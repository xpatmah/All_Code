package spring.java.testpring.component;

import org.springframework.stereotype.Component;

import com.org.spring.faces.FortuneService;

@Component("sadFortuneService")
public class SadFortuneService implements FortuneService {

	public String getLuckyDay() {
		return "Today Is not Your Lucky Day";
	}

}
