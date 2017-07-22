package cn.tim.ddd.workflow.domains.afs.task;

import cn.tim.ddd.workflow.domains.afs.enums.States;
import cn.tim.ddd.workflow.domains.afs.form.ProcessForm;
import cn.tim.ddd.workflow.entity.AfsLog;
import cn.tim.ddd.workflow.entity.AfsService;
import cn.tim.ddd.workflow.entity.jpa.AfsLogJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by luolibing on 2017/7/22.
 */
@Order(value = Ordered.LOWEST_PRECEDENCE)
@Service
public class LogTask implements AfsTask {

    @Autowired
    private AfsLogJpaRepository afsLogJpaRepository;


    @Override
    public Object execute(ProcessForm processForm, AfsService afsService) {
        AfsLog afsLog = new AfsLog();
        afsLog.setCreated(new Date());
        afsLog.setUser(processForm.getUser());
        afsLog.setComment("生成服务单");
        afsLogJpaRepository.save(afsLog);
        return afsService;
    }

    @Override
    public List<States> interestedStates() {
        return Arrays.asList(States.values());
    }
}
