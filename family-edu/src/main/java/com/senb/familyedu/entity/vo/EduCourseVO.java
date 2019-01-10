package com.senb.familyedu.entity.vo;

import com.baomidou.mybatisplus.annotations.TableName;
import com.senb.familyedu.entity.EduUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("edu_course")
public class EduCourseVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String vedio;

    private String picPath;

    private String introdue;

    private EduUser userTea;

    private String timeSection;

    private String week;






}
