package com.suray.wcsgui.dbopr.entity;


import javax.persistence.*;


@Entity
@Table(name = "db_abnormaldictionary")
public class AbnormalDictionaryDB {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 异常编号
     */
    @Column(columnDefinition = "char(20) COMMENT '异常编号'", nullable = false)
    private String AbnormalNum;

    /**
     * 异常详情
     */
    @Column(columnDefinition = "char(100) COMMENT '异常详情'", nullable = false)
    private String AbnormalInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbnormalNum() {
        return AbnormalNum;
    }

    public void setAbnormalNum(String abnormalNum) {
        AbnormalNum = abnormalNum;
    }

    public String getAbnormalInfo() {
        return AbnormalInfo;
    }

    public void setAbnormalInfo(String abnormalInfo) {
        AbnormalInfo = abnormalInfo;
    }
}
