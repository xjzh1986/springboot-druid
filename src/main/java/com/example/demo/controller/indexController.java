package com.example.demo.controller;


import com.alibaba.fastjson.JSON;
import com.example.demo.entity.SysUser;
import com.example.demo.service.SysUserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sysUser")
@Api(tags = "用户操作模块")
public class indexController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加用户信息", notes = "添加用户信息")
    public String index(@RequestBody SysUser sysUserParam) {
        for(int i=0;i<100;i++){
            SysUser user = new SysUser();
            user.setUserName("username"+i);
            user.setPassword("password"+i);
            user.setMail("mail"+i);
            user.setPhone("phone"+i);
            user.setStatus((byte)1);
            sysUserService.insert(user);
        }
        return "success";
    }

    @ApiOperation(value = "查询用户信息" ,  notes="查询用户信息")
    @RequestMapping(value="/selectAll",method= RequestMethod.POST)
    @ResponseBody
    public PageInfo<SysUser> selectAll(@RequestParam("page") int page, SysUser user){
        PageInfo<SysUser> pageInfo = sysUserService.findAllUser(page,user);
        // 用户组对象转JSON串
        String jsonString = JSON.toJSONString(pageInfo);
        System.out.println("jsonString:" + jsonString);
        return pageInfo;
    }
}
