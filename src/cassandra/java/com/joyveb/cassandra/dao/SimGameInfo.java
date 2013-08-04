package com.joyveb.cassandra.dao;

import java.util.Date;

public class SimGameInfo extends CassandraPrimaryKey<String> {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SIM_GAMEINFO.LTYPE
     *
     * @mbggenerated Tue Aug 21 10:23:40 CST 2012
     */
    private String ltype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SIM_GAMEINFO.GAMENAME
     *
     * @mbggenerated Tue Aug 21 10:23:40 CST 2012
     */
    private String gamename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SIM_GAMEINFO.PLAYNAME
     *
     * @mbggenerated Tue Aug 21 10:23:40 CST 2012
     */
    private String playname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SIM_GAMEINFO.EXPIREDDATES
     *
     * @mbggenerated Tue Aug 21 10:23:40 CST 2012
     */
    private Long expireddates;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_SIM_GAMEINFO.PRIZEDATE
     *
     * @mbggenerated Tue Aug 21 10:23:40 CST 2012
     */
    private String prizedate;
    
    
    private Date createdate;


    public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SIM_GAMEINFO.LTYPE
     *
     * @return the value of T_SIM_GAMEINFO.LTYPE
     *
     * @mbggenerated Tue Aug 21 10:23:40 CST 2012
     */
    public String getLtype() {
        return ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SIM_GAMEINFO.LTYPE
     *
     * @param ltype the value for T_SIM_GAMEINFO.LTYPE
     *
     * @mbggenerated Tue Aug 21 10:23:40 CST 2012
     */
    public void setLtype(String ltype) {
        this.ltype = ltype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SIM_GAMEINFO.GAMENAME
     *
     * @return the value of T_SIM_GAMEINFO.GAMENAME
     *
     * @mbggenerated Tue Aug 21 10:23:40 CST 2012
     */
    public String getGamename() {
        return gamename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SIM_GAMEINFO.GAMENAME
     *
     * @param gamename the value for T_SIM_GAMEINFO.GAMENAME
     *
     * @mbggenerated Tue Aug 21 10:23:40 CST 2012
     */
    public void setGamename(String gamename) {
        this.gamename = gamename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SIM_GAMEINFO.PLAYNAME
     *
     * @return the value of T_SIM_GAMEINFO.PLAYNAME
     *
     * @mbggenerated Tue Aug 21 10:23:40 CST 2012
     */
    public String getPlayname() {
        return playname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SIM_GAMEINFO.PLAYNAME
     *
     * @param playname the value for T_SIM_GAMEINFO.PLAYNAME
     *
     * @mbggenerated Tue Aug 21 10:23:40 CST 2012
     */
    public void setPlayname(String playname) {
        this.playname = playname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SIM_GAMEINFO.EXPIREDDATES
     *
     * @return the value of T_SIM_GAMEINFO.EXPIREDDATES
     *
     * @mbggenerated Tue Aug 21 10:23:40 CST 2012
     */
    public Long getExpireddates() {
        return expireddates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SIM_GAMEINFO.EXPIREDDATES
     *
     * @param expireddates the value for T_SIM_GAMEINFO.EXPIREDDATES
     *
     * @mbggenerated Tue Aug 21 10:23:40 CST 2012
     */
    public void setExpireddates(Long expireddates) {
        this.expireddates = expireddates;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_SIM_GAMEINFO.PRIZEDATE
     *
     * @return the value of T_SIM_GAMEINFO.PRIZEDATE
     *
     * @mbggenerated Tue Aug 21 10:23:40 CST 2012
     */
    public String getPrizedate() {
        return prizedate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_SIM_GAMEINFO.PRIZEDATE
     *
     * @param prizedate the value for T_SIM_GAMEINFO.PRIZEDATE
     *
     * @mbggenerated Tue Aug 21 10:23:40 CST 2012
     */
    public void setPrizedate(String prizedate) {
        this.prizedate = prizedate;
    }
}