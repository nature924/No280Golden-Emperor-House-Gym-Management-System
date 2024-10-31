package com.dao;

import com.entity.JianshenqichaiChuruInoutListEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JianshenqichaiChuruInoutListView;

/**
 * 出入库详情 Dao 接口
 *
 * @author 
 */
public interface JianshenqichaiChuruInoutListDao extends BaseMapper<JianshenqichaiChuruInoutListEntity> {

   List<JianshenqichaiChuruInoutListView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
