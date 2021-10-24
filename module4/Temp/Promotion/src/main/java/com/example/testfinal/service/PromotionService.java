package com.example.testfinal.service;

import com.example.testfinal.model.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PromotionService {
    Page<Promotion> findAll(int pageNum,int pageSize);
    Page<Promotion> findPromotion(String startDate, String endDate, double moneyPromotion, Pageable pageable);
    Page<Promotion> findPromotionName(String name, Pageable pageable);
    void create(Promotion  promotion);
    void update(Promotion  promotion);
    void delete(int id);
    Promotion findById(int id);
}
