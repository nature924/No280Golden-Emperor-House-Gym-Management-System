package com.dao;

import com.entity.ZhuchangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhuchangView;

/**
 * 驻场人员 Dao 接口
 *
 * @author 
 */
public interface ZhuchangDao extends BaseMapper<ZhuchangEntity> {

   List<ZhuchangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
