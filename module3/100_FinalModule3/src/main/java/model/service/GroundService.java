package model.service;

import model.bean.MatBang;

import java.util.List;

public interface GroundService {
    List<MatBang> selectAllGround();
    boolean insertGround(MatBang matBang);
    boolean deleteGround(int idMatBang);
    boolean updateGround(MatBang matBang);
    List<MatBang> findGround(String loaiMatBang);
    MatBang selectGround(int idMatBang);
}
