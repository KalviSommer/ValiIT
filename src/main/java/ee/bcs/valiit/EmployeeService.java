package ee.bcs.valiit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Transactional
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveEmployee(String firstName, String lastName, String position, String address) {
        employeeRepository.saveEmployee(firstName, lastName, position, address);
    }

    public List<Employee> getEmployeeList(String search, String orderBy) {
        return employeeRepository.getEmployeeList(search, orderBy);

    }

    public Employee getEmployee(int id) {
        return employeeRepository.getEmployee(id);
    }

    public void changeEmployee(int n, String firstName, String lastName, String address, String position) {
        employeeRepository.changeEmployee(n, firstName, lastName, address, position);
    }

    public void deleteEmployee(int n) {
        String sql = "DELETE FROM employee WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", n);
        employeeRepository.deleteEmployee(n);
    }

    public EmployeeName getName(Integer id) {
        return employeeRepository.getName(id);
    }
}
