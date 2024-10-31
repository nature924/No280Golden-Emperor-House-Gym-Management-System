package com.entity.vo;

import com.entity.JianshenkechengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 健身课程
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jianshenkecheng")
public class JianshenkechengVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 教练
     */

    @TableField(value = "jiaolian_id")
    private Integer jiaolianId;


    /**
     * 健身课程名称
     */

    @TableField(value = "jianshenkecheng_name")
    private String jianshenkechengName;


    /**
     * 健身课程照片
     */

    @TableField(value = "jianshenkecheng_photo")
    private String jianshenkechengPhoto;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 健身课程类型
     */

    @TableField(value = "jianshenkecheng_types")
    private Integer jianshenkechengTypes;


    /**
     * 健身课程热度
     */

    @TableField(value = "jianshenkecheng_clicknum")
    private Integer jianshenkechengClicknum;


    /**
     * 课程价格
     */

    @TableField(value = "jianshenkecheng_new_money")
    private Double jianshenkechengNewMoney;


    /**
     * 健身课程介绍
     */

    @TableField(value = "jianshenkecheng_content")
    private String jianshenkechengContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "data_delete")
    private Integer dataDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：教练
	 */
    public Integer getJiaolianId() {
        return jiaolianId;
    }


    /**
	 * 获取：教练
	 */

    public void setJiaolianId(Integer jiaolianId) {
        this.jiaolianId = jiaolianId;
    }
    /**
	 * 设置：健身课程名称
	 */
    public String getJianshenkechengName() {
        return jianshenkechengName;
    }


    /**
	 * 获取：健身课程名称
	 */

    public void setJianshenkechengName(String jianshenkechengName) {
        this.jianshenkechengName = jianshenkechengName;
    }
    /**
	 * 设置：健身课程照片
	 */
    public String getJianshenkechengPhoto() {
        return jianshenkechengPhoto;
    }


    /**
	 * 获取：健身课程照片
	 */

    public void setJianshenkechengPhoto(String jianshenkechengPhoto) {
        this.jianshenkechengPhoto = jianshenkechengPhoto;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：健身课程类型
	 */
    public Integer getJianshenkechengTypes() {
        return jianshenkechengTypes;
    }


    /**
	 * 获取：健身课程类型
	 */

    public void setJianshenkechengTypes(Integer jianshenkechengTypes) {
        this.jianshenkechengTypes = jianshenkechengTypes;
    }
    /**
	 * 设置：健身课程热度
	 */
    public Integer getJianshenkechengClicknum() {
        return jianshenkechengClicknum;
    }


    /**
	 * 获取：健身课程热度
	 */

    public void setJianshenkechengClicknum(Integer jianshenkechengClicknum) {
        this.jianshenkechengClicknum = jianshenkechengClicknum;
    }
    /**
	 * 设置：课程价格
	 */
    public Double getJianshenkechengNewMoney() {
        return jianshenkechengNewMoney;
    }


    /**
	 * 获取：课程价格
	 */

    public void setJianshenkechengNewMoney(Double jianshenkechengNewMoney) {
        this.jianshenkechengNewMoney = jianshenkechengNewMoney;
    }
    /**
	 * 设置：健身课程介绍
	 */
    public String getJianshenkechengContent() {
        return jianshenkechengContent;
    }


    /**
	 * 获取：健身课程介绍
	 */

    public void setJianshenkechengContent(String jianshenkechengContent) {
        this.jianshenkechengContent = jianshenkechengContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
