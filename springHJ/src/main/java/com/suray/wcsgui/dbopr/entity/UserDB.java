package com.suray.wcsgui.dbopr.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "db_user")
public class UserDB {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    @Column(columnDefinition = "varchar(20) COMMENT '用户名'", nullable = false)
    private String username;

    /**
     * 密码
     */
    @Column(columnDefinition = "varchar(40) COMMENT '用户密码'", nullable = false)
    private String password;

    /**
     * 注册时间
     */
    @Column(columnDefinition = "DATETIME COMMENT '注册时间'")
    private Date regTime;

    /**
     * 仓库编号
     */
    @Column(columnDefinition = "INT COMMENT '管理的仓库的id'")
    private String warehouseId;

    /**
     * 是否管理员
     */
    @Column(columnDefinition = "TINYINT COMMENT '是否是管理员'", nullable = false)
    private Boolean manager;

    /**
     * 更新日期
     */
    @Column(columnDefinition = "DATETIME COMMENT '更新日期'")
    private Date updateTime;

    /**
     * 更新人
     */
    @Column(columnDefinition = "INT COMMENT '更新人的id'")
    private Integer updateId;

    /**
     * 是否接收邮件
     */
    @Column(columnDefinition = "TINYINT COMMENT '是否接收邮件'")
    private Boolean receiveE;

    /**
     * 保留字段
     */
    @Column(columnDefinition = "varchar(40) COMMENT '盐'")
    private String salt;

    @Override
    public String toString() {
        return "UserDB{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", regTime=" + regTime +
                ", warehouseId='" + warehouseId + '\'' +
                ", manager=" + manager +
                ", updateTime=" + updateTime +
                ", updateId=" + updateId +
                ", receiveE=" + receiveE +
                ", salt='" + salt + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    public Boolean getManager() {
        return manager;
    }

    public void setManager(Boolean manager) {
        this.manager = manager;
    }

    public Boolean getReceiveE() {
        return receiveE;
    }

    public void setReceiveE(Boolean receiveE) {
        this.receiveE = receiveE;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
