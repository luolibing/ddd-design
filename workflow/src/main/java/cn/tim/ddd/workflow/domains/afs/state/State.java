package cn.tim.ddd.workflow.domains.afs.state;

/**
 * Created by luolibing on 2017/7/20.
 */
public interface State {

    void startProcess();

    void serveAuditPass();

    void serveAuditReject();

    void serveManagePass();

    void serveManageReject();

    void waitDelivery();

    void deliveryPass();

    void storagePass();

    void storageReject();
}
