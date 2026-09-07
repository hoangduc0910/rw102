-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước 
DELIMITER $$
create trigger tgq1
BEFORE insert on group_table 
for each row 
BEGIN	
	IF new.created_date < date_sub(now(), interval 1 year)
    then signal SQLSTATE '11111'
    set message_text = ' không thể nhập vào group tạo từ 1 năm trước' ;
END if ;
END$$
DELIMITER ;

/* Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user 
 nào vào department "Sale" nữa, khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user" */
DELIMITER $$
create trigger tgq2
BEFORE insert on department
for each row 
BEGIN	
	declare	dep_name varchar(100);
    SELECT department_name INTO dep_name
    FROM department
    WHERE department_id = new.department_id;
    
    IF dep_name = 'sales' then
		signal sqlstate '11111'
        SET MESSAGE_TEXT = 'department "Sale" cannot add more user';
	end if ;
END$$
DELIMITER ;

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user 
DELIMITER $$
create trigger tgq3
BEFORE insert on group_account
for each row 
BEGIN	
	declare v_count INT;
    select count(1) into v_count
    from group_account ga
    join account acc on ga.account_id = acc.account_id
    where group_id = new.group_id;
    
    IF v_count >= 5 then
		SIGNAL SQLSTATE '11111'
		SET MESSAGE_TEXT = 'group đã đủ 5 thành viên' ;
	END IF ;

END$$
DELIMITER ;

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question 
DELIMITER $$
create trigger tgq4
BEFORE insert on exam_question
for each row 
BEGIN	
	declare a_count INT;
    select count(1) into a_count
    from exam_question eq
    join question e on eq.question_id = e.question_id
    where exam_id = new.exam_id;
    
    IF v_count >= 10 then
		SIGNAL SQLSTATE '11111'
		SET MESSAGE_TEXT = 'bài thi đã đủ 10 câu hỏi' ;
	END IF ;

END$$
DELIMITER ;

/* Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là admin@gmail.com (đây là tài khoản admin, 
không cho phép user xóa), còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó */
DELIMITER $$
create trigger tgq5
BEFORE delete on account
for each row 
BEGIN	
	IF old.email = 'admin@gmail.com' THEN
		SIGNAL SQLSTATE '11111'
        SET MESSAGE_TEXT = 'đây là tài khoản admin, không cho phép user xóa' ;
	END IF ;

END$$
DELIMITER ;

/* Question 6: Không sử dụng cấu hình default cho field DepartmentID của table Account, hãy tạo 
	trigger cho phép người dùng khi tạo account không điền vào departmentID thì sẽ được phân vào phòng ban "waiting Department"  */
DELIMITER $$
create trigger tgq6
BEFORE insert on account
for each row 
BEGIN	
IF new.department_id IS NULL THEN
		SET new.department_id = (select department_id
								from department
								where department_name = 'phòng chờ'
                                limit 1);
END IF ;

END$$
DELIMITER ;

-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng. 
DELIMITER $$
create trigger tgq7
BEFORE insert on answer
for each row 
BEGIN	
	DECLARE v_answer INT;
    DECLARE v_correct INT;
    
    select count(1) into v_answer
    from answer 
    WHERE answer_id = new.answer_id;
    
    IF v_answer >= 4 THEN
		SIGNAL SQLSTATE '11111'
        SET MESSAGE_TEXT = 'đã đủ 4 cẩu trả lời';
	END IF;

SELECT count(1) into v_correct
from answer
where answer_id = new.answer_id AND is_correct = TRUE;

IF v_correct >= 2 and new.iscorrect = TRUE then
	SIGNAL SQLSTATE '11111'
    SET MESSAGE_TEXT = 'tối đa 2 câu trả lời đúng';
    END iF;

END$$
DELIMITER ;

