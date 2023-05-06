/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : codeoj

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 09/04/2023 17:18:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_menu`;
CREATE TABLE `admin_menu`  (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `menu_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `parent_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_menu
-- ----------------------------
INSERT INTO `admin_menu` VALUES (1, '仪表盘', '/admin/dashboard', '1', NULL, NULL, 'C', '2023-03-17 16:07:38', '2023-03-17 16:07:40', 0);
INSERT INTO `admin_menu` VALUES (2, '社区管理', '/admin/bbs', '1', NULL, NULL, 'M', '2023-03-17 16:13:46', '2023-03-17 16:13:49', 0);
INSERT INTO `admin_menu` VALUES (3, '靶场管理', '/admin/lab', '1', NULL, NULL, 'M', '2023-03-17 16:14:26', '2023-03-17 16:14:28', 0);
INSERT INTO `admin_menu` VALUES (4, '工具管理', '/admin/tool', '1', NULL, NULL, 'M', '2023-03-17 16:14:33', '2023-03-17 16:14:38', 0);
INSERT INTO `admin_menu` VALUES (5, '系统管理', '/admin/system', '1', NULL, NULL, 'M', '2023-03-17 16:14:36', '2023-03-17 16:14:40', 0);
INSERT INTO `admin_menu` VALUES (100, '社区评论管理', 'bbs-reply', '1', NULL, NULL, 'C', '2023-03-17 17:15:46', '2023-03-17 17:15:48', 2);
INSERT INTO `admin_menu` VALUES (101, '社区文章管理', 'bbs-article', '1', NULL, NULL, 'C', '2023-03-17 17:17:39', '2023-03-17 17:17:42', 2);
INSERT INTO `admin_menu` VALUES (102, '靶场管理', 'labs', '1', NULL, NULL, 'C', '2023-03-17 18:44:08', '2023-03-17 18:44:11', 3);
INSERT INTO `admin_menu` VALUES (103, '容器规则', 'labs-docker', '1', NULL, NULL, 'C', '2023-03-17 18:44:34', '2023-03-17 18:44:39', 3);
INSERT INTO `admin_menu` VALUES (104, '工具管理', 'tools', '1', NULL, NULL, 'C', '2023-03-17 18:45:56', '2023-03-17 18:45:59', 4);
INSERT INTO `admin_menu` VALUES (105, '用户管理', 'user', '1', NULL, NULL, 'C', '2023-03-17 18:46:28', '2023-03-17 18:46:31', 5);
INSERT INTO `admin_menu` VALUES (106, '角色管理', 'role', '1', NULL, NULL, 'C', '2023-03-17 18:46:55', '2023-03-17 18:46:57', 5);
INSERT INTO `admin_menu` VALUES (107, '菜单管理', 'menu', '1', NULL, NULL, 'C', '2023-03-17 18:47:14', '2023-03-17 18:47:16', 5);
INSERT INTO `admin_menu` VALUES (1000, '用户增加', NULL, '1', NULL, 'admin:user:add', 'B', '2023-04-08 23:29:23', '2023-04-08 23:29:26', NULL);
INSERT INTO `admin_menu` VALUES (1001, '用户更新', NULL, '1', NULL, 'admin:user:update', 'B', '2023-04-08 23:30:41', '2023-04-08 23:30:43', NULL);
INSERT INTO `admin_menu` VALUES (1002, '用户删除', NULL, '1', NULL, 'admin:user:delete', 'B', '2023-04-08 23:31:13', '2023-04-08 23:31:15', NULL);
INSERT INTO `admin_menu` VALUES (1003, '工具增加', NULL, '1', NULL, 'admin:tool:add', 'B', '2023-04-08 23:32:41', '2023-04-08 23:32:43', NULL);
INSERT INTO `admin_menu` VALUES (1004, '工具更新', NULL, '1', NULL, 'admin:tool:update', 'B', '2023-04-08 23:33:03', '2023-04-08 23:33:04', NULL);
INSERT INTO `admin_menu` VALUES (1005, '工具删除', NULL, '1', NULL, 'admin:tool:delete', 'B', '2023-04-08 23:33:33', '2023-04-08 23:33:35', NULL);
INSERT INTO `admin_menu` VALUES (1006, '文章增加', NULL, '1', NULL, 'admin:bbsarticle:add', 'B', '2023-04-08 23:35:04', '2023-04-08 23:35:06', NULL);
INSERT INTO `admin_menu` VALUES (1007, '文章更新', NULL, '1', NULL, 'admin:bbsarticle:update', 'B', '2023-04-08 23:35:33', '2023-04-08 23:35:35', NULL);
INSERT INTO `admin_menu` VALUES (1008, '文章删除', NULL, '1', NULL, 'admin:bbsarticle:delete', 'B', '2023-04-08 23:35:57', '2023-04-08 23:35:59', NULL);
INSERT INTO `admin_menu` VALUES (1009, '评论增加', NULL, '1', NULL, 'admin:bbsreply:add', 'B', '2023-04-08 23:36:31', '2023-04-08 23:36:33', NULL);
INSERT INTO `admin_menu` VALUES (1010, '评论更新', NULL, '1', NULL, 'admin:bbsreply:update', 'B', '2023-04-08 23:37:03', '2023-04-08 23:37:05', NULL);
INSERT INTO `admin_menu` VALUES (1011, '评论删除', NULL, '1', NULL, 'admin:bbsreply:delete', 'B', '2023-04-08 23:37:26', '2023-04-08 23:37:28', NULL);
INSERT INTO `admin_menu` VALUES (1012, '容器增加', NULL, '1', NULL, 'admin:labdocker:add', 'B', '2023-04-08 23:50:59', '2023-04-08 23:51:01', NULL);
INSERT INTO `admin_menu` VALUES (1013, '容器更新', NULL, '1', NULL, 'admin:labdocker:update', 'B', '2023-04-08 23:51:24', '2023-04-08 23:51:25', NULL);
INSERT INTO `admin_menu` VALUES (1014, '容器删除', NULL, '1', NULL, 'admin:labdocker:delete', 'B', '2023-04-08 23:51:40', '2023-04-08 23:51:42', NULL);
INSERT INTO `admin_menu` VALUES (1015, '容器配置增加', NULL, '1', NULL, 'admin:labconfig:add', 'B', '2023-04-08 23:52:31', '2023-04-08 23:52:33', NULL);
INSERT INTO `admin_menu` VALUES (1016, '容器配置更新', NULL, '1', NULL, 'admin:labconfig:update', 'B', '2023-04-08 23:52:50', '2023-04-08 23:52:52', NULL);
INSERT INTO `admin_menu` VALUES (1017, '容器配置删除', NULL, '1', NULL, 'admin:labconfig:delete', 'B', '2023-04-08 23:53:11', '2023-04-08 23:53:13', NULL);
INSERT INTO `admin_menu` VALUES (1018, '菜单增加', NULL, '1', NULL, 'admin:menu:add', 'B', '2023-04-08 23:53:54', '2023-04-08 23:53:56', NULL);
INSERT INTO `admin_menu` VALUES (1019, '菜单更新', NULL, '1', NULL, 'admin:menu:update', 'B', '2023-04-08 23:55:17', '2023-04-08 23:55:19', NULL);
INSERT INTO `admin_menu` VALUES (1020, '菜单删除', NULL, '1', NULL, 'admin:menu:delete', 'B', '2023-04-08 23:55:32', '2023-04-08 23:55:37', NULL);
INSERT INTO `admin_menu` VALUES (1021, '角色添加', NULL, '1', NULL, 'admin:role:add', 'B', '2023-04-08 23:56:40', '2023-04-08 23:56:42', NULL);
INSERT INTO `admin_menu` VALUES (1022, '角色更新', NULL, '1', NULL, 'admin:role:update', 'B', '2023-04-08 23:56:58', '2023-04-08 23:57:00', NULL);
INSERT INTO `admin_menu` VALUES (1023, '角色删除', NULL, '1', NULL, 'admin:role:delete', 'B', '2023-04-08 23:57:14', '2023-04-08 23:57:17', NULL);

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tags` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` int NOT NULL,
  `view` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `type_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `article_type_id`(`type_id`) USING BTREE,
  CONSTRAINT `article_type_id` FOREIGN KEY (`type_id`) REFERENCES `article_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, '一个测试标题显示', '位于 java.util.logging包下，是Java自带的日志框架，使用时不需要引用第三方类库，相对于其它框架虽然功能简单，但使用方便、学习成本低，主要应用在小型应用中。 组件介绍 Logger：被称为记录器，应用程序通过获取Logger对象，调用其API来发布日志信息。通常被认为是访问日志系统的入口。一般使用类的权限的名对实例进行命名，其命名具有继承机制。 Handler：被称为处理器，每个记录器都会关联一个或者一组Handler，记录器会将日志交给关联的处理器去进行相应处理，由处理器负责将日志做记录。Handler可以设置日志的输出位置。 Filter：过滤器，根据过滤条件来判断哪些日志会被记录，哪些日志会被略过。 Formatter：格式化组件，它负责对日志中的数据和信息进行转换和格式化，所以它决定了日志最终的输出格式。 Level：日志输出级别，每条日志都有一个关联的级别，根据输出级别的设置，用来展现最终所呈现的日志信息。 OFF：用来关闭日志记录 SEVERE：错误级别 WARNING：警告级别 INFO：关键级别，默认 CONFIG：配置级别 FINE：调试级别 FINER：普通级别 FINEST：详细级别 ALL：用来启用所有消息的日志记录 配置文件：默认为JAVA_HOME/jre/lib目录下的logging.properties。也可以通过LogManager的readConfiguration()方法来设置自己的配置文件。', '1,2', 1, '243', '2022-02-07 20:35:42', '2022-02-07 20:35:45', 1);
INSERT INTO `article` VALUES (2, '公告测试', '公告内容测试', 'test', 1, '107', '2022-02-09 15:17:20', '2022-02-09 15:17:22', 4);
INSERT INTO `article` VALUES (3, 'test', 'teet', 'sadsa,sadfsdaf', 1, '17', '2022-02-09 15:19:30', '2022-02-09 15:19:30', 1);
INSERT INTO `article` VALUES (4, '测试文章', '## 测试标题\n*测试斜线*\n#### 撒打算', '啊哈哈,玩5范德萨范德萨给', 1, '15', '2022-02-09 15:37:03', '2022-02-09 15:37:03', 1);
INSERT INTO `article` VALUES (5, '代码高亮测试', '```language\nconsole.log(111)\n```\n中间过渡\n```javascript\nconsole.log(111)\n```\n\n', '你好啊,sadf', 1, '80', '2022-02-09 16:08:53', '2022-02-09 16:08:53', 1);
INSERT INTO `article` VALUES (6, 'test11111', '## sdaasd\nsadasd\n```javascript\nconsole.log(111)\n```\n', 'a, b, c', 1, '11', '2022-02-09 23:56:52', '2022-02-09 23:56:52', 1);
INSERT INTO `article` VALUES (7, '测试222', '你好啊', 'java,spring', 1, '11', '2022-02-10 00:13:40', '2022-02-10 00:13:40', 1);
INSERT INTO `article` VALUES (8, '关于hiredis使用情况', '2', 'java,spring', 1, '12', '2022-02-10 00:19:43', '2022-02-10 00:19:43', 1);
INSERT INTO `article` VALUES (9, '\\033中0可以省掉不影响结果，以及演示跟图片结果不一致', '2', 'java,spring', 1, '21', '2022-02-10 00:20:31', '2022-02-10 00:20:31', 1);
INSERT INTO `article` VALUES (10, '关于hiredis使用情况', '2', '', 1, '129', '2022-02-25 00:22:01', '2022-02-10 00:22:01', 1);

-- ----------------------------
-- Table structure for article_reply
-- ----------------------------
DROP TABLE IF EXISTS `article_reply`;
CREATE TABLE `article_reply`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` int NOT NULL,
  `create_time` datetime NOT NULL,
  `article_id` int NOT NULL COMMENT '所属文章',
  `reply_id` int NOT NULL DEFAULT 0 COMMENT '默认0，为第一层，否则对应一级回复的ID号',
  `reply_user_id` int NOT NULL DEFAULT 0 COMMENT '二级回复，用来确定子回复是回复谁的',
  `reply_father_id` int NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `article_reply_article_id`(`article_id`) USING BTREE,
  INDEX `article_reply_user_id`(`user_id`) USING BTREE,
  CONSTRAINT `article_reply_article_id` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `article_reply_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of article_reply
-- ----------------------------
INSERT INTO `article_reply` VALUES (15, '<p>test</p>', 1, '2023-03-17 18:20:03', 10, 0, 0, 0);
INSERT INTO `article_reply` VALUES (16, '<p>2222222222</p>', 1, '2023-03-17 18:26:46', 10, 15, 1, 15);

-- ----------------------------
-- Table structure for article_sort
-- ----------------------------
DROP TABLE IF EXISTS `article_sort`;
CREATE TABLE `article_sort`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of article_sort
-- ----------------------------
INSERT INTO `article_sort` VALUES (1, '问答讨论', '2022-02-07 20:28:45');
INSERT INTO `article_sort` VALUES (2, '文章分享', '2022-02-07 20:29:00');
INSERT INTO `article_sort` VALUES (3, '踩坑记录', '2022-02-07 20:29:09');
INSERT INTO `article_sort` VALUES (4, '站内公告', '2022-02-07 20:29:32');

-- ----------------------------
-- Table structure for article_tags
-- ----------------------------
DROP TABLE IF EXISTS `article_tags`;
CREATE TABLE `article_tags`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of article_tags
-- ----------------------------
INSERT INTO `article_tags` VALUES (1, 'html');
INSERT INTO `article_tags` VALUES (2, 'sql');
INSERT INTO `article_tags` VALUES (3, 'java');
INSERT INTO `article_tags` VALUES (4, 'sqllib');

-- ----------------------------
-- Table structure for article_type
-- ----------------------------
DROP TABLE IF EXISTS `article_type`;
CREATE TABLE `article_type`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_type
-- ----------------------------
INSERT INTO `article_type` VALUES (1, '问答讨论', '2023-03-17 17:57:11');
INSERT INTO `article_type` VALUES (2, '文章分享', '2023-03-17 17:57:23');
INSERT INTO `article_type` VALUES (3, '踩坑记录', '2023-03-17 17:57:31');
INSERT INTO `article_type` VALUES (4, '站内公告', '2023-03-17 17:57:40');

-- ----------------------------
-- Table structure for code_share
-- ----------------------------
DROP TABLE IF EXISTS `code_share`;
CREATE TABLE `code_share`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` int NOT NULL,
  `only_key` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `code_share`(`user_id`) USING BTREE,
  CONSTRAINT `code_share` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of code_share
