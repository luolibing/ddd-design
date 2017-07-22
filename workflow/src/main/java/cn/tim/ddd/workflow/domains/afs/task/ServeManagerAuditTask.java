package cn.tim.ddd.workflow.domains.afs.task;

import cn.tim.ddd.workflow.domains.afs.enums.Events;
import cn.tim.ddd.workflow.domains.afs.enums.States;
import cn.tim.ddd.workflow.domains.afs.form.ProcessForm;
import cn.tim.ddd.workflow.domains.afs.form.ServeManagerAuditForm;
import cn.tim.ddd.workflow.entity.AfsService;
import cn.tim.ddd.workflow.entity.jpa.AfsServiceJpaRepository;
import cn.tim.ddd.workflow.statemachine.StateMachineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Created by luolibing on 2017/7/23.
 */
@Component
public class ServeManagerAuditTask extends AfsUserTask {

    @Autowired
    private StateMachineConfiguration stateMachineConfiguration;

    @Autowired
    private AfsServiceJpaRepository afsServiceJpaRepository;

    @Override
    public Object execute(ProcessForm processForm, AfsService afsService) {
        ServeManagerAuditForm serveManagerAuditForm = (ServeManagerAuditForm) processForm;
        Boolean audit = serveManagerAuditForm.getAudit();
        Events events = audit ? Events.MANAGER_AUDIT_PASS : Events.MANAGER_AUDIT_REJECT;
        States states = stateMachineConfiguration.stateChange(States.findByValue(afsService.getStatus()), events);
        afsService.setStatus(states.value());

        return afsServiceJpaRepository.save(afsService);
    }

    @Override
    public List<States> interestedStates() {
        return Collections.singletonList(States.WAIT_MANAGER_AUDIT);
    }
}
