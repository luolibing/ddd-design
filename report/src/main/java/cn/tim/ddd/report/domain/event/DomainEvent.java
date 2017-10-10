package cn.tim.ddd.report.domain.event;

import org.springframework.context.ApplicationEvent;

/**
 * User: luolibing
 * Date: 2017/10/10 17:35
 */
public class DomainEvent<T> extends ApplicationEvent {

    private T domainEvent;

    /**
     * Create a new ApplicationEvent.
     *
     * @param domainEvent the object on which the event initially occurred (never {@code null})
     */
    public DomainEvent(T domainEvent) {
        super(domainEvent);
        this.domainEvent = domainEvent;
    }

    public T getDomainEvent() {
        return domainEvent;
    }
}
