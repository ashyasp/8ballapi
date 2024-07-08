package com.ashya.ashya.service;

import com.ashya.ashya.model.Question;
import com.ashya.ashya.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }
}
