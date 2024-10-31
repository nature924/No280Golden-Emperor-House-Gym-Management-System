package com.dao;

import com.entity.JiaolianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaolianView;

/**
 * 教练 Dao 接口
 *
 * @author 
 */
public interface JiaolianDao extends BaseMapper<JiaolianEntity> {

   List<JiaolianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
