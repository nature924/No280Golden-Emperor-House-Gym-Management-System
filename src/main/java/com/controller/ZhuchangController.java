
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
 * 驻场人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhuchang")
public class ZhuchangController {
    private static final Logger logger = LoggerFactory.getLogger(ZhuchangController.class);

    private static final String TABLE_NAME = "zhuchang";

    @Autowired
    private ZhuchangService zhuchangService;


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
        params.put("dataDeleteStart",1);params.put("dataDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = zhuchangService.queryPage(params);

        //字典表数据转换
        List<ZhuchangView> list =(List<ZhuchangView>)page.getList();
        for(ZhuchangView c:list){
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
        ZhuchangEntity zhuchang = zhuchangService.selectById(id);
        if(zhuchang !=null){
            //entity转view
            ZhuchangView view = new ZhuchangView();
            BeanUtils.copyProperties( zhuchang , view );//把实体数据重构到view中
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
    public R save(@RequestBody ZhuchangEntity zhuchang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhuchang:{}",this.getClass().getName(),zhuchang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhuchangEntity> queryWrapper = new EntityWrapper<ZhuchangEntity>()
            .eq("username", zhuchang.getUsername())
            .or()
            .eq("zhuchang_phone", zhuchang.getZhuchangPhone())
            .eq("data_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhuchangEntity zhuchangEntity = zhuchangService.selectOne(queryWrapper);
        if(zhuchangEntity==null){
            zhuchang.setDataDelete(1);
            zhuchang.setInsertTime(new Date());
            zhuchang.setCreateTime(new Date());
            zhuchang.setPassword("123456");
            zhuchangService.insert(zhuchang);
            return R.ok();
        }else {
            return R.error(511,"账户或者驻场人员手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhuchangEntity zhuchang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zhuchang:{}",this.getClass().getName(),zhuchang.toString());
        ZhuchangEntity oldZhuchangEntity = zhuchangService.selectById(zhuchang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(zhuchang.getZhuchangPhoto()) || "null".equals(zhuchang.getZhuchangPhoto())){
                zhuchang.setZhuchangPhoto(null);
        }
        if("".equals(zhuchang.getZhuchangContent()) || "null".equals(zhuchang.getZhuchangContent())){
                zhuchang.setZhuchangContent(null);
        }

            zhuchangService.updateById(zhuchang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZhuchangEntity> oldZhuchangList =zhuchangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ZhuchangEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ZhuchangEntity zhuchangEntity = new ZhuchangEntity();
            zhuchangEntity.setId(id);
            zhuchangEntity.setDataDelete(2);
            list.add(zhuchangEntity);
        }
        if(list != null && list.size() >0){
            zhuchangService.updateBatchById(list);
        }

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
            List<ZhuchangEntity> zhuchangList = new ArrayList<>();//上传的东西
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
                            ZhuchangEntity zhuchangEntity = new ZhuchangEntity();
//                            zhuchangEntity.setUsername(data.get(0));                    //账户 要改的
//                            zhuchangEntity.setPassword("123456");//密码
//                            zhuchangEntity.setZhuchangName(data.get(0));                    //驻场人员名称 要改的
//                            zhuchangEntity.setZhuchangPhone(data.get(0));                    //驻场人员手机号 要改的
//                            zhuchangEntity.setZhuchangPhoto("");//详情和图片
//                            zhuchangEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            zhuchangEntity.setZhuchangEmail(data.get(0));                    //驻场人员邮箱 要改的
//                            zhuchangEntity.setZhuchangNewMoney(data.get(0));                    //工薪 要改的
//                            zhuchangEntity.setZhuchangContent("");//详情和图片
//                            zhuchangEntity.setDataDelete(1);//逻辑删除字段
//                            zhuchangEntity.setInsertTime(date);//时间
//                            zhuchangEntity.setCreateTime(date);//时间
                            zhuchangList.add(zhuchangEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //驻场人员手机号
                                if(seachFields.containsKey("zhuchangPhone")){
                                    List<String> zhuchangPhone = seachFields.get("zhuchangPhone");
                                    zhuchangPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> zhuchangPhone = new ArrayList<>();
                                    zhuchangPhone.add(data.get(0));//要改的
                                    seachFields.put("zhuchangPhone",zhuchangPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<ZhuchangEntity> zhuchangEntities_username = zhuchangService.selectList(new EntityWrapper<ZhuchangEntity>().in("username", seachFields.get("username")).eq("data_delete", 1));
                        if(zhuchangEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhuchangEntity s:zhuchangEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //驻场人员手机号
                        List<ZhuchangEntity> zhuchangEntities_zhuchangPhone = zhuchangService.selectList(new EntityWrapper<ZhuchangEntity>().in("zhuchang_phone", seachFields.get("zhuchangPhone")).eq("data_delete", 1));
                        if(zhuchangEntities_zhuchangPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhuchangEntity s:zhuchangEntities_zhuchangPhone){
                                repeatFields.add(s.getZhuchangPhone());
                            }
                            return R.error(511,"数据库的该表中的 [驻场人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhuchangService.insertBatch(zhuchangList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ZhuchangEntity zhuchang = zhuchangService.selectOne(new EntityWrapper<ZhuchangEntity>().eq("username", username));
        if(zhuchang==null || !zhuchang.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(zhuchang.getDataDelete() != 1)
            return R.error("账户已被删除");
        String token = tokenService.generateToken(zhuchang.getId(),username, "zhuchang", "驻场人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","驻场人员");
        r.put("username",zhuchang.getZhuchangName());
        r.put("tableName","zhuchang");
        r.put("userId",zhuchang.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ZhuchangEntity zhuchang, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<ZhuchangEntity> queryWrapper = new EntityWrapper<ZhuchangEntity>()
            .eq("username", zhuchang.getUsername())
            .or()
            .eq("zhuchang_phone", zhuchang.getZhuchangPhone())
            .andNew()
            .eq("data_delete", 1)
            ;
        ZhuchangEntity zhuchangEntity = zhuchangService.selectOne(queryWrapper);
        if(zhuchangEntity != null)
            return R.error("账户或者驻场人员手机号已经被使用");
        zhuchang.setZhuchangNewMoney(0.0);
        zhuchang.setDataDelete(1);
        zhuchang.setInsertTime(new Date());
        zhuchang.setCreateTime(new Date());
        zhuchangService.insert(zhuchang);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        ZhuchangEntity zhuchang = zhuchangService.selectById(id);
        zhuchang.setPassword("123456");
        zhuchangService.updateById(zhuchang);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        ZhuchangEntity zhuchang = zhuchangService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(zhuchang.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(zhuchang.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        zhuchang.setPassword(newPassword);
		zhuchangService.updateById(zhuchang);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        ZhuchangEntity zhuchang = zhuchangService.selectOne(new EntityWrapper<ZhuchangEntity>().eq("username", username));
        if(zhuchang!=null){
            zhuchang.setPassword("123456");
            zhuchangService.updateById(zhuchang);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrZhuchang(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ZhuchangEntity zhuchang = zhuchangService.selectById(id);
        if(zhuchang !=null){
            //entity转view
            ZhuchangView view = new ZhuchangView();
            BeanUtils.copyProperties( zhuchang , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = zhuchangService.queryPage(params);

        //字典表数据转换
        List<ZhuchangView> list =(List<ZhuchangView>)page.getList();
        for(ZhuchangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhuchangEntity zhuchang = zhuchangService.selectById(id);
            if(zhuchang !=null){


                //entity转view
                ZhuchangView view = new ZhuchangView();
                BeanUtils.copyProperties( zhuchang , view );//把实体数据重构到view中

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
    public R add(@RequestBody ZhuchangEntity zhuchang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zhuchang:{}",this.getClass().getName(),zhuchang.toString());
        Wrapper<ZhuchangEntity> queryWrapper = new EntityWrapper<ZhuchangEntity>()
            .eq("username", zhuchang.getUsername())
            .or()
            .eq("zhuchang_phone", zhuchang.getZhuchangPhone())
            .andNew()
            .eq("data_delete", 1)
//            .notIn("zhuchang_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhuchangEntity zhuchangEntity = zhuchangService.selectOne(queryWrapper);
        if(zhuchangEntity==null){
            zhuchang.setDataDelete(1);
            zhuchang.setInsertTime(new Date());
            zhuchang.setCreateTime(new Date());
            zhuchang.setPassword("123456");
        zhuchangService.insert(zhuchang);

            return R.ok();
        }else {
            return R.error(511,"账户或者驻场人员手机号已经被使用");
        }
    }

}

