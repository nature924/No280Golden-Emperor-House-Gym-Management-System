package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 前台
 *
 * @author 
 * @email
 */
@TableName("qiantai")
public class QiantaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QiantaiEntity() {

	}

	public QiantaiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 前台名称
     */
    @ColumnInfo(comment="前台名称",type="varchar(200)")
    @TableField(value = "qiantai_name")

    private String qiantaiName;


    /**
     * 前台手机号
     */
    @ColumnInfo(comment="前台手机号",type="varchar(200)")
    @TableField(value = "qiantai_phone")

    private String qiantaiPhone;


    /**
     * 前台头像
     */
    @ColumnInfo(comment="前台头像",type="varchar(200)")
    @TableField(value = "qiantai_photo")

    private String qiantaiPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 前台邮箱
     */
    @ColumnInfo(comment="前台邮箱",type="varchar(200)")
    @TableField(value = "qiantai_email")

    private String qiantaiEmail;


    /**
     * 工薪
     */
    @ColumnInfo(comment="工薪",type="decimal(10,2)")
    @TableField(value = "qiantai_new_money")

    private Double qiantaiNewMoney;


    /**
     * 前台简介
     */
    @ColumnInfo(comment="前台简介",type="longtext")
    @TableField(value = "qiantai_content")

    private String qiantaiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "data_delete")

    private Integer dataDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Qiantai{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", qiantaiName=" + qiantaiName +
            ", qiantaiPhone=" + qiantaiPhone +
            ", qiantaiPhoto=" + qiantaiPhoto +
            ", sexTypes=" + sexTypes +
            ", qiantaiEmail=" + qiantaiEmail +
            ", qiantaiNewMoney=" + qiantaiNewMoney +
            ", qiantaiContent=" + qiantaiContent +
            ", dataDelete=" + dataDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
