package spring.state.machine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.state.machine.listener.StateMachineEventListener;
import spring.state.machine.statemachinedomain.MEvents;
import spring.state.machine.statemachinedomain.MStates;

@RestController
public class AppController {

	@Autowired
	private StateMachine<MStates, MEvents> stateMachine;
	
	@RequestMapping(value="/test" , method=RequestMethod.GET)
	public String getThanksMessage() {
		
		stateMachine.addStateListener(new StateMachineEventListener());
		
		stateMachine.start();
		
		stateMachine.sendEvent(MEvents.VAL_OK);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//stateMachine.sendEvent(Events.COIN);
		
		return "Thanks User";
	}
	
	
}
