package com.suray.wcsgui.dbopr.service;

import com.suray.wcsgui.dbopr.dao.ShuttleInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Charles on 2018/5/15.
 */
@Service(value = "rgvManageService")
public class RgvManageService {
    private final ShuttleInfoDao shuttleInfoDao;

    @Autowired
    public RgvManageService(ShuttleInfoDao shuttleInfoDao) {
        this.shuttleInfoDao = shuttleInfoDao;
    }




}
