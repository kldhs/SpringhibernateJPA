package com.suray.wcsgui.dbopr.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "db_district")
public class DistrictDB {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 仓库ID
     */
    @ManyToOne(targetEntity = WarehouseDB.class)
    @JoinColumn(name = "warehouseId", columnDefinition = "INT COMMENT '仓库id'")
    private WarehouseDB assignedWarehouse;

    /**
     * 是否被启用
     */
    @Column(columnDefinition = "TINYINT COMMENT '是否被启用'", nullable = false)
    private Boolean inUse;

    /**
     * 备注
     */
    @Column(columnDefinition = "varchar(200) COMMENT '备注'", nullable = false)
    private String remark;

    /**
     * 录入日期
     */
    @Column(columnDefinition = "DATETIME COMMENT '是否被启用'", nullable = false)
    private Date insertTime;

    /**
     * 录入人id
     */
    @ManyToOne(targetEntity = UserDB.class)
    @JoinColumn(name = "insertId", columnDefinition = "INT COMMENT '录入人id'")
    private UserDB assignedInsertUser;

    /**
     * 更新日期
     */
    @Column(columnDefinition = "DATETIME COMMENT '更新日期'", nullable = false)
    private Date updateTime;

    /**
     * 更新人id
     */
    @ManyToOne(targetEntity = UserDB.class)
    @JoinColumn(name = "updateId", columnDefinition = "INT COMMENT '更新人id'")
    private UserDB assignedUpdateUser;

    /**
     * 封锁类型
     */
    @Column(columnDefinition = "INT COMMENT '更新日期'", nullable = false)
    private Integer lockType;

    /**
     * 封锁时间
     */
    @Column(columnDefinition = "DATETIME COMMENT '封锁时间'", nullable = false)
    private Date lockTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WarehouseDB getAssignedWarehouse() {
        return assignedWarehouse;
    }

    public void setAssignedWarehouse(WarehouseDB assignedWarehouse) {
        this.assignedWarehouse = assignedWarehouse;
    }

    public Boolean getInUse() {
        return inUse;
    }

    public void setInUse(Boolean inUse) {
        this.inUse = inUse;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public UserDB getAssignedInsertUser() {
        return assignedInsertUser;
    }

    public void setAssignedInsertUser(UserDB assignedInsertUser) {
        this.assignedInsertUser = assignedInsertUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public UserDB getAssignedUpdateUser() {
        return assignedUpdateUser;
    }

    public void setAssignedUpdateUser(UserDB assignedUpdateUser) {
        this.assignedUpdateUser = assignedUpdateUser;
    }

    public Integer getLockType() {
        return lockType;
    }

    public void setLockType(Integer lockType) {
        this.lockType = lockType;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }
}
