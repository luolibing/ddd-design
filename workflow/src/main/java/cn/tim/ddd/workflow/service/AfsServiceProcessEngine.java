package cn.tim.ddd.workflow.service;

import cn.tim.ddd.workflow.config.TransactionTemplateHelper;
import cn.tim.ddd.workflow.domains.afs.enums.States;
import cn.tim.ddd.workflow.domains.afs.form.ProcessForm;
import cn.tim.ddd.workflow.domains.afs.task.AfsServiceTask;
import cn.tim.ddd.workflow.domains.afs.task.AfsTask;
import cn.tim.ddd.workflow.entity.AfsService;
import cn.tim.ddd.workflow.entity.jpa.AfsServiceJpaRepository;
import cn.tim.ddd.workflow.entity.jpa.AfsTaskJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by luolibing on 2017/7/23.
 */
@Component
public class AfsServiceProcessEngine {

    @Autowired
    private TaskMapping taskMapping;

    @Autowired
    private AfsServiceJpaRepository afsServiceJpaRepository;

    @Autowired
    private TransactionTemplateHelper transactionTemplateHelper;

    @Autowired
    private AfsTaskJpaRepository afsTaskJpaRepository;


    public void process(ProcessForm processForm, States states) {
        // 表单验证
        processForm.validate();

        // 映射任务
        List<AfsTask> taskList = taskMapping.getTaskList(states);
        if(CollectionUtils.isEmpty(taskList)) {
            throw new RuntimeException();
        }

        AfsService afsService = afsServiceJpaRepository.findOne(processForm.getId());

        // 执行流程任务
        doProcess(processForm, afsService, taskList);

    }

    private void doProcess(ProcessForm processForm, AfsService afsService, List<AfsTask> taskList) {
        transactionTemplateHelper.getTransactionTemplate().execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                for(AfsTask afsTask : taskList) {
                    afsTask.execute(processForm, afsService);
                }

                States leastState = States.findByValue(afsService.getStatus());
                List<AfsTask> nextTaskList = taskMapping.getTaskList(leastState);
                saveLeastServiceTask(nextTaskList, afsService.getId(), leastState);
            }
        });

    }


    private void saveLeastServiceTask(List<AfsTask> afsTaskList, Long id, States leastState) {
        if(!CollectionUtils.isEmpty(afsTaskList)) {
            for(AfsTask afsTask : afsTaskList) {
                if(afsTask instanceof AfsServiceTask) {
                    cn.tim.ddd.workflow.entity.AfsTask t = new cn.tim.ddd.workflow.entity.AfsTask();
                    t.setCreated(new Date());
                    t.setFinished(0);
                    t.setServiceId(id);
                    t.setEventType(leastState.name());
                    afsTaskJpaRepository.save(t);
                }
            }
        }
    }
}
