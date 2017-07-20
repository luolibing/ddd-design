package cn.tim.ddd.workflow.domains.exception;

/**
 * Created by luolibing on 2017/7/20.
 */
public class NotSupportStateChangeException extends RuntimeException {

    public NotSupportStateChangeException() {
    }

    public NotSupportStateChangeException(String message) {
        super(message);
    }
}
