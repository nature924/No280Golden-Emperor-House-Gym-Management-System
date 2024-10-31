package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ForumEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 交流论坛
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("forum")
public class ForumView extends ForumEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 帖子状态的值
	*/
	@ColumnInfo(comment="帖子状态的字典表值",type="varchar(200)")
	private String forumStateValue;

	//级联表 店长
		/**
		* 店长名称
		*/

		@ColumnInfo(comment="店长名称",type="varchar(200)")
		private String dianzhangName;
		/**
		* 店长手机号
		*/

		@ColumnInfo(comment="店长手机号",type="varchar(200)")
		private String dianzhangPhone;
		/**
		* 店长头像
		*/

		@ColumnInfo(comment="店长头像",type="varchar(200)")
		private String dianzhangPhoto;
		/**
		* 店长邮箱
		*/

		@ColumnInfo(comment="店长邮箱",type="varchar(200)")
		private String dianzhangEmail;
		/**
		* 店长简介
		*/

		@ColumnInfo(comment="店长简介",type="longtext")
		private String dianzhangContent;
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
	//级联表 驻场人员
		/**
		* 驻场人员名称
		*/

		@ColumnInfo(comment="驻场人员名称",type="varchar(200)")
		private String zhuchangName;
		/**
		* 驻场人员手机号
		*/

		@ColumnInfo(comment="驻场人员手机号",type="varchar(200)")
		private String zhuchangPhone;
		/**
		* 驻场人员头像
		*/

		@ColumnInfo(comment="驻场人员头像",type="varchar(200)")
		private String zhuchangPhoto;
		/**
		* 驻场人员邮箱
		*/

		@ColumnInfo(comment="驻场人员邮箱",type="varchar(200)")
		private String zhuchangEmail;
		/**
		* 工薪
		*/
		@ColumnInfo(comment="工薪",type="decimal(10,2)")
		private Double zhuchangNewMoney;
		/**
		* 驻场人员简介
		*/

		@ColumnInfo(comment="驻场人员简介",type="longtext")
		private String zhuchangContent;
	//级联表 管理员
		/**
		* 医院名
		*/
		@ColumnInfo(comment="医院名",type="varchar(100)")
		private String uusername;
		/**
		* 密码
		*/
		@ColumnInfo(comment="密码",type="varchar(100)")
		private String upassword;
		/**
		* 角色
		*/
		@ColumnInfo(comment="角色",type="varchar(100)")
		private String urole;
		/**
		* 新增时间
		*/
		@ColumnInfo(comment="新增时间",type="timestamp")
		private Date uaddtime;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public ForumView() {

	}

	public ForumView(ForumEntity forumEntity) {
		try {
			BeanUtils.copyProperties(this, forumEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 帖子状态的值
	*/
	public String getForumStateValue() {
		return forumStateValue;
	}
	/**
	* 设置： 帖子状态的值
	*/
	public void setForumStateValue(String forumStateValue) {
		this.forumStateValue = forumStateValue;
	}


	//级联表的get和set 店长

		/**
		* 获取： 店长名称
		*/
		public String getDianzhangName() {
			return dianzhangName;
		}
		/**
		* 设置： 店长名称
		*/
		public void setDianzhangName(String dianzhangName) {
			this.dianzhangName = dianzhangName;
		}

		/**
		* 获取： 店长手机号
		*/
		public String getDianzhangPhone() {
			return dianzhangPhone;
		}
		/**
		* 设置： 店长手机号
		*/
		public void setDianzhangPhone(String dianzhangPhone) {
			this.dianzhangPhone = dianzhangPhone;
		}

		/**
		* 获取： 店长头像
		*/
		public String getDianzhangPhoto() {
			return dianzhangPhoto;
		}
		/**
		* 设置： 店长头像
		*/
		public void setDianzhangPhoto(String dianzhangPhoto) {
			this.dianzhangPhoto = dianzhangPhoto;
		}

		/**
		* 获取： 店长邮箱
		*/
		public String getDianzhangEmail() {
			return dianzhangEmail;
		}
		/**
		* 设置： 店长邮箱
		*/
		public void setDianzhangEmail(String dianzhangEmail) {
			this.dianzhangEmail = dianzhangEmail;
		}

		/**
		* 获取： 店长简介
		*/
		public String getDianzhangContent() {
			return dianzhangContent;
		}
		/**
		* 设置： 店长简介
		*/
		public void setDianzhangContent(String dianzhangContent) {
			this.dianzhangContent = dianzhangContent;
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
	//级联表的get和set 驻场人员

		/**
		* 获取： 驻场人员名称
		*/
		public String getZhuchangName() {
			return zhuchangName;
		}
		/**
		* 设置： 驻场人员名称
		*/
		public void setZhuchangName(String zhuchangName) {
			this.zhuchangName = zhuchangName;
		}

		/**
		* 获取： 驻场人员手机号
		*/
		public String getZhuchangPhone() {
			return zhuchangPhone;
		}
		/**
		* 设置： 驻场人员手机号
		*/
		public void setZhuchangPhone(String zhuchangPhone) {
			this.zhuchangPhone = zhuchangPhone;
		}

		/**
		* 获取： 驻场人员头像
		*/
		public String getZhuchangPhoto() {
			return zhuchangPhoto;
		}
		/**
		* 设置： 驻场人员头像
		*/
		public void setZhuchangPhoto(String zhuchangPhoto) {
			this.zhuchangPhoto = zhuchangPhoto;
		}

		/**
		* 获取： 驻场人员邮箱
		*/
		public String getZhuchangEmail() {
			return zhuchangEmail;
		}
		/**
		* 设置： 驻场人员邮箱
		*/
		public void setZhuchangEmail(String zhuchangEmail) {
			this.zhuchangEmail = zhuchangEmail;
		}

		/**
		* 获取： 工薪
		*/
		public Double getZhuchangNewMoney() {
			return zhuchangNewMoney;
		}
		/**
		* 设置： 工薪
		*/
		public void setZhuchangNewMoney(Double zhuchangNewMoney) {
			this.zhuchangNewMoney = zhuchangNewMoney;
		}

		/**
		* 获取： 驻场人员简介
		*/
		public String getZhuchangContent() {
			return zhuchangContent;
		}
		/**
		* 设置： 驻场人员简介
		*/
		public void setZhuchangContent(String zhuchangContent) {
			this.zhuchangContent = zhuchangContent;
		}
	//级联表的get和set 管理员
		/**
		* 获取： 医院名
		*/
		public String getUusername() {
			return uusername;
		}
		/**
		* 设置： 医院名
		*/
		public void setUusername(String uusername) {
			this.uusername = uusername;
		}
		/**
		* 获取： 密码
		*/
		public String getUpassword() {
			return upassword;
		}
		/**
		* 设置： 密码
		*/
		public void setUpassword(String upassword) {
			this.upassword = upassword;
		}
		/**
		* 获取： 角色
		*/
		public String getUrole() {
			return urole;
		}
		/**
		* 设置： 角色
		*/
		public void setUrole(String urole) {
			this.urole = urole;
		}
		/**
		* 获取： 新增时间
		*/
		public Date getUaddtime() {
			return uaddtime;
		}
		/**
		* 设置： 新增时间
		*/
		public void setUaddtime(Date uaddtime) {
			this.uaddtime = uaddtime;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "ForumView{" +
			", forumStateValue=" + forumStateValue +
			", dianzhangName=" + dianzhangName +
			", dianzhangPhone=" + dianzhangPhone +
			", dianzhangPhoto=" + dianzhangPhoto +
			", dianzhangEmail=" + dianzhangEmail +
			", dianzhangContent=" + dianzhangContent +
			", qiantaiName=" + qiantaiName +
			", qiantaiPhone=" + qiantaiPhone +
			", qiantaiPhoto=" + qiantaiPhoto +
			", qiantaiEmail=" + qiantaiEmail +
			", qiantaiNewMoney=" + qiantaiNewMoney +
			", qiantaiContent=" + qiantaiContent +
			", zhuchangName=" + zhuchangName +
			", zhuchangPhone=" + zhuchangPhone +
			", zhuchangPhoto=" + zhuchangPhoto +
			", zhuchangEmail=" + zhuchangEmail +
			", zhuchangNewMoney=" + zhuchangNewMoney +
			", zhuchangContent=" + zhuchangContent +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", jiaolianName=" + jiaolianName +
			", jiaolianPhone=" + jiaolianPhone +
			", jiaolianPhoto=" + jiaolianPhoto +
			", jiaolianEmail=" + jiaolianEmail +
			", jiaolianNewMoney=" + jiaolianNewMoney +
			", jiaolianContent=" + jiaolianContent +
			"} " + super.toString();
	}
}
