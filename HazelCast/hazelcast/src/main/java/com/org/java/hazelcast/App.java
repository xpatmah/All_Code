package com.org.java.hazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Configuration
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    
    @Bean(destroyMethod="shutdown")
    public HazelcastInstance creatSingleNode() throws Exception{
    	return Hazelcast.newHazelcastInstance();
    }
}
