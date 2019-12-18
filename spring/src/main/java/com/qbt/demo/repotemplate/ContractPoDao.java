package com.qbt.demo.repotemplate;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ContractPoDao {

    @Insert("INSERT INTO contract(dr" +
            ") " +
            "VALUES(0" +
            ")")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void add(ContractPo contractPo);

    @Update("UPDATE contract " +
            "SET " +
            "dr = 0 " +
            "WHERE id = #{id}")
    void update(ContractPo contractPo);

    @Update("UPDATE contract SET dr = 1 WHERE id = #{id}")
    void delete(ContractPo contractPo);

    @Select("<script>" +
            " select id " +
            " from contract " +
            " where dr = 0 " +
            " And id = #{id} " +
            " </script>")
    ContractPo findById(Long id);

    @Select("<script>" +
            " select id " +
            " from contract " +
            " where dr = 0 " +
//            "<if test=' != null'>AND  = #{}</if>" +
//            "<if test=' != null'>AND  like #{}</if>" +
            " </script>")
    List<ContractPo> findAll(ContractSpecification contractSpecification);

}
