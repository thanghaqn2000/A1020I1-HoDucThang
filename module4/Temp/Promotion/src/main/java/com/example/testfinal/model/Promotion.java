package com.example.testfinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank
    private String promotionName;

    private String startDate;

    private String endDate;
    @Min(value = 10000,message = "Discount money must be greater than 10.000")
    private double moneyPromotion;
    @NotBlank
    private String detail;

    public Promotion() {
    }

    public Promotion(int id, String promotionName, String startDate, String endDate, double moneyPromotion, String detail) {
        this.id = id;
        this.promotionName = promotionName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.moneyPromotion = moneyPromotion;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getMoneyPromotion() {
        return moneyPromotion;
    }

    public void setMoneyPromotion(double moneyPromotion) {
        this.moneyPromotion = moneyPromotion;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
