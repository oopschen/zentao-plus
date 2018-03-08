package org.zentao.entity.gen;

import java.util.Date;

public class ZtTask {
    private Integer id;

    private Integer project;

    private Integer module;

    private Integer story;

    private Short storyversion;

    private Integer frombug;

    private String name;

    private String type;

    private Byte pri;

    private Float estimate;

    private Float consumed;

    private Float left;

    private Date deadline;

    private String status;

    private String color;

    private String openedby;

    private Date openeddate;

    private String assignedto;

    private Date assigneddate;

    private Date eststarted;

    private Date realstarted;

    private String finishedby;

    private Date finisheddate;

    private String canceledby;

    private Date canceleddate;

    private String closedby;

    private Date closeddate;

    private String closedreason;

    private String lasteditedby;

    private Date lastediteddate;

    private String deleted;

    private String mailto;

    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProject() {
        return project;
    }

    public void setProject(Integer project) {
        this.project = project;
    }

    public Integer getModule() {
        return module;
    }

    public void setModule(Integer module) {
        this.module = module;
    }

    public Integer getStory() {
        return story;
    }

    public void setStory(Integer story) {
        this.story = story;
    }

    public Short getStoryversion() {
        return storyversion;
    }

    public void setStoryversion(Short storyversion) {
        this.storyversion = storyversion;
    }

    public Integer getFrombug() {
        return frombug;
    }

    public void setFrombug(Integer frombug) {
        this.frombug = frombug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Byte getPri() {
        return pri;
    }

    public void setPri(Byte pri) {
        this.pri = pri;
    }

    public Float getEstimate() {
        return estimate;
    }

    public void setEstimate(Float estimate) {
        this.estimate = estimate;
    }

    public Float getConsumed() {
        return consumed;
    }

    public void setConsumed(Float consumed) {
        this.consumed = consumed;
    }

    public Float getLeft() {
        return left;
    }

    public void setLeft(Float left) {
        this.left = left;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getOpenedby() {
        return openedby;
    }

    public void setOpenedby(String openedby) {
        this.openedby = openedby == null ? null : openedby.trim();
    }

    public Date getOpeneddate() {
        return openeddate;
    }

    public void setOpeneddate(Date openeddate) {
        this.openeddate = openeddate;
    }

    public String getAssignedto() {
        return assignedto;
    }

    public void setAssignedto(String assignedto) {
        this.assignedto = assignedto == null ? null : assignedto.trim();
    }

    public Date getAssigneddate() {
        return assigneddate;
    }

    public void setAssigneddate(Date assigneddate) {
        this.assigneddate = assigneddate;
    }

    public Date getEststarted() {
        return eststarted;
    }

    public void setEststarted(Date eststarted) {
        this.eststarted = eststarted;
    }

    public Date getRealstarted() {
        return realstarted;
    }

    public void setRealstarted(Date realstarted) {
        this.realstarted = realstarted;
    }

    public String getFinishedby() {
        return finishedby;
    }

    public void setFinishedby(String finishedby) {
        this.finishedby = finishedby == null ? null : finishedby.trim();
    }

    public Date getFinisheddate() {
        return finisheddate;
    }

    public void setFinisheddate(Date finisheddate) {
        this.finisheddate = finisheddate;
    }

    public String getCanceledby() {
        return canceledby;
    }

    public void setCanceledby(String canceledby) {
        this.canceledby = canceledby == null ? null : canceledby.trim();
    }

    public Date getCanceleddate() {
        return canceleddate;
    }

    public void setCanceleddate(Date canceleddate) {
        this.canceleddate = canceleddate;
    }

    public String getClosedby() {
        return closedby;
    }

    public void setClosedby(String closedby) {
        this.closedby = closedby == null ? null : closedby.trim();
    }

    public Date getCloseddate() {
        return closeddate;
    }

    public void setCloseddate(Date closeddate) {
        this.closeddate = closeddate;
    }

    public String getClosedreason() {
        return closedreason;
    }

    public void setClosedreason(String closedreason) {
        this.closedreason = closedreason == null ? null : closedreason.trim();
    }

    public String getLasteditedby() {
        return lasteditedby;
    }

    public void setLasteditedby(String lasteditedby) {
        this.lasteditedby = lasteditedby == null ? null : lasteditedby.trim();
    }

    public Date getLastediteddate() {
        return lastediteddate;
    }

    public void setLastediteddate(Date lastediteddate) {
        this.lastediteddate = lastediteddate;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted == null ? null : deleted.trim();
    }

    public String getMailto() {
        return mailto;
    }

    public void setMailto(String mailto) {
        this.mailto = mailto == null ? null : mailto.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}