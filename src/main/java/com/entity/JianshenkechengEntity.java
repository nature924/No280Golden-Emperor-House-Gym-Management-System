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
 * 健身课程
 *
 * @author 
 * @email
 */
@TableName("jianshenkecheng")
public class JianshenkechengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JianshenkechengEntity() {

	}

	public JianshenkechengEntity(T t) {
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
     * 教练
     */
    @ColumnInfo(comment="教练",type="int(11)")
    @TableField(value = "jiaolian_id")

    private Integer jiaolianId;


    /**
     * 健身课程名称
     */
    @ColumnInfo(comment="健身课程名称",type="varchar(200)")
    @TableField(value = "jianshenkecheng_name")

    private String jianshenkechengName;


    /**
     * 健身课程照片
     */
    @ColumnInfo(comment="健身课程照片",type="varchar(200)")
    @TableField(value = "jianshenkecheng_photo")

    private String jianshenkechengPhoto;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 健身课程类型
     */
    @ColumnInfo(comment="健身课程类型",type="int(11)")
    @TableField(value = "jianshenkecheng_types")

    private Integer jianshenkechengTypes;


    /**
     * 健身课程热度
     */
    @ColumnInfo(comment="健身课程热度",type="int(11)")
    @TableField(value = "jianshenkecheng_clicknum")

    private Integer jianshenkechengClicknum;


    /**
     * 课程价格
     */
    @ColumnInfo(comment="课程价格",type="decimal(10,2)")
    @TableField(value = "jianshenkecheng_new_money")

    private Double jianshenkechengNewMoney;


    /**
     * 健身课程介绍
     */
    @ColumnInfo(comment="健身课程介绍",type="longtext")
    @TableField(value = "jianshenkecheng_content")

    private String jianshenkechengContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "data_delete")

    private Integer dataDelete;


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
	 * 获取：教练
	 */
    public Integer getJiaolianId() {
        return jiaolianId;
    }
    /**
	 * 设置：教练
	 */

    public void setJiaolianId(Integer jiaolianId) {
        this.jiaolianId = jiaolianId;
    }
    /**
	 * 获取：健身课程名称
	 */
    public String getJianshenkechengName() {
        return jianshenkechengName;
    }
    /**
	 * 设置：健身课程名称
	 */

    public void setJianshenkechengName(String jianshenkechengName) {
        this.jianshenkechengName = jianshenkechengName;
    }
    /**
	 * 获取：健身课程照片
	 */
    public String getJianshenkechengPhoto() {
        return jianshenkechengPhoto;
    }
    /**
	 * 设置：健身课程照片
	 */

    public void setJianshenkechengPhoto(String jianshenkechengPhoto) {
        this.jianshenkechengPhoto = jianshenkechengPhoto;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：健身课程类型
	 */
    public Integer getJianshenkechengTypes() {
        return jianshenkechengTypes;
    }
    /**
	 * 设置：健身课程类型
	 */

    public void setJianshenkechengTypes(Integer jianshenkechengTypes) {
        this.jianshenkechengTypes = jianshenkechengTypes;
    }
    /**
	 * 获取：健身课程热度
	 */
    public Integer getJianshenkechengClicknum() {
        return jianshenkechengClicknum;
    }
    /**
	 * 设置：健身课程热度
	 */

    public void setJianshenkechengClicknum(Integer jianshenkechengClicknum) {
        this.jianshenkechengClicknum = jianshenkechengClicknum;
    }
    /**
	 * 获取：课程价格
	 */
    public Double getJianshenkechengNewMoney() {
        return jianshenkechengNewMoney;
    }
    /**
	 * 设置：课程价格
	 */

    public void setJianshenkechengNewMoney(Double jianshenkechengNewMoney) {
        this.jianshenkechengNewMoney = jianshenkechengNewMoney;
    }
    /**
	 * 获取：健身课程介绍
	 */
    public String getJianshenkechengContent() {
        return jianshenkechengContent;
    }
    /**
	 * 设置：健身课程介绍
	 */

    public void setJianshenkechengContent(String jianshenkechengContent) {
        this.jianshenkechengContent = jianshenkechengContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
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
        return "Jianshenkecheng{" +
            ", id=" + id +
            ", jiaolianId=" + jiaolianId +
            ", jianshenkechengName=" + jianshenkechengName +
            ", jianshenkechengPhoto=" + jianshenkechengPhoto +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", jianshenkechengTypes=" + jianshenkechengTypes +
            ", jianshenkechengClicknum=" + jianshenkechengClicknum +
            ", jianshenkechengNewMoney=" + jianshenkechengNewMoney +
            ", jianshenkechengContent=" + jianshenkechengContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", dataDelete=" + dataDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
