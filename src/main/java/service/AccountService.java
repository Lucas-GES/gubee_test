package service;


import annotations.Transaction;
import entity.Account;

public class AccountService implements ServiceAccount{

    Account acc = new Account();

    @Override
    @Transaction
    public String deposit(double deposit) {
        double balance = acc.getBalance() + deposit;
        acc.setBalance(balance);
        return "complete";
    }

    @Override
    @Transaction
    public String withdraw(double withdraw) {
        double balance = acc.getBalance();
        if(acc.getBalance() > 0 && acc.getBalance() <= withdraw){
            acc.setBalance(balance - withdraw);
            return "complete";
        }else{
            System.out.println("Error Insuficient Balance");
        }
        return "operation canceled";
    }
}
