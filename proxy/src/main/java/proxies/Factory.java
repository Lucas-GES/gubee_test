package proxies;

import com.sun.jdi.InternalException;
import javassist.util.proxy.ProxyFactory;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class Factory {

    private final Class[] interfaces;
    private Reference contructorRef;

    public Factory(Class classInterface){
        this(new Class[] {classInterface});
    }

    public Factory(Class[] interfaces){
        this.interfaces = interfaces;
    }

    public Object newInstance(InvocationHandler handler){
        if(handler == null) throw new NullPointerException();

        try{
            return getConstructor().newInstance(new Object[] {handler});
        }catch (InstantiationException e){
            throw new InternalError(e.toString());
        }catch (IllegalAccessException e){
            throw new InternalError(e.toString());
        }catch (InvocationTargetException e){
            throw new InternalError(e.toString());
        }
    }

    private synchronized Constructor getConstructor(){
        Constructor constructor = contructorRef == null ? null : (Constructor) contructorRef.get();

        if(constructor == null){
            try{
                constructor = Proxy.getProxyClass(getClass().getClassLoader(), interfaces)
                        .getConstructor(new Class[] {InvocationHandler.class});
            }catch (NoSuchMethodException e){
                throw new InternalError(e.toString());
            }

            contructorRef = new SoftReference(constructor);
        }

        return constructor;
    }

}
