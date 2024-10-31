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
 * 店长
 *
 * @author 
 * @email
 */
@TableName("dianzhang")
public class DianzhangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DianzhangEntity() {

	}

	public DianzhangEntity(T t) {
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
     * 店长名称
     */
    @ColumnInfo(comment="店长名称",type="varchar(200)")
    @TableField(value = "dianzhang_name")

    private String dianzhangName;


    /**
     * 店长手机号
     */
    @ColumnInfo(comment="店长手机号",type="varchar(200)")
    @TableField(value = "dianzhang_phone")

    private String dianzhangPhone;


    /**
     * 店长头像
     */
    @ColumnInfo(comment="店长头像",type="varchar(200)")
    @TableField(value = "dianzhang_photo")

    private String dianzhangPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 店长邮箱
     */
    @ColumnInfo(comment="店长邮箱",type="varchar(200)")
    @TableField(value = "dianzhang_email")

    private String dianzhangEmail;


    /**
     * 店长简介
     */
    @ColumnInfo(comment="店长简介",type="longtext")
    @TableField(value = "dianzhang_content")

    private String dianzhangContent;


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
	 * 获取：店长名称
	 */
    public String getDianzhangName() {
        return dianzhangName;
    }
    /**
	 * 设置：店长名称
	 */

    public void setDianzhangName(String dianzhangName) {
        this.dianzhangName = dianzhangName;
    }
    /**
	 * 获取：店长手机号
	 */
    public String getDianzhangPhone() {
        return dianzhangPhone;
    }
    /**
	 * 设置：店长手机号
	 */

    public void setDianzhangPhone(String dianzhangPhone) {
        this.dianzhangPhone = dianzhangPhone;
    }
    /**
	 * 获取：店长头像
	 */
    public String getDianzhangPhoto() {
        return dianzhangPhoto;
    }
    /**
	 * 设置：店长头像
	 */

    public void setDianzhangPhoto(String dianzhangPhoto) {
        this.dianzhangPhoto = dianzhangPhoto;
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
	 * 获取：店长邮箱
	 */
    public String getDianzhangEmail() {
        return dianzhangEmail;
    }
    /**
	 * 设置：店长邮箱
	 */

    public void setDianzhangEmail(String dianzhangEmail) {
        this.dianzhangEmail = dianzhangEmail;
    }
    /**
	 * 获取：店长简介
	 */
    public String getDianzhangContent() {
        return dianzhangContent;
    }
    /**
	 * 设置：店长简介
	 */

    public void setDianzhangContent(String dianzhangContent) {
        this.dianzhangContent = dianzhangContent;
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
        return "Dianzhang{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", dianzhangName=" + dianzhangName +
            ", dianzhangPhone=" + dianzhangPhone +
            ", dianzhangPhoto=" + dianzhangPhoto +
            ", sexTypes=" + sexTypes +
            ", dianzhangEmail=" + dianzhangEmail +
            ", dianzhangContent=" + dianzhangContent +
            ", dataDelete=" + dataDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