-- ----------------------------
INSERT INTO `code_share` VALUES (34, 'Ly8gInN0YXRpYyB2b2lkIG1haW4iIG11c3QgYmUgZGVmaW5lZCBpbiBhIHB1YmxpYyBjbGFzcy4KcHVibGljIGNsYXNzIE1haW4gewogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgewogICAgICAgIFN5c3RlbS5vdXQucHJpbnRsbigiSGVsbG8gV29ybGQhMTExMTExMTExMTExMTExMTExMTExMTExIik7CiAgICB9Cn0=', 1, '67a2d960f19a4726979a7978f8222532', 'JAVA');
INSERT INTO `code_share` VALUES (35, 'cHJpbnQoIkhlbGxvIFdvcmxkMTExMTExMTExMTExMTExMTExMTExISIp', 1, 'd6f9a5c2a04d43438dfc250ddba377bf', 'Python3');
INSERT INTO `code_share` VALUES (36, 'cHJpbnQgIkhlbGxvIFdvcmxkISI=', 1, '089648b7fa724b9798b46cdced3623c2', 'Python');
INSERT INTO `code_share` VALUES (37, 'IyAtKi0gY29kaW5nOiB1dGYtOCAtKi0KCnByaW50ICJIZWxsbyBXb3JsZCHlrozlloQi', 1, '44afd3775ea54ae48a9dc894d22e65f4', 'Python');
INSERT INTO `code_share` VALUES (38, 'IyAtKi0gY29kaW5nOiB1dGYtOCAtKi0KCnByaW50ICJIZWxsbyBXb3JsZCHlrozlloQi', 1, 'd4250b8761f54b128c0e48bf117fe177', 'Python');
INSERT INTO `code_share` VALUES (39, 'Ly8gInN0YXRpYyB2b2lkIG1haW4iIG11c3QgYmUgZGVmaW5lZCBpbiBhIHB1YmxpYyBjbGFzcy4KcHVibGljIGNsYXNzIE1haW4gewogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgewogICAgICAgIFN5c3RlbS5vdXQucHJpbnRsbigiSGVsbG8gV29ybGQhIik7CiAgICB9Cn0=', 1, 'ee97e0c6f6774bb88969e226112fd930', 'JAVA');
INSERT INTO `code_share` VALUES (40, 'Ly8gInN0YXRpYyB2b2lkIG1haW4iIG11c3QgYmUgZGVmaW5lZCBpbiBhIHB1YmxpYyBjbGFzcy4KcHVibGljIGNsYXNzIE1haW4gewogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgewogICAgICAgIFN5c3RlbS5vdXQucHJpbnRsbigiSGVsbG8gV29ybGQhIik7CiAgICB9Cn0=', 1, 'a3127d98cd5f414e978968c2d7b1511d', 'JAVA');
INSERT INTO `code_share` VALUES (41, 'Ly8gInN0YXRpYyB2b2lkIG1haW4iIG11c3QgYmUgZGVmaW5lZCBpbiBhIHB1YmxpYyBjbGFzcy4KcHVibGljIGNsYXNzIE1haW4gewogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgewogICAgICAgIFN5c3RlbS5vdXQucHJpbnRsbigiSGVsbG8gV29ybGQhIik7CiAgICB9Cn0=', 1, 'a16c2c33e568467eae8995ed40bbaaa8', 'JAVA');
INSERT INTO `code_share` VALUES (42, 'Ly8gInN0YXRpYyB2b2lkIG1haW4iIG11c3QgYmUgZGVmaW5lZCBpbiBhIHB1YmxpYyBjbGFzcy4KcHVibGljIGNsYXNzIE1haW4gewogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgewogICAgICAgIFN5c3RlbS5vdXQucHJpbnRsbigiSGVsbG8gV29ybGQhIik7CiAgICB9Cn0=', 1, 'adf366f3043c4c27b18bfea2af8eb976', 'JAVA');
INSERT INTO `code_share` VALUES (43, 'Ly8gInN0YXRpYyB2b2lkIG1haW4iIG11c3QgYmUgZGVmaW5lZCBpbiBhIHB1YmxpYyBjbGFzcy4KcHVibGljIGNsYXNzIE1haW4gewogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgewogICAgICAgIFN5c3RlbS5vdXQucHJpbnRsbigiSGVsbG8gV29ybGQhIik7CiAgICB9Cn0=', 1, 'dd4f47c9cdf44a56a380c2eb69d393b6', 'JAVA');
INSERT INTO `code_share` VALUES (44, 'Ly8gInN0YXRpYyB2b2lkIG1haW4iIG11c3QgYmUgZGVmaW5lZCBpbiBhIHB1YmxpYyBjbGFzcy4KcHVibGljIGNsYXNzIE1haW4gewogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgewogICAgICAgIFN5c3RlbS5vdXQucHJpbnRsbigiSGVsbG8gV29ybGQhIik7CiAgICB9Cn0=', 1, 'b32b67ec3697459b9a725b41e761a126', 'JAVA');
INSERT INTO `code_share` VALUES (45, 'Ly8gInN0YXRpYyB2b2lkIG1haW4iIG11c3QgYmUgZGVmaW5lZCBpbiBhIHB1YmxpYyBjbGFzcy4KcHVibGljIGNsYXNzIE1haW4gewogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgewogICAgICAgIFN5c3RlbS5vdXQucHJpbnRsbigiSGVsbG8gV29ybGQhIik7CiAgICB9Cn0=', 1, '70017f94e2604ab9bcdc1bfcf3e0dccf', 'JAVA');

