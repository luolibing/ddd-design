package cn.tim.ddd.workflow.domains.afs.event;

import lombok.Getter;

/**
 * Created by luolibing on 2017/7/21.
 */
@Getter
public class ServeManageAuditEvent implements Event {

    private Boolean audit;

    private Integer serviceType;

    private Integer deliveryType;

    public ServeManageAuditEvent(Boolean audit, Integer serviceType, Integer deliveryType) {
        this.audit = audit;
        this.serviceType = serviceType;
        this.deliveryType = deliveryType;
    }
}
