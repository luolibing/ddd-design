package cn.tim.ddd.workflow.domains.afs.state;

import cn.tim.ddd.workflow.domains.exception.NotSupportStateChangeException;

/**
 * Created by luolibing on 2017/7/20.
 */
public class BaseState implements State {
    @Override
    public void startProcess() {
        throw new NotSupportStateChangeException();
    }

    @Override
    public void serveAuditPass() {
        throw new NotSupportStateChangeException();
    }

    @Override
    public void serveAuditReject() {
        throw new NotSupportStateChangeException();
    }

    @Override
    public void serveManagePass() {
        throw new NotSupportStateChangeException();
    }

    @Override
    public void serveManageReject() {
        throw new NotSupportStateChangeException();
    }

    @Override
    public void waitDelivery() {
        throw new NotSupportStateChangeException();
    }

    @Override
    public void deliveryPass() {
        throw new NotSupportStateChangeException();
    }

    @Override
    public void storagePass() {
        throw new NotSupportStateChangeException();
    }

    @Override
    public void storageReject() {
        throw new NotSupportStateChangeException();
    }
}
