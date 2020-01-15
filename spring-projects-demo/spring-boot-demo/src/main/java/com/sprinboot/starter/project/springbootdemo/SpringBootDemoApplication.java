package com.sprinboot.starter.project.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sprinboot.starter.project.springbootdemo.jdbc.PersonJdbcDao;
import com.sprinboot.starter.project.springbootdemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner{

	//@Autowired
	//PersonJdbcDao dao;
	
	
	@Autowired
    PersonJpaRepository dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
        /*for(String name : context.getBeanDefinitionNames()) {System.out.println(name);}*/
	}

	@Override
	public void run(String... args) throws Exception {
		//logger.info("Starting the web app {} ",dao.findAll());
		logger.info("FIND user id by id {} and object {}",1002, dao.findById(1002));
		
	}
}
