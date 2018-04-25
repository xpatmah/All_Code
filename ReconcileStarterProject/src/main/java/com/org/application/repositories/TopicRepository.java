package com.org.application.repositories;

import org.springframework.data.repository.CrudRepository;

import com.org.application.domain.Topic;

public interface TopicRepository extends CrudRepository<Topic, Integer>{

}
