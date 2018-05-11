package com.awews.courseapiwithdata.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics() {
//		return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
			.forEach(topics::add);
		return topics;
	}
	
	public Topic getTopicById(String id) {
//		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}
	
//	doesn't work
	public Topic getTopicByName(String name) {
//		return topics.stream().filter(n -> n.getName().equals(name)).findFirst().get();
		return topicRepository.findOne(name);
		
	}

	public Topic addTopic(Topic topic) {
		// TODO Auto-generated method stub
//		topics.add(topic);
//		return topic;
		topicRepository.save(topic);
		return topic;
		
	}

	public Topic updateTopic(String id, Topic topic) {
		// TODO Auto-generated method stub
//		for(int i = 0; i < topics.size(); i++) {
//			Course t = topics.get(i);
//			if (t.getId().equals(id)) {
//				topics.set(i, topic);
//				return topic;
//			}
//		}
//		return topic;
		return topicRepository.save(topic);
	}

//	public Course deleteTopic(String id) {
//		Course topic = null;
//		// TODO Auto-generated method stub
//		topics.removeIf(t -> t.getId().equals(id));
//		
//		return topic;
//	}
	
	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
//		topics.removeIf(t -> t.getId().equals(id));
		topicRepository.delete(id);
		
	}

}
