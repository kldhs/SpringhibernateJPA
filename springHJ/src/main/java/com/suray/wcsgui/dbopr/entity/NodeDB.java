package com.suray.wcsgui.dbopr.entity;

import com.suray.path.enums.NodeType;
import com.suray.path.enums.StorageStatus;
import com.suray.path.pojo.Node;

import javax.persistence.*;
import java.util.Date;


/**
 * @author Charles on 2018/5/15.
 */
@Entity
@Table(name = "db_node")
public class NodeDB {
    /**
     * 货位ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 货位状态
     * 详情见{@link com.suray.path.enums.StorageStatus}
     */
    @Column(columnDefinition = "INT DEFAULT 0 COMMENT '货位状态'", nullable = false)
    private Integer storageStatus;

    /**
     * 货位类型
     * 详情见{@link com.suray.path.enums.NodeType}
     */
    @Column(columnDefinition = "INT COMMENT '货位类型'", nullable = false)
    private Integer nodeType;

    /**
     * 节点坐标X
     */
    @Column(columnDefinition = "INT COMMENT '节点坐标X'", nullable = false)
    private Integer x;

    /**
     * 节点坐标Y
     */
    @Column(columnDefinition = "INT COMMENT '节点坐标Y'", nullable = false)
    private Integer y;

    /**
     * 节点坐标Z
     */
    @Column(columnDefinition = "INT COMMENT '节点坐标Z'", nullable = false)
    private Integer z;

    /**
     * 插入时间
     */
    @Column(columnDefinition = "DATETIME COMMENT '插入时间'")
    private Date insertTime;

    /**
     * 更新时间
     */
    @Column(columnDefinition = "DATETIME COMMENT '更新时间'")
    private Date updateTime;

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStorageStatus() {
        return storageStatus;
    }

    public void setStorageStatus(Integer storageStatus) {
        this.storageStatus = storageStatus;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    public NodeType getNodeTypeEnum() {
        return NodeType.parseNodeType(this.nodeType);
    }

    public void setNodeTypeEnum(NodeType nodeType) {
        this.nodeType = nodeType.getTypeNum();
    }

    public StorageStatus getStorageStatusEnum() {
        return StorageStatus.parseStatus(this.storageStatus);
    }

    public void setStorageStatusEnum(StorageStatus storageStatus) {
        this.storageStatus = storageStatus.getStatusNum();
    }

    public Node transToNode() {
        return new Node(this.getX(), this.getY(), this.getZ());
    }

    @Override
    public String toString() {
        return "NodeDB{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
