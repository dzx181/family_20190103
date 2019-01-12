package com.senb.familyedu.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.senb.familyedu.entity.EduCourse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class EduSelectVO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private EduCourseVO course;

    private Integer userId;


    public static final String ID = "id";

    public static final String COURSE_ID = "course_id";

    public static final String USER_ID = "user_id";

}

