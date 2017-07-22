package cn.tim.ddd.workflow.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by luolibing on 2017/7/22.
 */
@Data
@Entity
@Table(name = "afs_service")
public class AfsService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer status;

    private Date created;
}
