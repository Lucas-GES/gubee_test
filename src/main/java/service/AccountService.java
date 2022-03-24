package service;


import annotations.Transaction;
import entity.Account;

public class AccountService implements ServiceAccount{

    Account acc = new Account();

    @Override
    @Transaction
    public void deposit(double deposit) {
        double balance = acc.getBalance() + deposit;
        acc.setBalance(balance);
    }

    @Override
    @Transaction
    public void withdraw(double withdraw) {
        double balance = acc.getBalance();
        if(acc.getBalance() > 0 && acc.getBalance() <= withdraw){
            acc.setBalance(balance - withdraw);
        }else{
            System.out.println("Error Insuficient Balance");
        }
    }
}
