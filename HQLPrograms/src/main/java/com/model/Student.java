package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	
	private String name;
	
	private int marks;
	
	public Student() {
		
	}
	
	public Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
	

	public Student(int studentId, String name, int marks) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.marks = marks;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", marks=" + marks + "]";
	}
	
	
}
