package com.javaclimb.xshopping.mapper;

import com.javaclimb.xshopping.model.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderInfoMapper extends Mapper<OrderInfo> {

    /*根据订单id查询一条订单数据*/
    @Select("select * from order_info where orderId = #{orderId}")
    List<OrderInfo> findByOrderId(@Param("orderId") String orderId);

    /*根据前端用户id和状态查询订单列表*/
    List<OrderInfo> findByEndUserId(@Param("userId")Long userId,@Param("status")String status);

    /*根据主键查询*/
    @Select("select * from order_info where id = #{id}")
    OrderInfo findById(@Param("id") Long id);

    /*更新订单状态*/
    @Update("update order_info set status = #{status} where id = #{id}")
    void updateStatus(@Param("id") Long id, @Param("status")String status);

   /*删除订单*/
    void deleteById(Long id);

    /*总交易额*/
    @Select("select sum(totalPrice) from order_info where status = '完成'")
    Double totalPrice();

    /*分类总销售额*/
    @Select("SELECT SUM(a.count*b.price) AS `price`,c.`name` FROM order_goods_rel AS a\n" +
            "LEFT JOIN goods_info AS b ON a.goodsId=b.id\n" +
            "LEFT JOIN type_info AS c ON c.id=b.typeId\n" +
            "GROUP BY b.typeId")
    List<Map<String,Object>> getTypePrice();

    /*分类总销量*/
    @Select("SELECT SUM(GI.sales) AS `count`,TI.`name` FROM goods_info AS GI\n" +
            "LEFT JOIN type_info AS TI ON GI.typeId = TI.id\n" +
            "GROUP BY GI.typeId")
    List<Map<String,Object>> getTypeCount();
}