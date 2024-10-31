package com.entity.model;

import com.entity.QiantaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 前台
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QiantaiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 前台名称
     */
    private String qiantaiName;


    /**
     * 前台手机号
     */
    private String qiantaiPhone;


    /**
     * 前台头像
     */
    private String qiantaiPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 前台邮箱
     */
    private String qiantaiEmail;


    /**
     * 工薪
     */
    private Double qiantaiNewMoney;


    /**
     * 前台简介
     */
    private String qiantaiContent;


    /**
     * 逻辑删除
     */
    private Integer dataDelete;


    /**
     * 添加时间
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：前台名称
	 */
    public String getQiantaiName() {
        return qiantaiName;
    }


    /**
	 * 设置：前台名称
	 */
    public void setQiantaiName(String qiantaiName) {
        this.qiantaiName = qiantaiName;
    }
    /**
	 * 获取：前台手机号
	 */
    public String getQiantaiPhone() {
        return qiantaiPhone;
    }


    /**
	 * 设置：前台手机号
	 */
    public void setQiantaiPhone(String qiantaiPhone) {
        this.qiantaiPhone = qiantaiPhone;
    }
    /**
	 * 获取：前台头像
	 */
    public String getQiantaiPhoto() {
        return qiantaiPhoto;
    }


    /**
	 * 设置：前台头像
	 */
    public void setQiantaiPhoto(String qiantaiPhoto) {
        this.qiantaiPhoto = qiantaiPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：前台邮箱
	 */
    public String getQiantaiEmail() {
        return qiantaiEmail;
    }


    /**
	 * 设置：前台邮箱
	 */
    public void setQiantaiEmail(String qiantaiEmail) {
        this.qiantaiEmail = qiantaiEmail;
    }
    /**
	 * 获取：工薪
	 */
    public Double getQiantaiNewMoney() {
        return qiantaiNewMoney;
    }


    /**
	 * 设置：工薪
	 */
    public void setQiantaiNewMoney(Double qiantaiNewMoney) {
        this.qiantaiNewMoney = qiantaiNewMoney;
    }
    /**
	 * 获取：前台简介
	 */
    public String getQiantaiContent() {
        return qiantaiContent;
    }


    /**
	 * 设置：前台简介
	 */
    public void setQiantaiContent(String qiantaiContent) {
        this.qiantaiContent = qiantaiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getDataDelete() {
        return dataDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setDataDelete(Integer dataDelete) {
        this.dataDelete = dataDelete;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
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
