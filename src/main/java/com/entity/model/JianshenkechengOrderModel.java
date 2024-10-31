package com.entity.model;

import com.entity.JianshenkechengOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 课程订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JianshenkechengOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单编号
     */
    private String jianshenkechengOrderUuidNumber;


    /**
     * 健身课程
     */
    private Integer jianshenkechengId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 预约日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jianshenkechengOrderTime;


    /**
     * 实付价格
     */
    private Double jianshenkechengOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer jianshenkechengOrderTypes;


    /**
     * 支付类型
     */
    private Integer jianshenkechengOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单编号
	 */
    public String getJianshenkechengOrderUuidNumber() {
        return jianshenkechengOrderUuidNumber;
    }


    /**
	 * 设置：订单编号
	 */
    public void setJianshenkechengOrderUuidNumber(String jianshenkechengOrderUuidNumber) {
        this.jianshenkechengOrderUuidNumber = jianshenkechengOrderUuidNumber;
    }
    /**
	 * 获取：健身课程
	 */
    public Integer getJianshenkechengId() {
        return jianshenkechengId;
    }


    /**
	 * 设置：健身课程
	 */
    public void setJianshenkechengId(Integer jianshenkechengId) {
        this.jianshenkechengId = jianshenkechengId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预约日期
	 */
    public Date getJianshenkechengOrderTime() {
        return jianshenkechengOrderTime;
    }


    /**
	 * 设置：预约日期
	 */
    public void setJianshenkechengOrderTime(Date jianshenkechengOrderTime) {
        this.jianshenkechengOrderTime = jianshenkechengOrderTime;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getJianshenkechengOrderTruePrice() {
        return jianshenkechengOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setJianshenkechengOrderTruePrice(Double jianshenkechengOrderTruePrice) {
        this.jianshenkechengOrderTruePrice = jianshenkechengOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getJianshenkechengOrderTypes() {
        return jianshenkechengOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setJianshenkechengOrderTypes(Integer jianshenkechengOrderTypes) {
        this.jianshenkechengOrderTypes = jianshenkechengOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getJianshenkechengOrderPaymentTypes() {
        return jianshenkechengOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setJianshenkechengOrderPaymentTypes(Integer jianshenkechengOrderPaymentTypes) {
        this.jianshenkechengOrderPaymentTypes = jianshenkechengOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
