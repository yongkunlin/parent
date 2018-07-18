
-- 创建 job_task 表
CREATE TABLE job_task (
	id VARCHAR (32) NOT NULL COMMENT '主键',
	job_name VARCHAR (20) NOT NULL COMMENT 'job名称',
    group_name VARCHAR (20) NOT NULL COMMENT '分组',
	ploy_id VARCHAR (20) UNIQUE NOT NULL COMMENT '策略id',
	data_base INT NOT NULL COMMENT '所属数据库',
	iz_use INT NOT NULL COMMENT '是否启用',
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
ALTER TABLE job_task ADD INDEX job_name_index (job_name);
ALTER TABLE job_task ADD INDEX group_index (group_name);
ALTER TABLE job_task ADD INDEX data_base_index (data_base);
ALTER TABLE job_task ADD INDEX iz_use_index (iz_use);
ALTER TABLE job_task ADD INDEX update_date_index (update_date);
ALTER TABLE job_task ADD INDEX version_index (version);

-- 创建 ploy 表
CREATE TABLE ploy (
	id VARCHAR (32) NOT NULL COMMENT '主键',
    name VARCHAR (20) NOT NULL COMMENT '策略名称',
    cron VARCHAR (20) UNIQUE NOT NULL COMMENT '策略表达式',
	type VARCHAR (20) NOT NULL COMMENT '策略类型',
	remark VARCHAR(200) COMMENT '备注',
	seq INT COMMENT '排序',
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
ALTER TABLE ploy ADD INDEX name_index (name);
ALTER TABLE ploy ADD INDEX cron_index (cron);
ALTER TABLE ploy ADD INDEX type_index (type);
ALTER TABLE ploy ADD INDEX seq_index (seq);
ALTER TABLE ploy ADD INDEX update_date_index (update_date);
ALTER TABLE ploy ADD INDEX version_index (version);