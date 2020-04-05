package spring.state.machine.listener;

import java.util.logging.Logger;

import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

import spring.state.machine.statemachinedomain.MEvents;
import spring.state.machine.statemachinedomain.MStates;

public class StateMachineEventListener
        extends StateMachineListenerAdapter<MStates, MEvents> {

    private Logger log = Logger.getLogger(StateMachineEventListener.class.getName());

    @Override
    public void stateChanged(State<MStates, MEvents> from, State<MStates, MEvents> to) {
        //	log.info(from +"  "+ to );
    }

    @Override
    public void stateEntered(State<MStates, MEvents> state) {
        log.info("State Entered " + state.getId());
    }

    @Override
    public void stateExited(State<MStates, MEvents> state) {
        log.info("State Exited " + state.getId());
    }

    @Override
    public void transition(Transition<MStates, MEvents> transition) {
        //	log.info("State transition SOURCE "+ transition.getSource() + " TARGET " + transition.getTarget());
    }

    @Override
    public void transitionStarted(Transition<MStates, MEvents> transition) {
        //log.info("State transitionStarted SOURCE "+ transition.getSource() + " TARGET " + transition.getTarget());
    }

    @Override
    public void transitionEnded(Transition<MStates, MEvents> transition) {
        //log.info("State transitionEnded SOURCE "+ transition.getSource() + " TARGET " + transition.getTarget());
    }

    @Override
    public void stateMachineStarted(StateMachine<MStates, MEvents> stateMachine) {
        //log.info(stateMachine.getId() + "Started the state machine");
    }

    @Override
    public void stateMachineStopped(StateMachine<MStates, MEvents> stateMachine) {
        //log.info(stateMachine.getId() + "Stopped the state machine");
    }
}