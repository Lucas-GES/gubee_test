package model.proxies;

public class AccountFactory implements BaseFactory{
    @Override
    public Object createProxy() {
        return new Proxy();
    }
}
