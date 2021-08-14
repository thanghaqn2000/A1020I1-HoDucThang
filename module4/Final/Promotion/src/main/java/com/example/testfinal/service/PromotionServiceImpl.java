package com.example.testfinal.service;

import com.example.testfinal.model.Promotion;
import com.example.testfinal.repository.PromotionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PromotionServiceImpl implements PromotionService {
    @Autowired
    PromotionRepo promotionRepo;


    @Override
    public Page<Promotion> findAll(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by("moneyPromotion").descending().and(Sort.by("detail")));
        return promotionRepo.findAll(pageable);
    }

    @Override
    public Page<Promotion> findPromotion(String startDate, String endDate, double moneyPromotion,Pageable pageable) {
//        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by("moneyPromotion").descending().and(Sort.by("detail")));

        return promotionRepo.boLoc(startDate,endDate,moneyPromotion,pageable);
    }

    @Override
    public Page<Promotion> findPromotionName(String name, Pageable pageable) {
        return promotionRepo.searchName(name,pageable);
    }

    @Override
    public void create(Promotion promotion) {
        promotionRepo.save(promotion);
    }

    @Override
    public void update(Promotion promotion) {
        promotionRepo.save(promotion);

    }

    @Override
    public void delete(int id) {
        promotionRepo.deleteById(id);
    }

    @Override
    public Promotion findById(int id) {
        return promotionRepo.findById(id).orElse(null);
    }
}
