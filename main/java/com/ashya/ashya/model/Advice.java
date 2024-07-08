package com.ashya.ashya.model;

import jakarta.persistence.*;

@Entity
@Table(name = "advice")
public class Advice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "category")
    private String category;

    @Column(name = "is_yes_or_no")
    private boolean isYesOrNo;

    public Advice() {
    }

    public boolean getYesOrNo() {
        return isYesOrNo;
    }

    public Long getId() {
        return id;
    }

    public void setYesOrNo(boolean yesOrNo) {
        isYesOrNo = yesOrNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Advice(String message, String category, boolean isYesOrNo) {
        this.message = message;
        this.category = category;
        this.isYesOrNo = isYesOrNo;

    }
}