package in.mindcraft.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.mindcraft.pojos.User;
import in.mindcraft.services.LoginService;

@RestController
public class LoginController {

    private final LoginService login;

    @Autowired
    public LoginController(LoginService login) {
        this.login = login;
    }


    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) {
        Map<String, String> response = (Map<String, String>) login.loginCheck(user);
        System.out.println(response);
        if ("success".equals(response.get("status"))) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}