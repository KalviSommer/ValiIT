package ee.bcs.valiit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void saveEmployee(String firstName, String lastName, String position, String address) {
        String sql = "INSERT INTO employee (first_name, last_name, position, address)" +
                " VALUES (:firstname, :lastname, :position, :address)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("firstname", firstName);
        paramMap.put("lastname", lastName);
        paramMap.put("position", position);
        paramMap.put("address", address);
        jdbcTemplate.update(sql, paramMap);
    }

    public List<Employee> getEmployeeList(String search, String orderBy) {
        String sql = "SELECT * FROM employee";
        Map<String, Object> paramMap = new HashMap<>();
        if (search != null && !search.isBlank()) {
            sql += " WHERE first_name ILIKE :search";
            paramMap.put("search", "%" + search + "%");
        }
        if (orderBy != null && !orderBy.isBlank()) {
            sql += " ORDER BY " + orderBy;
        }
        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(Employee.class));
    }

    public Employee getEmployee(int id) {
        String sql = "SELECT * FROM employee WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<>(Employee.class));
    }

    public void changeEmployee(int n, String firstName, String lastName, String address, String position) {
        String sql = "UPDATE employee SET first_name = :newFirstName, last_name = :newLastName," +
                "address = :newAddress, position = :newPosition WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", n);
        paramMap.put("newFirstName", firstName);
        paramMap.put("newLastName", lastName);
        paramMap.put("newAddress", address);
        paramMap.put("newPosition", position);
        jdbcTemplate.update(sql, paramMap);
    }

    public void deleteEmployee(int n) {
        String sql = "DELETE FROM employee WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", n);
        jdbcTemplate.update(sql, paramMap);
    }

    public EmployeeName getName(Integer id) {
        String sql = "SELECT first_name, last_name FROM employee WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<>(EmployeeName.class));
    }
}
