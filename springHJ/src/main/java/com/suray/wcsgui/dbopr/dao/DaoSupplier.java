package com.suray.wcsgui.dbopr.dao;

import com.suray.wcsgui.dbopr.entity.*;
import com.suray.wcsgui.utils.SpringUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Charles on 2018/7/25.
 */
public class DaoSupplier<T> {
    public static JpaRepository getDao(Class clazz) {
        if (clazz.equals(RgvDB.class)) {
            return (JpaRepository) SpringUtils.getBean("shuttleInfoDao");
        } else if (clazz.equals(TaskDB.class)) {
            return (JpaRepository) SpringUtils.getBean("taskInfoDao");
        } else if (clazz.equals(NodeDB.class)) {
            return (JpaRepository) SpringUtils.getBean("storageInfoDao");
        } else if (clazz.equals(AbnormalTaskDB.class)) {
            return (JpaRepository) SpringUtils.getBean("abnormalTaskDao");
        } else if (clazz.equals(DistrictDB.class)) {
            return (JpaRepository) SpringUtils.getBean("districtDao");
        } else if (clazz.equals(UserDB.class)) {
            return (JpaRepository) SpringUtils.getBean("userDao");
        } else if (clazz.equals(WarehouseDB.class)) {
            return (JpaRepository) SpringUtils.getBean("warehouseDAO");
        }
        throw new IllegalArgumentException(clazz + "非法");
    }

    public static void main(String[] args) {
        System.out.println("111111111111111111111111111111111111111111111111111111");
        AbnormalTaskDao dao=(AbnormalTaskDao) getDao(AbnormalTaskDB.class);
        AbnormalTaskDB taskDB=new AbnormalTaskDB();
        taskDB.setId(1);
        System.out.println(dao.findAll(Example.of(taskDB)).get(0).getOccurTime().toString());
        System.out.println("2222222222222222222222222222222222222222222222222222222222");
    }
}
