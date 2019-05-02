package com.example.demo.mapper;

import com.example.demo.entity.Tnum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Constantine
 */
@Mapper
public interface TnumMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tnum record);

    int insertSelective(Tnum record);

    Tnum selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tnum record);

    int updateByPrimaryKey(Tnum record);

    List<Tnum> showTnum(@Param(value = "sql")String sql);
}