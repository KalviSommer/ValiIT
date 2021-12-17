package ee.bcs.valiit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class Lesson4Service {

    @Autowired
    private Lesson4Repository lesson4Repository;

    public String createClient(String firstName, String lastName, String address) {
        int id = lesson4Repository.createClient(firstName, lastName, address);
        return "Client is created, name: " + firstName + " " + lastName + " address: " + address + " and id: " + id;
    }

    public String createAccount(String accountNr, int id) {
        lesson4Repository.createAccount(accountNr, id);
        return "Your account is created, details are: " + accountNr + ", " + id;
    }

    public String getBalance(String accountNr) {
        BankAccount bankAccount = lesson4Repository.selectBalance(accountNr);
        return "Account " + accountNr + " balance is: " + bankAccount.getBalance() + "!";
    }

    public String depositMoney(String accountNr, int amount) {
        BankAccount bankAccount = lesson4Repository.selectBalance(accountNr);
        int balance = bankAccount.getBalance();
        if (amount <= 0) {
            throw new ApplicationException("Deposit should be bigger than 0, and current account balance is " + balance + "!");
        }
        if (bankAccount.isStatus()) {
            throw new ApplicationException("Your account should be unlocked!");
        }
        balance = amount + balance;
        lesson4Repository.balanceUpdate(accountNr, balance);
        return "Deposit was successful, and account balance is " + balance + "!";
    }

    public String withdrawMoney(String accountNr, int amount) {
        BankAccount bankAccount = lesson4Repository.selectBalance(accountNr);
        int balance = bankAccount.getBalance();
        if (bankAccount.isStatus()) {
            throw new ApplicationException("Your account should be unlocked!");
        }
        if (amount <= 0) {
            throw new ApplicationException("Deposit should be bigger than 0, and current account balance is " + balance + "!");
        }
        balance = balance - amount;
        if (balance <= 0 && amount <= 0) {
            throw new ApplicationException("Your account balance and amount should be bigger than 0, and account current balance is" + balance + "!");
        }
        lesson4Repository.balanceUpdate(accountNr, balance);
        return "Withdrawal was successful, and account balance is" + balance + "!";
    }

    public String transferMoney(String fromAccountNr, int amount, String toAccountNr) {
        BankAccount senderBankAccount = lesson4Repository.selectBalance(fromAccountNr);
        int senderBalance = senderBankAccount.getBalance();
        BankAccount receiverBankAccount = lesson4Repository.selectBalance(toAccountNr);
        int receiverBalance = receiverBankAccount.getBalance();
        if (fromAccountNr.equals(toAccountNr)) {
            throw new ApplicationException("You can't transfer between same account!");
        }
        if ((senderBankAccount.isStatus()) || (receiverBankAccount.isStatus())) {
            throw new ApplicationException("Accounts should be unlocked!");
        }
        if (senderBalance < amount || amount <= 0) {
            throw new ApplicationException("Your balance should be bigger than transfering amount of money OR " +
                    "transfering amount of money should be bigger than 0");
        }
        int newSenderBalance = senderBalance - amount;
        int newReceiverBalance = receiverBalance + amount;
        lesson4Repository.balanceUpdate(fromAccountNr, newSenderBalance);
        lesson4Repository.balanceUpdate(toAccountNr, newReceiverBalance);
        return "Transfer was successful, you sent " + amount + "€! Account balance is: " + newSenderBalance + "€";
    }

    public String lockAccount(String accountNr) {
        lesson4Repository.selectStatus(accountNr);
        lesson4Repository.lockAccount(accountNr);
        return "Account: " + accountNr + " is locked!";
    }

    public String unlockAccount(String accountNr) {
        lesson4Repository.selectStatus(accountNr);
        lesson4Repository.unLockAccount(accountNr);
        return "Account: " + accountNr + " is unlocked!";
    }

    public List<Client> getAllClients() {
        List<Client> result = lesson4Repository.getAllClients();
        return result;
    }

    public List<BankAccountClient> getAllAccounts() {
        List<BankAccountClient> result = lesson4Repository.getAllAccounts();
        return result;
    }

    public List<BankAccount> getAllAccounts2() {
        List<BankAccount> result = lesson4Repository.getAllAccounts2();
        return result;
    }

    public BankAccountClient getAccountInfo(String accountNr) {
        BankAccountClient bankAccount = lesson4Repository.getAccountInfo(accountNr);
        if (bankAccount.isStatus()) {
            throw new ApplicationException("Account is locked!");
        }
        System.out.println("Account balance is: " + bankAccount.getBalance());
        return bankAccount;
    }
}
