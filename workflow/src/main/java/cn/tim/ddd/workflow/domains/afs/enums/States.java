package cn.tim.ddd.workflow.domains.afs.enums;

/**
 * Created by luolibing on 2017/7/22.
 */
public enum States {
    CREATED(0), WAIT_SERVE_AUDIT(10), WAIT_MANAGER_AUDIT(20), WAIT_REFUND(30), FINISHED(40), CLOSED(50);

    private int value;

    States(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public static States findByValue(int value) {
        for(States states : values()) {
            if(states.value == value) {
                return states;
            }
        }
        return null;
    }
}
