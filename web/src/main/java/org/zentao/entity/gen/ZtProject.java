package org.zentao.entity.gen;

import java.time.LocalDate;

public class ZtProject {
    private Integer id;

    private String iscat;

    private Integer catid;

    private String type;

    private Integer parent;

    private String name;

    private String code;

    private LocalDate begin;

    private LocalDate end;

    private Short days;

    private String status;

    private String statge;

    private String pri;

    private String openedby;

    private Integer openeddate;

    private String openedversion;

    private String closedby;

    private Integer closeddate;

    private String canceledby;

    private Integer canceleddate;

    private String po;

    private String pm;

    private String qd;

    private String rd;

    private String team;

    private String acl;

    private Integer order;

    private String deleted;

    private String desc;

    private String whitelist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIscat() {
        return iscat;
    }

    public void setIscat(String iscat) {
        this.iscat = iscat == null ? null : iscat.trim();
    }

    public Integer getCatid() {
        return catid;
    }

    public void setCatid(Integer catid) {
        this.catid = catid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Short getDays() {
        return days;
    }

    public void setDays(Short days) {
        this.days = days;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getStatge() {
        return statge;
    }

    public void setStatge(String statge) {
        this.statge = statge == null ? null : statge.trim();
    }

    public String getPri() {
        return pri;
    }

    public void setPri(String pri) {
        this.pri = pri == null ? null : pri.trim();
    }

    public String getOpenedby() {
        return openedby;
    }

    public void setOpenedby(String openedby) {
        this.openedby = openedby == null ? null : openedby.trim();
    }

    public Integer getOpeneddate() {
        return openeddate;
    }

    public void setOpeneddate(Integer openeddate) {
        this.openeddate = openeddate;
    }

    public String getOpenedversion() {
        return openedversion;
    }

    public void setOpenedversion(String openedversion) {
        this.openedversion = openedversion == null ? null : openedversion.trim();
    }

    public String getClosedby() {
        return closedby;
    }

    public void setClosedby(String closedby) {
        this.closedby = closedby == null ? null : closedby.trim();
    }

    public Integer getCloseddate() {
        return closeddate;
    }

    public void setCloseddate(Integer closeddate) {
        this.closeddate = closeddate;
    }

    public String getCanceledby() {
        return canceledby;
    }

    public void setCanceledby(String canceledby) {
        this.canceledby = canceledby == null ? null : canceledby.trim();
    }

    public Integer getCanceleddate() {
        return canceleddate;
    }

    public void setCanceleddate(Integer canceleddate) {
        this.canceleddate = canceleddate;
    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po == null ? null : po.trim();
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm == null ? null : pm.trim();
    }

    public String getQd() {
        return qd;
    }

    public void setQd(String qd) {
        this.qd = qd == null ? null : qd.trim();
    }

    public String getRd() {
        return rd;
    }

    public void setRd(String rd) {
        this.rd = rd == null ? null : rd.trim();
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team == null ? null : team.trim();
    }

    public String getAcl() {
        return acl;
    }

    public void setAcl(String acl) {
        this.acl = acl == null ? null : acl.trim();
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted == null ? null : deleted.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(String whitelist) {
        this.whitelist = whitelist == null ? null : whitelist.trim();
    }
}