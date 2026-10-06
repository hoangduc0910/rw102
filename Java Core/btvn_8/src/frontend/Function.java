package frontend;

import backend.IQLAccount;
import backend.IQLDepartment;
import backend.QLAccount;
import backend.QLDepartment;
import backend.controller.QLAccountController;
import backend.controller.QLDepartmentController;
import entity.Account;
import entity.Department;

import java.util.List;
import java.util.Scanner;

public class Function {
    private QLAccountController qlAccountController;
    private QLDepartmentController qlDepartmentController;
    private Scanner sc;

    public Function() {
        this.qlAccountController = new QLAccountController();
        this.qlDepartmentController = new QLDepartmentController();
        this.sc = new Scanner(System.in);
    }
    public void hienThiToanBoAccount(){
        //yêu cầu controller trả ra 1 danh sách account
        List<Account> accounts = qlAccountController.findAll();

        System.out.println("Hiển thị toàn bộ account");
        System.out.println("+---+---------------+--------------------+-------------------------+-------------------------+------------------------------+");
        System.out.printf("|%3s|%15s|%20s|%25s|%25s|%30s|\n", "id", "username", "full_name", "email", "pos_id", "dep_id");
        System.out.println("+---+---------------+--------------------+-------------------------+-------------------------+------------------------------+");
        for (Account acc: accounts){
            System.out.printf("|%3s|%15s|%20s|%25s|%25s|%30s|\n", acc.getId(), acc.getUserName(), acc.getFullName(), acc.getEmail(), acc.getPosition(), acc.getDepartment());
        }
        System.out.println("+---+---------------+--------------------+-------------------------+-------------------------+------------------------------+");
    }


        public void hienThiToanBoDepartment(){
            List<Department> departments = qlDepartmentController.findAll();

            System.out.println("Hiển Thị Department");
            System.out.println("+----------+------------------------------");
            System.out.printf("|%10s|%30s|\n", "id", "department_name");
            System.out.println("+----------+------------------------------");
            for (Department dep: departments){
                System.out.printf("|%10s|%30s|\n", dep.getId(), dep.getName());
            }
            System.out.println("+----------+------------------------------");

        }


    //tim kiem
    public void timKiemAccount(){
        System.out.println("==== TÌM ACCOUNT ==== ");
        System.out.println("==== NHẬP USERNAME ==== ");
        String name = sc.nextLine();
        List<Account> accounts = qlAccountController.findByUserName(name);

        if (accounts.isEmpty()){
            System.out.println("Không tìm thấy account tương ứng");
        }else {
            System.out.println("Hiển account cần tìm");
            System.out.println("+---+---------------+--------------------+-------------------------+-------------------------+------------------------------+");
            System.out.printf("|%3s|%15s|%20s|%25s|%25s|%30s|\n", "id", "username", "full_name", "email", "pos_id", "dep_id");
            System.out.println("+---+---------------+--------------------+-------------------------+-------------------------+------------------------------+");
            for (Account acc: accounts){
                System.out.printf("|%3s|%15s|%20s|%25s|%25s|%30s|\n", acc.getId(), acc.getUserName(), acc.getFullName(), acc.getEmail(), acc.getPosition(), acc.getDepartment());
            }
            System.out.println("+---+---------------+--------------------+-------------------------+-------------------------+------------------------------+");
        }

    }


    public void timKiemDepartment(){
        System.out.println("==== TÌM DEPARTMENT ==== ");
        System.out.println("==== NHẬP DEPARTMENT NAME ==== ");
        String name = sc.nextLine();
        List<Department> departments = qlDepartmentController.findByDepartmentName(name);

        if (departments.isEmpty()){
            System.out.println("Không tìm thấy department tương ứng");
        }else {
            System.out.println("Hiển Thị Department");
            System.out.println("+----------+------------------------------");
            System.out.printf("|%10s|%30s|\n", "id", "department_name");
            System.out.println("+----------+------------------------------");
            for (Department dep: departments){
                System.out.printf("|%10s|%30s|\n", dep.getId(), dep.getName());
            }
            System.out.println("+----------+------------------------------");
        }
    }


