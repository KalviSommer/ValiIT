//package ee.bcs.valiit.controller;
//
//import ee.bcs.valiit.BankAccount;
//import ee.bcs.valiit.TransactionsHistory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.web.bind.annotation.*;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//
//
//@RestController
//public class OldLesson4Controller {
//    private Map<String, BankAccount> accountBalanceMap = new HashMap<>();
//
//    @Autowired
//    private NamedParameterJdbcTemplate jdbcTemplate;
//
//    // TODO 1
//    // Add command: "createAccount ${accountNr}"
//    // this has to store accountNr with 0 balance
//
//    // http://localhost:8080/lesson4/account/EE123/Kalvi
//    @PostMapping("lesson4/account/{accountNr}/{ownerName}")
//    public String createAccount(@PathVariable("accountNr") String accountNr,
//                                @PathVariable("ownerName") String ownerName) {
////        BankAccount account = new BankAccount();
////        account.setAccountNr(accountNr);
////        account.setBalance(0);
////        account.setOwnerName(ownerName);
////        accountBalanceMap.put(accountNr, account);
//
//        String sql = "INSERT INTO bank_account (account_nr, owner_name, balance, status) " +
//                "VALUES (:accountnr, :ownername, :balance, :status)";
//
//        Map<String, Object> bankAccountMap = new HashMap<>();
//        bankAccountMap.put("accountnr", accountNr);
//        bankAccountMap.put("ownername", ownerName);
//        bankAccountMap.put("balance", 0);
//        bankAccountMap.put("status", false);
//        jdbcTemplate.update(sql, bankAccountMap);
//        return "Your account is created, details are: " + accountNr + ", " + ownerName;
//    }
//
//    // TODO 2
//    // Add command: "getBalance ${accountNr}"
//    // this has to display account balance of specific account
//
//    // http://localhost:8080/lesson4/account/EE123
//    @GetMapping("lesson4/account/{accountNr}")
//    public String getBalance(@PathVariable String accountNr) {
//
////        return accountBalanceMap.get(accountNr);}
//        String sql = "SELECT balance FROM bank_account WHERE account_nr = :accountnr";
//        Map<String, Object> bankAccountMap = new HashMap<>();
//        bankAccountMap.put("accountnr", accountNr);
//        int balance = jdbcTemplate.queryForObject(sql, bankAccountMap, Integer.class);
//        return "Account " + accountNr + " balance is: " + balance + "!";
//    }
//
//    // TODO 3
//    // Add command: "depositMoney ${accountNr} ${amount}
//    // this has to add specified amount of money to account
//    // You have to check that amount is positive number
//
//    // http://localhost:8080/lesson4/account/EE123/100
//    @PutMapping("lesson4/account/{accountNr}/{balance}")
//    public String depositMoney(@PathVariable("accountNr") String accountNr, @PathVariable("balance") int amount) {
//
//        String sql = "SELECT * FROM bank_account WHERE account_nr = :accountnr";
//        Map<String, Object> bankAccountMap = new HashMap<>();
//        bankAccountMap.put("accountnr", accountNr);
//        BankAccount bankAccount = jdbcTemplate.queryForObject(sql, bankAccountMap, new BeanPropertyRowMapper<>(BankAccount.class));
//        int balance = bankAccount.getBalance();
//
//        if (amount >= 0) {
////            BankAccount account = accountBalanceMap.get(accountNr);
////            boolean status = account.isStatus();
//            if (!bankAccount.isStatus()) {
////            int balance = account.getBalance();
//                balance = amount + balance;
////            account.setBalance(balance);
////            accountBalanceMap.put(accountNr, account);
//
////        }
//                String sql2 = "UPDATE bank_account SET balance = :balance WHERE account_nr = :accountnr";
//                Map<String, Object> bankAccountMap2 = new HashMap<>();
//                bankAccountMap2.put("accountnr", accountNr);
//                bankAccountMap2.put("balance", balance);
//                jdbcTemplate.update(sql2, bankAccountMap2);
//                return "Deposit was successful, and account balance is " + balance + "!";
//            }
//        }
//        return "Deposit was unsuccessful, and account balance is " + balance + "!";
//    }
//
//
//    // TODO 4
//    // Add command: "withdrawMoney ${accountNr} ${amount}
//    // This has to remove specified amount of money from account
//    // You have to check that amount is positive number
//    // You may not allow this transaction if account balance would become negative
//
//    // http://localhost:8080/lesson4/account/withdraw/EE123/100
//    @PutMapping("lesson4/account/withdraw/{accountNr}/{balance}")
//    public String withdrawMoney(@PathVariable("accountNr") String accountNr, @PathVariable("balance") int amount) {
//
//
//        String sql = "SELECT * FROM bank_account WHERE account_nr = :accountnr";
//        Map<String, Object> bankAccountMap = new HashMap<>();
//        bankAccountMap.put("accountnr", accountNr);
//        BankAccount bankAccount = jdbcTemplate.queryForObject(sql, bankAccountMap, new BeanPropertyRowMapper<>(BankAccount.class));
//        int balance = bankAccount.getBalance();
//
////        BankAccount account = accountBalanceMap.get(accountNr);
////        boolean status = account.isStatus();
//        if (!bankAccount.isStatus()) {
////            int balance = account.getBalance();
//            int newBalance = balance - amount;
//            if (newBalance >= 0 && amount > 0) {
////                account.setBalance(newBalance);
////                accountBalanceMap.put(accountNr, account);
//
//                String sql2 = "UPDATE bank_account SET balance = :balance WHERE account_nr = :accountnr";
//                Map<String, Object> bankAccountMap2 = new HashMap<>();
//                bankAccountMap2.put("accountnr", accountNr);
//                bankAccountMap2.put("balance", newBalance);
//                jdbcTemplate.update(sql2, bankAccountMap2);
//
//            }
//            return "Withdrawal was successful, and account balance is" + newBalance + "!";
//
//        }
//        return "Withdrawal was unsuccessful, and account balance is" + balance + "!";
//    }
//
//    // TODO 5
//    // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
//    // This has to remove specified amount from fromAccount and add it to toAccount
//    // Your application needs to check that amount is positive
//    // And from account has enough money to do that transaction
//
//    // http://localhost:8080/lesson4/account/transfer/EE123/100/EE1234
//    @PutMapping("lesson4/account/transfer/{fromAccountNr}/{balance}/{toAccountNr}")
//    public String transferMoney(@PathVariable("fromAccountNr") String fromAccountNr, @PathVariable("balance") int amount,
//                                @PathVariable("toAccountNr") String toAccountNr) {
//
////        String sql = "SELECT balance FROM bank_account WHERE account_nr = :fromaccountnr";
////        Map<String, Object> bankAccountMap = new HashMap<>();
////        bankAccountMap.put("fromaccountnr", fromAccountNr);
////        int senderBalance = jdbcTemplate.queryForObject(sql, bankAccountMap, Integer.class);
//
//        String sql = "SELECT * FROM bank_account WHERE account_nr = :fromaccountnr";
//        Map<String, Object> bankAccountMap = new HashMap<>();
//        bankAccountMap.put("fromaccountnr", fromAccountNr);
//        BankAccount senderBankAccount = jdbcTemplate.queryForObject(sql, bankAccountMap, new BeanPropertyRowMapper<>(BankAccount.class));
//        int senderBalance = senderBankAccount.getBalance();
//
////        String sql2 = "SELECT balance FROM bank_account WHERE account_nr = :toaccountnr";
////        Map<String, Object> bankAccountMap2 = new HashMap<>();
////        bankAccountMap2.put("toaccountnr", toAccountNr);
////        int receiverBalance = jdbcTemplate.queryForObject(sql2, bankAccountMap2, Integer.class);
//
//        String sql2 = "SELECT * FROM bank_account WHERE account_nr = :toaccountnr";
//        Map<String, Object> bankAccountMap2 = new HashMap<>();
//        bankAccountMap2.put("toaccountnr", toAccountNr);
//        BankAccount receiverBankAccount = jdbcTemplate.queryForObject(sql2, bankAccountMap2, new BeanPropertyRowMapper<>(BankAccount.class));
//        int receiverBalance = receiverBankAccount.getBalance();
//
////        BankAccount fromAccount = accountBalanceMap.get(fromAccountNr);
////        BankAccount toAccount = accountBalanceMap.get(toAccountNr);
////        boolean fromAccStatus = fromAccount.isStatus();
////        boolean toAccStatus = toAccount.isStatus();
//        if (fromAccountNr.equals(toAccountNr)) {
//            return "Transfer was unsuccessful! Account balance is: " + senderBalance + "€";
//        }
//        if (((!senderBankAccount.isStatus())) && (!receiverBankAccount.isStatus())) {
////            int senderBalance = fromAccount.getBalance();
////            int receiverBalance = toAccount.getBalance();
//            if (senderBalance >= amount && amount > 0) {
//                int newSenderBalance = senderBalance - amount;
//                int newReceiverBalance = receiverBalance + amount;
//
////                fromAccount.setBalance(newSenderBalance);
////                toAccount.setBalance(newReceiverBalance);
////                accountBalanceMap.put(fromAccountNr, fromAccount);
////                accountBalanceMap.put(toAccountNr, toAccount);
//
//                String sql3 = "UPDATE bank_account SET balance = :balance WHERE account_nr = :fromaccountnr";
//                Map<String, Object> bankAccountMap3 = new HashMap<>();
//                bankAccountMap3.put("fromaccountnr", fromAccountNr);
//                bankAccountMap3.put("balance", newSenderBalance);
//                jdbcTemplate.update(sql3, bankAccountMap3);
//
//                String sql4 = "UPDATE bank_account SET balance = :balance WHERE account_nr = :toaccountnr";
//                Map<String, Object> bankAccountMap4 = new HashMap<>();
//                bankAccountMap4.put("toaccountnr", toAccountNr);
//                bankAccountMap4.put("balance", newReceiverBalance);
//                jdbcTemplate.update(sql4, bankAccountMap4);
//                return "Transfer was successful, you sent " + amount + "€! Account balance is: " + newSenderBalance + "€";
//            }
//        }
//        return "Transfer was unsuccessful! Account balance is: " + senderBalance + "€";
//    }
//
//    // http://localhost:8080/lesson4/lockAccount/EE123/
//    @PutMapping("lesson4/lockAccount/{accountNr}")
//    public String lockAccount(@PathVariable("accountNr") String accountNr) {
//
//        String sql = "SELECT status FROM bank_account WHERE account_nr = :accountnr";
//        Map<String, Object> bankAccountMap = new HashMap<>();
//        bankAccountMap.put("accountnr", accountNr);
//        jdbcTemplate.queryForObject(sql, bankAccountMap, Boolean.class);
//
//
//        String sql2 = "UPDATE bank_account SET status = :status WHERE account_nr = :accountnr";
//        Map<String, Object> bankAccountMap2 = new HashMap<>();
//        bankAccountMap2.put("accountnr", accountNr);
//        bankAccountMap2.put("status", true);
//        jdbcTemplate.update(sql2, bankAccountMap2);
//
//
////        BankAccount account = accountBalanceMap.get(accountNr);
////        account.setStatus(true);
////        accountBalanceMap.put(accountNr, account);
//
//        return "Account: " + accountNr + " is locked!";
//    }
//
//    // http://localhost:8080/lesson4/unlockAccount/EE123/
//    @PutMapping("lesson4/unlockAccount/{accountNr}")
//    public String unlockAccount(@PathVariable("accountNr") String accountNr) {
//
//        String sql = "SELECT status FROM bank_account WHERE account_nr = :accountnr";
//        Map<String, Object> bankAccountMap = new HashMap<>();
//        bankAccountMap.put("accountnr", accountNr);
//        jdbcTemplate.queryForObject(sql, bankAccountMap, Boolean.class);
//
//
//        String sql2 = "UPDATE bank_account SET status = :status WHERE account_nr = :accountnr";
//        Map<String, Object> bankAccountMap2 = new HashMap<>();
//        bankAccountMap2.put("accountnr", accountNr);
//        bankAccountMap2.put("status", false);
//        jdbcTemplate.update(sql2, bankAccountMap2);
//
////        BankAccount account = accountBalanceMap.get(accountNr);
////        account.setStatus(false);
////        accountBalanceMap.put(accountNr, account);
//
//        return "Account: " + accountNr + " is unlocked!";
//    }
//
//    //    http://localhost:8080/lesson4/account
//    @GetMapping("lesson4/account")
//    public List<BankAccount> getAllAccounts() {
//        String sql = "SELECT * FROM bank_account";
//        Map<String, Object> bankAccountMap = new HashMap<>();
//        List<BankAccount> result = jdbcTemplate.query(sql, bankAccountMap, new BeanPropertyRowMapper<>(BankAccount.class));
//        return result;
//    }
//
//    //    http://localhost:8080/lesson4/account2
//    @GetMapping("lesson4/account2")
//    public List<BankAccount> getAllAccounts2() {
//        String sql = "SELECT * FROM bank_account";
//        Map<String, Object> bankAccountMap = new HashMap<>();
//        List<BankAccount> result = jdbcTemplate.query(sql, bankAccountMap, new BankAccountRowMapper());
//        return result;
//    }
//
//    private class BankAccountRowMapper implements RowMapper<BankAccount> {
//        @Override
//        public BankAccount mapRow(ResultSet resultSet, int i) throws SQLException {
//            BankAccount result = new BankAccount();
//            result.setAccountNr(resultSet.getString("account_nr"));
//            result.setOwnerName(resultSet.getString("owner_name"));
//            result.setBalance(resultSet.getInt("balance"));
//            result.setStatus(resultSet.getBoolean("status"));
//            return result;
//        }
//    }
//
//    //    http://localhost:8080/lesson4/accountInfo/EE123
//    @GetMapping("lesson4/accountInfo/{accountNr}")
//    public BankAccount getAccountInfo(@PathVariable("accountNr") String accountNr) {
//        String sql = "SELECT * FROM bank_account WHERE account_nr = :accountnr";
//        Map<String, Object> bankAccountMap = new HashMap<>();
//        bankAccountMap.put("accountnr", accountNr);
//        BankAccount bankAccount = jdbcTemplate.queryForObject(sql, bankAccountMap, new BeanPropertyRowMapper<>(BankAccount.class));
//        if (bankAccount.isStatus()) {
//            System.out.println("konto on lukus");
//            return null;
//        }
//        System.out.println("konto jääk on: " + bankAccount.getBalance());
//        return bankAccount;
//    }
//
//    //    http://localhost:8080/lesson6/transactionsHistory/EE123
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
//
//
//
//}
