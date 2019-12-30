package com.qbt.template.test;/*adf*/

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FootballPoDao {

    String table = "football";/*table*/

    @Insert("INSERT INTO " + table + "(dr" +
//            " ,id " +
            /*InsertField*/
            " ,name " +
            " ,code " +
            ") " +
            "VALUES(0" +
            /*InsertValue*/
            " ,#{name} " +
            " ,#{code} " +
//            " ,#{id} " +
            ")")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(FootballPo footballPo);

    @Update("UPDATE " + table + " SET dr = 1 WHERE id = #{id}")
    void delete(FootballPo footballPo);

    @Select("<script>" +
            " select id " +
            /*SelectFieldAndAlias*/
            " ,name name " +
            " ,code code " +
            " from " + table + " " +
            " where dr = 0 " +
//            "<if test=' != null'>AND  = #{}</if>" +
//            "<if test=' != null'>AND  like #{}</if>" +
            " </script>")
    List<FootballPo> findAll(FootballSpecification footballSpecification);

    @Select("<script>" +
            " select id " +
            /*SelectFieldAndAlias*/
            " ,name name " +
            " ,code code " +
            " from " + table + " " +
            " where dr = 0 " +
            " And id = #{id} " +
            " </script>")
    FootballPo findById(Long id);

    @Update("UPDATE " + table + " " +
            "SET " +
            /*UpdateExp*/
            "name = #{name}, " +
            "code = #{code}, " +
            "dr = 0 " +
            "WHERE id = #{id}")
    void update(FootballPo footballPo);

}
