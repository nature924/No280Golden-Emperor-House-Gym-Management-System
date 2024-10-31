package com.dao;

import com.entity.JianshenkechengOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JianshenkechengOrderView;

/**
 * 课程订单 Dao 接口
 *
 * @author 
 */
public interface JianshenkechengOrderDao extends BaseMapper<JianshenkechengOrderEntity> {

   List<JianshenkechengOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
