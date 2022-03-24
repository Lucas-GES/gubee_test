package proxies;

import annotations.Transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

public class DynamicProxy implements InvocationHandler {

    private Object target;
    private Class<?> targetClass;

    public DynamicProxy(Object targetObj){
        this.target = targetObj;
        this.targetClass = targetObj.getClass();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method targetMethod = getOverridenMethod(method);

        return getTransactionMethod(targetMethod)
                .map(annotation -> handler(method, args, annotation))
                .orElseGet(() -> invokeNotChecked(method, args));


    }

    private Object handler(Method method, Object[] args, Transaction annotation){
        Object result;

        System.out.println(String.format("Iniciando execução do método %s" , method.getName()));
        try{
            result = invokeNotChecked(method, args);
        } catch (RuntimeException e) {
            System.out.println(String.format("Finalizando execução do método %s com erro %s" , method.getName(), e));
            throw e;
        }
        System.out.println(String.format("Finalizando execução do método %s com sucesso" , method.getName()));
        return result;
    }

    private Object invokeNotChecked(Method method, Object[] args) throws RuntimeException {
        try{
            return method.invoke(target, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(String.format("Finalizando execução do método %s com erro %s" , method.getName(), e));
        }
    }

    private Optional<Transaction> getTransactionMethod(Method method){
        return Optional.ofNullable(method.getDeclaredAnnotation(Transaction.class));
    }

    private Method getOverridenMethod(Method method) throws NoSuchMethodException {
        return targetClass
                .getDeclaredMethod(method.getName(),
                        method.getParameterTypes());
    }



}
