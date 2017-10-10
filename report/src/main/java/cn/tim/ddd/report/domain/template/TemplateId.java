package cn.tim.ddd.report.domain.template;

import cn.tim.ddd.report.domain.AbstractId;

/**
 * User: luolibing
 * Date: 2017/9/29 15:12
 */
public class TemplateId extends AbstractId {

    public final static String IDENTITY_KEY = "templateId";

    public TemplateId(String id) {
        super(id);
    }
}
