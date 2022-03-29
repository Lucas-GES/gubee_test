package model.proxies;
import model.service.ServiceAccount;

public interface BaseFactory {
    ServiceAccount createService();
}
