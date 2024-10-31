package com.dao;

import com.entity.ChangdiLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChangdiLiuyanView;

/**
 * 场地留言 Dao 接口
 *
 * @author 
 */
public interface ChangdiLiuyanDao extends BaseMapper<ChangdiLiuyanEntity> {

   List<ChangdiLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
