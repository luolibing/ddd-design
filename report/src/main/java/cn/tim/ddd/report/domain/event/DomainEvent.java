package cn.tim.ddd.report.domain.event;

import java.util.Date;

/**
 * User: luolibing
 * Date: 2017/10/11 10:36
 */
public interface DomainEvent {

    int getEventVersion();

    Date occuredOn();
}
