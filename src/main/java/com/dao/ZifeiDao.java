package com.dao;

import com.entity.ZifeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZifeiView;

/**
 * 资费 Dao 接口
 *
 * @author 
 */
public interface ZifeiDao extends BaseMapper<ZifeiEntity> {

   List<ZifeiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
