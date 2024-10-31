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
 * 资费
 *
 * @author 
 * @email
 */
@TableName("zifei")
public class ZifeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZifeiEntity() {

	}

	public ZifeiEntity(T t) {
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
     * 资费编号
     */
    @ColumnInfo(comment="资费编号",type="varchar(200)")
    @TableField(value = "zifei_uuid_number")

    private String zifeiUuidNumber;


    /**
     * 资费名称
     */
    @ColumnInfo(comment="资费名称",type="varchar(200)")
    @TableField(value = "zifei_name")

    private String zifeiName;


    /**
     * 资费类型
     */
    @ColumnInfo(comment="资费类型",type="int(11)")
    @TableField(value = "zifei_types")

    private Integer zifeiTypes;


    /**
     * 金额
     */
    @ColumnInfo(comment="金额",type="decimal(10,2)")
    @TableField(value = "zifei_new_money")

    private Double zifeiNewMoney;


    /**
     * 前台
     */
    @ColumnInfo(comment="前台",type="int(11)")
    @TableField(value = "qiantai_id")

    private Integer qiantaiId;


    /**
     * 资费详情
     */
    @ColumnInfo(comment="资费详情",type="longtext")
    @TableField(value = "zifei_content")

    private String zifeiContent;


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

    @Override
    public String toString() {
        return "Zifei{" +
            ", id=" + id +
            ", zifeiUuidNumber=" + zifeiUuidNumber +
            ", zifeiName=" + zifeiName +
            ", zifeiTypes=" + zifeiTypes +
            ", zifeiNewMoney=" + zifeiNewMoney +
            ", qiantaiId=" + qiantaiId +
            ", zifeiContent=" + zifeiContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
