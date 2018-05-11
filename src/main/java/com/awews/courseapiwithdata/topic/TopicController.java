package com.awews.courseapiwithdata.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopicById(@PathVariable String id) {
		return topicService.getTopicById(id);
	}
	
	@RequestMapping("/topics/name/{name}")
	public Topic getTopicByName(@PathVariable String name) {
		return topicService.getTopicByName(name);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public Topic addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		return topic;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public Topic updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
		return topic;
	}
	
//	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
//	public Course deleteTopic(@PathVariable String id) {
//		topicService.deleteTopic(id);
//		Course topic = null;
//		return topic;
//	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);

	}

}
