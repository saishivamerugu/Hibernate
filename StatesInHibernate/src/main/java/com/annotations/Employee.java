package com.annotations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
// It thinks Employee as the table
	// when we are using the class name not same as the data base
	// Then we has to say like @Table(name = "employees") say our table name 
	// we are saying the table is employees not the employee
	// when the class name and the class name not same we implement the above 
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// We have the autoIncrement in the mysql and we can add to the column in java
	//	take a constructor without a id 
	// when i insert the data it automatically gets the id to the data 
	// The id is given by the sql and the id given by java when i run one by one it will give 0
	// Now it has to also should be known by the java that what the sql is giving the id 
	// add the annotation @GeneratedValue(stratergy = "GenerationType.IDENTITY");
	// and after mysql setting the id the annotaion gets the value and it binds it with the java object
	// to use it autoincrmenet should be done in mysql
	
	
	
	// if the column is different 
	// first change the column name in the database or the given class 
	// if any of them is not same then it will throw an exception
	// Unkonwn column exception in the 
// to solve this problem just add @Column(name = "sal")
	@Column(name = "sal")
	private double salary;
}
