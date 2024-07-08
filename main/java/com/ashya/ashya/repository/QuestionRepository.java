package com.ashya.ashya.repository;

import com.ashya.ashya.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  QuestionRepository extends JpaRepository<Question,Long> {


}
