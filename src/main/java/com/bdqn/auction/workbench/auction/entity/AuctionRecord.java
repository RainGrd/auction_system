package com.bdqn.auction.workbench.auction.entity;

import com.bdqn.auction.settings.entity.AuctionUser;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.List;

@Alias("auctionRecord")
public class AuctionRecord {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_auction_record.id
     *
     * @mbggenerated Wed Sep 21 20:09:32 CST 2022
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_auction_record.user_id
     *
     * @mbggenerated Wed Sep 21 20:09:32 CST 2022
     */
    private AuctionUser auctionUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_auction_record.auction_id
     *
     * @mbggenerated Wed Sep 21 20:09:32 CST 2022
     */
    private Auction auction;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_auction_record.auction_time
     *
     * @mbggenerated Wed Sep 21 20:09:32 CST 2022
     */
    private String auctionTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_auction_record.auction_price
     *
     * @mbggenerated Wed Sep 21 20:09:32 CST 2022
     */
    private BigDecimal auctionPrice;

    /**
     * 竞拍状态
     */
    private String auctionState;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_auction_record.id
     *
     * @return the value of t_auction_record.id
     * @mbggenerated Wed Sep 21 20:09:32 CST 2022
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_auction_record.id
     *
     * @param id the value for t_auction_record.id
     * @mbggenerated Wed Sep 21 20:09:32 CST 2022
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public AuctionUser getAuctionUser() {
        return auctionUser;
    }

    public void setAuctionUser(AuctionUser auctionUser) {
        this.auctionUser = auctionUser;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_auction_record.auction_time
     *
     * @return the value of t_auction_record.auction_time
     * @mbggenerated Wed Sep 21 20:09:32 CST 2022
     */
    public String getAuctionTime() {
        return auctionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_auction_record.auction_time
     *
     * @param auctionTime the value for t_auction_record.auction_time
     * @mbggenerated Wed Sep 21 20:09:32 CST 2022
     */
    public void setAuctionTime(String auctionTime) {
        this.auctionTime = auctionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_auction_record.auction_price
     *
     * @return the value of t_auction_record.auction_price
     * @mbggenerated Wed Sep 21 20:09:32 CST 2022
     */
    public BigDecimal getAuctionPrice() {
        return auctionPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_auction_record.auction_price
     *
     * @param auctionPrice the value for t_auction_record.auction_price
     * @mbggenerated Wed Sep 21 20:09:32 CST 2022
     */
    public void setAuctionPrice(BigDecimal auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    public String getAuctionState() {
        return auctionState;
    }

    public void setAuctionState(String auctionState) {
        this.auctionState = auctionState;
    }

    @Override
    public String toString() {
        return "AuctionRecord{" +
                "id='" + id + '\'' +
                ", auctionUser=" + auctionUser +
                ", auction=" + auction +
                ", auctionTime='" + auctionTime + '\'' +
                ", auctionPrice=" + auctionPrice +
                ", auctionState='" + auctionState + '\'' +
                '}';
    }
}