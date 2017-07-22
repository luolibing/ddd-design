package cn.tim.ddd.workflow.domains.afs.task;

import cn.tim.ddd.workflow.domains.afs.enums.States;
import cn.tim.ddd.workflow.domains.afs.form.ProcessForm;
import cn.tim.ddd.workflow.entity.AfsService;

import java.util.List;

/**
 * Created by luolibing on 2017/7/22.
 */
public abstract class AfsServiceTask implements AfsTask {

    public abstract Object execute(ProcessForm processForm, AfsService afsService);

    public abstract List<States> interestedStates();
}
