package com.leimingting.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @Author 小T
 * @Date 2021/5/28 19:44
 */
@Controller
public class handleFormUpload {
    @RequestMapping("/fileUpload")
    public String handleFormUpload(@RequestParam("name") String name, @RequestParam("uploadFile") List<MultipartFile> uploadFile, HttpServletRequest request) {
        //判断上传文件是否存在
        if (!uploadFile.isEmpty() && uploadFile.size() > 0) {
            //循环输出上传的文件
            for (MultipartFile file : uploadFile) {
                //获取上传文件的原始位置
                String originalFilename = file.getOriginalFilename();
                String dirPath = request.getServletContext().getRealPath("/upload/");
                File filePath = new File(dirPath);
                //如果保存的地址不存在，就先创建目录
                if (!filePath.exists()) {
                    filePath.mkdir();
                }
                //使用UUID重新命名上传的文件名称（上传人_uuid_原始文件名称）
                String newFilename = name + "_" + UUID.randomUUID() + "_" + originalFilename;
                try {
                    file.transferTo(new File(dirPath + newFilename));
                } catch (IOException e) {
                    e.printStackTrace();
                    return "error";
                }
            }
            return "success";
        } else {
            return "error";
        }
    }

    @RequestMapping("/goFile")
    public String goFile() {
        return "fileUpload";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request, String fileName) throws IOException {
        //指定文件下载的文件所在路径
        String path = request.getServletContext().getRealPath("/upload/");
        //创建该文件对象
        File file = new File(path + File.separator + fileName);
        HttpHeaders headers = new HttpHeaders();
        //通知浏览器以下载的方式打开文件
        headers.setContentDispositionFormData("attachment", fileName);
        //定义以流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //使用String MVC框架 的ResponseEntity对象封装返回下载数据
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }
}
