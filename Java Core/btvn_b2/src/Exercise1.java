import java.text.DateFormat;

public class Exercise1 {
    public static void question1(Account account){
        System.out.println("====Question 1: ====");
        if (account.department == null) {
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là " + account.department.departmentName);
        }
    }

    public static void question2(Account account, GroupAccount[] groupAccounts) {
        int count = 0;
        for (GroupAccount ga : groupAccounts) {
            if (ga.account.id == account.id) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Nhân viên này chưa có group");
        } else if (count == 1 || count == 2) {
            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
        } else if (count == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        } else {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
    }
     public static void question3 (Account account){
         System.out.println(account.department == null ? "Nhân viên này chưa có phòng ban" : "Phòng ban của " +
                 "nhân viên này là " + account.department.departmentName);
     }

    public static void question4 (Account account){
        System.out.println("====Question 4: ====");
        System.out.println(account.position != null && account.position.positionName == PositionName.DEV ? "Đây là Developer" :
                "Người này không phải là Developer");
    }


    public static void question5 (Group group,GroupAccount[] groupAccounts ){

        int count1 = 0;
        for (GroupAccount ga: groupAccounts) {
            if (ga.group.id == group.id){
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
    }

    public static void question6(Account account, GroupAccount[] groupAccounts) {
        int count2 = 0;
        for (GroupAccount ga: groupAccounts) {
            if (ga.account.id == account.id){
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
    }

    public static void question7 (Account account){
        if (account.position == null){
            System.out.println("Người này không phải Developer");
        } else {
            PositionName poName = account.position.positionName;
            switch (poName) {
                case DEV:
                    System.out.println("Đây là Developer");
                    break;
                default:
                    System.out.println("Đây không phải Developer");
                    break;
            }
        }
    }

   public static void question8 (Account[] accounts){
       System.out.println("====Question 8: ====");
       for (Account account :accounts){
           System.out.println("ID: " + account.id);
           System.out.println("UserName: " + account.userName);
           System.out.println("FullName: " + account.fullName);
           System.out.println("Email: " + account.email);
           System.out.println("DepartmentName: " + (account.department != null ? account.department.departmentName : "không có"));
           System.out.println("PostionName: " + (account.position != null ? account.position.positionName : "không có"));
       }
   }

   public static void question9 (Position[] positions){
       for (Position position:positions){
           System.out.println("ID: " + position.id);
           System.out.println("PositionName " + position.positionName);
       }
   }

    public static void question10 (Account[] accounts){
        for (int i = 0; i < accounts.length; i++){
            System.out.println("Thông tin account thứ " + (i+1)+ "là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department);
        }
    }

    public static void question11 (Department[] departments){
        for (int i = 0; i < departments.length; i++){
            System.out.println("Thông tin department thứ" + (i + 1) + "là: ");
            System.out.println("ID: " + departments[i].id);
            System.out.println("Name: " + departments[i].departmentName);
        }
    }

    public static void question12 (Department[] departments){
        for (int i = 0; i < departments.length; i++) {
            if (i < 2){
                System.out.println("Department ID: " + departments[i].id + "Department Name: " + departments[i].departmentName);
            }
        }
    }

    public static void question13 (Department[] departments){
        for (int i = 0; i < departments.length; i++) {
            if (i != 1){
                System.out.println("Department ID: " + departments[i].id + "Department Name: " + departments[i].departmentName);
            }
        }
    }
    public static void question14 (Account[] accounts){
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
    }

    public static void question15 (){
        for (int i = 0; i <= 20 ; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }



    }
