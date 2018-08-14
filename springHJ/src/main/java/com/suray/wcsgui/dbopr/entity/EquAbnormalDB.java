package com.suray.wcsgui.dbopr.entity;

import javax.persistence.*;

@Entity
@Table(name = "db_equAbnormal")
public class EquAbnormalDB {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 设备id
     */
    @ManyToOne(targetEntity = RgvDB.class)
    @JoinColumn(name = "rgvId", columnDefinition = "INT COMMENT '设备id'")
    private RgvDB assignedRgv;

    /**
     * 异常id
     */
    @ManyToOne(targetEntity = AbnormalDictionaryDB.class)
    @JoinColumn(name = "abdId", columnDefinition = "INT COMMENT '异常id'")
    private AbnormalDictionaryDB assignedAbnormalDictionary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RgvDB getAssignedRgv() {
        return assignedRgv;
    }

    public void setAssignedRgv(RgvDB assignedRgv) {
        this.assignedRgv = assignedRgv;
    }

    public AbnormalDictionaryDB getAssignedAbnormalDictionary() {
        return assignedAbnormalDictionary;
    }

    public void setAssignedAbnormalDictionary(AbnormalDictionaryDB assignedAbnormalDictionary) {
        this.assignedAbnormalDictionary = assignedAbnormalDictionary;
    }
}
