package spring.state.machine.listener;

import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import spring.state.machine.statemachinedomain.Events;
import spring.state.machine.statemachinedomain.MEvents;
import spring.state.machine.statemachinedomain.MStates;
import spring.state.machine.statemachinedomain.States;

public class PosStateMachineListener extends StateMachineListenerAdapter<MStates, MEvents> { 
  @Override 
  public void stateChanged(State<MStates, MEvents> from, State<MStates, MEvents> to) {
    System.out.println("Order state changed from" +" "+ from+" "+ "to " + to.getId()); 
  }
}