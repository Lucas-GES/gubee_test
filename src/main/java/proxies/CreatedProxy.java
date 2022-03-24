package proxies;

import java.util.List;

public class CreatedProxy {
    private List<Class<?>> interfaces;
    private Object proxy;

    public CreatedProxy(List<Class<?>> interfaces, Object proxy){
        this.interfaces = interfaces;
        this.proxy = proxy;
    }

    public Object getProxy(){
        return proxy;
    }

    public boolean hasInterface(Class<?> expectedInterface){
        return interfaces.contains(expectedInterface);
    }
}
