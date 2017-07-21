package cn.tim.ddd.workflow.domains.afs.task;

import cn.tim.ddd.workflow.domains.afs.AfsServiceDomain;

/**
 * Created by luolibing on 2017/7/21.
 */
public interface AfsTask {

    void execute(AfsServiceDomain afsServiceDomain);
}
