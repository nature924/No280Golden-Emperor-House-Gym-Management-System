package com.entity.model;

import com.entity.ZhuchangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 驻场人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhuchangModel implements Serializable {
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
     * 驻场人员名称
     */
    private String zhuchangName;


    /**
     * 驻场人员手机号
     */
    private String zhuchangPhone;


    /**
     * 驻场人员头像
     */
    private String zhuchangPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 驻场人员邮箱
     */
    private String zhuchangEmail;


    /**
     * 工薪
     */
    private Double zhuchangNewMoney;


    /**
     * 驻场人员简介
     */
    private String zhuchangContent;


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
	 * 获取：驻场人员名称
	 */
    public String getZhuchangName() {
        return zhuchangName;
    }


    /**
	 * 设置：驻场人员名称
	 */
    public void setZhuchangName(String zhuchangName) {
        this.zhuchangName = zhuchangName;
    }
    /**
	 * 获取：驻场人员手机号
	 */
    public String getZhuchangPhone() {
        return zhuchangPhone;
    }


    /**
	 * 设置：驻场人员手机号
	 */
    public void setZhuchangPhone(String zhuchangPhone) {
        this.zhuchangPhone = zhuchangPhone;
    }
    /**
	 * 获取：驻场人员头像
	 */
    public String getZhuchangPhoto() {
        return zhuchangPhoto;
    }


    /**
	 * 设置：驻场人员头像
	 */
    public void setZhuchangPhoto(String zhuchangPhoto) {
        this.zhuchangPhoto = zhuchangPhoto;
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
	 * 获取：驻场人员邮箱
	 */
    public String getZhuchangEmail() {
        return zhuchangEmail;
    }


    /**
	 * 设置：驻场人员邮箱
	 */
    public void setZhuchangEmail(String zhuchangEmail) {
        this.zhuchangEmail = zhuchangEmail;
    }
    /**
	 * 获取：工薪
	 */
    public Double getZhuchangNewMoney() {
        return zhuchangNewMoney;
    }


    /**
	 * 设置：工薪
	 */
    public void setZhuchangNewMoney(Double zhuchangNewMoney) {
        this.zhuchangNewMoney = zhuchangNewMoney;
    }
    /**
	 * 获取：驻场人员简介
	 */
    public String getZhuchangContent() {
        return zhuchangContent;
    }


    /**
	 * 设置：驻场人员简介
	 */
    public void setZhuchangContent(String zhuchangContent) {
        this.zhuchangContent = zhuchangContent;
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
