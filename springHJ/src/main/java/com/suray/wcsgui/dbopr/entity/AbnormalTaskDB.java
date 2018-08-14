package com.suray.wcsgui.dbopr.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "db_abnormaltask")
public class AbnormalTaskDB {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 任务id
     */
    @ManyToOne(targetEntity = TaskDB.class)
    @JoinColumn(name = "taskId", columnDefinition = "INT COMMENT '任务id'")
    private TaskDB assignedTask;

    /**
     * 异常发生时间
     */
    @Column(columnDefinition = "DATETIME COMMENT '异常发生时间'", nullable = false)
    private Date occurTime;

    /**
     * 异常位置节点
     */
    @OneToOne(targetEntity = NodeDB.class)
    @JoinColumn(name = "errorNodeId", columnDefinition = "INT COMMENT '异常节点'")
    private NodeDB assignederrorNode;

    /**
     * 目标位置节点
     */
    @OneToOne(targetEntity = NodeDB.class)
    @JoinColumn(name = "targetNodeId", columnDefinition = "INT COMMENT '异常节点'")
    private NodeDB assignedtargetNode;

    /**
     * 顶升状态
     */
    @Column(columnDefinition = "INT COMMENT '顶升状态'", nullable = false)
    private Integer rise;

    /**
     * 是否处理完成
     */
    @Column(columnDefinition = "INT COMMENT '是否处理完成'", nullable = false)
    private Integer handle;

    /**
     * 备注
     */
    @Column(columnDefinition = "varchar(200) COMMENT '备注'", nullable = false)
    private String remark;

    /**
     * 录入日期
     */
    @Column(columnDefinition = "DATETIME COMMENT '录入日期'", nullable = false)
    private Date insertTime;

    /**
     * 录入人
     */
    @Column(columnDefinition = "INT COMMENT '录入人'", nullable = false)
    private Integer insertId;

    /**
     * 更新日期
     */
    @Column(columnDefinition = "DATETIME COMMENT '更新日期'", nullable = false)
    private Date updateTime;

    /**
     * 更新人
     */
    @Column(columnDefinition = "INT COMMENT '更新人'", nullable = false)
    private Integer updateId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TaskDB getAssignedTask() {
        return assignedTask;
    }

    public void setAssignedTask(TaskDB assignedTask) {
        this.assignedTask = assignedTask;
    }

    public Date getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(Date occurTime) {
        this.occurTime = occurTime;
    }

    public NodeDB getAssignederrorNode() {
        return assignederrorNode;
    }

    public void setAssignederrorNode(NodeDB assignederrorNode) {
        this.assignederrorNode = assignederrorNode;
    }

    public NodeDB getAssignedtargetNode() {
        return assignedtargetNode;
    }

    public void setAssignedtargetNode(NodeDB assignedtargetNode) {
        this.assignedtargetNode = assignedtargetNode;
    }

    public Integer getRise() {
        return rise;
    }

    public void setRise(Integer rise) {
        this.rise = rise;
    }

    public Integer getHandle() {
        return handle;
    }

    public void setHandle(Integer handle) {
        this.handle = handle;
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

    public Integer getInsertId() {
        return insertId;
    }

    public void setInsertId(Integer insertId) {
        this.insertId = insertId;
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
}
