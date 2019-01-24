package com.csy.token;

import com.alibaba.fastjson.JSON;
import com.csy.constant.SystemConst;
import com.csy.entity.User;
import com.csy.utils.Base64Util;
import com.csy.utils.EncryptUtil;
import java.time.LocalDateTime;
import java.util.Random;

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
public class TokenUtil {

    //生成token
    public static String createToken(User user){
        LoginToken token = new LoginToken();
        token.setId(user.getId());
        token.setUser(user);
        token.setCreatetime(LocalDateTime.now());
        token.setRandomnum(new Random().nextLong());
        String json = JSON.toJSONString(token);
        return EncryptUtil.AESEnc(Base64Util.base64Dec(SystemConst.TOKENKEY),json);
    }

    //更新token时间
    public static String updateToken(String token){
        String json = EncryptUtil.AESDec(Base64Util.base64Dec(SystemConst.TOKENKEY),token);
        LoginToken loginToken = JSON.parseObject(json,LoginToken.class);
        loginToken.setCreatetime(LocalDateTime.now());
        loginToken.setRandomnum(new Random().nextLong());
        return EncryptUtil.AESEnc(Base64Util.base64Dec(SystemConst.TOKENKEY),JSON.toJSONString(loginToken));
    }

    //解析token
    public static LoginToken parseToken(String token){
        return JSON.parseObject(EncryptUtil.AESDec(Base64Util.base64Dec(SystemConst.TOKENKEY),token),LoginToken.class);
    }
}
