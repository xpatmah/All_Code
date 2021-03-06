package spring.state.machine.configuration;

import java.util.EnumSet;

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
public class StateMachineConfigTransition extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
        config.
                withConfiguration().
                autoStartup(true)
                .listener(new OrderStateMachineListener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states.
                withStates()
                .initial(States.S1)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions
                .withExternal()
                .source(States.S1).target(States.S2).event(Events.E1)
                .and()
                .withInternal()
                .source(States.S2).event(Events.E2)
                .and()
                .withLocal()
                .source(States.S2).target(States.S3).event(Events.E3);

    }


}
