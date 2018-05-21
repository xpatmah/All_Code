package com.org.application.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.application.domain.Topic;
import com.org.application.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
    @RequestMapping(value="/topics/{topicId}",method=RequestMethod.GET)
    public Topic getTopic(@PathVariable(value="topicId") Integer topicId) {
        return topicService.getTopic(topicId);
    }
    
    @RequestMapping(value="/alltopics",method=RequestMethod.GET)
    public List<Topic> getAllTopics(){
    	return topicService.getAllTopics();
    }
    
    @RequestMapping(method=RequestMethod.POST,value="/addtopics")
    public void addTopic(@RequestBody Topic topic) {
    	topicService.add(topic); 
    }
   
    @RequestMapping(method=RequestMethod.PUT,value="/updatetopics")
    public void updateTopic(@RequestBody Topic topic) {
    	topicService.update(topic);
    }
    
    @RequestMapping(method=RequestMethod.DELETE,value="/delete/{topicId}")
    public void delete(@PathVariable(value="topicId") Integer topicId ) {
    	topicService.delete(topicId);
    }
    
}