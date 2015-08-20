SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for logging_event
-- ----------------------------
DROP TABLE IF EXISTS `logging_event`;
CREATE TABLE `logging_event` (
  `TIMESTMP` datetime NOT NULL,
  `FORMATTED_MESSAGE` varchar(4000) NOT NULL,
  `LOGGER_NAME` varchar(255) NOT NULL,
  `LEVEL_STRING` varchar(255) NOT NULL,
  `THREAD_NAME` varchar(255) DEFAULT NULL,
  `REFERENCE_FLAG` int(255) DEFAULT NULL,
  `ARG0` varchar(255) DEFAULT NULL,
  `ARG1` varchar(255) DEFAULT NULL,
  `ARG2` varchar(255) DEFAULT NULL,
  `ARG3` varchar(255) DEFAULT NULL,
  `CALLER_FILENAME` varchar(255) NOT NULL,
  `CALLER_CLASS` varchar(255) NOT NULL,
  `CALLER_METHOD` varchar(255) NOT NULL,
  `CALLER_LINE` varchar(255) NOT NULL,
  `EVENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`EVENT_ID`)
) ENGINE=MyISAM AUTO_INCREMENT=2173 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for logging_event_exception
-- ----------------------------
DROP TABLE IF EXISTS `logging_event_exception`;
CREATE TABLE `logging_event_exception` (
  `EVENT_ID` int(11) NOT NULL,
  `I` int(11) NOT NULL,
  `TRACE_LINE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`EVENT_ID`,`I`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for logging_event_property
-- ----------------------------
DROP TABLE IF EXISTS `logging_event_property`;
CREATE TABLE `logging_event_property` (
  `EVENT_ID` int(11) NOT NULL,
  `MAPPED_KEY` varchar(255) NOT NULL,
  `MAPPED_VALUE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`EVENT_ID`,`MAPPED_KEY`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for resources
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源ID,主键,自动递增',
  `PID` int(11) NOT NULL COMMENT '父级资源ID',
  `ENABLED` smallint(6) NOT NULL COMMENT '状态:0删除,1正常,2禁用',
  `NAME` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `LEVEL` int(11) DEFAULT NULL COMMENT '资源级别',
  `TYPE` smallint(6) DEFAULT NULL COMMENT '资源类型  1 菜单 0 非菜单',
  `DESC` varchar(50) DEFAULT NULL COMMENT '资源描述',
  `CODE` varchar(20) DEFAULT NULL COMMENT '方法上的code,用来控制权限',
  `URL` varchar(100) DEFAULT NULL COMMENT '资源链接地址',
  `ICON` varchar(255) DEFAULT NULL COMMENT '资源图片',
  `OPENTYPE` smallint(6) DEFAULT NULL COMMENT '菜单打开方式:0原窗口打开,1新窗口打开',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `MODIFER` varchar(50) DEFAULT NULL COMMENT '更新者',
  `ORDERBY` bigint(20) DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=323 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID,主键,自动递增',
  `ROLE_NAME` varchar(50) NOT NULL COMMENT '角色名称',
  `ROLE_DESC` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `ENABLED` smallint(6) DEFAULT NULL COMMENT '状态:0删除,1正常,2禁用',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `MODIFER` varchar(50) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for roles_resources
-- ----------------------------
DROP TABLE IF EXISTS `roles_resources`;
CREATE TABLE `roles_resources` (
  `ROLES_ID` int(11) NOT NULL COMMENT '角色表的外键,角色ID',
  `RESOURCES_ID` int(11) NOT NULL COMMENT '资源表的外键,资源ID',
  PRIMARY KEY (`ROLES_ID`,`RESOURCES_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户ID,主键自动递增',
  `USER_NAME` varchar(50) NOT NULL COMMENT '用户姓名',
  `GROUP_NAME` varchar(50) DEFAULT NULL COMMENT '用户组名称',
  `PASSWORD` varchar(64) NOT NULL COMMENT '用户密码',
  `REAL_NAME` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `TITLE` varchar(50) DEFAULT NULL COMMENT '头衔',
  `ENABLED` smallint(1) NOT NULL COMMENT '状态:0删除,1正常,2禁用',
  `EMAIL` varchar(64) DEFAULT NULL COMMENT '电子邮件',
  `MOBILE` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `MODIFER` varchar(50) DEFAULT NULL COMMENT '更新者',
  `WORK_STATUS` varchar(50) DEFAULT NULL COMMENT '工作状态',
  `DEPT_ID` bigint(20) DEFAULT NULL COMMENT '机构ID',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for users_roles
-- ----------------------------
DROP TABLE IF EXISTS `users_roles`;
CREATE TABLE `users_roles` (
  `USERS_ID` int(11) NOT NULL COMMENT '用户表的外键,用户ID',
  `ROLES_ID` int(11) NOT NULL COMMENT '角色表的外键,角色ID',
  PRIMARY KEY (`USERS_ID`,`ROLES_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
