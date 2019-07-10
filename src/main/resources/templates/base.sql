# Host: 122.152.200.229  (Version 5.7.23-0ubuntu0.16.04.1)
# Date: 2019-04-16 15:38:29
# Generator: MySQL-Front 6.1  (Build 1.26)


#
# Structure for table "t_role"
#

DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(100) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `desc` varchar(50) DEFAULT NULL,
  `attr1` varchar(100) DEFAULT NULL,
  `attr2` varchar(100) DEFAULT NULL,
  `attr3` varchar(100) DEFAULT NULL,
  `create_by` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

#
# Data for table "t_role"
#

INSERT INTO `t_role` VALUES (1,'ALL',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'admin'),(2,'INSERT,UPDATE,SELECT',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'agent'),(4,'SELECT',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'customer');

#
# Structure for table "t_user"
#

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `realname` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `attr1` varchar(100) DEFAULT NULL,
  `attr2` varchar(100) DEFAULT NULL,
  `attr3` varchar(100) DEFAULT NULL,
  `create_by` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

#
# Data for table "t_user"
#

INSERT INTO `t_user` VALUES (1,'changyu',NULL,'17712613272',1,'447556649@qq.com','202cb962ac59075b964b07152d234b70',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
