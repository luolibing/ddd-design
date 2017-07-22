package cn.tim.ddd.workflow.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by luolibing on 2017/7/22.
 */
@Data
@Entity
@Table(name = "afs_task")
public class AfsTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long serviceId;

    private String eventType;

    private Integer finished;

    private Date created;
}
