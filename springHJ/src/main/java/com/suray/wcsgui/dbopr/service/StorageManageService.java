package com.suray.wcsgui.dbopr.service;

import com.suray.path.enums.NodeType;
import com.suray.path.enums.StorageStatus;
import com.suray.path.initialize.MapInit;
import com.suray.path.pojo.Node;
import com.suray.path.pojo.Road;
import com.suray.wcsgui.dbopr.dao.StorageInfoDao;
import com.suray.wcsgui.dbopr.entity.NodeDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Charles on 2018/6/4.
 */
@Service("storageManageService")
public class StorageManageService {
    private final StorageInfoDao storageInfoDao;

    @Autowired
    public StorageManageService(StorageInfoDao storageInfoDao) {
        this.storageInfoDao = storageInfoDao;
    }

    public List<Node> getCargoNearCurRoad(Road road) {
        return null;
    }

    public StorageStatus getStorageStatus(Node node) {
        return StorageStatus.parseStatus(storageInfoDao.findByXAndYAndZ(node.x, node.y, node.z).getStorageStatus());
    }

    public void updateStorageStatus(List<Node> nodes, StorageStatus storageStatus) {
        for (Node node : nodes) {
            storageInfoDao.updateDB_NodeStatus(storageStatus.getStatusNum(), node.x, node.y, node.z);
        }
    }

    public void saveOrUpdateAll(List<Node> nodes) {
        List<NodeDB> db_nodes = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            NodeDB db_node = new NodeDB();
            db_node.setId(i + 1);
            db_node.setX(node.x);
            db_node.setY(node.y);
            db_node.setZ(node.z);
            db_node.setStorageStatus(StorageStatus.EMPTY.getStatusNum());
            db_node.setNodeType(MapInit.getNodeInfo(db_node.getX(), db_node.getY(), db_node.getZ()).getNodeType().getTypeNum());
            db_node.setInsertTime(new Date(System.currentTimeMillis()));
            db_nodes.add(db_node);
        }
        storageInfoDao.save(db_nodes);
    }

    public List<Node> findAllSpecifiedNodes(StorageStatus storageStatus, NodeType storageType) {
        List<NodeDB> db_nodes = storageInfoDao.findAllByStorageStatusNotAndNodeTypeEquals(storageStatus.getStatusNum(), storageType.getTypeNum());
        List<Node> specifiedNodes = new ArrayList<>();
        for (NodeDB db_node : db_nodes) {
            specifiedNodes.add(new Node(db_node.getX(), db_node.getY(), db_node.getZ()));
        }
        return specifiedNodes;
    }
}
