import java.io.PipedOutputStream;
import java.time.LocalDate;
import java.util.Scanner;

public class Exercise5 {
    public static void question1(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" Số thứ 1 là : " );
        int number1 = sc.nextInt();
        System.out.println(" Số thứ 2 là : " );
        int number2 = sc.nextInt();
        System.out.println(" Số thứ 3 là : " );
        int number3 = sc.nextInt();
    }

    public static void question2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số thực thứ 1: ");
        double so1 = sc.nextDouble();

        System.out.print("Nhập số thực thứ 2: ");
        double so2 = sc.nextDouble();

        System.out.println("2 số vừa nhập là: "
                + so1 + ", " + so2);
    }

    public static void question3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Họ và Tên:");
        String name = sc.nextLine();

        System.out.println("Tên của bạn là:" + name);
    }

    public static void question4(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ngày sinh nhật (yyyy-MM-dd): ");
        LocalDate birthday = LocalDate.parse(sc.nextLine());

        System.out.println("Ngày sinh của bạn là: " + birthday);
    }

    public static void question5(PositionName positionName){
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập email: ");
        String email = sc.nextLine();

        System.out.print("Nhập username: ");
        String userName = sc.nextLine();

        System.out.print("Nhập Fullname: ");
        String fullName = sc.nextLine();

        System.out.print("Nhập Position (1-5): ");
        int position = sc.nextInt();


        switch (position) {
            case 1:
                positionName = PositionName.DEV;
                break;
            case 2:
                positionName = PositionName.TEST;
                break;
            case 3:
                positionName = PositionName.SCRUM_MASTER;
                break;
            case 4:
                positionName = PositionName.PM;
                break;
            default:
                positionName = null;
                System.out.println("Position không hợp lệ!");
        }
        sc.nextLine();
        System.out.println("+---+----------+----------+----------+------");
        System.out.printf("|%3S|%10S|%10S|%10S|%3S|\n", "ID", "Email", "Username","Fullname","departmentname");
        System.out.println("+---+----------+----------+----------+------");
        System.out.printf("|%3S|%10S|%10S|%10S|%3S|\n", "id", "email", "userName","fullName","position");    }

    public static void question6(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ID của bạn là");
        int id = sc.nextInt();
        System.out.println("Tên phòng ban của bạn là: ");
        String name = sc.nextLine();
        System.out.println("+-----+--------------------+");
        System.out.printf("|%5S|%20S|\n", "ID", "DepartmentName");
        System.out.println("+-----+--------------------+");
        System.out.printf("|%5S|%20S|\n", id, name);
        System.out.println("+-----+--------------------+");
    }

    public static void question7(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập một số chẵn: ");
        int number = scanner.nextInt();

        while (number % 2 != 0) {
            System.out.print("Số vừa nhập không phải số chẵn. Nhập lại: ");
            number = scanner.nextInt();
        }

        System.out.println("Số chẵn bạn nhập là: " + number);
    }



    }
