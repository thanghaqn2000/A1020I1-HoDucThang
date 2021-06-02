package model.repository.employee.impl;

import model.bean.Employee;
import model.repository.BaseRepository;
import model.repository.employee.EmployeeRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepoImpl implements EmployeeRepo {
    private static final String SELECT_EMP_BY_ID_SQL ="select id_nhan_vien,ten_vi_tri,ten_trinh_do,ten_bo_phan,ho_ten,ngay_sinh,cmnd,luong,sdt,email,dia_chi\n" +
            "from nhan_vien nv\n" +
            "left join vi_tri vt on vt.id_vi_tri=nv.id_vi_tri\n" +
            "left join trinh_do td on td.id_trinh_do=nv.id_trinh_do\n" +
            "left join bo_phan bp on bp.id_bo_phan=nv.id_bo_phan\n" +
            "where id_nhan_vien=?;";
    private static final String SELECT_ALL_EMP = "select id_nhan_vien,ten_vi_tri,ten_trinh_do,ten_bo_phan,ho_ten,ngay_sinh,cmnd,luong,sdt,email,dia_chi\n" +
            "from nhan_vien nv\n" +
            "left join vi_tri vt on vt.id_vi_tri=nv.id_vi_tri\n" +
            "left join trinh_do td on td.id_trinh_do=nv.id_trinh_do\n" +
            "left join bo_phan bp on bp.id_bo_phan=nv.id_bo_phan;";
    private static final String FIND_EMP_BY_NAME_SQL = "select id_nhan_vien,ten_vi_tri,ten_trinh_do,ten_bo_phan,ho_ten,ngay_sinh,cmnd,luong,sdt,email,dia_chi\n" +
            "from nhan_vien nv\n" +
            "left join vi_tri vt on vt.id_vi_tri=nv.id_vi_tri\n" +
            "left join trinh_do td on td.id_trinh_do=nv.id_trinh_do\n" +
            "left join bo_phan bp on bp.id_bo_phan=nv.id_bo_phan\n" +
            "where ((ho_ten like ?));";
    private static final String INSERT_EMP_SQL = "insert into nhan_vien(id_vi_tri,id_trinh_do,id_bo_phan,ho_ten,ngay_sinh,cmnd,luong,sdt,email,dia_chi ) \n" +
            "values (?,?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE_EMP_BY_ID_SQL = "update nhan_vien\n" +
            "set id_vi_tri=?,id_trinh_do=?,id_bo_phan=?,ho_ten=?,ngay_sinh=?,cmnd=?,luong=?,sdt=?,email=?,dia_chi=?\n" +
            "where id_nhan_vien=?";
    private static final String DELETE_EMP_BY_ID_SQL = "delete from nhan_vien\n" +
            "where id_nhan_vien=?;";
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Employee> selectAllEmp() {
        List<Employee> employeeList=new ArrayList<>();
        try {
            Statement statement=baseRepository.getConnection().createStatement();
            ResultSet rs= statement.executeQuery(SELECT_ALL_EMP);
            Employee employee=null;
            while (rs.next()){
                employee=new Employee();
                employee.setId_Employee(rs.getInt("id_nhan_vien"));
                employee.setNamePosition(rs.getString("ten_vi_tri"));
                employee.setNameLevel(rs.getString("ten_trinh_do"));
                employee.setNameDepartment(rs.getString("ten_bo_phan"));
                employee.setName(rs.getString("ho_ten"));
                employee.setDof(rs.getString("ngay_sinh"));
                employee.setId_Card(rs.getString("cmnd"));
                employee.setSalary(rs.getDouble("luong"));
                employee.setPhoneNumber(rs.getString("sdt"));
                employee.setEmail(rs.getString("email"));
                employee.setAddress(rs.getString("dia_chi"));
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public boolean insertEmp(Employee employee) {
        int row = 0;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(INSERT_EMP_SQL);
            preparedStatement.setInt(1, employee.getId_Position());
            preparedStatement.setInt(2, employee.getId_Level());
            preparedStatement.setInt(3, employee.getId_Department());
            preparedStatement.setString(4, employee.getName());
            preparedStatement.setString(5, employee.getDof());
            preparedStatement.setString(6, employee.getId_Card());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.setString(8, employee.getPhoneNumber());
            preparedStatement.setString(9, employee.getEmail());
            preparedStatement.setString(10, employee.getAddress());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    @Override
    public boolean deleteEmp(int idEmp) {
        int row=0;
        try {
            PreparedStatement preparedStatement=baseRepository.getConnection().prepareStatement(DELETE_EMP_BY_ID_SQL);
            preparedStatement.setInt(1,idEmp);
            row=preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row>0;
    }

    @Override
    public boolean updateEmp(Employee employee) {
        int row=0;
        try {
            PreparedStatement preparedStatement=baseRepository.getConnection().prepareStatement(UPDATE_EMP_BY_ID_SQL);
            preparedStatement.setInt(1, employee.getId_Position());
            preparedStatement.setInt(2, employee.getId_Level());
            preparedStatement.setInt(3, employee.getId_Department());
            preparedStatement.setString(4, employee.getName());
            preparedStatement.setString(5, employee.getDof());
            preparedStatement.setString(6, employee.getId_Card());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.setString(8, employee.getPhoneNumber());
            preparedStatement.setString(9, employee.getEmail());
            preparedStatement.setString(10, employee.getAddress());
            preparedStatement.setInt(11,employee.getId_Employee());
            row=preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row>0;
    }

    @Override
    public List<Employee> findEmp(String nameEmp) {
        List<Employee> employeeList=new ArrayList<>();
        try {
            PreparedStatement preparedStatement=baseRepository.getConnection().prepareStatement(FIND_EMP_BY_NAME_SQL);
            preparedStatement.setString(1,"%" + nameEmp + "%");
            ResultSet rs = preparedStatement.executeQuery();
            Employee employee=null;
            while (rs.next()){
                employee=new Employee();
                employee.setId_Employee(rs.getInt("id_nhan_vien"));
                employee.setNamePosition(rs.getString("ten_vi_tri"));
                employee.setNameLevel(rs.getString("ten_trinh_do"));
                employee.setNameDepartment(rs.getString("ten_bo_phan"));
                employee.setName(rs.getString("ho_ten"));
                employee.setDof(rs.getString("ngay_sinh"));
                employee.setId_Card(rs.getString("cmnd"));
                employee.setSalary(rs.getDouble("luong"));
                employee.setPhoneNumber(rs.getString("sdt"));
                employee.setEmail(rs.getString("email"));
                employee.setAddress(rs.getString("dia_chi"));
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee selectEmp(int id) {
        Employee employee=null;
        try {
            PreparedStatement preparedStatement=baseRepository.getConnection().prepareStatement(SELECT_EMP_BY_ID_SQL);
            preparedStatement.setInt(1,id);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                employee=new Employee();
                employee.setId_Employee(rs.getInt("id_nhan_vien"));
                employee.setNamePosition(rs.getString("ten_vi_tri"));
                employee.setNameLevel(rs.getString("ten_trinh_do"));
                employee.setNameDepartment(rs.getString("ten_bo_phan"));
                employee.setName(rs.getString("ho_ten"));
                employee.setDof(rs.getString("ngay_sinh"));
                employee.setId_Card(rs.getString("cmnd"));
                employee.setSalary(rs.getDouble("luong"));
                employee.setPhoneNumber(rs.getString("sdt"));
                employee.setEmail(rs.getString("email"));
                employee.setAddress(rs.getString("dia_chi"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

    @Override
    public int getIdAuto() {
        return 0;
    }
}
