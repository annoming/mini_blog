package com.atming.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: Annoming
 * @Date: 2020/10/28
 * @Time: 22:19
 * @Description
 */
@Data
public class AccountProfile implements Serializable {

    private Long id;

    private String userName;

    private String avatar;

    private String email;
}
