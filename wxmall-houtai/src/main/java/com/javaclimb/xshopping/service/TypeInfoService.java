package com.javaclimb.xshopping.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.xshopping.mapper.TypeInfoMapper;
import com.javaclimb.xshopping.model.TypeInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品类别相关的service
 */
@Service
public class TypeInfoService {

    @Resource
    private TypeInfoMapper typeInfoMapper;

    /**
     * 分页查询商品类别列表
     */
    public PageInfo<TypeInfo> findPage(Integer pageNum,Integer pageSize,String name){
        PageHelper.startPage(pageNum,pageSize); //帮助实现分页
        List<TypeInfo> list = typeInfoMapper.findByName(name);
        return PageInfo.of(list); //返回页面数据
    }

    /**
     * 新增商品类别,新增完成之后将商品类别信息再返回去，返回TypeInfo对象
     */
    public TypeInfo add(TypeInfo typeInfo){
        typeInfoMapper.insertSelective(typeInfo);
        return typeInfo;

    }

    /**
     * 修改商品类别
     */
    public void update(TypeInfo typeInfo){
        typeInfoMapper.updateByPrimaryKeySelective(typeInfo);
    }

    /**
     * 根据id删除商品类别
     */
    public void delete(Long id){
        typeInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id获取商品类别
     */
    public TypeInfo findById(Long id){
        return typeInfoMapper.selectByPrimaryKey(id);
    }
}
