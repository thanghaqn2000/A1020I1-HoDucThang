package model.repository.customer.impl;

import model.repository.BaseRepository;
import model.repository.customer.CustomerRepo;
import model.bean.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class CustomerRepoImpl implements CustomerRepo {
    private static final String SELECT_CUSTOMER_BY_ID_SQL = "select id_khach_hang,lk.id_loai_khach,lk.ten_loai_khach,ho_ten,ngay_sinh,so_cmnd,sdt,email,dia_chi\n" +
            " from khach_hang kh\n" +
            " left join loai_khach lk on lk.id_loai_khach=kh.id_loai_khach\n" +
            "where id_khach_hang=?;";
    private static final String SELECT_ALL_CUSTOMER = "select kh.id_khach_hang,kh.ho_ten ,lk.ten_loai_khach, kh.ngay_sinh,kh.so_cmnd,kh.sdt,kh.email,kh.dia_chi\n" +
            "from khach_hang kh\n" +
            "\tleft join loai_khach lk on lk.id_loai_khach=kh.id_loai_khach;";

//    private static final String SELECT_AUTO_ID = "SELECT last_insert_id() FROM information_schema.tables " +
//            "WHERE table_name = 'users' and table_schema = 'demo';";
//
//    private static final String SELECT_AUTO_INCREMENT = "SELECT AUTO_INCREMENT FROM information_schema.tables " +
//            "WHERE table_name = 'users' and table_schema = 'demo';";

    private static final String FIND_CUSTOMER_BY_NAME_SQL = "select id_khach_hang,lk.id_loai_khach,lk.ten_loai_khach,ho_ten,ngay_sinh,so_cmnd,sdt,email,dia_chi\n" +
            " from khach_hang kh\n" +
            " left join loai_khach lk on lk.id_loai_khach=kh.id_loai_khach\n" +
            "where ((ho_ten like ?));";
    private static final String INSERT_CUSTOMER_SQL = "insert into khach_hang(id_loai_khach,ho_ten,ngay_sinh,so_cmnd,sdt,email,dia_chi)" +
            "values (?,?,?,?,?,?,?)";
    private static final String UPDATE_CUSTOMER_BY_ID_SQL = "update khach_hang\n" +
            "set id_loai_khach=?,ho_ten=?,ngay_sinh=?,so_cmnd=?,sdt=?,email=?,dia_chi=?\n" +
            "where id_khach_hang=?;";
    private static final String DELETE_CUSTOMER_BY_ID_SQL = "delete from khach_hang \n" +
            "where id_khach_hang =?;";
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Customer> selectAllCus() {
        List<Customer> customerList = new ArrayList<>();
        try {
            Statement statement = baseRepository.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_CUSTOMER);
            Customer customer = null;
            while (rs.next()) {
                customer = new Customer();
                customer.setCustomer_Id(rs.getInt("id_khach_hang"));
                customer.setType_Customer(rs.getString("ten_loai_khach"));
                customer.setCustomer_Name(rs.getString("ho_ten"));
                customer.setCustomer_Birthday(rs.getString("ngay_sinh"));
                customer.setCustomer_Id_Card(rs.getString("so_cmnd"));
                customer.setCustomer_Phone(rs.getString("sdt"));
                customer.setCustomer_Email(rs.getString("email"));
                customer.setCustomer_Address(rs.getString("dia_chi"));
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean insertCus(Customer customer) {
        int row = 0;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(INSERT_CUSTOMER_SQL);
            preparedStatement.setInt(1, customer.getType_Customer_Id());
            preparedStatement.setString(2, customer.getCustomer_Name());
            preparedStatement.setString(3, customer.getCustomer_Birthday());
            preparedStatement.setString(4, customer.getCustomer_Id_Card());
            preparedStatement.setString(5, customer.getCustomer_Phone());
            preparedStatement.setString(6, customer.getCustomer_Email());
            preparedStatement.setString(7, customer.getCustomer_Address());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    @Override
    public boolean deleteCus(int idCus) {
        int row = 0;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(DELETE_CUSTOMER_BY_ID_SQL);
            preparedStatement.setInt(1, idCus);
            row = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row > 0;
    }

    @Override
    public boolean updateCus(Customer customer) {
        int row = 0;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(UPDATE_CUSTOMER_BY_ID_SQL);
            preparedStatement.setInt(1, customer.getType_Customer_Id());
            preparedStatement.setString(2, customer.getCustomer_Name());
            preparedStatement.setString(3, customer.getCustomer_Birthday());
            preparedStatement.setString(4, customer.getCustomer_Id_Card());
            preparedStatement.setString(5, customer.getCustomer_Phone());
            preparedStatement.setString(6, customer.getCustomer_Email());
            preparedStatement.setString(7, customer.getCustomer_Address());
            preparedStatement.setInt(8, customer.getCustomer_Id());
            row = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row > 0;
    }

    @Override
    public List<Customer> findCus(String nameCus) {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(FIND_CUSTOMER_BY_NAME_SQL);
            preparedStatement.setString(1, "%" + nameCus + "%");
            ResultSet rs = preparedStatement.executeQuery();
            Customer customer = null;
            while (rs.next()) {
                customer = new Customer();
                customer.setCustomer_Id(rs.getInt("id_khach_hang"));
                customer.setType_Customer(rs.getString("ten_loai_khach"));
                customer.setCustomer_Name(rs.getString("ho_ten"));
                customer.setCustomer_Birthday(rs.getString("ngay_sinh"));
                customer.setCustomer_Id_Card(rs.getString("so_cmnd"));
                customer.setCustomer_Phone(rs.getString("sdt"));
                customer.setCustomer_Email(rs.getString("email"));
                customer.setCustomer_Address(rs.getString("dia_chi"));
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer selectCus(int id) {
        Customer customer = null;
        try {
            PreparedStatement statement = baseRepository.getConnection().prepareStatement(SELECT_CUSTOMER_BY_ID_SQL);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                customer = new Customer();
                customer.setCustomer_Id(rs.getInt("id_khach_hang"));
                customer.setType_Customer_Id(rs.getInt("id_loai_khach"));
                customer.setType_Customer(rs.getString("ten_loai_khach"));
                customer.setCustomer_Name(rs.getString("ho_ten"));
                customer.setCustomer_Birthday(rs.getString("ngay_sinh"));
                customer.setCustomer_Id_Card(rs.getString("so_cmnd"));
                customer.setCustomer_Phone(rs.getString("sdt"));
                customer.setCustomer_Email(rs.getString("email"));
                customer.setCustomer_Address(rs.getString("dia_chi"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public int getIdAuto() {
        return 0;
    }
}
