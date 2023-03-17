package com.example.XMLToBase.db.entity;

import javax.persistence.*;
import java.util.Date;

//<OBJECT ID="1178934" OBJECTID="948460" OBJECTGUID="b6ea12e7-eb66-46e4-9329-fb3dbfd09827"
//        CHANGEID="2615278"
//        NAME="Ветеран квартал 6"
//        TYPENAME="снт" LEVEL="7"
//        OPERTYPEID="50" PREVID="1178870"
//        NEXTID="1909861" UPDATEDATE="2021-05-07" STARTDATE="2016-09-29" ENDDATE="2021-05-07"
//        ISACTUAL="0" ISACTIVE="0" /><OBJECT ID="1909471" OBJECTID="101148944"
//        OBJECTGUID="73104935-cc12-4bc7-b2d1-70c431aa7005" CHANGEID="192807935"
//        NAME="Южный" TYPENAME="пер" LEVEL="8" OPERTYPEID="10" PREVID="0" NEXTID="0"
//        UPDATEDATE="2021-05-05" STARTDATE="2021-05-05" ENDDATE="2079-06-06" ISACTUAL="1"
//        ISACTIVE="1" /><OBJECT ID="1909861" OBJECTID="948460" OBJECTGUID="b6ea12e7-eb66-46e4-9329-fb3dbfd09827"
//        CHANGEID="192832273" NAME="Ветеран квартал 6" TYPENAME="снт" LEVEL="7" OPERTYPEID="30" PREVID="1178934" NEXTID="0"
//        UPDATEDATE="2021-05-07" STARTDATE="2021-05-07" ENDDATE="2079-06-06" ISACTUAL="1" ISACTIVE="0" /></ADDRESSOBJECTS>

@Entity
@Table(name = "gar_addressobject")
public class GarAddressobject {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "objectid")
    private Long objectid;

    @Column(name = "objectguid")
    private String objectguid;

    @Column(name = "changeid")
    private Long changeid;

    @Column(name = "name")
    private String name;

    @Column(name = "typename")
    private String typename;

    @Column(name = "level")
    private String level;

    @Column(name = "opertypeid")
    private Long opertypeid;

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

    @Column(name = "isactual")
    private Long isactual;

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

    public String getObjectguid() {
        return this.objectguid;
    }

    public void setObjectguid(String objectguid) {
        this.objectguid = objectguid;
    }

    public Long getChangeid() {
        return this.changeid;
    }

    public void setChangeid(Long changeid) {
        this.changeid = changeid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypename() {
        return this.typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getOpertypeid() {
        return this.opertypeid;
    }

    public void setOpertypeid(Long opertypeid) {
        this.opertypeid = opertypeid;
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

    public Long getIsactual() {
        return this.isactual;
    }

    public void setIsactual(Long isactual) {
        this.isactual = isactual;
    }

    public Long getIsactive() {
        return this.isactive;
    }

    public void setIsactive(Long isactive) {
        this.isactive = isactive;
    }
}
