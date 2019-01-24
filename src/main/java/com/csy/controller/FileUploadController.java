package com.csy.controller;

import com.csy.utils.FileUtil;
import com.csy.utils.ResultUtil;
import com.csy.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
@RestController
@Api(value = "资源上传")
public class FileUploadController {

    //上传文件或图片
    @ApiOperation(value = "文件或图片上传",notes = "支持多文件上传")
    @PostMapping("fileupload.do")
    public ResultVo upload(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) throws IOException {
        if (files!=null&&files.length>0){
            List<String> paths = new ArrayList<>();
            for (MultipartFile f:files) {
                //获取上传的文件名称
                String fn = FileUtil.renameFile(f.getOriginalFilename());
                //获取存储的文件夹
                File dir = FileUtil.createDir(new File(request.getServletContext().getRealPath("/")).getParent()+File.separator+"selfresource");
                File desFile = new File(dir,fn);
                f.transferTo(desFile);
                paths.add("/selfsource"+File.separator+dir.getName()+File.separator+fn);
            }
            return ResultUtil.execOK(paths);
        }
        return ResultUtil.execERROR();
    }

    //上传视频
    @ApiOperation(value = "视频上传",notes = "支持视频上传")
    @PostMapping("videoupload.do")
    public ResultVo uploadVideo(@RequestParam("video") MultipartFile video,HttpServletRequest request) throws IOException {
        if (video!=null){
            StringBuffer buffer = new StringBuffer();
            //获取上传的文件名称
            String fn = FileUtil.renameFile(video.getOriginalFilename());
            //获取存储的文件夹
            File dir=FileUtil.createDir(new File(request.getServletContext().getRealPath("/")).getParent()+File.separator+"selfvideos");
            buffer.append("/selfvideos"+File.separator);
            buffer.append(dir.getName()+File.separator);
            buffer.append(fn);
            video.transferTo(new File(dir,fn));
            return ResultUtil.execOK(buffer.toString());
        }
        return ResultUtil.execERROR();
    }
}
