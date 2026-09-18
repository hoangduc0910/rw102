import java.time.LocalDate;
import java.util.Random;

public class Exercise4 {
    public static void question1(){
        Random rand = new Random();
        int h = rand.nextInt();
        System.out.println(h);
    }

    public static void question2(){
        Random rand = new Random();
        double number = Math.random();
        System.out.println(number);
    }

    public static void question3(){
        String[] students = {"Nguyen Van A", "Hoang Minh Duc", "Dang Quang B"};
        int randomStudentsName = (int) (Math.random() * students.length);

        System.out.println("Tên bạn là: " + students[randomStudentsName]);
    }

    public static void question4(){
        LocalDate startDate = LocalDate.of(1995, 7, 24);
        LocalDate endDate = LocalDate.of(1995, 12, 20);

        long randomDay = (long) (Math.random() *
                (endDate.toEpochDay() - startDate.toEpochDay() + 1));

        LocalDate randomDate = startDate.plusDays(randomDay);

        System.out.println("Ngày ngẫu nhiên: " + randomDate);
    }

    public static void question5(){

    }

    public static void question6(){

    }

    public static void question7(){
        Random rand = new Random();
        int j = rand.nextInt(100,1000);
        System.out.println(j);
    }


    }
