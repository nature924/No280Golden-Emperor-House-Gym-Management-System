package com.dao;

import com.entity.JianshenkechengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JianshenkechengView;

/**
 * 健身课程 Dao 接口
 *
 * @author 
 */
public interface JianshenkechengDao extends BaseMapper<JianshenkechengEntity> {

   List<JianshenkechengView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
