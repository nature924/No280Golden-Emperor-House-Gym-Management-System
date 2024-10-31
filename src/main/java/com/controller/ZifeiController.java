
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
 * 资费
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zifei")
public class ZifeiController {
    private static final Logger logger = LoggerFactory.getLogger(ZifeiController.class);

    private static final String TABLE_NAME = "zifei";

    @Autowired
    private ZifeiService zifeiService;


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
        PageUtils page = zifeiService.queryPage(params);

        //字典表数据转换
        List<ZifeiView> list =(List<ZifeiView>)page.getList();
        for(ZifeiView c:list){
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
        ZifeiEntity zifei = zifeiService.selectById(id);
        if(zifei !=null){
            //entity转view
            ZifeiView view = new ZifeiView();
            BeanUtils.copyProperties( zifei , view );//把实体数据重构到view中
            //级联表 前台
            //级联表
            QiantaiEntity qiantai = qiantaiService.selectById(zifei.getQiantaiId());
            if(qiantai != null){
            BeanUtils.copyProperties( qiantai , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "qiantaiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setQiantaiId(qiantai.getId());
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
    public R save(@RequestBody ZifeiEntity zifei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zifei:{}",this.getClass().getName(),zifei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("前台".equals(role))
            zifei.setQiantaiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ZifeiEntity> queryWrapper = new EntityWrapper<ZifeiEntity>()
            .eq("zifei_name", zifei.getZifeiName())
            .eq("zifei_types", zifei.getZifeiTypes())
            .eq("qiantai_id", zifei.getQiantaiId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZifeiEntity zifeiEntity = zifeiService.selectOne(queryWrapper);
        if(zifeiEntity==null){
            zifei.setInsertTime(new Date());
            zifei.setCreateTime(new Date());
            zifeiService.insert(zifei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZifeiEntity zifei, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zifei:{}",this.getClass().getName(),zifei.toString());
        ZifeiEntity oldZifeiEntity = zifeiService.selectById(zifei.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("前台".equals(role))
//            zifei.setQiantaiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(zifei.getZifeiContent()) || "null".equals(zifei.getZifeiContent())){
                zifei.setZifeiContent(null);
        }

            zifeiService.updateById(zifei);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZifeiEntity> oldZifeiList =zifeiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        zifeiService.deleteBatchIds(Arrays.asList(ids));

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
            List<ZifeiEntity> zifeiList = new ArrayList<>();//上传的东西
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
                            ZifeiEntity zifeiEntity = new ZifeiEntity();
//                            zifeiEntity.setZifeiUuidNumber(data.get(0));                    //资费编号 要改的
//                            zifeiEntity.setZifeiName(data.get(0));                    //资费名称 要改的
//                            zifeiEntity.setZifeiTypes(Integer.valueOf(data.get(0)));   //资费类型 要改的
//                            zifeiEntity.setZifeiNewMoney(data.get(0));                    //金额 要改的
//                            zifeiEntity.setQiantaiId(Integer.valueOf(data.get(0)));   //前台 要改的
//                            zifeiEntity.setZifeiContent("");//详情和图片
//                            zifeiEntity.setInsertTime(date);//时间
//                            zifeiEntity.setCreateTime(date);//时间
                            zifeiList.add(zifeiEntity);


                            //把要查询是否重复的字段放入map中
                                //资费编号
                                if(seachFields.containsKey("zifeiUuidNumber")){
                                    List<String> zifeiUuidNumber = seachFields.get("zifeiUuidNumber");
                                    zifeiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zifeiUuidNumber = new ArrayList<>();
                                    zifeiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zifeiUuidNumber",zifeiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //资费编号
                        List<ZifeiEntity> zifeiEntities_zifeiUuidNumber = zifeiService.selectList(new EntityWrapper<ZifeiEntity>().in("zifei_uuid_number", seachFields.get("zifeiUuidNumber")));
                        if(zifeiEntities_zifeiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZifeiEntity s:zifeiEntities_zifeiUuidNumber){
                                repeatFields.add(s.getZifeiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [资费编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zifeiService.insertBatch(zifeiList);
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
        PageUtils page = zifeiService.queryPage(params);

        //字典表数据转换
        List<ZifeiView> list =(List<ZifeiView>)page.getList();
        for(ZifeiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZifeiEntity zifei = zifeiService.selectById(id);
            if(zifei !=null){


                //entity转view
                ZifeiView view = new ZifeiView();
                BeanUtils.copyProperties( zifei , view );//把实体数据重构到view中

                //级联表
                    QiantaiEntity qiantai = qiantaiService.selectById(zifei.getQiantaiId());
                if(qiantai != null){
                    BeanUtils.copyProperties( qiantai , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "qiantaiId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setQiantaiId(qiantai.getId());
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
    public R add(@RequestBody ZifeiEntity zifei, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zifei:{}",this.getClass().getName(),zifei.toString());
        Wrapper<ZifeiEntity> queryWrapper = new EntityWrapper<ZifeiEntity>()
            .eq("zifei_uuid_number", zifei.getZifeiUuidNumber())
            .eq("zifei_name", zifei.getZifeiName())
            .eq("zifei_types", zifei.getZifeiTypes())
            .eq("qiantai_id", zifei.getQiantaiId())
//            .notIn("zifei_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZifeiEntity zifeiEntity = zifeiService.selectOne(queryWrapper);
        if(zifeiEntity==null){
            zifei.setInsertTime(new Date());
            zifei.setCreateTime(new Date());
        zifeiService.insert(zifei);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

