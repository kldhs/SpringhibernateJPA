package com.suray.wcsgui.dbopr.dao;

import com.suray.wcsgui.dbopr.entity.AbnormalTaskDB;
import com.suray.wcsgui.dbopr.entity.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserDao extends JpaRepository<UserDB, Integer> {

    @Query("from UserDB u where (?1=?2)")
    List<UserDB> selectByRow(String row, Integer price);
}
