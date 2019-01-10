package com.senb.familyedu.controller;


import com.senb.familyedu.entity.EduCourse;
import com.senb.familyedu.entity.EduUser;
import com.senb.familyedu.service.EduCourseService;

import com.senb.familyedu.util.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author senb
 * @since 2019-01-03
 */
@Controller
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;

    @RequestMapping(value = "/insertCourse",method = RequestMethod.POST)
    public String insertCourse(EduCourse course, HttpServletRequest request,
                               @RequestParam("uploadFile") List<MultipartFile> uploadFile
                               ) throws IOException {
        if (!uploadFile.isEmpty()) {
            // session中获取user
            EduUser user = (EduUser) request.getSession().getAttribute("user");
            // 上传文件名
            String videoName = uploadFile.get(0).getOriginalFilename();
            String picName = uploadFile.get(1).getOriginalFilename();
            // 站点路径
            String servletPath = new File(ConstUtil.GEN_PATH).getAbsolutePath();
            // 为上传文件用户创建一个单独的文件夹
            File userDir = new File(servletPath + File.separator + user.getUsername());
            if (!userDir.exists()) {
                userDir.mkdir();
            }
            // 上传文件到该用户文件夹
            File file = new File(userDir + File.separator + videoName);
            if (!file.getParentFile().exists()) {
                file.mkdir();
            }
            File file1 = new File(userDir + File.separator + picName);
            if (!file1.getParentFile().exists()) {
                file1.mkdir();
            }
            // 上传文件到路径
            uploadFile.get(0).transferTo(file);
            uploadFile.get(1).transferTo(file1);
            // 设置course的值
            course.setVedio(videoName);
            course.setPicPath(picName);
            eduCourseService.insert(course);
            request.setAttribute("msg", "上传成功");
            return "information";
        }
        request.setAttribute("msg", "上传文件不能为空");
        return "information";
    }

//    /**
//     * 文件下载
//     *
//     * @param docVO
//     * @param request
//     * @return
//     * @throws IOException
//     */
//    @GetMapping("/downloadFile")
//    public ResponseEntity<byte[]> downloadFile(DocVO docVO, HttpServletRequest request) throws IOException {
//        // 下载文件路径,文件对象
//        String servletPath = new File(ConstUtil.GEN_PATH).getAbsolutePath() + File.separator + docVO.getUser().getUsername();
//        String path = servletPath + File.separator + docVO.getFilename();
//
//        // 文件下载
//        return CarDownloadUtil.download(path, docVO.getFilename());
//    }



//    /**
//     * 跳转到docAdd
//     *
//     * @param request
//     * @return
//     */
//    @RequestMapping("/docAdd")
//    public String jumpDocAdd(HttpServletRequest request) {
//        request.setAttribute("type", request.getAttribute("type"));
//        return "doc/docUpload";
//    }
//
//    /**
//     * 查询文件
//     *
//     * @param doc
//     * @param request
//     * @param page
//     * @return
//     */
//    @RequestMapping("/selectDoc")
//    public String selectDoc(Doc doc, HttpServletRequest request, Integer page) {
//        return docService.selectDoc(page, doc, request);
//    }


//    /**
//     * 删除文件
//     *
//     * @param caption
//     * @return
//     */
//    @RequestMapping("/deleteDocs")
//    public String deleteDocs(Integer[] caption) {
//        docService.deleteDoc(Arrays.asList(caption));
//        return "redirect:/selectDoc";
//
//    }




}

