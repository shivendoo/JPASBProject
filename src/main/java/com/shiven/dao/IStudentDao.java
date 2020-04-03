package com.shiven.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shiven.Student;



public interface IStudentDao extends JpaRepository<Student, Integer> {

	List<Student> findByAge(int age); 
	List<Student> findByName(String name);
	List<Student> findByAgeGreaterThan(int age); 
	List<Student> findByAgeLessThan(int age); 
	
	//@Query("from Student where age>?1 and order by name")
	//List<Student> findByAgeShorted(int age); 
	
	
	
}
