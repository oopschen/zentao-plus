package org.zentao.entity.gen;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ZtTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZtTaskExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andModuleIsNull() {
            addCriterion("module is null");
            return (Criteria) this;
        }

        public Criteria andModuleIsNotNull() {
            addCriterion("module is not null");
            return (Criteria) this;
        }

        public Criteria andModuleEqualTo(Integer value) {
            addCriterion("module =", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotEqualTo(Integer value) {
            addCriterion("module <>", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleGreaterThan(Integer value) {
            addCriterion("module >", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleGreaterThanOrEqualTo(Integer value) {
            addCriterion("module >=", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLessThan(Integer value) {
            addCriterion("module <", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleLessThanOrEqualTo(Integer value) {
            addCriterion("module <=", value, "module");
            return (Criteria) this;
        }

        public Criteria andModuleIn(List<Integer> values) {
            addCriterion("module in", values, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotIn(List<Integer> values) {
            addCriterion("module not in", values, "module");
            return (Criteria) this;
        }

        public Criteria andModuleBetween(Integer value1, Integer value2) {
            addCriterion("module between", value1, value2, "module");
            return (Criteria) this;
        }

        public Criteria andModuleNotBetween(Integer value1, Integer value2) {
            addCriterion("module not between", value1, value2, "module");
            return (Criteria) this;
        }

        public Criteria andStoryIsNull() {
            addCriterion("story is null");
            return (Criteria) this;
        }

        public Criteria andStoryIsNotNull() {
            addCriterion("story is not null");
            return (Criteria) this;
        }

        public Criteria andStoryEqualTo(Integer value) {
            addCriterion("story =", value, "story");
            return (Criteria) this;
        }

        public Criteria andStoryNotEqualTo(Integer value) {
            addCriterion("story <>", value, "story");
            return (Criteria) this;
        }

        public Criteria andStoryGreaterThan(Integer value) {
            addCriterion("story >", value, "story");
            return (Criteria) this;
        }

        public Criteria andStoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("story >=", value, "story");
            return (Criteria) this;
        }

        public Criteria andStoryLessThan(Integer value) {
            addCriterion("story <", value, "story");
            return (Criteria) this;
        }

        public Criteria andStoryLessThanOrEqualTo(Integer value) {
            addCriterion("story <=", value, "story");
            return (Criteria) this;
        }

        public Criteria andStoryIn(List<Integer> values) {
            addCriterion("story in", values, "story");
            return (Criteria) this;
        }

        public Criteria andStoryNotIn(List<Integer> values) {
            addCriterion("story not in", values, "story");
            return (Criteria) this;
        }

        public Criteria andStoryBetween(Integer value1, Integer value2) {
            addCriterion("story between", value1, value2, "story");
            return (Criteria) this;
        }

        public Criteria andStoryNotBetween(Integer value1, Integer value2) {
            addCriterion("story not between", value1, value2, "story");
            return (Criteria) this;
        }

        public Criteria andStoryversionIsNull() {
            addCriterion("storyVersion is null");
            return (Criteria) this;
        }

        public Criteria andStoryversionIsNotNull() {
            addCriterion("storyVersion is not null");
            return (Criteria) this;
        }

        public Criteria andStoryversionEqualTo(Short value) {
            addCriterion("storyVersion =", value, "storyversion");
            return (Criteria) this;
        }

        public Criteria andStoryversionNotEqualTo(Short value) {
            addCriterion("storyVersion <>", value, "storyversion");
            return (Criteria) this;
        }

        public Criteria andStoryversionGreaterThan(Short value) {
            addCriterion("storyVersion >", value, "storyversion");
            return (Criteria) this;
        }

        public Criteria andStoryversionGreaterThanOrEqualTo(Short value) {
            addCriterion("storyVersion >=", value, "storyversion");
            return (Criteria) this;
        }

        public Criteria andStoryversionLessThan(Short value) {
            addCriterion("storyVersion <", value, "storyversion");
            return (Criteria) this;
        }

        public Criteria andStoryversionLessThanOrEqualTo(Short value) {
            addCriterion("storyVersion <=", value, "storyversion");
            return (Criteria) this;
        }

        public Criteria andStoryversionIn(List<Short> values) {
            addCriterion("storyVersion in", values, "storyversion");
            return (Criteria) this;
        }

        public Criteria andStoryversionNotIn(List<Short> values) {
            addCriterion("storyVersion not in", values, "storyversion");
            return (Criteria) this;
        }

        public Criteria andStoryversionBetween(Short value1, Short value2) {
            addCriterion("storyVersion between", value1, value2, "storyversion");
            return (Criteria) this;
        }

        public Criteria andStoryversionNotBetween(Short value1, Short value2) {
            addCriterion("storyVersion not between", value1, value2, "storyversion");
            return (Criteria) this;
        }

        public Criteria andFrombugIsNull() {
            addCriterion("fromBug is null");
            return (Criteria) this;
        }

        public Criteria andFrombugIsNotNull() {
            addCriterion("fromBug is not null");
            return (Criteria) this;
        }

        public Criteria andFrombugEqualTo(Integer value) {
            addCriterion("fromBug =", value, "frombug");
            return (Criteria) this;
        }

        public Criteria andFrombugNotEqualTo(Integer value) {
            addCriterion("fromBug <>", value, "frombug");
            return (Criteria) this;
        }

        public Criteria andFrombugGreaterThan(Integer value) {
            addCriterion("fromBug >", value, "frombug");
            return (Criteria) this;
        }

        public Criteria andFrombugGreaterThanOrEqualTo(Integer value) {
            addCriterion("fromBug >=", value, "frombug");
            return (Criteria) this;
        }

        public Criteria andFrombugLessThan(Integer value) {
            addCriterion("fromBug <", value, "frombug");
            return (Criteria) this;
        }

        public Criteria andFrombugLessThanOrEqualTo(Integer value) {
            addCriterion("fromBug <=", value, "frombug");
            return (Criteria) this;
        }

        public Criteria andFrombugIn(List<Integer> values) {
            addCriterion("fromBug in", values, "frombug");
            return (Criteria) this;
        }

        public Criteria andFrombugNotIn(List<Integer> values) {
            addCriterion("fromBug not in", values, "frombug");
            return (Criteria) this;
        }

        public Criteria andFrombugBetween(Integer value1, Integer value2) {
            addCriterion("fromBug between", value1, value2, "frombug");
            return (Criteria) this;
        }

        public Criteria andFrombugNotBetween(Integer value1, Integer value2) {
            addCriterion("fromBug not between", value1, value2, "frombug");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andPriIsNull() {
            addCriterion("pri is null");
            return (Criteria) this;
        }

        public Criteria andPriIsNotNull() {
            addCriterion("pri is not null");
            return (Criteria) this;
        }

        public Criteria andPriEqualTo(Byte value) {
            addCriterion("pri =", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriNotEqualTo(Byte value) {
            addCriterion("pri <>", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriGreaterThan(Byte value) {
            addCriterion("pri >", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriGreaterThanOrEqualTo(Byte value) {
            addCriterion("pri >=", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriLessThan(Byte value) {
            addCriterion("pri <", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriLessThanOrEqualTo(Byte value) {
            addCriterion("pri <=", value, "pri");
            return (Criteria) this;
        }

        public Criteria andPriIn(List<Byte> values) {
            addCriterion("pri in", values, "pri");
            return (Criteria) this;
        }

        public Criteria andPriNotIn(List<Byte> values) {
            addCriterion("pri not in", values, "pri");
            return (Criteria) this;
        }

        public Criteria andPriBetween(Byte value1, Byte value2) {
            addCriterion("pri between", value1, value2, "pri");
            return (Criteria) this;
        }

        public Criteria andPriNotBetween(Byte value1, Byte value2) {
            addCriterion("pri not between", value1, value2, "pri");
            return (Criteria) this;
        }

        public Criteria andEstimateIsNull() {
            addCriterion("estimate is null");
            return (Criteria) this;
        }

        public Criteria andEstimateIsNotNull() {
            addCriterion("estimate is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateEqualTo(Float value) {
            addCriterion("estimate =", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateNotEqualTo(Float value) {
            addCriterion("estimate <>", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateGreaterThan(Float value) {
            addCriterion("estimate >", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateGreaterThanOrEqualTo(Float value) {
            addCriterion("estimate >=", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateLessThan(Float value) {
            addCriterion("estimate <", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateLessThanOrEqualTo(Float value) {
            addCriterion("estimate <=", value, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateIn(List<Float> values) {
            addCriterion("estimate in", values, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateNotIn(List<Float> values) {
            addCriterion("estimate not in", values, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateBetween(Float value1, Float value2) {
            addCriterion("estimate between", value1, value2, "estimate");
            return (Criteria) this;
        }

        public Criteria andEstimateNotBetween(Float value1, Float value2) {
            addCriterion("estimate not between", value1, value2, "estimate");
            return (Criteria) this;
        }

        public Criteria andConsumedIsNull() {
            addCriterion("consumed is null");
            return (Criteria) this;
        }

        public Criteria andConsumedIsNotNull() {
            addCriterion("consumed is not null");
            return (Criteria) this;
        }

        public Criteria andConsumedEqualTo(Float value) {
            addCriterion("consumed =", value, "consumed");
            return (Criteria) this;
        }

        public Criteria andConsumedNotEqualTo(Float value) {
            addCriterion("consumed <>", value, "consumed");
            return (Criteria) this;
        }

        public Criteria andConsumedGreaterThan(Float value) {
            addCriterion("consumed >", value, "consumed");
            return (Criteria) this;
        }

        public Criteria andConsumedGreaterThanOrEqualTo(Float value) {
            addCriterion("consumed >=", value, "consumed");
            return (Criteria) this;
        }

        public Criteria andConsumedLessThan(Float value) {
            addCriterion("consumed <", value, "consumed");
            return (Criteria) this;
        }

        public Criteria andConsumedLessThanOrEqualTo(Float value) {
            addCriterion("consumed <=", value, "consumed");
            return (Criteria) this;
        }

        public Criteria andConsumedIn(List<Float> values) {
            addCriterion("consumed in", values, "consumed");
            return (Criteria) this;
        }

        public Criteria andConsumedNotIn(List<Float> values) {
            addCriterion("consumed not in", values, "consumed");
            return (Criteria) this;
        }

        public Criteria andConsumedBetween(Float value1, Float value2) {
            addCriterion("consumed between", value1, value2, "consumed");
            return (Criteria) this;
        }

        public Criteria andConsumedNotBetween(Float value1, Float value2) {
            addCriterion("consumed not between", value1, value2, "consumed");
            return (Criteria) this;
        }

        public Criteria andLeftIsNull() {
            addCriterion("left is null");
            return (Criteria) this;
        }

        public Criteria andLeftIsNotNull() {
            addCriterion("left is not null");
            return (Criteria) this;
        }

        public Criteria andLeftEqualTo(Float value) {
            addCriterion("left =", value, "left");
            return (Criteria) this;
        }

        public Criteria andLeftNotEqualTo(Float value) {
            addCriterion("left <>", value, "left");
            return (Criteria) this;
        }

        public Criteria andLeftGreaterThan(Float value) {
            addCriterion("left >", value, "left");
            return (Criteria) this;
        }

        public Criteria andLeftGreaterThanOrEqualTo(Float value) {
            addCriterion("left >=", value, "left");
            return (Criteria) this;
        }

        public Criteria andLeftLessThan(Float value) {
            addCriterion("left <", value, "left");
            return (Criteria) this;
        }

        public Criteria andLeftLessThanOrEqualTo(Float value) {
            addCriterion("left <=", value, "left");
            return (Criteria) this;
        }

        public Criteria andLeftIn(List<Float> values) {
            addCriterion("left in", values, "left");
            return (Criteria) this;
        }

        public Criteria andLeftNotIn(List<Float> values) {
            addCriterion("left not in", values, "left");
            return (Criteria) this;
        }

        public Criteria andLeftBetween(Float value1, Float value2) {
            addCriterion("left between", value1, value2, "left");
            return (Criteria) this;
        }

        public Criteria andLeftNotBetween(Float value1, Float value2) {
            addCriterion("left not between", value1, value2, "left");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNull() {
            addCriterion("deadline is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineIsNotNull() {
            addCriterion("deadline is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineEqualTo(Date value) {
            addCriterionForJDBCDate("deadline =", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotEqualTo(Date value) {
            addCriterionForJDBCDate("deadline <>", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThan(Date value) {
            addCriterionForJDBCDate("deadline >", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deadline >=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThan(Date value) {
            addCriterionForJDBCDate("deadline <", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("deadline <=", value, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineIn(List<Date> values) {
            addCriterionForJDBCDate("deadline in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotIn(List<Date> values) {
            addCriterionForJDBCDate("deadline not in", values, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deadline between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andDeadlineNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("deadline not between", value1, value2, "deadline");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andOpenedbyIsNull() {
            addCriterion("openedBy is null");
            return (Criteria) this;
        }

        public Criteria andOpenedbyIsNotNull() {
            addCriterion("openedBy is not null");
            return (Criteria) this;
        }

        public Criteria andOpenedbyEqualTo(String value) {
            addCriterion("openedBy =", value, "openedby");
            return (Criteria) this;
        }

        public Criteria andOpenedbyNotEqualTo(String value) {
            addCriterion("openedBy <>", value, "openedby");
            return (Criteria) this;
        }

        public Criteria andOpenedbyGreaterThan(String value) {
            addCriterion("openedBy >", value, "openedby");
            return (Criteria) this;
        }

        public Criteria andOpenedbyGreaterThanOrEqualTo(String value) {
            addCriterion("openedBy >=", value, "openedby");
            return (Criteria) this;
        }

        public Criteria andOpenedbyLessThan(String value) {
            addCriterion("openedBy <", value, "openedby");
            return (Criteria) this;
        }

        public Criteria andOpenedbyLessThanOrEqualTo(String value) {
            addCriterion("openedBy <=", value, "openedby");
            return (Criteria) this;
        }

        public Criteria andOpenedbyLike(String value) {
            addCriterion("openedBy like", value, "openedby");
            return (Criteria) this;
        }

        public Criteria andOpenedbyNotLike(String value) {
            addCriterion("openedBy not like", value, "openedby");
            return (Criteria) this;
        }

        public Criteria andOpenedbyIn(List<String> values) {
            addCriterion("openedBy in", values, "openedby");
            return (Criteria) this;
        }

        public Criteria andOpenedbyNotIn(List<String> values) {
            addCriterion("openedBy not in", values, "openedby");
            return (Criteria) this;
        }

        public Criteria andOpenedbyBetween(String value1, String value2) {
            addCriterion("openedBy between", value1, value2, "openedby");
            return (Criteria) this;
        }

        public Criteria andOpenedbyNotBetween(String value1, String value2) {
            addCriterion("openedBy not between", value1, value2, "openedby");
            return (Criteria) this;
        }

        public Criteria andOpeneddateIsNull() {
            addCriterion("openedDate is null");
            return (Criteria) this;
        }

        public Criteria andOpeneddateIsNotNull() {
            addCriterion("openedDate is not null");
            return (Criteria) this;
        }

        public Criteria andOpeneddateEqualTo(Date value) {
            addCriterion("openedDate =", value, "openeddate");
            return (Criteria) this;
        }

        public Criteria andOpeneddateNotEqualTo(Date value) {
            addCriterion("openedDate <>", value, "openeddate");
            return (Criteria) this;
        }

        public Criteria andOpeneddateGreaterThan(Date value) {
            addCriterion("openedDate >", value, "openeddate");
            return (Criteria) this;
        }

        public Criteria andOpeneddateGreaterThanOrEqualTo(Date value) {
            addCriterion("openedDate >=", value, "openeddate");
            return (Criteria) this;
        }

        public Criteria andOpeneddateLessThan(Date value) {
            addCriterion("openedDate <", value, "openeddate");
            return (Criteria) this;
        }

        public Criteria andOpeneddateLessThanOrEqualTo(Date value) {
            addCriterion("openedDate <=", value, "openeddate");
            return (Criteria) this;
        }

        public Criteria andOpeneddateIn(List<Date> values) {
            addCriterion("openedDate in", values, "openeddate");
            return (Criteria) this;
        }

        public Criteria andOpeneddateNotIn(List<Date> values) {
            addCriterion("openedDate not in", values, "openeddate");
            return (Criteria) this;
        }

        public Criteria andOpeneddateBetween(Date value1, Date value2) {
            addCriterion("openedDate between", value1, value2, "openeddate");
            return (Criteria) this;
        }

        public Criteria andOpeneddateNotBetween(Date value1, Date value2) {
            addCriterion("openedDate not between", value1, value2, "openeddate");
            return (Criteria) this;
        }

        public Criteria andAssignedtoIsNull() {
            addCriterion("assignedTo is null");
            return (Criteria) this;
        }

        public Criteria andAssignedtoIsNotNull() {
            addCriterion("assignedTo is not null");
            return (Criteria) this;
        }

        public Criteria andAssignedtoEqualTo(String value) {
            addCriterion("assignedTo =", value, "assignedto");
            return (Criteria) this;
        }

        public Criteria andAssignedtoNotEqualTo(String value) {
            addCriterion("assignedTo <>", value, "assignedto");
            return (Criteria) this;
        }

        public Criteria andAssignedtoGreaterThan(String value) {
            addCriterion("assignedTo >", value, "assignedto");
            return (Criteria) this;
        }

        public Criteria andAssignedtoGreaterThanOrEqualTo(String value) {
            addCriterion("assignedTo >=", value, "assignedto");
            return (Criteria) this;
        }

        public Criteria andAssignedtoLessThan(String value) {
            addCriterion("assignedTo <", value, "assignedto");
            return (Criteria) this;
        }

        public Criteria andAssignedtoLessThanOrEqualTo(String value) {
            addCriterion("assignedTo <=", value, "assignedto");
            return (Criteria) this;
        }

        public Criteria andAssignedtoLike(String value) {
            addCriterion("assignedTo like", value, "assignedto");
            return (Criteria) this;
        }

        public Criteria andAssignedtoNotLike(String value) {
            addCriterion("assignedTo not like", value, "assignedto");
            return (Criteria) this;
        }

        public Criteria andAssignedtoIn(List<String> values) {
            addCriterion("assignedTo in", values, "assignedto");
            return (Criteria) this;
        }

        public Criteria andAssignedtoNotIn(List<String> values) {
            addCriterion("assignedTo not in", values, "assignedto");
            return (Criteria) this;
        }

        public Criteria andAssignedtoBetween(String value1, String value2) {
            addCriterion("assignedTo between", value1, value2, "assignedto");
            return (Criteria) this;
        }

        public Criteria andAssignedtoNotBetween(String value1, String value2) {
            addCriterion("assignedTo not between", value1, value2, "assignedto");
            return (Criteria) this;
        }

        public Criteria andAssigneddateIsNull() {
            addCriterion("assignedDate is null");
            return (Criteria) this;
        }

        public Criteria andAssigneddateIsNotNull() {
            addCriterion("assignedDate is not null");
            return (Criteria) this;
        }

        public Criteria andAssigneddateEqualTo(Date value) {
            addCriterion("assignedDate =", value, "assigneddate");
            return (Criteria) this;
        }

        public Criteria andAssigneddateNotEqualTo(Date value) {
            addCriterion("assignedDate <>", value, "assigneddate");
            return (Criteria) this;
        }

        public Criteria andAssigneddateGreaterThan(Date value) {
            addCriterion("assignedDate >", value, "assigneddate");
            return (Criteria) this;
        }

        public Criteria andAssigneddateGreaterThanOrEqualTo(Date value) {
            addCriterion("assignedDate >=", value, "assigneddate");
            return (Criteria) this;
        }

        public Criteria andAssigneddateLessThan(Date value) {
            addCriterion("assignedDate <", value, "assigneddate");
            return (Criteria) this;
        }

        public Criteria andAssigneddateLessThanOrEqualTo(Date value) {
            addCriterion("assignedDate <=", value, "assigneddate");
            return (Criteria) this;
        }

        public Criteria andAssigneddateIn(List<Date> values) {
            addCriterion("assignedDate in", values, "assigneddate");
            return (Criteria) this;
        }

        public Criteria andAssigneddateNotIn(List<Date> values) {
            addCriterion("assignedDate not in", values, "assigneddate");
            return (Criteria) this;
        }

        public Criteria andAssigneddateBetween(Date value1, Date value2) {
            addCriterion("assignedDate between", value1, value2, "assigneddate");
            return (Criteria) this;
        }

        public Criteria andAssigneddateNotBetween(Date value1, Date value2) {
            addCriterion("assignedDate not between", value1, value2, "assigneddate");
            return (Criteria) this;
        }

        public Criteria andEststartedIsNull() {
            addCriterion("estStarted is null");
            return (Criteria) this;
        }

        public Criteria andEststartedIsNotNull() {
            addCriterion("estStarted is not null");
            return (Criteria) this;
        }

        public Criteria andEststartedEqualTo(Date value) {
            addCriterionForJDBCDate("estStarted =", value, "eststarted");
            return (Criteria) this;
        }

        public Criteria andEststartedNotEqualTo(Date value) {
            addCriterionForJDBCDate("estStarted <>", value, "eststarted");
            return (Criteria) this;
        }

        public Criteria andEststartedGreaterThan(Date value) {
            addCriterionForJDBCDate("estStarted >", value, "eststarted");
            return (Criteria) this;
        }

        public Criteria andEststartedGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("estStarted >=", value, "eststarted");
            return (Criteria) this;
        }

        public Criteria andEststartedLessThan(Date value) {
            addCriterionForJDBCDate("estStarted <", value, "eststarted");
            return (Criteria) this;
        }

        public Criteria andEststartedLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("estStarted <=", value, "eststarted");
            return (Criteria) this;
        }

        public Criteria andEststartedIn(List<Date> values) {
            addCriterionForJDBCDate("estStarted in", values, "eststarted");
            return (Criteria) this;
        }

        public Criteria andEststartedNotIn(List<Date> values) {
            addCriterionForJDBCDate("estStarted not in", values, "eststarted");
            return (Criteria) this;
        }

        public Criteria andEststartedBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("estStarted between", value1, value2, "eststarted");
            return (Criteria) this;
        }

        public Criteria andEststartedNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("estStarted not between", value1, value2, "eststarted");
            return (Criteria) this;
        }

        public Criteria andRealstartedIsNull() {
            addCriterion("realStarted is null");
            return (Criteria) this;
        }

        public Criteria andRealstartedIsNotNull() {
            addCriterion("realStarted is not null");
            return (Criteria) this;
        }

        public Criteria andRealstartedEqualTo(Date value) {
            addCriterionForJDBCDate("realStarted =", value, "realstarted");
            return (Criteria) this;
        }

        public Criteria andRealstartedNotEqualTo(Date value) {
            addCriterionForJDBCDate("realStarted <>", value, "realstarted");
            return (Criteria) this;
        }

        public Criteria andRealstartedGreaterThan(Date value) {
            addCriterionForJDBCDate("realStarted >", value, "realstarted");
            return (Criteria) this;
        }

        public Criteria andRealstartedGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("realStarted >=", value, "realstarted");
            return (Criteria) this;
        }

        public Criteria andRealstartedLessThan(Date value) {
            addCriterionForJDBCDate("realStarted <", value, "realstarted");
            return (Criteria) this;
        }

        public Criteria andRealstartedLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("realStarted <=", value, "realstarted");
            return (Criteria) this;
        }

        public Criteria andRealstartedIn(List<Date> values) {
            addCriterionForJDBCDate("realStarted in", values, "realstarted");
            return (Criteria) this;
        }

        public Criteria andRealstartedNotIn(List<Date> values) {
            addCriterionForJDBCDate("realStarted not in", values, "realstarted");
            return (Criteria) this;
        }

        public Criteria andRealstartedBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("realStarted between", value1, value2, "realstarted");
            return (Criteria) this;
        }

        public Criteria andRealstartedNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("realStarted not between", value1, value2, "realstarted");
            return (Criteria) this;
        }

        public Criteria andFinishedbyIsNull() {
            addCriterion("finishedBy is null");
            return (Criteria) this;
        }

        public Criteria andFinishedbyIsNotNull() {
            addCriterion("finishedBy is not null");
            return (Criteria) this;
        }

        public Criteria andFinishedbyEqualTo(String value) {
            addCriterion("finishedBy =", value, "finishedby");
            return (Criteria) this;
        }

        public Criteria andFinishedbyNotEqualTo(String value) {
            addCriterion("finishedBy <>", value, "finishedby");
            return (Criteria) this;
        }

        public Criteria andFinishedbyGreaterThan(String value) {
            addCriterion("finishedBy >", value, "finishedby");
            return (Criteria) this;
        }

        public Criteria andFinishedbyGreaterThanOrEqualTo(String value) {
            addCriterion("finishedBy >=", value, "finishedby");
            return (Criteria) this;
        }

        public Criteria andFinishedbyLessThan(String value) {
            addCriterion("finishedBy <", value, "finishedby");
            return (Criteria) this;
        }

        public Criteria andFinishedbyLessThanOrEqualTo(String value) {
            addCriterion("finishedBy <=", value, "finishedby");
            return (Criteria) this;
        }

        public Criteria andFinishedbyLike(String value) {
            addCriterion("finishedBy like", value, "finishedby");
            return (Criteria) this;
        }

        public Criteria andFinishedbyNotLike(String value) {
            addCriterion("finishedBy not like", value, "finishedby");
            return (Criteria) this;
        }

        public Criteria andFinishedbyIn(List<String> values) {
            addCriterion("finishedBy in", values, "finishedby");
            return (Criteria) this;
        }

        public Criteria andFinishedbyNotIn(List<String> values) {
            addCriterion("finishedBy not in", values, "finishedby");
            return (Criteria) this;
        }

        public Criteria andFinishedbyBetween(String value1, String value2) {
            addCriterion("finishedBy between", value1, value2, "finishedby");
            return (Criteria) this;
        }

        public Criteria andFinishedbyNotBetween(String value1, String value2) {
            addCriterion("finishedBy not between", value1, value2, "finishedby");
            return (Criteria) this;
        }

        public Criteria andFinisheddateIsNull() {
            addCriterion("finishedDate is null");
            return (Criteria) this;
        }

        public Criteria andFinisheddateIsNotNull() {
            addCriterion("finishedDate is not null");
            return (Criteria) this;
        }

        public Criteria andFinisheddateEqualTo(Date value) {
            addCriterion("finishedDate =", value, "finisheddate");
            return (Criteria) this;
        }

        public Criteria andFinisheddateNotEqualTo(Date value) {
            addCriterion("finishedDate <>", value, "finisheddate");
            return (Criteria) this;
        }

        public Criteria andFinisheddateGreaterThan(Date value) {
            addCriterion("finishedDate >", value, "finisheddate");
            return (Criteria) this;
        }

        public Criteria andFinisheddateGreaterThanOrEqualTo(Date value) {
            addCriterion("finishedDate >=", value, "finisheddate");
            return (Criteria) this;
        }

        public Criteria andFinisheddateLessThan(Date value) {
            addCriterion("finishedDate <", value, "finisheddate");
            return (Criteria) this;
        }

        public Criteria andFinisheddateLessThanOrEqualTo(Date value) {
            addCriterion("finishedDate <=", value, "finisheddate");
            return (Criteria) this;
        }

        public Criteria andFinisheddateIn(List<Date> values) {
            addCriterion("finishedDate in", values, "finisheddate");
            return (Criteria) this;
        }

        public Criteria andFinisheddateNotIn(List<Date> values) {
            addCriterion("finishedDate not in", values, "finisheddate");
            return (Criteria) this;
        }

        public Criteria andFinisheddateBetween(Date value1, Date value2) {
            addCriterion("finishedDate between", value1, value2, "finisheddate");
            return (Criteria) this;
        }

        public Criteria andFinisheddateNotBetween(Date value1, Date value2) {
            addCriterion("finishedDate not between", value1, value2, "finisheddate");
            return (Criteria) this;
        }

        public Criteria andCanceledbyIsNull() {
            addCriterion("canceledBy is null");
            return (Criteria) this;
        }

        public Criteria andCanceledbyIsNotNull() {
            addCriterion("canceledBy is not null");
            return (Criteria) this;
        }

        public Criteria andCanceledbyEqualTo(String value) {
            addCriterion("canceledBy =", value, "canceledby");
            return (Criteria) this;
        }

        public Criteria andCanceledbyNotEqualTo(String value) {
            addCriterion("canceledBy <>", value, "canceledby");
            return (Criteria) this;
        }

        public Criteria andCanceledbyGreaterThan(String value) {
            addCriterion("canceledBy >", value, "canceledby");
            return (Criteria) this;
        }

        public Criteria andCanceledbyGreaterThanOrEqualTo(String value) {
            addCriterion("canceledBy >=", value, "canceledby");
            return (Criteria) this;
        }

        public Criteria andCanceledbyLessThan(String value) {
            addCriterion("canceledBy <", value, "canceledby");
            return (Criteria) this;
        }

        public Criteria andCanceledbyLessThanOrEqualTo(String value) {
            addCriterion("canceledBy <=", value, "canceledby");
            return (Criteria) this;
        }

        public Criteria andCanceledbyLike(String value) {
            addCriterion("canceledBy like", value, "canceledby");
            return (Criteria) this;
        }

        public Criteria andCanceledbyNotLike(String value) {
            addCriterion("canceledBy not like", value, "canceledby");
            return (Criteria) this;
        }

        public Criteria andCanceledbyIn(List<String> values) {
            addCriterion("canceledBy in", values, "canceledby");
            return (Criteria) this;
        }

        public Criteria andCanceledbyNotIn(List<String> values) {
            addCriterion("canceledBy not in", values, "canceledby");
            return (Criteria) this;
        }

        public Criteria andCanceledbyBetween(String value1, String value2) {
            addCriterion("canceledBy between", value1, value2, "canceledby");
            return (Criteria) this;
        }

        public Criteria andCanceledbyNotBetween(String value1, String value2) {
            addCriterion("canceledBy not between", value1, value2, "canceledby");
            return (Criteria) this;
        }

        public Criteria andCanceleddateIsNull() {
            addCriterion("canceledDate is null");
            return (Criteria) this;
        }

        public Criteria andCanceleddateIsNotNull() {
            addCriterion("canceledDate is not null");
            return (Criteria) this;
        }

        public Criteria andCanceleddateEqualTo(Date value) {
            addCriterion("canceledDate =", value, "canceleddate");
            return (Criteria) this;
        }

        public Criteria andCanceleddateNotEqualTo(Date value) {
            addCriterion("canceledDate <>", value, "canceleddate");
            return (Criteria) this;
        }

        public Criteria andCanceleddateGreaterThan(Date value) {
            addCriterion("canceledDate >", value, "canceleddate");
            return (Criteria) this;
        }

        public Criteria andCanceleddateGreaterThanOrEqualTo(Date value) {
            addCriterion("canceledDate >=", value, "canceleddate");
            return (Criteria) this;
        }

        public Criteria andCanceleddateLessThan(Date value) {
            addCriterion("canceledDate <", value, "canceleddate");
            return (Criteria) this;
        }

        public Criteria andCanceleddateLessThanOrEqualTo(Date value) {
            addCriterion("canceledDate <=", value, "canceleddate");
            return (Criteria) this;
        }

        public Criteria andCanceleddateIn(List<Date> values) {
            addCriterion("canceledDate in", values, "canceleddate");
            return (Criteria) this;
        }

        public Criteria andCanceleddateNotIn(List<Date> values) {
            addCriterion("canceledDate not in", values, "canceleddate");
            return (Criteria) this;
        }

        public Criteria andCanceleddateBetween(Date value1, Date value2) {
            addCriterion("canceledDate between", value1, value2, "canceleddate");
            return (Criteria) this;
        }

        public Criteria andCanceleddateNotBetween(Date value1, Date value2) {
            addCriterion("canceledDate not between", value1, value2, "canceleddate");
            return (Criteria) this;
        }

        public Criteria andClosedbyIsNull() {
            addCriterion("closedBy is null");
            return (Criteria) this;
        }

        public Criteria andClosedbyIsNotNull() {
            addCriterion("closedBy is not null");
            return (Criteria) this;
        }

        public Criteria andClosedbyEqualTo(String value) {
            addCriterion("closedBy =", value, "closedby");
            return (Criteria) this;
        }

        public Criteria andClosedbyNotEqualTo(String value) {
            addCriterion("closedBy <>", value, "closedby");
            return (Criteria) this;
        }

        public Criteria andClosedbyGreaterThan(String value) {
            addCriterion("closedBy >", value, "closedby");
            return (Criteria) this;
        }

        public Criteria andClosedbyGreaterThanOrEqualTo(String value) {
            addCriterion("closedBy >=", value, "closedby");
            return (Criteria) this;
        }

        public Criteria andClosedbyLessThan(String value) {
            addCriterion("closedBy <", value, "closedby");
            return (Criteria) this;
        }

        public Criteria andClosedbyLessThanOrEqualTo(String value) {
            addCriterion("closedBy <=", value, "closedby");
            return (Criteria) this;
        }

        public Criteria andClosedbyLike(String value) {
            addCriterion("closedBy like", value, "closedby");
            return (Criteria) this;
        }

        public Criteria andClosedbyNotLike(String value) {
            addCriterion("closedBy not like", value, "closedby");
            return (Criteria) this;
        }

        public Criteria andClosedbyIn(List<String> values) {
            addCriterion("closedBy in", values, "closedby");
            return (Criteria) this;
        }

        public Criteria andClosedbyNotIn(List<String> values) {
            addCriterion("closedBy not in", values, "closedby");
            return (Criteria) this;
        }

        public Criteria andClosedbyBetween(String value1, String value2) {
            addCriterion("closedBy between", value1, value2, "closedby");
            return (Criteria) this;
        }

        public Criteria andClosedbyNotBetween(String value1, String value2) {
            addCriterion("closedBy not between", value1, value2, "closedby");
            return (Criteria) this;
        }

        public Criteria andCloseddateIsNull() {
            addCriterion("closedDate is null");
            return (Criteria) this;
        }

        public Criteria andCloseddateIsNotNull() {
            addCriterion("closedDate is not null");
            return (Criteria) this;
        }

        public Criteria andCloseddateEqualTo(Date value) {
            addCriterion("closedDate =", value, "closeddate");
            return (Criteria) this;
        }

        public Criteria andCloseddateNotEqualTo(Date value) {
            addCriterion("closedDate <>", value, "closeddate");
            return (Criteria) this;
        }

        public Criteria andCloseddateGreaterThan(Date value) {
            addCriterion("closedDate >", value, "closeddate");
            return (Criteria) this;
        }

        public Criteria andCloseddateGreaterThanOrEqualTo(Date value) {
            addCriterion("closedDate >=", value, "closeddate");
            return (Criteria) this;
        }

        public Criteria andCloseddateLessThan(Date value) {
            addCriterion("closedDate <", value, "closeddate");
            return (Criteria) this;
        }

        public Criteria andCloseddateLessThanOrEqualTo(Date value) {
            addCriterion("closedDate <=", value, "closeddate");
            return (Criteria) this;
        }

        public Criteria andCloseddateIn(List<Date> values) {
            addCriterion("closedDate in", values, "closeddate");
            return (Criteria) this;
        }

        public Criteria andCloseddateNotIn(List<Date> values) {
            addCriterion("closedDate not in", values, "closeddate");
            return (Criteria) this;
        }

        public Criteria andCloseddateBetween(Date value1, Date value2) {
            addCriterion("closedDate between", value1, value2, "closeddate");
            return (Criteria) this;
        }

        public Criteria andCloseddateNotBetween(Date value1, Date value2) {
            addCriterion("closedDate not between", value1, value2, "closeddate");
            return (Criteria) this;
        }

        public Criteria andClosedreasonIsNull() {
            addCriterion("closedReason is null");
            return (Criteria) this;
        }

        public Criteria andClosedreasonIsNotNull() {
            addCriterion("closedReason is not null");
            return (Criteria) this;
        }

        public Criteria andClosedreasonEqualTo(String value) {
            addCriterion("closedReason =", value, "closedreason");
            return (Criteria) this;
        }

        public Criteria andClosedreasonNotEqualTo(String value) {
            addCriterion("closedReason <>", value, "closedreason");
            return (Criteria) this;
        }

        public Criteria andClosedreasonGreaterThan(String value) {
            addCriterion("closedReason >", value, "closedreason");
            return (Criteria) this;
        }

        public Criteria andClosedreasonGreaterThanOrEqualTo(String value) {
            addCriterion("closedReason >=", value, "closedreason");
            return (Criteria) this;
        }

        public Criteria andClosedreasonLessThan(String value) {
            addCriterion("closedReason <", value, "closedreason");
            return (Criteria) this;
        }

        public Criteria andClosedreasonLessThanOrEqualTo(String value) {
            addCriterion("closedReason <=", value, "closedreason");
            return (Criteria) this;
        }

        public Criteria andClosedreasonLike(String value) {
            addCriterion("closedReason like", value, "closedreason");
            return (Criteria) this;
        }

        public Criteria andClosedreasonNotLike(String value) {
            addCriterion("closedReason not like", value, "closedreason");
            return (Criteria) this;
        }

        public Criteria andClosedreasonIn(List<String> values) {
            addCriterion("closedReason in", values, "closedreason");
            return (Criteria) this;
        }

        public Criteria andClosedreasonNotIn(List<String> values) {
            addCriterion("closedReason not in", values, "closedreason");
            return (Criteria) this;
        }

        public Criteria andClosedreasonBetween(String value1, String value2) {
            addCriterion("closedReason between", value1, value2, "closedreason");
            return (Criteria) this;
        }

        public Criteria andClosedreasonNotBetween(String value1, String value2) {
            addCriterion("closedReason not between", value1, value2, "closedreason");
            return (Criteria) this;
        }

        public Criteria andLasteditedbyIsNull() {
            addCriterion("lastEditedBy is null");
            return (Criteria) this;
        }

        public Criteria andLasteditedbyIsNotNull() {
            addCriterion("lastEditedBy is not null");
            return (Criteria) this;
        }

        public Criteria andLasteditedbyEqualTo(String value) {
            addCriterion("lastEditedBy =", value, "lasteditedby");
            return (Criteria) this;
        }

        public Criteria andLasteditedbyNotEqualTo(String value) {
            addCriterion("lastEditedBy <>", value, "lasteditedby");
            return (Criteria) this;
        }

        public Criteria andLasteditedbyGreaterThan(String value) {
            addCriterion("lastEditedBy >", value, "lasteditedby");
            return (Criteria) this;
        }

        public Criteria andLasteditedbyGreaterThanOrEqualTo(String value) {
            addCriterion("lastEditedBy >=", value, "lasteditedby");
            return (Criteria) this;
        }

        public Criteria andLasteditedbyLessThan(String value) {
            addCriterion("lastEditedBy <", value, "lasteditedby");
            return (Criteria) this;
        }

        public Criteria andLasteditedbyLessThanOrEqualTo(String value) {
            addCriterion("lastEditedBy <=", value, "lasteditedby");
            return (Criteria) this;
        }

        public Criteria andLasteditedbyLike(String value) {
            addCriterion("lastEditedBy like", value, "lasteditedby");
            return (Criteria) this;
        }

        public Criteria andLasteditedbyNotLike(String value) {
            addCriterion("lastEditedBy not like", value, "lasteditedby");
            return (Criteria) this;
        }

        public Criteria andLasteditedbyIn(List<String> values) {
            addCriterion("lastEditedBy in", values, "lasteditedby");
            return (Criteria) this;
        }

        public Criteria andLasteditedbyNotIn(List<String> values) {
            addCriterion("lastEditedBy not in", values, "lasteditedby");
            return (Criteria) this;
        }

        public Criteria andLasteditedbyBetween(String value1, String value2) {
            addCriterion("lastEditedBy between", value1, value2, "lasteditedby");
            return (Criteria) this;
        }

        public Criteria andLasteditedbyNotBetween(String value1, String value2) {
            addCriterion("lastEditedBy not between", value1, value2, "lasteditedby");
            return (Criteria) this;
        }

        public Criteria andLastediteddateIsNull() {
            addCriterion("lastEditedDate is null");
            return (Criteria) this;
        }

        public Criteria andLastediteddateIsNotNull() {
            addCriterion("lastEditedDate is not null");
            return (Criteria) this;
        }

        public Criteria andLastediteddateEqualTo(Date value) {
            addCriterion("lastEditedDate =", value, "lastediteddate");
            return (Criteria) this;
        }

        public Criteria andLastediteddateNotEqualTo(Date value) {
            addCriterion("lastEditedDate <>", value, "lastediteddate");
            return (Criteria) this;
        }

        public Criteria andLastediteddateGreaterThan(Date value) {
            addCriterion("lastEditedDate >", value, "lastediteddate");
            return (Criteria) this;
        }

        public Criteria andLastediteddateGreaterThanOrEqualTo(Date value) {
            addCriterion("lastEditedDate >=", value, "lastediteddate");
            return (Criteria) this;
        }

        public Criteria andLastediteddateLessThan(Date value) {
            addCriterion("lastEditedDate <", value, "lastediteddate");
            return (Criteria) this;
        }

        public Criteria andLastediteddateLessThanOrEqualTo(Date value) {
            addCriterion("lastEditedDate <=", value, "lastediteddate");
            return (Criteria) this;
        }

        public Criteria andLastediteddateIn(List<Date> values) {
            addCriterion("lastEditedDate in", values, "lastediteddate");
            return (Criteria) this;
        }

        public Criteria andLastediteddateNotIn(List<Date> values) {
            addCriterion("lastEditedDate not in", values, "lastediteddate");
            return (Criteria) this;
        }

        public Criteria andLastediteddateBetween(Date value1, Date value2) {
            addCriterion("lastEditedDate between", value1, value2, "lastediteddate");
            return (Criteria) this;
        }

        public Criteria andLastediteddateNotBetween(Date value1, Date value2) {
            addCriterion("lastEditedDate not between", value1, value2, "lastediteddate");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(String value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(String value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(String value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(String value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(String value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLike(String value) {
            addCriterion("deleted like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotLike(String value) {
            addCriterion("deleted not like", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<String> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<String> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(String value1, String value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(String value1, String value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
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