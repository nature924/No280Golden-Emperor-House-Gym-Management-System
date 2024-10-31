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
 * 出入库详情
 *
 * @author 
 * @email
 */
@TableName("jianshenqichai_churu_inout_list")
public class JianshenqichaiChuruInoutListEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JianshenqichaiChuruInoutListEntity() {

	}

	public JianshenqichaiChuruInoutListEntity(T t) {
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
     * 出入库
     */
    @ColumnInfo(comment="出入库",type="int(11)")
    @TableField(value = "jianshenqichai_churu_inout_id")

    private Integer jianshenqichaiChuruInoutId;


    /**
     * 健身器材
     */
    @ColumnInfo(comment="健身器材",type="int(11)")
    @TableField(value = "jianshenqichai_id")

    private Integer jianshenqichaiId;


    /**
     * 操作数量
     */
    @ColumnInfo(comment="操作数量",type="int(11)")
    @TableField(value = "jianshenqichai_churu_inout_list_number")

    private Integer jianshenqichaiChuruInoutListNumber;


    /**
     * 操作时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="操作时间",type="timestamp")
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
	 * 获取：出入库
	 */
    public Integer getJianshenqichaiChuruInoutId() {
        return jianshenqichaiChuruInoutId;
    }
    /**
	 * 设置：出入库
	 */

    public void setJianshenqichaiChuruInoutId(Integer jianshenqichaiChuruInoutId) {
        this.jianshenqichaiChuruInoutId = jianshenqichaiChuruInoutId;
    }
    /**
	 * 获取：健身器材
	 */
    public Integer getJianshenqichaiId() {
        return jianshenqichaiId;
    }
    /**
	 * 设置：健身器材
	 */

    public void setJianshenqichaiId(Integer jianshenqichaiId) {
        this.jianshenqichaiId = jianshenqichaiId;
    }
    /**
	 * 获取：操作数量
	 */
    public Integer getJianshenqichaiChuruInoutListNumber() {
        return jianshenqichaiChuruInoutListNumber;
    }
    /**
	 * 设置：操作数量
	 */

    public void setJianshenqichaiChuruInoutListNumber(Integer jianshenqichaiChuruInoutListNumber) {
        this.jianshenqichaiChuruInoutListNumber = jianshenqichaiChuruInoutListNumber;
    }
    /**
	 * 获取：操作时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：操作时间
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
        return "JianshenqichaiChuruInoutList{" +
            ", id=" + id +
            ", jianshenqichaiChuruInoutId=" + jianshenqichaiChuruInoutId +
            ", jianshenqichaiId=" + jianshenqichaiId +
            ", jianshenqichaiChuruInoutListNumber=" + jianshenqichaiChuruInoutListNumber +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
