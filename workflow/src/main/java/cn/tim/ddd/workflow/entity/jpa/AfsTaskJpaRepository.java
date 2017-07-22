package cn.tim.ddd.workflow.entity.jpa;

import cn.tim.ddd.workflow.entity.AfsTask;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by luolibing on 2017/7/22.
 */
public interface AfsTaskJpaRepository extends JpaRepository<AfsTask, Long> {
}
