create database quan_ly_dau_vao;
-- table 1
drop TABLE IF EXISTS department;
CREATE TABLE department(
	department_id	INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    department_name	varchar(60)
    );
    
-- table 2
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`(
	position_id		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	position_name	ENUM('DEV','TEST','SCRUM MASTER','PM')
);

-- table 3
DROP table IF EXISTS `account`;
CREATE TABLE `account`(
	account_id		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	email			varchar(60)	UNIQUE NOT NULL,
	user_name		varchar(60)	UNIQUE NOT NULL,
	full_name		varchar(60) DEFAULT 'NO NAME',
	department_id	int	UNSIGNED,
	position_id		int	UNSIGNED,
	create_date		DATETIME DEFAULT CURRENT_TIMESTAMP,
    constraint fk_dep_acc foreign key (department_id) references department(department_id),
    constraint fk_pos_acc foreign key (position_id)   references `position`(position_id)
);

-- table 4
drop table IF EXISTS `group`;
CREATE TABLE `group`(
	group_id		int UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	group_name		varchar(100) UNIQUE NOT NULL,
	creator_id		INT UNIQUE NOT NULL,
	create_date		DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- table 5
DROP TABLE IF EXISTS group_account;
CREATE TABLE group_account(
	group_id		INT UNSIGNED  ,
    account_id		int UNSIGNED  ,
    join_date		DATETIME DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT fk_grpacc_grp FOREIGN KEY (group_id) REFERENCES `group`(group_id),
    CONSTRAINT fk_grpacc_acc FOREIGN KEY (account_id) REFERENCES `account`(account_id)
    );
    
-- table 6
DROP TABLE IF EXISTS type_question;
CREATE TABLE type_question(
	type_id			INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    type_name		enum('essay','multiple-choice') NOT NULL
    );
    
-- table 7
DROP TABLE IF EXISTS category_question;
CREATE TABLE category_question(
	category_id		int UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    category_name	varchar(40) NOT NULL
    );

-- table 8
DROP TABLE IF EXISTS question;
CREATE TABLE question(
	question_id		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    content			varchar(100) NOT NULL,
    category_id		INT UNSIGNED,
    type_id			INT UNSIGNED,
    creator_id		INT UNIQUE NOT NULL ,
    create_date		DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_ques_cate FOREIGN KEY (category_id) REFERENCES category_question (category_id),
    CONSTRAINT fk_ques_type FOREIGN KEY (type_id) REFERENCES type_question (type_id)
    );
    
-- table 9
DROP TABLE IF EXISTS answer;
CREATE TABLE answer(
	answer_id		INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    content			varchar(80) NOT NULL,
    question_id		INT UNSIGNED,
    is_correct		enum('đúng','sai'),
    CONSTRAINT fk_ans_ques FOREIGN KEY (question_id) REFERENCES question (question_id)
    );
    
-- table 10
DROP TABLE IF EXISTS exam;
CREATE TABLE exam(
	exam_id			INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    code			varchar(10) NOT NULL,
    title			varchar(50) NOT NULL,
    category_id		INT UNSIGNED,
    duration		INT NOT NULL,
    creator_id		INT NOT NULL UNIQUE,
    create_date		DATETIME DEFAULT CURRENT_TIMESTAMP
    );

-- table 11
DROP TABLE IF EXISTS exam_question;
CREATE TABLE exam_question(
	exam_id			INT UNSIGNED,
    question_id		INT UNSIGNED,
    CONSTRAINT fk_exqus_exam FOREIGN KEY (exam_id) REFERENCES exam (exam_id),
    CONSTRAINT fk_exqus_ans FOREIGN KEY (question_id) REFERENCES question (question_id)
    );
    
-- Insert dữ liệu
-- table 1
INSERT INTO department(department_name)
		values 	('sale'),
				('marketing'),
				('kế toán'),
				('nhân sự'),
                ('bảo vệ');

-- table 2
INSERT INTO `position`(position_name)
		values	('DEV'),
				('TEST'),
                ('SCRUM MASTER'),
                ('PM');
-- table 3
INSERT INTO `account`(Email,user_name,department_id,position_id)
		values	('123@gmail.com','ducminh',1,4),
				('234@gmail.com','minhduc',5,1),
                ('231a@gmail.com','hoang',1,2),
                ('asdasw@gmail.com','long',5,2),
                ('czkq@gmail.com','trang',3,1);
 
 -- table 4
 INSERT INTO `group`(group_name,creator_id)
		values	('group1',2),
				('group2',1),
                ('group3',4),
                ('group4',5),
                ('group5',3);
                
-- table 5
INSERT INTO group_account(group_id,account_id)
		values	(1,3),
				(2,2),
                (2,1),
                (3,5),
                (4,3);
                
-- table 6
INSERT INTO type_question(type_name)
		values	('essay'),
				('multiple-choice');

-- table 7
INSERT INTO category_question(category_name)
		values	('JAVA'),
				('.NET'),
                ('SQL'),
                ('POSTMAN'),
                ('RUBY');

-- table 8
INSERT INTO question(content,category_id,type_id,creator_id)
		values	('câu hỏi 1',1,2,'110'),
				('câu hỏi 2',5,2,'111'),
                ('câu hỏi 3',3,1,'112'),
                ('câu hỏi 4',2,2,'113'),
                ('câu hỏi 4',4,2,'114');

-- table 9
INSERT INTO answer(content,question_id,is_correct)
		values	('trả lời 1',1,'đúng'),
				('trả lời 2',4,'sai'),
                ('trả lời 3',3,'đúng');
                
-- table 10
INSERT INTO exam(code,title,category_id,duration,creator_id)
		values	('a1','title1','1','60','101'),
				('a2','title2','2','90','102'),
                ('a3','title3','3','30','103');
                select * from exam;

-- table 11
INSERT INTO exam_question(exam_id,question_id)
		values	(3,5),
				(2,4),
                (1,3),
                (2,2);
