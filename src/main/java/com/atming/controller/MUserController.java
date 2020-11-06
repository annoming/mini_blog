package com.atming.controller;


import com.atming.common.lang.Result;
import com.atming.entity.MUser;
import com.atming.service.IMUserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-10-22
 */
@RestController
@RequestMapping("/atming/m-user")
public class MUserController {

    @Autowired
    IMUserService userService;

    @RequiresAuthentication
    @GetMapping("/index")
    public Result index() {
        MUser user = userService.getById(1);
        return Result.success(user);
    }

    @PostMapping("/save")
    public Result save(@Validated @RequestBody MUser user){
        return Result.success(user);
    }
}
