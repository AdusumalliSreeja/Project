package com.klef.jfsd.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klef.jfsd.project.model.Customer;
import com.klef.jfsd.project.model.Task;


@Service
public interface TaskService 
{
      public String createtasks(Task t);
      public List<Task> viewtasks();
      public String managetasks(int tid);
    
}