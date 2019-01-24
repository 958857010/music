package com.csy.utils;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

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
public class JedisUtil {

    private Jedis jedis;

    public JedisUtil(String host,int port,String pass) {
        jedis=new Jedis(host,port);
        jedis.auth(pass);
    }
    //新增
    public void save(String key,String value){
        jedis.set(key,value);
    }
    public void save(String key, String field,String value){
        jedis.hset(key,field,value);

    }
    public void save(String key, Map<String,String> values){
        jedis.hset(key,values);
    }
    public void save(String key,List<String> values){
        jedis.lpush(key,(String[]) values.toArray());
    }
    //移除
    public void del(String key){
        jedis.del(key);
    }
    public void del(String key,String... fileds){
        jedis.hdel(key,fileds);
    }
    //查询
    public String get(String key){
        return jedis.get(key);
    }
    public Map<String,String> getMap(String key){
        return jedis.hgetAll(key);
    }
    public String getMap(String key,String field){
        return jedis.hget(key,field);
    }
    public boolean checkFiled(String key,String field){
        return  jedis.hexists(key,field);
    }
    //设置有效期
    public void expire(String key,int seconds){
        jedis.expire(key,seconds);
    }
    //验证Key是否存在
    public boolean exists(String key){
        return jedis.exists(key);
    }
    //取消有效期
    public void persist(String key){
        jedis.persist(key);
    }

}
