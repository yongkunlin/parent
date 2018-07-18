-- 创建session表
create table session(
   id VARCHAR(32) NOT NULL COMMENT '主键',
   user_id VARCHAR(32) NOT NULL COMMENT '用户id',
	 org_id VARCHAR(32) NOT NULL COMMENT '部门id',
   access_ip VARCHAR(15) NOT NULL COMMENT '访问ip',
	 access_time DATETIME NOT NULL COMMENT '访问时间',
	 access_url VARCHAR(200) NOT NULL COMMENT '访问路径',
	 state int NOT NULL COMMENT '状态',
   PRIMARY KEY ( id )
);
ALTER TABLE session ADD INDEX access_time_index (access_time);
ALTER TABLE session ADD INDEX user_id_index (user_id);

-- 创建 org 表
CREATE TABLE org (
	id VARCHAR (32) NOT NULL COMMENT '主键',
	org_name VARCHAR (20) NOT NULL COMMENT '名称',
	org_code VARCHAR (20) UNIQUE NOT NULL COMMENT '编码',
	org_level INT NOT NULL COMMENT '层级',
	parent_id VARCHAR (32) COMMENT '父id',
	create_user VARCHAR (20) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	create_ip VARCHAR (15) NOT NULL COMMENT '创建ip',
	update_user VARCHAR (20) NOT NULL COMMENT '修改人',
	update_date datetime NOT NULL COMMENT '修改时间',
	update_ip VARCHAR (15) NOT NULL COMMENT '修改ip',
	delete_user VARCHAR (20) COMMENT '删除人',
	delete_date datetime COMMENT '删除时间',
	delete_ip VARCHAR (15) COMMENT '删除',
	iz_delete INT NOT NULL COMMENT '是否删除',
	version INT NOT NULL COMMENT '版本',
	PRIMARY KEY (id)
);
ALTER TABLE org ADD INDEX org_name_index (org_name);
ALTER TABLE org ADD INDEX parent_id_index (parent_id);
ALTER TABLE org ADD INDEX update_date_index (update_date);
ALTER TABLE org ADD INDEX version_index (version);


-- 创建 user 表
CREATE TABLE user (
	id VARCHAR (32) NOT NULL COMMENT '主键',
	user_name VARCHAR (20) NOT NULL COMMENT '名称',
	user_code VARCHAR (20) UNIQUE NOT NULL COMMENT '编码',
	org_id VARCHAR (32) COMMENT '部门id',
	create_user VARCHAR (20) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	create_ip VARCHAR (15) NOT NULL COMMENT '创建ip',
	update_user VARCHAR (20) NOT NULL COMMENT '修改人',
	update_date datetime NOT NULL COMMENT '修改时间',
	update_ip VARCHAR (15) NOT NULL COMMENT '修改ip',
	delete_user VARCHAR (20) COMMENT '删除人',
	delete_date datetime COMMENT '删除时间',
	delete_ip VARCHAR (15) COMMENT '删除',
	iz_delete INT NOT NULL COMMENT '是否删除',
	version INT NOT NULL COMMENT '版本',
	PRIMARY KEY (id)
);
ALTER TABLE user ADD INDEX user_name_index (user_name);
ALTER TABLE user ADD INDEX org_id_index (org_id);
ALTER TABLE user ADD INDEX update_date_index (update_date);
ALTER TABLE user ADD INDEX version_index (version);

-- 创建 log 表
CREATE TABLE log (
	id VARCHAR (32) NOT NULL COMMENT '主键',
	level INT NOT NULL COMMENT '等级',
	type INT NOT NULL COMMENT '类型',
	operator_obj TEXT COMMENT '操作对象',
	operator_describe VARCHAR (200) COMMENT '操作描述',
	modle VARCHAR (50) COMMENT '模块',
	operator_user VARCHAR (20) NOT NULL COMMENT '操作人',
	operator_time datetime NOT NULL COMMENT '操作时间',
	operator_ip VARCHAR (15) NOT NULL COMMENT '操作ip',
	PRIMARY KEY (id)
);
ALTER TABLE log ADD INDEX level_index (level);
ALTER TABLE log ADD INDEX type_index (type);
ALTER TABLE log ADD INDEX operator_time_index (operator_time);

-- 创建 resource 表
CREATE TABLE resource (
	id VARCHAR (32) NOT NULL COMMENT '主键',
	resource_name VARCHAR (20) NOT NULL COMMENT '名称',
	resource_code VARCHAR (20) UNIQUE NOT NULL COMMENT '编码',
	url VARCHAR (32) COMMENT '路径',
	level INT NOT NULL COMMENT '层级',
	status INT NOT NULL COMMENT '状态',
	parent_id VARCHAR (32) COMMENT '父id',
	create_user VARCHAR (20) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	create_ip VARCHAR (15) NOT NULL COMMENT '创建ip',
	update_user VARCHAR (20) NOT NULL COMMENT '修改人',
	update_date datetime NOT NULL COMMENT '修改时间',
	update_ip VARCHAR (15) NOT NULL COMMENT '修改ip',
	delete_user VARCHAR (20) COMMENT '删除人',
	delete_date datetime COMMENT '删除时间',
	delete_ip VARCHAR (15) COMMENT '删除',
	iz_delete INT NOT NULL COMMENT '是否删除',
	version INT NOT NULL COMMENT '版本',
	PRIMARY KEY (id)
);
ALTER TABLE resource ADD INDEX resource_name_index (resource_name);
ALTER TABLE resource ADD INDEX level_index (level);
ALTER TABLE resource ADD INDEX status_index (status);
ALTER TABLE resource ADD INDEX update_date_index (update_date);
ALTER TABLE resource ADD INDEX version_index (version);


-- 创建 role 表
CREATE TABLE role (
	id VARCHAR (32) NOT NULL COMMENT '主键',
	role_name VARCHAR (20) NOT NULL COMMENT '名称',
	role_code VARCHAR (20) UNIQUE NOT NULL COMMENT '编码',
	level INT NOT NULL COMMENT '层级',
	status INT NOT NULL COMMENT '状态',
  parent_id VARCHAR (32) COMMENT '父id',
	create_user VARCHAR (20) NOT NULL COMMENT '创建人',
	create_date datetime NOT NULL COMMENT '创建时间',
	create_ip VARCHAR (15) NOT NULL COMMENT '创建ip',
	update_user VARCHAR (20) NOT NULL COMMENT '修改人',
	update_date datetime NOT NULL COMMENT '修改时间',
	update_ip VARCHAR (15) NOT NULL COMMENT '修改ip',
	delete_user VARCHAR (20) COMMENT '删除人',
	delete_date datetime COMMENT '删除时间',
	delete_ip VARCHAR (15) COMMENT '删除',
	iz_delete INT NOT NULL COMMENT '是否删除',
	version INT NOT NULL COMMENT '版本',
	PRIMARY KEY (id)
);
ALTER TABLE role ADD INDEX role_name_index (role_name);
ALTER TABLE role ADD INDEX level_index (level);
ALTER TABLE role ADD INDEX status_index (status);
ALTER TABLE role ADD INDEX update_date_index (update_date);
ALTER TABLE role ADD INDEX version_index (version);