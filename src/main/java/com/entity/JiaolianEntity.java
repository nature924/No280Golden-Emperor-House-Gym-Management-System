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
 * 教练
 *
 * @author 
 * @email
 */
@TableName("jiaolian")
public class JiaolianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaolianEntity() {

	}

	public JiaolianEntity(T t) {
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
     * 教练名称
     */
    @ColumnInfo(comment="教练名称",type="varchar(200)")
    @TableField(value = "jiaolian_name")

    private String jiaolianName;


    /**
     * 教练手机号
     */
    @ColumnInfo(comment="教练手机号",type="varchar(200)")
    @TableField(value = "jiaolian_phone")

    private String jiaolianPhone;


    /**
     * 教练头像
     */
    @ColumnInfo(comment="教练头像",type="varchar(200)")
    @TableField(value = "jiaolian_photo")

    private String jiaolianPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 教练邮箱
     */
    @ColumnInfo(comment="教练邮箱",type="varchar(200)")
    @TableField(value = "jiaolian_email")

    private String jiaolianEmail;


    /**
     * 工薪
     */
    @ColumnInfo(comment="工薪",type="decimal(10,2)")
    @TableField(value = "jiaolian_new_money")

    private Double jiaolianNewMoney;


    /**
     * 教练简介
     */
    @ColumnInfo(comment="教练简介",type="longtext")
    @TableField(value = "jiaolian_content")

    private String jiaolianContent;


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

    @Override
    public String toString() {
        return "Jiaolian{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", jiaolianName=" + jiaolianName +
            ", jiaolianPhone=" + jiaolianPhone +
            ", jiaolianPhoto=" + jiaolianPhoto +
            ", sexTypes=" + sexTypes +
            ", jiaolianEmail=" + jiaolianEmail +
            ", jiaolianNewMoney=" + jiaolianNewMoney +
            ", jiaolianContent=" + jiaolianContent +
            ", dataDelete=" + dataDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
