package com.shuaiyin.studyplanner.repository;

import com.shuaiyin.studyplanner.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByCompleted(boolean completed);
}
