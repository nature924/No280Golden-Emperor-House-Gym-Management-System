package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JianshenqichaiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 健身器材
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jianshenqichai")
public class JianshenqichaiView extends JianshenqichaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 健身器材类型的值
	*/
	@ColumnInfo(comment="健身器材类型的字典表值",type="varchar(200)")
	private String jianshenqichaiValue;




	public JianshenqichaiView() {

	}

	public JianshenqichaiView(JianshenqichaiEntity jianshenqichaiEntity) {
		try {
			BeanUtils.copyProperties(this, jianshenqichaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 健身器材类型的值
	*/
	public String getJianshenqichaiValue() {
		return jianshenqichaiValue;
	}
	/**
	* 设置： 健身器材类型的值
	*/
	public void setJianshenqichaiValue(String jianshenqichaiValue) {
		this.jianshenqichaiValue = jianshenqichaiValue;
	}




	@Override
	public String toString() {
		return "JianshenqichaiView{" +
			", jianshenqichaiValue=" + jianshenqichaiValue +
			"} " + super.toString();
	}
}
