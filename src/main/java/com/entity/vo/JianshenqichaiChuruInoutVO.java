package com.entity.vo;

import com.entity.JianshenqichaiChuruInoutEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 出入库
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jianshenqichai_churu_inout")
public class JianshenqichaiChuruInoutVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 出入库流水号
     */

    @TableField(value = "jianshenqichai_churu_inout_uuid_number")
    private String jianshenqichaiChuruInoutUuidNumber;


    /**
     * 出入库名称
     */

    @TableField(value = "jianshenqichai_churu_inout_name")
    private String jianshenqichaiChuruInoutName;


    /**
     * 出入库类型
     */

    @TableField(value = "jianshenqichai_churu_inout_types")
    private Integer jianshenqichaiChuruInoutTypes;


    /**
     * 备注
     */

    @TableField(value = "jianshenqichai_churu_inout_content")
    private String jianshenqichaiChuruInoutContent;


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
	 * 设置：出入库流水号
	 */
    public String getJianshenqichaiChuruInoutUuidNumber() {
        return jianshenqichaiChuruInoutUuidNumber;
    }


    /**
	 * 获取：出入库流水号
	 */

    public void setJianshenqichaiChuruInoutUuidNumber(String jianshenqichaiChuruInoutUuidNumber) {
        this.jianshenqichaiChuruInoutUuidNumber = jianshenqichaiChuruInoutUuidNumber;
    }
    /**
	 * 设置：出入库名称
	 */
    public String getJianshenqichaiChuruInoutName() {
        return jianshenqichaiChuruInoutName;
    }


    /**
	 * 获取：出入库名称
	 */

    public void setJianshenqichaiChuruInoutName(String jianshenqichaiChuruInoutName) {
        this.jianshenqichaiChuruInoutName = jianshenqichaiChuruInoutName;
    }
    /**
	 * 设置：出入库类型
	 */
    public Integer getJianshenqichaiChuruInoutTypes() {
        return jianshenqichaiChuruInoutTypes;
    }


    /**
	 * 获取：出入库类型
	 */

    public void setJianshenqichaiChuruInoutTypes(Integer jianshenqichaiChuruInoutTypes) {
        this.jianshenqichaiChuruInoutTypes = jianshenqichaiChuruInoutTypes;
    }
    /**
	 * 设置：备注
	 */
    public String getJianshenqichaiChuruInoutContent() {
        return jianshenqichaiChuruInoutContent;
    }


    /**
	 * 获取：备注
	 */

    public void setJianshenqichaiChuruInoutContent(String jianshenqichaiChuruInoutContent) {
        this.jianshenqichaiChuruInoutContent = jianshenqichaiChuruInoutContent;
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
