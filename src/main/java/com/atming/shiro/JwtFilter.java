package com.atming.shiro;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: Annoming
 * @Date: 2020/10/23
 * @Time: 21:37
 * @Description
 */

import cn.hutool.http.server.HttpServerRequest;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//  两种方式：
//     + 继承AuthenticatingFilter
//     + 继承BasicHttpAuthenticationFilter
@Component
public class JwtFilter extends AuthenticatingFilter {
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServerRequest request = (HttpServerRequest) servletRequest;
        String jwt = request.getHeader("Authorization");
        if (StringUtils.isEmpty(jwt)) {
            return null;
        }
        return new JwtToken(jwt);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return false;
    }
}
