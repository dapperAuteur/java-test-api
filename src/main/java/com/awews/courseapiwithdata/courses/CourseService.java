package com.awews.courseapiwithdata.courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
			.forEach(courses::add);
		return courses;
	}
	
	public Course getCourseById(String id) {
		return courseRepository.findOne(id);
	}
	
//	doesn't work
//	public Course getCourseByName(String name) {
//		return courseRepository.findOne(name);
//		
//	}

	public Course addCourse(Course course) {
		courseRepository.save(course);
		return course;
		
	}

	public Course updateCourse(Course course) {
		return courseRepository.save(course);
	}
	
	public void deleteCourse(String id) {
		courseRepository.delete(id);
		
	}

}
