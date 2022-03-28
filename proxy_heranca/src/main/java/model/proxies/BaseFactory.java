package model.proxies;

public abstract class BaseFactory {

    public void factory(){
        createProxy();
    }

    public abstract Proxy createProxy();
}