-- ----------------------------
-- Table structure for coin_record
-- ----------------------------
DROP TABLE IF EXISTS `coin_record`;
CREATE TABLE `coin_record`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime NOT NULL,
  `user_id` int NOT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `count` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `coin_record_user_id`(`user_id`) USING BTREE,
  CONSTRAINT `coin_record_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of coin_record
-- ----------------------------
INSERT INTO `coin_record` VALUES (1, '10', '2022-02-26 16:01:12', 1, '网站签到', '10');
INSERT INTO `coin_record` VALUES (2, '10', '2022-02-26 21:16:48', 1, '网站签到', '10');
INSERT INTO `coin_record` VALUES (3, '10', '2022-02-26 21:27:00', 1, '网站签到', '30');
INSERT INTO `coin_record` VALUES (4, '10', '2022-02-27 00:19:10', 1, '网站签到', '40');
INSERT INTO `coin_record` VALUES (5, '10', '2022-02-28 15:14:09', 1, '网站签到', '50');
INSERT INTO `coin_record` VALUES (6, '10', '2022-03-01 10:46:08', 1, '网站签到', '60');
INSERT INTO `coin_record` VALUES (7, '10', '2022-03-02 14:54:47', 1, '网站签到', '70');
INSERT INTO `coin_record` VALUES (12, '-50', '2023-04-09 16:43:07', 1, '启动环境', '999850');
INSERT INTO `coin_record` VALUES (13, '-50', '2023-04-09 16:57:52', 1, '启动环境', '999800');

-- ----------------------------
-- Table structure for index_nav
-- ----------------------------
DROP TABLE IF EXISTS `index_nav`;
CREATE TABLE `index_nav`  (
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `logo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of index_nav
-- ----------------------------
INSERT INTO `index_nav` VALUES ('首页', 1, '/home', 'Home');
INSERT INTO `index_nav` VALUES ('安全靶场', 2, '/Challenges', 'Safe');
INSERT INTO `index_nav` VALUES ('工具下载', 3, '/Tools', 'Tools');
INSERT INTO `index_nav` VALUES ('社区', 4, '/BBS', 'People');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `role_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', '2023-03-17 15:16:21', '2023-03-17 15:16:32', 'root');
INSERT INTO `role` VALUES (2, '普通管理员', '2023-03-17 15:16:44', '2023-03-17 15:16:46', 'admin');
INSERT INTO `role` VALUES (3, '普通用户', '2023-03-17 15:16:55', '2023-03-17 15:16:58', 'user');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `role_id` int NULL DEFAULT NULL,
  `menu_id` int NULL DEFAULT NULL,
  INDEX `role_menu_menu_id`(`menu_id`) USING BTREE,
  INDEX `role_menu_role_id`(`role_id`) USING BTREE,
  CONSTRAINT `role_menu_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `admin_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_menu_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 1);
INSERT INTO `role_menu` VALUES (1, 2);
INSERT INTO `role_menu` VALUES (1, 3);
INSERT INTO `role_menu` VALUES (1, 4);
INSERT INTO `role_menu` VALUES (1, 5);
INSERT INTO `role_menu` VALUES (1, 100);
INSERT INTO `role_menu` VALUES (1, 101);
INSERT INTO `role_menu` VALUES (1, 102);
INSERT INTO `role_menu` VALUES (1, 103);
INSERT INTO `role_menu` VALUES (1, 104);
INSERT INTO `role_menu` VALUES (1, 105);
INSERT INTO `role_menu` VALUES (1, 106);
INSERT INTO `role_menu` VALUES (1, 107);

-- ----------------------------
-- Table structure for safe_docker
-- ----------------------------
DROP TABLE IF EXISTS `safe_docker`;
CREATE TABLE `safe_docker`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_shell` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `flag_addr` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `intro` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `nginx_shell` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of safe_docker
-- ----------------------------
INSERT INTO `safe_docker` VALUES (1, 'docker run -d --name={{name}} --hostname=openssh-server -e PUID=1000 -e PGID=1000 -e SUDO_ACCESS=false -e PASSWORD_ACCESS=true -e USER_PASSWORD=123456 -e USER_NAME=codetip -p {{port}}:2222 --restart unless-stopped ghcr.io/linuxserver/openssh-server:9.1_p1-r2-ls107;docker exec -itd {{name}} sh -c \'echo \"codetip{c4rewwetrfewgsd}\" > flag.txt\'', '/flag.txt', '开始吧：{{name}}.node1.jishu5.com\r\n端口：{{port}}', 'echo \"server { listen 80; server_name {{name}}.node1.jishu5.com; location / { proxy_pass http://localhost:{{port}}; } }\" > {{nginx}}/{{name}}.conf', '测试靶场');

-- ----------------------------
-- Table structure for safe_docker_user
-- ----------------------------
DROP TABLE IF EXISTS `safe_docker_user`;
CREATE TABLE `safe_docker_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `docker_id` int NULL DEFAULT NULL,
  `lab_id` int NULL DEFAULT NULL,
  `intro` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `create_time` datetime NOT NULL,
  `container_id` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `exp_time` datetime NOT NULL,
  `docker_name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `port` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `is_exist` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `is_success` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `safe_docker_user_user_id`(`user_id`) USING BTREE,
  INDEX `safe_docker_user_docker_id`(`docker_id`) USING BTREE,
  INDEX `safe_docker_user_lab_id`(`lab_id`) USING BTREE,
  CONSTRAINT `safe_docker_user_docker_id` FOREIGN KEY (`docker_id`) REFERENCES `safe_docker` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `safe_docker_user_lab_id` FOREIGN KEY (`lab_id`) REFERENCES `safe_labs` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `safe_docker_user_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 148 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of safe_docker_user
-- ----------------------------
INSERT INTO `safe_docker_user` VALUES (148, 1, 1, 1, '开始吧：e72c6b6e32ba43a5b96eebbc8c5ec86a.node1.jishu5.com\r\n端口：18871', '2023-04-09 16:58:04', '84fc8eca29d1667bff6d86d8e069638f0a21b8accdc68467ed67875b601d4cb5\n', '2023-04-09 17:28:04', 'e72c6b6e32ba43a5b96eebbc8c5ec86a', '18871', '1', '1');

-- ----------------------------
-- Table structure for safe_hot_tags
-- ----------------------------
DROP TABLE IF EXISTS `safe_hot_tags`;
CREATE TABLE `safe_hot_tags`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_date` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of safe_hot_tags
-- ----------------------------
INSERT INTO `safe_hot_tags` VALUES (1, 'SQLi Lib', '2022-02-02 01:38:24');
INSERT INTO `safe_hot_tags` VALUES (2, '流量分析', '2022-02-02 01:38:30');
INSERT INTO `safe_hot_tags` VALUES (3, 'ctf', '2022-02-02 01:38:37');
INSERT INTO `safe_hot_tags` VALUES (4, 'N1BOOK', '2022-02-05 13:01:27');
INSERT INTO `safe_hot_tags` VALUES (5, 'log4j', '2022-03-01 22:08:19');
INSERT INTO `safe_hot_tags` VALUES (6, 'sql', '2022-03-01 22:08:25');
INSERT INTO `safe_hot_tags` VALUES (7, 'web', '2022-03-01 22:08:54');
INSERT INTO `safe_hot_tags` VALUES (8, '文件包含', '2022-03-01 22:09:01');
INSERT INTO `safe_hot_tags` VALUES (9, 'upload', '2022-03-01 22:09:17');

