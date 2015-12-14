package com.pramati.simplehibernatemaven.model;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_information")
public class StudentInformation {
	@Id @GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	Date dateOfBirth;
	String studentName;
	
	@Override
    public String toString()
    {
    	return "ClassPojo [Student Name = "+studentName+"  Date of Birth = "+dateOfBirth+"]";
    }
}
