package model.proxies;

public class Factory {
    private Object proxy;

    public Factory(BaseFactory factory){
        proxy = factory.createProxy();
    }

    public Object instantiate(){
        return proxy;
    }
}
