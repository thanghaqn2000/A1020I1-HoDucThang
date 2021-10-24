package com.example.testfinal.repository;

import com.example.testfinal.model.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PromotionRepo extends JpaRepository<Promotion, Integer> {

    @Query(value = " SELECT * FROM promotion where start_date = :startDate " +
            " and end_date = :endDate and money_promotion = :money", nativeQuery = true)
    Page<Promotion> boLoc(@Param("startDate") String startDate, @Param("endDate") String endDate,
                          @Param("money") Double money, Pageable pageable);

    Page<Promotion> findByStartDate(String startDate, Pageable pageable);

    Page<Promotion> findByEndDate(String endDate, Pageable pageable);

    Page<Promotion> findByMoneyPromotion(Double money, Pageable pageable);

    @Query(value = "SELECT * FROM promotion " +
            " where promotion_name like %:name% ", nativeQuery = true)
    Page<Promotion> searchName(@Param("name") String name,Pageable pageble);
}
