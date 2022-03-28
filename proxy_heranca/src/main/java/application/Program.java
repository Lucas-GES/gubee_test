package application;;
import model.entities.Account;
import model.proxies.AccountFactory;
import model.proxies.Proxy;
import model.service.ServiceAccount;


public class Program {

    public static void main(String args[]){

        ServiceAccount sc;

        Account acc = new Account("Poupança", "João", 500.0);

        sc = new Proxy();

        sc.deposit(100.0);
        sc.withdraw(100.0);
        System.out.println();
        sc =  new AccountFactory().createProxy();
        sc.deposit(100.0);
        sc.withdraw(100.0);
    }


}
