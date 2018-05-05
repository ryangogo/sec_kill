package com.seckill.dao;

import com.seckill.pojo.SuccessKilled;

public interface SuccessKilledMapper {

    int insert(SuccessKilled record);

    int insertSelective(SuccessKilled record);

    int updateByPrimaryKeySelective(SuccessKilled record);

    int updateByPrimaryKey(SuccessKilled record);
}