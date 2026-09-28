package frontend;

import backend.IQLTV;
import backend.QLTV;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        menu();
    }


    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        IQLTV iqltv = new QLTV();
        while (true) {
            System.out.println("=== CHỌN CHỨC NĂNG ===");
            System.out.println("=== 1. THÊM MỚI TÀI LIỆU  ===");
            System.out.println("=== 2. XÓA TÀI LIỆU THEO MÃ ===");
            System.out.println("=== 3. HIỂN THỊ THÔNG TIN ===");
            System.out.println("=== 4. TÌM KIẾM  ===");
            System.out.println("=== 5. THOÁT. ===");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    iqltv.hienThiTaiLieu();
                    break;
                case "4":
                    break;
                case "5":
                    System.out.println("THOÁT.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Chọn lại !");
            }
        }
    }
}
