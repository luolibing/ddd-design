package cn.tim.ddd.report.domain;

import cn.tim.ddd.report.infrastructure.template.TemplateJpaRepository;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * User: luolibing
 * Date: 2017/10/10 17:29
 */
@Service
public class DomainRegistry implements ApplicationContextAware, ApplicationEventPublisherAware {

    private static ApplicationContext applicationContext;

    private static ApplicationEventPublisher applicationEventPublisher;

    public static ApplicationEventPublisher eventPublisher() {
        return applicationEventPublisher;
    }

    public static TemplateJpaRepository templateJpaRepository() {
        return (TemplateJpaRepository) applicationContext.getBean("templateJpaRepository");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DomainRegistry.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        DomainRegistry.applicationEventPublisher = applicationEventPublisher;
    }
}
