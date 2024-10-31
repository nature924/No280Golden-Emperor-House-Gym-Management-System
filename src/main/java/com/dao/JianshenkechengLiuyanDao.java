package com.dao;

import com.entity.JianshenkechengLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JianshenkechengLiuyanView;

/**
 * 课程留言 Dao 接口
 *
 * @author 
 */
public interface JianshenkechengLiuyanDao extends BaseMapper<JianshenkechengLiuyanEntity> {

   List<JianshenkechengLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
