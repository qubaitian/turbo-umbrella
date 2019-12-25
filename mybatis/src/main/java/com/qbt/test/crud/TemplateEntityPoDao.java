package com.qbt.test.crud;/*adf*/

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TemplateEntityPoDao {

    String table = "template_entity";/*table*/

    @Insert("INSERT INTO " + table + "(dr" +
            /*InsertField*/
            ") " +
            "VALUES(0" +
            /*InsertValue*/
            ")")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(TemplateEntityPo templateEntityPo);

    @Update("UPDATE " + table + " " +
            "SET " +
            /*UpdateExp*/
            "dr = 0 " +
            "WHERE id = #{id}")
    void update(TemplateEntityPo templateEntityPo);

    @Update("UPDATE contract SET dr = 1 WHERE id = #{id}")
    void delete(TemplateEntityPo templateEntityPo);

    @Select("<script>" +
            " select id " +
            /*SelectFieldAndAlias*/
            " from " + table + " " +
            " where dr = 0 " +
            " And id = #{id} " +
            " </script>")
    TemplateEntityPo findById(Long id);

    @Select("<script>" +
            " select id " +
            /*SelectFieldAndAlias*/
            " from " + table + " " +
            " where dr = 0 " +
//            "<if test=' != null'>AND  = #{}</if>" +
//            "<if test=' != null'>AND  like #{}</if>" +
            " </script>")
    List<TemplateEntityPo> findAll(TemplateEntitySpecification templateEntitySpecification);

}
