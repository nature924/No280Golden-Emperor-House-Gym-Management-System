package com.entity.vo;

import com.entity.JianshenkechengOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 课程订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jianshenkecheng_order")
public class JianshenkechengOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "jianshenkecheng_order_uuid_number")
    private String jianshenkechengOrderUuidNumber;


    /**
     * 健身课程
     */

    @TableField(value = "jianshenkecheng_id")
    private Integer jianshenkechengId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 预约日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jianshenkecheng_order_time")
    private Date jianshenkechengOrderTime;


    /**
     * 实付价格
     */

    @TableField(value = "jianshenkecheng_order_true_price")
    private Double jianshenkechengOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "jianshenkecheng_order_types")
    private Integer jianshenkechengOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "jianshenkecheng_order_payment_types")
    private Integer jianshenkechengOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单编号
	 */
    public String getJianshenkechengOrderUuidNumber() {
        return jianshenkechengOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setJianshenkechengOrderUuidNumber(String jianshenkechengOrderUuidNumber) {
        this.jianshenkechengOrderUuidNumber = jianshenkechengOrderUuidNumber;
    }
    /**
	 * 设置：健身课程
	 */
    public Integer getJianshenkechengId() {
        return jianshenkechengId;
    }


    /**
	 * 获取：健身课程
	 */

    public void setJianshenkechengId(Integer jianshenkechengId) {
        this.jianshenkechengId = jianshenkechengId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：预约日期
	 */
    public Date getJianshenkechengOrderTime() {
        return jianshenkechengOrderTime;
    }


    /**
	 * 获取：预约日期
	 */

    public void setJianshenkechengOrderTime(Date jianshenkechengOrderTime) {
        this.jianshenkechengOrderTime = jianshenkechengOrderTime;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getJianshenkechengOrderTruePrice() {
        return jianshenkechengOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setJianshenkechengOrderTruePrice(Double jianshenkechengOrderTruePrice) {
        this.jianshenkechengOrderTruePrice = jianshenkechengOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getJianshenkechengOrderTypes() {
        return jianshenkechengOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setJianshenkechengOrderTypes(Integer jianshenkechengOrderTypes) {
        this.jianshenkechengOrderTypes = jianshenkechengOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getJianshenkechengOrderPaymentTypes() {
        return jianshenkechengOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setJianshenkechengOrderPaymentTypes(Integer jianshenkechengOrderPaymentTypes) {
        this.jianshenkechengOrderPaymentTypes = jianshenkechengOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
