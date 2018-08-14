package com.suray.wcsgui.dbopr.service;

import com.suray.path.enums.TaskProgress;
import com.suray.wcsgui.dbopr.dao.TaskInfoDao;
import com.suray.wcsgui.dbopr.entity.TaskDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Charles on 2018/5/22.
 */
@Service("taskManageService")
public class TaskManageService {
    private final TaskInfoDao taskInfoDao;

    @Autowired
    public TaskManageService(TaskInfoDao taskInfoDao) {
        this.taskInfoDao = taskInfoDao;
    }

    public synchronized void updateTaskProgress(TaskDB task, TaskProgress taskProgress) {
        taskInfoDao.updateTaskInfoProgressById(taskProgress.getProgressNum(), task.getId());
        task.setTaskProgressEnum(taskProgress);
    }


}
