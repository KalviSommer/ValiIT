package ee.bcs.valiit.controller;


import ee.bcs.valiit.Employee;
import ee.bcs.valiit.EmployeeName;
import ee.bcs.valiit.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    private List<Employee> employeeList = new ArrayList<>();

    @Autowired
    private EmployeeService employeeService;

    // http://localhost:8090/api/employee/
    @PostMapping("/api/employee")
    public void saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee.getFirstName(), employee.getLastName(), employee.getPosition(), employee.getAddress());
    }

    // http://localhost:8090/api/employeelist/
    @GetMapping("/api/employeelist")
    public List<Employee> getEmployeeList(@RequestParam("search") String search, String orderBy) {
        return employeeService.getEmployeeList(search, orderBy);
    }

    //Get id
    // http://localhost:8090/api/getEmployee/1
    @GetMapping("/api/getEmployee/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        return employeeService.getEmployee(id);
    }

    //Put id
    // http://localhost:8090/api/changeEmployee/1
    @PutMapping("/api/changeEmployee/{id}")
    public void changeEmployee(@PathVariable("id") int n, @RequestBody Employee employee) {
        employeeService.changeEmployee((n), employee.getFirstName(), employee.getLastName(), employee.getAddress(), employee.getPosition());
    }

    // http://localhost:8090/api/deleteemployee/
    @DeleteMapping("/api/deleteemployee/{id}")
    public void deleteEmployee(@PathVariable("id") int n) {
        employeeService.deleteEmployee(n);
    }

    // http://localhost:8090/api/employee/getName/
    @GetMapping("/api/employee/getName/{id}")
    public EmployeeName getName(@PathVariable("id") Integer id) {
        return employeeService.getName(id);
    }
}
