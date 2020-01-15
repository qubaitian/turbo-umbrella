package com.qbt.template.repository.slim;/*package*/

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TemplateDao {

    String table = "tableName   ";/*table*/

    @Insert("INSERT INTO " + table + "(dr" +
//            " ,id " +
            /*InsertField*/
            ") " +
            "VALUES(0" +
//            " ,#{id} " +
            /*InsertValue*/
            ")")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(Template template);

    @Update("UPDATE " + table + " SET dr = 1 WHERE id = #{id}")
    void delete(Template template);

    @Select("<script>" +
            " select id " +
            /*SelectFieldAndAlias*/
            " from " + table + " " +
            " where dr = 0 " +
//            "<if test=' != null'>AND  = #{}</if>" +
//            "<if test=' != null'>AND  like #{}</if>" +
            " </script>")
    List<Template> findAll(TemplateSpecification templateSpecification);

    @Select("<script>" +
            " select id " +
            /*SelectFieldAndAlias*/
            " from " + table + " " +
            " where dr = 0 " +
            " And id = #{id} " +
            " </script>")
    Template findById(Long id);

    @Update("UPDATE " + table + " " +
            "SET " +
            /*UpdateExp*/
            "dr = 0 " +
            "WHERE id = #{id}")
    void update(Template template);
}
