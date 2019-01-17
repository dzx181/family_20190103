/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : db_edu

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-01-12 21:42:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for edu_course
-- ----------------------------
DROP TABLE IF EXISTS `edu_course`;
CREATE TABLE `edu_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '课程名',
  `vedio` varchar(255) DEFAULT NULL COMMENT '视频课程',
  `pic_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '课程封面图路径',
  `introdue` text COMMENT '课程介绍',
  `user_tea_id` int(11) DEFAULT NULL COMMENT '老师id',
  `time_section` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '时间段',
  `week` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '星期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for edu_remark
-- ----------------------------
DROP TABLE IF EXISTS `edu_remark`;
CREATE TABLE `edu_remark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '评论',
  `evaluate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评价',
  `user_stu_id` int(11) DEFAULT NULL COMMENT '学生id',
  `user_tea_id` int(11) DEFAULT NULL COMMENT '老师id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for edu_select
-- ----------------------------
DROP TABLE IF EXISTS `edu_select`;
CREATE TABLE `edu_select` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) DEFAULT NULL COMMENT '课程id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for edu_user
-- ----------------------------
DROP TABLE IF EXISTS `edu_user`;
CREATE TABLE `edu_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `status` int(11) DEFAULT NULL COMMENT '状态，1表管理员，2表老师，3表学生',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
