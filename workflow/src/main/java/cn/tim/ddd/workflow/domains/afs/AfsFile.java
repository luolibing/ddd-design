package cn.tim.ddd.workflow.domains.afs;

import lombok.Getter;

/**
 * Created by luolibing on 2017/7/20.
 */
@Getter
public class AfsFile {

    private Long id;

    private String file;

    public AfsFile(Long id, String file) {
        this.id = id;
        this.file = file;
    }
}
