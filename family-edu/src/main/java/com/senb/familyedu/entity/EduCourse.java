package com.senb.familyedu.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author senb
 * @since 2019-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("edu_course")
public class EduCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 课程名
     */
    @TableField("name")
    private String name;
    /**
     * 视频课程
     */
    @TableField("vedio")
    private String vedio;
    /**
     * 课程封面图路径
     */
    @TableField("pic_path")
    private String picPath;
    /**
     * 课程介绍
     */
    @TableField("introdue")
    private String introdue;
    /**
     * 老师id
     */
    @TableField("user_tea_id")
    private Integer userTeaId;
    /**
     * 时间段
     */
    @TableField("time_section")
    private String timeSection;
    /**
     * 星期
     */
    @TableField("week")
    private String week;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String VEDIO = "vedio";

    public static final String PIC_PATH = "pic_path";

    public static final String INTRODUE = "introdue";

    public static final String USER_TEA_ID = "user_tea_id";

    public static final String TIME_SECTION = "time_section";

    public static final String WEEK = "week";

}
