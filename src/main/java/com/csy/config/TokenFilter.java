package com.csy.config;


import com.alibaba.fastjson.JSON;
import com.csy.constant.SystemConst;
import com.csy.utils.JedisUtil;
import com.csy.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * //
 * //                       _oo0oo_
 * //                      o8888888o
 * //                      88" . "88
 * //                      (| -_- |)
 * //                      0\  =  /0
 * //                    ___/`---'\___
 * //                  .' \\|     |// '.
 * //                 / \\|||  :  |||// \
 * //                / _||||| -:- |||||- \
 * //               |   | \\\  -  /// |   |
 * //               | \_|  ''\---/''  |_/ |
 * //               \  .-\__  '-'  ___/-. /
 * //             ___'. .'  /--.--\  `. .'___
 * //          ."" '<  `.___\_<|>_/___.' >' "".
 * //         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * //         \  \ `_.   \_ __\ /__ _/   .-` /  /
 * //     =====`-.____`.___ \_____/___.-`___.-'=====
 * //                       `=---='
 * //
 * //
 * //     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * //
 * //               佛祖保佑         永无BUG
 * //
 */
public class TokenFilter implements Filter {

    @Autowired
    private JedisUtil jedisUtil;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        String token=request.getParameter("token");
        if(token!=null && token.length()>0){
            if(jedisUtil.checkFiled(SystemConst.TOKENMAP,"user:"+token)){
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                servletResponse.getWriter().write(JSON.toJSONString(ResultUtil.execERROR()));
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
