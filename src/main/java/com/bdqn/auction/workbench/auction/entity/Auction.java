package com.bdqn.auction.workbench.auction.entity;

import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
@Alias("auction")
public class Auction {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_auction.auction_id
     *
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    private String auctionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_auction.auction_name
     *
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    private String auctionName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_auction.auction_start_price
     *
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    private BigDecimal auctionStartPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_auction.auction_upset
     *
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    private BigDecimal auctionUpset;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_auction.auction_start_time
     *
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    private String auctionStartTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_auction.auction_end_time
     *
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    private String auctionEndTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_auction.auction_pic
     *
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    private String auctionPic;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_auction.auction_pic_type
     *
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    private String auctionPicType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_auction.auction_desc
     *
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    private String auctionDesc;
    /**
     * ???????????? 0:?????????1:??????
     */
    private Integer auctionStatus;
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_auction.auction_id
     *
     * @return the value of t_auction.auction_id
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    public String getAuctionId() {
        return auctionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_auction.auction_id
     *
     * @param auctionId the value for t_auction.auction_id
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    public void setAuctionId(String auctionId) {
        this.auctionId = auctionId == null ? null : auctionId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_auction.auction_name
     *
     * @return the value of t_auction.auction_name
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    public String getAuctionName() {
        return auctionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_auction.auction_name
     *
     * @param auctionName the value for t_auction.auction_name
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    public void setAuctionName(String auctionName) {
        this.auctionName = auctionName == null ? null : auctionName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_auction.auction_start_price
     *
     * @return the value of t_auction.auction_start_price
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    public BigDecimal getAuctionStartPrice() {
        return auctionStartPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_auction.auction_start_price
     *
     * @param auctionStartPrice the value for t_auction.auction_start_price
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    public void setAuctionStartPrice(BigDecimal auctionStartPrice) {
        this.auctionStartPrice = auctionStartPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_auction.auction_upset
     *
     * @return the value of t_auction.auction_upset
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    public BigDecimal getAuctionUpset() {
        return auctionUpset;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_auction.auction_upset
     *
     * @param auctionUpset the value for t_auction.auction_upset
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    public void setAuctionUpset(BigDecimal auctionUpset) {
        this.auctionUpset = auctionUpset;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_auction.auction_start_time
     *
     * @return the value of t_auction.auction_start_time
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    public String getAuctionStartTime() {
        return auctionStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_auction.auction_start_time
     *
     * @param auctionStartTime the value for t_auction.auction_start_time
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    public void setAuctionStartTime(String auctionStartTime) {
        this.auctionStartTime = auctionStartTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_auction.auction_end_time
     *
     * @return the value of t_auction.auction_end_time
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    public String getAuctionEndTime() {
        return auctionEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_auction.auction_end_time
     *
     * @param auctionEndTime the value for t_auction.auction_end_time
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    public void setAuctionEndTime(String auctionEndTime) {
        this.auctionEndTime = auctionEndTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_auction.auction_pic
     *
     * @return the value of t_auction.auction_pic
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    public String getAuctionPic() {
        return auctionPic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_auction.auction_pic
     *
     * @param auctionPic the value for t_auction.auction_pic
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    public void setAuctionPic(String auctionPic) {
        this.auctionPic = auctionPic == null ? null : auctionPic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_auction.auction_pic_type
     *
     * @return the value of t_auction.auction_pic_type
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    public String getAuctionPicType() {
        return auctionPicType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_auction.auction_pic_type
     *
     * @param auctionPicType the value for t_auction.auction_pic_type
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    public void setAuctionPicType(String auctionPicType) {
        this.auctionPicType = auctionPicType == null ? null : auctionPicType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_auction.auction_desc
     *
     * @return the value of t_auction.auction_desc
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    public String getAuctionDesc() {
        return auctionDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_auction.auction_desc
     *
     * @param auctionDesc the value for t_auction.auction_desc
     * @mbggenerated Mon Sep 19 20:19:51 CST 2022
     */
    public void setAuctionDesc(String auctionDesc) {
        this.auctionDesc = auctionDesc == null ? null : auctionDesc.trim();
    }

    public Integer getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(Integer auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "auctionId='" + auctionId + '\'' +
                ", auctionName='" + auctionName + '\'' +
                ", auctionStartPrice=" + auctionStartPrice +
                ", auctionUpset=" + auctionUpset +
                ", auctionStartTime='" + auctionStartTime + '\'' +
                ", auctionEndTime='" + auctionEndTime + '\'' +
                ", auctionPic='" + auctionPic + '\'' +
                ", auctionPicType='" + auctionPicType + '\'' +
                ", auctionDesc='" + auctionDesc + '\'' +
                ", auctionStatus=" + auctionStatus +
                '}';
    }
}