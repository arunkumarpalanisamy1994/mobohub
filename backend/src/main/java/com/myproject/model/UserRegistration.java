package com.myproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRegistration {

@Column
String Name;
@Column
String SurName;
@Id
String YourEmail;
@Column
String Password;
@Column
String status="true";
@Column
String ROLE="ROLE-USER";
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getSurName() {
	return SurName;
}
public void setSurName(String surName) {
	SurName = surName;
}
public String getYourEmail() {
	return YourEmail;
}
public void setYourEmail(String yourEmail) {
	YourEmail = yourEmail;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getRole() {
	// TODO Auto-generated method stub
	return null;
}

}
