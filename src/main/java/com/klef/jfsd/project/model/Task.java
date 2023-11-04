package com.klef.jfsd.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="task_table")
public class Task 
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(nullable=false)
private String title;
@Column(nullable=false)
private String ddate;
@Column(nullable=false)
private String description;
public int getId() {
  return id;
}
public void setId(int id) {
  this.id = id;
}
public String getTitle() {
  return title;
}
public void setTitle(String title) {
  this.title = title;
}
public String getDdate() {
  return ddate;
}
public void setDdate(String ddate) {
  this.ddate = ddate;
}
public String getDescription() {
  return description;
}
public void setDescription(String description) {
  this.description = description;
}
@Override
public String toString() {
  return "Task [id=" + id + ", title=" + title + ", ddate=" + ddate + ", description=" + description + "]";
}
}