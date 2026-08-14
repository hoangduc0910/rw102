create database quan_ly_dau_vao;
-- table 1
CREATE TABLE department(
	department_id	int,
    deparment_name	varchar(60)
    );
    
-- table 2
CREATE TABLE `position`(
	position_id		int,
	position_name	ENUM('DEV','TEST','SCRUM MASTER','PM')
);

-- table 3
CREATE TABLE `account`(
	account_id		int,
	email			varchar(60),
	user_name		varchar(60),
	full_name		varchar(60),
	department_id	int,
	position_id		int,
	create_date		date 
);

-- table 4
CREATE TABLE `group`(
	group_id		int,
	group_name		varchar(50),
	creator_id		int,
	create_date		date 
);

-- table 5
CREATE TABLE group_account(
	group_id		int,
    account_id		int,
    join_date		date
    );
    
-- table 6
CREATE TABLE type_question(
	type_id			int,
    type_name		enum('essay','mutiple-choice')
    );
    
-- table 7
CREATE TABLE category_question(
	category_id		int,
    category_name	varchar(40)
    );

-- table 8
CREATE TABLE question(
	question_id		int,
    content			varchar(70),
    category_id		int,
    type_id			int,
    creator_id		int,
    create_date		date 
    );
    
-- table 9
CREATE TABLE answer(
	answer_id		int,
    content			varchar(50),
    question_id		int,
    is_correct		enum('đúng','sai')
    );
    
-- table 10
CREATE TABLE exam(
	exam_id			int,
    code			varchar(10),
    title			varchar(50),
    category_id		int,
    duration		time,
    creator_id		int,
    create_date		date 
    );

-- table 11
CREATE TABLE exam_question(
	exam_id			int,
    question_id		int 
    );