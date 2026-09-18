import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exercise2 {
    public static void question1 () {
        System.out.println("====Question 1: =====");
        int q = 5;
        System.out.printf("%d\n", q);
    }

        public static void question2 (){
        int w = 100000000;
        System.out.printf("%,d\n", w);
    }

    public static void question3 (){
        System.out.println("====Question 3: =====");
        double e = 5.567098;
        System.out.printf("%.4f\n",e);
    }

    public static void question4 (){
        System.out.println("====Question 4: =====");
        String hoVaTen = "Nguyễn Văn A";
        System.out.println("Tên tôi là \"" + hoVaTen + "\" và tôi đang độc thân.");
    }

    public static void question5 (){
        System.out.println("====Question 5: =====");
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH'h':mm'm':ss's'");

        System.out.println(now.format(formatter));
    }

    public static void question6 (Department[] departments){
        System.out.println("====Question 6: =====");
        System.out.println("+-----+--------------------+");
        System.out.printf("|%5S|%20S|\n", "ID", "DepartmentName");
        System.out.println("+-----+--------------------+");
        for (Department department: departments){
            System.out.printf("|%5S|%20S|\n", "department.id", "department.departmentName");
        }
        System.out.println("+-----+--------------------+");
    }

    }
