package cn.tim.ddd.workflow.domains.afs.event;

import lombok.Getter;

/**
 * Created by luolibing on 2017/7/21.
 */
@Getter
public class StartProcessEvent implements Event {

    private Integer serviceType;

    private Integer deliveryType;

    public StartProcessEvent(Integer serviceType, Integer deliveryType) {
        this.serviceType = serviceType;
        this.deliveryType = deliveryType;
    }

}
