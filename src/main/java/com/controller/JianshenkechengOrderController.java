
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
 * 课程订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jianshenkechengOrder")
public class JianshenkechengOrderController {
    private static final Logger logger = LoggerFactory.getLogger(JianshenkechengOrderController.class);

    private static final String TABLE_NAME = "jianshenkechengOrder";

    @Autowired
    private JianshenkechengOrderService jianshenkechengOrderService;


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
        PageUtils page = jianshenkechengOrderService.queryPage(params);

        //字典表数据转换
        List<JianshenkechengOrderView> list =(List<JianshenkechengOrderView>)page.getList();
        for(JianshenkechengOrderView c:list){
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
        JianshenkechengOrderEntity jianshenkechengOrder = jianshenkechengOrderService.selectById(id);
        if(jianshenkechengOrder !=null){
            //entity转view
            JianshenkechengOrderView view = new JianshenkechengOrderView();
            BeanUtils.copyProperties( jianshenkechengOrder , view );//把实体数据重构到view中
            //级联表 健身课程
            //级联表
            JianshenkechengEntity jianshenkecheng = jianshenkechengService.selectById(jianshenkechengOrder.getJianshenkechengId());
            if(jianshenkecheng != null){
            BeanUtils.copyProperties( jianshenkecheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJianshenkechengId(jianshenkecheng.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jianshenkechengOrder.getYonghuId());
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
    public R save(@RequestBody JianshenkechengOrderEntity jianshenkechengOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jianshenkechengOrder:{}",this.getClass().getName(),jianshenkechengOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            jianshenkechengOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        jianshenkechengOrder.setCreateTime(new Date());
        jianshenkechengOrder.setInsertTime(new Date());
        jianshenkechengOrderService.insert(jianshenkechengOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JianshenkechengOrderEntity jianshenkechengOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jianshenkechengOrder:{}",this.getClass().getName(),jianshenkechengOrder.toString());
        JianshenkechengOrderEntity oldJianshenkechengOrderEntity = jianshenkechengOrderService.selectById(jianshenkechengOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            jianshenkechengOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            jianshenkechengOrderService.updateById(jianshenkechengOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JianshenkechengOrderEntity> oldJianshenkechengOrderList =jianshenkechengOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jianshenkechengOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<JianshenkechengOrderEntity> jianshenkechengOrderList = new ArrayList<>();//上传的东西
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
                            JianshenkechengOrderEntity jianshenkechengOrderEntity = new JianshenkechengOrderEntity();
//                            jianshenkechengOrderEntity.setJianshenkechengOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            jianshenkechengOrderEntity.setJianshenkechengId(Integer.valueOf(data.get(0)));   //健身课程 要改的
//                            jianshenkechengOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jianshenkechengOrderEntity.setJianshenkechengOrderTime(sdf.parse(data.get(0)));          //预约日期 要改的
//                            jianshenkechengOrderEntity.setJianshenkechengOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            jianshenkechengOrderEntity.setJianshenkechengOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            jianshenkechengOrderEntity.setJianshenkechengOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            jianshenkechengOrderEntity.setInsertTime(date);//时间
//                            jianshenkechengOrderEntity.setCreateTime(date);//时间
                            jianshenkechengOrderList.add(jianshenkechengOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("jianshenkechengOrderUuidNumber")){
                                    List<String> jianshenkechengOrderUuidNumber = seachFields.get("jianshenkechengOrderUuidNumber");
                                    jianshenkechengOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jianshenkechengOrderUuidNumber = new ArrayList<>();
                                    jianshenkechengOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jianshenkechengOrderUuidNumber",jianshenkechengOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<JianshenkechengOrderEntity> jianshenkechengOrderEntities_jianshenkechengOrderUuidNumber = jianshenkechengOrderService.selectList(new EntityWrapper<JianshenkechengOrderEntity>().in("jianshenkecheng_order_uuid_number", seachFields.get("jianshenkechengOrderUuidNumber")));
                        if(jianshenkechengOrderEntities_jianshenkechengOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JianshenkechengOrderEntity s:jianshenkechengOrderEntities_jianshenkechengOrderUuidNumber){
                                repeatFields.add(s.getJianshenkechengOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jianshenkechengOrderService.insertBatch(jianshenkechengOrderList);
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
        PageUtils page = jianshenkechengOrderService.queryPage(params);

        //字典表数据转换
        List<JianshenkechengOrderView> list =(List<JianshenkechengOrderView>)page.getList();
        for(JianshenkechengOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JianshenkechengOrderEntity jianshenkechengOrder = jianshenkechengOrderService.selectById(id);
            if(jianshenkechengOrder !=null){


                //entity转view
                JianshenkechengOrderView view = new JianshenkechengOrderView();
                BeanUtils.copyProperties( jianshenkechengOrder , view );//把实体数据重构到view中

                //级联表
                    JianshenkechengEntity jianshenkecheng = jianshenkechengService.selectById(jianshenkechengOrder.getJianshenkechengId());
                if(jianshenkecheng != null){
                    BeanUtils.copyProperties( jianshenkecheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJianshenkechengId(jianshenkecheng.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jianshenkechengOrder.getYonghuId());
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
    public R add(@RequestBody JianshenkechengOrderEntity jianshenkechengOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jianshenkechengOrder:{}",this.getClass().getName(),jianshenkechengOrder.toString());
            JianshenkechengEntity jianshenkechengEntity = jianshenkechengService.selectById(jianshenkechengOrder.getJianshenkechengId());
            if(jianshenkechengEntity == null){
                return R.error(511,"查不到该健身课程");
            }
            // Double jianshenkechengNewMoney = jianshenkechengEntity.getJianshenkechengNewMoney();

            if(false){
            }
            else if(jianshenkechengEntity.getJianshenkechengNewMoney() == null){
                return R.error(511,"课程价格不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - jianshenkechengEntity.getJianshenkechengNewMoney()*1;//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            jianshenkechengOrder.setJianshenkechengOrderTypes(101); //设置订单状态为已支付
            jianshenkechengOrder.setJianshenkechengOrderTruePrice(jianshenkechengEntity.getJianshenkechengNewMoney()*1); //设置实付价格
            jianshenkechengOrder.setYonghuId(userId); //设置订单支付人id
            jianshenkechengOrder.setJianshenkechengOrderUuidNumber(String.valueOf(new Date().getTime()));
            jianshenkechengOrder.setJianshenkechengOrderPaymentTypes(1);
            jianshenkechengOrder.setInsertTime(new Date());
            jianshenkechengOrder.setCreateTime(new Date());
                jianshenkechengOrderService.insert(jianshenkechengOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }


    /**
    * 退款
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            JianshenkechengOrderEntity jianshenkechengOrder = jianshenkechengOrderService.selectById(id);//当前表service
            Integer jianshenkechengOrderPaymentTypes = jianshenkechengOrder.getJianshenkechengOrderPaymentTypes();
            Integer jianshenkechengId = jianshenkechengOrder.getJianshenkechengId();
            if(jianshenkechengId == null)
                return R.error(511,"查不到该健身课程");
            JianshenkechengEntity jianshenkechengEntity = jianshenkechengService.selectById(jianshenkechengId);
            if(jianshenkechengEntity == null)
                return R.error(511,"查不到该健身课程");
            Double jianshenkechengNewMoney = jianshenkechengEntity.getJianshenkechengNewMoney();
            if(jianshenkechengNewMoney == null)
                return R.error(511,"健身课程价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

            //判断是什么支付方式 1代表余额 2代表积分
            if(jianshenkechengOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = jianshenkechengEntity.getJianshenkechengNewMoney() * 1  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额


            }


            jianshenkechengOrder.setJianshenkechengOrderTypes(102);//设置订单状态为已退款
            jianshenkechengOrderService.updateAllColumnById(jianshenkechengOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            jianshenkechengService.updateById(jianshenkechengEntity);//更新订单中健身课程的信息

            return R.ok();
    }

    /**
     * 完成
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id  , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        JianshenkechengOrderEntity  jianshenkechengOrderEntity = jianshenkechengOrderService.selectById(id);
        jianshenkechengOrderEntity.setJianshenkechengOrderTypes(103);//设置订单状态为已完成
        jianshenkechengOrderService.updateById( jianshenkechengOrderEntity);

        return R.ok();
    }


}

