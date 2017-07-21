package cn.tim.ddd.workflow.domains.afs.event;

import lombok.Getter;

/**
 * Created by luolibing on 2017/7/21.
 */
@Getter
public class DeliveryAuditEvent implements Event {

    private Boolean audit;

    public DeliveryAuditEvent(Boolean audit) {
        this.audit = audit;
    }
}
