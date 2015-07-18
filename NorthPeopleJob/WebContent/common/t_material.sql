/*
Navicat MySQL Data Transfer

Source Server         : root@localhost
Source Server Version : 50520
Source Host           : 127.0.0.1:3306
Source Database       : northpeoplejob

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2015-07-08 23:15:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_material
-- ----------------------------
DROP TABLE IF EXISTS `t_material`;
CREATE TABLE `t_material` (
  `sn` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `department` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`sn`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*
徐伟 Date: 2015-07-10 16:23:00
注意！！！ 语句要逐条运行
**/
ALTER TABLE  `t_question` ADD  `isFirst` VARCHAR( 100 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT  '是本分类的第一个问题' AFTER  `type`
ALTER TABLE  `t_question` ADD  `fileA2` VARCHAR( 100 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT  '文件A2' AFTER  `fileA`
ALTER TABLE  `t_question` ADD  `fileB2` VARCHAR( 100 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT  '文件B2' AFTER  `fileB`
ALTER TABLE  `t_question` ADD  `fileC2` VARCHAR( 100 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT  '文件C2' AFTER  `fileC`
ALTER TABLE  `t_question` ADD  `fileD2` VARCHAR( 100 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT  '文件D2' AFTER  `fileD`
ALTER TABLE  `t_question` ADD  `fileE2` VARCHAR( 100 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT  '文件E2' AFTER  `fileE`
ALTER TABLE  `t_question` ADD  `fileF2` VARCHAR( 100 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT  '文件F2' AFTER  `fileF`
ALTER TABLE  `t_answer` ADD  `questionFrom` VARCHAR( 100 ) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT  '上一个题目' AFTER  `questionChoice`