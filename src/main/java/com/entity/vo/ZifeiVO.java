package com.entity.vo;

import com.entity.ZifeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 资费
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zifei")
public class ZifeiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 资费编号
     */

    @TableField(value = "zifei_uuid_number")
    private String zifeiUuidNumber;


    /**
     * 资费名称
     */

    @TableField(value = "zifei_name")
    private String zifeiName;


    /**
     * 资费类型
     */

    @TableField(value = "zifei_types")
    private Integer zifeiTypes;


    /**
     * 金额
     */

    @TableField(value = "zifei_new_money")
    private Double zifeiNewMoney;


    /**
     * 前台
     */

    @TableField(value = "qiantai_id")
    private Integer qiantaiId;


    /**
     * 资费详情
     */

    @TableField(value = "zifei_content")
    private String zifeiContent;


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
	 * 设置：资费编号
	 */
    public String getZifeiUuidNumber() {
        return zifeiUuidNumber;
    }


    /**
	 * 获取：资费编号
	 */

    public void setZifeiUuidNumber(String zifeiUuidNumber) {
        this.zifeiUuidNumber = zifeiUuidNumber;
    }
    /**
	 * 设置：资费名称
	 */
    public String getZifeiName() {
        return zifeiName;
    }


    /**
	 * 获取：资费名称
	 */

    public void setZifeiName(String zifeiName) {
        this.zifeiName = zifeiName;
    }
    /**
	 * 设置：资费类型
	 */
    public Integer getZifeiTypes() {
        return zifeiTypes;
    }


    /**
	 * 获取：资费类型
	 */

    public void setZifeiTypes(Integer zifeiTypes) {
        this.zifeiTypes = zifeiTypes;
    }
    /**
	 * 设置：金额
	 */
    public Double getZifeiNewMoney() {
        return zifeiNewMoney;
    }


    /**
	 * 获取：金额
	 */

    public void setZifeiNewMoney(Double zifeiNewMoney) {
        this.zifeiNewMoney = zifeiNewMoney;
    }
    /**
	 * 设置：前台
	 */
    public Integer getQiantaiId() {
        return qiantaiId;
    }


    /**
	 * 获取：前台
	 */

    public void setQiantaiId(Integer qiantaiId) {
        this.qiantaiId = qiantaiId;
    }
    /**
	 * 设置：资费详情
	 */
    public String getZifeiContent() {
        return zifeiContent;
    }


    /**
	 * 获取：资费详情
	 */

    public void setZifeiContent(String zifeiContent) {
        this.zifeiContent = zifeiContent;
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
