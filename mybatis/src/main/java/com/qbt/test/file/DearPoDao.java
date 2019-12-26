package com.qbt.test.file;/*adf*/

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DearPoDao {

    String table = "dear";/*table*/

    @Insert("INSERT INTO " + table + "(dr" +
            /*InsertField*/
            " ,name " +
            " ,code " +
            " ,candy " +
            " ,candies " +
            ") " +
            "VALUES(0" +
            /*InsertValue*/
            " ,#{name} " +
            " ,#{code} " +
            " ,#{candy} " +
            " ,#{candies} " +
            ")")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(DearPo dearPo);

    @Update("UPDATE " + table + " SET dr = 1 WHERE id = #{id}")
    void delete(DearPo dearPo);

    @Select("<script>" +
            " select id " +
            /*SelectFieldAndAlias*/
            " ,name name " +
            " ,code code " +
            " ,candy candy " +
            " ,candies candies " +
            " from " + table + " " +
            " where dr = 0 " +
//            "<if test=' != null'>AND  = #{}</if>" +
//            "<if test=' != null'>AND  like #{}</if>" +
            " </script>")
    List<DearPo> findAll(DearSpecification dearSpecification);

    @Select("<script>" +
            " select id " +
            /*SelectFieldAndAlias*/
            " ,name name " +
            " ,code code " +
            " ,candy candy " +
            " ,candies candies " +
            " from " + table + " " +
            " where dr = 0 " +
            " And id = #{id} " +
            " </script>")
    DearPo findById(Long id);

    @Update("UPDATE " + table + " " +
            "SET " +
            /*UpdateExp*/
            "name = #{name}, " +
            "code = #{code}, " +
            "candy = #{candy}, " +
            "candies = #{candies}, " +
            "dr = 0 " +
            "WHERE id = #{id}")
    void update(DearPo dearPo);

}
