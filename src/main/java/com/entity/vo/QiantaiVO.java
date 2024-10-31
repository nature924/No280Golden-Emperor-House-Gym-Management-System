package com.entity.vo;

import com.entity.QiantaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 前台
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("qiantai")
public class QiantaiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 前台名称
     */

    @TableField(value = "qiantai_name")
    private String qiantaiName;


    /**
     * 前台手机号
     */

    @TableField(value = "qiantai_phone")
    private String qiantaiPhone;


    /**
     * 前台头像
     */

    @TableField(value = "qiantai_photo")
    private String qiantaiPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 前台邮箱
     */

    @TableField(value = "qiantai_email")
    private String qiantaiEmail;


    /**
     * 工薪
     */

    @TableField(value = "qiantai_new_money")
    private Double qiantaiNewMoney;


    /**
     * 前台简介
     */

    @TableField(value = "qiantai_content")
    private String qiantaiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "data_delete")
    private Integer dataDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：前台名称
	 */
    public String getQiantaiName() {
        return qiantaiName;
    }


    /**
	 * 获取：前台名称
	 */

    public void setQiantaiName(String qiantaiName) {
        this.qiantaiName = qiantaiName;
    }
    /**
	 * 设置：前台手机号
	 */
    public String getQiantaiPhone() {
        return qiantaiPhone;
    }


    /**
	 * 获取：前台手机号
	 */

    public void setQiantaiPhone(String qiantaiPhone) {
        this.qiantaiPhone = qiantaiPhone;
    }
    /**
	 * 设置：前台头像
	 */
    public String getQiantaiPhoto() {
        return qiantaiPhoto;
    }


    /**
	 * 获取：前台头像
	 */

    public void setQiantaiPhoto(String qiantaiPhoto) {
        this.qiantaiPhoto = qiantaiPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：前台邮箱
	 */
    public String getQiantaiEmail() {
        return qiantaiEmail;
    }


    /**
	 * 获取：前台邮箱
	 */

    public void setQiantaiEmail(String qiantaiEmail) {
        this.qiantaiEmail = qiantaiEmail;
    }
    /**
	 * 设置：工薪
	 */
    public Double getQiantaiNewMoney() {
        return qiantaiNewMoney;
    }


    /**
	 * 获取：工薪
	 */

    public void setQiantaiNewMoney(Double qiantaiNewMoney) {
        this.qiantaiNewMoney = qiantaiNewMoney;
    }
    /**
	 * 设置：前台简介
	 */
    public String getQiantaiContent() {
        return qiantaiContent;
    }


    /**
	 * 获取：前台简介
	 */

    public void setQiantaiContent(String qiantaiContent) {
        this.qiantaiContent = qiantaiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getDataDelete() {
        return dataDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setDataDelete(Integer dataDelete) {
        this.dataDelete = dataDelete;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
