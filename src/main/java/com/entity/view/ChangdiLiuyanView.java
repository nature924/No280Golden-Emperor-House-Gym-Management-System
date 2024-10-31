package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ChangdiLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 场地留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("changdi_liuyan")
public class ChangdiLiuyanView extends ChangdiLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 场地信息
		/**
		* 场地名称
		*/

		@ColumnInfo(comment="场地名称",type="varchar(200)")
		private String changdiName;
		/**
		* 场地照片
		*/

		@ColumnInfo(comment="场地照片",type="varchar(200)")
		private String changdiPhoto;
		/**
		* 场地类型
		*/
		@ColumnInfo(comment="场地类型",type="int(11)")
		private Integer changdiTypes;
			/**
			* 场地类型的值
			*/
			@ColumnInfo(comment="场地类型的字典表值",type="varchar(200)")
			private String changdiValue;
		/**
		* 场地容量
		*/

		@ColumnInfo(comment="场地容量",type="int(11)")
		private Integer changdiKucunNumber;
		/**
		* 价格/分钟
		*/
		@ColumnInfo(comment="价格/分钟",type="decimal(10,2)")
		private Double changdiNewMoney;
		/**
		* 场地热度
		*/

		@ColumnInfo(comment="场地热度",type="int(11)")
		private Integer changdiClicknum;
		/**
		* 场地介绍
		*/

		@ColumnInfo(comment="场地介绍",type="longtext")
		private String changdiContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
	//级联表 用户
		/**
		* 用户名称
		*/

		@ColumnInfo(comment="用户名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 现有余额
		*/
		@ColumnInfo(comment="现有余额",type="decimal(10,2)")
		private Double newMoney;



	public ChangdiLiuyanView() {

	}

	public ChangdiLiuyanView(ChangdiLiuyanEntity changdiLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, changdiLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 场地信息

		/**
		* 获取： 场地名称
		*/
		public String getChangdiName() {
			return changdiName;
		}
		/**
		* 设置： 场地名称
		*/
		public void setChangdiName(String changdiName) {
			this.changdiName = changdiName;
		}

		/**
		* 获取： 场地照片
		*/
		public String getChangdiPhoto() {
			return changdiPhoto;
		}
		/**
		* 设置： 场地照片
		*/
		public void setChangdiPhoto(String changdiPhoto) {
			this.changdiPhoto = changdiPhoto;
		}
		/**
		* 获取： 场地类型
		*/
		public Integer getChangdiTypes() {
			return changdiTypes;
		}
		/**
		* 设置： 场地类型
		*/
		public void setChangdiTypes(Integer changdiTypes) {
			this.changdiTypes = changdiTypes;
		}


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

		/**
		* 获取： 场地容量
		*/
		public Integer getChangdiKucunNumber() {
			return changdiKucunNumber;
		}
		/**
		* 设置： 场地容量
		*/
		public void setChangdiKucunNumber(Integer changdiKucunNumber) {
			this.changdiKucunNumber = changdiKucunNumber;
		}

		/**
		* 获取： 价格/分钟
		*/
		public Double getChangdiNewMoney() {
			return changdiNewMoney;
		}
		/**
		* 设置： 价格/分钟
		*/
		public void setChangdiNewMoney(Double changdiNewMoney) {
			this.changdiNewMoney = changdiNewMoney;
		}

		/**
		* 获取： 场地热度
		*/
		public Integer getChangdiClicknum() {
			return changdiClicknum;
		}
		/**
		* 设置： 场地热度
		*/
		public void setChangdiClicknum(Integer changdiClicknum) {
			this.changdiClicknum = changdiClicknum;
		}

		/**
		* 获取： 场地介绍
		*/
		public String getChangdiContent() {
			return changdiContent;
		}
		/**
		* 设置： 场地介绍
		*/
		public void setChangdiContent(String changdiContent) {
			this.changdiContent = changdiContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


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
	//级联表的get和set 用户

		/**
		* 获取： 用户名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 现有余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 现有余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}


	@Override
	public String toString() {
		return "ChangdiLiuyanView{" +
			", changdiName=" + changdiName +
			", changdiPhoto=" + changdiPhoto +
			", changdiKucunNumber=" + changdiKucunNumber +
			", changdiNewMoney=" + changdiNewMoney +
			", changdiClicknum=" + changdiClicknum +
			", changdiContent=" + changdiContent +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
