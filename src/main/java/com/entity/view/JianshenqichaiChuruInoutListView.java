package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JianshenqichaiChuruInoutListEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 出入库详情
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jianshenqichai_churu_inout_list")
public class JianshenqichaiChuruInoutListView extends JianshenqichaiChuruInoutListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 健身器材
		/**
		* 健身器材编号
		*/

		@ColumnInfo(comment="健身器材编号",type="varchar(200)")
		private String jianshenqichaiUuidNumber;
		/**
		* 健身器材名称
		*/

		@ColumnInfo(comment="健身器材名称",type="varchar(200)")
		private String jianshenqichaiName;
		/**
		* 健身器材类型
		*/
		@ColumnInfo(comment="健身器材类型",type="int(11)")
		private Integer jianshenqichaiTypes;
			/**
			* 健身器材类型的值
			*/
			@ColumnInfo(comment="健身器材类型的字典表值",type="varchar(200)")
			private String jianshenqichaiValue;
		/**
		* 健身器材库存
		*/

		@ColumnInfo(comment="健身器材库存",type="int(11)")
		private Integer jianshenqichaiKucunNumber;
		/**
		* 价格
		*/
		@ColumnInfo(comment="价格",type="decimal(10,2)")
		private Double jianshenqichaiNewMoney;
		/**
		* 健身器材介绍
		*/

		@ColumnInfo(comment="健身器材介绍",type="longtext")
		private String jianshenqichaiContent;
	//级联表 出入库
		/**
		* 出入库流水号
		*/

		@ColumnInfo(comment="出入库流水号",type="varchar(200)")
		private String jianshenqichaiChuruInoutUuidNumber;
		/**
		* 出入库名称
		*/

		@ColumnInfo(comment="出入库名称",type="varchar(200)")
		private String jianshenqichaiChuruInoutName;
		/**
		* 出入库类型
		*/
		@ColumnInfo(comment="出入库类型",type="int(11)")
		private Integer jianshenqichaiChuruInoutTypes;
			/**
			* 出入库类型的值
			*/
			@ColumnInfo(comment="出入库类型的字典表值",type="varchar(200)")
			private String jianshenqichaiChuruInoutValue;
		/**
		* 备注
		*/

		@ColumnInfo(comment="备注",type="longtext")
		private String jianshenqichaiChuruInoutContent;



	public JianshenqichaiChuruInoutListView() {

	}

	public JianshenqichaiChuruInoutListView(JianshenqichaiChuruInoutListEntity jianshenqichaiChuruInoutListEntity) {
		try {
			BeanUtils.copyProperties(this, jianshenqichaiChuruInoutListEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 健身器材

		/**
		* 获取： 健身器材编号
		*/
		public String getJianshenqichaiUuidNumber() {
			return jianshenqichaiUuidNumber;
		}
		/**
		* 设置： 健身器材编号
		*/
		public void setJianshenqichaiUuidNumber(String jianshenqichaiUuidNumber) {
			this.jianshenqichaiUuidNumber = jianshenqichaiUuidNumber;
		}

		/**
		* 获取： 健身器材名称
		*/
		public String getJianshenqichaiName() {
			return jianshenqichaiName;
		}
		/**
		* 设置： 健身器材名称
		*/
		public void setJianshenqichaiName(String jianshenqichaiName) {
			this.jianshenqichaiName = jianshenqichaiName;
		}
		/**
		* 获取： 健身器材类型
		*/
		public Integer getJianshenqichaiTypes() {
			return jianshenqichaiTypes;
		}
		/**
		* 设置： 健身器材类型
		*/
		public void setJianshenqichaiTypes(Integer jianshenqichaiTypes) {
			this.jianshenqichaiTypes = jianshenqichaiTypes;
		}


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

		/**
		* 获取： 健身器材库存
		*/
		public Integer getJianshenqichaiKucunNumber() {
			return jianshenqichaiKucunNumber;
		}
		/**
		* 设置： 健身器材库存
		*/
		public void setJianshenqichaiKucunNumber(Integer jianshenqichaiKucunNumber) {
			this.jianshenqichaiKucunNumber = jianshenqichaiKucunNumber;
		}

		/**
		* 获取： 价格
		*/
		public Double getJianshenqichaiNewMoney() {
			return jianshenqichaiNewMoney;
		}
		/**
		* 设置： 价格
		*/
		public void setJianshenqichaiNewMoney(Double jianshenqichaiNewMoney) {
			this.jianshenqichaiNewMoney = jianshenqichaiNewMoney;
		}

		/**
		* 获取： 健身器材介绍
		*/
		public String getJianshenqichaiContent() {
			return jianshenqichaiContent;
		}
		/**
		* 设置： 健身器材介绍
		*/
		public void setJianshenqichaiContent(String jianshenqichaiContent) {
			this.jianshenqichaiContent = jianshenqichaiContent;
		}
	//级联表的get和set 出入库

		/**
		* 获取： 出入库流水号
		*/
		public String getJianshenqichaiChuruInoutUuidNumber() {
			return jianshenqichaiChuruInoutUuidNumber;
		}
		/**
		* 设置： 出入库流水号
		*/
		public void setJianshenqichaiChuruInoutUuidNumber(String jianshenqichaiChuruInoutUuidNumber) {
			this.jianshenqichaiChuruInoutUuidNumber = jianshenqichaiChuruInoutUuidNumber;
		}

		/**
		* 获取： 出入库名称
		*/
		public String getJianshenqichaiChuruInoutName() {
			return jianshenqichaiChuruInoutName;
		}
		/**
		* 设置： 出入库名称
		*/
		public void setJianshenqichaiChuruInoutName(String jianshenqichaiChuruInoutName) {
			this.jianshenqichaiChuruInoutName = jianshenqichaiChuruInoutName;
		}
		/**
		* 获取： 出入库类型
		*/
		public Integer getJianshenqichaiChuruInoutTypes() {
			return jianshenqichaiChuruInoutTypes;
		}
		/**
		* 设置： 出入库类型
		*/
		public void setJianshenqichaiChuruInoutTypes(Integer jianshenqichaiChuruInoutTypes) {
			this.jianshenqichaiChuruInoutTypes = jianshenqichaiChuruInoutTypes;
		}


			/**
			* 获取： 出入库类型的值
			*/
			public String getJianshenqichaiChuruInoutValue() {
				return jianshenqichaiChuruInoutValue;
			}
			/**
			* 设置： 出入库类型的值
			*/
			public void setJianshenqichaiChuruInoutValue(String jianshenqichaiChuruInoutValue) {
				this.jianshenqichaiChuruInoutValue = jianshenqichaiChuruInoutValue;
			}

		/**
		* 获取： 备注
		*/
		public String getJianshenqichaiChuruInoutContent() {
			return jianshenqichaiChuruInoutContent;
		}
		/**
		* 设置： 备注
		*/
		public void setJianshenqichaiChuruInoutContent(String jianshenqichaiChuruInoutContent) {
			this.jianshenqichaiChuruInoutContent = jianshenqichaiChuruInoutContent;
		}


	@Override
	public String toString() {
		return "JianshenqichaiChuruInoutListView{" +
			", jianshenqichaiChuruInoutUuidNumber=" + jianshenqichaiChuruInoutUuidNumber +
			", jianshenqichaiChuruInoutName=" + jianshenqichaiChuruInoutName +
			", jianshenqichaiChuruInoutContent=" + jianshenqichaiChuruInoutContent +
			", jianshenqichaiUuidNumber=" + jianshenqichaiUuidNumber +
			", jianshenqichaiName=" + jianshenqichaiName +
			", jianshenqichaiKucunNumber=" + jianshenqichaiKucunNumber +
			", jianshenqichaiNewMoney=" + jianshenqichaiNewMoney +
			", jianshenqichaiContent=" + jianshenqichaiContent +
			"} " + super.toString();
	}
}