/* Question 8: Viết trigger sửa lại dữ liệu cho đúng: Nếu người dùng nhập vào gender của account là nam, nữ, 
chưa xác định thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database */
DELIMITER $$
create trigger tgq7
BEFORE insert on answer
for each row 
BEGIN	
	DECLARE v_answer INT;
    DECLARE v_correct INT;
    
    select count(1) into v_answer
    from answer 
    WHERE answer_id = new.answer_id;
    
    IF v_answer >= 4 THEN
		SIGNAL SQLSTATE '11111'
        SET MESSAGE_TEXT = 'đã đủ 4 cẩu trả lời';
	END IF;

SELECT count(1) into v_correct
from answer
where answer_id = new.answer_id AND is_correct = TRUE;

IF v_correct >= 2 and new.iscorrect = TRUE then
	SIGNAL SQLSTATE '11111'
    SET MESSAGE_TEXT = 'tối đa 2 câu trả lời đúng';
    END iF;

END$$
DELIMITER ;

/*Question 8: Viết trigger sửa lại dữ liệu cho đúng: Nếu người dùng nhập vào gender của account
 là nam, nữ, chưa xác định thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database */
 DELIMITER $$
create trigger tgq7
BEFORE insert on answer
for each row 
BEGIN	
	DECLARE v_answer INT;
    DECLARE v_correct INT;
    
    select count(1) into v_answer
    from answer 
    WHERE answer_id = new.answer_id;
    
    IF v_answer >= 4 THEN
		SIGNAL SQLSTATE '11111'
        SET MESSAGE_TEXT = 'đã đủ 4 cẩu trả lời';
	END IF;

SELECT count(1) into v_correct
from answer
where answer_id = new.answer_id AND is_correct = TRUE;

IF v_correct >= 2 and new.iscorrect = TRUE then
	SIGNAL SQLSTATE '11111'
    SET MESSAGE_TEXT = 'tối đa 2 câu trả lời đúng';
    END iF;

END$$
DELIMITER ;

/* Question 8: Viết trigger sửa lại dữ liệu cho đúng: Nếu người dùng nhập vào gender của account là nam, nữ, 
chưa xác định thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database */
DELIMITER $$
create trigger tgq8
BEFORE insert on account
for each row 
BEGIN	
	 IF LOWER(NEW.gender) = 'nam' THEN
        SET NEW.gender = 'M';
    ELSEIF LOWER(NEW.gender) = ('nữ') THEN
        SET NEW.gender = 'F';
    ELSEIF LOWER(NEW.gender) = ('chưa xác định') THEN
        SET NEW.gender = 'U';
END IF;
END$$
DELIMITER ;

-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày 
DELIMITER $$
CREATE TRIGGER tgq9
BEFORE DELETE ON exam
FOR EACH ROW
BEGIN
    IF OLD.CreateDate > DATE_SUB(NOW(), INTERVAL 2 DAY) THEN
        SIGNAL SQLSTATE '11111'
        SET MESSAGE_TEXT = 'không thể xóa bài thi mới tạo được 2 ngày';
    END IF;
END$$
DELIMITER ;

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào 
DELIMITER $$
CREATE TRIGGER tgq10_update
BEFORE UPDATE ON question
FOR EACH ROW
BEGIN
    IF EXISTS (SELECT * FROM exam_question
        WHERE question_id = old.question_id
    ) THEN
        SIGNAL SQLSTATE '11111'
        SET MESSAGE_TEXT = 'không thể cập nhật vì đã tồn tại trong exam';
    END IF;
END $$
DELIMITER ;

-- Delete
DELIMITER $$
CREATE TRIGGER tgq10_delete
BEFORE DELETE ON question
FOR EACH ROW
BEGIN
    IF EXISTS (SELECT * FROM exam_question
        WHERE question_id = old.question_id
    ) THEN
        SIGNAL SQLSTATE '11111'
        SET MESSAGE_TEXT = 'không thể xóa vì đã tồn tại trong exam';
    END IF;
END $$
DELIMITER ;