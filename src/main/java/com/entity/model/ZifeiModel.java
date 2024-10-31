package com.entity.model;

import com.entity.ZifeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 资费
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZifeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 资费编号
     */
    private String zifeiUuidNumber;


    /**
     * 资费名称
     */
    private String zifeiName;


    /**
     * 资费类型
     */
    private Integer zifeiTypes;


    /**
     * 金额
     */
    private Double zifeiNewMoney;


    /**
     * 前台
     */
    private Integer qiantaiId;


    /**
     * 资费详情
     */
    private String zifeiContent;


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
	 * 获取：资费编号
	 */
    public String getZifeiUuidNumber() {
        return zifeiUuidNumber;
    }


    /**
	 * 设置：资费编号
	 */
    public void setZifeiUuidNumber(String zifeiUuidNumber) {
        this.zifeiUuidNumber = zifeiUuidNumber;
    }
    /**
	 * 获取：资费名称
	 */
    public String getZifeiName() {
        return zifeiName;
    }


    /**
	 * 设置：资费名称
	 */
    public void setZifeiName(String zifeiName) {
        this.zifeiName = zifeiName;
    }
    /**
	 * 获取：资费类型
	 */
    public Integer getZifeiTypes() {
        return zifeiTypes;
    }


    /**
	 * 设置：资费类型
	 */
    public void setZifeiTypes(Integer zifeiTypes) {
        this.zifeiTypes = zifeiTypes;
    }
    /**
	 * 获取：金额
	 */
    public Double getZifeiNewMoney() {
        return zifeiNewMoney;
    }


    /**
	 * 设置：金额
	 */
    public void setZifeiNewMoney(Double zifeiNewMoney) {
        this.zifeiNewMoney = zifeiNewMoney;
    }
    /**
	 * 获取：前台
	 */
    public Integer getQiantaiId() {
        return qiantaiId;
    }


    /**
	 * 设置：前台
	 */
    public void setQiantaiId(Integer qiantaiId) {
        this.qiantaiId = qiantaiId;
    }
    /**
	 * 获取：资费详情
	 */
    public String getZifeiContent() {
        return zifeiContent;
    }


    /**
	 * 设置：资费详情
	 */
    public void setZifeiContent(String zifeiContent) {
        this.zifeiContent = zifeiContent;
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
