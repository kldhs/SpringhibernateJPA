package com.suray.wcsgui.dbopr.dao;

import com.suray.wcsgui.dbopr.entity.WarehouseDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WarehouseDAO extends JpaRepository<WarehouseDB,Integer>{

    @Query("from WarehouseDB w where (?1=?2)")
    List<WarehouseDB> selectByRow(String row, Integer price);
}
