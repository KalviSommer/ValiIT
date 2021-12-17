package ee.bcs.valiit;

import ee.bcs.valiit.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class Lesson4Repository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Integer createClient(String firstName, String lastName, String address) {
        String sql = "INSERT INTO client (first_name, last_name, address) " +
                "VALUES (:firstname,:lastname,:address)";
        Map<String, Object> bankAccountMap = new HashMap<>();
        bankAccountMap.put("firstname", firstName);
        bankAccountMap.put("lastname", lastName);
        bankAccountMap.put("address", address);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, new MapSqlParameterSource(bankAccountMap), keyHolder);
        return (Integer) keyHolder.getKeys().get("id");
    }

    public void createAccount(String accountNr, int id) {
        String sql = "INSERT INTO bank_account (account_nr, client_id, balance, status) " +
                "VALUES (:accountnr, :clientid, :balance, :status)";
        Map<String, Object> bankAccountMap = new HashMap<>();
        bankAccountMap.put("accountnr", accountNr);
        bankAccountMap.put("clientid", id);
        bankAccountMap.put("balance", 0);
        bankAccountMap.put("status", false);
        jdbcTemplate.update(sql, bankAccountMap);
    }

    public BankAccount selectBalance(String accountNr) {
        String sql = "SELECT * FROM bank_account WHERE account_nr = :accountnr";
        Map<String, Object> bankAccountMap = new HashMap<>();
        bankAccountMap.put("accountnr", accountNr);
        return jdbcTemplate.queryForObject(sql, bankAccountMap, new BeanPropertyRowMapper<>(BankAccount.class));
    }

    public int balanceUpdate(String accountNr, int balance) {
        String sql2 = "UPDATE bank_account SET balance = :balance WHERE account_nr = :accountnr";
        Map<String, Object> bankAccountMap2 = new HashMap<>();
        bankAccountMap2.put("accountnr", accountNr);
        bankAccountMap2.put("balance", balance);
        return jdbcTemplate.update(sql2, bankAccountMap2);
    }

    public String selectStatus(String accountNr) {
        String sql = "SELECT status FROM bank_account WHERE account_nr = :accountnr";
        Map<String, Object> bankAccountMap = new HashMap<>();
        bankAccountMap.put("accountnr", accountNr);
        return jdbcTemplate.queryForObject(sql, bankAccountMap, String.class);
    }

    public int lockAccount(String accountNr) {
        String sql2 = "UPDATE bank_account SET status = :status WHERE account_nr = :accountnr";
        Map<String, Object> bankAccountMap2 = new HashMap<>();
        bankAccountMap2.put("accountnr", accountNr);
        bankAccountMap2.put("status", true);
        return jdbcTemplate.update(sql2, bankAccountMap2);
    }

    public int unLockAccount(String accountNr) {
        String sql2 = "UPDATE bank_account SET status = :status WHERE account_nr = :accountnr";
        Map<String, Object> bankAccountMap2 = new HashMap<>();
        bankAccountMap2.put("accountnr", accountNr);
        bankAccountMap2.put("status", false);
        return jdbcTemplate.update(sql2, bankAccountMap2);
    }

    public List<BankAccount> getAllAccounts3() {
            String sql = "SELECT * FROM bank_account";
            Map<String, Object> bankAccountMap = new HashMap<>();
            return jdbcTemplate.query(sql, bankAccountMap, new BeanPropertyRowMapper<>(BankAccount.class));
    }

    public List<Client> getAllClients() {
            String sql = "SELECT * FROM  client";
            Map<String, Object> bankAccountMap = new HashMap<>();
            return jdbcTemplate.query(sql, bankAccountMap, new BeanPropertyRowMapper<>(Client.class));
    }

    public List<BankAccountClient> getAllAccounts() {
            String sql = "SELECT * FROM bank_account b JOIN client c ON b.client_id=c.id";
            Map<String, Object> bankAccountMap = new HashMap<>();
            return jdbcTemplate.query(sql, bankAccountMap, new BeanPropertyRowMapper<>(BankAccountClient.class));
    }

    public List<BankAccount> getAllAccounts2() {
        String sql = "SELECT * FROM bank_account";
        Map<String, Object> bankAccountMap = new HashMap<>();
        return jdbcTemplate.query(sql, bankAccountMap, new BankAccountRowMapper());
    }

    public BankAccount getAccountInfo1(String accountNr) {
        String sql = "SELECT * FROM bank_account WHERE account_nr = :accountnr";
        Map<String, Object> bankAccountMap = new HashMap<>();
        bankAccountMap.put("accountnr", accountNr);
        return jdbcTemplate.queryForObject(sql, bankAccountMap, new BeanPropertyRowMapper<>(BankAccount.class));
    }

    public BankAccountClient getAccountInfo(String accountNr) {
        String sql = "SELECT * FROM bank_account b JOIN client c ON b.client_id=c.id WHERE account_nr = :accountnr";
        Map<String, Object> bankAccountMap = new HashMap<>();
        bankAccountMap.put("accountnr", accountNr);
        return jdbcTemplate.queryForObject(sql, bankAccountMap, new BeanPropertyRowMapper<>(BankAccountClient.class));
    }

    private class BankAccountRowMapper implements RowMapper<BankAccount> {
        @Override
        public BankAccount mapRow(ResultSet resultSet, int i) throws SQLException {
            BankAccount result = new BankAccount();
            result.setAccountNr(resultSet.getString("account_nr"));
            result.setBalance(resultSet.getInt("balance"));
            result.setStatus(resultSet.getBoolean("status"));
            return result;
        }
    }

    private class ClientRowMapper implements RowMapper<Client> {
        @Override
        public Client mapRow(ResultSet resultSet, int i) throws SQLException {
            Client result = new Client();
            result.setFirstName(resultSet.getString("first_name"));
            result.setLastName(resultSet.getString("last_name"));
            result.setAddress(resultSet.getString("address"));
            return result;
        }
    }
}
