package com.ashya.ashya.model;

import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String query;

    @ManyToOne
    @JoinColumn(name = "advice_id")
    private Advice advice;

    public Question() {
    }

    public Question(String query, Advice advice) {
        this.query = query;
        this.advice = advice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}