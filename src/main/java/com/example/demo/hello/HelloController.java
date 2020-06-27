package com.example.demo.hello;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloController {

	List<Student> al = new ArrayList<Student>();
	
	//Get all students
	@GetMapping("/students")
	public List<Student> getAllStudents()
	{
		
		return al;
	}
	
	//Get single student
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable String id)
	{
		Student res=null;
		for(Student s : al)
		{
			if(s.getId().equals(id))
			{
				res= s;
				break;
			}
		}
		return res;
	}
	
	//Add student
	@RequestMapping(method = RequestMethod.POST, value = "/students")
	public String addStudent(@RequestBody Student student)
	{
		al.add(student);
		return "Data Inserted";
	}
	
	
	//Update student
	@RequestMapping(method = RequestMethod.PUT, value = "/students/{id}")
	public String updateStudent(@RequestBody Student student,@PathVariable String id )
	{
		for(int i = 0 ; i < al.size(); i++)
		{
			Student s = al.get(i);
			if(s.getId().equals(id))
			{
				al.set(i, student);
				
				
			}
		}
		
		return "Data Updated";
	}
	
	// Delete Student
	@RequestMapping(method = RequestMethod.DELETE, value = "/students/{id}")
	public String deleteStudent(@PathVariable String id)
	{
		al.removeIf(t-> t.getId().equals(id));
		
		return "Data Deleted";
		
	}


	
}
