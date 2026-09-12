import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!"); //sout


        String fullname = "Hoàng Minh Đức";// varchar, S viết hoa
        char gender = 'M';// chỉ chứa đc 1 ký tự

        int age = 22;//int
        long a = 1;
        short b = 1;
        byte c = 1;
        float point = 7.5f;//float
        double d = 7.5;


        // arrays: khi muốn biểu diễn 1 danh sách chứa các phần tử cùng kiểu dữ liệu
        // ds điểm
        int[] points = new int[] {1,2,3,1,2,1};
        int[] points2 = new int[4];
                points2[0] = 7;
                points2[1] = 8;
                points2[2] = 2;
                points2[3] = 10;

        String[] students = new String[]{"An", "Khánh", "Đức", "1.1"};

        // đúng sai
        boolean check1 = false;
        boolean check2 = true;

        //so sánh
        boolean check3 = (1 > 2);
        System.out.println("check3: " + check3);

        System.out.println("fullname: " + fullname);
        System.out.println("age: " + age);
        System.out.println("Point: " + point);

        //số nguyên
            //byte -128_127
            //short_32,736_32,767
            //int
            //long
    }
}