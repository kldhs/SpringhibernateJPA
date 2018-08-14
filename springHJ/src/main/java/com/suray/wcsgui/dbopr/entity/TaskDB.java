package com.suray.wcsgui.dbopr.entity;

import com.suray.path.enums.TaskProgress;
import com.suray.path.enums.TaskType;
import com.suray.path.pojo.Node;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author Charles on 2018/5/15.
 */
@Entity
@Table(name = "db_task")
public class TaskDB implements Comparable<TaskDB> {
    /**
     * 任务ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 任务起点节点ID
     */
    @ManyToOne(targetEntity = NodeDB.class)
    @JoinColumn(name = "startNodeId", columnDefinition = "INT COMMENT '任务起点节点ID'")
    private NodeDB startNode;

    /**
     * 任务终点节点ID
     */
    @ManyToOne(targetEntity = NodeDB.class)
    @JoinColumn(name = "endNodeId", columnDefinition = "INT COMMENT '任务终点节点ID'")
    private NodeDB endNode;

    /**
     * 任务进度
     * 详情见{@link com.suray.path.enums.TaskProgress}
     */
    @Column(columnDefinition = "INT DEFAULT 0 COMMENT '任务进度'")
    private Integer taskProgress;

    /**
     * 任务类型
     * 详情见{@link com.suray.path.enums.TaskType}
     */
    @Column(columnDefinition = "INT COMMENT '任务类型'")
    private Integer taskType;

    /**
     * 预先分配给的小车ID
     */
    @ManyToOne(targetEntity = RgvDB.class)
    @JoinColumn(name = "assignedRgvId", columnDefinition = "INT COMMENT '预先分配给的小车ID'")
    private RgvDB assignedRgv;

    /**
     * 执行中的小车ID
     */
    @OneToOne(targetEntity = RgvDB.class)
    @JoinColumn(name = "processingRgvId", columnDefinition = "INT COMMENT '执行中的小车ID'")
    private RgvDB processingRgv;

    /**
     * 插入时间
     */
    @Column(columnDefinition = "DATETIME COMMENT '插入时间'")
    private Date insertTime;

    /**
     * 执行时间
     */
    @Column(columnDefinition = "DATETIME COMMENT '执行时间'")
    private Date executeTime;

    /**
     * 完成时间
     */
    @Column(columnDefinition = "DATETIME COMMENT '完成时间'")
    private Date completeTime;


    public NodeDB getStartNode() {
        return startNode;
    }

    public void setStartNode(NodeDB startNode) {
        this.startNode = startNode;
    }

    public Node getStart() {
        return startNode.transToNode();
    }

    public Node getEnd() {
        return endNode.transToNode();
    }


    public NodeDB getEndNode() {
        return endNode;
    }

    @Override
    public String toString() {
        return "TaskDB{" +
                "id=" + id +
                ", startNode=" + startNode +
                ", endNode=" + endNode +
                ", assignedRgv=" + assignedRgv +
                ", insertTime=" + insertTime +
                '}';
    }

    public void setEndNode(NodeDB endNode) {
        this.endNode = endNode;
    }


    public RgvDB getAssignedRgv() {
        return assignedRgv;
    }


    public void setAssignedRgv(RgvDB assignedRgv) {
        this.assignedRgv = assignedRgv;
    }


    public RgvDB getProcessingRgv() {
        return processingRgv;
    }


    public void setProcessingRgv(RgvDB processingRgv) {
        this.processingRgv = processingRgv;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public TaskType getTaskTypeEnum() {
        return TaskType.parseTaskType(taskType);
    }

    public void setTaskTypeEnum(TaskType taskType) {
        this.taskType = taskType.getTaskType();
    }

    public TaskProgress getTaskProgressEnum() {
        return TaskProgress.parseTaskProgress(taskProgress);
    }

    public void setTaskProgressEnum(TaskProgress taskProgress) {
        this.taskProgress = taskProgress.getProgressNum();
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskProgress() {
        return taskProgress;
    }

    public void setTaskProgress(Integer taskProgress) {
        this.taskProgress = taskProgress;
    }

    @Override
    public int compareTo(TaskDB o) {
        return Integer.compare(o.getId(), this.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDB taskDB = (TaskDB) o;
        return Objects.equals(id, taskDB.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
