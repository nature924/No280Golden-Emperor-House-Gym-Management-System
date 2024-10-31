package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.JianshenkechengLiuyanDao;
import com.entity.JianshenkechengLiuyanEntity;
import com.service.JianshenkechengLiuyanService;
import com.entity.view.JianshenkechengLiuyanView;

/**
 * 课程留言 服务实现类
 */
@Service("jianshenkechengLiuyanService")
@Transactional
public class JianshenkechengLiuyanServiceImpl extends ServiceImpl<JianshenkechengLiuyanDao, JianshenkechengLiuyanEntity> implements JianshenkechengLiuyanService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<JianshenkechengLiuyanView> page =new Query<JianshenkechengLiuyanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
