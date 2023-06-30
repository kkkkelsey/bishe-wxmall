package com.javaclimb.xshopping.controller;

import com.github.pagehelper.PageInfo;
import com.javaclimb.xshopping.common.Result;
import com.javaclimb.xshopping.model.AdvertiserInfo;
import com.javaclimb.xshopping.service.AdvertiserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 公告增删改查控制器
 */
@RestController
@RequestMapping(value = "/advertiserInfo")
public class AdvertiserInfoController {

    @Resource
    private AdvertiserInfoService advertiserInfoService;

    /**
     * 分页查询公告列表
     * @param pageNum 第几页
     * @param pageSize 每一页大小，即数量
     * @param name 公告名
     */
    @GetMapping("/page/{name}")
    public Result<PageInfo<AdvertiserInfo>> page(@RequestParam(defaultValue = "1") Integer pageNum,
                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                           @PathVariable String name){
        return Result.success(advertiserInfoService.findPage(pageNum,pageSize,name));
    }

    /**
     * 新增公告
     */
    @PostMapping
    public Result<AdvertiserInfo> add(@RequestBody AdvertiserInfo advertiserInfo){
        advertiserInfoService.add(advertiserInfo);
        return Result.success(advertiserInfo);
    }

    /**
     * 更新公告
     */
    @PutMapping
    public Result update(@RequestBody AdvertiserInfo advertiserInfo){
        advertiserInfoService.update(advertiserInfo);
        return Result.success();
    }

    /**
     * 删除公告
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        advertiserInfoService.delete(id);
        return Result.success();
    }

    /**
     * 根据id查询一条公告详情
     */
    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id){
        return Result.success(advertiserInfoService.findById(id));
    }
}
