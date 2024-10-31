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
import com.dao.ChangdiYuyueDao;
import com.entity.ChangdiYuyueEntity;
import com.service.ChangdiYuyueService;
import com.entity.view.ChangdiYuyueView;

/**
 * 场地预约申请 服务实现类
 */
@Service("changdiYuyueService")
@Transactional
public class ChangdiYuyueServiceImpl extends ServiceImpl<ChangdiYuyueDao, ChangdiYuyueEntity> implements ChangdiYuyueService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<ChangdiYuyueView> page =new Query<ChangdiYuyueView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
