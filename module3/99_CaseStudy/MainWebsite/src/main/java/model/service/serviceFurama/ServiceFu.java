package model.service.serviceFurama;

import model.bean.Service;

import java.util.List;

public interface ServiceFu {
    List<Service> selectAllService();
    boolean insertService(Service service);
}
