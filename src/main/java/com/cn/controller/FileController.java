package com.cn.controller;

import com.cn.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Administrator on 2016/11/11.
 */
@RestController
public class FileController {

    @Value("${upload-path}")
    private String uploadPath;

    @PostMapping("postFile")
    public String postFile(HttpServletRequest request,@RequestParam("image") MultipartFile[] files){
        //这里可以支持多文件上传
        if(files!=null && files.length>=1) {
            BufferedOutputStream bw = null;
            try {
                String fileName = files[0].getOriginalFilename();
                //判断是否有文件且是否为图片文件
                if(fileName!=null && !"".equalsIgnoreCase(fileName.trim()) && FileUtil.isImageFile(fileName)) {
                    //创建输出文件对象
                    File outFile = new File(uploadPath + "/" + UUID.randomUUID().toString()+FileUtil.getFileType(fileName));
                    //拷贝文件到输出文件对象
                    FileUtils.copyInputStreamToFile(files[0].getInputStream(), outFile);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(bw!=null) {bw.close();}
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "get Name:"+request.getParameter("name");
    }

}
