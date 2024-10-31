package com.entity.vo;

import com.entity.DianzhangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 店长
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("dianzhang")
public class DianzhangVO implements Serializable {
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
     * 店长名称
     */

    @TableField(value = "dianzhang_name")
    private String dianzhangName;


    /**
     * 店长手机号
     */

    @TableField(value = "dianzhang_phone")
    private String dianzhangPhone;


    /**
     * 店长头像
     */

    @TableField(value = "dianzhang_photo")
    private String dianzhangPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 店长邮箱
     */

    @TableField(value = "dianzhang_email")
    private String dianzhangEmail;


    /**
     * 店长简介
     */

    @TableField(value = "dianzhang_content")
    private String dianzhangContent;


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
	 * 设置：店长名称
	 */
    public String getDianzhangName() {
        return dianzhangName;
    }


    /**
	 * 获取：店长名称
	 */

    public void setDianzhangName(String dianzhangName) {
        this.dianzhangName = dianzhangName;
    }
    /**
	 * 设置：店长手机号
	 */
    public String getDianzhangPhone() {
        return dianzhangPhone;
    }


    /**
	 * 获取：店长手机号
	 */

    public void setDianzhangPhone(String dianzhangPhone) {
        this.dianzhangPhone = dianzhangPhone;
    }
    /**
	 * 设置：店长头像
	 */
    public String getDianzhangPhoto() {
        return dianzhangPhoto;
    }


    /**
	 * 获取：店长头像
	 */

    public void setDianzhangPhoto(String dianzhangPhoto) {
        this.dianzhangPhoto = dianzhangPhoto;
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
	 * 设置：店长邮箱
	 */
    public String getDianzhangEmail() {
        return dianzhangEmail;
    }


    /**
	 * 获取：店长邮箱
	 */

    public void setDianzhangEmail(String dianzhangEmail) {
        this.dianzhangEmail = dianzhangEmail;
    }
    /**
	 * 设置：店长简介
	 */
    public String getDianzhangContent() {
        return dianzhangContent;
    }


    /**
	 * 获取：店长简介
	 */

    public void setDianzhangContent(String dianzhangContent) {
        this.dianzhangContent = dianzhangContent;
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
