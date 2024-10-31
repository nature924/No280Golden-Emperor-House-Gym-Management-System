package com.entity.vo;

import com.entity.JianshenqichaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 健身器材
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jianshenqichai")
public class JianshenqichaiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 健身器材编号
     */

    @TableField(value = "jianshenqichai_uuid_number")
    private String jianshenqichaiUuidNumber;


    /**
     * 健身器材名称
     */

    @TableField(value = "jianshenqichai_name")
    private String jianshenqichaiName;


    /**
     * 健身器材类型
     */

    @TableField(value = "jianshenqichai_types")
    private Integer jianshenqichaiTypes;


    /**
     * 健身器材库存
     */

    @TableField(value = "jianshenqichai_kucun_number")
    private Integer jianshenqichaiKucunNumber;


    /**
     * 价格
     */

    @TableField(value = "jianshenqichai_new_money")
    private Double jianshenqichaiNewMoney;


    /**
     * 健身器材介绍
     */

    @TableField(value = "jianshenqichai_content")
    private String jianshenqichaiContent;


    /**
     * 录入时间
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
	 * 设置：健身器材编号
	 */
    public String getJianshenqichaiUuidNumber() {
        return jianshenqichaiUuidNumber;
    }


    /**
	 * 获取：健身器材编号
	 */

    public void setJianshenqichaiUuidNumber(String jianshenqichaiUuidNumber) {
        this.jianshenqichaiUuidNumber = jianshenqichaiUuidNumber;
    }
    /**
	 * 设置：健身器材名称
	 */
    public String getJianshenqichaiName() {
        return jianshenqichaiName;
    }


    /**
	 * 获取：健身器材名称
	 */

    public void setJianshenqichaiName(String jianshenqichaiName) {
        this.jianshenqichaiName = jianshenqichaiName;
    }
    /**
	 * 设置：健身器材类型
	 */
    public Integer getJianshenqichaiTypes() {
        return jianshenqichaiTypes;
    }


    /**
	 * 获取：健身器材类型
	 */

    public void setJianshenqichaiTypes(Integer jianshenqichaiTypes) {
        this.jianshenqichaiTypes = jianshenqichaiTypes;
    }
    /**
	 * 设置：健身器材库存
	 */
    public Integer getJianshenqichaiKucunNumber() {
        return jianshenqichaiKucunNumber;
    }


    /**
	 * 获取：健身器材库存
	 */

    public void setJianshenqichaiKucunNumber(Integer jianshenqichaiKucunNumber) {
        this.jianshenqichaiKucunNumber = jianshenqichaiKucunNumber;
    }
    /**
	 * 设置：价格
	 */
    public Double getJianshenqichaiNewMoney() {
        return jianshenqichaiNewMoney;
    }


    /**
	 * 获取：价格
	 */

    public void setJianshenqichaiNewMoney(Double jianshenqichaiNewMoney) {
        this.jianshenqichaiNewMoney = jianshenqichaiNewMoney;
    }
    /**
	 * 设置：健身器材介绍
	 */
    public String getJianshenqichaiContent() {
        return jianshenqichaiContent;
    }


    /**
	 * 获取：健身器材介绍
	 */

    public void setJianshenqichaiContent(String jianshenqichaiContent) {
        this.jianshenqichaiContent = jianshenqichaiContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
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
