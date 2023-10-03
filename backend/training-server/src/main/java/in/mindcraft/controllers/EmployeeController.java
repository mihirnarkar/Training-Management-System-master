package in.mindcraft.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.mindcraft.pojos.Employee;
import in.mindcraft.services.EmployeeService;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
    public List<Map<String, Object>> getEmployee() {
        List<Map<String, Object>> response = employeeService.getEmployee();
        // System.out.println(response);
        return response;
    }

    @RequestMapping(value = "/getEmployee/{employee_id}", method = RequestMethod.GET)
    public List<Map<String, Object>> getEmployee(@PathVariable int employee_id) {
        List<Map<String, Object>> response = employeeService.getEmployee(employee_id);
        // System.out.println(response);
        return response;
    }


    @RequestMapping(value = "/insertEmployee", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> insertEmployee(@RequestBody Employee employee) {
        Map<String, String> response = (Map<String, String>) employeeService.insertEmployee(employee);
        System.out.println(response);
        if ("success".equals(response.get("status"))) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @RequestMapping(value = "/updateEmployee/{employee_id}", method = RequestMethod.PUT)
    public ResponseEntity<Map<String, String>> updateEmployee(@PathVariable int employee_id, @RequestBody Employee employee) {
        Map<String, String> response = (Map<String, String>) employeeService.updateEmployee(employee_id,employee);
        System.out.println(response);
        if ("success".equals(response.get("status"))) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @RequestMapping(value = "/deleteEmployee/{employee_id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, String>> deleteEmployee(@PathVariable int employee_id) {
        Map<String, String> response = (Map<String, String>) employeeService.deleteEmployee(employee_id);
        System.out.println(response);
        if ("success".equals(response.get("status"))) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
