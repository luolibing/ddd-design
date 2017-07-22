package cn.tim.ddd.workflow.domains.afs.task;

import cn.tim.ddd.workflow.domains.afs.enums.States;
import cn.tim.ddd.workflow.domains.afs.form.ProcessForm;
import cn.tim.ddd.workflow.entity.AfsService;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Created by luolibing on 2017/7/23.
 */
@Component
public class RefundServiceTask extends AfsServiceTask {


    @Override
    public Object execute(ProcessForm processForm, AfsService afsService) {
        System.out.println("发起退款");
        return null;
    }

    @Override
    public List<States> interestedStates() {
        return Collections.singletonList(States.WAIT_REFUND);
    }
}
