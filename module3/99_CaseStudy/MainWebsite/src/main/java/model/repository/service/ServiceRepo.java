package model.repository.service;

import model.bean.Customer;
import model.bean.Service;

import java.util.List;

public interface ServiceRepo {
    List<Service> selectAllService();
    boolean insertService(Service service);
}
