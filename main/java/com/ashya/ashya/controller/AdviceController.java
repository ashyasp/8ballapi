package com.ashya.ashya.controller;

import com.ashya.ashya.model.Advice;
import com.ashya.ashya.model.Question;
import com.ashya.ashya.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/advice")
public class AdviceController {
    @Autowired
    private AdviceService adviceService;

    @GetMapping("/random")
    public ResponseEntity<Advice> getAdvice(@RequestParam String category) {
        Advice advice = adviceService.getRandomAdvice(category);
        return advice != null ? ResponseEntity.ok(advice) : ResponseEntity.notFound().build();
    }

    @PostMapping("/ask")
    public ResponseEntity<?> askForAdvice(@RequestParam String category, @RequestBody String query) {
        try {
            Advice advice = adviceService.getRandomAdvice(category);
            if (advice != null) {
                Question question = new Question(query, advice);
                adviceService.saveQuestion(question);
                return ResponseEntity.ok(advice);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No advice found for the specified category.");
            }
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error processing request: " + e.getMessage());
        }
    }
    @PostMapping("/submit")
    public ResponseEntity<Advice> submitAdvice(@RequestBody Advice advice) {
        Advice savedAdvice = adviceService.saveAdvice(advice);
        if (savedAdvice != null) {
            return ResponseEntity.ok(savedAdvice);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping("/yesorno")
    public ResponseEntity<String> getYesOrNoAdvice() {
        String advice = adviceService.getYesOrNoAdvice();
        return ResponseEntity.ok(advice);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Advice> getAdviceById(@PathVariable Long id) {
        Optional<Advice> advice = adviceService.getAdviceById(id);
        return advice.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Advice> updateAdvice(@PathVariable Long id, @RequestBody Advice updatedAdvice) {
        Advice advice = adviceService.updateAdvice(id, updatedAdvice);
        if (advice != null) {
            return ResponseEntity.ok(advice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
