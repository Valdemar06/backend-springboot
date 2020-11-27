package com.valdemar.backendspringboot.Service;

import com.valdemar.backendspringboot.entity.Task;
import com.valdemar.backendspringboot.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public Task update(Task task) {
        return taskRepository.save(task);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).get();
    }

    public Page<Task> findByParams(String title, Integer completed, Long priorityId, Long categoryId, PageRequest pagebel){
        return taskRepository.findByParams(title,completed,priorityId,categoryId,pagebel);
    }

    public List<Task>findAllByOrderByIdAsc(){
        return taskRepository.findAllByOrderByIdAsc();}
}
