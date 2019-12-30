package com.qbt.template.repository.append;/*adf*/

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CandyPoDao {

    String table = "candy";/*table*/

    @Insert("INSERT INTO " + table + "(dr" +
            /*InsertField*/
            " ,name " +
            " ,code " +
            ") " +
            "VALUES(0" +
            /*InsertValue*/
            " ,#{name} " +
            " ,#{code} " +
            ")")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(CandyPo candyPo);

    @Update("UPDATE " + table + " SET dr = 1 WHERE id = #{id}")
    void delete(CandyPo candyPo);

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
    List<CandyPo> findAll(CandySpecification candySpecification);

    @Select("<script>" +
            " select id " +
            /*SelectFieldAndAlias*/
            " ,name name " +
            " ,code code " +
            " from " + table + " " +
            " where dr = 0 " +
            " And id = #{id} " +
            " </script>")
    CandyPo findById(Long id);

    @Update("UPDATE " + table + " " +
            "SET " +
            /*UpdateExp*/
            "name = #{name}, " +
            "code = #{code}, " +
            "dr = 0 " +
            "WHERE id = #{id}")
    void update(CandyPo candyPo);

}
