package cn.tim.ddd.workflow.service;

import cn.tim.ddd.workflow.domains.afs.enums.States;
import cn.tim.ddd.workflow.domains.afs.task.AfsTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by luolibing on 2017/7/23.
 */
@Component
public class TaskMapping {

    private Map<States, List<AfsTask>> mappingTask;

    @Autowired
    public TaskMapping(List<AfsTask> afsTaskList) {
        mappingTask = new HashMap<>();
        for(AfsTask afsTask : afsTaskList) {
            List<States> states = afsTask.interestedStates();
            if(states != null) {
                for (States state : states) {
                    mappingTask.computeIfAbsent(state, v -> new ArrayList<>()).add(afsTask);
                }
            }
        }
    }

    public List<AfsTask> getTaskList(States states) {
        return mappingTask.get(states);
    }
}
