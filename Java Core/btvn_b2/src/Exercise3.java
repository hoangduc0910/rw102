import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Exercise3 {
    public static void question1 (Exam exam){
        System.out.println("Exam Id: " + exam.id);
        System.out.println("Code: " + exam.code);
        System.out.println("Title: " + exam.title);
        System.out.println("Category: " + exam.category);
        System.out.println("Duration: " + exam.duration);
        System.out.println("Creator: " + exam.creator);
        Locale locale = new Locale("vi","VI");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        String date = dateFormat.format(new Date());
        System.out.println(date);
    }

    public static void question2 (Exam exam, Exam[] exams){
        for (int j = 0; j < exams.length; j++) {
            System.out.println("Exam Id: " + exam.id);
            System.out.println("Code: " + exam.code);
            System.out.println("Title: " + exam.title);
            System.out.println("Category: " + exam.category);
            System.out.println("Duration: " + exam.duration);
            System.out.println("Creator: " + exam.creator);
            String pattern = "yyyy-MM-dd HH-mm-ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date1 = simpleDateFormat.format(new Date());
            System.out.println(date1);
        }
    }

    public static void question3 (Exam[] exams){
        for (int j = 0; j < exams.length; j++) {
            String pattern = "yyyy-MM-dd HH-mm-ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date2 = simpleDateFormat.format(new Date());
            System.out.println(date2);
        }
    }

    public static void question4 (Exam exam, Exam[] exams){
        for (int j = 0; j < exams.length; j++) {
            System.out.println("Exam Id: " + exam.id);
            System.out.println("Code: " + exam.code);
            System.out.println("Title: " + exam.title);
            System.out.println("Category: " + exam.category);
            System.out.println("Duration: " + exam.duration);
            System.out.println("Creator: " + exam.creator);
            String pattern = "MM-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date3 = simpleDateFormat.format(new Date());
            System.out.println(date3);
        }
    }

    public static void question5 (Exam exam, Exam[] exams){
//Question 5:
        for (int j = 0; j < exams.length; j++) {
            System.out.println("Exam Id: " + exam.id);
            System.out.println("Code: " + exam.code);
            System.out.println("Title: " + exam.title);
            System.out.println("Category: " + exam.category);
            System.out.println("Duration: " + exam.duration);
            System.out.println("Creator: " + exam.creator);
            String pattern = "MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date4 = simpleDateFormat.format(new Date());
            System.out.println(date4);
        }

    }



    }

