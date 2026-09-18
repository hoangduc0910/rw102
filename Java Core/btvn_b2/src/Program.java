import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Program {
    public static void main(String[] args) {
        Department department1 = new Department();
        department1.id = 1;
        department1.departmentName = "Sale";

        Department department2 = new Department();
        department2.id = 2;
        department2.departmentName = "Marketing";

        Department department3 = new Department();
        department3.id = 3;
        department3.departmentName = "Bảo vệ";

        System.out.println("Department Id: " + department1.id);
        System.out.println("Department Name: " + department1.departmentName);

        Department[]departments = {department1, department2, department3};

        //postion
        Position position1 = new Position();
        position1.id = 1;
        position1.positionName = PositionName.DEV;

        Position position2 = new Position();
        position2.id = 2;
        position2.positionName = PositionName.PM;

        Position position3 = new Position();
        position3.id = 3;
        position3.positionName = PositionName.TEST;

        System.out.println("Position Id: " + position1.id);
        System.out.println("Position Name: " + position1.positionName);

        Position[] positions = {position1, position2, position3};

        //Account
        Account account1 = new Account();
        account1.id = 1;
        account1.userName = "duc hoang";
        account1.fullName = "Hoàng Minh Đức";
        account1.email = "duchoang1@gmail.com";
        account1.department = department1;
        account1.position = position1;
        account1.createDate = LocalDate.now();

        Account account2 = new Account();
        account2.id = 2;
        account2.userName = "longhoang";
        account2.fullName = "Hoàng Minh Long";
        account2.email = "longhoang1@gmail.com";
        account2.department = department2;
        account2.position = position2;
        account2.createDate = LocalDate.now();

        Account account3 = new Account();
        account3.id = 3;
        account3.userName = "namdang";
        account3.fullName = "Đặng Quang Nam";
        account3.email = "namdang123@gmail.com";
        account3.department = department3;
        account3.position = position3;
        account3.createDate = LocalDate.now();

        System.out.println("Account Id: " + account1.id);
        System.out.println("User Name: " + account1.userName);
        System.out.println("Full Name: " + account1.fullName);
        System.out.println("email: " + account1.email);
        System.out.println("Department: " + account1.department);
        System.out.println("Position: " + account1.position);
        System.out.println("Create Date " + account1.createDate);

        Account[] accounts = {account1, account2,account3};

        //Group
        Group group1 = new Group();
        group1.id = 1;
        group1.groupName = "group1";
        group1.creator = account1;
        group1.createDate = LocalDate.now();

        Group group2 = new Group();
        group2.id = 2;
        group2.groupName = "group2";
        group2.creator = account2;
        group2.createDate = LocalDate.now();

        Group group3 = new Group();
        group3.id = 3;
        group3.groupName = "group3";
        group3.creator = account3;
        group3.createDate = LocalDate.now();

        System.out.println("Group ID: " + group1.id);
        System.out.println("Group Name: " + group1.groupName);
        System.out.println("creator: " + group1.creator);
        System.out.println("Create Date: " + group1.createDate);

        //GroupAccount
        GroupAccount groupAccount1 = new GroupAccount();
        groupAccount1.group = group1;
        groupAccount1.account = account1;
        groupAccount1.joinDate = LocalDate.now();

        GroupAccount groupAccount2 = new GroupAccount();
        groupAccount2.group = group2;
        groupAccount2.account = account2;
        groupAccount2.joinDate = LocalDate.now();

        GroupAccount groupAccount3 = new GroupAccount();
        groupAccount3.group = group3;
        groupAccount3.account = account3;
        groupAccount3.joinDate = LocalDate.now();

        System.out.println("Group Account Id: +" + groupAccount1.group);
        System.out.println("Account: +" + groupAccount1.account);
        System.out.println("Join Date: +" + groupAccount1.joinDate);

        GroupAccount[] groupAccounts = {groupAccount1, groupAccount2, groupAccount3};

        //TypeQuestion
        TypeQuestion typeQuestion1 = new TypeQuestion();
        typeQuestion1.id = 1;
        typeQuestion1.typeName = TypeName.ESSAY;

        TypeQuestion typeQuestion2 = new TypeQuestion();
        typeQuestion2.id = 2;
        typeQuestion2.typeName = TypeName.MULTIPLE_CHOICE;

        TypeQuestion typeQuestion3 = new TypeQuestion();
        typeQuestion3.id = 3;
        typeQuestion3.typeName = TypeName.ESSAY;

        System.out.println("Type Question Id: " + typeQuestion1.id);
        System.out.println("Type Question Name: " + typeQuestion1.typeName);


        //CategoryQuestion
        CategoryQuestion categoryQuestion1 = new CategoryQuestion();
        categoryQuestion1.id = 1;
        categoryQuestion1.categoryName = "Java";

        CategoryQuestion categoryQuestion2 = new CategoryQuestion();
        categoryQuestion2.id = 2;
        categoryQuestion2.categoryName = "SQL";

        CategoryQuestion categoryQuestion3 = new CategoryQuestion();
        categoryQuestion3.id = 3;
        categoryQuestion3.categoryName = "Postman";

        System.out.println("Category Question Id: " + categoryQuestion1.id);
        System.out.println("Category Question Name: " + categoryQuestion1.categoryName);


        //Question
        Question question1 = new Question();
        question1.id = 1;
        question1.content = "content1";
        question1.category = categoryQuestion1;
        question1.type = typeQuestion1;
        question1.creator = account1;
        question1.createDate = LocalDate.now();

        Question question2 = new Question();
        question2.id = 2;
        question2.content = "content2";
        question2.category = categoryQuestion2;
        question2.type = typeQuestion2;
        question2.creator = account2;
        question2.createDate = LocalDate.now();

        Question question3 = new Question();
        question3.id = 3;
        question3.content = "content3";
        question3.category = categoryQuestion3;
        question3.type = typeQuestion3;
        question3.creator = account3;
        question3.createDate = LocalDate.now();

        System.out.println("Question Id: " + question1.id);
        System.out.println("Content: " + question1.content);
        System.out.println("Category: " + question1.category);
        System.out.println("Type: " + question1.type);
        System.out.println("Creator: " + question1.creator);
        System.out.println("Create Date: " + question1.createDate);


        //Answer
        Answer answer1 = new Answer();
        answer1.id = 1;
        answer1.content = "content01";
        answer1.question = question1;
        answer1.isCorrect = true;

        Answer answer2 = new Answer();
        answer2.id = 2;
        answer2.content = "content02";
        answer2.question = question2;
        answer2.isCorrect = true;

        Answer answer3 = new Answer();
        answer3.id = 3;
        answer3.content = "content03";
        answer3.question = question3;
        answer3.isCorrect = false;

        System.out.println("Answer Id: " + answer1.id);
        System.out.println("Content: " + answer1.content);
        System.out.println("Question: " + answer1.question);
        System.out.println("Is Correct: " + answer1.isCorrect);


        //Exam
        Exam exam1 = new Exam();
        exam1.id = 1;
        exam1.code = "101";
        exam1.title = "exam1";
        exam1.category = categoryQuestion1;
        exam1.duration = 60;
        exam1.creator = account1;
        exam1.createDate = LocalDate.now();

        Exam exam2 = new Exam();
        exam2.id = 2;
        exam2.code = "102";
        exam2.title = "exam2";
        exam2.category = categoryQuestion2;
        exam2.duration = 45;
        exam2.creator = account2;
        exam2.createDate = LocalDate.now();

        Exam exam3 = new Exam();
        exam3.id = 3;
        exam3.code = "103";
        exam3.title = "exam3";
        exam3.category = categoryQuestion3;
        exam3.duration = 15;
        exam3.creator = account3;
        exam3.createDate = LocalDate.now();

        System.out.println("Exam Id: " + exam1.id);
        System.out.println("Code: " + exam1.code);
        System.out.println("Title: " + exam1.title);
        System.out.println("Category: " + exam1.category);
        System.out.println("Duration: " + exam1.duration);
        System.out.println("Creator: " + exam1.creator);
        System.out.println("Create Date: " + exam1.createDate);

        Exam[] exams = {exam1,exam2,exam3};

        //ExamQuestion
        ExamQuestion examQuestion1 = new ExamQuestion();
        examQuestion1.id = 1;
        examQuestion1.question = question1;

        ExamQuestion examQuestion2 = new ExamQuestion();
        examQuestion2.id = 2;
        examQuestion1.question = question2;

        ExamQuestion examQuestion3 = new ExamQuestion();
        examQuestion3.id = 3;
        examQuestion1.question = question3;

        System.out.println("Exam Question Id: " + examQuestion1.id);
        System.out.println("Question: " + question1);


        // 	Question 1:
//        Exercise1.question1(account2);

        System.out.println("====Question 1: ====");
        if (account2.department == null) {
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là " + account2.department.departmentName);
        }

//        //Question 2:Kiểm tra account thứ 2
//Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
//Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
//Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
//Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group"
        System.out.println("====Question 2=====");
        // dùng for để duyệt qua array groupAccounts để đếm xem account này tham gia bao nhiêu nhóm
        int count = 0;
        for (GroupAccount ga: groupAccounts) {
            if (ga.account.id == account2.id){
                count++;
            }
        }
            if (count == 0){
                System.out.println("Nhân viên này chưa có group");
            } else if (count == 1 || count == 2) {
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
            } else if (count == 3) {
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
            }else {
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
            }
        //Question 3: Sử dụng toán tử ternary để làm Question 1
        System.out.println("====Question 3: ====");
        System.out.println(account2.department == null ? "Nhân viên này chưa có phòng ban" : "Phòng ban của " +
                "nhân viên này là " + account2.department.departmentName);

        //Question 4: Sử dụng toán tử ternary để làm yêu cầu sau: Kiểm tra Position của account thứ 1
        //Nếu Position = Dev thì in ra text "Đây là Developer" Nếu không phải thì in ra text "Người này không phải là Developer"
        System.out.println("====Question 4: ====");
        System.out.println(account1.position != null && account1.position.positionName == PositionName.DEV ? "Đây là Developer" :
                "Người này không phải là Developer");
                // để là dev thì phải có chức vụ trước(tối thiểu) + chức vụ = dev

        //Question 5:
        //Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
        //Nếu =0 thì in ra nhm chưa có thành viên nào
        //Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
        //Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
        //Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
        //Còn lại in ra "Nhóm có nhiều thành viên"
        System.out.println("====Question 4: ====");
        int count1 = 0;
        for (GroupAccount ga: groupAccounts) {
            if (ga.group.id == group1.id){
                count1++;
            }
        }

        if (count1 == 0){
            System.out.println("nhóm chưa có thành viên nào");
        } else if (count1 == 1) {
            System.out.println("Nhóm có một thành viên");
        } else if (count1 == 2) {
            System.out.println("Nhóm có hai thành viên");
        } else if (count1 == 3) {
            System.out.println("Nhóm có ba thành viên");
        }else{
            System.out.println("Nhóm có nhiều thành viên");
        }


        //Question 6:
        //Sử dụng switch case để làm lại Question 2
        System.out.println("====Question 6: ====");
        int count2 = 0;
        for (GroupAccount ga: groupAccounts) {
            if (ga.account.id == account2.id){
                count2++;
            }
        }
        switch (count2) {
            case 0:
                System.out.println("Nhân viên này chưa có group");
                break;
            case 1:
            case 2:
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default:
        }

        //Question 7:
        //Sử dụng switch case để làm lại Question 4
        System.out.println("====Question 7: ====");
        if (account1.position == null){
            System.out.println("Người này không phải Developer");
        } else {
            PositionName poName = account1.position.positionName;
            switch (poName) {
                case DEV:
                    System.out.println("Đây là Developer");
                    break;
                default:
                    System.out.println("Đây không phải Developer");
                    break;
            }
        }


        //FOREACH
        //Question 8: In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
        System.out.println("====Question 8: ====");
        for (Account account :accounts){
            System.out.println("ID: " + account.id);
            System.out.println("UserName: " + account.userName);
            System.out.println("FullName: " + account.fullName);
            System.out.println("Email: " + account.email);
            System.out.println("DepartmentName: " + (account.department != null ? account.department.departmentName : "không có"));
            System.out.println("PostionName: " + (account.position != null ? account.position.positionName : "không có"));
        }

        //Question 9:
        //In ra thông tin các phòng ban bao gồm: id và name
        System.out.println("====Question 9: ====");
        for (Position position:positions){
            System.out.println("ID: " + position.id);
            System.out.println("PositionName " + position.positionName);
        }



        /*Question 10:
        In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
        Thông tin account thứ 1 là:
        Email: NguyenVanA@gmail.com
        Full name: Nguyễn Văn A
        Phòng ban: Sale

        Thông tin account thứ 2 là:
        Email: NguyenVanB@gmail.com
        Full name: Nguyễn Văn B
        Phòng ban: Marketting*/

        for (int i = 0; i < accounts.length; i++){
            System.out.println("Thông tin account thứ " + (i+1)+ "là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department);
        }


       /* Question 11:
        In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
        Thông tin department thứ 1 là:
        Id: 1
        Name: Sale
        Thông tin department thứ 2 là:
        Id: 2
        Name: Marketing*/

        for (int i = 0; i < departments.length; i++){
            System.out.println("Thông tin department thứ" + (i + 1) + "là: ");
            System.out.println("ID: " + departments[i].id);
            System.out.println("Name: " + departments[i].departmentName);
        }


        // Question 12:Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
        // tạo mảng department
        for (int i = 0; i < departments.length; i++) {
            if (i < 2){
                System.out.println("Department ID: " + departments[i].id + "Department Name: " + departments[i].departmentName);
            }
        }

        //In ra thông tin tất cả các department ngoại trừ account thứ 2
        for (int i = 0; i < departments.length; i++) {
            if (i != 1){
                System.out.println("Department ID: " + departments[i].id + "Department Name: " + departments[i].departmentName);
            }
        }

        //Question 14:
        //In ra thông tin tất cả các account có id < 2
        System.out.println("====Question 14: ====");
        for (Account account :accounts) {
            if (account.id < 2) {
                System.out.println("ID: " + account.id);
                System.out.println("UserName: " + account.userName);
                System.out.println("FullName: " + account.fullName);
                System.out.println("Email: " + account.email);
                System.out.println("DepartmentName: " + (account.department != null ? account.department.departmentName : "không có"));
                System.out.println("PostionName: " + (account.position != null ? account.position.positionName : "không có"));

            }
        }


        //Question 15:
        //In ra các số chẵn nhỏ hơn hoặc bằng 20
        for (int i = 0; i <= 20 ; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }

        //Question 16: Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break, continue
        System.out.println("====Question 16 ====");
        int i = 0;
        while (i < accounts.length){
            System.out.println("Thông tin account thứ " + (i+1)+ "là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department);
            i++;
        }


       // Question 17
        System.out.println("====Question 17 ====");
        int o = 0;
        while (o < departments.length){
            System.out.println("Thông tin department thứ" + (i + 1) + "là: ");
            System.out.println("ID: " + departments[o].id);
            System.out.println("Name: " + departments[o].departmentName);
            o++;
        }
        //excercise 2
        //Question 1:  Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó
        System.out.println("====Question 1: =====");
        int q = 5;
        System.out.printf("%d\n", q);

        //Question 2:
        //Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để
        // in ra số nguyên đó thành định dạng như sau: 100,000,000
        System.out.println("====Question 2: =====");
        int w = 100000000;
        System.out.printf("%,d\n", w);

        //Question 3:
        //Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số thực đó chỉ bao gồm 4 số đằng sau

        System.out.println("====Question 3: =====");
        double e = 5.567098;
        System.out.printf("%.4f\n",e);

       /* Question 4:
        Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định dạng như sau:
        Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
        Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.*/
        System.out.println("====Question 4: =====");
        String hoVaTen = "Nguyễn Văn A";
        System.out.println("Tên tôi là \"" + hoVaTen + "\" và tôi đang độc thân.");

        //Question 5:
        //Lấy thời gian bây giờ và in ra theo định dạng sau:
        //24/04/2020 11h:16p:20s
        System.out.println("====Question 5: =====");
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH'h':mm'm':ss's'");

        System.out.println(now.format(formatter));

        //Question 6
        System.out.println("====Question 6: =====");
                System.out.println("+-----+--------------------");
        System.out.printf("|%5S|%20S|\n", "ID", "DepartmentName");
        System.out.println("+-----+--------------------");
        for (Department department: departments){
        System.out.printf("|%5S|%20S|\n", "department.id", "department.departmentName");
         }
                System.out.println("+-----+--------------------");

    //Exercise 3
         //Question 1:In ra thông tin Exam thứ 1 và property create date sẽ được format theo định dạng vietnamese
        System.out.println("Exam Id: " + exam1.id);
        System.out.println("Code: " + exam1.code);
        System.out.println("Title: " + exam1.title);
        System.out.println("Category: " + exam1.category);
        System.out.println("Duration: " + exam1.duration);
        System.out.println("Creator: " + exam1.creator);
        Locale locale = new Locale("vi","VI");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        String date = dateFormat.format(new Date());
        System.out.println(date);

        //Question 2:In ra thông tin: Exam đã tạo ngày nào theo định dạng
        //Năm – tháng – ngày – giờ – phút – giây
        for (int j = 0; j < exams.length; j++) {
            System.out.println("Exam Id: " + exam1.id);
            System.out.println("Code: " + exam1.code);
            System.out.println("Title: " + exam1.title);
            System.out.println("Category: " + exam1.category);
            System.out.println("Duration: " + exam1.duration);
            System.out.println("Creator: " + exam1.creator);
            String pattern = "yyyy-MM-dd HH-mm-ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date1 = simpleDateFormat.format(new Date());
            System.out.println(date1);
        }

        //Question 3:Chỉ in ra năm của create date property trong Question 2
        for (int j = 0; j < exams.length; j++) {
            String pattern = "yyyy-MM-dd HH-mm-ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date2 = simpleDateFormat.format(new Date());
            System.out.println(date2);
        }

        //Question 4
        for (int j = 0; j < exams.length; j++) {
            System.out.println("Exam Id: " + exam1.id);
            System.out.println("Code: " + exam1.code);
            System.out.println("Title: " + exam1.title);
            System.out.println("Category: " + exam1.category);
            System.out.println("Duration: " + exam1.duration);
            System.out.println("Creator: " + exam1.creator);
            String pattern = "MM-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date3 = simpleDateFormat.format(new Date());
            System.out.println(date3);
        }

        //Question 5:
        for (int j = 0; j < exams.length; j++) {
            System.out.println("Exam Id: " + exam1.id);
            System.out.println("Code: " + exam1.code);
            System.out.println("Title: " + exam1.title);
            System.out.println("Category: " + exam1.category);
            System.out.println("Duration: " + exam1.duration);
            System.out.println("Creator: " + exam1.creator);
            String pattern = "MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date4 = simpleDateFormat.format(new Date());
            System.out.println(date4);
        }

    //Exercise 4:
        //Question 1:
        Random rand = new Random();
        int h = rand.nextInt();
        System.out.println(h);

        //Question 2:
        //In ngẫu nhiên ra 1 số thực
        double number = Math.random();
        System.out.println(number);

        //Question 3:  Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn
        String[] students = {"Nguyen Van A", "Hoang Minh Duc", "Dang Quang B"};
        int randomStudentsName = (int) (Math.random() * students.length);

        System.out.println("Tên bạn là: " + students[randomStudentsName]);

        //Question 4:
        //Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-121995

        LocalDate startDate = LocalDate.of(1995, 7, 24);
        LocalDate endDate = LocalDate.of(1995, 12, 20);

        long randomDay = (long) (Math.random() *
                (endDate.toEpochDay() - startDate.toEpochDay() + 1));

        LocalDate randomDate = startDate.plusDays(randomDay);

        System.out.println("Ngày ngẫu nhiên: " + randomDate);

        //Question 5:
        //Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây

        //Question 6:
        //Lấy ngẫu nhiên 1 ngày trong quá khứ

       // Question 7:
        //Lấy ngẫu nhiên 1 số có 3 chữ số

        int j = rand.nextInt(100,1000);
        System.out.println(j);

    //Exercise5
        //Question 1:
        //Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
        Scanner sc = new Scanner(System.in);
        System.out.println(" Số thứ 1 là : " );
        int number1 = sc.nextInt();
        System.out.println(" Số thứ 2 là : " );
        int number2 = sc.nextInt();
        System.out.println(" Số thứ 3 là : " );
        int number3 = sc.nextInt();

        System.out.println("3 số bạn vừa nhập là: " + number1 +"," + number2 + "," + number3);

        //Question 2:
        //Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
        System.out.print("Nhập số thực thứ 1: ");
        double so1 = sc.nextDouble();

        System.out.print("Nhập số thực thứ 2: ");
        double so2 = sc.nextDouble();

        System.out.println("2 số vừa nhập là: "
                + so1 + ", " + so2);

        //Question 3:
        //Viết lệnh cho phép người dùng nhập họ và tên
        System.out.println("Họ và Tên:");
        String name = sc.nextLine();

        System.out.println("Tên của bạn là:" + name);

//        Question 4:
//        Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
        System.out.print("Nhập ngày sinh nhật (yyyy-MM-dd): ");
        LocalDate birthday = LocalDate.parse(sc.nextLine());

        System.out.println("Ngày sinh của bạn là: " + birthday);

        //Question 5:
        //Viết lệnh cho phép người dùng tạo account (viết thành method) Đối với property Position,
        // Người dùng nhập vào 1 2 3 4 5 và vào chương trình sẽ chuyển thành Position.Dev, Position.Test,
        // Position.ScrumMaster, Position.PM


    }
}

