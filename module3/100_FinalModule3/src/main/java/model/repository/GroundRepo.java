package model.repository;

import model.bean.MatBang;

import java.util.List;

public interface GroundRepo {
    List<MatBang> selectAllGround();
    boolean insertGround(MatBang matBang);
    boolean deleteGround(int idMatBang);
    boolean updateGround(MatBang matBang);
    List<MatBang> findGround(String loaiMatBang);
    MatBang selectGround(int idMatBang);
}
