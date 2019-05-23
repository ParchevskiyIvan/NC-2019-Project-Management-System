package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskRepository extends PagingAndSortingRepository<TaskEntity, Integer> {
    TaskEntity findTaskById(Integer id);
    Iterable<TaskEntity> findTasksByProjectId(Integer Projects_id);
    Page<TaskEntity> findTasksByStatusId(Integer Status_id, Pageable pageable);
    Page<TaskEntity> findTasksByAssigneeId(Integer Assignee_id1, Pageable pageable);
    Page<TaskEntity> findTasksByAssigneeIdAndStatusId(Integer Assignee_id1, Integer Status_id, Pageable pageable);
}
