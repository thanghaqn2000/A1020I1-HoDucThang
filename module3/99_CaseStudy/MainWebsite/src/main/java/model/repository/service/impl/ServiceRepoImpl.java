package model.repository.service.impl;

import model.bean.Service;
import model.repository.BaseRepository;
import model.repository.service.ServiceRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepoImpl implements ServiceRepo {
    private static final String SELECT_ALL_SERVICE = "select id_dich_vu,ten_loai_dich_vu,ten_kieu_thue,ten_dich_vu,dien_tich,so_tang,so_nguoi_toi_da,chi_phi_thue,trang_thai\n" +
            "from dich_vu dv\n" +
            "left join loai_dich_vu ldv on ldv.id_loai_dich_vu = dv.id_loai_dich_vu\n" +
            "left join kieu_thue kt on kt.id_kieu_thue = dv.id_kieu_thue;";

    private static final String INSERT_SERVICE="insert into dich_vu(id_loai_dich_vu,id_kieu_thue,ten_dich_vu,dien_tich,so_tang,so_nguoi_toi_da,chi_phi_thue,trang_thai)\n" +
            "values (?,?,?,?,?,?,?,?);";
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Service> selectAllService() {
        List<Service> serviceList = new ArrayList<>();
        try {
            Statement statement = baseRepository.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_SERVICE);
            Service service = null;
            while (rs.next()) {
                service = new Service();
                service.setId_service(rs.getInt("id_dich_vu"));
                service.setName_type_service(rs.getString("ten_loai_dich_vu"));
                service.setName_type_rental(rs.getString("ten_kieu_thue"));
                service.setName_service(rs.getString("ten_dich_vu"));
                service.setArea(rs.getDouble("dien_tich"));
                service.setFloor(rs.getDouble("so_tang"));
                service.setMax_people(rs.getInt("so_nguoi_toi_da"));
                service.setCost_rental(rs.getDouble("chi_phi_thue"));
                service.setStatus(rs.getString("trang_thai"));
                serviceList.add(service);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public boolean insertService(Service service) {
        int row=0;
        try {
            PreparedStatement preparedStatement=baseRepository.getConnection().prepareStatement(INSERT_SERVICE);
            preparedStatement.setInt(1,service.getId_type_service());
            preparedStatement.setInt(2,service.getId_type_rental());
            preparedStatement.setString(3,service.getName_service());
            preparedStatement.setDouble(4,service.getArea());
            preparedStatement.setDouble(5,service.getFloor());
            preparedStatement.setInt(6,service.getMax_people());
            preparedStatement.setDouble(7,service.getCost_rental());
            preparedStatement.setString(8,service.getStatus());
            row=preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row>0;
    }
}
