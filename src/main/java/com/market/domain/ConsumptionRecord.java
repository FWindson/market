package com.market.domain;

import java.util.Date;

public class ConsumptionRecord {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column consumption_record.id
     *
     * @mbg.generated Sat Mar 25 19:15:36 CST 2017
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column consumption_record.shopping_ticket_id
     *
     * @mbg.generated Sat Mar 25 19:15:36 CST 2017
     */
    private String shoppingTicketId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column consumption_record.handle_by
     *
     * @mbg.generated Sat Mar 25 19:15:36 CST 2017
     */
    private String handleBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column consumption_record.create_time
     *
     * @mbg.generated Sat Mar 25 19:15:36 CST 2017
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column consumption_record.is_deleted
     *
     * @mbg.generated Sat Mar 25 19:15:36 CST 2017
     */
    private Boolean isDeleted;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column consumption_record.id
     *
     * @return the value of consumption_record.id
     *
     * @mbg.generated Sat Mar 25 19:15:36 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column consumption_record.id
     *
     * @param id the value for consumption_record.id
     *
     * @mbg.generated Sat Mar 25 19:15:36 CST 2017
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column consumption_record.shopping_ticket_id
     *
     * @return the value of consumption_record.shopping_ticket_id
     *
     * @mbg.generated Sat Mar 25 19:15:36 CST 2017
     */
    public String getShoppingTicketId() {
        return shoppingTicketId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column consumption_record.shopping_ticket_id
     *
     * @param shoppingTicketId the value for consumption_record.shopping_ticket_id
     *
     * @mbg.generated Sat Mar 25 19:15:36 CST 2017
     */
    public void setShoppingTicketId(String shoppingTicketId) {
        this.shoppingTicketId = shoppingTicketId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column consumption_record.handle_by
     *
     * @return the value of consumption_record.handle_by
     *
     * @mbg.generated Sat Mar 25 19:15:36 CST 2017
     */
    public String getHandleBy() {
        return handleBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column consumption_record.handle_by
     *
     * @param handleBy the value for consumption_record.handle_by
     *
     * @mbg.generated Sat Mar 25 19:15:36 CST 2017
     */
    public void setHandleBy(String handleBy) {
        this.handleBy = handleBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column consumption_record.create_time
     *
     * @return the value of consumption_record.create_time
     *
     * @mbg.generated Sat Mar 25 19:15:36 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column consumption_record.create_time
     *
     * @param createTime the value for consumption_record.create_time
     *
     * @mbg.generated Sat Mar 25 19:15:36 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column consumption_record.is_deleted
     *
     * @return the value of consumption_record.is_deleted
     *
     * @mbg.generated Sat Mar 25 19:15:36 CST 2017
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column consumption_record.is_deleted
     *
     * @param isDeleted the value for consumption_record.is_deleted
     *
     * @mbg.generated Sat Mar 25 19:15:36 CST 2017
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}