-- ----------------------------
-- Table structure for safe_labs
-- ----------------------------
DROP TABLE IF EXISTS `safe_labs`;
CREATE TABLE `safe_labs`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `intro` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `level` int NOT NULL,
  `label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `docker_id` int NULL DEFAULT NULL,
  `type_id` int NOT NULL,
  `create_time` datetime NOT NULL,
  `flag` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `need_coin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gold_coin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `safe_labs_type_id`(`type_id`) USING BTREE,
  INDEX `safe_labs_docker_id`(`docker_id`) USING BTREE,
  CONSTRAINT `safe_labs_docker_id` FOREIGN KEY (`docker_id`) REFERENCES `safe_docker` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `safe_labs_type_id` FOREIGN KEY (`type_id`) REFERENCES `safe_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of safe_labs
-- ----------------------------
INSERT INTO `safe_labs` VALUES (1, 'Linux labs', '开始挑战前，先来做一个热身运动吧，默认账号：codetip，密码：123456~', 5, '1,3,4', 1, 1, '2022-01-31 11:19:00', 'codetip{c4rewwetrfewgsd}', '50', '50');

-- ----------------------------
-- Table structure for safe_labs_record
-- ----------------------------
DROP TABLE IF EXISTS `safe_labs_record`;
CREATE TABLE `safe_labs_record`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_time` datetime NULL DEFAULT NULL,
  `end_time` datetime NULL DEFAULT NULL,
  `docker_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_id` int NULL DEFAULT NULL,
  `lab_id` int NULL DEFAULT NULL,
  `is_success` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `safe_labs_record_user_id`(`user_id`) USING BTREE,
  INDEX `safe_labs_record_lab_id`(`lab_id`) USING BTREE,
  CONSTRAINT `safe_labs_record_lab_id` FOREIGN KEY (`lab_id`) REFERENCES `safe_labs` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `safe_labs_record_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of safe_labs_record
-- ----------------------------
INSERT INTO `safe_labs_record` VALUES (1, '2023-04-09 16:43:19', '2023-04-09 16:46:37', '1a41d4d2b3a744e899cc7f8153ce8cad', 1, 1, 0);
INSERT INTO `safe_labs_record` VALUES (2, '2023-04-09 16:58:04', '2023-04-09 17:28:04', 'e72c6b6e32ba43a5b96eebbc8c5ec86a', 1, 1, 1);

-- ----------------------------
-- Table structure for safe_success_record
-- ----------------------------
DROP TABLE IF EXISTS `safe_success_record`;
CREATE TABLE `safe_success_record`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `user_id` int NOT NULL,
  `lab_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `safe_success_record_user_id`(`user_id`) USING BTREE,
  INDEX `safe_success_record_lab_id`(`lab_id`) USING BTREE,
  CONSTRAINT `safe_success_record_lab_id` FOREIGN KEY (`lab_id`) REFERENCES `safe_labs` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `safe_success_record_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of safe_success_record
-- ----------------------------

-- ----------------------------
-- Table structure for safe_tags
-- ----------------------------
DROP TABLE IF EXISTS `safe_tags`;
CREATE TABLE `safe_tags`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of safe_tags
-- ----------------------------
INSERT INTO `safe_tags` VALUES (1, 'SQL注入', '2022-02-04 22:08:28');
INSERT INTO `safe_tags` VALUES (2, '文件包含', '2022-02-04 22:08:55');
INSERT INTO `safe_tags` VALUES (3, 'CTF', '2022-02-04 22:09:03');
INSERT INTO `safe_tags` VALUES (4, '基础', '2022-02-04 22:09:11');
INSERT INTO `safe_tags` VALUES (5, '进阶', '2022-02-04 22:09:17');
INSERT INTO `safe_tags` VALUES (6, '高级', '2022-02-04 22:09:22');
INSERT INTO `safe_tags` VALUES (7, '密码破解', '2022-02-04 22:09:50');
INSERT INTO `safe_tags` VALUES (8, 'XSS', '2022-02-04 22:10:02');
INSERT INTO `safe_tags` VALUES (9, '文件上传', '2022-02-04 22:10:16');
INSERT INTO `safe_tags` VALUES (10, 'SSRF', '2022-02-04 22:10:29');

-- ----------------------------
-- Table structure for safe_type
-- ----------------------------
DROP TABLE IF EXISTS `safe_type`;
CREATE TABLE `safe_type`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of safe_type
-- ----------------------------
INSERT INTO `safe_type` VALUES (1, '基础技能');
INSERT INTO `safe_type` VALUES (2, '注入相关');
INSERT INTO `safe_type` VALUES (3, '信息泄露');
INSERT INTO `safe_type` VALUES (4, '解密相关');
INSERT INTO `safe_type` VALUES (5, 'XSS');
INSERT INTO `safe_type` VALUES (6, 'SSRF');
INSERT INTO `safe_type` VALUES (7, '技能提升');

-- ----------------------------
-- Table structure for tool_hot_tags
-- ----------------------------
DROP TABLE IF EXISTS `tool_hot_tags`;
CREATE TABLE `tool_hot_tags`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tool_hot_tags
-- ----------------------------
INSERT INTO `tool_hot_tags` VALUES (1, 'SQL注入工具包', '2022-02-04 20:10:23');
INSERT INTO `tool_hot_tags` VALUES (2, 'JDK', '2022-02-04 20:10:36');
INSERT INTO `tool_hot_tags` VALUES (3, 'fofa', '2022-02-04 20:10:48');
INSERT INTO `tool_hot_tags` VALUES (4, 'python3.9', '2022-02-04 20:10:59');
INSERT INTO `tool_hot_tags` VALUES (5, '中国菜刀', '2022-02-04 20:11:12');

-- ----------------------------
-- Table structure for tool_list
-- ----------------------------
DROP TABLE IF EXISTS `tool_list`;
CREATE TABLE `tool_list`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `intro` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `tags` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `create_time` datetime NOT NULL,
  `website` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `download` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `type_id` int NULL DEFAULT NULL,
  `avatar_url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `tool_list_type_id`(`type_id`) USING BTREE,
  CONSTRAINT `tool_list_type_id` FOREIGN KEY (`type_id`) REFERENCES `tool_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 90 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tool_list
-- ----------------------------
INSERT INTO `tool_list` VALUES (1, 'ExeInfoPE', '打包、压缩壳侦测工具，可以支持Symbian/Android/Linux/macOS/Windows等系统的可执行文件', 'Linux,macOS,Windows,Reverse', '2022-02-12 13:09:10', 'http://exeinfo.booomhost.com/?i=1', 'http://exeinfo.booomhost.com/?i=1', 1, '');
INSERT INTO `tool_list` VALUES (2, 'SageMathCell', 'SageMathCell是SageMath的基于WebUI制作的在线运行Sage脚本的Web站点。它允许将Sage计算嵌入到任何网页中。计算资源由马德里自治大学马德里分校的Matemáticas部门提供。也可以自行部署在私有的服务器上。', 'Website,Crypto', '2022-02-12 13:09:10', 'https://sagecell.sagemath.org/', 'https://sagecell.sagemath.org/', 1, 'https://static.ctfhub.com/tools/icon/89_3ea072a746a80f2a3075b0e094e2d81ab2600805.png?1594138267');
INSERT INTO `tool_list` VALUES (3, 'Bytecode Viewer', '一个开源轻量的Java反编译工具，使用多种反编译引擎进行反编译，支持JAR/APK/CLASS等反编译', 'Android,Reverse,Misc', '2022-02-12 13:09:10', 'https://bytecodeviewer.com/', 'https://github.com/konloch/bytecode-viewer/releases', 1, '');
INSERT INTO `tool_list` VALUES (4, 'SageMath', 'SageMath是根据GPL许可的免费开源数学软件系统。 它基于许多现有的开源软件包：NumPy，SciPy，matplotlib，Sympy，Maxima，GAP，FLINT，R等。 通过基于Python的通用语言或直接通过接口或包装器来访问其组合功能。', 'Crypto', '2022-02-12 13:09:10', 'https://www.sagemath.org/', 'https://www.sagemath.org/download.html', 1, 'https://static.ctfhub.com/tools/icon/88_bc818bf843b6e0fb64b02a83c8d84d1d7ea312be.png?1594138274');
INSERT INTO `tool_list` VALUES (5, 'Detect it Easy(DiE)', 'Detect It Easy缩写为DIE，是一个用来确定文件类型和查看保护壳的程序。&amp;ldquo;DIE&amp;rdquo;是一个跨平台的应用程序，除了Windows版本，还有Linux和Mac OS版本。它具有完全开放的签名体系结构。您可以轻松地添加自己的检测算法或修改那些已经存在的算法。这是通过使用脚本实现的。脚本语言与JavaScript非常相似，任何了解编程基础知识的人都可以很容易地理解它是如何工作的。可能有人认为脚本运行非常缓慢。确实，脚本比编译后的代码运行得慢，但是由于脚本引擎的良好优化，这不会造成任何特殊的不便。开放架构的可能性弥补了这些限制。', 'Linux,macOS,Windows,Reverse', '2022-02-12 13:09:10', 'https://github.com/horsicq/Detect-It-Easy', 'https://github.com/horsicq/DIE-engine/releases', 1, '');
INSERT INTO `tool_list` VALUES (6, 'StegOnline', '图片隐写工具 StegSolve 的 Web 版。真香。', '图片,Website,隐写,Misc', '2022-02-12 13:09:10', 'http://stegonline.georgeom.net', 'https://github.com/Ge0rg3/StegOnline', 1, '');
INSERT INTO `tool_list` VALUES (7, 'cRARk', 'cRARk是一款跨平台的RAR压缩包密码破解工具，可以使用GPU（CUDA/OpenCL）来加速破解过程', '压缩包,Linux,Windows,暴力破解,Misc', '2022-02-12 13:09:11', 'http://www.crark.net/', 'http://www.crark.net/#download', 1, '');
INSERT INTO `tool_list` VALUES (8, 'brainfuck', 'Brainfuck，是一种极小化的程序语言，它是由Urban Müller在1993年创造的。由于fuck在英语中是脏话，这种语言有时被称为Brainf*ck或Brainf***，或被简称为BF。', 'Website,Crypto', '2022-02-12 13:09:11', 'http://www.muppetlabs.com/~breadbox/bf/', 'https://copy.sh/brainfuck/', 1, 'https://static.ctfhub.com/tools/icon/85_cf8d5f5917af7a8bb26eb7a0a0d51795334bc45c.png?1583046335');
INSERT INTO `tool_list` VALUES (9, 'MATLAB', 'MATLAB是美国MathWorks公司出品的商业数学软件，用于算法开发、数据可视化、数据分析以及数值计算的高级技术计算语言和交互式环境，主要包括MATLAB和Simulink两大部分。', 'Crypto', '2022-02-12 13:09:11', 'https://www.mathworks.com/', 'https://www.mathworks.com/', 1, 'https://static.ctfhub.com/tools/icon/83_69a1df32cea5f0254a07a62c1f1696c93a345411.png?1583045992');
INSERT INTO `tool_list` VALUES (10, 'wolfram', 'wolfram是一个用于各类密码算法分析的在线工具', 'Website,Crypto', '2022-02-12 13:09:11', 'https://www.wolframalpha.com/', 'https://www.wolframalpha.com/', 1, 'https://static.ctfhub.com/tools/icon/82_d448f2d06b8aa701b22a19633fc55848ebc1cfb7.png?1583045832');
INSERT INTO `tool_list` VALUES (11, 'jsfuck', 'JSFuck（或为了避讳脏话Fuck写作 JSF*ck ）是一种深奥的 JavaScript 编程风格。以这种风格写成的代码中仅使用 [、]、(、)、! 和 + 六种字符。此编程风格的名字派生自仅使用较少符号写代码的Brainfuck语言。', 'Website,Crypto', '2022-02-12 13:09:11', 'https://www.bugku.com/tools/jsfuck/', 'https://www.bugku.com/tools/jsfuck/', 1, 'https://static.ctfhub.com/tools/icon/84_3eb45759897587bd272e0f96a938e187ff948f8f.png?1583046420');
INSERT INTO `tool_list` VALUES (12, 'dcode', 'DCODE是一个在线的密码解码的工具，包含了常见的密码加密解密小工具', 'Website,Crypto', '2022-02-12 13:09:11', 'https://www.dcode.fr/', 'https://www.dcode.fr/', 1, 'https://static.ctfhub.com/tools/icon/81_e8fe5ab159712bc442ab30faf264f6e7c5fd3b95.png?1583045764');
INSERT INTO `tool_list` VALUES (13, 'quipqiup', 'quipqiup是由Edwin Olson创建的提供的一种快速的自动密码求解器。 它可以解决一些简单的替代密码。', 'Website,Crypto', '2022-02-12 13:10:47', 'https://www.quipqiup.com/', 'https://www.quipqiup.com/', 1, 'https://static.ctfhub.com/tools/icon/80_e1747c25f4dd0681f579aa21b762f9e52378e02f.png?1583045692');
INSERT INTO `tool_list` VALUES (14, 'Forensic ToolKit(FTK)', 'FTK（Forensic Toolkit）是世界上公认的计算机取证调查的必备工具，可帮助法律执行机构和公司、企业安全专业人员，执行完整、彻底的计算机取证检查。FTK拥有强大的文件过滤和搜索功能，通过FTK过滤器能够自动对所有文件进行分类，自动定位有嫌疑的文件，快速找出所需的证据文件。', '取证(Forensics),Misc', '2022-02-12 13:10:47', 'https://accessdata.com/products-services/forensic-toolkit-ftk', 'https://accessdata.com/product-download', 1, 'https://static.ctfhub.com/tools/icon/78_e349e289d6ac7111f7ceeff4af7dcccc5ba6ceb8.png?1582550149');
INSERT INTO `tool_list` VALUES (15, 'Android Backup Extractor(abe.jar)', '一款用于解包安卓应用备份的工具', 'Android,Misc', '2022-02-12 13:10:47', 'https://github.com/nelenkov/android-backup-extractor', 'https://github.com/nelenkov/android-backup-extractor/releases', 1, 'https://static.ctfhub.com/tools/icon/79_2584154747f0701cb3024184ce6561228cd60fd7.png?1582686180');
INSERT INTO `tool_list` VALUES (16, 'Autopsy', 'Autopsy Forensic Browser是数字取证工具-TheSleuthKit（TSK）的图形界面，一个用来分析磁盘映像和恢复文件的开源取证工具。提供在磁盘映像中进行字符串提取，恢复文件，时间轴分析，chrome，firefox等浏览历史分析，关键字搜索和邮件分析等功能。', '取证(Forensics),Misc', '2022-02-12 13:10:47', 'http://www.sleuthkit.org/autopsy/', 'https://www.autopsy.com/download/', 1, 'https://static.ctfhub.com/tools/icon/77_4284d75807a29d30bb4dbb3d15626ee6c2ff9571.png?1582549963');
INSERT INTO `tool_list` VALUES (17, 'gmpy2', 'gmpy2是一个C编码的Python扩展模块，支持多精度算术。 除了支持GMP或MPIR用于多精度整数和有理算术外，gmpy2还增加了对MPFR（正确舍入的实数浮点算术）和MPC（正确舍入的复数浮点算术）库的支持。', 'Crypto', '2022-02-12 13:10:47', 'https://github.com/aleaxit/gmpy/', 'https://pypi.org/project/gmpy2/', 1, 'https://static.ctfhub.com/tools/icon/76_3a0b48275328a851c227ccd3116da627fc684b26.png?1582549779');
INSERT INTO `tool_list` VALUES (18, 'dvcs-ripper', '版本控制软件信息泄露利用工具，包括 SVN, GIT, Mercurial/hg, bzr... 该工具需要 Perl 环境', '版本控制(VCS),Web', '2022-02-12 13:10:47', 'https://github.com/kost/dvcs-ripper', 'https://github.com/kost/dvcs-ripper/archive/master.zip', 1, 'https://static.ctfhub.com/tools/icon/72_3c6fdc421e21cd9374a9247bddaa54c9ec2b1446.png?1581676669');
INSERT INTO `tool_list` VALUES (19, 'Python-dsstore', '.DS_Store 解析工具', '版本控制(VCS),Web', '2022-02-12 13:10:47', 'https://github.com/gehaxelt/Python-dsstore', 'https://github.com/gehaxelt/Python-dsstore', 1, 'https://static.ctfhub.com/tools/icon/75_33733236c287b81c325d1ed8a6e27ae35a610b92.png?1582019736');
INSERT INTO `tool_list` VALUES (20, 'CyberChef', 'CyberChef是一个非常强大的在线各类编码转换工具，当然也可以下载离线版本，支持任意类型的编码转换组合从而获得最终数据', 'Website,Crypto,Misc', '2022-02-12 13:10:47', 'https://github.com/gchq/CyberChef', 'https://gchq.github.io/CyberChef/', 1, 'https://static.ctfhub.com/tools/icon/71_473f5c162fb7c2e897271b309c917f480c0e9efb.png?1581287709');
INSERT INTO `tool_list` VALUES (21, 'WinHex', 'WinHex是一款在Windows下的十六进制编辑器，在计算机取证，数据恢复，低级数据处理和IT安全领域特别有用。 日常和紧急使用的高级工具：检查和编辑各种文件，从文件系统损坏的硬盘驱动器或数码相机卡中恢复已删除的文件或丢失的数据。 ', '取证(Forensics),Windows,隐写,Misc', '2022-02-12 13:10:47', 'http://www.x-ways.net/winhex/', 'http://www.x-ways.net/winhex.zip', 1, 'https://static.ctfhub.com/tools/icon/69_c1e2967dbd044e990f4c6dcc6ffc9dda1edad36c.png?1581286873');
INSERT INTO `tool_list` VALUES (22, 'OllyDBG', 'OllyDbg是一种具有可视化界面的32位汇编分析调试器，是一个新的动态追踪工具，将IDA与SoftICE结合起来的思想，Ring3级调试器，非常容易上手。同时还支持插件扩展功能。', 'Windows,Reverse', '2022-02-12 13:10:47', 'http://www.ollydbg.org/', 'https://static.ctfhub.com/tools/attachment/68_cdfe423ddc5a61c0084c4298c6fcd7e23b30e26a.zip?1581286560', 1, 'https://static.ctfhub.com/tools/icon/68_cdfe423ddc5a61c0084c4298c6fcd7e23b30e26a.png?1581286581');
INSERT INTO `tool_list` VALUES (23, '超级字典生成器', '超级字典生成器是一款在Windows下生成密码字典的工具', 'PenTest,Windows,暴力破解,Misc,Web', '2022-02-12 13:10:47', '', 'https://static.ctfhub.com/tools/attachment/67_6596b884cbe0aebac08c240af501d2bbda9de084.zip?1581286276', 1, 'https://static.ctfhub.com/tools/icon/67_6596b884cbe0aebac08c240af501d2bbda9de084.png?1581286269');
INSERT INTO `tool_list` VALUES (24, 'RAR Password Unlocker', 'RAR Password Unlocker是一款快速的爆破RAR压缩文件密码的工具，其支持暴力破解，掩码破解以及字典破解等方式，工具来源于网络。', '压缩包,Windows,暴力破解,Misc', '2022-02-12 13:10:47', '', 'https://static.ctfhub.com/tools/attachment/66_af7da340697cdc838711241bd1b23455a83d4685.zip?1581285864', 1, 'https://static.ctfhub.com/tools/icon/66_af7da340697cdc838711241bd1b23455a83d4685.png?1581285911');
INSERT INTO `tool_list` VALUES (25, 'RSA Wiener Attack', '使用Python实现RSA的Wiener攻击RSA公钥的工具。在加密指数太小或太大的情况下，它使用有关连续分数近似的一些结果从公共密钥推断出私有密钥。', 'Script,Crypto,RSA', '2022-02-12 13:12:02', 'https://github.com/pablocelayes/rsa-wiener-attack', 'https://github.com/pablocelayes/rsa-wiener-attack', 1, 'https://static.ctfhub.com/tools/icon/64_b501ef5e45f314a7cd786bb8d9b305ad630c2539.png?1581285019');
INSERT INTO `tool_list` VALUES (26, 'nps', 'nps是一款轻量级、高性能、功能强大的跨平台内网穿透代理服务器。目前支持tcp、udp流量转发，可支持任何tcp、udp上层协议（访问内网网站、本地支付接口调试、ssh访问、远程桌面，内网dns解析等等&amp;amp;hellip;&amp;amp;hellip;），此外还支持内网http代理、内网socks5代理、p2p等，并带有功能强大的web管理端。', '代理,PenTest,Linux,Windows,Web', '2022-02-12 13:12:02', 'https://github.com/ehang-io/nps', 'https://github.com/ehang-io/nps/releases', 1, 'https://static.ctfhub.com/tools/icon/65_7d8d016b663ba84d76650601f496a139731b1971.png?1581285188');
INSERT INTO `tool_list` VALUES (27, '手机按键音识别(Detect DTMF Tones)', '一个在线的手机按键声音识别。 上传录制的声音文件，即可分析出来按了九宫格输入的哪些键。', 'Website,Misc', '2022-02-12 13:12:02', 'http://dialabc.com/sound/detect/', 'http://dialabc.com/sound/detect/', 1, 'https://static.ctfhub.com/tools/icon/63_098aade9d25f053ab5b415357d5f79148b645453.png?1581284802');
INSERT INTO `tool_list` VALUES (28, 'masscan', 'masscan是一个开源跨平台的极快的端口扫描工具，它可以调整发包速率。扫描主机全端口仅需要不到一分钟。因为非常的快，通常漏报的问题也比较严重，建议在内网中使用。\n因为功能专注且单一。masscan仅能扫描端口，并不能像nmap一样可以做进一步服务识别。\n', '端口扫描,Linux,macOS,Windows,Web', '2022-02-12 13:12:02', 'https://github.com/robertdavidgraham/masscan', 'https://github.com/robertdavidgraham/masscan', 1, 'https://static.ctfhub.com/tools/icon/62_2110b29a01b409431e3dc8f7c1465db196450f41.png?1581284692');
INSERT INTO `tool_list` VALUES (29, 'HxD', 'HxD是一个轻巧的十六进制编辑器，可以支持原始磁盘编辑和主存储器（RAM）修改，也可以处理任意文件。\n它拥有易于使用的界面提供诸如搜索和替换，导出，校验和/摘要，字节模式插入，文件粉碎器，文件串联或分割，统计信息等功能', 'Windows,Misc', '2022-02-12 13:12:02', 'https://mh-nexus.de/en/hxd/', 'https://mh-nexus.de/en/downloads.php?product=HxD20', 1, 'https://static.ctfhub.com/tools/icon/61_938cf769f124b90dd8326c99fac73af98146695f.png?1581284024');
INSERT INTO `tool_list` VALUES (30, 'DirBuster', 'DirBuster是一个多线程的暴力破解目标网站目录和文件的Java应用程序', 'PenTest,暴力破解,Web', '2022-02-12 13:12:02', 'https://sourceforge.net/projects/dirbuster/', 'https://sourceforge.net/projects/dirbuster/', 1, 'https://static.ctfhub.com/tools/icon/60_3fb00ebfc9831cd78a63c037cbb8d42e72132b74.png?1581283767');
INSERT INTO `tool_list` VALUES (31, 'nmap', 'Nmap（Network Mapper）是一款开放源代码的网络探测和安全审核工具。它的设计目标是快速地扫描大型网络。Nmap使用检测IP数据包来确定访问的主机、提供的服务、数据包的类型等其他信息；Nmap通常被用来做安全审查，比如日常的网络日常检查、管理service升级计划以及检测hosts和service的运行时长等', '端口扫描,PenTest,Linux,macOS,Web', '2022-02-12 13:12:02', 'https://nmap.org/', 'https://nmap.org/download.html', 1, 'https://static.ctfhub.com/tools/icon/59_3428ae0713eb1be85e4a7faef4587ead8b0ba22c.png?1581284235');
INSERT INTO `tool_list` VALUES (32, 'Proxifier', 'Proxifier可以使不支持通过代理服务器工作的网络应用程序通过Socks5或HTTPS代理进行操作。方便流量的重定向', 'iOS,代理,Misc,Web', '2022-02-12 13:12:02', 'https://www.proxifier.com/', 'https://www.proxifier.com/download/', 1, 'https://static.ctfhub.com/tools/icon/56_164d93abf63bf0b160bdcebdb7b9e9b9afefd2f6.png?1581283132');
INSERT INTO `tool_list` VALUES (33, 'Ghidra', 'Ghidra是由美国NSA为国家安全局的网络安全任务开发的软件逆向工程（SRE）框架。 后来它开源出去，任何人都可以下载和根据需要改进。它有助于分析恶意代码和诸如病毒的恶意软件，并可以使网络安全专业人员更好地了解其网络和系统中的潜在漏洞。其强大的反编译和调试可以比肩IDA Pro', '调试,Reverse', '2022-02-12 13:12:02', 'https://ghidra-sre.org/', 'https://ghidra-sre.org/', 1, 'https://static.ctfhub.com/tools/icon/55_5062da9a2a8d3f96a4b7624a9e1686488865fafe.png?1581282677');
INSERT INTO `tool_list` VALUES (34, 'Fiddler', '一款免费的网络请求捕获调试工具，可适用于任何浏览器，系统或平台，其功能类似于Burp Suite，不过更多的是面向开发方向，在安全方面的支持较为薄弱', '代理,Windows,Web', '2022-02-12 13:12:02', 'https://www.telerik.com/fiddler', 'https://www.telerik.com/download/fiddler', 1, 'https://static.ctfhub.com/tools/icon/58_d811e64ab3e3ac9ec39ab20b67cf59ad0dd45afc.png?1581283547');
INSERT INTO `tool_list` VALUES (35, 'Seay SVN漏洞利用工具', 'Seay SVN漏洞利用工具是用来下载存在.svn目录泄露问题的网站的源码的工具。', 'Windows,版本控制(VCS),Web', '2022-02-12 13:12:02', '', 'https://static.ctfhub.com/tools/attachment/57_47dd7452cbaa2fbdb30644534326fcae89a0422b.zip?1581283265', 1, 'https://static.ctfhub.com/tools/icon/57_47dd7452cbaa2fbdb30644534326fcae89a0422b.png?1581283252');
INSERT INTO `tool_list` VALUES (36, 'JEB', '专业的Android逆向工具，可以反编译和调试二进制代码。解包并分析Android APK文件。支持Android Dalvik，MIPS，ARM，Intel x86，WebAssembly和Ethereum反编译。', 'Android,Reverse', '2022-02-12 13:12:02', 'https://www.pnfsoftware.com/', 'https://www.pnfsoftware.com/', 1, 'https://static.ctfhub.com/tools/icon/54_8b2dc02f271ed5507229e975f80ff197d034dc8f.png?1581282485');
INSERT INTO `tool_list` VALUES (37, 'jadx-gui', 'Android/Java反编译神器，安装后可以用来查看apk源码，打开zip、dex、jar、apk、class文件，了解学习借鉴其内部代码构造，需要64位Java环境支持。', 'Android,Reverse', '2022-02-12 13:12:49', 'https://github.com/skylot/jadx', 'https://github.com/skylot/jadx/releases', 1, 'https://static.ctfhub.com/tools/icon/53_99ac295f76c5c4a8a4ae96b6413d7bc858528094.png?1581282209');
INSERT INTO `tool_list` VALUES (38, 'Wireshark', 'Wireshark 是一款非常棒的开源网络协议分析器。它可以实时检测网络通讯数据，也可以检测其抓取的网络通讯数据快照文件。可以通过图形界面浏览这些数据，可以查看网络通讯数据包中每一层的详细内容。', '流量分析,Misc', '2022-02-12 13:12:49', 'https://www.wireshark.org/', 'https://www.wireshark.org/download.html', 1, 'https://static.ctfhub.com/tools/icon/52_3ac9965f41396d26b1ce706303e2a5b2822e4195.png?1581282078');
INSERT INTO `tool_list` VALUES (39, 'PsQREdit', '一款在Windows下好用的二维码识别生成软件', '图片,Misc', '2022-02-12 13:12:49', '', 'https://static.ctfhub.com/tools/attachment/51_4da44ddc40ee96e7a29bc0f24a4b676f90f7f063.zip?1581282118', 1, 'https://static.ctfhub.com/tools/icon/51_4da44ddc40ee96e7a29bc0f24a4b676f90f7f063.png?1581281960');
INSERT INTO `tool_list` VALUES (40, 'RSATools', '一款在Windows下好用的RSA分析工具', 'Crypto,RSA', '2022-02-12 13:12:49', '', 'https://static.ctfhub.com/tools/attachment/50_51f8023026137d6bf183bc7911a1061ec34aac2c.zip?1581281667', 1, 'https://static.ctfhub.com/tools/icon/50_51f8023026137d6bf183bc7911a1061ec34aac2c.png?1581281649');
INSERT INTO `tool_list` VALUES (41, 'GitHack', '.git 泄漏利用工具，可还原历史版本', '版本控制(VCS),Web', '2022-02-12 13:12:49', 'https://github.com/BugScanTeam/GitHack', 'https://github.com/BugScanTeam/GitHack/archive/master.zip', 1, 'https://static.ctfhub.com/tools/icon/49_dfbfd4829da91d1b3e955b1cc56df1d4e9602fc0.png?1581278230');
INSERT INTO `tool_list` VALUES (42, 'Parallels Desktop', 'Parallels Desktop 被称为 macOS 上最强大的虚拟机软件。可以在 Mac 下同时模拟运行 Win、Linux、Android 等多种操作系统及软件而不必重启电脑，并能在不同系统间随意切换。', '虚拟机,Pwn,Web', '2022-02-12 13:12:49', 'https://www.parallels.cn/products/desktop/pro/', 'https://www.parallels.cn/products/desktop/trial/', 1, 'https://static.ctfhub.com/tools/icon/47_0323bcf72ba15493cfb026fa46c8247b62921927.png?1581273051');
INSERT INTO `tool_list` VALUES (43, 'VirtualBox', 'VirtualBox 虚拟机是德国软件公司InnoTek所开发的一款开源的虚拟系统软件，是一个发布在GPL许可之下的自由软件。VirtualBox可以在Linux和Windows主机中运行，并支持在其中安装Windows (NT 4.0、2000、XP、Server 2003、Vista)、DOS/Windows 3.x、Linux (2.4 和 2.6)、OpenBSD 等系列的客户操作系统。', '虚拟机,Pwn,Web', '2022-02-12 13:12:49', 'https://www.virtualbox.org/', 'https://www.virtualbox.org/wiki/Downloads', 1, 'https://static.ctfhub.com/tools/icon/46_adba54143267ef92b4094e4cbef656731ef751b8.png?1581293091');
INSERT INTO `tool_list` VALUES (44, 'volatility', 'volatility 是一款内存取证和分析工具，可以对 Procdump 等工具 dump 出来的内存进行分析，并提取内存中的文件。该工具支持 Windows 和 Linux，Kali 下面默认已经安装。\nvolatility 的许多功能由其内置的各种插件来实现，例如查看当前的网络连接，命令行中的命令，记事本中的内容等等。', '取证(Forensics),Misc', '2022-02-12 13:12:49', 'https://www.volatilityfoundation.org/', 'https://github.com/volatilityfoundation/volatility', 1, 'https://static.ctfhub.com/tools/icon/44_ad53c27b667d3073e95db4bbf39d54046805d84d.png?1581278974');
INSERT INTO `tool_list` VALUES (45, 'VMware Workstation', 'VMware Workstation是业界非常稳定且安全的桌面虚拟机软件，VMware虚拟机可让你在一台机器上同时运行二个或更多Windows、DOS、LINUX系统。在虚拟网路，实时快照，拖曳共享文件夹，支持PXE等方面均有特别之处，使用VMware，用户可在单一的桌面上同时运行不同的操作系统，进行开发、测试、部署新的应用程序。', '虚拟机,Pwn,Web', '2022-02-12 13:12:49', 'https://www.vmware.com/cn/products/workstation-pro.html', 'https://www.vmware.com/cn/products/workstation-pro/workstation-pro-evaluation.html', 1, 'https://static.ctfhub.com/tools/icon/45_cd3dc58ac5cf30c67c3cd675aa3d726bf60c40dd.png?1581278897');
INSERT INTO `tool_list` VALUES (46, 'ELF Parser', '通过静态分析快速确定ELF二进制文件的功能。在不执行文件的情况下发现二进制文件是否为已知恶意软件或可能的威胁。', 'Pwn', '2022-02-12 13:12:49', 'http://www.elfparser.com/index.html', 'http://www.elfparser.com/download.html', 1, 'https://static.ctfhub.com/tools/icon/43_2c81b2166873b9638ed68a95386a37d45ec73c8c.png?1579238301');
INSERT INTO `tool_list` VALUES (47, 'dirsearch', '一个命令行工具，使用字典扫描网站中目录和文件。', 'Web', '2022-02-12 13:12:49', 'https://github.com/maurosoria/dirsearch', 'https://github.com/maurosoria/dirsearch/releases', 1, 'https://static.ctfhub.com/tools/icon/41_fbbf8c02a2808a9c4ffa460a2213cb0b80b5133b.png?1581278962');
INSERT INTO `tool_list` VALUES (48, 'checksec', 'Checksec是一个bash脚本，用于检查可执行文件的保护等属性（例如PIE，RELRO，PaX，Canaries，ASLR，Fortify Source）。 ', 'Pwn', '2022-02-12 13:12:49', 'https://github.com/slimm609/checksec.sh', 'https://github.com/slimm609/checksec.sh/releases', 1, 'https://static.ctfhub.com/tools/icon/42_e3106eb6a65bf2624c6dc1e8b3eeb12aa1dcf77d.png?1581280073');
INSERT INTO `tool_list` VALUES (49, 'libc database search', '基于 libc-database 的一个在线查询 libc 版本的工具。', 'Libc,Pwn', '2022-02-12 13:13:30', 'https://libc.blukat.me/', 'https://libc.blukat.me/', 1, 'https://static.ctfhub.com/tools/icon/38_458b2eef945e415275d5239bde00c38aa0be4eaa.png?1581279008');
INSERT INTO `tool_list` VALUES (50, 'Apktool', 'Apktool 主要用于逆向 apk 文件。它可以将资源解码，并在修改后可以重新构建它们。它还可以执行一些自动化任务，例如构建apk。', 'apk,Mobile,Android,Reverse', '2022-02-12 13:13:30', 'https://ibotpeaches.github.io/Apktool/', 'https://ibotpeaches.github.io/Apktool/install/', 1, 'https://static.ctfhub.com/tools/icon/39_010399befd020c871ee700c9cb255405f10a00fe.png?1579236851');
INSERT INTO `tool_list` VALUES (51, 'libc-database', 'libc 偏移量数据库以简化开发', 'Libc,Pwn', '2022-02-12 13:13:30', 'https://github.com/niklasb/libc-database', 'https://github.com/niklasb/libc-database/archive/master.zip', 1, 'https://static.ctfhub.com/tools/icon/37_c84ae610cb80f6bb69931138966599100627bd84.png?1581280090');
INSERT INTO `tool_list` VALUES (52, 'jd-gui', '一个图形化工具，将 class 文件反编译为 Java 源代码。', 'Mobile,Reverse,Web', '2022-02-12 13:13:30', 'https://java-decompiler.github.io/', 'https://java-decompiler.github.io/', 1, 'https://static.ctfhub.com/tools/icon/40_12fcece4b9b1eda44b321effdfe1d92cbc5829fd.png?1579237231');
INSERT INTO `tool_list` VALUES (53, 'HashPump', '哈希长度扩展攻击的工具，目前支持 MD5, SHA1, SHA256, SHA512 这几种哈希算法。', 'Web', '2022-02-12 13:13:30', 'https://github.com/bwall/HashPump', 'https://github.com/bwall/HashPump/releases', 1, 'https://static.ctfhub.com/tools/icon/36_120424cee746bcb5b8a5dac102d89fb89c2f6b06.png?1581280095');
INSERT INTO `tool_list` VALUES (54, 'binwalk', 'Binwalk是用于搜索给定二进制镜像文件以获取嵌入的文件和代码的工具。 具体来说,它被设计用于识别嵌入固件镜像内的文件和代码。', '隐写,Misc', '2022-02-12 13:13:30', 'https://github.com/ReFirmLabs/binwalk', 'https://github.com/ReFirmLabs/binwalk/releases', 1, 'https://static.ctfhub.com/tools/icon/35_6a72e265984cd09db19d5ebd9d1334bb06d831b1.png?1581279685');
INSERT INTO `tool_list` VALUES (55, 'gdb-peda', 'gdb 调试器插件 peda, 使用 python 开发。', '插件,调试,Pwn', '2022-02-12 13:13:30', 'https://github.com/longld/peda', 'https://github.com/longld/peda/releases', 1, 'https://static.ctfhub.com/tools/icon/34_452a285a284a9e223b74dadcc35a59912312aeaf.png?1581279714');
INSERT INTO `tool_list` VALUES (56, 'PwnTools', 'pwntools 是一个CTF框架和漏洞利用开发库，用Python开发，旨在让使用者简单快速的编写 exploit。', 'Pwn', '2022-02-12 13:13:30', 'http://pwntools.com', 'https://github.com/Gallopsled/pwntools/releases', 1, 'https://static.ctfhub.com/tools/icon/33_aa7aad2a65c1b78803b050f7fc2b8a0b2240c40c.png?1581278983');
INSERT INTO `tool_list` VALUES (57, 'uncompyle6', 'uncompyle6 是一款 Python 反编译工具，可将 .pyc 文件反编译成 .py 源代码文件。', 'Reverse,Web', '2022-02-12 13:13:30', 'https://github.com/rocky/python-uncompyle6', 'https://github.com/rocky/python-uncompyle6/releases', 1, 'https://static.ctfhub.com/tools/icon/32_3fcde10f25beea7038087f968d0f1bf28612ca55.png?1581279727');
INSERT INTO `tool_list` VALUES (58, 'unpy2exe', '从 py2exe 打包的可执行文件中提取 .pyc 文件。', 'Reverse', '2022-02-12 13:13:30', 'https://github.com/matiasb/unpy2exe', 'https://github.com/matiasb/unpy2exe', 1, 'https://static.ctfhub.com/tools/icon/31_cc6621ce019609c68a5aa3c907e79c2f9ec2dd4b.png?1581279739');
INSERT INTO `tool_list` VALUES (59, 'dnSpy', 'dnSpy是一款.NET程序调试器和反编译器。 即使没有可用的源代码，您也可以使用它来编辑和调试程序。', '调试,Reverse', '2022-02-12 13:13:30', 'https://github.com/0xd4d/dnSpy/', 'https://github.com/0xd4d/dnSpy/releases', 1, 'https://static.ctfhub.com/tools/icon/30_24fb33b4aae95e04349b963bf87ce2a5852a532b.png?1581278920');
INSERT INTO `tool_list` VALUES (60, '飘云阁密码学综合工具', '飘云阁密码学综合工具是一款由飘云阁官方推出的绿色免费密码学工具，里面综合了各种密码学的加密算法，有效的节省了时间和走歪路的过程，是各位研究加密密码和破解密码的上好工具。', 'Crypto', '2022-02-12 13:13:30', 'https://www.chinapyg.com/forum.php?mod=viewthread&amp;amp;amp;tid=72459&amp;amp;amp;highlight=%D7%DB%BA%CF%B9%A4%BE%DF', 'https://static.ctfhub.com/tools/attachment/29_b00d6646f46cb59363a2f50f24fe1d14f3f64605.zip?1581275898', 1, 'https://static.ctfhub.com/tools/icon/29_b00d6646f46cb59363a2f50f24fe1d14f3f64605.png?1579168949');
INSERT INTO `tool_list` VALUES (61, 'Detect DTMF Tones', '拨号音识别在线工具。', 'Audio,Misc', '2022-02-12 13:14:09', 'http://dialabc.com/', 'http://dialabc.com/sound/detect/', 1, 'https://static.ctfhub.com/tools/icon/27_edd1d1483556ba640c09a7e68a4971d0caa3d1ea.png?1579167766');
INSERT INTO `tool_list` VALUES (62, 'Elcomsoft Forensic Disk Decryptor(EFDD)', '实时解密BitLocker、PGP以及TrueCrypt加密磁盘。可完全解密所有的文件或实时解密文件。用户可以选择解密所有文件并访问或者实时解密文件。可在32位和64位版本的Windows XP、Windows Vista、Windows 7以及Windows 2003和Windows Server 2008下运行。另外，EFDD在执行以上这些行为之后将不会遗留下任何的访问痕迹。', 'Misc', '2022-02-12 13:14:09', 'https://www.elcomsoft.com/efdd.html', 'http://download.us.elcomsoft.com/efdd_setup_en.msi', 1, 'https://static.ctfhub.com/tools/icon/28_594386a11ff64ba4c4fd5f1130634aa856fed7cf.png?1579168432');
INSERT INTO `tool_list` VALUES (63, 'php_mt_seed', 'php_mt_seed 是一个PHP mt_rand() 种子破解程序。在最简单的调用模式下，在使用mt_srand() 进行可能的播种之后，在给定第一个mt_rand() 输出的情况下，它会找到可能的种子。使用高级调用模式，它还能够将多个，非第一和/或不精确的mt_rand() 输出与可能的种子值进行匹配。', 'Web', '2022-02-12 13:14:09', 'https://www.openwall.com/php_mt_seed/', 'https://www.openwall.com/php_mt_seed/', 1, 'https://static.ctfhub.com/tools/icon/26_d5f4111db21cee44f33bfb28393f711aca6b1279.png?1581280104');
INSERT INTO `tool_list` VALUES (64, '010 Editor', '010Editor是一款快速且强大的十六进制编辑器。用来编辑二进制文件。有一个友好易于使用的界面，无限次的undo和redo操作。另外还可以打印十六进制的字节或者以书签的方式标出某些重要的字节。支持二进制模板（binary template）系统。', '取证(Forensics),隐写,Misc', '2022-02-12 13:14:09', 'http://www.sweetscape.com/010editor/', 'http://www.sweetscape.com/download/010editor/', 1, 'https://static.ctfhub.com/tools/icon/24_a3e7100eb6427011eec6570856509a700b446595.png?1581281519');
INSERT INTO `tool_list` VALUES (65, 'stegdetect', 'Stegdetect是一种自动检测图像中的隐藏内容的工具，目前该项目已不再维护。', '图片,隐写,Misc', '2022-02-12 13:14:09', 'https://github.com/abeluck/stegdetect', 'https://static.ctfhub.com/tools/attachment/25_1ba9b6b0ff2a878c5d72eed7775224f00f5a18f4.zip?1581275987', 1, 'https://static.ctfhub.com/tools/icon/25_1ba9b6b0ff2a878c5d72eed7775224f00f5a18f4.png?1581280110');
INSERT INTO `tool_list` VALUES (66, 'Elcomsoft Wireless Security Auditor', '审核无线网络Wi-Fi的安全性，检查无线网络和信道的工具。嗅探无线流量并破解WPA / WPA2密码。', '抓包,暴力破解,Misc', '2022-02-12 13:14:09', 'https://www.elcomsoft.com/ewsa.html', 'https://www.elcomsoft.com/ewsa.html', 1, 'https://static.ctfhub.com/tools/icon/23_547a2c388a381c800f5fd421ee7ee5b790c6cacc.png?1579166171');
INSERT INTO `tool_list` VALUES (67, 'OutGuess', 'OutGuess 是一款通用的图片隐写工具，目前支持 JPEG 和 PNM 格式，将隐藏信息插入到数据源的冗余位中。', '图片,隐写,Misc', '2022-02-12 13:14:09', 'https://github.com/crorvick/outguess', 'https://github.com/crorvick/outguess', 1, 'https://static.ctfhub.com/tools/icon/22_addc25407b8fe8188f6be8a6af48d4188078f3d4.png?1581280128');
INSERT INTO `tool_list` VALUES (68, 'hashcat', 'hashcat是世界上最快，最先进的密码恢复实用程序，为超过200种高度优化的哈希算法提供了五种独特的攻击模式。 hashcat当前在Linux，Windows和macOS上支持CPU，GPU和其他硬件加速器，并具有分布式密码破解的功能。', '暴力破解,Misc', '2022-02-12 13:14:09', 'https://hashcat.net/hashcat/', 'https://hashcat.net/hashcat/', 1, 'https://static.ctfhub.com/tools/icon/21_e14ab150e60757f5a832632bab7bb863e0b35fcf.png?1581280173');
INSERT INTO `tool_list` VALUES (69, 'Advanced Office Password Recovery', '简称 AOPR。一款能够破解微软 Office 文档密码的工具。支持 Word、Excel、Access、Outlook、PowerPoint、Visio、Publisher、OneNote、Project, 此外还支持 OpenOffice、Hangul Office 格式的文档。', 'Office,暴力破解,Misc', '2022-02-12 13:14:09', 'https://www.elcomsoft.com/aopr.html', 'https://www.elcomsoft.com/aopr.html', 1, 'https://static.ctfhub.com/tools/icon/20_c46a1c1a81f98005eaeed5752777329a289b5c52.png?1579163112');
INSERT INTO `tool_list` VALUES (70, 'Alternate Stream View', 'AlternateStreamView是一个小型实用程序，可让您扫描NTFS驱动器，并找到文件系统中存储的所有隐藏替代流。 扫描并找到备用流后，您可以将这些流提取到指定的文件夹中，删除不需要的流，或将流列表保存到text / html / csv / xml文件中。', '隐写,Misc', '2022-02-12 13:14:09', 'http://www.nirsoft.net/utils/alternate_data_streams.html', 'http://www.nirsoft.net/utils/alternate_data_streams.html', 1, 'https://static.ctfhub.com/tools/icon/18_41f806da32d729cefccec134a5e52684fd2fb478.png?1581281157');
INSERT INTO `tool_list` VALUES (71, 'Advanced Archive Password Recovery', '简称 ArchPR, 一款破解ZIP和RAR文件的密码工具。完美底层优化有助于更快地完成工作。能够保证在一小时之内恢复特定类型的压缩文件。', '压缩包,暴力破解,Misc', '2022-02-12 13:14:09', 'https://www.elcomsoft.com/archpr.html', 'https://www.elcomsoft.com/archpr.html', 1, 'https://static.ctfhub.com/tools/icon/19_064f2266c00ddd05b37ee851a5f1fc54ee0246e0.png?1579162666');
INSERT INTO `tool_list` VALUES (72, 'Adobe PhotoShop', 'Adobe 开发和发行的图像处理软件。', '图片,隐写', '2022-02-12 13:14:09', 'https://www.adobe.com/products/photoshop.html', 'https://www.adobe.com/products/photoshop.html#mini-plans-web-cta-photoshop-card', 1, 'https://static.ctfhub.com/tools/icon/17_e0546824e8f979a2fc3fc464e026d66e6de49585.png?1581278929');
INSERT INTO `tool_list` VALUES (73, 'Adobe Audition', 'Adobe Audition是由Adobe公司开发的一个专业音频编辑软件。', '隐写,Misc', '2022-02-12 13:14:40', 'https://www.adobe.com/products/audition.html', 'https://www.adobe.com/products/audition.html', 1, 'https://static.ctfhub.com/tools/icon/16_de3ecd254fbcab38f9018a599f11856fc2a1fb74.png?1581278910');
INSERT INTO `tool_list` VALUES (74, 'pngcheck', 'pngcheck 用于验证PNG,JNG和MNG文件的完整性,它可以选择以人类可读的形式转储图像中几乎所有的块级信息。例如,它可用于打印有关图像的基本统计信息（尺寸、位深度等）, 列出颜色和透明度信息, 或提取嵌入的文本注释。常用于 IDAT 隐写。', '图片,隐写,Misc', '2022-02-12 13:14:40', 'http://www.libpng.org/pub/png/apps/pngcheck.html', 'http://www.libpng.org/pub/png/apps/pngcheck.html', 1, 'https://static.ctfhub.com/tools/icon/14_1958a4b3142e5dbbb7b52e2fc50ec847661d9cce.png?1581280239');
INSERT INTO `tool_list` VALUES (75, 'ezgif', 'GIF 在线分帧工具', '图片,隐写,Misc', '2022-02-12 13:14:40', 'https://ezgif.com/split', 'https://ezgif.com/split', 1, 'https://static.ctfhub.com/tools/icon/15_9f6ee7667ebfe217c4d4194fe0f24c013c8fc2b2.png?1581280218');
INSERT INTO `tool_list` VALUES (76, 'factordb', '在线大数分解', 'Crypto,RSA', '2022-02-12 13:14:40', 'http://factordb.com/', 'http://factordb.com/', 1, 'https://static.ctfhub.com/tools/icon/13_13b214e86aa76bda1cb6490d5519fb12f8792303.png?1581280246');
INSERT INTO `tool_list` VALUES (77, 'yafu', '一款开源的自动化分解大整数的工具，常用于 RSA 破解', 'Crypto,RSA', '2022-02-12 13:14:40', 'https://sites.google.com/site/bbuhrow/', 'https://sourceforge.net/projects/yafu/files/', 1, 'https://static.ctfhub.com/tools/icon/12_0704c21f4aa484f4bf5c4b515e808d9109ee8f23.png?1581280560');
INSERT INTO `tool_list` VALUES (78, 'thc-hydra', 'hydra 是一个支持多种网络协议的非常快速的口令破解工具。', '暴力破解,Misc,Web', '2022-02-12 13:14:40', 'https://github.com/vanhauser-thc/thc-hydra', 'https://github.com/vanhauser-thc/thc-hydra/releases', 1, 'https://static.ctfhub.com/tools/icon/11_8a6be27b1436ee12d6584edbe991c67333a9847d.png?1581280448');
INSERT INTO `tool_list` VALUES (79, 'Flask Session Cookie Decoder/Encoder', 'Flask 客户端 Session，利用该工具可直接从 Session 解码找出敏感信息, 在知道 SECRET_KEY 的情况下，可利用该工具加密伪造后的 Session', 'Web', '2022-02-12 13:14:40', 'https://noraj.github.io/flask-session-cookie-manager/', 'https://github.com/noraj/flask-session-cookie-manager/archive/master.zip', 1, 'https://static.ctfhub.com/tools/icon/10_7fb51a4fc6aca8afb3425766a527b84b29c78f3d.png?1581280583');
INSERT INTO `tool_list` VALUES (80, 'ZipCenOp', '一款检测、修复 ZIP 伪加密的工具, 需要 JAVA 环境', '压缩包,Misc', '2022-02-12 13:14:40', '', 'https://static.ctfhub.com/tools/attachment/9_2819beddcb395f5423de5a2d6cd8550153058bc8.zip?1581275697', 1, 'https://static.ctfhub.com/tools/icon/9_2819beddcb395f5423de5a2d6cd8550153058bc8.png?1581278129');
INSERT INTO `tool_list` VALUES (81, 'c-jwt-cracker', '一个用C语言编写的多线程JWT密钥暴力破解程序。', '暴力破解,Misc,Web', '2022-02-12 13:14:40', 'https://github.com/brendan-rius/c-jwt-cracker', 'https://github.com/brendan-rius/c-jwt-cracker/archive/master.zip', 1, 'https://static.ctfhub.com/tools/icon/8_7d094d72e83d95c3154c78c9f00eb93aaa1f27d6.png?1581280600');
INSERT INTO `tool_list` VALUES (82, 'AntSword', 'AntSword又名中国蚁剑, 是一款开源的跨平台网站管理工具', 'Web', '2022-02-12 13:14:40', 'https://github.com/AntSwordProject/antSword', 'https://github.com/AntSwordProject/antSword/releases', 1, 'https://static.ctfhub.com/tools/icon/7_b224d8c2575b8b3739fcb307dfd6e7a80901354f.png?1581281068');
INSERT INTO `tool_list` VALUES (83, 'Ziperello', 'Ziperello是一款Windows平台下的ZIP压缩包密码破解工具，软件的原名Turbo ZIP Cracker，可以解压多种压缩格式的文件包。工具还支持双重模式破解，暴力和字典，断点续破、掩码破解等高级特性它也都具备。', '压缩包,暴力破解,Misc', '2022-02-12 13:14:40', '', 'https://static.ctfhub.com/tools/attachment/6_0eed0205bb82cc96f33505cca2e6b1a24bc3b3fa.zip?1581276163', 1, 'https://static.ctfhub.com/tools/icon/6_0eed0205bb82cc96f33505cca2e6b1a24bc3b3fa.png?1581278945');
INSERT INTO `tool_list` VALUES (84, 'IDA Pro', 'IDA Pro 是一款功能丰富的跨平台多处理器反汇编程序和调试器。', '调试,Reverse', '2022-02-12 13:14:40', 'https://www.hex-rays.com/products/ida/', 'https://www.hex-rays.com/products/ida/support/download/', 1, 'https://static.ctfhub.com/tools/icon/5_973a2aeddfd30aaf46c8f6dc9b00b96e4e364322.png?1581281090');
INSERT INTO `tool_list` VALUES (85, 'Audacity', '一款免费的音频处理软件，遵循GNU协议的免费软件。常用于音频隐写。', 'Audio,隐写,Misc', '2022-02-12 13:15:11', 'https://www.audacityteam.org/', 'https://www.audacityteam.org/download/', 1, 'https://static.ctfhub.com/tools/icon/4_5e04b52fce86e3f6ed4bdeee3bb232544933626d.png?1581280890');
INSERT INTO `tool_list` VALUES (86, 'Stegsolve', '一款常用的图片隐写查看工具，可以对图片查看LSB/MSB等，可以对gif逐帧查看，也可以比较两个图片的不同，是图片隐写类题目居家旅行必备工具', '图片,隐写,Misc', '2022-02-12 13:15:11', 'http://www.caesum.com/handbook/stego.htm', 'https://static.ctfhub.com/tools/attachment/3_9b3b470878a69e1e8d4a84f7a234a894d561bd75.zip?1581280699', 1, 'https://static.ctfhub.com/tools/icon/3_9b3b470878a69e1e8d4a84f7a234a894d561bd75.png?1581281219');
INSERT INTO `tool_list` VALUES (87, 'sqlmap', 'sqlmap是一款开源的渗透测试工具,它可以自动检测和利用SQL注入漏洞。', 'SQL注入,Web', '2022-02-12 13:15:11', 'http://sqlmap.org/', 'https://github.com/sqlmapproject/sqlmap/releases', 1, 'https://static.ctfhub.com/tools/icon/2_6c51b61ae1795031873eed2e11ae4bbd89ee691c.png?1581281194');
INSERT INTO `tool_list` VALUES (88, 'BurpSuite', 'Burp Suite 是用于攻击web 应用程序的集成平台，包含了许多工具。Burp Suite为这些工具设计了许多接口，以加快攻击应用程序的过程。所有工具都共享一个请求，并能处理对应的HTTP 消息、持久性、认证、代理、日志、警报。', 'Web', '2022-02-12 13:15:11', 'https://portswigger.net/burp', 'https://portswigger.net/burp/communitydownload', 1, 'https://static.ctfhub.com/tools/icon/1_45c94eed2c2ae20557b5a4914017ba6d97af1373.png?1581281078');

-- ----------------------------
-- Table structure for tool_tags
-- ----------------------------
DROP TABLE IF EXISTS `tool_tags`;
CREATE TABLE `tool_tags`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tool_tags
-- ----------------------------
INSERT INTO `tool_tags` VALUES (1, 'JAVA', '2022-02-04 22:07:43');
INSERT INTO `tool_tags` VALUES (2, 'Python', '2022-02-04 22:06:12');
INSERT INTO `tool_tags` VALUES (3, 'JDK', '2022-02-04 22:06:20');
INSERT INTO `tool_tags` VALUES (4, '网络安全', '2022-02-04 22:06:30');
INSERT INTO `tool_tags` VALUES (5, 'SQL', '2022-02-04 22:06:35');
INSERT INTO `tool_tags` VALUES (6, 'Web', '2022-02-04 22:07:22');
INSERT INTO `tool_tags` VALUES (7, 'SQL注入', '2022-02-04 22:08:07');

-- ----------------------------
-- Table structure for tool_type
-- ----------------------------
DROP TABLE IF EXISTS `tool_type`;
CREATE TABLE `tool_type`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tool_type
-- ----------------------------
INSERT INTO `tool_type` VALUES (1, '安全工具');
INSERT INTO `tool_type` VALUES (2, 'JAVA工具');
INSERT INTO `tool_type` VALUES (3, 'C/C++工具');
INSERT INTO `tool_type` VALUES (4, '前端工具');
INSERT INTO `tool_type` VALUES (5, '运维工具');
INSERT INTO `tool_type` VALUES (6, '其他工具');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `avatar_url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `is_exist` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` datetime NOT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `coin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  `status` tinyint(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '$2a$10$fzDgva1.0bXoBGeh5riKqOU2XnqT4uFaOJxGFoFG9.yUL49nRUMGO', 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic_source%2F34%2F93%2Ffe%2F3493fec56c307642522b2bc2fc4461e0.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1644938763&t=4a3558526cb7183a0e420ec367b65a72', '否', '2022-01-28 22:33:03', '这个人很懒，什么也没留下..', '194908655@qq.com', '18888888886', '倪风', '999850', NULL);
INSERT INTO `user` VALUES (2, 'root2', '2f2320654120ccd1f8bf9d54fd5e7e8e', 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic_source%2F34%2F93%2Ffe%2F3493fec56c307642522b2bc2fc4461e0.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1644938763&t=4a3558526cb7183a0e420ec367b65a72', '是', '2022-01-29 13:05:12', '这个人很懒，什么也没留下...', '15616516', '65165165', 'admin', '0', NULL);
INSERT INTO `user` VALUES (3, 'hahaha', '0e367940f51ce3f24f4abd2d981f443c', 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic_source%2F34%2F93%2Ffe%2F3493fec56c307642522b2bc2fc4461e0.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1644938763&t=4a3558526cb7183a0e420ec367b65a72', '是', '2022-02-12 18:06:20', '这个人很懒，什么也没留下...', '65165165', '1561651', 'hahaha', '0', NULL);
INSERT INTO `user` VALUES (4, '11', '557984a30d19c0328c7180a51e6d65c1', 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic_source%2F34%2F93%2Ffe%2F3493fec56c307642522b2bc2fc4461e0.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1644938763&t=4a3558526cb7183a0e420ec367b65a72', '是', '2022-02-12 19:53:59', '这个人很懒，什么也没留下...', '1343254153@qq.com', '18888888', '11', '0', NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `user_role_role_id`(`role_id`) USING BTREE,
  CONSTRAINT `user_role_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_role_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);

SET FOREIGN_KEY_CHECKS = 1;
