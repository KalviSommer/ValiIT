package ee.bcs.valiit.securitiyconfiguration;

import ee.bcs.valiit.Employee;
import ee.bcs.valiit.EmployeeName;
import ee.bcs.valiit.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AllClientsController {
    private List<AllClientsDto> allClientsList = new ArrayList<>();

    @Autowired
    private AllClientsService allClientsService;

    // http://localhost:8090/api/public/createclient/
    @PostMapping("api/public/createclient")
    public void createClient(@RequestBody AllClientsDto newClient) {
        allClientsService.createClient(newClient.getClientName(), newClient.getPassword());
    }

    // http://localhost:8090/api/public/login/
    @PostMapping("api/public/login")
    public String login(@RequestBody LoginRequest login) {
      return allClientsService.login(login.getClientName(), login.getPassword());
    }

    // http://localhost:8090/employee/getName/
    @GetMapping("/employee/getName/{id}")
    public EmployeeName getName(@PathVariable("id") Integer id) {
        return allClientsService.getName(id);
    }

}
