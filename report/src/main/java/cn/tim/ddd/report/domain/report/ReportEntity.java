package cn.tim.ddd.report.domain.report;

import cn.tim.ddd.report.domain.subjectdata.SubjectDataEntity;
import cn.tim.ddd.report.domain.template.TemplateEntity;

import java.util.List;

/**
 * User: luolibing
 * Date: 2017/9/29 15:10
 */
public class ReportEntity {

    private ReportId reportId;

    private String reportName;

    private String yearMonth;

    private TemplateEntity templateEntity;

    private List<SubjectDataEntity> datas;
}
