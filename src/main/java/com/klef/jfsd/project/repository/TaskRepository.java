package com.klef.jfsd.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.project.model.Customer;
import com.klef.jfsd.project.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>
{

}