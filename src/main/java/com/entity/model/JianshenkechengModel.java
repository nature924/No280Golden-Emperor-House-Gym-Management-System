package com.entity.model;

import com.entity.JianshenkechengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 健身课程
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JianshenkechengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 教练
     */
    private Integer jiaolianId;


    /**
     * 健身课程名称
     */
    private String jianshenkechengName;


    /**
     * 健身课程照片
     */
    private String jianshenkechengPhoto;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 健身课程类型
     */
    private Integer jianshenkechengTypes;


    /**
     * 健身课程热度
     */
    private Integer jianshenkechengClicknum;


    /**
     * 课程价格
     */
    private Double jianshenkechengNewMoney;


    /**
     * 健身课程介绍
     */
    private String jianshenkechengContent;


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
