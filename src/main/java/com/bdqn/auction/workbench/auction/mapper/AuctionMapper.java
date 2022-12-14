package com.bdqn.auction.workbench.auction.mapper;

import com.bdqn.auction.workbench.auction.entity.Auction;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AuctionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auction
     *
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    int deleteByPrimaryKey(String auctionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auction
     *
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    int insert(Auction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auction
     *
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    int insertSelective(Auction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auction
     *
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    Auction selectByPrimaryKey(String auctionId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auction
     *
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    int updateByPrimaryKeySelective(Auction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_auction
     *
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    int updateByPrimaryKey(Auction record);
    /**
     * 查询根据查询条件分页查询
     */
    List<Auction> selectAuctionByConditionForPage(@Param("map") Map<String,String> map);
    /**
     * 根据查询条件查询分页总条数
     */
    int selectCountByConditionForPage(@Param("map") Map<String,String> map);

    /**
     * 根据id删除商品
     */
    int deleteAuctionById(@Param("id") String id);
    /**
     * 插入商品对象
     */
    int insertAuction(Auction auction);
    /**
     * 根据id查询商品
     */
    Auction selectAuctionById(@Param("auctionId") String id);
    /**
     * 修改商品
     */
    int updateAuction(@Param("auction") Auction auction);


}