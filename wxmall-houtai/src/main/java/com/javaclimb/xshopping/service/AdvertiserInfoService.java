package com.javaclimb.xshopping.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.xshopping.mapper.AdvertiserInfoMapper;
import com.javaclimb.xshopping.model.AdvertiserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 公告相关的service
 */
@Service
public class AdvertiserInfoService {

    @Resource
    private AdvertiserInfoMapper advertiserInfoMapper;

    /**
     * 分页查询公告列表
     */
    public PageInfo<AdvertiserInfo> findPage(Integer pageNum,Integer pageSize,String name){
        PageHelper.startPage(pageNum,pageSize); //帮助实现分页
        List<AdvertiserInfo> list = advertiserInfoMapper.findByName(name);
        return PageInfo.of(list); //返回页面数据
    }

    /**
     * 新增公告,新增完成之后将公告信息再返回去，返回AdvertiserInfo对象
     */
    public AdvertiserInfo add(AdvertiserInfo advertiserInfo){
        advertiserInfo.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        advertiserInfoMapper.insertSelective(advertiserInfo);
        return advertiserInfo;
    }

    /**
     * 修改公告
     */
    public void update(AdvertiserInfo advertiserInfo){
        advertiserInfo.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        advertiserInfoMapper.updateByPrimaryKeySelective(advertiserInfo);
    }

    /**
     * 根据id删除公告
     */
    public void delete(Long id){
        advertiserInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id查询一条公告详情
     */
    public AdvertiserInfo findById(Long id){
        return advertiserInfoMapper.selectByPrimaryKey(id);
    }
}
