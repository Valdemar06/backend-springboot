package com.valdemar.backendspringboot.Service;

import com.valdemar.backendspringboot.entity.Stat;
import com.valdemar.backendspringboot.repository.StatRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StatService {

    private final StatRepository statRepository;

    public StatService(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    public Stat findById(Long id) {
        return statRepository.findById(id).get();
    }
}
