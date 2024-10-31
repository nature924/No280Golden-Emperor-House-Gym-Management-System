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
 * 健身器材
 *
 * @author 
 * @email
 */
@TableName("jianshenqichai")
public class JianshenqichaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JianshenqichaiEntity() {

	}

	public JianshenqichaiEntity(T t) {
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
     * 健身器材编号
     */
    @ColumnInfo(comment="健身器材编号",type="varchar(200)")
    @TableField(value = "jianshenqichai_uuid_number")

    private String jianshenqichaiUuidNumber;


    /**
     * 健身器材名称
     */
    @ColumnInfo(comment="健身器材名称",type="varchar(200)")
    @TableField(value = "jianshenqichai_name")

    private String jianshenqichaiName;


    /**
     * 健身器材类型
     */
    @ColumnInfo(comment="健身器材类型",type="int(11)")
    @TableField(value = "jianshenqichai_types")

    private Integer jianshenqichaiTypes;


    /**
     * 健身器材库存
     */
    @ColumnInfo(comment="健身器材库存",type="int(11)")
    @TableField(value = "jianshenqichai_kucun_number")

    private Integer jianshenqichaiKucunNumber;


    /**
     * 价格
     */
    @ColumnInfo(comment="价格",type="decimal(10,2)")
    @TableField(value = "jianshenqichai_new_money")

    private Double jianshenqichaiNewMoney;


    /**
     * 健身器材介绍
     */
    @ColumnInfo(comment="健身器材介绍",type="longtext")
    @TableField(value = "jianshenqichai_content")

    private String jianshenqichaiContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
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

    @Override
    public String toString() {
        return "Jianshenqichai{" +
            ", id=" + id +
            ", jianshenqichaiUuidNumber=" + jianshenqichaiUuidNumber +
            ", jianshenqichaiName=" + jianshenqichaiName +
            ", jianshenqichaiTypes=" + jianshenqichaiTypes +
            ", jianshenqichaiKucunNumber=" + jianshenqichaiKucunNumber +
            ", jianshenqichaiNewMoney=" + jianshenqichaiNewMoney +
            ", jianshenqichaiContent=" + jianshenqichaiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
