package com.javaclimb.xshopping.mapper;

import com.javaclimb.xshopping.model.TypeInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 商品类别相关的Mapper
 */
public interface TypeInfoMapper extends Mapper<TypeInfo> {
    /*根据类别名称查询*/
    List<TypeInfo> findByName(@Param("name") String name);
}