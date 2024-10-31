package com.entity.model;

import com.entity.ChangdiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 场地信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChangdiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 场地名称
     */
    private String changdiName;


    /**
     * 场地照片
     */
    private String changdiPhoto;


    /**
     * 场地类型
     */
    private Integer changdiTypes;


    /**
     * 场地容量
     */
    private Integer changdiKucunNumber;


    /**
     * 价格/分钟
     */
    private Double changdiNewMoney;


    /**
     * 场地热度
     */
    private Integer changdiClicknum;


    /**
     * 场地介绍
     */
    private String changdiContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer dataDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：场地名称
	 */
    public String getChangdiName() {
        return changdiName;
    }


    /**
	 * 设置：场地名称
	 */
    public void setChangdiName(String changdiName) {
        this.changdiName = changdiName;
    }
    /**
	 * 获取：场地照片
	 */
    public String getChangdiPhoto() {
        return changdiPhoto;
    }


    /**
	 * 设置：场地照片
	 */
    public void setChangdiPhoto(String changdiPhoto) {
        this.changdiPhoto = changdiPhoto;
    }
    /**
	 * 获取：场地类型
	 */
    public Integer getChangdiTypes() {
        return changdiTypes;
    }


    /**
	 * 设置：场地类型
	 */
    public void setChangdiTypes(Integer changdiTypes) {
        this.changdiTypes = changdiTypes;
    }
    /**
	 * 获取：场地容量
	 */
    public Integer getChangdiKucunNumber() {
        return changdiKucunNumber;
    }


    /**
	 * 设置：场地容量
	 */
    public void setChangdiKucunNumber(Integer changdiKucunNumber) {
        this.changdiKucunNumber = changdiKucunNumber;
    }
    /**
	 * 获取：价格/分钟
	 */
    public Double getChangdiNewMoney() {
        return changdiNewMoney;
    }


    /**
	 * 设置：价格/分钟
	 */
    public void setChangdiNewMoney(Double changdiNewMoney) {
        this.changdiNewMoney = changdiNewMoney;
    }
    /**
	 * 获取：场地热度
	 */
    public Integer getChangdiClicknum() {
        return changdiClicknum;
    }


    /**
	 * 设置：场地热度
	 */
    public void setChangdiClicknum(Integer changdiClicknum) {
        this.changdiClicknum = changdiClicknum;
    }
    /**
	 * 获取：场地介绍
	 */
    public String getChangdiContent() {
        return changdiContent;
    }


    /**
	 * 设置：场地介绍
	 */
    public void setChangdiContent(String changdiContent) {
        this.changdiContent = changdiContent;
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
