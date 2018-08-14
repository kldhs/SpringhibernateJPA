package com.suray.wcsgui.dbopr.entity;


import javax.persistence.*;

/**
 * @author Charles on 2018/5/15.
 */
@Entity
@Table(name = "db_rgv")
public class RgvDB {

    /**
     * 小车ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    /**
     * 小车IP
     */
    @Column(columnDefinition = "VARCHAR(20) COMMENT '小车IP'", nullable = false)
    protected String ip;


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
