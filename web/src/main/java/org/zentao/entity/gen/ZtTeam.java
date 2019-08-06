package org.zentao.entity.gen;

import java.util.Date;

public class ZtTeam {
    private Integer root;

    private String account;

    private String role;

    private String limited;

    private Date join;

    private Short days;

    private Float hours;


    public Integer getRoot() {
        return root;
    }

    public void setRoot(Integer root) {
        this.root = root;
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

    public String getLimited() {
        return limited;
    }

    public void setLimited(String limiteduser) {
        this.limited = limiteduser == null ? null : limiteduser.trim();
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