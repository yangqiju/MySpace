package com.joyveb.redis.bean;

import java.util.Date;

import lombok.Data;

@Data
public class ParaDrawnumber extends ParaDrawnumberKey {
	private Short isvalid;

	private Integer year;

    private Date startdate;

    private Date enddate;

    private Integer status;

    private Integer salestatus;

    private Date realstartdate;

    private Date realenddate;

    private Date closesharedate;

    private Date createdate;

    private Date updatedate;

    private Short runstatus;

//    private Integer processstatus;

    private Long currcdc;

    private Long mdata1;

    private Long mdata2;

    private String mdata3;

    private String mdata4;

    private Date mdata5;

}