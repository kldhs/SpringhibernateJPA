package com.suray.wcsgui.dbopr.dao;

import com.suray.wcsgui.dbopr.entity.AbnormalTaskDB;
import com.suray.wcsgui.dbopr.entity.DistrictDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistrictDao extends JpaRepository<DistrictDB,Integer> {
    @Query("from DistrictDB d where (?1=?2)")
    List<DistrictDB> selectByRow(String row, Integer price);
}
