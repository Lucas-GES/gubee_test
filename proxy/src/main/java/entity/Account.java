package entity;

public class Account {

    private String account_type;
    private String user;
    private double balance;

    public Account() {
    }

    public Account(String account_type, String user, double balance) {
        this.account_type = account_type;
        this.user = user;
        this.balance = balance;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
