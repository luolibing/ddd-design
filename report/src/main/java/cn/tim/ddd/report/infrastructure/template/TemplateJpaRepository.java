package cn.tim.ddd.report.infrastructure.template;

import cn.tim.ddd.report.domain.template.TemplateEntity;
import cn.tim.ddd.report.domain.template.TemplateId;

/**
 * User: luolibing
 * Date: 2017/9/29 17:01
 */
public interface TemplateJpaRepository {

    void update(TemplateEntity templateEntity);

    TemplateEntity findOne(TemplateId templateId);

    void add(TemplateEntity templateEntity);
}
