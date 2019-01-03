package com.senb.familyedu.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
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
@TableName("edu_user")
public class EduUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    @TableField("usename")
    private String usename;
    /**
     * 密码
     */
    @TableField("password")
    private String password;
    /**
     * 性别
     */
    @TableField("sex")
    private String sex;
    /**
     * 电话
     */
    @TableField("phone")
    private String phone;
    /**
     * 状态，1表管理员，2表老师，3表学生
     */
    @TableField("status")
    private Integer status;


    public static final String ID = "id";

    public static final String USENAME = "usename";

    public static final String PASSWORD = "password";

    public static final String SEX = "sex";

    public static final String PHONE = "phone";

    public static final String STATUS = "status";

}
