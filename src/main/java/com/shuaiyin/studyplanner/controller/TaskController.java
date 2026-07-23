package com.shuaiyin.studyplanner.controller;

import com.shuaiyin.studyplanner.model.Task;
import com.shuaiyin.studyplanner.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getTasks(
        @RequestParam(required = false) String status
    ){
        if("completed".equalsIgnoreCase(status)){
            return taskRepository.findByCompleted(true);
        }

        if("pending".equalsIgnoreCase(status)){
            return taskRepository.findByCompleted(false);
        }
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @GetMapping("/stats/weekly")
    public Map<String, Long> getWeeklyCompletedTaskNum(){
        LocalDate today = LocalDate.now();

        LocalDateTime startOfWeek = today
                .with(DayOfWeek.MONDAY)
                .atStartOfDay();

        LocalDateTime startOfNextWeek = startOfWeek.plusWeeks(1);

        long count = taskRepository.countByCompletedTrueAndCompletedAtBetween(
                startOfWeek,
                startOfNextWeek
        );

        return Map.of("completedThisWeek", count);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(
            @PathVariable Long id,
            @RequestBody Task updatedTask
    ){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setDeadline(updatedTask.getDeadLine());

        return taskRepository.save(task);
    }

    @PatchMapping("/{id}/complete")
    public Task completeTask(@PathVariable Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setCompleted(true);
        task.setCompletedAt(LocalDateTime.now());

        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskRepository.deleteById(id);
    }
}
