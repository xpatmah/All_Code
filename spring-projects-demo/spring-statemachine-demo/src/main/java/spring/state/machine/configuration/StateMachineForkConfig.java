package spring.state.machine.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;

import spring.state.machine.listener.PosStateMachineListener;
import spring.state.machine.statemachinedomain.MEvents;
import spring.state.machine.statemachinedomain.MStates;

//@Configuration
//@EnableStateMachine
public class StateMachineForkConfig extends EnumStateMachineConfigurerAdapter<MStates, MEvents> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<MStates, MEvents> config) throws Exception {
        config.
                withConfiguration()
                .autoStartup(true)
                .listener(new PosStateMachineListener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<MStates, MEvents> states) throws Exception {
        states.
                withStates()
                .initial(MStates.RECEIVED)
                .state(MStates.VALIDATION)
                //.choice(MStates.VALIDATION)
                .end(MStates.POSFAIL)
                .end(MStates.POSPASS)
                .and()
                //	.withStates()

                //.state(MStates.VALIDATION,,null)
                /*
                 * .state(MStates.VALIDATION_OK,new Action<MStates, MEvents>(){
                 *
                 * @Override public void execute(StateContext<MStates, MEvents> context) {
                 * context.getExtendedState().getVariables().get("CACHE"); //
                 * context.getStateMachine().sendEvent(MEvents.VAL_OK); } },null)
                 * .end(MStates.VALIDATION_ERROR)
                 */
                //	.and()
                .withStates()
                .state(MStates.INIT_PROCESS, new Action<MStates, MEvents>() {
                    @Override
                    public void execute(StateContext<MStates, MEvents> context) {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        //context.getStateMachine().sendEvent(MEvents.VAL_OK);
                        System.out.println("ENTERED INIT_PORCESS");
                    }
                }, null)
                //.state(MStates.INIT_PROCESS)
                .fork(MStates.REF_TRANS_FORK)
                .join(MStates.REF_TRANS_FORK_JOIN)
                .end(MStates.INIT_PROCESS_COMPLETE)
                .and()
                .withStates()
                .parent(MStates.INIT_PROCESS)
                .initial(MStates.REF_DATA_PROCESS, new Action<MStates, MEvents>() {
                    @Override
                    public void execute(StateContext<MStates, MEvents> context) {
                        try {
                            Thread.sleep(20000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        context.getStateMachine().sendEvent(MEvents.REF_DATA_OK);
                    }
                })
                .end(MStates.REF_DATA_PROCESS_COMPLETE)
                .and()
                .withStates()
                .parent(MStates.INIT_PROCESS)
                .initial(MStates.TRANS_DATA_PROCESS, new Action<MStates, MEvents>() {
                    @Override
                    public void execute(StateContext<MStates, MEvents> context) {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        //context.getStateMachine().sendEvent(MEvents.VAL_OK);
                        System.out.println("ENTERED TRANS DATA PROCESS");
                    }
                })
                //.state(MStates.TRANS_DATA_PROCESS)
                .fork(MStates.TRANS_FORK)
                .join(MStates.TRANS_FORK_JOIN)
                .end(MStates.TRANS_DATA_PROCESS_COMPLETE)
                .and()
                .withStates()
                .parent(MStates.TRANS_DATA_PROCESS)
                .initial(MStates.TRANS_TLIVE, new Action<MStates, MEvents>() {
                    @Override
                    public void execute(StateContext<MStates, MEvents> context) {
                        try {
                            Thread.sleep(20000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        context.getStateMachine().sendEvent(MEvents.TRASTLIVE_OK);
                    }
                })
                .end(MStates.TRANS_TLIVE_COMPLETE)
                .and()
                .withStates()
                .parent(MStates.TRANS_DATA_PROCESS)
                .initial(MStates.TRANS_TPLIVE, new Action<MStates, MEvents>() {
                    @Override
                    public void execute(StateContext<MStates, MEvents> context) {

                        try {
                            Thread.sleep(20000);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        context.getStateMachine().sendEvent(MEvents.TRASTPLIVE_OK);
                    }
                })
                .end(MStates.TRANS_TPLIVE_COMPLETE);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<MStates, MEvents> transitions) throws Exception {
        transitions
                .withExternal()
                .source(MStates.RECEIVED).target(MStates.VALIDATION)
                .and()
                .withExternal()
                .source(MStates.VALIDATION)
                .target(MStates.VALIDATION_OK).event(MEvents.VAL_OK).guard(guard())
                .and()
                .withExternal()
                .source(MStates.VALIDATION_OK).target(MStates.VALIDATION_ERROR).guardExpression("false")
                .and()
                .withExternal()
                .source(MStates.VALIDATION_OK).target(MStates.INIT_PROCESS).guardExpression("true")
                .and()
                .withFork()
                .source(MStates.REF_TRANS_FORK).target(MStates.REF_DATA_PROCESS).target(MStates.TRANS_DATA_PROCESS)
                .and()
                .withJoin()
                .source(MStates.REF_DATA_PROCESS_COMPLETE).source(MStates.TRANS_DATA_PROCESS_COMPLETE).target(MStates.REF_TRANS_FORK_JOIN)
                .and()
                .withFork()
                .source(MStates.TRANS_FORK).target(MStates.TRANS_TLIVE).target(MStates.TRANS_TPLIVE)
                .and()
                .withJoin()
                .source(MStates.TRANS_TLIVE_COMPLETE).source(MStates.TRANS_TPLIVE_COMPLETE).target(MStates.TRANS_FORK_JOIN)
                .and()
                .withExternal()
                .source(MStates.INIT_PROCESS).target(MStates.REF_TRANS_FORK)
                .and()
                .withExternal()
                .source(MStates.REF_TRANS_FORK_JOIN).target(MStates.INIT_PROCESS_COMPLETE)
                .and()
                .withExternal()
                .source(MStates.REF_DATA_PROCESS).target(MStates.REF_DATA_PROCESS_COMPLETE).event(MEvents.REF_DATA_OK)
                .and()
                .withExternal()
                .source(MStates.TRANS_DATA_PROCESS).target(MStates.TRANS_FORK)
                .and()
                .withExternal()
                .source(MStates.TRANS_FORK_JOIN).target(MStates.TRANS_DATA_PROCESS_COMPLETE)
                .and()
                .withExternal()
                .source(MStates.TRANS_TLIVE).target(MStates.TRANS_TLIVE_COMPLETE).event(MEvents.TRASTLIVE_OK)
                .and()
                .withExternal()
                .source(MStates.TRANS_TPLIVE).target(MStates.TRANS_TPLIVE_COMPLETE).event(MEvents.TRASTPLIVE_OK)
                .and()
                .withExternal()
                .source(MStates.INIT_PROCESS_COMPLETE).target(MStates.POSPASS);
        ;

    }

    @Bean
    public Guard<MStates, MEvents> guard() {
        return new Guard<MStates, MEvents>() {

            @Override
            public boolean evaluate(StateContext<MStates, MEvents> context) {
                return true;
            }
        };
    }


}
