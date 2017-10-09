package cn.tim.ddd.report.domain.template;

import cn.tim.ddd.report.domain.subject.SubjectEntity;
import lombok.Getter;

import java.util.Date;
import java.util.List;

/**
 * User: luolibing
 * Date: 2017/9/29 15:12
 */
@Getter
public class TemplateEntity {

    private TemplateId templateId;

    private String name;

    private List<SubjectEntity> subjectList;

    private Date created;

    public void addSubjectEntity(SubjectEntity subjectEntity) {
        subjectList.add(subjectEntity);

    }

    private void setTemplateId(TemplateId templateId) {
        this.templateId = templateId;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setCreated(Date created) {
        this.created = created;
    }

    private void setSubjectList(List<SubjectEntity> subjectList) {
        this.subjectList = subjectList;
    }
}
