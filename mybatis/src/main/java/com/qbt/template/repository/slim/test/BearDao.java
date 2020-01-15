package com.qbt.template.repository.slim.test;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BearDao {

    String table = "bear";/*table*/

    @Insert("INSERT INTO " + table + "(dr" +
//            " ,id " +
            /*InsertField*/
            ") " +
            "VALUES(0" +
//            " ,#{id} " +
            /*InsertValue*/
            ")")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(Bear bear);

    @Update("UPDATE " + table + " SET dr = 1 WHERE id = #{id}")
    void delete(Bear bear);

    @Select("<script>" +
            " select id " +
            /*SelectFieldAndAlias*/
            " from " + table + " " +
            " where dr = 0 " +
//            "<if test=' != null'>AND  = #{}</if>" +
//            "<if test=' != null'>AND  like #{}</if>" +
            " </script>")
    List<Bear> findAll(BearSpecification bearSpecification);

    @Select("<script>" +
            " select id " +
            /*SelectFieldAndAlias*/
            " from " + table + " " +
            " where dr = 0 " +
            " And id = #{id} " +
            " </script>")
    Bear findById(Long id);

    @Update("UPDATE " + table + " " +
            "SET " +
            /*UpdateExp*/
            "dr = 0 " +
            "WHERE id = #{id}")
    void update(Bear bear);
}
