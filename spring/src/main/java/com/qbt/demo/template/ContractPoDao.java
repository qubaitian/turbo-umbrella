package com.qbt.demo.template;/*adf*/

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ContractPoDao {

    String table = "contract";

    @Insert("INSERT INTO " + table + "(dr" +
            /*InsertField*/
            ") " +
            "VALUES(0" +
            /*InsertValue*/
            ")")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(ContractPo contractPo);

    @Update("UPDATE " + table + " " +
            "SET " +
            /*UpdateExp*/
            "dr = 0 " +
            "WHERE id = #{id}")
    void update(ContractPo contractPo);

    @Update("UPDATE contract SET dr = 1 WHERE id = #{id}")
    void delete(ContractPo contractPo);

    @Select("<script>" +
            " select id " +
            /*SelectFieldAndAlias*/
            " from " + table + " " +
            " where dr = 0 " +
            " And id = #{id} " +
            " </script>")
    ContractPo findById(Long id);

    @Select("<script>" +
            " select id " +
            /*SelectFieldAndAlias*/
            " from " + table + " " +
            " where dr = 0 " +
//            "<if test=' != null'>AND  = #{}</if>" +
//            "<if test=' != null'>AND  like #{}</if>" +
            " </script>")
    List<ContractPo> findAll(ContractSpecification contractSpecification);

}
