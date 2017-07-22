package cn.tim.ddd.workflow.process;

import cn.tim.ddd.workflow.WorkflowApplication;
import cn.tim.ddd.workflow.domains.afs.enums.States;
import cn.tim.ddd.workflow.domains.afs.form.ServeAuditForm;
import cn.tim.ddd.workflow.domains.afs.form.ServeManagerAuditForm;
import cn.tim.ddd.workflow.domains.afs.form.StartProcessForm;
import cn.tim.ddd.workflow.entity.AfsService;
import cn.tim.ddd.workflow.entity.jpa.AfsServiceJpaRepository;
import cn.tim.ddd.workflow.service.AfsServiceProcessEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by luolibing on 2017/7/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WorkflowApplication.class)
public class AfsServiceProcessEngineTest {

    @Autowired
    private AfsServiceProcessEngine processEngine;

    @Autowired
    private AfsServiceJpaRepository afsServiceJpaRepository;

    @Test
    public void startProcess() {
        AfsService afsService = insert();
        StartProcessForm form = new StartProcessForm();
        form.setId(afsService.getId());
        form.setUser("admin");
        form.setStates(States.CREATED);
        processEngine.process(form, States.CREATED);

        ServeAuditForm serveAuditForm = new ServeAuditForm();
        serveAuditForm.setAudit(true);
        serveAuditForm.setUser("admin");
        serveAuditForm.setStates(States.WAIT_SERVE_AUDIT);
        serveAuditForm.setId(afsService.getId());
        processEngine.process(serveAuditForm, States.WAIT_SERVE_AUDIT);


        ServeManagerAuditForm serveManagerAuditForm = new ServeManagerAuditForm();
        serveManagerAuditForm.setAudit(true);
        serveManagerAuditForm.setUser("admin");
        serveManagerAuditForm.setStates(States.WAIT_MANAGER_AUDIT);
        serveManagerAuditForm.setId(afsService.getId());
        processEngine.process(serveManagerAuditForm, States.WAIT_MANAGER_AUDIT);
    }

    private AfsService insert() {
        AfsService afsService = new AfsService();
        afsService.setStatus(States.CREATED.value());
        afsService.setName("售后服务单");
        afsService.setCreated(new Date());
        return afsServiceJpaRepository.save(afsService);
    }
}
