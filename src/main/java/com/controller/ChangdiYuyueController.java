
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 场地预约申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/changdiYuyue")
public class ChangdiYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(ChangdiYuyueController.class);

    private static final String TABLE_NAME = "changdiYuyue";

    @Autowired
    private ChangdiYuyueService changdiYuyueService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChangdiService changdiService;//场地信息
    @Autowired
    private ChangdiCollectionService changdiCollectionService;//场地收藏
    @Autowired
    private ChangdiLiuyanService changdiLiuyanService;//场地留言
    @Autowired
    private DianzhangService dianzhangService;//店长
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//交流论坛
    @Autowired
    private JianshenkechengService jianshenkechengService;//健身课程
    @Autowired
    private JianshenkechengCollectionService jianshenkechengCollectionService;//课程收藏
    @Autowired
    private JianshenkechengLiuyanService jianshenkechengLiuyanService;//课程留言
    @Autowired
    private JianshenkechengOrderService jianshenkechengOrderService;//课程订单
    @Autowired
    private JianshenqichaiService jianshenqichaiService;//健身器材
    @Autowired
    private JianshenqichaiChuruInoutService jianshenqichaiChuruInoutService;//出入库
    @Autowired
    private JianshenqichaiChuruInoutListService jianshenqichaiChuruInoutListService;//出入库详情
    @Autowired
    private JiaolianService jiaolianService;//教练
    @Autowired
    private NewsService newsService;//公告通知
    @Autowired
    private QiantaiService qiantaiService;//前台
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZhuchangService zhuchangService;//驻场人员
    @Autowired
    private ZifeiService zifeiService;//资费
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("店长".equals(role))
            params.put("dianzhangId",request.getSession().getAttribute("userId"));
        else if("教练".equals(role))
            params.put("jiaolianId",request.getSession().getAttribute("userId"));
        else if("前台".equals(role))
            params.put("qiantaiId",request.getSession().getAttribute("userId"));
        else if("驻场人员".equals(role))
            params.put("zhuchangId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = changdiYuyueService.queryPage(params);

        //字典表数据转换
        List<ChangdiYuyueView> list =(List<ChangdiYuyueView>)page.getList();
        for(ChangdiYuyueView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChangdiYuyueEntity changdiYuyue = changdiYuyueService.selectById(id);
        if(changdiYuyue !=null){
            //entity转view
            ChangdiYuyueView view = new ChangdiYuyueView();
            BeanUtils.copyProperties( changdiYuyue , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(changdiYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 场地信息
            //级联表
            ChangdiEntity changdi = changdiService.selectById(changdiYuyue.getChangdiId());
            if(changdi != null){
            BeanUtils.copyProperties( changdi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setChangdiId(changdi.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChangdiYuyueEntity changdiYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,changdiYuyue:{}",this.getClass().getName(),changdiYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            changdiYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ChangdiYuyueEntity> queryWrapper = new EntityWrapper<ChangdiYuyueEntity>()
            .eq("yonghu_id", changdiYuyue.getYonghuId())
            .eq("changdi_id", changdiYuyue.getChangdiId())
            .in("changdi_yuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChangdiYuyueEntity changdiYuyueEntity = changdiYuyueService.selectOne(queryWrapper);
        if(changdiYuyueEntity==null){
            changdiYuyue.setChangdiYuyueYesnoTypes(1);
            changdiYuyue.setInsertTime(new Date());
            changdiYuyue.setCreateTime(new Date());
            changdiYuyueService.insert(changdiYuyue);
            return R.ok();
        }else {
            if(changdiYuyueEntity.getChangdiYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(changdiYuyueEntity.getChangdiYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChangdiYuyueEntity changdiYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,changdiYuyue:{}",this.getClass().getName(),changdiYuyue.toString());
        ChangdiYuyueEntity oldChangdiYuyueEntity = changdiYuyueService.selectById(changdiYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            changdiYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(changdiYuyue.getSheshiyuyueText()) || "null".equals(changdiYuyue.getSheshiyuyueText())){
                changdiYuyue.setSheshiyuyueText(null);
        }
        if("".equals(changdiYuyue.getChangdiYuyueYesnoText()) || "null".equals(changdiYuyue.getChangdiYuyueYesnoText())){
                changdiYuyue.setChangdiYuyueYesnoText(null);
        }

            changdiYuyueService.updateById(changdiYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody ChangdiYuyueEntity changdiYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,changdiYuyueEntity:{}",this.getClass().getName(),changdiYuyueEntity.toString());

        ChangdiYuyueEntity oldChangdiYuyue = changdiYuyueService.selectById(changdiYuyueEntity.getId());//查询原先数据

        if(changdiYuyueEntity.getChangdiYuyueYesnoTypes() == 2){//通过
            Long tim =  (oldChangdiYuyue.getChangdiYuyueTime().getTime() - oldChangdiYuyue.getChangdiJieshuTime().getTime())/1000/60;
            if(tim>0){
                YonghuEntity yonghuEntity = yonghuService.selectById(oldChangdiYuyue.getYonghuId());
                double v = tim * changdiService.selectById(oldChangdiYuyue.getChangdiId()).getChangdiNewMoney();
                if(yonghuEntity.getNewMoney() < v){
                    return R.error("余额不足请充值");
                }
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - v);
                yonghuService.updateById(yonghuEntity);
            }
        }
        changdiYuyueService.updateById(changdiYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChangdiYuyueEntity> oldChangdiYuyueList =changdiYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        changdiYuyueService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<ChangdiYuyueEntity> changdiYuyueList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ChangdiYuyueEntity changdiYuyueEntity = new ChangdiYuyueEntity();
//                            changdiYuyueEntity.setChangdiYuyueUuidNumber(data.get(0));                    //预约编号 要改的
//                            changdiYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            changdiYuyueEntity.setChangdiId(Integer.valueOf(data.get(0)));   //场地 要改的
//                            changdiYuyueEntity.setSheshiyuyueText(data.get(0));                    //备注 要改的
//                            changdiYuyueEntity.setChangdiYuyueTime(sdf.parse(data.get(0)));          //开始时间 要改的
//                            changdiYuyueEntity.setChangdiJieshuTime(sdf.parse(data.get(0)));          //结束时间 要改的
//                            changdiYuyueEntity.setChangdiYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //预约状态 要改的
//                            changdiYuyueEntity.setChangdiYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            changdiYuyueEntity.setInsertTime(date);//时间
//                            changdiYuyueEntity.setCreateTime(date);//时间
                            changdiYuyueList.add(changdiYuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //预约编号
                                if(seachFields.containsKey("changdiYuyueUuidNumber")){
                                    List<String> changdiYuyueUuidNumber = seachFields.get("changdiYuyueUuidNumber");
                                    changdiYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> changdiYuyueUuidNumber = new ArrayList<>();
                                    changdiYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("changdiYuyueUuidNumber",changdiYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //预约编号
                        List<ChangdiYuyueEntity> changdiYuyueEntities_changdiYuyueUuidNumber = changdiYuyueService.selectList(new EntityWrapper<ChangdiYuyueEntity>().in("changdi_yuyue_uuid_number", seachFields.get("changdiYuyueUuidNumber")));
                        if(changdiYuyueEntities_changdiYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChangdiYuyueEntity s:changdiYuyueEntities_changdiYuyueUuidNumber){
                                repeatFields.add(s.getChangdiYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [预约编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        changdiYuyueService.insertBatch(changdiYuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = changdiYuyueService.queryPage(params);

        //字典表数据转换
        List<ChangdiYuyueView> list =(List<ChangdiYuyueView>)page.getList();
        for(ChangdiYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChangdiYuyueEntity changdiYuyue = changdiYuyueService.selectById(id);
            if(changdiYuyue !=null){


                //entity转view
                ChangdiYuyueView view = new ChangdiYuyueView();
                BeanUtils.copyProperties( changdiYuyue , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(changdiYuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    ChangdiEntity changdi = changdiService.selectById(changdiYuyue.getChangdiId());
                if(changdi != null){
                    BeanUtils.copyProperties( changdi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChangdiId(changdi.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ChangdiYuyueEntity changdiYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,changdiYuyue:{}",this.getClass().getName(),changdiYuyue.toString());
        Wrapper<ChangdiYuyueEntity> queryWrapper = new EntityWrapper<ChangdiYuyueEntity>()
            .eq("changdi_yuyue_uuid_number", changdiYuyue.getChangdiYuyueUuidNumber())
            .eq("yonghu_id", changdiYuyue.getYonghuId())
            .eq("changdi_id", changdiYuyue.getChangdiId())
            .eq("sheshiyuyue_text", changdiYuyue.getSheshiyuyueText())
            .in("changdi_yuyue_yesno_types", new Integer[]{1,2})
            .eq("changdi_yuyue_yesno_text", changdiYuyue.getChangdiYuyueYesnoText())
//            .notIn("changdi_yuyue_types", new Integer[]{102})
            ;
        if(changdiYuyue.getChangdiYuyueTime().getTime() > changdiYuyue.getChangdiJieshuTime().getTime()){
            return R.error("开始时间不能大于结束时间");
        }
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChangdiYuyueEntity changdiYuyueEntity = changdiYuyueService.selectOne(queryWrapper);
        if(changdiYuyueEntity==null){
            changdiYuyue.setChangdiYuyueYesnoTypes(1);
            changdiYuyue.setInsertTime(new Date());
            changdiYuyue.setCreateTime(new Date());
        changdiYuyueService.insert(changdiYuyue);

            return R.ok();
        }else {
            if(changdiYuyueEntity.getChangdiYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(changdiYuyueEntity.getChangdiYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

