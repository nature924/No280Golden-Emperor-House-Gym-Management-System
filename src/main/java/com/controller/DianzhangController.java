
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
 * 店长
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/dianzhang")
public class DianzhangController {
    private static final Logger logger = LoggerFactory.getLogger(DianzhangController.class);

    private static final String TABLE_NAME = "dianzhang";

    @Autowired
    private DianzhangService dianzhangService;


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
        params.put("dataDeleteStart",1);params.put("dataDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = dianzhangService.queryPage(params);

        //字典表数据转换
        List<DianzhangView> list =(List<DianzhangView>)page.getList();
        for(DianzhangView c:list){
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
        DianzhangEntity dianzhang = dianzhangService.selectById(id);
        if(dianzhang !=null){
            //entity转view
            DianzhangView view = new DianzhangView();
            BeanUtils.copyProperties( dianzhang , view );//把实体数据重构到view中
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
    public R save(@RequestBody DianzhangEntity dianzhang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,dianzhang:{}",this.getClass().getName(),dianzhang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<DianzhangEntity> queryWrapper = new EntityWrapper<DianzhangEntity>()
            .eq("username", dianzhang.getUsername())
            .or()
            .eq("dianzhang_phone", dianzhang.getDianzhangPhone())
            .eq("data_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DianzhangEntity dianzhangEntity = dianzhangService.selectOne(queryWrapper);
        if(dianzhangEntity==null){
            dianzhang.setDataDelete(1);
            dianzhang.setInsertTime(new Date());
            dianzhang.setCreateTime(new Date());
            dianzhang.setPassword("123456");
            dianzhangService.insert(dianzhang);
            return R.ok();
        }else {
            return R.error(511,"账户或者店长手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DianzhangEntity dianzhang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,dianzhang:{}",this.getClass().getName(),dianzhang.toString());
        DianzhangEntity oldDianzhangEntity = dianzhangService.selectById(dianzhang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(dianzhang.getDianzhangPhoto()) || "null".equals(dianzhang.getDianzhangPhoto())){
                dianzhang.setDianzhangPhoto(null);
        }
        if("".equals(dianzhang.getDianzhangContent()) || "null".equals(dianzhang.getDianzhangContent())){
                dianzhang.setDianzhangContent(null);
        }

            dianzhangService.updateById(dianzhang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<DianzhangEntity> oldDianzhangList =dianzhangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<DianzhangEntity> list = new ArrayList<>();
        for(Integer id:ids){
            DianzhangEntity dianzhangEntity = new DianzhangEntity();
            dianzhangEntity.setId(id);
            dianzhangEntity.setDataDelete(2);
            list.add(dianzhangEntity);
        }
        if(list != null && list.size() >0){
            dianzhangService.updateBatchById(list);
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
            List<DianzhangEntity> dianzhangList = new ArrayList<>();//上传的东西
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
                            DianzhangEntity dianzhangEntity = new DianzhangEntity();
//                            dianzhangEntity.setUsername(data.get(0));                    //账户 要改的
//                            dianzhangEntity.setPassword("123456");//密码
//                            dianzhangEntity.setDianzhangName(data.get(0));                    //店长名称 要改的
//                            dianzhangEntity.setDianzhangPhone(data.get(0));                    //店长手机号 要改的
//                            dianzhangEntity.setDianzhangPhoto("");//详情和图片
//                            dianzhangEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            dianzhangEntity.setDianzhangEmail(data.get(0));                    //店长邮箱 要改的
//                            dianzhangEntity.setDianzhangContent("");//详情和图片
//                            dianzhangEntity.setDataDelete(1);//逻辑删除字段
//                            dianzhangEntity.setInsertTime(date);//时间
//                            dianzhangEntity.setCreateTime(date);//时间
                            dianzhangList.add(dianzhangEntity);


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
                                //店长手机号
                                if(seachFields.containsKey("dianzhangPhone")){
                                    List<String> dianzhangPhone = seachFields.get("dianzhangPhone");
                                    dianzhangPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> dianzhangPhone = new ArrayList<>();
                                    dianzhangPhone.add(data.get(0));//要改的
                                    seachFields.put("dianzhangPhone",dianzhangPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<DianzhangEntity> dianzhangEntities_username = dianzhangService.selectList(new EntityWrapper<DianzhangEntity>().in("username", seachFields.get("username")).eq("data_delete", 1));
                        if(dianzhangEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DianzhangEntity s:dianzhangEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //店长手机号
                        List<DianzhangEntity> dianzhangEntities_dianzhangPhone = dianzhangService.selectList(new EntityWrapper<DianzhangEntity>().in("dianzhang_phone", seachFields.get("dianzhangPhone")).eq("data_delete", 1));
                        if(dianzhangEntities_dianzhangPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(DianzhangEntity s:dianzhangEntities_dianzhangPhone){
                                repeatFields.add(s.getDianzhangPhone());
                            }
                            return R.error(511,"数据库的该表中的 [店长手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        dianzhangService.insertBatch(dianzhangList);
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
        DianzhangEntity dianzhang = dianzhangService.selectOne(new EntityWrapper<DianzhangEntity>().eq("username", username));
        if(dianzhang==null || !dianzhang.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(dianzhang.getDataDelete() != 1)
            return R.error("账户已被删除");
        String token = tokenService.generateToken(dianzhang.getId(),username, "dianzhang", "店长");
        R r = R.ok();
        r.put("token", token);
        r.put("role","店长");
        r.put("username",dianzhang.getDianzhangName());
        r.put("tableName","dianzhang");
        r.put("userId",dianzhang.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody DianzhangEntity dianzhang, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<DianzhangEntity> queryWrapper = new EntityWrapper<DianzhangEntity>()
            .eq("username", dianzhang.getUsername())
            .or()
            .eq("dianzhang_phone", dianzhang.getDianzhangPhone())
            .andNew()
            .eq("data_delete", 1)
            ;
        DianzhangEntity dianzhangEntity = dianzhangService.selectOne(queryWrapper);
        if(dianzhangEntity != null)
            return R.error("账户或者店长手机号已经被使用");
        dianzhang.setDataDelete(1);
        dianzhang.setInsertTime(new Date());
        dianzhang.setCreateTime(new Date());
        dianzhangService.insert(dianzhang);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        DianzhangEntity dianzhang = dianzhangService.selectById(id);
        dianzhang.setPassword("123456");
        dianzhangService.updateById(dianzhang);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        DianzhangEntity dianzhang = dianzhangService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(dianzhang.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(dianzhang.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        dianzhang.setPassword(newPassword);
		dianzhangService.updateById(dianzhang);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        DianzhangEntity dianzhang = dianzhangService.selectOne(new EntityWrapper<DianzhangEntity>().eq("username", username));
        if(dianzhang!=null){
            dianzhang.setPassword("123456");
            dianzhangService.updateById(dianzhang);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrDianzhang(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        DianzhangEntity dianzhang = dianzhangService.selectById(id);
        if(dianzhang !=null){
            //entity转view
            DianzhangView view = new DianzhangView();
            BeanUtils.copyProperties( dianzhang , view );//把实体数据重构到view中

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
        PageUtils page = dianzhangService.queryPage(params);

        //字典表数据转换
        List<DianzhangView> list =(List<DianzhangView>)page.getList();
        for(DianzhangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DianzhangEntity dianzhang = dianzhangService.selectById(id);
            if(dianzhang !=null){


                //entity转view
                DianzhangView view = new DianzhangView();
                BeanUtils.copyProperties( dianzhang , view );//把实体数据重构到view中

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
    public R add(@RequestBody DianzhangEntity dianzhang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,dianzhang:{}",this.getClass().getName(),dianzhang.toString());
        Wrapper<DianzhangEntity> queryWrapper = new EntityWrapper<DianzhangEntity>()
            .eq("username", dianzhang.getUsername())
            .or()
            .eq("dianzhang_phone", dianzhang.getDianzhangPhone())
            .andNew()
            .eq("data_delete", 1)
//            .notIn("dianzhang_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DianzhangEntity dianzhangEntity = dianzhangService.selectOne(queryWrapper);
        if(dianzhangEntity==null){
            dianzhang.setDataDelete(1);
            dianzhang.setInsertTime(new Date());
            dianzhang.setCreateTime(new Date());
            dianzhang.setPassword("123456");
        dianzhangService.insert(dianzhang);

            return R.ok();
        }else {
            return R.error(511,"账户或者店长手机号已经被使用");
        }
    }

}

