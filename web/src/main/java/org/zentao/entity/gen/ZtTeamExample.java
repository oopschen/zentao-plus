package org.zentao.entity.gen;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ZtTeamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZtTeamExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andProjectIsNull() {
            addCriterion("project is null");
            return (Criteria) this;
        }

        public Criteria andProjectIsNotNull() {
            addCriterion("project is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEqualTo(Integer value) {
            addCriterion("project =", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotEqualTo(Integer value) {
            addCriterion("project <>", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThan(Integer value) {
            addCriterion("project >", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThanOrEqualTo(Integer value) {
            addCriterion("project >=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThan(Integer value) {
            addCriterion("project <", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThanOrEqualTo(Integer value) {
            addCriterion("project <=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectIn(List<Integer> values) {
            addCriterion("project in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotIn(List<Integer> values) {
            addCriterion("project not in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectBetween(Integer value1, Integer value2) {
            addCriterion("project between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotBetween(Integer value1, Integer value2) {
            addCriterion("project not between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("`role` is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("`role` is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(String value) {
            addCriterion("`role` =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(String value) {
            addCriterion("`role` <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(String value) {
            addCriterion("`role` >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(String value) {
            addCriterion("`role` >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(String value) {
            addCriterion("`role` <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(String value) {
            addCriterion("`role` <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLike(String value) {
            addCriterion("`role` like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotLike(String value) {
            addCriterion("`role` not like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<String> values) {
            addCriterion("`role` in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<String> values) {
            addCriterion("`role` not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(String value1, String value2) {
            addCriterion("`role` between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(String value1, String value2) {
            addCriterion("`role` not between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andLimiteduserIsNull() {
            addCriterion("limitedUser is null");
            return (Criteria) this;
        }

        public Criteria andLimiteduserIsNotNull() {
            addCriterion("limitedUser is not null");
            return (Criteria) this;
        }

        public Criteria andLimiteduserEqualTo(String value) {
            addCriterion("limitedUser =", value, "limiteduser");
            return (Criteria) this;
        }

        public Criteria andLimiteduserNotEqualTo(String value) {
            addCriterion("limitedUser <>", value, "limiteduser");
            return (Criteria) this;
        }

        public Criteria andLimiteduserGreaterThan(String value) {
            addCriterion("limitedUser >", value, "limiteduser");
            return (Criteria) this;
        }

        public Criteria andLimiteduserGreaterThanOrEqualTo(String value) {
            addCriterion("limitedUser >=", value, "limiteduser");
            return (Criteria) this;
        }

        public Criteria andLimiteduserLessThan(String value) {
            addCriterion("limitedUser <", value, "limiteduser");
            return (Criteria) this;
        }

        public Criteria andLimiteduserLessThanOrEqualTo(String value) {
            addCriterion("limitedUser <=", value, "limiteduser");
            return (Criteria) this;
        }

        public Criteria andLimiteduserLike(String value) {
            addCriterion("limitedUser like", value, "limiteduser");
            return (Criteria) this;
        }

        public Criteria andLimiteduserNotLike(String value) {
            addCriterion("limitedUser not like", value, "limiteduser");
            return (Criteria) this;
        }

        public Criteria andLimiteduserIn(List<String> values) {
            addCriterion("limitedUser in", values, "limiteduser");
            return (Criteria) this;
        }

        public Criteria andLimiteduserNotIn(List<String> values) {
            addCriterion("limitedUser not in", values, "limiteduser");
            return (Criteria) this;
        }

        public Criteria andLimiteduserBetween(String value1, String value2) {
            addCriterion("limitedUser between", value1, value2, "limiteduser");
            return (Criteria) this;
        }

        public Criteria andLimiteduserNotBetween(String value1, String value2) {
            addCriterion("limitedUser not between", value1, value2, "limiteduser");
            return (Criteria) this;
        }

        public Criteria andJoinIsNull() {
            addCriterion("`join` is null");
            return (Criteria) this;
        }

        public Criteria andJoinIsNotNull() {
            addCriterion("`join` is not null");
            return (Criteria) this;
        }

        public Criteria andJoinEqualTo(Date value) {
            addCriterionForJDBCDate("`join` =", value, "join");
            return (Criteria) this;
        }

        public Criteria andJoinNotEqualTo(Date value) {
            addCriterionForJDBCDate("`join` <>", value, "join");
            return (Criteria) this;
        }

        public Criteria andJoinGreaterThan(Date value) {
            addCriterionForJDBCDate("`join` >", value, "join");
            return (Criteria) this;
        }

        public Criteria andJoinGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("`join` >=", value, "join");
            return (Criteria) this;
        }

        public Criteria andJoinLessThan(Date value) {
            addCriterionForJDBCDate("`join` <", value, "join");
            return (Criteria) this;
        }

        public Criteria andJoinLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("`join` <=", value, "join");
            return (Criteria) this;
        }

        public Criteria andJoinIn(List<Date> values) {
            addCriterionForJDBCDate("`join` in", values, "join");
            return (Criteria) this;
        }

        public Criteria andJoinNotIn(List<Date> values) {
            addCriterionForJDBCDate("`join` not in", values, "join");
            return (Criteria) this;
        }

        public Criteria andJoinBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("`join` between", value1, value2, "join");
            return (Criteria) this;
        }

        public Criteria andJoinNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("`join` not between", value1, value2, "join");
            return (Criteria) this;
        }

        public Criteria andDaysIsNull() {
            addCriterion("`days` is null");
            return (Criteria) this;
        }

        public Criteria andDaysIsNotNull() {
            addCriterion("`days` is not null");
            return (Criteria) this;
        }

        public Criteria andDaysEqualTo(Short value) {
            addCriterion("`days` =", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotEqualTo(Short value) {
            addCriterion("`days` <>", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThan(Short value) {
            addCriterion("`days` >", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThanOrEqualTo(Short value) {
            addCriterion("`days` >=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThan(Short value) {
            addCriterion("`days` <", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThanOrEqualTo(Short value) {
            addCriterion("`days` <=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysIn(List<Short> values) {
            addCriterion("`days` in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotIn(List<Short> values) {
            addCriterion("`days` not in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysBetween(Short value1, Short value2) {
            addCriterion("`days` between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotBetween(Short value1, Short value2) {
            addCriterion("`days` not between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andHoursIsNull() {
            addCriterion("`hours` is null");
            return (Criteria) this;
        }

        public Criteria andHoursIsNotNull() {
            addCriterion("`hours` is not null");
            return (Criteria) this;
        }

        public Criteria andHoursEqualTo(Float value) {
            addCriterion("`hours` =", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursNotEqualTo(Float value) {
            addCriterion("`hours` <>", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursGreaterThan(Float value) {
            addCriterion("`hours` >", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursGreaterThanOrEqualTo(Float value) {
            addCriterion("`hours` >=", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursLessThan(Float value) {
            addCriterion("`hours` <", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursLessThanOrEqualTo(Float value) {
            addCriterion("`hours` <=", value, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursIn(List<Float> values) {
            addCriterion("`hours` in", values, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursNotIn(List<Float> values) {
            addCriterion("`hours` not in", values, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursBetween(Float value1, Float value2) {
            addCriterion("`hours` between", value1, value2, "hours");
            return (Criteria) this;
        }

        public Criteria andHoursNotBetween(Float value1, Float value2) {
            addCriterion("`hours` not between", value1, value2, "hours");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}