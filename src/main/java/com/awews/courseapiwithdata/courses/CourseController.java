package com.awews.courseapiwithdata.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.awews.courseapiwithdata.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourseById(@PathVariable String id) {
		return courseService.getCourseById(id);
	}
	
//	@RequestMapping("/topics/{id}/courses/name/{name}")
//	public Course getCourseByName(@PathVariable String name) {
//		return courseService.getCourseByName(name);
//	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public Course addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
		return course;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public Course updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
		return course;
	}
	
//	@RequestMapping(method=RequestMethod.DELETE, value="/courses/{id}")
//	public Course deleteCourse(@PathVariable String id) {
//		courseService.deleteCourse(id);
//		Course course = null;
//		return course;
//	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);

	}

}
