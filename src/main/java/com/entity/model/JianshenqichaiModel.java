package com.entity.model;

import com.entity.JianshenqichaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 健身器材
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JianshenqichaiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 健身器材编号
     */
    private String jianshenqichaiUuidNumber;


    /**
     * 健身器材名称
     */
    private String jianshenqichaiName;


    /**
     * 健身器材类型
     */
    private Integer jianshenqichaiTypes;


    /**
     * 健身器材库存
     */
    private Integer jianshenqichaiKucunNumber;


    /**
     * 价格
     */
    private Double jianshenqichaiNewMoney;


    /**
     * 健身器材介绍
     */
    private String jianshenqichaiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：健身器材编号
	 */
    public String getJianshenqichaiUuidNumber() {
        return jianshenqichaiUuidNumber;
    }


    /**
	 * 设置：健身器材编号
	 */
    public void setJianshenqichaiUuidNumber(String jianshenqichaiUuidNumber) {
        this.jianshenqichaiUuidNumber = jianshenqichaiUuidNumber;
    }
    /**
	 * 获取：健身器材名称
	 */
    public String getJianshenqichaiName() {
        return jianshenqichaiName;
    }


    /**
	 * 设置：健身器材名称
	 */
    public void setJianshenqichaiName(String jianshenqichaiName) {
        this.jianshenqichaiName = jianshenqichaiName;
    }
    /**
	 * 获取：健身器材类型
	 */
    public Integer getJianshenqichaiTypes() {
        return jianshenqichaiTypes;
    }


    /**
	 * 设置：健身器材类型
	 */
    public void setJianshenqichaiTypes(Integer jianshenqichaiTypes) {
        this.jianshenqichaiTypes = jianshenqichaiTypes;
    }
    /**
	 * 获取：健身器材库存
	 */
    public Integer getJianshenqichaiKucunNumber() {
        return jianshenqichaiKucunNumber;
    }


    /**
	 * 设置：健身器材库存
	 */
    public void setJianshenqichaiKucunNumber(Integer jianshenqichaiKucunNumber) {
        this.jianshenqichaiKucunNumber = jianshenqichaiKucunNumber;
    }
    /**
	 * 获取：价格
	 */
    public Double getJianshenqichaiNewMoney() {
        return jianshenqichaiNewMoney;
    }


    /**
	 * 设置：价格
	 */
    public void setJianshenqichaiNewMoney(Double jianshenqichaiNewMoney) {
        this.jianshenqichaiNewMoney = jianshenqichaiNewMoney;
    }
    /**
	 * 获取：健身器材介绍
	 */
    public String getJianshenqichaiContent() {
        return jianshenqichaiContent;
    }


    /**
	 * 设置：健身器材介绍
	 */
    public void setJianshenqichaiContent(String jianshenqichaiContent) {
        this.jianshenqichaiContent = jianshenqichaiContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
