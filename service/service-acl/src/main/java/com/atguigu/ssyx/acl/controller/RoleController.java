package com.atguigu.ssyx.acl.controller;

import com.atguigu.ssyx.acl.service.RoleService;
import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.model.acl.Role;
import com.atguigu.ssyx.vo.acl.RoleQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 韩跃迁
 * @date 2023年07月02日 下午 17:21
 */
@RestController
@RequestMapping("/admin/acl/role")
@Api(tags = "用户管理")
@CrossOrigin
public class RoleController {


    @Autowired
    private RoleService roleService;

    @ApiOperation("角色条件分页查询")
    @GetMapping("{current}/{limit}")
    public Result pageList(@PathVariable Long current,
                           @PathVariable Long limit,
                            RoleQueryVo roleQueryVo){
        //1 创建page对象，传递当前页和每页记录数
        // current：当前页
        // limit: 每页显示记录数
        Page<Role> pageParam = new Page<>(current, limit);

        //调用service方法实现条件分页查询，返回分页对象
        IPage<Role> pageModel = roleService.selectRolePage(pageParam,roleQueryVo);
        return Result.ok(pageModel);

    }

    @ApiOperation("保存一个新角色")
    @PostMapping("save")
    public Result save(@RequestBody Role role){
        boolean isSuccess = roleService.save(role);
        if (isSuccess == true){
            return Result.ok(null);
        }else {
            return Result.fail(null);
        }
    }

    @ApiOperation("根据Id获取某个角色")
    @GetMapping("get/{id}")
    public Result getById(@PathVariable Long id){
        Role byId = roleService.getById(id);
        return Result.ok(null);
    }

    @ApiOperation("更新一个角色")
    @PutMapping("update")
    public Result updateById(@RequestBody Role role){
        boolean b = roleService.updateById(role);
        return Result.ok(null);
    }

    @ApiOperation("删除某个角色")
    @DeleteMapping("remove/{id}")
    public Result removeById(@PathVariable Long id){
        roleService.removeById(id);
        return Result.ok(null);
    }

    @ApiOperation("批量删除多个角色")
    @DeleteMapping("batchRemove")
    public Result removeRoles(@RequestBody List<Long> idList){
        roleService.removeByIds(idList);
        return Result.ok(null);
    }
}
