package application;;
import model.entities.Account;
import model.proxies.AccountFactory;
import model.proxies.BaseFactory;
import model.proxies.Factory;
import model.proxies.Proxy;
import model.service.AccountService;
import model.service.ServiceAccount;


public class Program {

    public static void main(String args[]){

        ServiceAccount sc;

        Account acc = new Account("Poupança", "João", 500.0);

//        sc = new Proxy();
//
//        sc.deposit(100.0);
//        sc.withdraw(100.0);
//
//        System.out.println();

        Factory factory;
        BaseFactory baseFactory;

        baseFactory = new AccountFactory();
        sc = (ServiceAccount) new Factory(baseFactory).instantiate();
        sc.deposit(100.0);


    }


}
