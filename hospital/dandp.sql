/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : dandp

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2021-06-21 18:24:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_case
-- ----------------------------
DROP TABLE IF EXISTS `t_case`;
CREATE TABLE `t_case` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `patients_id` int(11) DEFAULT NULL COMMENT '患者id',
  `doctor_id` int(11) DEFAULT NULL COMMENT '医生id',
  `remake` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '病例详情',
  `recipe` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '处方信息',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='病例表';

-- ----------------------------
-- Records of t_case
-- ----------------------------
INSERT INTO `t_case` VALUES ('3', '88', '86', '测试病例详情', '测试处方信息', '2021-05-07 15:34:03', '2021-05-07 16:48:46');
INSERT INTO `t_case` VALUES ('4', '90', '89', '123', '123', '2021-05-07 19:55:12', '2021-05-25 00:17:23');
INSERT INTO `t_case` VALUES ('12', '96', '86', '123123', '12321312', '2021-07-02 11:59:35', '2021-07-02 12:23:47');
INSERT INTO `t_case` VALUES ('13', '96', '86', '1231123', '1231212312', '2021-07-03 10:23:59', '2021-07-03 10:27:15');
INSERT INTO `t_case` VALUES ('14', '97', '98', '晚上睡不着，有病', '安眠药加酒，你值得拥有！', '2021-06-21 15:20:46', '2021-06-21 15:23:14');

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `dep_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '科室名',
  `letter` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '医院编号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='医院科室表';

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '神经科', 'A', '2021-05-04 11:44:40', '2021-05-04 11:44:40');
INSERT INTO `t_department` VALUES ('3', '外科', 'B', '2021-05-05 11:22:25', '2021-05-05 11:22:25');
INSERT INTO `t_department` VALUES ('4', '眼鼻喉科', 'C', '2021-06-21 18:19:07', '2021-06-21 18:19:07');
INSERT INTO `t_department` VALUES ('5', '呼吸科', 'B', '2021-06-21 18:20:16', '2021-06-21 18:20:16');

-- ----------------------------
-- Table structure for t_questions
-- ----------------------------
DROP TABLE IF EXISTS `t_questions`;
CREATE TABLE `t_questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `title` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '问题/回复',
  `parent_id` int(11) DEFAULT NULL COMMENT '问题id',
  `doctor_id` int(11) DEFAULT NULL COMMENT '医生Id',
  `patient_id` int(11) DEFAULT NULL COMMENT '问题所属患者id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='问答表';

-- ----------------------------
-- Records of t_questions
-- ----------------------------
INSERT INTO `t_questions` VALUES ('3', '睡不着咋办？？', null, null, '90', '2021-05-07 22:47:59', '2021-05-07 22:47:59');
INSERT INTO `t_questions` VALUES ('4', '回答测试', '3', '86', '90', '2021-05-07 23:03:49', '2021-05-07 23:03:49');
INSERT INTO `t_questions` VALUES ('5', '此事件发生', '3', '86', '90', '2021-05-07 23:06:15', '2021-05-07 23:06:15');
INSERT INTO `t_questions` VALUES ('6', '测试', '3', '86', '90', '2021-05-07 23:31:36', '2021-05-07 23:31:36');
INSERT INTO `t_questions` VALUES ('7', '1111', '3', '44', '90', '2021-05-24 22:59:46', '2021-05-24 22:59:46');
INSERT INTO `t_questions` VALUES ('8', '123', '3', '44', '90', '2021-05-24 23:02:47', '2021-05-24 23:02:47');
INSERT INTO `t_questions` VALUES ('9', '1232321321321', null, null, '88', '2021-05-24 23:46:16', '2021-05-24 23:46:16');
INSERT INTO `t_questions` VALUES ('10', '测试提问', null, null, '88', '2021-05-24 23:48:52', '2021-05-24 23:48:52');
INSERT INTO `t_questions` VALUES ('11', '你有病，去治疗', '10', '98', '88', '2021-06-21 08:35:06', '2021-06-21 08:35:06');
INSERT INTO `t_questions` VALUES ('12', '晚上睡不着，胡思乱想', null, null, '97', '2021-06-21 15:21:19', '2021-06-21 15:21:19');
INSERT INTO `t_questions` VALUES ('13', '建议您吃10粒安眠药，外加一瓶酒', '12', '98', '97', '2021-06-21 15:22:29', '2021-06-21 15:22:29');

