package com.ashya.ashya.service;

import com.ashya.ashya.model.Advice;
import com.ashya.ashya.model.Question;
import com.ashya.ashya.repository.AdviceRepository;
import com.ashya.ashya.repository.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
public class AdviceService {
    private static final Logger logger = LoggerFactory.getLogger(AdviceService.class);
    @Autowired
    private AdviceRepository adviceRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public Advice getRandomAdvice(String category) {
        List<Advice> advices = adviceRepository.findByCategory(category);
        logger.info("Fetching advice for category: {}", category);
        if (advices.isEmpty()) {
            logger.info("No advice found for category: {}", category);
            return null;
        }
        return advices.get(new Random().nextInt(advices.size()));
    }


    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }
    public Advice saveAdvice(Advice advice) {
        return adviceRepository.save(advice);
    }
    public String getYesOrNoAdvice() {
        // Simple random generator for Yes or No
        boolean yes = new Random().nextBoolean();
        return yes ? "Yes" : "No";
    }
    public Optional<Advice> getAdviceById(Long id) {
        return adviceRepository.findById(id);
    }
    public Advice updateAdvice(Long id, Advice updatedAdvice) {
        return adviceRepository.findById(id)
                .map(advice -> {
                    advice.setMessage(updatedAdvice.getMessage());
                    advice.setCategory(updatedAdvice.getCategory());
                    advice.setYesOrNo(updatedAdvice.getYesOrNo());
                    return adviceRepository.save(advice);
                }).orElse(null);
    }
}