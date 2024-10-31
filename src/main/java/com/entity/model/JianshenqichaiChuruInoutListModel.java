package com.entity.model;

import com.entity.JianshenqichaiChuruInoutListEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 出入库详情
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JianshenqichaiChuruInoutListModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 出入库
     */
    private Integer jianshenqichaiChuruInoutId;


    /**
     * 健身器材
     */
    private Integer jianshenqichaiId;


    /**
     * 操作数量
     */
    private Integer jianshenqichaiChuruInoutListNumber;


    /**
     * 操作时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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

    }
