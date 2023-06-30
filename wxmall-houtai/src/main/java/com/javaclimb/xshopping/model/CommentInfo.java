package com.javaclimb.xshopping.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 商品评价表
 */
@Table(name = "comment_info")
public class CommentInfo implements Serializable {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 评价内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 所属商品
     */
    @Column(name = "goodsId")
    private Long goodsid;

    /**
     * 评价人id
     */
    @Column(name = "userId")
    private Long userid;

    /**
     * 用户等级
     */
    @Column(name = "level")
    private Integer level;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private String createtime;

    /**
     * 所属评价人姓名
     */
    @Transient
    private String userName;

    /**
     * 所属商品名称
     */
    @Transient
    private String goodsName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Long goodsid) {
        this.goodsid = goodsid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", content=").append(content);
        sb.append(", goodsid=").append(goodsid);
        sb.append(", userid=").append(userid);
        sb.append(", level=").append(level);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}