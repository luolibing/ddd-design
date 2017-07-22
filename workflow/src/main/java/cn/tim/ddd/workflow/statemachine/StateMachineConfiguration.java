package cn.tim.ddd.workflow.statemachine;


import cn.tim.ddd.workflow.domains.afs.enums.Events;
import cn.tim.ddd.workflow.domains.afs.enums.States;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.stereotype.Component;

import java.util.EnumSet;

/**
 * User: luolibing
 * Date: 2017/7/22 15:23
 */
@Component
public class StateMachineConfiguration implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public States stateChange(States initStates, Events events) {
        try {
            StateMachine<States, Events> stateMachine = buildMachine(initStates);
            stateMachine.start();
            stateMachine.sendEvent(events);
            return stateMachine.getState().getId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private StateMachine<States, Events> buildMachine(States initStates) throws Exception {
        StateMachineBuilder.Builder<States, Events> builder = StateMachineBuilder.builder();
        builder.configureConfiguration().withConfiguration().beanFactory(applicationContext.getAutowireCapableBeanFactory());

        builder.configureStates()
                .withStates()
                .initial(initStates)
                .states(EnumSet.allOf(States.class));

        builder.configureTransitions()
                .withExternal()
                .source(States.CREATED).target(States.WAIT_SERVE_AUDIT)
                .event(Events.START_PROCESS)
                .and()
                .withExternal()
                .source(States.WAIT_SERVE_AUDIT).target(States.WAIT_MANAGER_AUDIT)
                .event(Events.SERVE_AUDIT_PASS)
                .and()
                .withExternal()
                .source(States.WAIT_SERVE_AUDIT).target(States.CLOSED)
                .event(Events.SERVE_AUDIT_REJECT)
                .and()
                .withExternal()
                .source(States.WAIT_MANAGER_AUDIT).target(States.WAIT_REFUND)
                .event(Events.MANAGER_AUDIT_PASS)
                .and()

                .withExternal()
                .source(States.WAIT_MANAGER_AUDIT).target(States.CLOSED)
                .event(Events.MANAGER_AUDIT_REJECT)
                .and()

                .withExternal()
                .source(States.WAIT_REFUND).target(States.FINISHED)
                .event(Events.REFUND)
                ;

        return builder.build();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
