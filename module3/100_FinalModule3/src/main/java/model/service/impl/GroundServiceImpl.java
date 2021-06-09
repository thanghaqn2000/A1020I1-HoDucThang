package model.service.impl;

import model.bean.MatBang;
import model.repository.GroundRepo;
import model.repository.impl.GroundRepoImpl;
import model.service.GroundService;

import java.util.List;

public class GroundServiceImpl implements GroundService {
    GroundRepo groundRepo=new GroundRepoImpl();
    @Override
    public List<MatBang> selectAllGround() {
        return groundRepo.selectAllGround();
    }

    @Override
    public boolean insertGround(MatBang matBang) {
        return groundRepo.insertGround(matBang);
    }

    @Override
    public boolean deleteGround(int idMatBang) {
        return groundRepo.deleteGround(idMatBang);
    }

    @Override
    public boolean updateGround(MatBang matBang) {
        return groundRepo.updateGround(matBang);
    }

    @Override
    public List<MatBang> findGround(String loaiMatBang) {
        return groundRepo.findGround(loaiMatBang);
    }

    @Override
    public MatBang selectGround(int idMatBang) {
        return groundRepo.selectGround(idMatBang);
    }
}
