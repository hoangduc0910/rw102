package frontend;

import backend.IQL;
import backend.QL;

import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner sc = new Scanner(System.in);
        IQL iql = new QL();
        while (true){
            System.out.println("==== VUI LÒNG CHỌN ====");
            System.out.println("1. Hiển thị toàn bộ account");
            System.out.println("2. Tìm kiếm account theo username");
            System.out.println("3. Hiển thị toàn bộ department");
            System.out.println("4. Tìm kiếm department theo tên");
            System.out.println("5. Thoát");
            String choice = sc.nextLine();
            switch (choice){
                case "1":
                    iql.hienThiToanBoAccount();
                break;
                case "2":
                    iql.timKiemAccountTheoUsername();
                    break;
                case "3":
                    iql.hienThiDepartment();
                    break;
                case "4":
                    iql.timKiemDepartmentTheoTen();
                    break;
                case "5":
                    System.out.println("THOÁT.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("NHẬP SAI MỜI NHẬP LẠI ");
            }
        }
    }
}
