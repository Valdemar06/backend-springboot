package com.valdemar.backendspringboot.Service;

import com.valdemar.backendspringboot.entity.Priority;
import com.valdemar.backendspringboot.repository.PriorityRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    public List<Priority> findAll() {
        return priorityRepository.findAll();
    }

    public Priority save(Priority priority) {
        return priorityRepository.save(priority);
    }

    public Priority update(Priority priority) {
        return priorityRepository.save(priority);
    }

    public void deleteById(Long id) {
        priorityRepository.deleteById(id);
    }

    public Priority findById(Long id) {
        return priorityRepository.findById(id).get();
    }

    public List<Priority> findByTitle(String title) {
        return priorityRepository.findByTitle(title);
    }

    public List<Priority> findAllByOrderByIdAsc(){
        return priorityRepository.findAllByOrderByIdAsc();
    }
}
