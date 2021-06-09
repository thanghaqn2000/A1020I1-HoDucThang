package model.repository.impl;

import model.bean.MatBang;
import model.repository.BaseRepository;
import model.repository.GroundRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GroundRepoImpl implements GroundRepo {
    private static final String SELECT_ALL_GROUND = "select mb.id,lmb.loaiMatBang,trangThai,dienTich,tang,giaTien,ngayBatDau,ngayBatDau\n" +
            "from MatBang mb\n" +
            "left join LoaiMatBang lmb on lmb.id= mb.idLoaiMatBang\n" +
            "order by dienTich ";
    private static final String INSERT_GROUND = "insert into MatBang(idLoaiMatBang,trangThai,dienTich,tang,giaTien,ngayBatDau,ngayKetThuc)\n" +
            "values(?,?,?,?,?,?,?);";
    private static final String DELETE_GROUND="delete from MatBang\n" +
            "where id =?;";
    private static final String FIND_GROUND="select mb.id,lmb.loaiMatBang,trangThai,dienTich,tang,giaTien,ngayBatDau,ngayBatDau\n" +
            "from MatBang mb\n" +
            "left join LoaiMatBang lmb on lmb.id= mb.idLoaiMatBang\n" +
            "where ((lmb.loaiMatBang like ?)) ";
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<MatBang> selectAllGround() {
        List<MatBang> groundList = new ArrayList<>();
        try {
            Statement statement = baseRepository.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_GROUND);
            MatBang matBang = null;
            while (rs.next()) {
                matBang = new MatBang();
                matBang.setId(rs.getInt(1));
                matBang.setLoaiMatBang(rs.getString(2));
                matBang.setTrangThai(rs.getString(3));
                matBang.setDienTich(rs.getDouble(4));
                matBang.setTang(rs.getInt(5));
                matBang.setGiaTien(rs.getDouble(6));
                matBang.setNgayBatDau(rs.getString(7));
                matBang.setNgayKetThuc(rs.getString(8));

                groundList.add(matBang);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return groundList;
    }

    @Override
    public boolean insertGround(MatBang matBang) {
        int row = 0;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(INSERT_GROUND);
            preparedStatement.setInt(1, matBang.getIdLoaiMatBang());
            preparedStatement.setString(2, matBang.getTrangThai());
            preparedStatement.setDouble(3, matBang.getDienTich());
            preparedStatement.setInt(4, matBang.getTang());
            preparedStatement.setDouble(5, matBang.getGiaTien());
            preparedStatement.setString(6, matBang.getNgayBatDau());
            preparedStatement.setString(7, matBang.getNgayKetThuc());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    @Override
    public boolean deleteGround(int idMatBang) {
        int row=0;
        try {
            PreparedStatement preparedStatement=baseRepository.getConnection().prepareStatement(DELETE_GROUND);
            preparedStatement.setInt(1,idMatBang);
            row=preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row>0;
    }

    @Override
    public boolean updateGround(MatBang matBang) {
        return false;
    }

    @Override
    public List<MatBang> findGround(String loaiMatBang) {
        List<MatBang> matBangList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(FIND_GROUND);
            preparedStatement.setString(1, "%" + loaiMatBang + "%");
            ResultSet rs = preparedStatement.executeQuery();
            MatBang matBang = null;
            while (rs.next()) {
                matBang = new MatBang();
                matBang.setId(rs.getInt(1));
                matBang.setLoaiMatBang(rs.getString(2));
                matBang.setTrangThai(rs.getString(3));
                matBang.setDienTich(rs.getDouble(4));
                matBang.setTang(rs.getInt(5));
                matBang.setGiaTien(rs.getDouble(6));
                matBang.setNgayBatDau(rs.getString(7));
                matBang.setNgayKetThuc(rs.getString(8));
                matBangList.add(matBang);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return matBangList;
    }

    @Override
    public MatBang selectGround(int idMatBang) {
        return null;
    }
}
