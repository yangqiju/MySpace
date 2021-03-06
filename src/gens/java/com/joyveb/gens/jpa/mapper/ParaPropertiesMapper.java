package com.joyveb.gens.jpa.mapper;

import com.joyveb.gens.jpa.model.ParaProperties;
import com.joyveb.gens.jpa.model.ParaPropertiesExample;
import com.joyveb.gens.jpa.model.ParaPropertiesKey;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ParaPropertiesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_PROPERTIES
     *
     * @mbggenerated
     */
    int countByExample(ParaPropertiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_PROPERTIES
     *
     * @mbggenerated
     */
    int deleteByExample(ParaPropertiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_PROPERTIES
     *
     * @mbggenerated
     */
    @Delete({
        "delete from T_PARA_PROPERTIES",
        "where KEY = #{key,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(ParaPropertiesKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_PROPERTIES
     *
     * @mbggenerated
     */
    @Insert({
        "insert into T_PARA_PROPERTIES (KEY, VALUE, ",
        "DES)",
        "values (#{key,jdbcType=VARCHAR}, #{value,jdbcType=VARCHAR}, ",
        "#{des,jdbcType=VARCHAR})"
    })
    int insert(ParaProperties record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_PROPERTIES
     *
     * @mbggenerated
     */
    int insertSelective(ParaProperties record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_PROPERTIES
     *
     * @mbggenerated
     */
    List<ParaProperties> selectByExample(ParaPropertiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_PROPERTIES
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "KEY, VALUE, DES",
        "from T_PARA_PROPERTIES",
        "where KEY = #{key,jdbcType=VARCHAR}"
    })
    @ResultMap("BaseResultMap")
    ParaProperties selectByPrimaryKey(ParaPropertiesKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_PROPERTIES
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ParaProperties record, @Param("example") ParaPropertiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_PROPERTIES
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ParaProperties record, @Param("example") ParaPropertiesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_PROPERTIES
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ParaProperties record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PARA_PROPERTIES
     *
     * @mbggenerated
     */
    @Update({
        "update T_PARA_PROPERTIES",
        "set VALUE = #{value,jdbcType=VARCHAR},",
          "DES = #{des,jdbcType=VARCHAR}",
        "where KEY = #{key,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(ParaProperties record);

    /**
    * This method was generated by MyBatis Generator.
    * This method corresponds to the database table T_PARA_PROPERTIES
    */
    int sumByExample(ParaPropertiesExample example);

    /**
    * This method was generated by MyBatis Generator.
    * This method corresponds to the database table T_PARA_PROPERTIES
    */
    List<HashMap> groupByExample(ParaPropertiesExample example);
}