package com.senb.familyedu.util;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;

public class CarDownloadUtil {
    public static ResponseEntity<byte[]> download(String downloadPath, String filename) throws IOException {
        // 文件下载
        File file = new File(downloadPath);
        // 中文名 乱码问题
        String encodingFilename = new String(filename.getBytes("utf-8"), "iso-8859-1");
        // 设置头部attachment(下载方式)，application/octet-stream
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", encodingFilename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 返回ResponseEntity对象,CREATED(201状态码)请求已经被实现，而且有一个新的资源已经依据请求的需要而建立，且其 URI
        // 已经随Location 头信息返回。
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
}