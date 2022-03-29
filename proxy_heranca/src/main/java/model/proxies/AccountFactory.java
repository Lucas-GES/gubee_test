package model.proxies;

import model.service.AccountService;
import model.service.ServiceAccount;

public class AccountFactory implements BaseFactory{

    @Override
    public ServiceAccount createService() {
        return new Proxy(new AccountService());
    }
}
