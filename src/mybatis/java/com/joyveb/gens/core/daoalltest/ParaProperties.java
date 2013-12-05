package com.joyveb.gens.core.daoalltest;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("ParaProperties")
public @Data class ParaProperties implements Serializable {
    private String key;

    private String value;

    private String des;

    private static final long serialVersionUID = 1L;
}