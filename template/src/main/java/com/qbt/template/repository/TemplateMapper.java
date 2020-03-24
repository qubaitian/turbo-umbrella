package com.qbt.template.repository;

import com.qbt.template.domain.Template;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TemplateMapper {

  String table = "template ";/*table*/

  @Insert("INSERT INTO " + table + "(dr" +
//            " ,id " +
          " , name " +
          /*InsertField*/
          ") " +
          "VALUES(0" +
//            " ,#{id} " +
          /*InsertValue*/
          " ,#{name} " +
          ")")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void add(Template template);

  @Update("UPDATE " + table + " " +
          "SET " +
          /*UpdateExp*/
          "name = #{name}, " +
          "dr = 0 " +
          "WHERE id = #{id}")
  void update(Template template);

  @Update("UPDATE " + table + " SET dr = 1 WHERE id = #{id}")
  void delete(Template template);

  @Select("<script>" +
          " select id " +
          /*SelectFieldAndAlias*/
          " ,name name " +
          " from " + table + " " +
          " where dr = 0 " +
          " And id = #{id} " +
          " </script>")
  Template findById(Long id);

}
