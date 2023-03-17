package com.example.XMLToBase.db.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "gar_mun_hierarchy")
public class GarMunHierarchy {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "objectid")
    private Long objectid;

    @Column(name = "parentobjid")
    private Long parentobjid;

    @Column(name = "changeid")
    private Long changeid;

    @Column(name = "oktmo")
    private String oktmo;

    @Column(name = "previd")
    private Long previd;

    @Column(name = "nextid")
    private Long nextid;

    @Column(name = "updatedate")
    private Date updatedate;

    @Column(name = "startdate")
    private Date startdate;

    @Column(name = "enddate")
    private Date enddate;

    @Column(name = "isactive")
    private Long isactive;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getObjectid() {
        return this.objectid;
    }

    public void setObjectid(Long objectid) {
        this.objectid = objectid;
    }

    public Long getParentobjid() {
        return this.parentobjid;
    }

    public void setParentobjid(Long parentobjid) {
        this.parentobjid = parentobjid;
    }

    public Long getChangeid() {
        return this.changeid;
    }

    public void setChangeid(Long changeid) {
        this.changeid = changeid;
    }

    public String getOktmo() {
        return this.oktmo;
    }

    public void setOktmo(String oktmo) {
        this.oktmo = oktmo;
    }

    public Long getPrevid() {
        return this.previd;
    }

    public void setPrevid(Long previd) {
        this.previd = previd;
    }

    public Long getNextid() {
        return this.nextid;
    }

    public void setNextid(Long nextid) {
        this.nextid = nextid;
    }

    public Date getUpdatedate() {
        return this.updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return this.enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Long getIsactive() {
        return this.isactive;
    }

    public void setIsactive(Long isactive) {
        this.isactive = isactive;
    }
}
