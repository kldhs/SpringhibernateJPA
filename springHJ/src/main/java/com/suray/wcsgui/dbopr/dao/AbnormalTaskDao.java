package com.suray.wcsgui.dbopr.dao;

import com.suray.wcsgui.dbopr.entity.AbnormalTaskDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AbnormalTaskDao extends JpaRepository<AbnormalTaskDB,Integer>{
    @Query("from AbnormalTaskDB a where (?1=?2)")
    List<AbnormalTaskDB> selectByRow(String row,Integer price);


}
