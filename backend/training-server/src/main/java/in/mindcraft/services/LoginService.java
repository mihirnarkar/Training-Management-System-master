package in.mindcraft.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import in.mindcraft.pojos.User;

@Service
public class LoginService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LoginService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, String> loginCheck(User user) {
        String sql = "SELECT * FROM users WHERE username = ?";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, user.getUsername());
        // System.out.println(result.get(0).get("username"));
        if (!result.isEmpty()) {
            // User with the given username exists in the database
            // Now, hash the provided password with SHA-256
            String providedPassword = user.getPassword();
            String providedPasswordHash = hashWithSHA256(providedPassword);
            // Retrieve the stored password hash from the database
            String storedPasswordHash = (String) result.get(0).get("password");

            // Compare the hashed password provided by the user with the stored hash
            if (providedPasswordHash.equals(storedPasswordHash)) {
                Map<String, String> response = new HashMap<>();
                response.put("status", "success");
                response.put("message", "Login successful");
                return response;
            }
        }

        Map<String, String> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", "Login failed. Invalid username or password.");
        return response;
    }

    private String hashWithSHA256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(input.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 hashing algorithm not available.", e);
        }
    }

}
