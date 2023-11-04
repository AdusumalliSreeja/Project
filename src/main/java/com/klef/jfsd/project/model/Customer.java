package com.klef.jfsd.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer_table")
public class Customer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_id")
private int id;
	@Column(name="c_name",nullable=false,length = 50)
private String name;
	 @Column(name="c_gender",nullable=false,length = 10)
private String gender;
@Column(name = "c_dob",nullable=false,length = 20) 
private String dateofbirth; 
@Column(name="c_email",nullable=false,unique = true,length = 30)
private String email;
@Column(name="c_password",nullable=false,length = 30)
private String password;
@Column(name="c_location",nullable=false)
private String location;
@Column(name="c_contactno",nullable=false,unique = true)
private String contactno;
@Column(name="c_active",nullable=false)
private boolean active;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getDateofbirth() {
	return dateofbirth;
}
public void setDateofbirth(String dateofbirth) {
	this.dateofbirth = dateofbirth;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getContactno() {
	return contactno;
}
public void setContactno(String contactno) {
	this.contactno = contactno;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}
@Override
public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", gender=" + gender + ", dateofbirth=" + dateofbirth + ", email="
			+ email + ", password=" + password + ", location=" + location + ", contactno=" + contactno + ", active="
			+ active + "]";
}

}
