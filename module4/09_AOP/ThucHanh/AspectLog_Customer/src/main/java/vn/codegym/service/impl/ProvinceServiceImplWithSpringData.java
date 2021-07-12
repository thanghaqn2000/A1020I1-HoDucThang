package vn.codegym.service.impl;

import org.springframework.stereotype.Service;
import vn.codegym.model.Province;
import vn.codegym.repository.ProvinceRepository;
import vn.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
@Service
public class ProvinceServiceImplWithSpringData implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public List<Province> findAll() {
        return streamAll().collect(Collectors.toList());
    }

    @Override
    public Province findOne(Long id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public Province save(Province Province) {
        return provinceRepository.save(Province);
    }

//    @Override
//    public List<Province> save(List<Province> Provinces) {
//        Iterable<Province> updatedProvinces = provinceRepository.save(Provinces);
//        return streamAll(updatedProvinces).collect(Collectors.toList());
//    }

    @Override
    public boolean exists(Long id) {
        return provinceRepository.existsById(id);
    }

    @Override
    public List<Province> findAll(List<Long> ids) {
        Iterable<Province> Provinces = provinceRepository.findAll();
        return streamAll(Provinces).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return provinceRepository.count();
    }

    @Override
    public void delete(Long id) {
        provinceRepository.delete(findOne(id));
    }

    @Override
    public void delete(Province Province) {
        provinceRepository.delete(Province);
    }

    @Override
    public void delete(List<Province> Provinces) {
        //provinceRepository.delete(Provinces);
    }

    @Override
    public void deleteAll() {
        provinceRepository.deleteAll();
    }

    private Stream<Province> streamAll() {
        return StreamSupport.stream(provinceRepository.findAll().spliterator(), false);
    }

    private Stream<Province> streamAll(Iterable<Province> Provinces) {
        return StreamSupport.stream(Provinces.spliterator(), false);
    }
}
