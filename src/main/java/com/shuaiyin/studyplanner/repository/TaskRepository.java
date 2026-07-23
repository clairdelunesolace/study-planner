package com.shuaiyin.studyplanner.repository;

import com.shuaiyin.studyplanner.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.time.LocalDateTime;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByCompleted(boolean completed);

    long countByCompletedTrueAndCompletedAtBetween(
            LocalDateTime start,
            LocalDateTime end
    );
}
