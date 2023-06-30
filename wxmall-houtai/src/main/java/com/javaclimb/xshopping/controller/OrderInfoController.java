package com.javaclimb.xshopping.controller;

import com.github.pagehelper.PageInfo;
import com.javaclimb.xshopping.common.Result;
import com.javaclimb.xshopping.common.ResultCode;
import com.javaclimb.xshopping.exception.CustomException;
import com.javaclimb.xshopping.model.GoodsInfo;
import com.javaclimb.xshopping.model.OrderInfo;
import com.javaclimb.xshopping.service.OrderInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 订单控制器
 */
@RestController
@RequestMapping(value = "orderInfo")
public class OrderInfoController {

    @Resource
    private OrderInfoService orderInfoService;

    /**
     * 下单
     */
    @PostMapping
    public Result<OrderInfo> add(@RequestBody OrderInfo orderInfo){
        Long userId = orderInfo.getUserid();
        List<GoodsInfo> goodsList = orderInfo.getGoodsList();
        if (userId == null || goodsList == null || goodsList.size() == 0){
            throw new CustomException(ResultCode.PARAM_ERROR);
        }
        orderInfo.setStatus("待付款");
        return Result.success(orderInfoService.add(orderInfo));
    }

    /**
     * 查询所有信息（分页）
     */
    @GetMapping("/page")
    public Result<PageInfo<OrderInfo>> findPage(@RequestParam(required = false) Long userId,
                                                    @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                                    @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                                    HttpServletRequest request){
        return Result.success(orderInfoService.findPages(userId,pageNum,pageSize,request));
    }

    /**
     * 查询所有信息（分页）
     */
    @GetMapping("/page/front")
    public Result<PageInfo<OrderInfo>> findFrontPage(@RequestParam(required = false) Long userId,
                                                    @RequestParam(required = false) String status,
                                                    @RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                                    @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        return Result.success(orderInfoService.findFrontPages(userId,status,pageNum,pageSize));
    }

    /**
     * 修改订单状态
     */
    @PostMapping("/status/{id}/{status}")
    public Result status(@PathVariable Long id,@PathVariable String status){
        orderInfoService.changeStatus(id, status);
        return Result.success();
    }

    /**
     * 删除订单
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        orderInfoService.delete(id);
        return Result.success();
    }

    /**
     * 根据订单id查询所有商品
     */
    @GetMapping("/order/{id}")
    public Result<OrderInfo> findById(@PathVariable Long id) {
        OrderInfo orderInfo = orderInfoService.findById(id);
        return Result.success(orderInfo);
    }

}
