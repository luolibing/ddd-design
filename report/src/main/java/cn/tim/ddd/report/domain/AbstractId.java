package cn.tim.ddd.report.domain;

import org.springframework.util.Assert;

/**
 * User: luolibing
 * Date: 2017/9/29 15:23
 */
public class AbstractId implements Identity {

    protected String id;

    protected AbstractId(String id) {
        setId(id);
    }

    @Override
    public String id() {
        return id;
    }

    private void setId(String id) {
        Assert.notNull(id, "id不能为空");
        this.id = id;
    }
}
