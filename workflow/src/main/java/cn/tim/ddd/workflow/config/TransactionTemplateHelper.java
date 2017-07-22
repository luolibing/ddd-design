package cn.tim.ddd.workflow.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by luolibing on 2017/7/23.
 */
@Component
public class TransactionTemplateHelper {

    @Autowired
    private PlatformTransactionManager transactionManager;

    public TransactionTemplate getTransactionTemplate() {
        return new TransactionTemplate(transactionManager);
    }
}
