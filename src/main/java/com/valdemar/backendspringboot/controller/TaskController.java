package com.valdemar.backendspringboot.controller;

import com.valdemar.backendspringboot.entity.Task;
import com.valdemar.backendspringboot.repository.TaskRepository;
import com.valdemar.backendspringboot.search.TaskSearchValues;
import com.valdemar.backendspringboot.util.MyLogger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskRepository taskRepository;
    private final MyLogger myLogger = new MyLogger();

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/all")
    public List<Task> findAll() {
        myLogger.showClassAndMethod("Task Controller method:findAll() ----------------------------------------------");
        return taskRepository.findAllByOrderByIdAsc();
    }

    @PostMapping("/add")
    public ResponseEntity<Task> add(@RequestBody Task task) {
        myLogger.showClassAndMethod("Task Controller method:add() --------------------------------------------------");
        if (task.getId() != null && task.getId() != 0) {
            return new ResponseEntity("Id shouldn't be null or 0", HttpStatus.NOT_ACCEPTABLE);
        }
        if (task.getTitle() == null || task.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: TITLE", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(taskRepository.save(task));
    }

    @PutMapping("/update")
    public ResponseEntity<Task> update(@RequestBody Task task) {
        myLogger.showClassAndMethod("Task Controller method:update() -----------------------------------------------");
        if (task.getId() == null || task.getId() == 0) {
            return new ResponseEntity("missed param: ID", HttpStatus.NOT_ACCEPTABLE);
        }
        if (task.getTitle() == null || task.getTitle().trim().length() == 0) {
            return new ResponseEntity("missed param: ID", HttpStatus.NOT_ACCEPTABLE);
        }
        taskRepository.save(task);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        myLogger.showClassAndMethod("Task Controller method:findById() ---------------------------------------------");
        Task task;
        try {
            task = taskRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return new ResponseEntity("id = " + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Task> deleteById(@PathVariable Long id) {
        myLogger.showClassAndMethod("Task Controller method:deleteById() -------------------------------------------");
        try {
            taskRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return new ResponseEntity("id  = " + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Task>> search(@RequestBody TaskSearchValues taskSearchValues) {
        myLogger.showClassAndMethod("Task Controller method:search() -----------------------------------------------");

        // exclude NullPointerException
        String title = taskSearchValues.getTitle() != null ? taskSearchValues.getTitle() : null;
        //Converted Boolean in Integer
        Integer completed = taskSearchValues.getCompleted() != null ? taskSearchValues.getCompleted() : null;
        Long priorityId = taskSearchValues.getPriorityId() != null ? taskSearchValues.getPriorityId() : null;
        Long categoryId = taskSearchValues.getCategoryId() != null ? taskSearchValues.getCategoryId() : null;

        String sortColumn = taskSearchValues.getSortColumn() != null ? taskSearchValues.getSortColumn() : null;
        String sortDirection = taskSearchValues.getSortDirection() != null ? taskSearchValues.getSortDirection() : null;

        Integer pageNumber = taskSearchValues.getPageNumber() != null ? taskSearchValues.getPageNumber() : null;
        Integer pageSize = taskSearchValues.getPageSize() != null ? taskSearchValues.getPageSize() : null;

        Sort.Direction direction = sortDirection == null ||sortDirection.trim().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;

        //sort object
        Sort sort = Sort.by( direction, sortColumn);

        //paging object
        PageRequest pageable = PageRequest.of(pageNumber, pageSize);

        Page result = taskRepository.findByParams(title, completed, priorityId, categoryId, pageable);

        return ResponseEntity.ok(result);
    }
}
