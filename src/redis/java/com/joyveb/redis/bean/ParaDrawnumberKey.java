package com.joyveb.redis.bean;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ParaDrawnumberKey {
    private Short ltype;

    private BigDecimal idrawnumber;

    private BigDecimal edrawnumber;

}