package cn.tim.ddd.workflow.domains.afs;

import cn.tim.ddd.workflow.domains.afs.state.CreateState;
import cn.tim.ddd.workflow.domains.afs.state.State;
import lombok.Data;

import java.util.List;

/**
 * 服务单Domain
 * Created by luolibing on 2017/7/20.
 */
@Data
public class AfsServiceDomain {

    private Long id;

    private List<AfsFile> file;

    private State state;

    public AfsServiceDomain(Long id, Integer state) {
        if(state == 0) {
            this.state = new CreateState();
        }
    }
}
