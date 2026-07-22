package com.shuaiyin.studyplanner.repository;

import com.shuaiyin.studyplanner.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
