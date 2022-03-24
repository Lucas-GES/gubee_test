package proxies;

import annotations.Transaction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

public class DynamicProxy implements InvocationHandler {

    private final Object target;
    private final Class<?> targetClass;

    public DynamicProxy(Object targetObj){
        this.target = targetObj;
        this.targetClass = targetObj.getClass();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method targetMethod = getOverride(method);

        return getTransaction(targetMethod)
                .map(annotation -> handlerMethod(method, args))
                .orElseGet(() -> notCheckedInvoke(method, args));

    }

    private Object handlerMethod(Method method, Object[] args){
        Object result;
        System.out.println(String.format("Iniciando execução do método %s" , method.getName()));
        try{
            result = notCheckedInvoke(method, args);
        } catch (RuntimeException e) {
            System.out.println(String.format("Finalizando execução do método %s com erro %s" , method.getName(), e));
            throw e;
        }
        System.out.println(String.format("Finalizando execução do método %s com sucesso" , method.getName()));
        return result;
    }

    private Optional<Transaction> getTransaction(Method method){
        return Optional.ofNullable(method.getDeclaredAnnotation(Transaction.class));
    }

    private Object notCheckedInvoke(Method method, Object[] args){
        try{
            return method.invoke(target, args);
        } catch (InvocationTargetException | IllegalAccessException  e) {
           throw new RuntimeException(e.getMessage());
        }
    }

    private Method getOverride(Method method) throws NoSuchMethodException {
        return targetClass.getDeclaredMethod(method.getName(), method.getParameterTypes());
    }

}
