package application;;
import entity.Account;
import proxies.Factory;
import service.AccountInterface;

public class Program {

    public static void main(String args[]){
        Factory factory = new Factory(Program.class.getPackage());
        Account acc = new Account("Poupança", "João", 500.0);

        AccountInterface accountInterface = factory.getBean(AccountInterface.class);
        System.out.println(accountInterface.deposit(100.0));

        System.out.println();
    }


}
