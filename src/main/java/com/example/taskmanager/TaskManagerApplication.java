package com.example.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class TaskManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);
    }
}

// 1. Data Model (Entity)
@Table("task")
class Task {
    @Id private Long id;
    private String title;
    private String description;
    private boolean completed;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}

// 2. Reactive Repository
interface TaskRepository extends ReactiveCrudRepository<Task, Long> {}

// 3. Reactive REST Controller
@RestController
@RequestMapping("/api/tasks")
@CrossOrigin("*")
class TaskController {
    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Flux<Task> getAllTasks() {
        return repository.findAll();
    }

    @PostMapping
    public Mono<Task> createTask(@RequestBody Task task) {
        return repository.save(task);
    }
}
