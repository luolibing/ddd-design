package cn.tim.ddd.report.domain.event;

import cn.tim.ddd.report.domain.DomainRegistry;

/**
 * User: luolibing
 * Date: 2017/10/9 16:38
 */
public class DomainEventPublisher {

    public static <T> void publishEvent(final T aDomainEvent) {
        DomainRegistry.eventPublisher()
                .publishEvent(new DomainEvent<>(aDomainEvent));
    }

}
