package frontend;

import backend.IQLAccount;
import backend.IQLDepartment;
import backend.QLAccount;
import backend.QLDepartment;
import backend.controller.QLAccountController;
import backend.controller.QLDepartmentController;
import entity.Account;
import entity.Department;
import entity.Position;

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
        String userName;
        while (true){
            userName = sc.nextLine();
            if (userName.length() < 5 || userName.length() > 50){
                System.err.println("Username phải có độ dài từ 5 đến 50 ký tự");
                continue;
            }

            boolean check = qlAccountController.deleteIfExits(userName);
            if (check){
                System.err.println("Username đã tồn tại");
                continue;
            }
            break;
        }

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
        String userName ;
        while (true){
            userName = sc.nextLine();
            if (userName.length() < 5 || userName.length() > 50){
                System.err.println("Username phải có độ dài từ 5 đến 50 ký tự");
                continue;
            }

            boolean check = qlAccountController.exitsByUserName(userName);
            if (check){
                System.err.println("Username đã tồn tại");
                continue;
            }
            break;
        }
        System.out.println("Nhập fullname cần đổi");
        String fullName;
        while (true){
            fullName = sc.nextLine();
            if (fullName.length() < 5 || fullName.length() > 50){
                System.err.println("Fullname phải có độ dài từ 5 đến 50 ký tự");
                continue;
            }
            break;
        }


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

    //them moi
    public void themMoiAccount(){
        System.out.println("=== THÊM MỚI ACCOUNT ===");
        System.out.println("Nhập username");
        String username ;
        while (true){
            username = sc.nextLine();
            if (username.length() < 5 || username.length() > 50){
                System.err.println("Username phải có độ dài từ 5 đến 50 ký tự");
                continue;
            }

            boolean check = qlAccountController.exitsByUserName(username);
            if (check){
                System.err.println("Username đã tồn tại");
                continue;
            }
            break;
        }
        System.out.println("Nhập fullname");
        String fullName ;
            while (true){
                fullName = sc.nextLine();
                if (fullName.length() < 5 || fullName.length() > 50){
                    System.err.println("Fullname phải có độ dài từ 5 đến 50 ký tự");
                    continue;
                }
                break;
            }
        System.out.println("Nhập email");
        String email;
        while (true){
            email = sc.nextLine();
            // biểu thức chính quy       "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$"// fo+mat của email
            if (email.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")) {
                System.out.println("đúng định dạng");
            } else {
                System.out.println("sai định dạng");
                continue;
            }
            if (username.length() < 5 || username.length() > 50){
                System.err.println("Username phải có độ dài từ 5 đến 50 ký tự");
                continue;
            }
            boolean check = qlAccountController.exitsByEmail(email);
            if (check){
                System.err.println("Email đã tồn tại");
                continue;
            }
            break;
        }
        int depId ;
        int posId;
        Account account = null;
        List<Position> positions = qlAccountController.getAllPosition();
        Position position = null;
        while (true){
            System.out.println("Nhập position id");
            System.out.println("+-----+--------------------+");
            System.out.printf("|%5s|%20s|\n","ID","Name");
            System.out.println("+-----+--------------------+");
            for (Position pos: positions){
                System.out.printf("|%5s|%20s|\n", pos.getId(), pos.getName());
            }
            System.out.println("+-----+--------------------+");
            posId = sc.nextInt();
            sc.nextLine();
            boolean check = false;
            for (Position pos: positions){
                if (pos.getId() == posId){
                    position = pos;
                    check = true;
                    break;
                }
            }
            if (check ){
                break;
            }else {
                System.out.println("ID chức vụ chưa đúng, nhập lại!!");
            }
        }

        List<Department> departments = qlAccountController.getallDepartment();
        Department department = null;
        while (true){
            System.out.println("Nhập department id");
            System.out.println("+-----+--------------------+");
            System.out.printf("|%5s|%20s|\n","ID","Name");
            System.out.println("+-----+--------------------+");
            for (Department dep : departments){
                System.out.printf("|%5s|%20s|\n", dep.getId(), dep.getName());
            }
            System.out.println("+-----+--------------------+");
            depId = sc.nextInt();
            sc.nextLine();
            boolean check = false;
            for (Department dep: departments){
                if (dep.getId() == depId){
                    department = dep;
                    check = true;
                    break;
                }
            }
            if (check )  {
                break;
            }else {
                System.out.println("ID chưa đúng, nhập lại!!");
            }
        }

        account = new Account(position, department, fullName, email, username);

        boolean check = qlAccountController.themMoiAccount(account);
        if (check){
            System.out.println("Thêm mới thành công");
        }else {
            System.out.println("Thêm mới thất bại");
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
                    this.themMoiAccount();
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
                    System.out.println("THOÁT.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("NHẬP SAI MỜI NHẬP LẠI ");
            }
        }
    }
}
