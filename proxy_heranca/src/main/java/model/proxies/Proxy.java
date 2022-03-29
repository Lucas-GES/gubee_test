package model.proxies;
import model.annotations.Transaction;
import model.service.AccountService;
import model.service.ServiceAccount;

import java.lang.reflect.Method;

public class Proxy implements ServiceAccount {

    private ServiceAccount accountService;
    private Class targetClass;

    public Proxy(ServiceAccount serviceAccount){
        this.accountService = serviceAccount;
        targetClass = AccountService.class;
    }

    public <T>boolean isAnnotationMethod(String methodName){
        try {
            Method method = targetClass.getDeclaredMethod(methodName, double.class);
            if(method.getName().equals(methodName) && method.isAnnotationPresent(Transaction.class)){
                return true;
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void deposit(double deposit) {
        if (isAnnotationMethod("deposit")) {
            System.out.println("Iniciando execução do método deposit");
            accountService.deposit(deposit);
            System.out.println(String.format("Finalizando execução do método deposit com sucesso"));
        }
    }

    @Override
    public void withdraw(double withdraw) {
        if (isAnnotationMethod("withdraw")) {
            System.out.println(String.format("Iniciando execução do método withdraw"));
            accountService.withdraw(withdraw);
            System.out.println(String.format("Finalizando execução do método withdraw com sucesso"));
        }
    }
}