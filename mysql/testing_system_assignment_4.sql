-- question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE VIEW V_ACC_PO as
SELECT acc.*, po.position_name
from account acc
left join `position` po on acc.position_id = po.position_id
WHERE position_name = 'SALES';

-- question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE VIEW V_ACC_GA as
SELECT acc.*, count(ga.group_id) as 'số lượng group'
FROM account acc 
JOIN group_account ga on acc.account_id = ga.account_id
GROUP BY acc.account_id
ORDER BY count(ga.group_id) desc
limit 1;

SELECT acc.*, count(ga.group_id) as 'số lượng group'
FROM account acc 
LEFT JOIN group_account ga on acc.acount_id = ga.account_id
GROUP BY acc.account_id
Having acc.account_id = (SELECT acc.*, count(ga.group_id) as 'số lượng group'
							FROM account acc 
							LEFT JOIN group_acc ga on acc.acount_id = ga.account_id
							GROUP BY acc.account_id
							ORDER BY count(ga.group_id) desc
							limit 1);
                            
-- question 3:	
CREATE VIEW V_LONGQUESTION as
SELECT question_id, content
FROM question
WHERE char_length(content) - char_length(REPLACE(content,' ','')) + 1 > 300;

-- question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE VIEW V_dep_acc as
SELECT de.*, count(acc.account_id)
FROM department de
JOIN account acc on de.department_id = acc.department_id
GROUP BY de.department_id
ORDER BY count(acc.account_id) desc
limit 1;

SELECT de.*, count(acc.account_id)
FROM department de
JOIN account acc on de.department_id = acc.department_id
GROUP BY de.department_id
HAVING count(acc.account_id) = (SELECT de.*, count(acc.account_id)
								FROM department de
								JOIN account acc on de.department_id = acc.department_id
								GROUP BY de.department_id
								ORDER BY count(acc.account_id) desc
								limit 1);
                                
-- question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE VIEW V_CR as
SELECT qu.*
FROM question qu
join account acc on  qu.creator_id = acc.account_id
WHERE full_name LIKE 'NG%';
