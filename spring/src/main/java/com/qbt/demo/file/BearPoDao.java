package com.qbt.demo.file;/*adf*/

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BearPoDao {

    String table = "bear";

    @Insert("INSERT INTO " + table + "(dr" +
            /*InsertField*/
            " ,name " +
            " ,code " +
            " ,bear " +
            " ,bears " +
            ") " +
            "VALUES(0" +
            /*InsertValue*/
            " ,#{name} " +
            " ,#{code} " +
            " ,#{bear} " +
            " ,#{bears} " +
            ")")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(BearPo bearPo);

    @Update("UPDATE " + table + " " +
            "SET " +
            /*UpdateExp*/
            "name = #{name}, " +
            "code = #{code}, " +
            "bear = #{bear}, " +
            "bears = #{bears}, " +
            "dr = 0 " +
            "WHERE id = #{id}")
    void update(BearPo bearPo);

    @Update("UPDATE bear SET dr = 1 WHERE id = #{id}")
    void delete(BearPo bearPo);

    @Select("<script>" +
            " select id " +
            /*SelectFieldAndAlias*/
            " ,name name " +
            " ,code code " +
            " ,bear bear " +
            " ,bears bears " +
            " from " + table + " " +
            " where dr = 0 " +
            " And id = #{id} " +
            " </script>")
    BearPo findById(Long id);

    @Select("<script>" +
            " select id " +
            /*SelectFieldAndAlias*/
            " ,name name " +
            " ,code code " +
            " ,bear bear " +
            " ,bears bears " +
            " from " + table + " " +
            " where dr = 0 " +
//            "<if test=' != null'>AND  = #{}</if>" +
//            "<if test=' != null'>AND  like #{}</if>" +
            " </script>")
    List<BearPo> findAll(BearSpecification bearSpecification);

}
