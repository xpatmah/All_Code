package spring.state.machine.listener;

import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import spring.state.machine.statemachinedomain.Events;
import spring.state.machine.statemachinedomain.States;

public class OrderStateMachineListener extends StateMachineListenerAdapter<States, Events> {

    @Override
    public void stateChanged(State<States, Events> from, State<States, Events> to) {
        System.out.println("Order state changed from" + " " + from + " " + "to " + to.getId());
    }
}