package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(145, "Core Java Course", "this course contains basics of Java"));
		list.add(new Course(4343, "Spring Boot Course", "creating REST api using spring boot"));
		list.add(new Course(423, "React JS Course", "this course contains basics of React JS"));
		
	}
	
	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		Course c = null;
		for(Course course: list) {
			if(course.getId() == courseId) {
				c = course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		for(Course c: list) {
			if(course.getId() == c.getId()) {
				c.setTitle(course.getTitle());
				c.setDescription(course.getDescription());
				break;
			}
		}
		return course;
	}

	@Override
	public Course deleteCourse(long courseId) {
		Course del = new Course();
		for(Course c: list) {
			if(c.getId() == courseId) {
				del = c;
				break;
			}
		}
		list.remove(del);
		return del;
	}

}