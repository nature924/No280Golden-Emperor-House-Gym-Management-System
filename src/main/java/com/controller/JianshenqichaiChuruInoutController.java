
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
 * 出入库
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jianshenqichaiChuruInout")
public class JianshenqichaiChuruInoutController {
    private static final Logger logger = LoggerFactory.getLogger(JianshenqichaiChuruInoutController.class);

    private static final String TABLE_NAME = "jianshenqichaiChuruInout";

    @Autowired
    private JianshenqichaiChuruInoutService jianshenqichaiChuruInoutService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChangdiService changdiService;//场地信息
    @Autowired
    private ChangdiCollectionService changdiCollectionService;//场地收藏
    @Autowired
    private ChangdiLiuyanService changdiLiuyanService;//场地留言
    @Autowired
    private ChangdiYuyueService changdiYuyueService;//场地预约申请
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
        PageUtils page = jianshenqichaiChuruInoutService.queryPage(params);

        //字典表数据转换
        List<JianshenqichaiChuruInoutView> list =(List<JianshenqichaiChuruInoutView>)page.getList();
        for(JianshenqichaiChuruInoutView c:list){
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
        JianshenqichaiChuruInoutEntity jianshenqichaiChuruInout = jianshenqichaiChuruInoutService.selectById(id);
        if(jianshenqichaiChuruInout !=null){
            //entity转view
            JianshenqichaiChuruInoutView view = new JianshenqichaiChuruInoutView();
            BeanUtils.copyProperties( jianshenqichaiChuruInout , view );//把实体数据重构到view中
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
    public R save(@RequestBody JianshenqichaiChuruInoutEntity jianshenqichaiChuruInout, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jianshenqichaiChuruInout:{}",this.getClass().getName(),jianshenqichaiChuruInout.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JianshenqichaiChuruInoutEntity> queryWrapper = new EntityWrapper<JianshenqichaiChuruInoutEntity>()
            .eq("jianshenqichai_churu_inout_name", jianshenqichaiChuruInout.getJianshenqichaiChuruInoutName())
            .eq("jianshenqichai_churu_inout_types", jianshenqichaiChuruInout.getJianshenqichaiChuruInoutTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JianshenqichaiChuruInoutEntity jianshenqichaiChuruInoutEntity = jianshenqichaiChuruInoutService.selectOne(queryWrapper);
        if(jianshenqichaiChuruInoutEntity==null){
            jianshenqichaiChuruInout.setInsertTime(new Date());
            jianshenqichaiChuruInout.setCreateTime(new Date());
            jianshenqichaiChuruInoutService.insert(jianshenqichaiChuruInout);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JianshenqichaiChuruInoutEntity jianshenqichaiChuruInout, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jianshenqichaiChuruInout:{}",this.getClass().getName(),jianshenqichaiChuruInout.toString());
        JianshenqichaiChuruInoutEntity oldJianshenqichaiChuruInoutEntity = jianshenqichaiChuruInoutService.selectById(jianshenqichaiChuruInout.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(jianshenqichaiChuruInout.getJianshenqichaiChuruInoutContent()) || "null".equals(jianshenqichaiChuruInout.getJianshenqichaiChuruInoutContent())){
                jianshenqichaiChuruInout.setJianshenqichaiChuruInoutContent(null);
        }

            jianshenqichaiChuruInoutService.updateById(jianshenqichaiChuruInout);//根据id更新
            return R.ok();
    }


    /**
    * 出库
    */
    @RequestMapping("/outJianshenqichaiChuruInoutList")
    public R outJianshenqichaiChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("outJianshenqichaiChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取出入库名称并判断是否存在
        String jianshenqichaiChuruInoutName = String.valueOf(params.get("jianshenqichaiChuruInoutName"));
        Wrapper<JianshenqichaiChuruInoutEntity> queryWrapper = new EntityWrapper<JianshenqichaiChuruInoutEntity>()
            .eq("jianshenqichai_churu_inout_name", jianshenqichaiChuruInoutName)
            ;
        JianshenqichaiChuruInoutEntity jianshenqichaiChuruInoutSelectOne = jianshenqichaiChuruInoutService.selectOne(queryWrapper);
        if(jianshenqichaiChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");



        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");


        Set<String> ids = map.keySet();

        List<JianshenqichaiEntity> jianshenqichaiList = jianshenqichaiService.selectBatchIds(ids);
        if(jianshenqichaiList == null || jianshenqichaiList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(JianshenqichaiEntity w:jianshenqichaiList){
                Integer value = w.getJianshenqichaiKucunNumber()-map.get(String.valueOf(w.getId()));
                if(value <0){
                    return R.error(511,"出库数量大于库存数量");
                }
                w.setJianshenqichaiKucunNumber(value);
            }
        }

        //当前表
        JianshenqichaiChuruInoutEntity jianshenqichaiChuruInoutEntity = new JianshenqichaiChuruInoutEntity<>();
            jianshenqichaiChuruInoutEntity.setJianshenqichaiChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            jianshenqichaiChuruInoutEntity.setJianshenqichaiChuruInoutName(jianshenqichaiChuruInoutName);
            jianshenqichaiChuruInoutEntity.setJianshenqichaiChuruInoutTypes(1);
            jianshenqichaiChuruInoutEntity.setJianshenqichaiChuruInoutContent("");
            jianshenqichaiChuruInoutEntity.setInsertTime(new Date());
            jianshenqichaiChuruInoutEntity.setCreateTime(new Date());

        boolean insertJianshenqichaiChuruInout = jianshenqichaiChuruInoutService.insert(jianshenqichaiChuruInoutEntity);
        //list表
        ArrayList<JianshenqichaiChuruInoutListEntity> jianshenqichaiChuruInoutLists = new ArrayList<>();
        if(insertJianshenqichaiChuruInout){
            for(String id:ids){
                JianshenqichaiChuruInoutListEntity jianshenqichaiChuruInoutListEntity = new JianshenqichaiChuruInoutListEntity();
                    jianshenqichaiChuruInoutListEntity.setJianshenqichaiChuruInoutId(jianshenqichaiChuruInoutEntity.getId());
                    jianshenqichaiChuruInoutListEntity.setJianshenqichaiId(Integer.valueOf(id));
                    jianshenqichaiChuruInoutListEntity.setJianshenqichaiChuruInoutListNumber(map.get(id));
                    jianshenqichaiChuruInoutListEntity.setInsertTime(new Date());
                    jianshenqichaiChuruInoutListEntity.setCreateTime(new Date());
                jianshenqichaiChuruInoutLists.add(jianshenqichaiChuruInoutListEntity);
                jianshenqichaiService.updateBatchById(jianshenqichaiList);
            }
            jianshenqichaiChuruInoutListService.insertBatch(jianshenqichaiChuruInoutLists);
        }

        return R.ok();
    }

    /**
    *入库
    */
    @RequestMapping("/inJianshenqichaiChuruInoutList")
    public R inJianshenqichaiChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("inJianshenqichaiChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        //params:{"map":{"1":2,"2":3},"wuziOutinName":"订单1"}

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取当前表名称并判断
        String jianshenqichaiChuruInoutName = String.valueOf(params.get("jianshenqichaiChuruInoutName"));
        Wrapper<JianshenqichaiChuruInoutEntity> queryWrapper = new EntityWrapper<JianshenqichaiChuruInoutEntity>()
            .eq("jianshenqichai_churu_inout_name", jianshenqichaiChuruInoutName)
            ;
        JianshenqichaiChuruInoutEntity jianshenqichaiChuruInoutSelectOne = jianshenqichaiChuruInoutService.selectOne(queryWrapper);
        if(jianshenqichaiChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");


        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");

        Set<String> ids = map.keySet();

        List<JianshenqichaiEntity> jianshenqichaiList = jianshenqichaiService.selectBatchIds(ids);
        if(jianshenqichaiList == null || jianshenqichaiList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(JianshenqichaiEntity w:jianshenqichaiList){
                w.setJianshenqichaiKucunNumber(w.getJianshenqichaiKucunNumber()+map.get(String.valueOf(w.getId())));
            }
        }

        //当前表
        JianshenqichaiChuruInoutEntity jianshenqichaiChuruInoutEntity = new JianshenqichaiChuruInoutEntity<>();
            jianshenqichaiChuruInoutEntity.setJianshenqichaiChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            jianshenqichaiChuruInoutEntity.setJianshenqichaiChuruInoutName(jianshenqichaiChuruInoutName);
            jianshenqichaiChuruInoutEntity.setJianshenqichaiChuruInoutTypes(2);
            jianshenqichaiChuruInoutEntity.setJianshenqichaiChuruInoutContent("");
            jianshenqichaiChuruInoutEntity.setInsertTime(new Date());
            jianshenqichaiChuruInoutEntity.setCreateTime(new Date());


        boolean insertJianshenqichaiChuruInout = jianshenqichaiChuruInoutService.insert(jianshenqichaiChuruInoutEntity);
        //list表
        ArrayList<JianshenqichaiChuruInoutListEntity> jianshenqichaiChuruInoutLists = new ArrayList<>();
        if(insertJianshenqichaiChuruInout){
            for(String id:ids){
                JianshenqichaiChuruInoutListEntity jianshenqichaiChuruInoutListEntity = new JianshenqichaiChuruInoutListEntity();
                jianshenqichaiChuruInoutListEntity.setJianshenqichaiChuruInoutId(jianshenqichaiChuruInoutEntity.getId());
                jianshenqichaiChuruInoutListEntity.setJianshenqichaiId(Integer.valueOf(id));
                jianshenqichaiChuruInoutListEntity.setJianshenqichaiChuruInoutListNumber(map.get(id));
                jianshenqichaiChuruInoutListEntity.setInsertTime(new Date());
                jianshenqichaiChuruInoutListEntity.setCreateTime(new Date());
                jianshenqichaiChuruInoutLists.add(jianshenqichaiChuruInoutListEntity);
                jianshenqichaiService.updateBatchById(jianshenqichaiList);
            }
            jianshenqichaiChuruInoutListService.insertBatch(jianshenqichaiChuruInoutLists);
        }

        return R.ok();
    }
    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JianshenqichaiChuruInoutEntity> oldJianshenqichaiChuruInoutList =jianshenqichaiChuruInoutService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jianshenqichaiChuruInoutService.deleteBatchIds(Arrays.asList(ids));
        jianshenqichaiChuruInoutListService.delete(new EntityWrapper<JianshenqichaiChuruInoutListEntity>().in("jianshenqichai_churu_inout_id",ids));

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
            List<JianshenqichaiChuruInoutEntity> jianshenqichaiChuruInoutList = new ArrayList<>();//上传的东西
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
                            JianshenqichaiChuruInoutEntity jianshenqichaiChuruInoutEntity = new JianshenqichaiChuruInoutEntity();
//                            jianshenqichaiChuruInoutEntity.setJianshenqichaiChuruInoutUuidNumber(data.get(0));                    //出入库流水号 要改的
//                            jianshenqichaiChuruInoutEntity.setJianshenqichaiChuruInoutName(data.get(0));                    //出入库名称 要改的
//                            jianshenqichaiChuruInoutEntity.setJianshenqichaiChuruInoutTypes(Integer.valueOf(data.get(0)));   //出入库类型 要改的
//                            jianshenqichaiChuruInoutEntity.setJianshenqichaiChuruInoutContent("");//详情和图片
//                            jianshenqichaiChuruInoutEntity.setInsertTime(date);//时间
//                            jianshenqichaiChuruInoutEntity.setCreateTime(date);//时间
                            jianshenqichaiChuruInoutList.add(jianshenqichaiChuruInoutEntity);


                            //把要查询是否重复的字段放入map中
                                //出入库流水号
                                if(seachFields.containsKey("jianshenqichaiChuruInoutUuidNumber")){
                                    List<String> jianshenqichaiChuruInoutUuidNumber = seachFields.get("jianshenqichaiChuruInoutUuidNumber");
                                    jianshenqichaiChuruInoutUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jianshenqichaiChuruInoutUuidNumber = new ArrayList<>();
                                    jianshenqichaiChuruInoutUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jianshenqichaiChuruInoutUuidNumber",jianshenqichaiChuruInoutUuidNumber);
                                }
                        }

                        //查询是否重复
                         //出入库流水号
                        List<JianshenqichaiChuruInoutEntity> jianshenqichaiChuruInoutEntities_jianshenqichaiChuruInoutUuidNumber = jianshenqichaiChuruInoutService.selectList(new EntityWrapper<JianshenqichaiChuruInoutEntity>().in("jianshenqichai_churu_inout_uuid_number", seachFields.get("jianshenqichaiChuruInoutUuidNumber")));
                        if(jianshenqichaiChuruInoutEntities_jianshenqichaiChuruInoutUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JianshenqichaiChuruInoutEntity s:jianshenqichaiChuruInoutEntities_jianshenqichaiChuruInoutUuidNumber){
                                repeatFields.add(s.getJianshenqichaiChuruInoutUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [出入库流水号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jianshenqichaiChuruInoutService.insertBatch(jianshenqichaiChuruInoutList);
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
        PageUtils page = jianshenqichaiChuruInoutService.queryPage(params);

        //字典表数据转换
        List<JianshenqichaiChuruInoutView> list =(List<JianshenqichaiChuruInoutView>)page.getList();
        for(JianshenqichaiChuruInoutView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JianshenqichaiChuruInoutEntity jianshenqichaiChuruInout = jianshenqichaiChuruInoutService.selectById(id);
            if(jianshenqichaiChuruInout !=null){


                //entity转view
                JianshenqichaiChuruInoutView view = new JianshenqichaiChuruInoutView();
                BeanUtils.copyProperties( jianshenqichaiChuruInout , view );//把实体数据重构到view中

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
    public R add(@RequestBody JianshenqichaiChuruInoutEntity jianshenqichaiChuruInout, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jianshenqichaiChuruInout:{}",this.getClass().getName(),jianshenqichaiChuruInout.toString());
        Wrapper<JianshenqichaiChuruInoutEntity> queryWrapper = new EntityWrapper<JianshenqichaiChuruInoutEntity>()
            .eq("jianshenqichai_churu_inout_uuid_number", jianshenqichaiChuruInout.getJianshenqichaiChuruInoutUuidNumber())
            .eq("jianshenqichai_churu_inout_name", jianshenqichaiChuruInout.getJianshenqichaiChuruInoutName())
            .eq("jianshenqichai_churu_inout_types", jianshenqichaiChuruInout.getJianshenqichaiChuruInoutTypes())
//            .notIn("jianshenqichai_churu_inout_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JianshenqichaiChuruInoutEntity jianshenqichaiChuruInoutEntity = jianshenqichaiChuruInoutService.selectOne(queryWrapper);
        if(jianshenqichaiChuruInoutEntity==null){
            jianshenqichaiChuruInout.setInsertTime(new Date());
            jianshenqichaiChuruInout.setCreateTime(new Date());
        jianshenqichaiChuruInoutService.insert(jianshenqichaiChuruInout);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

