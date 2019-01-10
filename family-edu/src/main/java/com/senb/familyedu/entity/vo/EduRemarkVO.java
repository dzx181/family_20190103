package com.senb.familyedu.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.senb.familyedu.entity.EduUser;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("edu_course")
public class EduRemarkVO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer id;


    private String remark;


    private String evaluate;


    private EduUser userStu;


    private Integer userTeaId;


}
