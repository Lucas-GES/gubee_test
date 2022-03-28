package model.proxies;
import model.annotations.Transaction;
import model.service.AccountService;
import model.service.ServiceAccount;

import java.lang.reflect.Method;

public class Proxy implements ServiceAccount {

    private ServiceAccount accountService;
    private Class targetClass;

    public Proxy(){
        this.accountService = new AccountService();
        targetClass = AccountService.class;
    }

    public <T>boolean isAnnotationMethod(String methodName){
        Method[] methods = targetClass.getMethods();
        for(Method method : methods){
            if(method.getName().equals(methodName)){
                if(method.isAnnotationPresent(Transaction.class)){
                    return true;
                }
            }
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