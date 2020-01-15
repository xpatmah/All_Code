package spring.state.machine.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import spring.state.machine.listener.OrderStateMachineListener;
import spring.state.machine.statemachinedomain.Events;
import spring.state.machine.statemachinedomain.States;

//@Configuration
//@EnableStateMachine
public class StateMachineConfigRegion extends EnumStateMachineConfigurerAdapter<States, Events> {

	@Override
	public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
		config.
			withConfiguration().
				autoStartup(true)
				.listener(new OrderStateMachineListener());
	}

	@Override
	public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
		states
		.withStates()
			.initial(States.SI)
			.state(States.S1)
			.and()
			.withStates()
				.parent(States.S1)
				.initial(States.S2I)
				.state(States.S2I)
				.end(States.S2F)
			.and()
			.withStates()
				.parent(States.S1)
				.initial(States.S3I)
				.state(States.S3I)
				.end(States.S2FF);
	
	}

	@Override
	public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
		/*
		 * transitions .withExternal()
		 * .source(States.SI).target(States.S1).event(Events.E1) .and() .withExternal()
		 * .source(States.S1).target(States.S2).event(Events.E2) .and() .withExternal()
		 * .source(States.S2).target(States.SF);
		 */
	}

	
	
}
