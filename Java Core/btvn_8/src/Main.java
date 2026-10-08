import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Nhập email: ");
            while (true) {
                String email = sc.nextLine();
                // biểu thức chính quy       "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$"// fo+mat của email
                if (email.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")) {
                    System.out.println("đúng định dạng");
                } else {
                    System.out.println("sai định dạng");
                }
            }

        }

}