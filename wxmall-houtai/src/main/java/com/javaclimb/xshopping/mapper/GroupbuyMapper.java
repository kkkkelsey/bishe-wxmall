package com.javaclimb.xshopping.mapper;

import com.javaclimb.xshopping.model.Groupbuy;

public interface GroupbuyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Groupbuy row);

    int insertSelective(Groupbuy row);

    Groupbuy selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Groupbuy row);

    int updateByPrimaryKey(Groupbuy row);
}