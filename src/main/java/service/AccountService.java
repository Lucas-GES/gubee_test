package service;


import annotations.Transaction;
import annotations.TransactionService;
import entity.Account;

@TransactionService
public class AccountService implements AccountInterface{

    Account acc = new Account();

    @Override
    @Transaction
    public boolean deposit(double deposit) {
        double balance = acc.getBalance() + deposit;
        acc.setBalance(balance);
        return true;
    }

    @Override
    @Transaction
    public boolean withdraw(double withdraw) {
        double balance = acc.getBalance();
        if(acc.getBalance() > 0 && acc.getBalance() <= withdraw){
            acc.setBalance(balance - withdraw);
            return true;
        }else{
            System.out.println("Error Insuficient Balance");
        }
        return false;
    }
}
