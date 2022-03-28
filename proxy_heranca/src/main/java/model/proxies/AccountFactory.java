package model.proxies;

public class AccountFactory extends BaseFactory{

    @Override
    public Proxy createProxy() {
        return new Proxy();
    }
}
