package cn.tim.ddd.report.domain.event;

import org.springframework.context.ApplicationListener;

/**
 * 事件存储
 * User: luolibing
 * Date: 2017/10/11 11:35
 */
public class EventStoreApplicationListener implements ApplicationListener<DomainStoreEvent> {
    @Override
    public void onApplicationEvent(DomainStoreEvent event) {

    }
}
