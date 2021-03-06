package com.Spring_boot.CRUD_Operation.CRUDOperation.CurdService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring_boot.CRUD_Operation.CRUDOperation.CurdRepository.StudentCurdRepository;
import com.Spring_boot.CRUD_Operation.CRUDOperation.model.Student;

@Service
public class CrudService {
	
	@Autowired
	private StudentCurdRepository studentCurdRepository;
	
	public List <Student> fetchallstudentlist()
	{
		return studentCurdRepository.findAll();
	}

	public Student savestudenttoDB(Student student)
	{
		return studentCurdRepository.save(student);
	}
	public Optional<Student> fetchstudentbyID(int id)
	{	
		
		return studentCurdRepository.findById(id);
	}
	public String DeleteStudentByID(int id)
	{	
		String result;
		try{
		studentCurdRepository.deleteById(id);
		result = "Student Sucessfully Deleted";
		}
		catch(Exception e){
			result = "ID is not valid";
			
		}
		return result;
		}
}
