package cn.tim.ddd.workflow.domains.afs;

import cn.tim.ddd.workflow.domains.afs.state.CreateState;
import cn.tim.ddd.workflow.domains.afs.state.State;
import cn.tim.ddd.workflow.domains.afs.task.AfsTask;
import lombok.Data;

import java.util.List;

/**
 * 服务单Domain
 * Created by luolibing on 2017/7/20.
 */
@Data
public class AfsServiceDomain {

    private Long id;

    private AfsService afsService;

    private List<AfsFile> file;

    private State state;

    private AfsTask task;

    public AfsServiceDomain(AfsService afsService) {
        if(afsService.getStatus() == 0) {
            this.state = new CreateState();
        }
    }

    public void processTask() {
        task.execute(this);
    }
}
