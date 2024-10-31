package com.dao;

import com.entity.ChangdiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChangdiCollectionView;

/**
 * 场地收藏 Dao 接口
 *
 * @author 
 */
public interface ChangdiCollectionDao extends BaseMapper<ChangdiCollectionEntity> {

   List<ChangdiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
