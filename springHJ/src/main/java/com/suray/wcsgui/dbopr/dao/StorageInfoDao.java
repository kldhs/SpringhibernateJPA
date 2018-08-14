package com.suray.wcsgui.dbopr.dao;

import com.suray.wcsgui.dbopr.entity.NodeDB;
import com.suray.wcsgui.dbopr.entity.RgvDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Charles on 2018/5/15.
 */
public interface StorageInfoDao extends JpaRepository<NodeDB, Integer> {
    @Query("select d from NodeDB d where (x=?1 or x=?2) and (y>=?3 and y<=?4)")
    List<NodeDB> getDB_NodesNearRoad(Integer xNext_up, Integer xNext_down, Integer yMin, Integer yMax);

    NodeDB findByXAndYAndZ(Integer x, Integer y, Integer z);

    @Query("update NodeDB set storageStatus=?1 where x=?2 and y=?3 and z=?4")
    @Modifying
    @Transactional
    void updateDB_NodeStatus(Integer status, Integer x, Integer y, Integer z);

    List<NodeDB> findAllByStorageStatusNotAndNodeTypeEquals(Integer storageStatus, Integer storageType);

    @Query("from NodeDB  where (?1=?2)")
    List<NodeDB> selectByRow(String row, Integer price);

}