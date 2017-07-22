package cn.tim.ddd.workflow.domains.afs.form;

import cn.tim.ddd.workflow.domains.afs.enums.States;
import lombok.Data;

/**
 * Created by luolibing on 2017/7/22.
 */
@Data
public class ProcessForm {

    private Long id;

    private String user;

    private States states;

    public void validate() {
        // 默认验证
        // 自定义验证
    }

    public void customsize() {
        // 留给子类实现
    }
}
