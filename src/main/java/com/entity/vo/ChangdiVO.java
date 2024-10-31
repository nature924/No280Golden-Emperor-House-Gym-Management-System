package com.entity.vo;

import com.entity.ChangdiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 场地信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("changdi")
public class ChangdiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 场地名称
     */

    @TableField(value = "changdi_name")
    private String changdiName;


    /**
     * 场地照片
     */

    @TableField(value = "changdi_photo")
    private String changdiPhoto;


    /**
     * 场地类型
     */

    @TableField(value = "changdi_types")
    private Integer changdiTypes;


    /**
     * 场地容量
     */

    @TableField(value = "changdi_kucun_number")
    private Integer changdiKucunNumber;


    /**
     * 价格/分钟
     */

    @TableField(value = "changdi_new_money")
    private Double changdiNewMoney;


    /**
     * 场地热度
     */

    @TableField(value = "changdi_clicknum")
    private Integer changdiClicknum;


    /**
     * 场地介绍
     */

    @TableField(value = "changdi_content")
    private String changdiContent;


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
	 * 设置：场地名称
	 */
    public String getChangdiName() {
        return changdiName;
    }


    /**
	 * 获取：场地名称
	 */

    public void setChangdiName(String changdiName) {
        this.changdiName = changdiName;
    }
    /**
	 * 设置：场地照片
	 */
    public String getChangdiPhoto() {
        return changdiPhoto;
    }


    /**
	 * 获取：场地照片
	 */

    public void setChangdiPhoto(String changdiPhoto) {
        this.changdiPhoto = changdiPhoto;
    }
    /**
	 * 设置：场地类型
	 */
    public Integer getChangdiTypes() {
        return changdiTypes;
    }


    /**
	 * 获取：场地类型
	 */

    public void setChangdiTypes(Integer changdiTypes) {
        this.changdiTypes = changdiTypes;
    }
    /**
	 * 设置：场地容量
	 */
    public Integer getChangdiKucunNumber() {
        return changdiKucunNumber;
    }


    /**
	 * 获取：场地容量
	 */

    public void setChangdiKucunNumber(Integer changdiKucunNumber) {
        this.changdiKucunNumber = changdiKucunNumber;
    }
    /**
	 * 设置：价格/分钟
	 */
    public Double getChangdiNewMoney() {
        return changdiNewMoney;
    }


    /**
	 * 获取：价格/分钟
	 */

    public void setChangdiNewMoney(Double changdiNewMoney) {
        this.changdiNewMoney = changdiNewMoney;
    }
    /**
	 * 设置：场地热度
	 */
    public Integer getChangdiClicknum() {
        return changdiClicknum;
    }


    /**
	 * 获取：场地热度
	 */

    public void setChangdiClicknum(Integer changdiClicknum) {
        this.changdiClicknum = changdiClicknum;
    }
    /**
	 * 设置：场地介绍
	 */
    public String getChangdiContent() {
        return changdiContent;
    }


    /**
	 * 获取：场地介绍
	 */

    public void setChangdiContent(String changdiContent) {
        this.changdiContent = changdiContent;
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
