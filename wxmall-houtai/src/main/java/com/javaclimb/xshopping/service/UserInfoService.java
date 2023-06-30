package com.javaclimb.xshopping.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.xshopping.common.ResultCode;
import com.javaclimb.xshopping.exception.CustomException;
import com.javaclimb.xshopping.mapper.UserInfoMapper;
import com.javaclimb.xshopping.model.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户相关的service
 */
@Service
public class UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 登录
     */
    public UserInfo login(String name,String password){
        //判断数据库里是否有该用户
        List<UserInfo> list = userInfoMapper.findByName(name);
        if (CollectionUtil.isEmpty(list)){
            throw new CustomException(ResultCode.USER_NOT_EXIT_ERROR);
        }
        //判断密码是否正确
        if (!SecureUtil.md5(password).equals(list.get(0).getPassword())){
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        return list.get(0);
    }

    /**
     * 重置密码（用于忘记密码）
     */
    public UserInfo resetPassword(String name){
        //判断数据库里是否有该用户
        List<UserInfo> list = userInfoMapper.findByName(name);
        if (CollectionUtil.isEmpty(list)){
            throw new CustomException(ResultCode.USER_NOT_EXIT_ERROR);
        }
        list.get(0).setPassword(SecureUtil.md5("123456"));
        userInfoMapper.updateByPrimaryKeySelective(list.get(0));
        return list.get(0);
    }

    /**
     * 分页查询用户列表
     */
    public PageInfo<UserInfo> findPage(Integer pageNum,Integer pageSize,String name){
        PageHelper.startPage(pageNum,pageSize); //帮助实现分页
        List<UserInfo> list = userInfoMapper.findByName(name);
        return PageInfo.of(list); //返回页面数据
    }

    /**
     * 新增用户,新增完成之后将用户信息再返回去，返回UserInfo对象
     */
    public UserInfo add(UserInfo userInfo){
        //判断数据库里是否有该用户
        List<UserInfo> list = userInfoMapper.findByName(userInfo.getName());
        if (CollectionUtil.isNotEmpty(list)){
            return list.get(0);
        }
        if (StrUtil.isBlank(userInfo.getPassword())){
            //设置默认密码为123456
            userInfo.setPassword(SecureUtil.md5("123456"));
        }else {
            userInfo.setPassword(SecureUtil.md5(userInfo.getPassword()));
        }
        //设置新增用户是买家，不允许添加管理员和卖家
        userInfo.setLevel(3);
        userInfoMapper.insertSelective(userInfo);
        return userInfo;

    }

    /**
     * 修改用户
     */
    public void update(UserInfo userInfo){

        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    /**
     * 根据id删除用户
     */
    public void delete(Long id){

        userInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id获取用户
     */
    public UserInfo findById(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    /*用户总数*/
    public Integer count(){
        return userInfoMapper.count();
    }
}
