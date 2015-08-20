package cn.com.bsfit.frms.manager.pojo;

import cn.com.bsfit.frms.manager.utils.Page;
import java.util.ArrayList;
import java.util.List;

public class RolesResourcesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public RolesResourcesExample() {
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

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
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

        public Criteria andResourcesIdIsNull() {
            addCriterion("RESOURCES_ID is null");
            return (Criteria) this;
        }

        public Criteria andResourcesIdIsNotNull() {
            addCriterion("RESOURCES_ID is not null");
            return (Criteria) this;
        }

        public Criteria andResourcesIdEqualTo(Integer value) {
            addCriterion("RESOURCES_ID =", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdNotEqualTo(Integer value) {
            addCriterion("RESOURCES_ID <>", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdGreaterThan(Integer value) {
            addCriterion("RESOURCES_ID >", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("RESOURCES_ID >=", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdLessThan(Integer value) {
            addCriterion("RESOURCES_ID <", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdLessThanOrEqualTo(Integer value) {
            addCriterion("RESOURCES_ID <=", value, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdIn(List<Integer> values) {
            addCriterion("RESOURCES_ID in", values, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdNotIn(List<Integer> values) {
            addCriterion("RESOURCES_ID not in", values, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdBetween(Integer value1, Integer value2) {
            addCriterion("RESOURCES_ID between", value1, value2, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andResourcesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("RESOURCES_ID not between", value1, value2, "resourcesId");
            return (Criteria) this;
        }

        public Criteria andRolesIdIsNull() {
            addCriterion("ROLES_ID is null");
            return (Criteria) this;
        }

        public Criteria andRolesIdIsNotNull() {
            addCriterion("ROLES_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRolesIdEqualTo(Integer value) {
            addCriterion("ROLES_ID =", value, "rolesId");
            return (Criteria) this;
        }

        public Criteria andRolesIdNotEqualTo(Integer value) {
            addCriterion("ROLES_ID <>", value, "rolesId");
            return (Criteria) this;
        }

        public Criteria andRolesIdGreaterThan(Integer value) {
            addCriterion("ROLES_ID >", value, "rolesId");
            return (Criteria) this;
        }

        public Criteria andRolesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ROLES_ID >=", value, "rolesId");
            return (Criteria) this;
        }

        public Criteria andRolesIdLessThan(Integer value) {
            addCriterion("ROLES_ID <", value, "rolesId");
            return (Criteria) this;
        }

        public Criteria andRolesIdLessThanOrEqualTo(Integer value) {
            addCriterion("ROLES_ID <=", value, "rolesId");
            return (Criteria) this;
        }

        public Criteria andRolesIdIn(List<Integer> values) {
            addCriterion("ROLES_ID in", values, "rolesId");
            return (Criteria) this;
        }

        public Criteria andRolesIdNotIn(List<Integer> values) {
            addCriterion("ROLES_ID not in", values, "rolesId");
            return (Criteria) this;
        }

        public Criteria andRolesIdBetween(Integer value1, Integer value2) {
            addCriterion("ROLES_ID between", value1, value2, "rolesId");
            return (Criteria) this;
        }

        public Criteria andRolesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ROLES_ID not between", value1, value2, "rolesId");
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