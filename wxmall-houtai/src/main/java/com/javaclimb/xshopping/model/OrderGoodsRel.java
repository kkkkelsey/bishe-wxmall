package com.javaclimb.xshopping.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 订单商品关系映射表
 */
@Table(name = "order_goods_rel")
public class OrderGoodsRel implements Serializable {
    /**
     * 自增id
     *
     * @mbg.generated
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 订单ID
     *
     * @mbg.generated
     */
    @Column(name = "orderId")
    private Long orderid;

    /**
     * 所属商品id
     *
     * @mbg.generated
     */
    @Column(name = "goodsId")
    private Long goodsid;

    /**
     * 商品数量
     *
     * @mbg.generated
     */
    @Column(name = "count")
    private Integer count;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderid=").append(orderid);
        sb.append(", goodsid=").append(goodsid);
        sb.append(", count=").append(count);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}