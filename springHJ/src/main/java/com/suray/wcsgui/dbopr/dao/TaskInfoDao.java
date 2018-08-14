package com.suray.wcsgui.dbopr.dao;

import com.suray.wcsgui.dbopr.entity.NodeDB;
import com.suray.wcsgui.dbopr.entity.RgvDB;
import com.suray.wcsgui.dbopr.entity.TaskDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Charles on 2018/5/15.
 */
public interface TaskInfoDao extends JpaRepository<TaskDB, Integer> {
    @Modifying
    @Query("update TaskDB as t set t.taskProgress = ?1 where t.id=?2")
    @Transactional
    void updateTaskInfoProgressById(int taskProgress, int id);

    @Modifying
    @Query("update TaskDB as t set t.assignedRgv = ?1 where t.id=?2")
    @Transactional
    void updateTaskProcessingRgvByRgv(RgvDB processingRgv, Integer id);


    List<TaskDB> findAllByAssignedRgvNotNullAndTaskProgressEquals(Integer taskProgress);

    List<TaskDB> findAllByAssignedRgvNullAndTaskProgressEquals(Integer taskProgress);

    @Query("from TaskDB  where (?1=?2)")
    List<TaskDB> selectByRow(String row, Integer price);
}
