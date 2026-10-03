package frontend;

import backend.IQLAccount;
import backend.IQLDepartment;
import backend.QLAccount;
import backend.QLDepartment;

import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner sc = new Scanner(System.in);
        IQLAccount iql1 = new QLAccount();
        IQLDepartment iql2 = new QLDepartment();
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
                    iql1.hienThiToanBoAccount();
                break;
                case "2":
                    iql1.timKiemAccountTheoUsername();
                    break;
                case "3":
                    iql2.hienThiDepartment();
                    break;
                case "4":
                    iql2.timKiemDepartmentTheoTen();
                    break;
                case "5":
                    iql1.themMoiAccount();
                    break;
                case "6":
                    iql2.themMoiDepartment();
                    break;
                case "7":
                    iql1.xoaAccountTheousUsername();
                    break;
                case "8":
                    iql2.xoaDepartmentTheoTen();
                    break;
                case "9":
                    iql1.capNhatfullnameTheousUsername();
                    break;
                case "10":
                    iql2.capNhatDepartmentTheoid();
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
