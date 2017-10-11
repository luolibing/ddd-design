package cn.tim.ddd.report.domain.notification;

import cn.tim.ddd.report.domain.event.DomainEvent;
import lombok.Getter;

import java.util.Date;

/**
 *
 * User: luolibing
 * Date: 2017/10/11 10:33
 */
@Getter
public class Notification {

    private DomainEvent event;
    private long notificationId;
    private Date occurredOn;
    private String typeName;
    private int version;

    public Notification(long notificationId, DomainEvent domainEvent) {
        this.setEvent(domainEvent);
        this.setNotificationId(notificationId);
        this.setOccurredOn(domainEvent.occuredOn());
        this.setTypeName(domainEvent.getClass().getName());
        this.setVersion(domainEvent.getEventVersion());
    }

    private void setEvent(DomainEvent event) {
        this.event = event;
    }

    private void setNotificationId(long notificationId) {
        this.notificationId = notificationId;
    }

    private void setOccurredOn(Date occurredOn) {
        this.occurredOn = occurredOn;
    }

    private void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    private void setVersion(int version) {
        this.version = version;
    }
}
