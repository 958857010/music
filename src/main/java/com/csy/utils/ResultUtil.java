package com.csy.utils;

import com.csy.vo.PageVo;
import com.csy.vo.ResultVo;

import java.util.List;

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
public class ResultUtil {
    //一般都是新增或修改或删除操作
     public static ResultVo exec(int count, Object obj){
         ResultVo resultVo = new ResultVo();
         if (count>0){
             resultVo.setCode(1);
             resultVo.setMsg("操作成功");
             resultVo.setData(obj);
         }else {
             resultVo.setCode(0);
             resultVo.setMsg("操作失败");
         }
         return resultVo;
     }

     public static ResultVo execOK(){
         ResultVo resultVo = new ResultVo();
         resultVo.setCode(1);
         resultVo.setMsg("OK");
         return resultVo;
     }

     public static ResultVo execOK(Object obj){
         ResultVo resultVo = new ResultVo();
         resultVo.setCode(1);
         resultVo.setMsg("OK");
         resultVo.setData(obj);
         return resultVo;
     }

     public static ResultVo execERROR(){
         ResultVo resultVo = new ResultVo();
         resultVo.setCode(0);
         resultVo.setMsg("ERROR");
         return resultVo;
     }

     public static ResultVo execERROR(Object obj){
         ResultVo resultVo = new ResultVo();
         resultVo.setCode(0);
         resultVo.setMsg("ERROR");
         resultVo.setData(obj);
         return resultVo;
     }

     public static <T> PageVo<T> exec(int page, int size, int count, List<T> data){
         PageVo<T> pageVo = new PageVo<>();
         pageVo.setCurrpage(page);
         pageVo.setSize(size);
         pageVo.setCount(count);
         pageVo.setData(data);
         return pageVo;
     }
}