    //xoa
    public void deleteAccountByName(){
        System.out.println("=== Xóa account theo username ===");
        System.out.println("Nhập username");
        String userName =sc.nextLine();
        boolean check = qlAccountController.deleteAccountByName(userName);
        if (check){
            System.out.println("Xóa account thành công");
        }else {
            System.out.println("Xóa account thất bại");
        }
    }

    public void deleteDepartmentByName(){
        System.out.println("=== Xóa department theo tên ===");
        System.out.println("Nhập tên department");
        String name =sc.nextLine();
        boolean check = qlDepartmentController.deleteDepartmentByName(name);
        if (check){
            System.out.println("Xóa department thành công");
        }else {
            System.out.println("Xóa department thất bại");
        }
    }

    //update
    public void updateFullNameTheoUsermane(){
        System.out.println("Update fullname theo username");
        System.out.println("Nhập username");
        String userName =sc.nextLine();
        System.out.println("Nhập fullname cần đổi");
        String fullName =sc.nextLine();

        boolean check = qlAccountController.updateFullNameByUsername(userName, fullName);

        if (check){
            System.out.println("Cập nhật fullname thành công");
        }else {
            System.out.println("Cập nhật fullname thất bại");
        }
    }

    public void updateDepartmentNameTheoId(){
        System.out.println("Update tên department theo id");
        System.out.println("Nhập id");
        int department_id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập department_name cần đổi");
        String name =sc.nextLine();

        boolean check = qlDepartmentController.updateDepById(department_id, name);
        if (check){
            System.out.println("Cập nhật department thành công");
        }else {
            System.out.println("Cập nhật department thất bại");
        }
    }

    public void menu(){
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("==== VUI LÒNG CHỌN ====");
            System.out.println("1. Hiển thị toàn bộ account");
            System.out.println("2. Tìm kiếm account theo username");
            System.out.println("3. Hiển thị toàn bộ department");
            System.out.println("4. Tìm kiếm department theo tên");
            System.out.println("5. Thêm mới account");
            System.out.println("6. Thêm mới department");
            System.out.println("7. Xóa account theo username");
            System.out.println("8. Xóa department theo tên");
            System.out.println("9. Cập nhật full name theo username");
            System.out.println("10. Cập nhật tên department theo id");
            System.out.println("11 Thoát");
            String choice = sc.nextLine();
            switch (choice){
                case "1":
                    this.hienThiToanBoAccount();
//                    iql1.hienThiToanBoAccount();
                    break;
                case "2":
                    this.timKiemAccount();
//                    iql1.timKiemAccountTheoUsername();
                    break;
                case "3":
//                    iql2.hienThiDepartment();
                    this.hienThiToanBoDepartment();
                    break;
                case "4":
                    this.timKiemDepartment();
//                    iql2.timKiemDepartmentTheoTen();
                    break;
                case "5":
//                    iql1.themMoiAccount();
                    break;
                case "6":
//                    iql2.themMoiDepartment();
                    break;
                case "7":
                    this.deleteAccountByName();
//                    iql1.xoaAccountTheousUsername();
                    break;
                case "8":
                    this.deleteDepartmentByName();
//                    iql2.xoaDepartmentTheoTen();
                    break;
                case "9":
                    this.updateFullNameTheoUsermane();
//                    iql1.capNhatfullnameTheousUsername();
                    break;
                case "10":
                    this.updateDepartmentNameTheoId();
//                    iql2.capNhatDepartmentTheoid();
                    break;
                case "11":
//                    System.out.println("THOÁT.");
//                    System.exit(0);
                    break;
                default:
                    System.out.println("NHẬP SAI MỜI NHẬP LẠI ");
            }
        }
    }
}
