package spring.java.testpring.component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.org.spring.faces.Coach;
import com.org.spring.faces.FortuneService;

@Component("tenissCoach")
public class TenisCoach implements Coach{

	/*@Autowired
	FortuneService happyFortuneService;
	@Autowired
	FortuneService sadFortuneService;*/
	@Autowired
	@Qualifier("sadFortuneService")
	FortuneService fortuneService;
	
	public FortuneService getSadFortuneService() {
		return fortuneService;
	}

	public void setSadFortuneService(FortuneService sadFortuneService) {
		this.fortuneService = sadFortuneService;
	}

    @PostConstruct
	public void intMehtod() {
		System.out.println("This is the initialize method");
	}

    @PreDestroy
	public void NotintMehtod() {
		System.out.println("This is the Destroy method");
	}
	
/*	@Autowired
	public TenisCoach(FortuneService fortuneServer) {
		// TODO Auto-generated constructor stub
		this.fortuneServer = fortuneServer;
	}
*/	
	
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Practice daily backhand";
	}

	public String getTodayFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getLuckyDay();
	}

} 
