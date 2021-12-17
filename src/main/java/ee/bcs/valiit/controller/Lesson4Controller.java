package ee.bcs.valiit.controller;

import ee.bcs.valiit.BankAccount;

import ee.bcs.valiit.BankAccountClient;
import ee.bcs.valiit.Client;
import ee.bcs.valiit.Lesson4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Lesson4Controller {
    private Map<String, BankAccount> accountBalanceMap = new HashMap<>();

    @Autowired
    private Lesson4Service lesson4Service;

    // http://localhost:8090/api/lesson4/createClient/
    @PostMapping("/api/lesson4/createClient/")
    public String createClient(@RequestBody Client client) {
        return lesson4Service.createClient(client.getFirstName(), client.getLastName(), client.getAddress());
    }

    // http://localhost:8090/api/lesson4/account/EE123/1
    @PostMapping("/api/lesson4/account/{accountNr}/{id}")
    public String createAccount(@PathVariable("accountNr") String accountNr,
                                @PathVariable("id") int id) {
        return lesson4Service.createAccount(accountNr, id);
    }

    // http://localhost:8090/api/lesson4/account/EE123
    @GetMapping("/api/lesson4/account/{accountNr}")
    public String getBalance(@PathVariable("accountNr") String accountNr) {
         return lesson4Service.getBalance(accountNr);
    }

    // http://localhost:8090/api/lesson4/account/EE123/100
    @PutMapping("/api/lesson4/account/{accountNr}/{balance}")
    public String depositMoney(@PathVariable("accountNr") String accountNr, @PathVariable("balance") int amount) {
        return lesson4Service.depositMoney(accountNr, amount);
    }

    // http://localhost:8090/api/lesson4/account/withdraw/EE123/100
    @PutMapping("/api/lesson4/account/withdraw/{accountNr}/{balance}")
    public String withdrawMoney(@PathVariable("accountNr") String accountNr, @PathVariable("balance") int amount) {
        return lesson4Service.withdrawMoney(accountNr, amount);
    }

    // http://localhost:8090/api/lesson4/account/transfer/EE123/100/EE12345
    @PutMapping("/api/lesson4/account/transfer/{fromAccountNr}/{balance}/{toAccountNr}")
    public String transferMoney(@PathVariable("fromAccountNr") String fromAccountNr, @PathVariable("balance") int amount,
                                @PathVariable("toAccountNr") String toAccountNr) {
        return lesson4Service.transferMoney(fromAccountNr, amount, toAccountNr);
    }

    // http://localhost:8090/api/lesson4/lockAccount/EE123/
    @PutMapping("/api/lesson4/lockAccount/{accountNr}")
    public String lockAccount(@PathVariable("accountNr") String accountNr) {
        return lesson4Service.lockAccount(accountNr);
    }

    // http://localhost:8090/api/lesson4/unlockAccount/EE123/
    @PutMapping("/api/lesson4/unlockAccount/{accountNr}")
    public String unlockAccount(@PathVariable("accountNr") String accountNr) {
        return lesson4Service.unlockAccount(accountNr);
    }
    //    http://localhost:8090/api/lesson4/clients
    @GetMapping("/api/lesson4/clients")
    public List<Client> getAllClients() {
        return lesson4Service.getAllClients();
    }

    //    http://localhost:8090/api/lesson4/accounts
    @GetMapping("/api/lesson4/accounts")
    public List<BankAccountClient> getAllAccounts() {
        return lesson4Service.getAllAccounts();
    }

    //    http://localhost:8090/api/lesson4/account2
    @GetMapping("/api/lesson4/account2")
    public List<BankAccount> getAllAccounts2() {
        return lesson4Service.getAllAccounts2();
    }

    //    http://localhost:8090/api/lesson4/accountInfo/EE123
    @GetMapping("/api/lesson4/accountInfo/{accountNr}")
    public BankAccountClient getAccountInfo(@PathVariable("accountNr") String accountNr) {
        return lesson4Service.getAccountInfo(accountNr);
    }

    //    http://localhost:8080/lesson6/transactionsHistory/EE123
//    @PutMapping("lesson6/transactionsHistory/{accountNr}")
//    public Object getTransactionsHistory(@PathVariable("accountNr") String accountNr) {
//        String sql = "SELECT * FROM bank_account WHERE account_nr = :accountnr";
//        Map<String, Object> transactionsHistoryMap = new HashMap<>();
//        transactionsHistoryMap.put("accountnr", accountNr);
//        TransactionsHistory transactionsHistory = jdbcTemplate.queryForObject(sql, transactionsHistoryMap, new BeanPropertyRowMapper<>(TransactionsHistory.class));
//
//        String sql2 = "UPDATE transactions_history SET status = :status WHERE account_nr = :accountnr";
//        Map<String, Object> bankAccountMap2 = new HashMap<>();
//        bankAccountMap2.put("accountnr", accountNr);
//        bankAccountMap2.put("status", false);
//        jdbcTemplate.update(sql2, bankAccountMap2);
//
//        return transactionsHistory;
//    }



}
