package proxies;

import annotations.Transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object targetObj){
        this.target = targetObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        Method method1 = target.getClass().getMethod(method.getName(), method.getParameterTypes());

        if(method1.isAnnotationPresent(Transaction.class)) {
            System.out.println(String.format("Iniciando execução do método %s", method.getName()));
            try {
                result = method.invoke(target, args);
            } catch (RuntimeException e) {
                System.out.println(String.format("Finalizando execução do método %s com erro %s", method.getName(), e));
                throw e;
            }
            System.out.println(String.format("Finalizando execução do método %s com sucesso", method.getName()));
            return result;
        }
        return method.invoke(target, args);

    }
}
