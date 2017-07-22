package cn.tim.ddd.workflow.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by luolibing on 2017/7/22.
 */
@Data
@Entity
@Table(name = "afs_logs")
public class AfsLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String user;

    private String comment;

    private Date created;
}
