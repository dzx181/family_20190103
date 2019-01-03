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
@TableName("edu_remark")
public class EduRemark implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 评论
     */
    @TableField("remark")
    private String remark;
    /**
     * 评价
     */
    @TableField("evaluate")
    private String evaluate;
    /**
     * 学生id
     */
    @TableField("user_stu_id")
    private Integer userStuId;
    /**
     * 老师id
     */
    @TableField("user_tea_id")
    private Integer userTeaId;


    public static final String ID = "id";

    public static final String REMARK = "remark";

    public static final String EVALUATE = "evaluate";

    public static final String USER_STU_ID = "user_stu_id";

    public static final String USER_TEA_ID = "user_tea_id";

}
