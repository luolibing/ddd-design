package cn.tim.ddd.report.application;

import cn.tim.ddd.report.domain.DomainRegistry;
import cn.tim.ddd.report.domain.template.TemplateEntity;
import cn.tim.ddd.report.domain.template.TemplateId;
import cn.tim.ddd.report.infrastructure.idgenerate.IdGenerator;
import cn.tim.ddd.report.web.form.TemplateForm;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * User: luolibing
 * Date: 2017/10/10 17:46
 */
@Service
public class TemplateApplicationService {

    public void addTemplate(TemplateForm templateForm) {
        TemplateEntity templateEntity = new TemplateEntity(
                new TemplateId(IdGenerator.nextId(TemplateId.IDENTITY_KEY)),
                templateForm.getTitle(),
                Collections.emptyList()
        );
        DomainRegistry.templateJpaRepository()
                .add(templateEntity);
    }

    public TemplateEntity templateEntity(Long id) {
        return DomainRegistry.templateJpaRepository()
                .findOne(new TemplateId(Long.toString(id)));
    }
}
