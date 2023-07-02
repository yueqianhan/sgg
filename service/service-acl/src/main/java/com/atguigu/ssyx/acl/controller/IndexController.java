package com.atguigu.ssyx.acl.controller;

import com.atguigu.ssyx.common.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 韩跃迁
 * @date 2023年07月02日 下午 15:39
 */
@Api(tags = "登录接口")
@RestController
@RequestMapping("/admin/acl/index")
@CrossOrigin
public class IndexController {

    @ApiOperation("登录")
    @PostMapping("login")
    public Result login(){
        Map<String, String> map = new HashMap<>();
        map.put("token","token-admin");
        return Result.ok(map);
    }

    /**
     * 2 获取用户信息
     */
    @ApiOperation("获取信息")
    @GetMapping("info")
    public Result info(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","atguigu");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return Result.ok(map);
    }

    /**
     * 3 退出
     */
    @ApiOperation("退出")
    @PostMapping("logout")
    public Result logout(){
        return Result.ok(null);
    }
}
