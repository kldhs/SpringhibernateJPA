package com.suray.wcsgui.dbopr.dao;

import com.suray.wcsgui.dbopr.entity.AbnormalTaskDB;
import com.suray.wcsgui.dbopr.entity.RgvDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Charles on 2018/5/15.
 */
public interface ShuttleInfoDao extends JpaRepository<RgvDB, Integer> {


    @Query("from RgvDB  where (?1=?2)")
    List<RgvDB> selectByRow(String row, Integer price);

}
