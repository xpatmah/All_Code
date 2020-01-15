package com.org.spring.bean.component;

import org.springframework.stereotype.Component;

import com.org.spring.interfaces.FortuneService;

@Component("sadFortuneService")
public class SadFortuneService implements FortuneService {

	public String getLuckyDay() {
		return "Today Is not Your Lucky Day";
	}

}
