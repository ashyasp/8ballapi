package com.ashya.ashya.repository;

import com.ashya.ashya.model.Advice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdviceRepository  extends JpaRepository<Advice,Long> {
    List<Advice>findByCategory(String category);

}
