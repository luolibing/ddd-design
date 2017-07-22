package cn.tim.ddd.workflow.entity.jpa;

import cn.tim.ddd.workflow.entity.AfsLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by luolibing on 2017/7/22.
 */
public interface AfsLogJpaRepository extends JpaRepository<AfsLog, Long> {
}
