package com.entity.model;

import com.entity.ChangdiYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 场地预约申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChangdiYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 预约编号
     */
    private String changdiYuyueUuidNumber;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 场地
     */
    private Integer changdiId;


    /**
     * 备注
     */
    private String sheshiyuyueText;


    /**
     * 开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date changdiYuyueTime;


    /**
     * 结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date changdiJieshuTime;


    /**
     * 预约状态
     */
    private Integer changdiYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String changdiYuyueYesnoText;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：预约编号
	 */
    public String getChangdiYuyueUuidNumber() {
        return changdiYuyueUuidNumber;
    }


    /**
	 * 设置：预约编号
	 */
    public void setChangdiYuyueUuidNumber(String changdiYuyueUuidNumber) {
        this.changdiYuyueUuidNumber = changdiYuyueUuidNumber;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：场地
	 */
    public Integer getChangdiId() {
        return changdiId;
    }


    /**
	 * 设置：场地
	 */
    public void setChangdiId(Integer changdiId) {
        this.changdiId = changdiId;
    }
    /**
	 * 获取：备注
	 */
    public String getSheshiyuyueText() {
        return sheshiyuyueText;
    }


    /**
	 * 设置：备注
	 */
    public void setSheshiyuyueText(String sheshiyuyueText) {
        this.sheshiyuyueText = sheshiyuyueText;
    }
    /**
	 * 获取：开始时间
	 */
    public Date getChangdiYuyueTime() {
        return changdiYuyueTime;
    }


    /**
	 * 设置：开始时间
	 */
    public void setChangdiYuyueTime(Date changdiYuyueTime) {
        this.changdiYuyueTime = changdiYuyueTime;
    }
    /**
	 * 获取：结束时间
	 */
    public Date getChangdiJieshuTime() {
        return changdiJieshuTime;
    }


    /**
	 * 设置：结束时间
	 */
    public void setChangdiJieshuTime(Date changdiJieshuTime) {
        this.changdiJieshuTime = changdiJieshuTime;
    }
    /**
	 * 获取：预约状态
	 */
    public Integer getChangdiYuyueYesnoTypes() {
        return changdiYuyueYesnoTypes;
    }


    /**
	 * 设置：预约状态
	 */
    public void setChangdiYuyueYesnoTypes(Integer changdiYuyueYesnoTypes) {
        this.changdiYuyueYesnoTypes = changdiYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getChangdiYuyueYesnoText() {
        return changdiYuyueYesnoText;
    }


    /**
	 * 设置：审核回复
	 */
    public void setChangdiYuyueYesnoText(String changdiYuyueYesnoText) {
        this.changdiYuyueYesnoText = changdiYuyueYesnoText;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
