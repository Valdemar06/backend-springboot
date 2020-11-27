package com.valdemar.backendspringboot.controller;

import com.valdemar.backendspringboot.util.MyLogger;
import com.valdemar.backendspringboot.entity.Stat;
import com.valdemar.backendspringboot.repository.StatRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/stat")
public class StatController {

    private final MyLogger helper = new MyLogger();
    private final StatRepository statRepository;
    private final Long constID = 1L;

    public StatController(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<Stat> findById() {
        helper.showClassAndMethod("Stat Controller: method:findAll() --------------------------------------------------------------");
        return ResponseEntity.ok(statRepository.findById(constID).get());
    }
}
