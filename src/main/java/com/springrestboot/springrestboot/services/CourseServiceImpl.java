package com.springrestboot.springrestboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestboot.springrestboot.dao.CourseDao;
import com.springrestboot.springrestboot.entities.Course;
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;
	
	//List<Course> list;
	
	public CourseServiceImpl() {
		
		//list=new ArrayList<>();
		//list.add(new Course(145,"java Core Course","This Course Cantains Basic of java"));
	   // list.add(new Course(4343,"Spring boot course","create rest api using spring boot"));
	    
	
	}
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		//return list;
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
	/*	Course c=null;
		for(Course course:list)
		{
			if(course.getId()==courseId)
			{
				c=course;
				break;
			}
		}*/
		//return c;
		return courseDao.getOne(courseId);
		
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
	//	list.add(course);
		courseDao.save(course);
		return course;
		}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
	//	list.forEach(e ->{ 
			//if(e.getId()==course.getId()) {
				//e.setTitle(course.getTitle());
				//e.setDescription(course.getDescription());
			//}
		//});
	        courseDao.save(course);
		return course;
		
	}

	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		//list=this.list.stream().filter(e->e.getId()!=parseLong).collect (Collectors.toList());
		Course entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}
	
	}


