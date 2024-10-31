
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
 * 课程留言
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jianshenkechengLiuyan")
public class JianshenkechengLiuyanController {
    private static final Logger logger = LoggerFactory.getLogger(JianshenkechengLiuyanController.class);

    private static final String TABLE_NAME = "jianshenkechengLiuyan";

    @Autowired
    private JianshenkechengLiuyanService jianshenkechengLiuyanService;


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
        PageUtils page = jianshenkechengLiuyanService.queryPage(params);

        //字典表数据转换
        List<JianshenkechengLiuyanView> list =(List<JianshenkechengLiuyanView>)page.getList();
        for(JianshenkechengLiuyanView c:list){
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
        JianshenkechengLiuyanEntity jianshenkechengLiuyan = jianshenkechengLiuyanService.selectById(id);
        if(jianshenkechengLiuyan !=null){
            //entity转view
            JianshenkechengLiuyanView view = new JianshenkechengLiuyanView();
            BeanUtils.copyProperties( jianshenkechengLiuyan , view );//把实体数据重构到view中
            //级联表 健身课程
            //级联表
            JianshenkechengEntity jianshenkecheng = jianshenkechengService.selectById(jianshenkechengLiuyan.getJianshenkechengId());
            if(jianshenkecheng != null){
            BeanUtils.copyProperties( jianshenkecheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJianshenkechengId(jianshenkecheng.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jianshenkechengLiuyan.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody JianshenkechengLiuyanEntity jianshenkechengLiuyan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jianshenkechengLiuyan:{}",this.getClass().getName(),jianshenkechengLiuyan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            jianshenkechengLiuyan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        jianshenkechengLiuyan.setCreateTime(new Date());
        jianshenkechengLiuyan.setInsertTime(new Date());
        jianshenkechengLiuyanService.insert(jianshenkechengLiuyan);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JianshenkechengLiuyanEntity jianshenkechengLiuyan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jianshenkechengLiuyan:{}",this.getClass().getName(),jianshenkechengLiuyan.toString());
        JianshenkechengLiuyanEntity oldJianshenkechengLiuyanEntity = jianshenkechengLiuyanService.selectById(jianshenkechengLiuyan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            jianshenkechengLiuyan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jianshenkechengLiuyan.getJianshenkechengLiuyanText()) || "null".equals(jianshenkechengLiuyan.getJianshenkechengLiuyanText())){
                jianshenkechengLiuyan.setJianshenkechengLiuyanText(null);
        }
        if("".equals(jianshenkechengLiuyan.getReplyText()) || "null".equals(jianshenkechengLiuyan.getReplyText())){
                jianshenkechengLiuyan.setReplyText(null);
        }
        jianshenkechengLiuyan.setUpdateTime(new Date());

            jianshenkechengLiuyanService.updateById(jianshenkechengLiuyan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JianshenkechengLiuyanEntity> oldJianshenkechengLiuyanList =jianshenkechengLiuyanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jianshenkechengLiuyanService.deleteBatchIds(Arrays.asList(ids));

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
            List<JianshenkechengLiuyanEntity> jianshenkechengLiuyanList = new ArrayList<>();//上传的东西
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
                            JianshenkechengLiuyanEntity jianshenkechengLiuyanEntity = new JianshenkechengLiuyanEntity();
//                            jianshenkechengLiuyanEntity.setJianshenkechengId(Integer.valueOf(data.get(0)));   //健身课程 要改的
//                            jianshenkechengLiuyanEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jianshenkechengLiuyanEntity.setJianshenkechengLiuyanText(data.get(0));                    //留言内容 要改的
//                            jianshenkechengLiuyanEntity.setInsertTime(date);//时间
//                            jianshenkechengLiuyanEntity.setReplyText(data.get(0));                    //回复内容 要改的
//                            jianshenkechengLiuyanEntity.setUpdateTime(sdf.parse(data.get(0)));          //回复时间 要改的
//                            jianshenkechengLiuyanEntity.setCreateTime(date);//时间
                            jianshenkechengLiuyanList.add(jianshenkechengLiuyanEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        jianshenkechengLiuyanService.insertBatch(jianshenkechengLiuyanList);
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
        PageUtils page = jianshenkechengLiuyanService.queryPage(params);

        //字典表数据转换
        List<JianshenkechengLiuyanView> list =(List<JianshenkechengLiuyanView>)page.getList();
        for(JianshenkechengLiuyanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JianshenkechengLiuyanEntity jianshenkechengLiuyan = jianshenkechengLiuyanService.selectById(id);
            if(jianshenkechengLiuyan !=null){


                //entity转view
                JianshenkechengLiuyanView view = new JianshenkechengLiuyanView();
                BeanUtils.copyProperties( jianshenkechengLiuyan , view );//把实体数据重构到view中

                //级联表
                    JianshenkechengEntity jianshenkecheng = jianshenkechengService.selectById(jianshenkechengLiuyan.getJianshenkechengId());
                if(jianshenkecheng != null){
                    BeanUtils.copyProperties( jianshenkecheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJianshenkechengId(jianshenkecheng.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jianshenkechengLiuyan.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
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
    public R add(@RequestBody JianshenkechengLiuyanEntity jianshenkechengLiuyan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jianshenkechengLiuyan:{}",this.getClass().getName(),jianshenkechengLiuyan.toString());
        jianshenkechengLiuyan.setCreateTime(new Date());
        jianshenkechengLiuyan.setInsertTime(new Date());
        jianshenkechengLiuyanService.insert(jianshenkechengLiuyan);

            return R.ok();
        }

}

