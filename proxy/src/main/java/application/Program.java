package application;;
import annotations.Transaction;
import entity.Account;
import proxies.DynamicProxy;
import proxies.Factory;
import service.AccountService;
import service.ServiceAccount;

import javax.xml.stream.FactoryConfigurationError;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Program {

    public static void main(String args[]){

        Account acc = new Account("Poupança", "João", 500.0);

//        AccountService as = new AccountService();
//
//        ClassLoader cl = AccountService.class.getClassLoader();
//
//        DynamicProxy dynamicProxy = new DynamicProxy(as);
//
//        ServiceAccount proxiedService = (ServiceAccount) Proxy
//                .newProxyInstance(cl, new Class[] {ServiceAccount.class},
//                        dynamicProxy);
//
//        proxiedService.deposit(100.0);

        Factory factory = new Factory(ServiceAccount.class);
        ServiceAccount proxiedService = (ServiceAccount) factory.newInstance(new DynamicProxy(new AccountService()));

        proxiedService.deposit(100.0);
    }


}
