package com.javaclimb.xshopping.mapper;

import com.javaclimb.xshopping.model.OrderGoodsRel;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrderGoodsRelMapper extends Mapper<OrderGoodsRel> {

    /*根据订单id获取商品列表 */
    List<OrderGoodsRel> findByOrderid(Long orderId);

   /*根据订单id删除关联关系*/
    void deleteByOrderId(Long orderId);

    /*统计总销量*/
    @Select("select sum(count) from order_goods_rel")
    Integer totalShopping();
}