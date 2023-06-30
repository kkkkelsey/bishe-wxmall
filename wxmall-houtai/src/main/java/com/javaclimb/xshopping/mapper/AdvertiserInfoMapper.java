package com.javaclimb.xshopping.mapper;

import com.javaclimb.xshopping.model.AdvertiserInfo;

public interface AdvertiserInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertiser_info
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertiser_info
     *
     * @mbg.generated
     */
    int insert(AdvertiserInfo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertiser_info
     *
     * @mbg.generated
     */
    int insertSelective(AdvertiserInfo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertiser_info
     *
     * @mbg.generated
     */
    AdvertiserInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertiser_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AdvertiserInfo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertiser_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(AdvertiserInfo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table advertiser_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AdvertiserInfo row);
}