package com.springrestboot.springrestboot.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springrestboot.springrestboot.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long>{

}
