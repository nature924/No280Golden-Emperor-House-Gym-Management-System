package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JianshenkechengEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 健身课程
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jianshenkecheng")
public class JianshenkechengView extends JianshenkechengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 健身课程类型的值
	*/
	@ColumnInfo(comment="健身课程类型的字典表值",type="varchar(200)")
	private String jianshenkechengValue;
	/**
	* 是否上架的值
	*/
	@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
	private String shangxiaValue;

	//级联表 教练
		/**
		* 教练名称
		*/

		@ColumnInfo(comment="教练名称",type="varchar(200)")
		private String jiaolianName;
		/**
		* 教练手机号
		*/

		@ColumnInfo(comment="教练手机号",type="varchar(200)")
		private String jiaolianPhone;
		/**
		* 教练头像
		*/

		@ColumnInfo(comment="教练头像",type="varchar(200)")
		private String jiaolianPhoto;
		/**
		* 教练邮箱
		*/

		@ColumnInfo(comment="教练邮箱",type="varchar(200)")
		private String jiaolianEmail;
		/**
		* 工薪
		*/
		@ColumnInfo(comment="工薪",type="decimal(10,2)")
		private Double jiaolianNewMoney;
		/**
		* 教练简介
		*/

		@ColumnInfo(comment="教练简介",type="longtext")
		private String jiaolianContent;



	public JianshenkechengView() {

	}

	public JianshenkechengView(JianshenkechengEntity jianshenkechengEntity) {
		try {
			BeanUtils.copyProperties(this, jianshenkechengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 健身课程类型的值
	*/
	public String getJianshenkechengValue() {
		return jianshenkechengValue;
	}
	/**
	* 设置： 健身课程类型的值
	*/
	public void setJianshenkechengValue(String jianshenkechengValue) {
		this.jianshenkechengValue = jianshenkechengValue;
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


	//级联表的get和set 教练

		/**
		* 获取： 教练名称
		*/
		public String getJiaolianName() {
			return jiaolianName;
		}
		/**
		* 设置： 教练名称
		*/
		public void setJiaolianName(String jiaolianName) {
			this.jiaolianName = jiaolianName;
		}

		/**
		* 获取： 教练手机号
		*/
		public String getJiaolianPhone() {
			return jiaolianPhone;
		}
		/**
		* 设置： 教练手机号
		*/
		public void setJiaolianPhone(String jiaolianPhone) {
			this.jiaolianPhone = jiaolianPhone;
		}

		/**
		* 获取： 教练头像
		*/
		public String getJiaolianPhoto() {
			return jiaolianPhoto;
		}
		/**
		* 设置： 教练头像
		*/
		public void setJiaolianPhoto(String jiaolianPhoto) {
			this.jiaolianPhoto = jiaolianPhoto;
		}

		/**
		* 获取： 教练邮箱
		*/
		public String getJiaolianEmail() {
			return jiaolianEmail;
		}
		/**
		* 设置： 教练邮箱
		*/
		public void setJiaolianEmail(String jiaolianEmail) {
			this.jiaolianEmail = jiaolianEmail;
		}

		/**
		* 获取： 工薪
		*/
		public Double getJiaolianNewMoney() {
			return jiaolianNewMoney;
		}
		/**
		* 设置： 工薪
		*/
		public void setJiaolianNewMoney(Double jiaolianNewMoney) {
			this.jiaolianNewMoney = jiaolianNewMoney;
		}

		/**
		* 获取： 教练简介
		*/
		public String getJiaolianContent() {
			return jiaolianContent;
		}
		/**
		* 设置： 教练简介
		*/
		public void setJiaolianContent(String jiaolianContent) {
			this.jiaolianContent = jiaolianContent;
		}


	@Override
	public String toString() {
		return "JianshenkechengView{" +
			", jianshenkechengValue=" + jianshenkechengValue +
			", shangxiaValue=" + shangxiaValue +
			", jiaolianName=" + jiaolianName +
			", jiaolianPhone=" + jiaolianPhone +
			", jiaolianPhoto=" + jiaolianPhoto +
			", jiaolianEmail=" + jiaolianEmail +
			", jiaolianNewMoney=" + jiaolianNewMoney +
			", jiaolianContent=" + jiaolianContent +
			"} " + super.toString();
	}
}
