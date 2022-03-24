package proxies;

import annotations.TransactionService;
import application.Program;
import org.reflections.Reflections;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Factory {

    private List<CreatedProxy> beanRegistry;

    public Factory(Package packages){
        Reflections reflections = new Reflections(packages);
        Set<Class<?>> transactionClass = reflections.getTypesAnnotatedWith(TransactionService.class);

        List<?> beans = instantiateBeans(transactionClass);
        beanRegistry = newProxies(beans);
    }

    private List<CreatedProxy> newProxies(List<?> beans){
        return beans.stream()
                .map(this::createdProxy)
                .collect(Collectors.toList());
    }

    private List<?> instantiateBeans(Set<Class<?>> annotated){
        return annotated.stream()
                .map(this::instantiateClass)
                .collect(Collectors.toList());
    }

    private Object instantiateClass(Class<?> clasz){
        try {
            return clasz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Could not instantiate class " + clasz);
        }
    }

    private CreatedProxy createdProxy(Object bean){
        InvocationHandler handler = new DynamicProxy(bean);
        Object proxyObj = Proxy.newProxyInstance(Program.class.getClassLoader(), bean.getClass().getInterfaces(), handler);

        return new CreatedProxy(Arrays.asList(bean.getClass().getInterfaces()), proxyObj);
    }

    public <T> T getBean(Class<T> clasz){
        Object proxy = beanRegistry.stream()
                .filter(p -> p.hasInterface(clasz))
                .findFirst()
                .map(CreatedProxy::getProxy)
                .orElseThrow(() -> new RuntimeException("Not found for class " + clasz));
        return clasz.cast(proxy);
    }
}
