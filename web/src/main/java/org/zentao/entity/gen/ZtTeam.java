package org.zentao.entity.gen;

import java.util.Date;

public class ZtTeam {
    private Integer project;

    private String account;

    private String role;

    private String limiteduser;

    private Date join;

    private Short days;

    private Float hours;

    public Integer getProject() {
        return project;
    }

    public void setProject(Integer project) {
        this.project = project;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getLimiteduser() {
        return limiteduser;
    }

    public void setLimiteduser(String limiteduser) {
        this.limiteduser = limiteduser == null ? null : limiteduser.trim();
    }

    public Date getJoin() {
        return join;
    }

    public void setJoin(Date join) {
        this.join = join;
    }

    public Short getDays() {
        return days;
    }

    public void setDays(Short days) {
        this.days = days;
    }

    public Float getHours() {
        return hours;
    }

    public void setHours(Float hours) {
        this.hours = hours;
    }
}