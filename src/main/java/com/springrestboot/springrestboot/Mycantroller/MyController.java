/*package com.springrestboot.springrestboot.Mycantroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrestboot.springrestboot.entities.Course;
import com.springrestboot.springrestboot.services.CourseService;

@RestController
public class MyController {
	@Autowired
	private CourseService courseService;
	@GetMapping("/home")
	public String home() {
	return "Welcome to courses application";	
		
	}
	
	//get the courses
	@GetMapping("/Courses")
	public List<Course> getCourse()
	{
		return this.courseService.getCourses();
	}

}*/



package com.springrestboot.springrestboot.Mycantroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springrestboot.springrestboot.entities.Course;
import com.springrestboot.springrestboot.services.CourseService;
@RestController
public class MyController {
	@Autowired
	private CourseService CourseService;
	
	@GetMapping("/home")
	public String home() {
		
		return"this is a home page";
	}
	
	//get the courses
	
	@GetMapping("/courses")
	public List <Course> getCourse()
	{
		return this.CourseService.getCourses();
	}
	//
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId)
	{
	 return	this.CourseService.getCourse(Long.parseLong(courseId));
	}
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course)
	{
		return this.CourseService.addCourse(course);
	}
	
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course)
	{
		return this.CourseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
   public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String CourseId )
  
	{
	try	{
	this.CourseService.deleteCourse(Long.parseLong(CourseId));
	   return new ResponseEntity<>(HttpStatus.OK);
   } catch (Exception e) {
	   return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
   }
	}
}