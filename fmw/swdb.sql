CREATE DATABASE SWDB default CHARACTER SET UTF8; -- DB 생성

use SWDB; -- SWDB 사용

SET foreign_key_checks = 0; -- 외래키 체크 해제 : 0

drop table sw_user;


-- drop table sw_pool;
drop table sw_center;
-- drop table sw_pool_ttable;
drop table sw_center_ttable;
-- drop table sw_pool_use_type;
drop table sw_center_class;
-- drop table sw_pool_use_type_ttable;
drop table sw_center_class_ttable;
-- drop table sw_pool_vote; -- 테이블 drop
drop table sw_center_vote; 
drop table sw_center_pool; 

drop table sw_user_history;
drop table sw_user_history_dtl;


CREATE TABLE sw_user (-- 사용자 테이블
    uid VARCHAR(20),
    nickname VARCHAR(50),
    sns_login_ci VARCHAR(50),
    report_num INT(11),
    act_yn VARCHAR(2),
    user_type VARCHAR(2),
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(uid)
)  ENGINE=INNODB;

create index idx_nickname on sw_user(nickname);

show index from sw_user;

insert into sw_user values('testdata22','1nickname','1testdata',0,'Y','A',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

select * from sw_user;

delete from SW_USER where UID = 'testdata3';

commit;

CREATE TABLE sw_center (-- 수영장 테이블
    center_id VARCHAR(20) PRIMARY KEY,
    center_nm VARCHAR(50),
    center_location VARCHAR(50),
    center_address_city VARCHAR(100),
    center_address_gu VARCHAR(100),
    center_address_detail VARCHAR(100),
    center_phone VARCHAR(20),
    center_website VARCHAR(50),
    center_sns VARCHAR(50),
    center_parking_yn VARCHAR(2),
    center_image VARCHAR(200),
    center_detail LONGTEXT,
    center_holiday VARCHAR(200),
    center_rule VARCHAR(200),
    center_lane_len VARCHAR(20),
    center_lane_num INT(11),
    center_lane_depth double,
    center_sea_yn VARCHAR(2),
    center_warm_yn VARCHAR(2),
    center_dv_yn VARCHAR(2),
    center_child_yn VARCHAR(2),
    center_locker_yn VARCHAR(2),
    center_locker_price VARCHAR(20),
    center_tower_yn VARCHAR(2),
    center_tower_price VARCHAR(20),    
    center_shuttle_yn VARCHAR(2),
    center_shop_yn VARCHAR(2),
    center_etc_yn VARCHAR(2),
    center_break_yn VARCHAR(2),
    center_thumb_up INT(11),
    center_thumb_down INT(11),
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)  ENGINE=INNODB;

create index IDX_CENTER_NM on sw_center(center_nm);

show index from sw_center;

insert into sw_center values('testdata','testdata','testdata','testdata','testdata','testdata','testdata','testdata','testdata','Y','testdata','testdata','testdata','testdata','25',6,1.5,'Y','Y','Y','Y','Y','Y','Y','Y','Y','Y','Y','Y',2,2,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

select * from sw_center;


commit;

CREATE TABLE sw_center_ttable (-- 수영장 운영시간 테이블
    ctt_id VARCHAR(20),
    center_id VARCHAR(20),
    ctt_order_num INT(11),
    ctt_day VARCHAR(20),
    ctt_time VARCHAR(20),
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(ctt_id,center_id),
    constraint FK_SW_CENTER_CENTER_ID_TTABLE FOREIGN KEY(center_id) references sw_center(center_id)
)  ENGINE=INNODB;

create index FK_SW_CENTER_CENTER_ID_TTABLE on sw_center_ttable(center_id);

show index from sw_center_ttable;

insert into sw_center_ttable values('testdata','testdata',1,'testdata','testdata',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into sw_center_ttable values('1testdata','testdata',1,'testdata','testdata',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into sw_center_ttable values('testdata','1testdata',1,'testdata','testdata',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into sw_center_ttable values('1testdata','1testdata',1,'testdata','testdata',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

commit;


select * from sw_center_ttable;

CREATE TABLE sw_center_pool (-- 수영장 운영시간 테이블
	pool_id	VARCHAR(20),
	center_id	VARCHAR(50),
	pool_nm	VARCHAR(20),
	pool_lane_len	VARCHAR(20),
	pool_lane_num	INT(11),
	pool_lane_depth	VARCHAR(20),
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(pool_id,center_id),
    constraint FK_SW_CENTER_CENTER_ID_POOL FOREIGN KEY(center_id) references sw_center(center_id)
)  ENGINE=INNODB;

create index FK_SW_CENTER_CENTER_ID_POOL on sw_center_pool(center_id);

show index from sw_center_pool;

insert into sw_center_pool values('testdata','testdata','testdata','testdata',11,'testdata',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into sw_center_pool values('1testdata','testdata','testdata','testdata',11,'testdata',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into sw_center_pool values('testdata','2testdata','testdata','testdata',11,'testdata',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into sw_center_pool values('1testdata','2testdata','testdata','testdata',11,'testdata',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

commit;


select * from sw_center_pool;




CREATE TABLE sw_center_class (-- 수영장 운영 타입 테이블
	class_id	VARCHAR(20),
	class_nm	VARCHAR(50),
	center_id	VARCHAR(20),
	class_type1	VARCHAR(20),
	class_type1_fee	VARCHAR(20),
	class_type2	VARCHAR(20),
	class_type2_fee	VARCHAR(20),
	class_type3	VARCHAR(20),
	class_type3_fee	VARCHAR(20),
	class_type4	VARCHAR(20),
	class_type4_fee	VARCHAR(20),
	class_use	longtext,
	class_limit	longtext,
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(class_id,center_id),
    constraint FK_SW_CENTER_CENTER_ID_TYPE FOREIGN KEY(center_id) references sw_center(center_id)
)  ENGINE=INNODB;

create index FK_SW_CENTER_CENTER_ID_TYPE on sw_center_class(center_id);

show index from sw_center_class;

insert into sw_center_class values('testdata','testdata','testdata','testdata','testdata','testdata','testdata','testdata','testdata','testdata','testdata','testdata','testdata',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


select * from sw_center_class;

commit;

CREATE TABLE sw_center_class_ttable (-- 수영장 운영 타입 시간표 테이블
	cctt_id	VARCHAR(20),
	class_id	VARCHAR(20),
	cctt_time	INT(11),
	cctt_day	VARCHAR(20),
	cctt_type	VARCHAR(2),
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(cctt_id,class_id),
    constraint FK_SW_CENTER_CLASS_CLASS_ID FOREIGN KEY(class_id) references sw_center_class(class_id)
)  ENGINE=INNODB;

create index FK_SW_CENTER_CLASS_CLASS_ID on sw_center_class_ttable(class_id);

show index from sw_center_class_ttable;

insert into sw_center_class_ttable values('testdata','testdata',1,'testdata','T',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


select * from sw_center_class_ttable;

commit;

CREATE TABLE sw_center_vote (-- 수영장 추천 정보 테이블
    center_vote_id VARCHAR(20),
	center_id VARCHAR(20),
    uid VARCHAR(20),
	center_vote_type VARCHAR(2),
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(center_vote_id,center_id),
    constraint FK_SW_CENTER_CENTER_ID_VOTE FOREIGN KEY(center_id) references sw_center(center_id)
)  ENGINE=INNODB;

create index FK_SW_CENTER_CENTER_ID_VOTE on sw_center_vote(center_id);

show index from sw_center_vote;

insert into sw_center_vote values('testdata','testdata','testdata','U',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


select * from sw_center_vote;

commit;

CREATE TABLE sw_user_history (-- 사용자 기록 테이블
    history_id VARCHAR(20),
    uid VARCHAR(20),
    act_type VARCHAR(20),
    act_start_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    act_end_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    pool_nm VARCHAR(50),
    pool_lane_len VARCHAR(20),
    pool_depth VARCHAR(20),
    act_cal VARCHAR(20),
    act_total_len VARCHAR(20),
    act_detail longtext,
    act_image VARCHAR(50),
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(history_id,uid),
    constraint FK_SW_USER_UID FOREIGN KEY(uid) references sw_user(uid)
)  ENGINE=INNODB;

create index FK_SW_USER_UID on sw_user_history(uid);

show index from sw_user_history;

insert into sw_user_history values('testdata','testdata','testdata',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'testdata','testdata','testdata','testdata','testdata','testdata','testdata',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


select * from sw_user_history;


CREATE TABLE sw_user_history_dtl (-- 사용자 기록 상세 테이블
    history_dtl_id VARCHAR(20),
    history_id VARCHAR(20),
    history_dtl_order_num INT(11),
    act_stroke VARCHAR(20),
    act_stroke_option VARCHAR(20),
    act_stroke_tool VARCHAR(20),
    act_lap INT(11),
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(history_dtl_id,history_id),
    constraint FK_SW_USER_HISTORY_HISTORY_ID FOREIGN KEY(history_id) references sw_user_history(history_id)
)  ENGINE=INNODB;

create index FK_SW_USER_HISTORY_HISTORY_ID on sw_user_history_dtl(history_id);

show index from sw_user_history_dtl;

insert into sw_user_history_dtl values('testdata','testdata',1,'testdata','testdata','testdata',1,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


select * from sw_user_history_dtl;