-- ----------------------------
-- Table structure for t_registration
-- ----------------------------
DROP TABLE IF EXISTS `t_registration`;
CREATE TABLE `t_registration` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '唯一编号',
  `time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '预约时间，默认为当前时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '挂号时间',
  `doctor_id` int(11) DEFAULT NULL COMMENT '挂号医生',
  `patients_id` int(11) DEFAULT NULL COMMENT '挂号患者Id',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0:未处理，1已处理',
  `evaluate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '满意，一般，不满意',
  `accept` int(11) DEFAULT NULL COMMENT '状态，1为采纳，2为不采纳',
  `is_cases` tinyint(1) DEFAULT NULL COMMENT '是否需要病历本',
  `amount_payable` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '扫码支付' COMMENT '结算类型',
  `level` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '挂号级别',
  `is_invoice` tinyint(1) DEFAULT '0' COMMENT '是否开票',
  `invoice_code` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '发票代码',
  `invoice_number` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '发票号',
  `invoice_date` date DEFAULT NULL COMMENT '开票日期',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `t_registration_number_uindex` (`number`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC COMMENT='挂号表';

-- ----------------------------
-- Records of t_registration
-- ----------------------------
INSERT INTO `t_registration` VALUES ('6', '20200507A1', '2021-05-07 15:34:03', '2021-05-07 15:34:03', '86', '90', '1', '666', '1', '1', '64.05', '扫码支付', '测试', '0', null, null, null);
INSERT INTO `t_registration` VALUES ('7', '20200507A2', '2021-05-05 00:00:00', '2021-05-07 19:55:12', '89', '90', '1', '牛皮', '2', '1', '64.05', '扫码支付', '测试', '0', null, null, null);
INSERT INTO `t_registration` VALUES ('9', '20200524A1', '2021-05-24 23:57:41', '2021-05-24 23:57:41', '86', '88', '1', '', null, '1', '64.05', '扫码支付', '测试', '0', null, null, null);
INSERT INTO `t_registration` VALUES ('10', '20200525A1', '2021-05-25 00:05:29', '2021-05-25 00:05:29', '86', '90', '0', '', null, '1', '64.05', '扫码支付', '测试', '0', null, null, null);
INSERT INTO `t_registration` VALUES ('11', '20200525A2', '2021-05-25 18:11:37', '2021-05-25 18:11:37', '86', '90', '0', '', null, '1', '64.05', '扫码支付', '测试', '0', null, null, null);
INSERT INTO `t_registration` VALUES ('12', '20200525A3', '2021-05-08 00:00:00', '2021-05-25 19:44:37', '89', '90', '1', '可以', '1', '1', '64.05', '扫码支付', '测试', '0', null, null, null);
INSERT INTO `t_registration` VALUES ('13', '20200525B1', '2021-05-25 19:45:00', '2021-05-25 19:45:00', '88', '90', '0', '', null, '1', '64.05', '扫码支付', '测试', '0', null, null, null);
INSERT INTO `t_registration` VALUES ('16', '20200702A1', '2021-07-02 11:13:51', '2021-07-02 11:14:00', '86', '96', '0', null, null, '1', '64.05', '扫码支付', '测试', '0', null, null, null);
INSERT INTO `t_registration` VALUES ('17', '20200702A2', '2021-07-02 11:16:17', '2021-07-02 11:16:23', '86', '96', '0', null, null, '1', '64.05', '扫码支付', '测试', '0', null, null, null);
INSERT INTO `t_registration` VALUES ('18', '20200702A3', '2021-07-02 11:21:01', '2021-07-02 11:21:13', '86', '96', '0', null, null, '1', '64.05', '扫码支付', '测试', '0', null, null, null);
INSERT INTO `t_registration` VALUES ('19', '20200702A4', '2021-07-29 11:00:00', '2021-07-02 11:24:56', '86', '96', '0', null, null, '1', '64.05', '扫码支付', '测试', '0', null, null, null);
INSERT INTO `t_registration` VALUES ('20', '20200702A5', '2021-07-02 11:41:27', '2021-07-02 11:41:27', '86', '96', '0', null, null, '1', '64.05', '扫码支付', '测试', '1', '838489053861', '301153303', '2021-07-03');
INSERT INTO `t_registration` VALUES ('21', '20200702A6', '2021-07-02 11:43:51', '2021-07-02 11:43:51', '86', '96', '0', null, null, '1', '73.84', '扫码支付', '测试', '1', '584268938746', '637242916', '2021-07-03');
INSERT INTO `t_registration` VALUES ('22', '20200702A7', '2021-07-02 11:57:24', '2021-07-02 11:57:43', '86', '96', '0', null, null, '1', '83.65', '扫码支付', '测试', '1', '813415740806', '101603616', '2021-07-02');
INSERT INTO `t_registration` VALUES ('23', '20200702A8', '2021-07-27 00:00:00', '2021-07-02 11:59:35', '86', '96', '1', null, null, '1', '93.99', '扫码支付', '测试', '0', null, null, null);
INSERT INTO `t_registration` VALUES ('24', '20200703A1', '2021-07-03 10:23:59', '2021-07-03 10:23:59', '86', '96', '1', '从v擦撒大苏打', '1', '1', '92.32', '扫码支付', '测试', '1', '421519069527', '287186092', '2021-07-03');
INSERT INTO `t_registration` VALUES ('25', '20210621B1', '2021-06-22 23:00:00', '2021-06-21 15:20:46', '98', '97', '1', '良医', '1', '1', '78.26', '扫码支付', '1', '1', '180140543743', '580304851', '2021-06-21');
INSERT INTO `t_registration` VALUES ('26', '20210621B2', '2021-06-21 15:39:04', '2021-06-21 15:39:04', '98', '97', '0', null, null, null, '50.11', '扫码支付', '1', '0', null, null, null);
INSERT INTO `t_registration` VALUES ('27', '20210621B3', '2021-06-21 15:43:30', '2021-06-21 15:43:30', '88', '97', '0', null, null, null, '86.57', '扫码支付', '1', '0', null, null, null);
INSERT INTO `t_registration` VALUES ('28', '20210621B4', '2021-06-21 15:46:26', '2021-06-21 15:46:26', '98', '97', '0', null, null, null, '61.29', '扫码支付', '1', '0', null, null, null);
INSERT INTO `t_registration` VALUES ('29', '20210621A1', '2021-06-21 15:48:28', '2021-06-21 15:48:28', '95', '97', '0', null, null, null, '59.80', '扫码支付', '1', '0', null, null, null);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `nick_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户昵称/真实姓名',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `email` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系电话',
  `last_login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上次登录Ip',
  `last_login_time` datetime DEFAULT NULL COMMENT '最近访问时间',
  `ssex` int(11) DEFAULT NULL COMMENT '性别 0男 1女 2保密',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '描述',
  `avatar` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '/image/avatar/imDefaultAvatar.png' COMMENT '用户头像',
  `school` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '医生毕业院校',
  `dep_id` int(11) DEFAULT NULL COMMENT '医生科室Id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '状态 0锁定 1有效,默认为1',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `role_id` int(11) NOT NULL COMMENT '角色，0微超级管理员，1为医生，2为患者',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE KEY `t_user_username_uindex` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统用户';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('44', 'admin', '麦田守望者', '0192023a7bbd73250516f069df18b500', 'chendikai@163.com', '13085152426', '125.75.21.103', '2021-05-08 00:12:23', '0', 'www.penint.vip', '/image/avatar/2021621/77688cbd-f898-4c02-801d-c5cdee611f59', null, null, '2021-05-06 11:29:00', '2021-06-21 09:10:39', '1', null, '0');
INSERT INTO `t_user` VALUES ('86', 'test1', 'test1', 'e10adc3949ba59abbe56e057f20f883e', '213@qq.com', '13090909090', '127.0.0.1', '2021-05-07 23:19:29', '0', '安徽医科大学硕士', '/image/avatar/2021620/710b4ce7-57cb-4530-95ff-0b1c0cc5597b', '安徽医科大学', '1', '2021-05-05 11:36:18', null, '1', '2021-05-24', '1');
INSERT INTO `t_user` VALUES ('88', 'doctor1', '医生1', 'e10adc3949ba59abbe56e057f20f883e', '123@qq.com', '13090901211', null, null, '0', null, '/image/avatar/2021620/1211262c-7bc8-421a-a7ad-99559f56f220', null, '3', '2021-05-06 16:30:45', null, '1', '2021-05-26', '1');
INSERT INTO `t_user` VALUES ('89', '123456q', '李建行', 'e10adc3949ba59abbe56e057f20f883e', '123456q@qq.com', '18523456789', '125.75.21.103', '2021-05-08 00:11:45', '0', '测试12321313131', '/image/avatar/2021620/51b35185-ef0a-4618-b354-0bfec6156595', '测试123123132131', '1', '2021-05-06 18:05:07', null, '1', '2010-05-11', '1');
INSERT INTO `t_user` VALUES ('90', '123456qq', '肖云鹏', 'e10adc3949ba59abbe56e057f20f883e', '123456qq@qq.com', '13978564790', '127.0.0.1', '2021-05-07 23:50:55', '0', null, '/image/avatar/defaultAvatar.png', null, null, '2021-05-06 18:07:40', null, '1', '2021-05-19', '2');
INSERT INTO `t_user` VALUES ('95', 'admin124', 'ce', 'e10adc3949ba59abbe56e057f20f883e', 'niko_hxx@163.com', '13252082376', null, null, '0', null, '/image/avatar/2021620/710b4ce7-57cb-4530-95ff-0b1c0cc5597b', null, '1', '2021-05-25 17:53:57', null, '1', '2021-05-01', '1');
INSERT INTO `t_user` VALUES ('96', 'huanz1', 'huanz1', 'e10adc3949ba59abbe56e057f20f883e', '123@qq.com', '13090901212', null, null, '0', null, '/image/avatar/defaultAvatar.png', null, null, '2021-07-02 10:40:53', null, '1', '2010-08-12', '2');
INSERT INTO `t_user` VALUES ('97', 'zhangsan', '张三', '01d7f40760960e7bd9443513f22ab9af', 'zhangsan@qq.com', '18085152426', null, null, '0', null, '/image/avatar/2021621/75652a8c-20d4-4f20-8d8e-a67af5ed2e88', null, null, '2021-06-20 21:20:33', null, '1', '2021-06-08', '2');
INSERT INTO `t_user` VALUES ('98', 'chendikai', '陈迪凯', '1bdaa4d5250a53d844e3816516d22219', 'chendikai@163.com', '18671420007', null, null, '0', null, '/image/avatar/2021621/a57f669c-4659-4800-8d40-7fad59c31dab', null, '3', '2021-06-20 21:48:27', null, '1', '1999-01-09', '1');
