package com.klef.jfsd.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.project.model.Task;
import com.klef.jfsd.project.repository.AdminRepository;
import com.klef.jfsd.project.repository.CustomerRepository;
import com.klef.jfsd.project.repository.TaskRepository;

@Service
public class TaskServiceImpl  implements TaskService
{
  
  @Autowired
   private AdminRepository adminRepository;
   
  @Autowired
  private CustomerRepository customerRepository;
  
  @Autowired
  private TaskRepository taskRepository;

  @Override
  public String createtasks(Task t) {
     taskRepository.save(t);
       return "Saved Successfully";
  }

  @Override
  public List<Task> viewtasks() {
    return taskRepository.findAll();
  }

  @Override
  public String managetasks(int tid) {
    Optional<Task> obj = taskRepository.findById(tid);
        
        String msg = null;
        
        if(obj.isPresent())
        {
          Task t = obj.get();
          taskRepository.delete(t);
          msg = "Task Deleted Successfully";
        }
        else
        {
          msg = "Task Not Found";
        }
        
        return msg;
  }

  }