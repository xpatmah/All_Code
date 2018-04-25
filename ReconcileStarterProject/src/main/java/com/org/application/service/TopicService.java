package com.org.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.application.domain.Topic;
import com.org.application.repositories.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository repository;
	
	
	public List<Topic> getAllTopics() {
		// TODO Auto-generated method stub
		List<Topic> topicList = new ArrayList<Topic>();
		repository.findAll().forEach(topicList::add);
		return topicList;
	}


	public void add(Topic topic) {
		// TODO Auto-generated method stub
		repository.save(topic);
	}


	public void update(Topic topicId) {
		// TODO Auto-generated method stub
		repository.save(topicId);
	}


	public void delete(Integer topicId) {
		// TODO Auto-generated method stub
		repository.deleteById(topicId);
	}


	public Topic getTopic(Integer topicId) {
		// TODO Auto-generated method stub
		return repository.findById(topicId).get();
	}

}
