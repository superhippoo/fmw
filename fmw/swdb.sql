CREATE DATABASE SWDB default CHARACTER SET UTF8; -- DB 생성
use SWDB; -- SWDB 사용



drop table sw_user;
drop table sw_pool;
drop table sw_pool_ttable;
drop table sw_pool_use_type;
drop table sw_pool_use_type_ttable;
drop table sw_pool_vote; -- 테이블 drop
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

CREATE TABLE sw_pool (-- 사용자 테이블
    pool_id VARCHAR(20) PRIMARY KEY,
    pool_nm VARCHAR(50),
    pool_location VARCHAR(50),
    pool_address_city VARCHAR(100),
    pool_address_gu VARCHAR(100),
    pool_address_detail VARCHAR(100),
    pool_phone VARCHAR(20),
    pool_website VARCHAR(50),
    pool_instargram VARCHAR(50),
    pool_parking_yn VARCHAR(2),
    pool_image VARCHAR(50),
    pool_detail LONGTEXT,
    pool_lane_len INT(11),
    pool_lane_num INT(11),
    pool_lane_depth INT(11),
    pool_sea_yn VARCHAR(2),
    pool_child_yn VARCHAR(2),
    pool_locker_yn VARCHAR(2),
    pool_locker_price VARCHAR(20),
    pool_tower_yn VARCHAR(2),
    pool_tower_price VARCHAR(20),
    pool_shuttle_yn VARCHAR(2),
    pool_shop_yn VARCHAR(2),
    pool_etc_yn VARCHAR(2),
    pool_break_yn VARCHAR(2),
    pool_thumb_up INT(11),
    pool_thumb_down INT(11),
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)  ENGINE=INNODB;

create index IDX_POOL_NM on sw_pool(pool_nm);

show index from sw_pool;

insert into sw_pool values('testdata','testdata','testdata','testdata','testdata','testdata','testdata','testdata','testdata','Y','testdata','testdata',25,6,1,'Y','Y','Y','testdata','Y','testdata','Y','Y','Y','Y',2,2,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into sw_pool values('1testdata','testdata','testdata','testdata','testdata','testdata','testdata','testdata','testdata','Y','testdata','testdata',25,6,1,'Y','Y','Y','testdata','Y','testdata','Y','Y','Y','Y',2,2,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

select * from sw_pool;


CREATE TABLE sw_pool_ttable (-- 수영장 운영시간 테이블
    ptt_id VARCHAR(20),
    pool_id VARCHAR(20),
    ptt_order_num INT(11),
    ptt_day VARCHAR(20),
    ptt_time VARCHAR(20),
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(ptt_id,pool_id),
    constraint FK_SW_POOL_POOL_ID_TTABLE FOREIGN KEY(pool_id) references sw_pool(pool_id)
)  ENGINE=INNODB;

create index FK_SW_POOL_POOL_ID_TTABLE on sw_pool_ttable(pool_id);

show index from sw_pool_ttable;

insert into sw_pool_ttable values('testdata','testdata',1,'testdata','testdata',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into sw_pool_ttable values('1testdata','testdata',1,'testdata','testdata',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into sw_pool_ttable values('testdata','1testdata',1,'testdata','testdata',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
insert into sw_pool_ttable values('1testdata','1testdata',1,'testdata','testdata',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);



select * from sw_pool_ttable;



CREATE TABLE sw_pool_use_type (-- 수영장 운영 타입 테이블
    type_id VARCHAR(20),
    type_nm VARCHAR(50),
    pool_id VARCHAR(20),
    type_day_price VARCHAR(20),
    type_period_price VARCHAR(20),
    type_regist_time VARCHAR(20),
    type_tip longtext,
    type_user_num INT(11),
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(type_id,pool_id),
    constraint FK_SW_POOL_POOL_ID_TYPE FOREIGN KEY(pool_id) references sw_pool(pool_id)
)  ENGINE=INNODB;

create index FK_SW_POOL_POOL_ID_TYPE on sw_pool_use_type(pool_id);

show index from sw_pool_use_type;

insert into sw_pool_use_type values('testdata','testdata','testdata','testdata','testdata','testdata','testdata',10,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


select * from sw_pool_use_type;



CREATE TABLE sw_pool_use_type_ttable (-- 수영장 운영 타입 시간표 테이블
    ttt_id VARCHAR(20),
	type_id VARCHAR(20),
	ttt_start_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ttt_end_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ttt_day VARCHAR(20),
	type_type VARCHAR(2),
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(ttt_id,type_id),
    constraint FK_SW_POOL_TYPE_TYPE_ID FOREIGN KEY(type_id) references sw_pool_use_type(type_id)
)  ENGINE=INNODB;

create index FK_SW_POOL_TYPE_TYPE_ID on sw_pool_use_type_ttable(type_id);

show index from sw_pool_use_type_ttable;

insert into sw_pool_use_type_ttable values('testdata','testdata',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,'testdata','Y',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


select * from sw_pool_use_type_ttable;


CREATE TABLE sw_pool_vote (-- 수영장 추천 정보 테이블
    pool_vote_id VARCHAR(20),
	pool_id VARCHAR(20),
    uid VARCHAR(20),
	pool_vote_type VARCHAR(2),
    reg_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    mdfy_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(pool_vote_id,pool_id),
    constraint FK_SW_POOL_POOL_ID_VOTE FOREIGN KEY(pool_id) references sw_pool(pool_id)
)  ENGINE=INNODB;

create index FK_SW_POOL_POOL_ID_VOTE on sw_pool_vote(pool_id);

show index from sw_pool_vote;

insert into sw_pool_vote values('testdata','testdata','testdata','U',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


select * from sw_pool_vote;

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
