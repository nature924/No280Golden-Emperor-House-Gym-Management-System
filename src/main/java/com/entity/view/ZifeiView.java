package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZifeiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 资费
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("zifei")
public class ZifeiView extends ZifeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 资费类型的值
	*/
	@ColumnInfo(comment="资费类型的字典表值",type="varchar(200)")
	private String zifeiValue;

	//级联表 前台
		/**
		* 前台名称
		*/

		@ColumnInfo(comment="前台名称",type="varchar(200)")
		private String qiantaiName;
		/**
		* 前台手机号
		*/

		@ColumnInfo(comment="前台手机号",type="varchar(200)")
		private String qiantaiPhone;
		/**
		* 前台头像
		*/

		@ColumnInfo(comment="前台头像",type="varchar(200)")
		private String qiantaiPhoto;
		/**
		* 前台邮箱
		*/

		@ColumnInfo(comment="前台邮箱",type="varchar(200)")
		private String qiantaiEmail;
		/**
		* 工薪
		*/
		@ColumnInfo(comment="工薪",type="decimal(10,2)")
		private Double qiantaiNewMoney;
		/**
		* 前台简介
		*/

		@ColumnInfo(comment="前台简介",type="longtext")
		private String qiantaiContent;



	public ZifeiView() {

	}

	public ZifeiView(ZifeiEntity zifeiEntity) {
		try {
			BeanUtils.copyProperties(this, zifeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 资费类型的值
	*/
	public String getZifeiValue() {
		return zifeiValue;
	}
	/**
	* 设置： 资费类型的值
	*/
	public void setZifeiValue(String zifeiValue) {
		this.zifeiValue = zifeiValue;
	}


	//级联表的get和set 前台

		/**
		* 获取： 前台名称
		*/
		public String getQiantaiName() {
			return qiantaiName;
		}
		/**
		* 设置： 前台名称
		*/
		public void setQiantaiName(String qiantaiName) {
			this.qiantaiName = qiantaiName;
		}

		/**
		* 获取： 前台手机号
		*/
		public String getQiantaiPhone() {
			return qiantaiPhone;
		}
		/**
		* 设置： 前台手机号
		*/
		public void setQiantaiPhone(String qiantaiPhone) {
			this.qiantaiPhone = qiantaiPhone;
		}

		/**
		* 获取： 前台头像
		*/
		public String getQiantaiPhoto() {
			return qiantaiPhoto;
		}
		/**
		* 设置： 前台头像
		*/
		public void setQiantaiPhoto(String qiantaiPhoto) {
			this.qiantaiPhoto = qiantaiPhoto;
		}

		/**
		* 获取： 前台邮箱
		*/
		public String getQiantaiEmail() {
			return qiantaiEmail;
		}
		/**
		* 设置： 前台邮箱
		*/
		public void setQiantaiEmail(String qiantaiEmail) {
			this.qiantaiEmail = qiantaiEmail;
		}

		/**
		* 获取： 工薪
		*/
		public Double getQiantaiNewMoney() {
			return qiantaiNewMoney;
		}
		/**
		* 设置： 工薪
		*/
		public void setQiantaiNewMoney(Double qiantaiNewMoney) {
			this.qiantaiNewMoney = qiantaiNewMoney;
		}

		/**
		* 获取： 前台简介
		*/
		public String getQiantaiContent() {
			return qiantaiContent;
		}
		/**
		* 设置： 前台简介
		*/
		public void setQiantaiContent(String qiantaiContent) {
			this.qiantaiContent = qiantaiContent;
		}


	@Override
	public String toString() {
		return "ZifeiView{" +
			", zifeiValue=" + zifeiValue +
			", qiantaiName=" + qiantaiName +
			", qiantaiPhone=" + qiantaiPhone +
			", qiantaiPhoto=" + qiantaiPhoto +
			", qiantaiEmail=" + qiantaiEmail +
			", qiantaiNewMoney=" + qiantaiNewMoney +
			", qiantaiContent=" + qiantaiContent +
			"} " + super.toString();
	}
}
