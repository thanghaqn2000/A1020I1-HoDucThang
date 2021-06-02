package model.repository.contract.impl;

import model.bean.Contract;
import model.repository.BaseRepository;
import model.repository.contract.ContractRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContractRepoImpl implements ContractRepo {
    private static final String SELECT_ALL_CONTRACT="select hd.id_hop_dong,nv.ho_ten,kh.ho_ten,dv.ten_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,tong_tien \n" +
            "from hop_dong hd\n" +
            "left join nhan_vien nv on nv.id_nhan_vien=hd.id_nhan_vien \n" +
            "left join khach_hang kh on kh.id_khach_hang=hd.id_khach_hang \n" +
            "left join dich_vu dv on dv.id_dich_vu=hd.id_dich_vu; ";
    private static final String INSERT_CONTRACT="insert into hop_dong(id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,tong_tien)\n" +
            "values(?,?,?,?,?,?,?);";
    BaseRepository baseRepository=new BaseRepository();

    @Override
    public List<Contract> selectAll() {
        List<Contract> contractList=new ArrayList<>();
        try {
            Statement statement=baseRepository.getConnection().createStatement();
            ResultSet rs=statement.executeQuery(SELECT_ALL_CONTRACT);
            Contract contract=null;
            while (rs.next()){
                contract=new Contract();
                contract.setId(rs.getInt("id_hop_dong"));
                contract.setEmp(rs.getString(2));
                contract.setCus(rs.getString(3));
                contract.setService(rs.getString(4));
                contract.setContractDate(rs.getString(5));
                contract.setEndDate(rs.getString(6));
                contract.setDeposits(rs.getDouble(7));
                contract.setTotalMoney(rs.getDouble(8));
                contractList.add(contract);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractList;
    }

    @Override
    public boolean insert(Contract contract) {
        int row=0;
        try {
            PreparedStatement preparedStatement=baseRepository.getConnection().prepareStatement(INSERT_CONTRACT);
            preparedStatement.setInt(1,contract.getIdEmp());
            preparedStatement.setInt(2,contract.getIdCus());
            preparedStatement.setInt(3,contract.getIdService());
            preparedStatement.setString(4,contract.getContractDate());
            preparedStatement.setString(5,contract.getEndDate());
            preparedStatement.setDouble(6,contract.getDeposits());
            preparedStatement.setDouble(7,contract.getTotalMoney());
            row=preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row>0;
    }
}
