package cn.tim.ddd.report.domain.event;

import org.springframework.context.ApplicationEvent;

/**
 * 事件存储的event
 * User: luolibing
 * Date: 2017/10/10 17:35
 */
public class DomainStoreEvent<T> extends ApplicationEvent {

    private T domainEvent;

    /**
     * Create a new ApplicationEvent.
     *
     * @param domainEvent the object on which the event initially occurred (never {@code null})
     */
    public DomainStoreEvent(T domainEvent) {
        super(domainEvent);
        this.domainEvent = domainEvent;
    }

    public T getDomainEvent() {
        return domainEvent;
    }
}
