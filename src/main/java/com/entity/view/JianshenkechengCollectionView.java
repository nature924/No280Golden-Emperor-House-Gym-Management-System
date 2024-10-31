package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JianshenkechengCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 课程收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jianshenkecheng_collection")
public class JianshenkechengCollectionView extends JianshenkechengCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String jianshenkechengCollectionValue;

	//级联表 健身课程
					 
		/**
		* 健身课程 的 教练
		*/
		@ColumnInfo(comment="教练",type="int(11)")
		private Integer jianshenkechengJiaolianId;
		/**
		* 健身课程名称
		*/

		@ColumnInfo(comment="健身课程名称",type="varchar(200)")
		private String jianshenkechengName;
		/**
		* 健身课程照片
		*/

		@ColumnInfo(comment="健身课程照片",type="varchar(200)")
		private String jianshenkechengPhoto;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 健身课程类型
		*/
		@ColumnInfo(comment="健身课程类型",type="int(11)")
		private Integer jianshenkechengTypes;
			/**
			* 健身课程类型的值
			*/
			@ColumnInfo(comment="健身课程类型的字典表值",type="varchar(200)")
			private String jianshenkechengValue;
		/**
		* 健身课程热度
		*/

		@ColumnInfo(comment="健身课程热度",type="int(11)")
		private Integer jianshenkechengClicknum;
		/**
		* 课程价格
		*/
		@ColumnInfo(comment="课程价格",type="decimal(10,2)")
		private Double jianshenkechengNewMoney;
		/**
		* 健身课程介绍
		*/

		@ColumnInfo(comment="健身课程介绍",type="longtext")
		private String jianshenkechengContent;
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



	public JianshenkechengCollectionView() {

	}

	public JianshenkechengCollectionView(JianshenkechengCollectionEntity jianshenkechengCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, jianshenkechengCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getJianshenkechengCollectionValue() {
		return jianshenkechengCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setJianshenkechengCollectionValue(String jianshenkechengCollectionValue) {
		this.jianshenkechengCollectionValue = jianshenkechengCollectionValue;
	}


	//级联表的get和set 健身课程
		/**
		* 获取：健身课程 的 教练
		*/
		public Integer getJianshenkechengJiaolianId() {
			return jianshenkechengJiaolianId;
		}
		/**
		* 设置：健身课程 的 教练
		*/
		public void setJianshenkechengJiaolianId(Integer jianshenkechengJiaolianId) {
			this.jianshenkechengJiaolianId = jianshenkechengJiaolianId;
		}

		/**
		* 获取： 健身课程名称
		*/
		public String getJianshenkechengName() {
			return jianshenkechengName;
		}
		/**
		* 设置： 健身课程名称
		*/
		public void setJianshenkechengName(String jianshenkechengName) {
			this.jianshenkechengName = jianshenkechengName;
		}

		/**
		* 获取： 健身课程照片
		*/
		public String getJianshenkechengPhoto() {
			return jianshenkechengPhoto;
		}
		/**
		* 设置： 健身课程照片
		*/
		public void setJianshenkechengPhoto(String jianshenkechengPhoto) {
			this.jianshenkechengPhoto = jianshenkechengPhoto;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}
		/**
		* 获取： 健身课程类型
		*/
		public Integer getJianshenkechengTypes() {
			return jianshenkechengTypes;
		}
		/**
		* 设置： 健身课程类型
		*/
		public void setJianshenkechengTypes(Integer jianshenkechengTypes) {
			this.jianshenkechengTypes = jianshenkechengTypes;
		}


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

		/**
		* 获取： 健身课程热度
		*/
		public Integer getJianshenkechengClicknum() {
			return jianshenkechengClicknum;
		}
		/**
		* 设置： 健身课程热度
		*/
		public void setJianshenkechengClicknum(Integer jianshenkechengClicknum) {
			this.jianshenkechengClicknum = jianshenkechengClicknum;
		}

		/**
		* 获取： 课程价格
		*/
		public Double getJianshenkechengNewMoney() {
			return jianshenkechengNewMoney;
		}
		/**
		* 设置： 课程价格
		*/
		public void setJianshenkechengNewMoney(Double jianshenkechengNewMoney) {
			this.jianshenkechengNewMoney = jianshenkechengNewMoney;
		}

		/**
		* 获取： 健身课程介绍
		*/
		public String getJianshenkechengContent() {
			return jianshenkechengContent;
		}
		/**
		* 设置： 健身课程介绍
		*/
		public void setJianshenkechengContent(String jianshenkechengContent) {
			this.jianshenkechengContent = jianshenkechengContent;
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
		return "JianshenkechengCollectionView{" +
			", jianshenkechengCollectionValue=" + jianshenkechengCollectionValue +
			", jianshenkechengName=" + jianshenkechengName +
			", jianshenkechengPhoto=" + jianshenkechengPhoto +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", jianshenkechengClicknum=" + jianshenkechengClicknum +
			", jianshenkechengNewMoney=" + jianshenkechengNewMoney +
			", jianshenkechengContent=" + jianshenkechengContent +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
