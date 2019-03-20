/*
Navicat MySQL Data Transfer

Source Server         : tengxun
Source Server Version : 50722
Source Host           : 139.199.204.74:3306
Source Database       : ticket

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-03-20 15:42:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cinema`
-- ----------------------------
DROP TABLE IF EXISTS `cinema`;
CREATE TABLE `cinema` (
  `cinema_id` int(11) NOT NULL AUTO_INCREMENT,
  `cinema_name` varchar(20) NOT NULL,
  `location` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cinema_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cinema
-- ----------------------------
INSERT INTO `cinema` VALUES ('1', '首都电影院', '西城区西单北大街甲131号大悦城商场十层');
INSERT INTO `cinema` VALUES ('2', '星空影城', '西三环南路10号月恒正大新生活广场三层');
INSERT INTO `cinema` VALUES ('3', '万达影城', '西铁营中路1号万达广场七层万达影城');

-- ----------------------------
-- Table structure for `form`
-- ----------------------------
DROP TABLE IF EXISTS `form`;
CREATE TABLE `form` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_time` char(20) NOT NULL,
  `user_id` int(11) NOT NULL,
  `screen_id` int(11) NOT NULL,
  `seat_x` int(11) NOT NULL,
  `seat_y` int(11) NOT NULL,
  `code` char(80) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  KEY `screen_id` (`screen_id`),
  KEY `seat_id` (`seat_x`),
  CONSTRAINT `form_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `form_ibfk_2` FOREIGN KEY (`screen_id`) REFERENCES `screen` (`screen_id`)
) ENGINE=InnoDB AUTO_INCREMENT=199 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of form
-- ----------------------------
INSERT INTO `form` VALUES ('80', '2018年9月13日14时30分9秒', '11', '4', '5', '7', '9fc1fbf78aaf4d9c90df54ab21f297e69e1c8cc5e43f4ff9a53826bb76510c3f');
INSERT INTO `form` VALUES ('81', '2018年9月13日14时30分9秒', '11', '4', '5', '6', '9fc1fbf78aaf4d9c90df54ab21f297e69e1c8cc5e43f4ff9a53826bb76510c3f');
INSERT INTO `form` VALUES ('82', '2018年9月13日14时30分9秒', '11', '4', '6', '6', '9fc1fbf78aaf4d9c90df54ab21f297e69e1c8cc5e43f4ff9a53826bb76510c3f');
INSERT INTO `form` VALUES ('83', '2018年9月13日14时30分9秒', '11', '4', '6', '7', '9fc1fbf78aaf4d9c90df54ab21f297e69e1c8cc5e43f4ff9a53826bb76510c3f');
INSERT INTO `form` VALUES ('84', '2018年9月13日14时30分9秒', '11', '4', '7', '7', '9fc1fbf78aaf4d9c90df54ab21f297e69e1c8cc5e43f4ff9a53826bb76510c3f');
INSERT INTO `form` VALUES ('85', '2018年9月13日14时30分37秒', '11', '4', '7', '6', '3c7782f01523472faf60e57b06462c7bc537e986fe9c41a38a4af955dfe08982');
INSERT INTO `form` VALUES ('86', '2018年9月13日14时31分8秒', '11', '4', '9', '4', '8f8785c8af494a48becdb94a94c2b558ed87d4b42f204d33b28fee4e3f75351f');
INSERT INTO `form` VALUES ('87', '2018年9月13日14时31分8秒', '11', '4', '10', '5', '8f8785c8af494a48becdb94a94c2b558ed87d4b42f204d33b28fee4e3f75351f');
INSERT INTO `form` VALUES ('88', '2018年9月13日14时35分34秒', '11', '25', '6', '7', 'dda002731ecc4e689b1494555b0e8e4cebc57c358aa5456c837d9bc1eeb87a95');
INSERT INTO `form` VALUES ('89', '2018年9月13日14时55分11秒', '11', '10', '7', '6', '5fba83018fc34613875963f402ec552078259abae88046159e7b18fccca41997');
INSERT INTO `form` VALUES ('90', '2018年9月13日14时58分22秒', '11', '19', '10', '7', 'f5387d3404e4466d95b1701aadf21412e36a8f89af4b47cd8357b37b00c67713');
INSERT INTO `form` VALUES ('91', '2018年9月13日14时58分22秒', '11', '19', '9', '6', 'f5387d3404e4466d95b1701aadf21412e36a8f89af4b47cd8357b37b00c67713');
INSERT INTO `form` VALUES ('92', '2018年9月13日14时58分22秒', '11', '19', '9', '7', 'f5387d3404e4466d95b1701aadf21412e36a8f89af4b47cd8357b37b00c67713');
INSERT INTO `form` VALUES ('121', '2018年9月14日20时9分31秒', '11', '16', '7', '6', '9f4db307a7074b328d8a053cd8bd34023ec75f197f69495c9230f537c283a87b');
INSERT INTO `form` VALUES ('125', '2018年9月18日0时3分11秒', '12', '25', '8', '6', 'a6ce679588e54a65919aeb6dd2fc363e223668e81823459da916033085ae3780');
INSERT INTO `form` VALUES ('127', '2018年9月19日1时1分48秒', '11', '11', '7', '2', '61da8f990f30499388f4444c0467cc69a665ccea002740a5a54206c4139f9375');
INSERT INTO `form` VALUES ('128', '2018年9月19日1时1分48秒', '11', '11', '7', '3', '61da8f990f30499388f4444c0467cc69a665ccea002740a5a54206c4139f9375');
INSERT INTO `form` VALUES ('129', '2018年9月19日1时1分48秒', '11', '11', '3', '8', '61da8f990f30499388f4444c0467cc69a665ccea002740a5a54206c4139f9375');
INSERT INTO `form` VALUES ('130', '2018年9月19日1时1分48秒', '11', '11', '7', '4', '61da8f990f30499388f4444c0467cc69a665ccea002740a5a54206c4139f9375');
INSERT INTO `form` VALUES ('131', '2018年9月19日1时1分48秒', '11', '11', '7', '5', '61da8f990f30499388f4444c0467cc69a665ccea002740a5a54206c4139f9375');
INSERT INTO `form` VALUES ('132', '2018年9月19日1时1分48秒', '11', '11', '6', '5', '61da8f990f30499388f4444c0467cc69a665ccea002740a5a54206c4139f9375');
INSERT INTO `form` VALUES ('133', '2018年9月19日1时1分48秒', '11', '11', '5', '5', '61da8f990f30499388f4444c0467cc69a665ccea002740a5a54206c4139f9375');
INSERT INTO `form` VALUES ('134', '2018年9月19日1时1分48秒', '11', '11', '8', '5', '61da8f990f30499388f4444c0467cc69a665ccea002740a5a54206c4139f9375');
INSERT INTO `form` VALUES ('135', '2018年9月19日1时1分48秒', '11', '11', '9', '5', '61da8f990f30499388f4444c0467cc69a665ccea002740a5a54206c4139f9375');
INSERT INTO `form` VALUES ('136', '2018年9月19日1时1分48秒', '11', '11', '9', '5', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('137', '2018年9月19日1时1分48秒', '11', '11', '6', '3', '61da8f990f30499388f4444c0467cc69a665ccea002740a5a54206c4139f9375');
INSERT INTO `form` VALUES ('138', '2018年9月19日1时1分48秒', '11', '11', '6', '3', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('140', '2018年9月19日1时1分48秒', '11', '11', '8', '3', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('141', '2018年9月19日1时1分48秒', '11', '11', '5', '6', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('142', '2018年9月19日1时1分48秒', '11', '11', '5', '7', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('143', '2018年9月19日1时1分48秒', '11', '11', '4', '7', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('144', '2018年9月19日1时1分48秒', '11', '11', '6', '7', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('145', '2018年9月19日1时1分48秒', '11', '11', '9', '6', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('146', '2018年9月19日1时1分48秒', '11', '11', '9', '7', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('147', '2018年9月19日1时1分48秒', '11', '11', '8', '7', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('148', '2018年9月19日1时1分48秒', '11', '11', '10', '7', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('149', '2018年9月19日1时1分48秒', '11', '11', '9', '8', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('150', '2018年9月19日1时1分48秒', '11', '11', '9', '9', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('151', '2018年9月19日1时1分48秒', '11', '11', '8', '9', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('152', '2018年9月19日1时1分48秒', '11', '11', '10', '9', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('153', '2018年9月19日1时1分48秒', '11', '11', '11', '9', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('154', '2018年9月19日1时1分48秒', '11', '11', '5', '8', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('155', '2018年9月19日1时1分48秒', '11', '11', '5', '9', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('156', '2018年9月19日1时1分48秒', '11', '11', '7', '9', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('157', '2018年9月19日1时1分48秒', '11', '11', '6', '9', '69f808ea715b4c8d8bb186f61027de1059b5692de4e94d9e9b32c85ee912b433');
INSERT INTO `form` VALUES ('158', '2018年9月20日17时3分4秒', '9', '34', '7', '9', '9589de6edc614f009d2d75faac222d54f1d8339b1c944457ad07e47fd5987368');
INSERT INTO `form` VALUES ('165', '2018年10月30日17时30分43秒', '10', '45', '3', '4', '79d495e7b95b4c408487499385f0fedcf3d4caf059a748ce962835f09dc0304f');
INSERT INTO `form` VALUES ('168', '2018年11月16日12时15分44秒', '8', '3', '2', '4', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('169', '2018年11月16日12时15分44秒', '8', '3', '3', '4', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('170', '2018年11月16日12时15分44秒', '8', '3', '4', '4', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('171', '2018年11月16日12时15分44秒', '8', '3', '5', '4', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('172', '2018年11月16日12时15分44秒', '8', '3', '6', '4', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('173', '2018年11月16日12时15分44秒', '8', '3', '4', '3', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('174', '2018年11月16日12时15分44秒', '8', '3', '4', '5', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('175', '2018年11月16日12时15分44秒', '8', '3', '4', '6', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('176', '2018年11月16日12时15分44秒', '8', '3', '3', '6', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('177', '2018年11月16日12时15分44秒', '8', '3', '5', '6', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('178', '2018年11月16日12时15分44秒', '8', '3', '8', '4', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('179', '2018年11月16日12时15分44秒', '8', '3', '10', '4', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('180', '2018年11月16日12时15分44秒', '8', '3', '11', '4', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('181', '2018年11月16日12时15分44秒', '8', '3', '11', '5', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('182', '2018年11月16日12时15分44秒', '8', '3', '11', '6', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('183', '2018年11月16日12时15分44秒', '8', '3', '11', '7', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('184', '2018年11月16日12时15分44秒', '8', '3', '10', '7', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('185', '2018年11月16日12时15分44秒', '8', '3', '10', '3', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('186', '2018年11月16日12时15分44秒', '8', '3', '9', '4', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('187', '2018年11月16日12时15分44秒', '8', '3', '9', '5', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('188', '2018年11月16日12时15分44秒', '8', '3', '8', '6', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('189', '2018年11月16日12时15分44秒', '8', '3', '7', '7', 'd8fdba01230d4ca6bcdb90136ce33012bae9a5431607431f98cf64ba3f50915b');
INSERT INTO `form` VALUES ('190', '2018年11月22日11时32分32秒', '8', '45', '7', '4', '34c2ad6e88da4f2c9277809c36d697a3eb963e9160d1458aae0ca097419f85de');
INSERT INTO `form` VALUES ('191', '2019年1月1日13时9分5秒', '16', '1', '9', '4', '7b85008fd2574b6c96f093b820f102a167175ee7cdf0445ea1d7f938dc587373');
INSERT INTO `form` VALUES ('192', '2019年1月3日10时5分16秒', '17', '13', '9', '6', '6004a29f1e1542e8b4e81992825b5632cdb7526243204db584c33886fc28d919');
INSERT INTO `form` VALUES ('193', '2019年1月3日10时11分39秒', '17', '42', '8', '6', '10c0f72098bf484a924285b8da8d5f966473f43ebf5040969128b9a7eba0248e');
INSERT INTO `form` VALUES ('194', '2019年1月11日17时31分39秒', '8', '13', '9', '7', '337ac259c6f14eae8b2983a792c43050632e2c9bebd8456ea6946a874e1eece0');
INSERT INTO `form` VALUES ('195', '2019年1月12日10时24分11秒', '8', '31', '8', '5', 'cfc1416ee27146b69eb68ddfa356ba0b18d2168095354d1592f1364f128042c6');
INSERT INTO `form` VALUES ('196', '2019年1月12日10时24分11秒', '8', '31', '6', '5', 'cfc1416ee27146b69eb68ddfa356ba0b18d2168095354d1592f1364f128042c6');
INSERT INTO `form` VALUES ('197', '2019年1月12日10时24分11秒', '8', '31', '7', '6', 'cfc1416ee27146b69eb68ddfa356ba0b18d2168095354d1592f1364f128042c6');
INSERT INTO `form` VALUES ('198', '2019年1月12日10时24分11秒', '8', '31', '7', '5', 'cfc1416ee27146b69eb68ddfa356ba0b18d2168095354d1592f1364f128042c6');

-- ----------------------------
-- Table structure for `movie`
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie` (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `movie_name` varchar(20) NOT NULL,
  `release` varchar(20) NOT NULL,
  `post_url` varchar(100) NOT NULL,
  `introduction` varchar(100) NOT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES ('1', '肖申克的救赎', '1994-09-10', './img/1.jpg', '该片改编自斯蒂芬·金《四季奇谭》中收录的同名小说，该片中涵盖全片的主题是“希望”，全片透过监狱这一强制剥夺自由、高度强调纪律的特殊背景来展现作为个体的人对“时间流逝、环境改造”的恐惧。');
INSERT INTO `movie` VALUES ('2', '阿甘正传', '1994-07-06', './img/2.jpg', '电影改编自美国作家温斯顿·格卢姆于1986年出版的同名小说，描绘了先天智障的小镇男孩福瑞斯特·甘自强不息，最终“傻人有傻福”地得到上天眷顾，在多个领域创造奇迹的励志故事.');
INSERT INTO `movie` VALUES ('3', '盗梦空间', '2009-07-13', './img/3.jpg', '影片讲述由莱昂纳多·迪卡普里奥扮演的造梦师，带领约瑟夫·高登-莱维特、艾伦·佩吉扮演的特工团队，进入他人梦境，从他人的潜意识中盗取机密，并重塑他人梦境的故事。');
INSERT INTO `movie` VALUES ('4', '疯狂动物城', '2016-03-04', './img/4.jpg', '该片讲述了在一个所有动物和平共处的动物城市，兔子朱迪通过自己努力奋斗完成自己儿时的梦想，成为动物警察的故事。');
INSERT INTO `movie` VALUES ('5', '美丽人生', '1997-12-20', './img/5.jpg', '该片讲述了一对犹太父子被送进了纳粹集中营，父亲利用自己的想像力扯谎说他们正身处一个游戏当中，最后父亲让儿子的童心没有受到伤害，而自己却惨死的故事。');
INSERT INTO `movie` VALUES ('6', '爱乐之城', '2016-12-16', './img/6.jpg', '该片讲述一位爵士乐钢琴家与一名怀揣梦想的女演员之间的爱情故事。');
INSERT INTO `movie` VALUES ('7', '海上钢琴师', '1998-10-28', './img/7.jpg', '该片改编自亚利桑德罗·巴里克文学剧本《1900：独白》，讲述了一个被命名为“1900”的弃婴在一艘远洋客轮上与钢琴结缘，成为钢琴大师的传奇故事。');
INSERT INTO `movie` VALUES ('8', '头脑特工队', '2015-06-19', './img/8.jpg', '该片讲述了小女孩莱莉因为爸爸的工作变动而搬到旧金山，她的生活被这五种情绪所掌控。 尽展脑内情绪的缤纷世界。');
INSERT INTO `movie` VALUES ('9', '乱世佳人', '1939-09-09', './img/9.jpg', '影片以美国南北战争为背景，讲述了主人公斯嘉丽与白瑞德之间一段跌宕起伏的爱情故事。');
INSERT INTO `movie` VALUES ('10', '2012', '2009-11-13', './img/10.jpg', '影片故事发生在2012年12月，一家人正在度假。没想到根据玛雅预言，2012年的12月21日，正是世界末日，玛雅人的日历也到那天为止，再没有下一页。电影讲述了主人公以及世界各国人民挣扎求生的经历。');

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `room_id` int(11) NOT NULL AUTO_INCREMENT,
  `cinema_id` int(11) NOT NULL,
  `room_name` varchar(20) NOT NULL,
  `room_row` int(11) NOT NULL,
  `room_column` int(11) NOT NULL,
  PRIMARY KEY (`room_id`),
  KEY `cenima_id` (`cinema_id`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`cinema_id`) REFERENCES `cinema` (`cinema_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1', '1', '第1放映厅', '8', '12');
INSERT INTO `room` VALUES ('2', '1', '第2放映厅', '8', '12');
INSERT INTO `room` VALUES ('3', '1', '第3放映厅', '10', '15');
INSERT INTO `room` VALUES ('4', '1', '第4放映厅', '10', '15');
INSERT INTO `room` VALUES ('5', '1', '第5放映厅', '10', '15');
INSERT INTO `room` VALUES ('6', '1', '第6放映厅', '12', '18');
INSERT INTO `room` VALUES ('7', '1', '第7放映厅', '12', '18');
INSERT INTO `room` VALUES ('8', '2', '东部放映厅', '10', '14');
INSERT INTO `room` VALUES ('9', '2', '南部放映厅', '10', '14');
INSERT INTO `room` VALUES ('10', '2', '西部放映厅', '10', '14');
INSERT INTO `room` VALUES ('11', '2', '北部放映厅', '10', '14');
INSERT INTO `room` VALUES ('12', '2', '中部放映厅', '12', '16');
INSERT INTO `room` VALUES ('13', '3', '1号放映室', '8', '12');
INSERT INTO `room` VALUES ('14', '3', '2号放映室', '10', '15');
INSERT INTO `room` VALUES ('15', '3', '3号放映室', '12', '20');

-- ----------------------------
-- Table structure for `screen`
-- ----------------------------
DROP TABLE IF EXISTS `screen`;
CREATE TABLE `screen` (
  `screen_id` int(11) NOT NULL AUTO_INCREMENT,
  `cenima_id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `time` char(20) NOT NULL,
  `room_id` int(11) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`screen_id`),
  KEY `cenima_id` (`cenima_id`),
  KEY `movie_id` (`movie_id`),
  KEY `room_id` (`room_id`),
  CONSTRAINT `screen_ibfk_1` FOREIGN KEY (`cenima_id`) REFERENCES `cinema` (`cinema_id`),
  CONSTRAINT `screen_ibfk_2` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`movie_id`),
  CONSTRAINT `screen_ibfk_3` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of screen
-- ----------------------------
INSERT INTO `screen` VALUES ('1', '1', '1', '2018/09/15 8:00', '1', '175');
INSERT INTO `screen` VALUES ('2', '1', '1', '2018/09/15 14:00', '1', '125');
INSERT INTO `screen` VALUES ('3', '1', '1', '2018/09/15 21:00', '1', '195');
INSERT INTO `screen` VALUES ('4', '1', '2', '2018/09/15 8:30', '2', '105');
INSERT INTO `screen` VALUES ('5', '1', '2', '2018/09/15 13:30', '2', '95');
INSERT INTO `screen` VALUES ('6', '1', '2', '2018/09/15 19:30', '2', '125');
INSERT INTO `screen` VALUES ('7', '1', '3', '2018/09/15 9:00', '3', '155');
INSERT INTO `screen` VALUES ('8', '1', '3', '2018/09/15 14:30', '3', '145');
INSERT INTO `screen` VALUES ('9', '1', '3', '2018/09/15 20:00', '3', '175');
INSERT INTO `screen` VALUES ('10', '1', '4', '2018/09/15 10:00', '4', '85');
INSERT INTO `screen` VALUES ('11', '1', '4', '2018/09/15 16:00', '4', '65');
INSERT INTO `screen` VALUES ('12', '1', '4', '2018/09/15 20:30', '4', '105');
INSERT INTO `screen` VALUES ('13', '1', '5', '2018/09/15 9:30', '5', '125');
INSERT INTO `screen` VALUES ('14', '1', '5', '2018/09/15 15:00', '5', '105');
INSERT INTO `screen` VALUES ('15', '1', '5', '2018/09/15 22:00', '5', '145');
INSERT INTO `screen` VALUES ('16', '1', '6', '2018/09/15 10:30', '6', '165');
INSERT INTO `screen` VALUES ('17', '1', '6', '2018/09/15 15:30', '6', '155');
INSERT INTO `screen` VALUES ('18', '1', '6', '2018/09/15 21:30', '6', '185');
INSERT INTO `screen` VALUES ('19', '1', '7', '2018/09/15 11:00', '7', '155');
INSERT INTO `screen` VALUES ('20', '1', '7', '2018/09/16 17:00', '7', '135');
INSERT INTO `screen` VALUES ('21', '1', '7', '2018/09/16 22:30', '7', '175');
INSERT INTO `screen` VALUES ('22', '1', '8', '2018/09/17 10:00', '1', '55');
INSERT INTO `screen` VALUES ('23', '1', '8', '2018/09/17 16:30', '1', '35');
INSERT INTO `screen` VALUES ('24', '1', '8', '2018/09/17 19:30', '1', '75');
INSERT INTO `screen` VALUES ('25', '1', '9', '2018/09/18 10:30', '2', '105');
INSERT INTO `screen` VALUES ('26', '1', '9', '2018/09/18 15:30', '2', '85');
INSERT INTO `screen` VALUES ('27', '1', '9', '2018/09/18 18:30', '2', '125');
INSERT INTO `screen` VALUES ('28', '1', '10', '2018/09/18  11:00', '3', '115');
INSERT INTO `screen` VALUES ('29', '1', '10', '2018/09/18 16:00', '3', '95');
INSERT INTO `screen` VALUES ('30', '1', '10', '2018/09/18 22:00', '3', '135');
INSERT INTO `screen` VALUES ('31', '2', '1', '2018/09/18 9:00', '8', '165');
INSERT INTO `screen` VALUES ('32', '2', '1', '2018/09/19 20:00', '8', '185');
INSERT INTO `screen` VALUES ('33', '2', '2', '2018/09/19 10:30', '9', '95');
INSERT INTO `screen` VALUES ('34', '2', '2', '2018/09/19 19:00', '9', '115');
INSERT INTO `screen` VALUES ('35', '2', '3', '2018/09/19 10:00', '10', '145');
INSERT INTO `screen` VALUES ('36', '2', '3', '2018/09/19 18:30', '10', '165');
INSERT INTO `screen` VALUES ('37', '2', '4', '2018/09/19 11:00', '11', '75');
INSERT INTO `screen` VALUES ('38', '2', '4', '2018/09/19 19:30', '11', '95');
INSERT INTO `screen` VALUES ('39', '2', '5', '2018/09/19 9:30', '12', '105');
INSERT INTO `screen` VALUES ('40', '2', '5', '2018/09/19 21:00', '12', '115');
INSERT INTO `screen` VALUES ('41', '2', '6', '2018/09/19 11:00', '8', '155');
INSERT INTO `screen` VALUES ('42', '2', '6', '2018/09/19 22:00', '8', '165');
INSERT INTO `screen` VALUES ('43', '2', '7', '2018/09/19 8:30', '9', '145');
INSERT INTO `screen` VALUES ('44', '2', '7', '2018/09/19 21:30', '9', '165');
INSERT INTO `screen` VALUES ('45', '3', '1', '2018/09/19 10:00', '13', '155');
INSERT INTO `screen` VALUES ('46', '3', '2', '2018/09/19 14:00', '14', '105');
INSERT INTO `screen` VALUES ('47', '3', '3', '2018/09/19 16:00', '15', '155');
INSERT INTO `screen` VALUES ('48', '3', '4', '2018/09/19 15:00', '13', '85');
INSERT INTO `screen` VALUES ('49', '3', '5', '2018/09/19 9:00', '14', '95');
INSERT INTO `screen` VALUES ('50', '3', '6', '2018/09/19 9:30', '15', '145');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(80) NOT NULL,
  `password` varchar(20) NOT NULL,
  `money` float(16,0) NOT NULL,
  `portrait_url` varchar(200) NOT NULL,
  `openid` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- View structure for `cinema_screen`
-- ----------------------------
DROP VIEW IF EXISTS `cinema_screen`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `cinema_screen` AS select `screen`.`screen_id` AS `screen_id`,`movie`.`movie_id` AS `movie_id`,`cinema`.`cinema_name` AS `cinema_name`,`cinema`.`location` AS `location`,`movie`.`movie_name` AS `movie_name`,`screen`.`time` AS `time`,`screen`.`price` AS `price`,`room`.`room_name` AS `room_name` from (((`cinema` join `screen`) join `movie`) join `room`) where ((`screen`.`movie_id` = `movie`.`movie_id`) and (`screen`.`cenima_id` = `cinema`.`cinema_id`) and (`room`.`room_id` = `screen`.`room_id`)) ;

-- ----------------------------
-- View structure for `formview`
-- ----------------------------
DROP VIEW IF EXISTS `formview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `formview` AS select `form`.`order_id` AS `order_id`,`form`.`order_time` AS `order_time`,`form`.`user_id` AS `user_id`,`screen`.`time` AS `time`,`movie`.`movie_id` AS `movie_id`,`movie`.`movie_name` AS `movie_name`,`cinema`.`cinema_id` AS `cinema_id`,`cinema`.`cinema_name` AS `cinema_name` from (((`form` join `screen`) join `movie`) join `cinema`) where ((`form`.`screen_id` = `screen`.`screen_id`) and (`screen`.`cenima_id` = `cinema`.`cinema_id`) and (`screen`.`movie_id` = `movie`.`movie_id`)) ;

-- ----------------------------
-- View structure for `room_view`
-- ----------------------------
DROP VIEW IF EXISTS `room_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `room_view` AS select `room`.`room_name` AS `room_name`,`movie`.`movie_name` AS `movie_name`,`cinema`.`cinema_name` AS `cinema_name`,`screen`.`screen_id` AS `screen_id`,`screen`.`time` AS `time`,`room`.`room_row` AS `room_row`,`room`.`room_column` AS `room_column`,`screen`.`price` AS `price` from (((`screen` join `room`) join `movie`) join `cinema`) where ((`screen`.`cenima_id` = `cinema`.`cinema_id`) and (`screen`.`movie_id` = `movie`.`movie_id`) and (`screen`.`room_id` = `room`.`room_id`)) ;

-- ----------------------------
-- View structure for `UserInfo`
-- ----------------------------
DROP VIEW IF EXISTS `UserInfo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `UserInfo` AS select `cinema`.`cinema_name` AS `cinema_name`,`room`.`room_name` AS `room_name`,`movie`.`movie_name` AS `movie_name`,`screen`.`time` AS `time`,`form`.`order_time` AS `order_time`,`user`.`user_id` AS `user_id`,`form`.`order_id` AS `order_id`,`form`.`seat_x` AS `seat_x`,`form`.`seat_y` AS `seat_y`,`screen`.`price` AS `price` from (((((`movie` join `screen`) join `cinema`) join `room`) join `form`) join `user`) where ((`form`.`user_id` = `user`.`user_id`) and (`form`.`screen_id` = `screen`.`screen_id`) and (`screen`.`room_id` = `room`.`room_id`) and (`screen`.`movie_id` = `movie`.`movie_id`) and (`screen`.`cenima_id` = `cinema`.`cinema_id`)) ;
