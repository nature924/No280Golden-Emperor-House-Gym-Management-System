package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ChangdiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 场地信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("changdi")
public class ChangdiView extends ChangdiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 场地类型的值
	*/
	@ColumnInfo(comment="场地类型的字典表值",type="varchar(200)")
	private String changdiValue;
	/**
	* 是否上架的值
	*/
	@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
	private String shangxiaValue;




	public ChangdiView() {

	}

	public ChangdiView(ChangdiEntity changdiEntity) {
		try {
			BeanUtils.copyProperties(this, changdiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 场地类型的值
	*/
	public String getChangdiValue() {
		return changdiValue;
	}
	/**
	* 设置： 场地类型的值
	*/
	public void setChangdiValue(String changdiValue) {
		this.changdiValue = changdiValue;
	}
	//当前表的
	/**
	* 获取： 是否上架的值
	*/
	public String getShangxiaValue() {
		return shangxiaValue;
	}
	/**
	* 设置： 是否上架的值
	*/
	public void setShangxiaValue(String shangxiaValue) {
		this.shangxiaValue = shangxiaValue;
	}




	@Override
	public String toString() {
		return "ChangdiView{" +
			", changdiValue=" + changdiValue +
			", shangxiaValue=" + shangxiaValue +
			"} " + super.toString();
	}
}
