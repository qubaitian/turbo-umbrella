package com.qbt.demo.file;/*adf*/

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ApplePoDao {

    String table="apple";

    @Insert("INSERT INTO "+table+"(dr" +
            ") " +
            "VALUES(0" +
            ")")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(ApplePo applePo);

    @Update("UPDATE "+table+" " +
            "SET " +
            "dr = 0 " +
            "WHERE id = #{id}")
    void update(ApplePo applePo);

    @Update("UPDATE apple SET dr = 1 WHERE id = #{id}")
    void delete(ApplePo applePo);

    @Select("<script>" +
            " select id " +
            " from "+table+" " +
            " where dr = 0 " +
            " And id = #{id} " +
            " </script>")
    ApplePo findById(Long id);

    @Select("<script>" +
            " select id " +
            " from "+table+" " +
            " where dr = 0 " +
//            "<if test=' != null'>AND  = #{}</if>" +
//            "<if test=' != null'>AND  like #{}</if>" +
            " </script>")
    List<ApplePo> findAll(AppleSpecification appleSpecification);

}
