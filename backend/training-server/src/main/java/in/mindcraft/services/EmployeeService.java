package in.mindcraft.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import in.mindcraft.pojos.Employee;

@Service
public class EmployeeService {
    private final JdbcTemplate jdbcTemplate;

    // @Autowired
    public EmployeeService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> getEmployee() {
        String sql = "select * from employees";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        Map<String, String> response = new HashMap<>();

        if (result.isEmpty()) {
            response.put("status", "error");
            response.put("message", "No Employees Found!");
        } else {
            response.put("status", "success");
            response.put("message","All Employees Displayed!");
        }
        return result;
    }

    public List<Map<String, Object>> getEmployee(int employee_id) {
        String sql = "select * from employees where employee_id=?";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, employee_id);
        Map<String, String> response = new HashMap<>();

        if (result.isEmpty()) {
            response.put("status", "error");
            response.put("message","No Employee Found!");
        } else {
            response.put("status", "success");
            response.put("message","Employee Found!");
        }
        return result;
    }

    public Map<String, String> insertEmployee(Employee employee) {
        String sql = "Insert into employees values(?,?,?,?,?,?,?,?)";
        int result = jdbcTemplate.update(sql,
                employee.getEmployee_id(),
                employee.getEmployee_firstname(),
                employee.getEmployee_lastname(),
                employee.getEmployee_email(),
                employee.getEmployee_department(),
                employee.getEmployee_designation(),
                employee.getEmployee_dob(),
                employee.getEmployee_doj());
        System.out.println(result);
        Map<String, String> response = new HashMap<>();

        if (result > 0) {
            response.put("status", "success");
            response.put("message", "Employee Inserted Successfully.");
        } else {
            response.put("status", "error");
            response.put("message", "Error while Inserting Employees.");
        }
        return response;
    }

    public Map<String, String> updateEmployee(int employeeid, Employee employee) {
        String checkEmployee = "select * from employees where employee_id=?";
        List<Map<String, Object>> resultant = jdbcTemplate.queryForList(checkEmployee, employeeid);
        if (!resultant.isEmpty()) {
            String sql = "Update employees set employee_firstname=?, employee_lastname=?, employee_email=?, employee_department=?, employee_designation=?, employee_dob=?, employee_doj=? where employee_id=?;";
            int result = jdbcTemplate.update(sql,
                    employee.getEmployee_firstname(),
                    employee.getEmployee_lastname(),
                    employee.getEmployee_email(),
                    employee.getEmployee_department(),
                    employee.getEmployee_designation(),
                    employee.getEmployee_dob(),
                    employee.getEmployee_doj(),
                    employeeid);
            System.out.println(result);
            Map<String, String> response = new HashMap<>();

            if (result > 0) {
                response.put("status", "success");
                response.put("message", "Employee Updated Successfully.");
            } else {
                response.put("status", "error");
                response.put("message", "Error while Updating Employees.");
            }
            return response;
        } else {
            Map<String, String> resultant_response = new HashMap<>();
            resultant_response.put("status", "error");
            resultant_response.put("message", "Employee Not Present In the Database");
            return resultant_response;
        }

    }

    public Map<String, String> deleteEmployee(int employeeid) {
        String sql = "Delete from employees where employee_id = ?";
        int rows_Deleted = jdbcTemplate.update(sql, employeeid);
        Map<String, String> response = new HashMap<>();
        if (rows_Deleted > 0) {
            response.put("status", "success");
            response.put("message", "Employee Deleted Successfully.");
        } else {
            response.put("status", "error");
            response.put("message", "Error while Deleting Employees.");
        }
        return response;

    }

}
