package com.entity.model;

import com.entity.JiaolianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 教练
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiaolianModel implements Serializable {
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
     * 教练名称
     */
    private String jiaolianName;


    /**
     * 教练手机号
     */
    private String jiaolianPhone;


    /**
     * 教练头像
     */
    private String jiaolianPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 教练邮箱
     */
    private String jiaolianEmail;


    /**
     * 工薪
     */
    private Double jiaolianNewMoney;


    /**
     * 教练简介
     */
    private String jiaolianContent;


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
	 * 获取：教练名称
	 */
    public String getJiaolianName() {
        return jiaolianName;
    }


    /**
	 * 设置：教练名称
	 */
    public void setJiaolianName(String jiaolianName) {
        this.jiaolianName = jiaolianName;
    }
    /**
	 * 获取：教练手机号
	 */
    public String getJiaolianPhone() {
        return jiaolianPhone;
    }


    /**
	 * 设置：教练手机号
	 */
    public void setJiaolianPhone(String jiaolianPhone) {
        this.jiaolianPhone = jiaolianPhone;
    }
    /**
	 * 获取：教练头像
	 */
    public String getJiaolianPhoto() {
        return jiaolianPhoto;
    }


    /**
	 * 设置：教练头像
	 */
    public void setJiaolianPhoto(String jiaolianPhoto) {
        this.jiaolianPhoto = jiaolianPhoto;
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
	 * 获取：教练邮箱
	 */
    public String getJiaolianEmail() {
        return jiaolianEmail;
    }


    /**
	 * 设置：教练邮箱
	 */
    public void setJiaolianEmail(String jiaolianEmail) {
        this.jiaolianEmail = jiaolianEmail;
    }
    /**
	 * 获取：工薪
	 */
    public Double getJiaolianNewMoney() {
        return jiaolianNewMoney;
    }


    /**
	 * 设置：工薪
	 */
    public void setJiaolianNewMoney(Double jiaolianNewMoney) {
        this.jiaolianNewMoney = jiaolianNewMoney;
    }
    /**
	 * 获取：教练简介
	 */
    public String getJiaolianContent() {
        return jiaolianContent;
    }


    /**
	 * 设置：教练简介
	 */
    public void setJiaolianContent(String jiaolianContent) {
        this.jiaolianContent = jiaolianContent;
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
