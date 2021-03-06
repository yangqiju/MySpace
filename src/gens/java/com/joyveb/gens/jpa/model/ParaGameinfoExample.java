package com.joyveb.gens.jpa.model;

import java.util.ArrayList;
import java.util.List;

public class ParaGameinfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
    * This method was generated by MyBatis Generator.
    * This method corresponds to the database table T_PARA_GAMEINFO
    */
    protected int startRow;

    /**
    * This method was generated by MyBatis Generator.
    * This method corresponds to the database table T_PARA_GAMEINFO
    */
    protected int endRow;

    /**
    * This method was generated by MyBatis Generator.
    * This method corresponds to the database table T_PARA_GAMEINFO
    */
    protected String sumCol;

    /**
    * This method was generated by MyBatis Generator.
    * This method corresponds to the database table T_PARA_GAMEINFO
    */
    protected String groupSelClause;

    /**
    * This method was generated by MyBatis Generator.
    * This method corresponds to the database table T_PARA_GAMEINFO
    */
    protected String groupByClause;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
    public ParaGameinfoExample() {
        oredCriteria = new ArrayList<Criteria>();
        startRow = 0;
        endRow = Integer.MAX_VALUE;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        this.startRow= 0;
        this.endRow= Integer.MAX_VALUE;
        this.sumCol=null;
        this.groupSelClause=null;
        this.groupByClause=null;
    }

    /**
    * This method was generated by MyBatis Generator.
    * This method corresponds to the database table T_PARA_GAMEINFO
    */
    public void setStartRow(int startRow) {
         this.startRow = startRow;
    }

    /**
    * This method was generated by MyBatis Generator.
    * This method corresponds to the database table T_PARA_GAMEINFO
    */
    public int getStartRow() {
          return startRow;
    }

    /**
    * This method was generated by MyBatis Generator.
    * This method corresponds to the database table T_PARA_GAMEINFO
    */
    public void setEndRow(int endRow) {
         this.endRow = endRow;
    }

    /**
    * This method was generated by MyBatis Generator.
    * This method corresponds to the database table T_PARA_GAMEINFO
    */
    public int getEndRow() {
          return endRow;
    }

    /**
    * This method was generated by MyBatis Generator.
    * This method corresponds to the database table T_PARA_GAMEINFO
    */
    public void setSumCol(String sumCol) {
         this.sumCol = sumCol;
    }

    /**
    * This method was generated by MyBatis Generator.
    * This method corresponds to the database table T_PARA_GAMEINFO
    */
    public String getSumCol() {
          return sumCol;
    }

    /**
    * This method was generated by MyBatis Generator.
    * This method corresponds to the database table T_PARA_GAMEINFO
    */
    public void setGroupSelClause(String groupSelClause) {
         this.groupSelClause = groupSelClause;
    }

    /**
    * This method was generated by MyBatis Generator.
    * This method corresponds to the database table T_PARA_GAMEINFO
    */
    public String getGroupSelClause() {
          return groupSelClause;
    }

    /**
    * This method was generated by MyBatis Generator.
    * This method corresponds to the database table T_PARA_GAMEINFO
    */
    public void setGroupByClause(String groupByClause) {
         this.groupByClause = groupByClause;
    }

    /**
    * This method was generated by MyBatis Generator.
    * This method corresponds to the database table T_PARA_GAMEINFO
    */
    public String getGroupByClause() {
          return groupByClause;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
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

        public Criteria andLtypeIsNull() {
            addCriterion("LTYPE is null");
            return (Criteria) this;
        }

        public Criteria andLtypeIsNotNull() {
            addCriterion("LTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andLtypeEqualTo(String value) {
            addCriterion("LTYPE =", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotEqualTo(String value) {
            addCriterion("LTYPE <>", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeGreaterThan(String value) {
            addCriterion("LTYPE >", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeGreaterThanOrEqualTo(String value) {
            addCriterion("LTYPE >=", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeLessThan(String value) {
            addCriterion("LTYPE <", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeLessThanOrEqualTo(String value) {
            addCriterion("LTYPE <=", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeLike(String value) {
            addCriterion("LTYPE like", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotLike(String value) {
            addCriterion("LTYPE not like", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeIn(List<String> values) {
            addCriterion("LTYPE in", values, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotIn(List<String> values) {
            addCriterion("LTYPE not in", values, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeBetween(String value1, String value2) {
            addCriterion("LTYPE between", value1, value2, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotBetween(String value1, String value2) {
            addCriterion("LTYPE not between", value1, value2, "ltype");
            return (Criteria) this;
        }

        public Criteria andGamenameIsNull() {
            addCriterion("GAMENAME is null");
            return (Criteria) this;
        }

        public Criteria andGamenameIsNotNull() {
            addCriterion("GAMENAME is not null");
            return (Criteria) this;
        }

        public Criteria andGamenameEqualTo(String value) {
            addCriterion("GAMENAME =", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotEqualTo(String value) {
            addCriterion("GAMENAME <>", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameGreaterThan(String value) {
            addCriterion("GAMENAME >", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameGreaterThanOrEqualTo(String value) {
            addCriterion("GAMENAME >=", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameLessThan(String value) {
            addCriterion("GAMENAME <", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameLessThanOrEqualTo(String value) {
            addCriterion("GAMENAME <=", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameLike(String value) {
            addCriterion("GAMENAME like", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotLike(String value) {
            addCriterion("GAMENAME not like", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameIn(List<String> values) {
            addCriterion("GAMENAME in", values, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotIn(List<String> values) {
            addCriterion("GAMENAME not in", values, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameBetween(String value1, String value2) {
            addCriterion("GAMENAME between", value1, value2, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotBetween(String value1, String value2) {
            addCriterion("GAMENAME not between", value1, value2, "gamename");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStartsaletimeIsNull() {
            addCriterion("STARTSALETIME is null");
            return (Criteria) this;
        }

        public Criteria andStartsaletimeIsNotNull() {
            addCriterion("STARTSALETIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartsaletimeEqualTo(String value) {
            addCriterion("STARTSALETIME =", value, "startsaletime");
            return (Criteria) this;
        }

        public Criteria andStartsaletimeNotEqualTo(String value) {
            addCriterion("STARTSALETIME <>", value, "startsaletime");
            return (Criteria) this;
        }

        public Criteria andStartsaletimeGreaterThan(String value) {
            addCriterion("STARTSALETIME >", value, "startsaletime");
            return (Criteria) this;
        }

        public Criteria andStartsaletimeGreaterThanOrEqualTo(String value) {
            addCriterion("STARTSALETIME >=", value, "startsaletime");
            return (Criteria) this;
        }

        public Criteria andStartsaletimeLessThan(String value) {
            addCriterion("STARTSALETIME <", value, "startsaletime");
            return (Criteria) this;
        }

        public Criteria andStartsaletimeLessThanOrEqualTo(String value) {
            addCriterion("STARTSALETIME <=", value, "startsaletime");
            return (Criteria) this;
        }

        public Criteria andStartsaletimeLike(String value) {
            addCriterion("STARTSALETIME like", value, "startsaletime");
            return (Criteria) this;
        }

        public Criteria andStartsaletimeNotLike(String value) {
            addCriterion("STARTSALETIME not like", value, "startsaletime");
            return (Criteria) this;
        }

        public Criteria andStartsaletimeIn(List<String> values) {
            addCriterion("STARTSALETIME in", values, "startsaletime");
            return (Criteria) this;
        }

        public Criteria andStartsaletimeNotIn(List<String> values) {
            addCriterion("STARTSALETIME not in", values, "startsaletime");
            return (Criteria) this;
        }

        public Criteria andStartsaletimeBetween(String value1, String value2) {
            addCriterion("STARTSALETIME between", value1, value2, "startsaletime");
            return (Criteria) this;
        }

        public Criteria andStartsaletimeNotBetween(String value1, String value2) {
            addCriterion("STARTSALETIME not between", value1, value2, "startsaletime");
            return (Criteria) this;
        }

        public Criteria andEndsaletimeIsNull() {
            addCriterion("ENDSALETIME is null");
            return (Criteria) this;
        }

        public Criteria andEndsaletimeIsNotNull() {
            addCriterion("ENDSALETIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndsaletimeEqualTo(String value) {
            addCriterion("ENDSALETIME =", value, "endsaletime");
            return (Criteria) this;
        }

        public Criteria andEndsaletimeNotEqualTo(String value) {
            addCriterion("ENDSALETIME <>", value, "endsaletime");
            return (Criteria) this;
        }

        public Criteria andEndsaletimeGreaterThan(String value) {
            addCriterion("ENDSALETIME >", value, "endsaletime");
            return (Criteria) this;
        }

        public Criteria andEndsaletimeGreaterThanOrEqualTo(String value) {
            addCriterion("ENDSALETIME >=", value, "endsaletime");
            return (Criteria) this;
        }

        public Criteria andEndsaletimeLessThan(String value) {
            addCriterion("ENDSALETIME <", value, "endsaletime");
            return (Criteria) this;
        }

        public Criteria andEndsaletimeLessThanOrEqualTo(String value) {
            addCriterion("ENDSALETIME <=", value, "endsaletime");
            return (Criteria) this;
        }

        public Criteria andEndsaletimeLike(String value) {
            addCriterion("ENDSALETIME like", value, "endsaletime");
            return (Criteria) this;
        }

        public Criteria andEndsaletimeNotLike(String value) {
            addCriterion("ENDSALETIME not like", value, "endsaletime");
            return (Criteria) this;
        }

        public Criteria andEndsaletimeIn(List<String> values) {
            addCriterion("ENDSALETIME in", values, "endsaletime");
            return (Criteria) this;
        }

        public Criteria andEndsaletimeNotIn(List<String> values) {
            addCriterion("ENDSALETIME not in", values, "endsaletime");
            return (Criteria) this;
        }

        public Criteria andEndsaletimeBetween(String value1, String value2) {
            addCriterion("ENDSALETIME between", value1, value2, "endsaletime");
            return (Criteria) this;
        }

        public Criteria andEndsaletimeNotBetween(String value1, String value2) {
            addCriterion("ENDSALETIME not between", value1, value2, "endsaletime");
            return (Criteria) this;
        }

        public Criteria andAheadclosetimeIsNull() {
            addCriterion("AHEADCLOSETIME is null");
            return (Criteria) this;
        }

        public Criteria andAheadclosetimeIsNotNull() {
            addCriterion("AHEADCLOSETIME is not null");
            return (Criteria) this;
        }

        public Criteria andAheadclosetimeEqualTo(Long value) {
            addCriterion("AHEADCLOSETIME =", value, "aheadclosetime");
            return (Criteria) this;
        }

        public Criteria andAheadclosetimeNotEqualTo(Long value) {
            addCriterion("AHEADCLOSETIME <>", value, "aheadclosetime");
            return (Criteria) this;
        }

        public Criteria andAheadclosetimeGreaterThan(Long value) {
            addCriterion("AHEADCLOSETIME >", value, "aheadclosetime");
            return (Criteria) this;
        }

        public Criteria andAheadclosetimeGreaterThanOrEqualTo(Long value) {
            addCriterion("AHEADCLOSETIME >=", value, "aheadclosetime");
            return (Criteria) this;
        }

        public Criteria andAheadclosetimeLessThan(Long value) {
            addCriterion("AHEADCLOSETIME <", value, "aheadclosetime");
            return (Criteria) this;
        }

        public Criteria andAheadclosetimeLessThanOrEqualTo(Long value) {
            addCriterion("AHEADCLOSETIME <=", value, "aheadclosetime");
            return (Criteria) this;
        }

        public Criteria andAheadclosetimeIn(List<Long> values) {
            addCriterion("AHEADCLOSETIME in", values, "aheadclosetime");
            return (Criteria) this;
        }

        public Criteria andAheadclosetimeNotIn(List<Long> values) {
            addCriterion("AHEADCLOSETIME not in", values, "aheadclosetime");
            return (Criteria) this;
        }

        public Criteria andAheadclosetimeBetween(Long value1, Long value2) {
            addCriterion("AHEADCLOSETIME between", value1, value2, "aheadclosetime");
            return (Criteria) this;
        }

        public Criteria andAheadclosetimeNotBetween(Long value1, Long value2) {
            addCriterion("AHEADCLOSETIME not between", value1, value2, "aheadclosetime");
            return (Criteria) this;
        }

        public Criteria andExpireddatesIsNull() {
            addCriterion("EXPIREDDATES is null");
            return (Criteria) this;
        }

        public Criteria andExpireddatesIsNotNull() {
            addCriterion("EXPIREDDATES is not null");
            return (Criteria) this;
        }

        public Criteria andExpireddatesEqualTo(Integer value) {
            addCriterion("EXPIREDDATES =", value, "expireddates");
            return (Criteria) this;
        }

        public Criteria andExpireddatesNotEqualTo(Integer value) {
            addCriterion("EXPIREDDATES <>", value, "expireddates");
            return (Criteria) this;
        }

        public Criteria andExpireddatesGreaterThan(Integer value) {
            addCriterion("EXPIREDDATES >", value, "expireddates");
            return (Criteria) this;
        }

        public Criteria andExpireddatesGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXPIREDDATES >=", value, "expireddates");
            return (Criteria) this;
        }

        public Criteria andExpireddatesLessThan(Integer value) {
            addCriterion("EXPIREDDATES <", value, "expireddates");
            return (Criteria) this;
        }

        public Criteria andExpireddatesLessThanOrEqualTo(Integer value) {
            addCriterion("EXPIREDDATES <=", value, "expireddates");
            return (Criteria) this;
        }

        public Criteria andExpireddatesIn(List<Integer> values) {
            addCriterion("EXPIREDDATES in", values, "expireddates");
            return (Criteria) this;
        }

        public Criteria andExpireddatesNotIn(List<Integer> values) {
            addCriterion("EXPIREDDATES not in", values, "expireddates");
            return (Criteria) this;
        }

        public Criteria andExpireddatesBetween(Integer value1, Integer value2) {
            addCriterion("EXPIREDDATES between", value1, value2, "expireddates");
            return (Criteria) this;
        }

        public Criteria andExpireddatesNotBetween(Integer value1, Integer value2) {
            addCriterion("EXPIREDDATES not between", value1, value2, "expireddates");
            return (Criteria) this;
        }

        public Criteria andDrawperiodIsNull() {
            addCriterion("DRAWPERIOD is null");
            return (Criteria) this;
        }

        public Criteria andDrawperiodIsNotNull() {
            addCriterion("DRAWPERIOD is not null");
            return (Criteria) this;
        }

        public Criteria andDrawperiodEqualTo(Integer value) {
            addCriterion("DRAWPERIOD =", value, "drawperiod");
            return (Criteria) this;
        }

        public Criteria andDrawperiodNotEqualTo(Integer value) {
            addCriterion("DRAWPERIOD <>", value, "drawperiod");
            return (Criteria) this;
        }

        public Criteria andDrawperiodGreaterThan(Integer value) {
            addCriterion("DRAWPERIOD >", value, "drawperiod");
            return (Criteria) this;
        }

        public Criteria andDrawperiodGreaterThanOrEqualTo(Integer value) {
            addCriterion("DRAWPERIOD >=", value, "drawperiod");
            return (Criteria) this;
        }

        public Criteria andDrawperiodLessThan(Integer value) {
            addCriterion("DRAWPERIOD <", value, "drawperiod");
            return (Criteria) this;
        }

        public Criteria andDrawperiodLessThanOrEqualTo(Integer value) {
            addCriterion("DRAWPERIOD <=", value, "drawperiod");
            return (Criteria) this;
        }

        public Criteria andDrawperiodIn(List<Integer> values) {
            addCriterion("DRAWPERIOD in", values, "drawperiod");
            return (Criteria) this;
        }

        public Criteria andDrawperiodNotIn(List<Integer> values) {
            addCriterion("DRAWPERIOD not in", values, "drawperiod");
            return (Criteria) this;
        }

        public Criteria andDrawperiodBetween(Integer value1, Integer value2) {
            addCriterion("DRAWPERIOD between", value1, value2, "drawperiod");
            return (Criteria) this;
        }

        public Criteria andDrawperiodNotBetween(Integer value1, Integer value2) {
            addCriterion("DRAWPERIOD not between", value1, value2, "drawperiod");
            return (Criteria) this;
        }

        public Criteria andDrawtimesIsNull() {
            addCriterion("DRAWTIMES is null");
            return (Criteria) this;
        }

        public Criteria andDrawtimesIsNotNull() {
            addCriterion("DRAWTIMES is not null");
            return (Criteria) this;
        }

        public Criteria andDrawtimesEqualTo(Integer value) {
            addCriterion("DRAWTIMES =", value, "drawtimes");
            return (Criteria) this;
        }

        public Criteria andDrawtimesNotEqualTo(Integer value) {
            addCriterion("DRAWTIMES <>", value, "drawtimes");
            return (Criteria) this;
        }

        public Criteria andDrawtimesGreaterThan(Integer value) {
            addCriterion("DRAWTIMES >", value, "drawtimes");
            return (Criteria) this;
        }

        public Criteria andDrawtimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("DRAWTIMES >=", value, "drawtimes");
            return (Criteria) this;
        }

        public Criteria andDrawtimesLessThan(Integer value) {
            addCriterion("DRAWTIMES <", value, "drawtimes");
            return (Criteria) this;
        }

        public Criteria andDrawtimesLessThanOrEqualTo(Integer value) {
            addCriterion("DRAWTIMES <=", value, "drawtimes");
            return (Criteria) this;
        }

        public Criteria andDrawtimesIn(List<Integer> values) {
            addCriterion("DRAWTIMES in", values, "drawtimes");
            return (Criteria) this;
        }

        public Criteria andDrawtimesNotIn(List<Integer> values) {
            addCriterion("DRAWTIMES not in", values, "drawtimes");
            return (Criteria) this;
        }

        public Criteria andDrawtimesBetween(Integer value1, Integer value2) {
            addCriterion("DRAWTIMES between", value1, value2, "drawtimes");
            return (Criteria) this;
        }

        public Criteria andDrawtimesNotBetween(Integer value1, Integer value2) {
            addCriterion("DRAWTIMES not between", value1, value2, "drawtimes");
            return (Criteria) this;
        }

        public Criteria andLtypeLikeInsensitive(String value) {
            addCriterion("upper(LTYPE) like", value.toUpperCase(), "ltype");
            return (Criteria) this;
        }

        public Criteria andGamenameLikeInsensitive(String value) {
            addCriterion("upper(GAMENAME) like", value.toUpperCase(), "gamename");
            return (Criteria) this;
        }

        public Criteria andStartsaletimeLikeInsensitive(String value) {
            addCriterion("upper(STARTSALETIME) like", value.toUpperCase(), "startsaletime");
            return (Criteria) this;
        }

        public Criteria andEndsaletimeLikeInsensitive(String value) {
            addCriterion("upper(ENDSALETIME) like", value.toUpperCase(), "endsaletime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
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