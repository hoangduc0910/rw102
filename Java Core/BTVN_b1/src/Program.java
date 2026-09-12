import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {
        //department
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
        groupAccount1.id = 1;
        groupAccount1.account = account1;
        groupAccount1.joinDate = LocalDate.now();

        GroupAccount groupAccount2 = new GroupAccount();
        groupAccount2.id = 2;
        groupAccount2.account = account2;
        groupAccount2.joinDate = LocalDate.now();

        GroupAccount groupAccount3 = new GroupAccount();
        groupAccount3.id = 3;
        groupAccount3.account = account3;
        groupAccount3.joinDate = LocalDate.now();

        System.out.println("Group Account Id: +" + groupAccount1.id);
        System.out.println("Account: +" + groupAccount1.account);
        System.out.println("Join Date: +" + groupAccount1.joinDate);


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
        categoryQuestion1.categoryName ="Java";

        CategoryQuestion categoryQuestion2 = new CategoryQuestion();
        categoryQuestion2.id = 2;
        categoryQuestion2.categoryName ="SQL";

        CategoryQuestion categoryQuestion3 = new CategoryQuestion();
        categoryQuestion3.id = 3;
        categoryQuestion3.categoryName ="Postman";

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


        //ExamQuestion
        ExamQuestion examQuestion1 = new ExamQuestion();
        examQuestion1.id = 1;

        ExamQuestion examQuestion2 = new ExamQuestion();
        examQuestion2.id = 2;

        ExamQuestion examQuestion3 = new ExamQuestion();
        examQuestion3.id = 3;

        System.out.println("Exam Question Id: " + examQuestion1.id);

    }
}
