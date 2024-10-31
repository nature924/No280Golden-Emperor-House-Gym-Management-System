package com.entity.vo;

import com.entity.ZhuchangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 驻场人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhuchang")
public class ZhuchangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 驻场人员名称
     */

    @TableField(value = "zhuchang_name")
    private String zhuchangName;


    /**
     * 驻场人员手机号
     */

    @TableField(value = "zhuchang_phone")
    private String zhuchangPhone;


    /**
     * 驻场人员头像
     */

    @TableField(value = "zhuchang_photo")
    private String zhuchangPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 驻场人员邮箱
     */

    @TableField(value = "zhuchang_email")
    private String zhuchangEmail;


    /**
     * 工薪
     */

    @TableField(value = "zhuchang_new_money")
    private Double zhuchangNewMoney;


    /**
     * 驻场人员简介
     */

    @TableField(value = "zhuchang_content")
    private String zhuchangContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "data_delete")
    private Integer dataDelete;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：驻场人员名称
	 */
    public String getZhuchangName() {
        return zhuchangName;
    }


    /**
	 * 获取：驻场人员名称
	 */

    public void setZhuchangName(String zhuchangName) {
        this.zhuchangName = zhuchangName;
    }
    /**
	 * 设置：驻场人员手机号
	 */
    public String getZhuchangPhone() {
        return zhuchangPhone;
    }


    /**
	 * 获取：驻场人员手机号
	 */

    public void setZhuchangPhone(String zhuchangPhone) {
        this.zhuchangPhone = zhuchangPhone;
    }
    /**
	 * 设置：驻场人员头像
	 */
    public String getZhuchangPhoto() {
        return zhuchangPhoto;
    }


    /**
	 * 获取：驻场人员头像
	 */

    public void setZhuchangPhoto(String zhuchangPhoto) {
        this.zhuchangPhoto = zhuchangPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：驻场人员邮箱
	 */
    public String getZhuchangEmail() {
        return zhuchangEmail;
    }


    /**
	 * 获取：驻场人员邮箱
	 */

    public void setZhuchangEmail(String zhuchangEmail) {
        this.zhuchangEmail = zhuchangEmail;
    }
    /**
	 * 设置：工薪
	 */
    public Double getZhuchangNewMoney() {
        return zhuchangNewMoney;
    }


    /**
	 * 获取：工薪
	 */

    public void setZhuchangNewMoney(Double zhuchangNewMoney) {
        this.zhuchangNewMoney = zhuchangNewMoney;
    }
    /**
	 * 设置：驻场人员简介
	 */
    public String getZhuchangContent() {
        return zhuchangContent;
    }


    /**
	 * 获取：驻场人员简介
	 */

    public void setZhuchangContent(String zhuchangContent) {
        this.zhuchangContent = zhuchangContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getDataDelete() {
        return dataDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setDataDelete(Integer dataDelete) {
        this.dataDelete = dataDelete;
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
