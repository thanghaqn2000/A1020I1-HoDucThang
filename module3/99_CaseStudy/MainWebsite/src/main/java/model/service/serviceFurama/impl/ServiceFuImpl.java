package model.service.serviceFurama.impl;

import model.bean.Service;
import model.repository.service.ServiceRepo;
import model.repository.service.impl.ServiceRepoImpl;
import model.service.serviceFurama.ServiceFu;

import java.util.List;

public class ServiceFuImpl implements ServiceFu {
    ServiceRepo serviceRepo=new ServiceRepoImpl();
    @Override
    public List<Service> selectAllService() {
        return serviceRepo.selectAllService();
    }

    @Override
    public boolean insertService(Service service) {
        return serviceRepo.insertService(service);
    }
}
