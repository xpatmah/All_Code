package spring.java.testpring.component;

import org.springframework.stereotype.Component;

import com.org.spring.faces.FortuneService;

@Component("happyFortuneService")
public class HappyFortuneService implements FortuneService {

	public String getLuckyDay() {
		// TODO Auto-generated method stub
		return "Today is Your lucky Day";
	}

}
