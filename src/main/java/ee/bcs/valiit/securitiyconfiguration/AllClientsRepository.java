package ee.bcs.valiit.securitiyconfiguration;

import ee.bcs.valiit.EmployeeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AllClientsRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createClient(String clientName, String password) {
        String sql = "INSERT INTO all_clients (client_name, password)" +
                " VALUES (:clientname, :password)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("clientname", clientName);
        paramMap.put("password", password);
        jdbcTemplate.update(sql, paramMap);
    }

    public String login(String clientName) {
        String sql = "SELECT password FROM all_clients WHERE client_name =:clientname";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("clientname", clientName);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }

    public EmployeeName getName(Integer id) {
        String sql = "SELECT first_name, last_name FROM employee WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return jdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<>(EmployeeName.class));
    }

}
