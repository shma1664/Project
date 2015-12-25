#MySQL默认存储引擎为MyISAM，该引擎不支持事务管理，仅存储，优点是读写速度块
#InnoDB支持事务管理
#论坛类系统的表一般都使用MyISAM引擎，这边是为了测试事务管理才改用InnoDB

#创建用户表
CREATE TABLE t_user (
	user_id		INT		AUTO_INCREMENT PRIMARY KEY,
	user_name	VARCHAR(30)	NOT NULL,
	credits		INT,
	PASSWORD	VARCHAR(32)	NOT NULL,
	last_visit_time		DATETIME,
	last_ip		VARCHAR(23)
)ENGINE=INNODB;

#创建登录日志表
CREATE TABLE t_login_log (
	login_log_id	INT	AUTO_INCREMENT PRIMARY KEY,
	user_id			INT	NOT NULL,
	ip				VARCHAR(23),
	login_time		DATETIME
)ENGINE=INNODB;