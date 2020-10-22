package com.atming.controller;


import com.atming.common.lang.Result;
import com.atming.entity.MUser;
import com.atming.service.IMUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/index")
    public Object index() {
        MUser user = userService.getById(1);
        return Result.success(user);
    }
}
