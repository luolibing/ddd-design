package cn.tim.ddd.workflow.domains.afs.task;

import cn.tim.ddd.workflow.domains.afs.enums.Events;
import cn.tim.ddd.workflow.domains.afs.enums.States;
import cn.tim.ddd.workflow.domains.afs.form.ProcessForm;
import cn.tim.ddd.workflow.entity.AfsService;
import cn.tim.ddd.workflow.entity.jpa.AfsServiceJpaRepository;
import cn.tim.ddd.workflow.statemachine.StateMachineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by luolibing on 2017/7/22.
 */
@Service
public class StartupTask extends AfsServiceTask {

    @Autowired
    private StateMachineConfiguration stateMachineConfiguration;

    @Autowired
    private AfsServiceJpaRepository afsServiceJpaRepository;


    @Override
    public Object execute(ProcessForm processForm, AfsService afsService) {
        States states = stateMachineConfiguration.stateChange(
                States.findByValue(afsService.getStatus()), Events.START_PROCESS);
        afsService.setStatus(states.value());
        afsServiceJpaRepository.save(afsService);
        return afsService;
    }

    @Override
    public List<States> interestedStates() {
        return Collections.singletonList(States.CREATED);
    }
}
