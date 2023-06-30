package com.javaclimb.xshopping.mapper;

import com.javaclimb.xshopping.model.CommentInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CommentInfoMapper extends Mapper<CommentInfo> {

    /*根据内容模糊查询评价列表*/
    List<CommentInfo> findByContent(@Param("name") String name);

    /*根据商品id获取评论列表*/
    @Select("select a.*,u.name as userName from comment_info as a left join user_info as u on a.userId=u.id where goodsId = #{goodsid}")
    List<CommentInfo> findByGoodsid(@Param("goodsid") Long goodsid);

    /*评论总数*/
    @Select("select count(*) from comment_info")
    Integer count();
}