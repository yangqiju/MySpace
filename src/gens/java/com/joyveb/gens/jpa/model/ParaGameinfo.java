package com.joyveb.gens.jpa.model;

public class ParaGameinfo extends ParaGameinfoKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_PARA_GAMEINFO.GAMENAME
     *
     * @mbggenerated
     */
    private String gamename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_PARA_GAMEINFO.STATUS
     *
     * @mbggenerated
     */
    private Short status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_PARA_GAMEINFO.STARTSALETIME
     *
     * @mbggenerated
     */
    private String startsaletime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_PARA_GAMEINFO.ENDSALETIME
     *
     * @mbggenerated
     */
    private String endsaletime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_PARA_GAMEINFO.AHEADCLOSETIME
     *
     * @mbggenerated
     */
    private Long aheadclosetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_PARA_GAMEINFO.EXPIREDDATES
     *
     * @mbggenerated
     */
    private Integer expireddates;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_PARA_GAMEINFO.DRAWPERIOD
     *
     * @mbggenerated
     */
    private Integer drawperiod;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_PARA_GAMEINFO.DRAWTIMES
     *
     * @mbggenerated
     */
    private Integer drawtimes;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_PARA_GAMEINFO.GAMENAME
     *
     * @return the value of T_PARA_GAMEINFO.GAMENAME
     *
     * @mbggenerated
     */
    public String getGamename() {
        return gamename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_PARA_GAMEINFO.GAMENAME
     *
     * @param gamename the value for T_PARA_GAMEINFO.GAMENAME
     *
     * @mbggenerated
     */
    public void setGamename(String gamename) {
        this.gamename = gamename == null ? null : gamename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_PARA_GAMEINFO.STATUS
     *
     * @return the value of T_PARA_GAMEINFO.STATUS
     *
     * @mbggenerated
     */
    public Short getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_PARA_GAMEINFO.STATUS
     *
     * @param status the value for T_PARA_GAMEINFO.STATUS
     *
     * @mbggenerated
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_PARA_GAMEINFO.STARTSALETIME
     *
     * @return the value of T_PARA_GAMEINFO.STARTSALETIME
     *
     * @mbggenerated
     */
    public String getStartsaletime() {
        return startsaletime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_PARA_GAMEINFO.STARTSALETIME
     *
     * @param startsaletime the value for T_PARA_GAMEINFO.STARTSALETIME
     *
     * @mbggenerated
     */
    public void setStartsaletime(String startsaletime) {
        this.startsaletime = startsaletime == null ? null : startsaletime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_PARA_GAMEINFO.ENDSALETIME
     *
     * @return the value of T_PARA_GAMEINFO.ENDSALETIME
     *
     * @mbggenerated
     */
    public String getEndsaletime() {
        return endsaletime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_PARA_GAMEINFO.ENDSALETIME
     *
     * @param endsaletime the value for T_PARA_GAMEINFO.ENDSALETIME
     *
     * @mbggenerated
     */
    public void setEndsaletime(String endsaletime) {
        this.endsaletime = endsaletime == null ? null : endsaletime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_PARA_GAMEINFO.AHEADCLOSETIME
     *
     * @return the value of T_PARA_GAMEINFO.AHEADCLOSETIME
     *
     * @mbggenerated
     */
    public Long getAheadclosetime() {
        return aheadclosetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_PARA_GAMEINFO.AHEADCLOSETIME
     *
     * @param aheadclosetime the value for T_PARA_GAMEINFO.AHEADCLOSETIME
     *
     * @mbggenerated
     */
    public void setAheadclosetime(Long aheadclosetime) {
        this.aheadclosetime = aheadclosetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_PARA_GAMEINFO.EXPIREDDATES
     *
     * @return the value of T_PARA_GAMEINFO.EXPIREDDATES
     *
     * @mbggenerated
     */
    public Integer getExpireddates() {
        return expireddates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_PARA_GAMEINFO.EXPIREDDATES
     *
     * @param expireddates the value for T_PARA_GAMEINFO.EXPIREDDATES
     *
     * @mbggenerated
     */
    public void setExpireddates(Integer expireddates) {
        this.expireddates = expireddates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_PARA_GAMEINFO.DRAWPERIOD
     *
     * @return the value of T_PARA_GAMEINFO.DRAWPERIOD
     *
     * @mbggenerated
     */
    public Integer getDrawperiod() {
        return drawperiod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_PARA_GAMEINFO.DRAWPERIOD
     *
     * @param drawperiod the value for T_PARA_GAMEINFO.DRAWPERIOD
     *
     * @mbggenerated
     */
    public void setDrawperiod(Integer drawperiod) {
        this.drawperiod = drawperiod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_PARA_GAMEINFO.DRAWTIMES
     *
     * @return the value of T_PARA_GAMEINFO.DRAWTIMES
     *
     * @mbggenerated
     */
    public Integer getDrawtimes() {
        return drawtimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_PARA_GAMEINFO.DRAWTIMES
     *
     * @param drawtimes the value for T_PARA_GAMEINFO.DRAWTIMES
     *
     * @mbggenerated
     */
    public void setDrawtimes(Integer drawtimes) {
        this.drawtimes = drawtimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ParaGameinfo other = (ParaGameinfo) that;
        return (this.getLtype() == null ? other.getLtype() == null : this.getLtype().equals(other.getLtype()))
            && (this.getGamename() == null ? other.getGamename() == null : this.getGamename().equals(other.getGamename()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getStartsaletime() == null ? other.getStartsaletime() == null : this.getStartsaletime().equals(other.getStartsaletime()))
            && (this.getEndsaletime() == null ? other.getEndsaletime() == null : this.getEndsaletime().equals(other.getEndsaletime()))
            && (this.getAheadclosetime() == null ? other.getAheadclosetime() == null : this.getAheadclosetime().equals(other.getAheadclosetime()))
            && (this.getExpireddates() == null ? other.getExpireddates() == null : this.getExpireddates().equals(other.getExpireddates()))
            && (this.getDrawperiod() == null ? other.getDrawperiod() == null : this.getDrawperiod().equals(other.getDrawperiod()))
            && (this.getDrawtimes() == null ? other.getDrawtimes() == null : this.getDrawtimes().equals(other.getDrawtimes()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLtype() == null) ? 0 : getLtype().hashCode());
        result = prime * result + ((getGamename() == null) ? 0 : getGamename().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getStartsaletime() == null) ? 0 : getStartsaletime().hashCode());
        result = prime * result + ((getEndsaletime() == null) ? 0 : getEndsaletime().hashCode());
        result = prime * result + ((getAheadclosetime() == null) ? 0 : getAheadclosetime().hashCode());
        result = prime * result + ((getExpireddates() == null) ? 0 : getExpireddates().hashCode());
        result = prime * result + ((getDrawperiod() == null) ? 0 : getDrawperiod().hashCode());
        result = prime * result + ((getDrawtimes() == null) ? 0 : getDrawtimes().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_GAMEINFO
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gamename=").append(gamename);
        sb.append(", status=").append(status);
        sb.append(", startsaletime=").append(startsaletime);
        sb.append(", endsaletime=").append(endsaletime);
        sb.append(", aheadclosetime=").append(aheadclosetime);
        sb.append(", expireddates=").append(expireddates);
        sb.append(", drawperiod=").append(drawperiod);
        sb.append(", drawtimes=").append(drawtimes);
        sb.append("]");
        return sb.toString();
    }
}