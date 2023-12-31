package com.javaclimb.xshopping.model;

import javax.persistence.*;
import java.util.List;

/**
 *   商品订单信息表
 */
@Table(name = "order_info")
public class OrderInfo {
    /**
     *主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     *   订单ID
     */
    @Column(name = "orderId")
    private String orderid;

    /**
     *   总价格
     */
    @Column(name = "totalprice")
    private Double totalprice;

    /**
     *   所属用户
     */
    @Column(name = "userId")
    private Long userid;

    /**
     *   用户等级
     */
    @Column(name = "level")
    private Integer level;

    /**
     *   联系地址
     */
    @Column(name = "linkAddress")
    private String linkaddress;

    /**
     *   联系电话
     */
    @Column(name = "linkPhone")
    private String linkphone;

    /**
     *   联系人
     */
    @Column(name = "linkMan")
    private String linkman;

    /**
     *   创建时间
     */
    @Column(name = "createTime")
    private String createtime;

    /**
     *   订单状态
     */
    @Column(name = "status")
    private String status;

    @Transient
    private UserInfo userInfo;

    @Transient
    private List<GoodsInfo> goodsList;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<GoodsInfo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsInfo> goodsList) {
        this.goodsList = goodsList;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.id
     *
     * @return the value of order_info.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.id
     *
     * @param id the value for order_info.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.orderId
     *
     * @return the value of order_info.orderId
     *
     * @mbg.generated
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.orderId
     *
     * @param orderid the value for order_info.orderId
     *
     * @mbg.generated
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.totalPrice
     *
     * @return the value of order_info.totalPrice
     *
     * @mbg.generated
     */
    public Double getTotalprice() {
        return totalprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.totalPrice
     *
     * @param totalprice the value for order_info.totalPrice
     *
     * @mbg.generated
     */
    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.userId
     *
     * @return the value of order_info.userId
     *
     * @mbg.generated
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.userId
     *
     * @param userid the value for order_info.userId
     *
     * @mbg.generated
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.level
     *
     * @return the value of order_info.level
     *
     * @mbg.generated
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.level
     *
     * @param level the value for order_info.level
     *
     * @mbg.generated
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.linkAddress
     *
     * @return the value of order_info.linkAddress
     *
     * @mbg.generated
     */
    public String getLinkaddress() {
        return linkaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.linkAddress
     *
     * @param linkaddress the value for order_info.linkAddress
     *
     * @mbg.generated
     */
    public void setLinkaddress(String linkaddress) {
        this.linkaddress = linkaddress == null ? null : linkaddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.linkPhone
     *
     * @return the value of order_info.linkPhone
     *
     * @mbg.generated
     */
    public String getLinkphone() {
        return linkphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.linkPhone
     *
     * @param linkphone the value for order_info.linkPhone
     *
     * @mbg.generated
     */
    public void setLinkphone(String linkphone) {
        this.linkphone = linkphone == null ? null : linkphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.linkMan
     *
     * @return the value of order_info.linkMan
     *
     * @mbg.generated
     */
    public String getLinkman() {
        return linkman;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.linkMan
     *
     * @param linkman the value for order_info.linkMan
     *
     * @mbg.generated
     */
    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.createTime
     *
     * @return the value of order_info.createTime
     *
     * @mbg.generated
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.createTime
     *
     * @param createtime the value for order_info.createTime
     *
     * @mbg.generated
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_info.status
     *
     * @return the value of order_info.status
     *
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_info.status
     *
     * @param status the value for order_info.status
     *
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}