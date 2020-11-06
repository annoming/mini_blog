package com.atming.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.atming.common.dto.LoginDto;
import com.atming.common.lang.Result;
import com.atming.entity.MUser;
import com.atming.service.IMUserService;
import com.atming.util.JwtUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: Annoming
 * @Date: 2020/11/6
 * @Time: 10:32
 * @Description
 */
@RestController
public class AccountController {

    @Autowired
    IMUserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @RequestMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response){
        MUser user = userService.getOne(new QueryWrapper<MUser>().eq("username", loginDto.getUsername()));
        //抛出异常为IllegalArgumentException
        Assert.notNull(user, "用户不存在");
        if (user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))) {
            return Result.fail("密码不正确");
        }
        String jwt = jwtUtils.generateToken(user.getId());
        response.setHeader("Authorization",jwt);
        response.setHeader("Access-control-Expost-Headers","Authorization");
        return Result.success(MapUtil.builder()
                .put("id",user.getId())
                .put("username",user.getUsername())
                .put("avatar",user.getAvatar())
                .put("email",user.getEmail())
                .map()
        );
    }
}
