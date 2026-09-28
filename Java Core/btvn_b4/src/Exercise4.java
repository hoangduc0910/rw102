import java.util.Locale;
import java.util.Scanner;
//Question 1:
//Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có thể cách nhau bằng nhiều khoảng trắng );

public class Exercise4 {
    private static Scanner scanner = new Scanner(System.in);
    public static void question1(){
        System.out.println("nhập 1 xâu ký tự");
        String s = scanner.nextLine();
        //.trim: bỏ đi khoảng trắng đầu cuối của chuỗi
        String[] arr = s.trim().split("\\s+");//gặp dấu cách sẽ cắt chuỗi
        System.out.println("số từ của chuỗi vừa nhập là: " + arr.length);


    }

//    Question 2:
//    Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
    public static void question2(){
        System.out.println("Nhập xâu kí tự thứ 1");
        String s1,s2;
        while (true){
            s1 = scanner.nextLine();
            if (!s1.isBlank()){
                break;
            }
            System.err.println("Vui lòng nhập lại s1");
        }
        System.out.println("Nhập xâu kí tự thứ 2");
        while (true){
            s2 = scanner.nextLine();
            if (!s2.isBlank()){
                break;
            }
            System.err.println("Vui lòng nhập lại s2");
        }

        //String s3 = s1 + s2;
        String s3 = new StringBuffer().append(s1).append(s2).toString();
        // mutable
        // immutable

        System.out.println("Sau khi nối 2 xâu: " + s1 + s2);
    }


//    Question 3:
//    Viết chương trình để người dùng nhập vào họ và tên và kiểm tra,
//    nếu tên chữ viết hoa chữ cái đầu thì viết hoa lên.
public static void question3(){
    System.out.println("Nhập họ và tên:");
    String hoVaTen = scanner.nextLine();
    while (true){
        hoVaTen = scanner.nextLine();
        if (hoVaTen.isBlank()){
            break;
        }
        System.err.println("vui lòng nhập họ tên");
    }
    String[] arr = hoVaTen.trim().split("\\s+");
    StringBuilder fullName = new StringBuilder();
    for (String s: arr){
        String first = s.substring(0,1).toUpperCase(); // lấy chữ đầu tiên sau đó viết hoa
        String last = s.substring(1).toLowerCase();// lấy các chữ còn lại viết thường
        fullName.append(first).append(last).append(" ");
    }
    System.out.println("tên sau khi nhập là: " + fullName);
    }




//            Question 4:
//    Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên của người dùng ra
//    VD:
//    Người dùng nhập vào "Nam", hệ thống sẽ in ra
//        "Ký tự thứ 1 là: N"
//        "Ký tự thứ 2 là: A"
//        "Ký tự thứ 3 là: M"
    public static void question4(){
        System.out.println("Nhập tên:");
        String hoVaTen = scanner.nextLine();
        while (true){
            hoVaTen = scanner.nextLine();
            if (hoVaTen.isBlank()){
                break;
            }
            System.err.println("vui lòng nhập họ tên");
        }
        for(int i = 0; i < hoVaTen.length(); i++) {
            char c = hoVaTen.charAt(i);
            System.out.printf("Ký tự thứ %d là %s\n ", (i + 1), String.valueOf(c).toUpperCase());
        }
    }




//    Question 5:
//    Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người dùng
//    nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ.
    public static void question5(){

    }




//    Question 6:
//    Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
//    sau đó hệ thống sẽ tách ra họ, tên , tên đệm
//    VD:
//    Người dùng nhập vào "Nguyễn Văn Nam"
//    Hệ thống sẽ in ra
//    "Họ là: Nguyễn"
//            "Tên đệm là: Văn"
//            "Tên là: Nam"
public static void question6(){
    System.out.println("Nhập họ tên:");
    String hoVaTen;
    while (true){
        hoVaTen = scanner.nextLine();
        if (!hoVaTen.isBlank()){
            break;
        }
        System.err.println("vui lòng nhập họ tên");
    }

    String[] arr = hoVaTen.trim().split("\\s+");
    System.out.println("Họ là: " + arr[0]);
    StringBuilder tenDem = new StringBuilder();
    for (int i = 0; i < arr.length - 1; i++) {
        tenDem.append(arr[i]).append(" ");
    }
    System.out.println("Đệm là: " + tenDem);
    System.out.println("Tên là: " + arr[arr.length - 1]);
}




//    Question 7:
//    Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và chuẩn hóa họ và tên của họ như sau:
//    a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập vào
//    VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ chuẩn hóa thành "nguyễn văn   nam"
//    b) Viết hoa chữ cái mỗi từ của người dùng
//    VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ chuẩn hóa thành "Nguyễn Văn Nam"


//    Question 8:
//    In ra tất cả các group có chứa chữ "Java"
    public static void question8(Group[] groups){
        System.out.println("Nhập tên group");
        String name = scanner.nextLine();
        System.out.println("+-----+--------------------+---------------+");
        System.out.printf("|%5s|%20s|%15s|\n", "ID", "Group name", "Created date");
        System.out.println("+-----+--------------------+---------------+");
        for (Group group: groups){
            if (group.groupName.contains(name)){
                System.out.printf("|%5s|%20s|%15s|\n", group.id, group.groupName, group.createDate);
            }
        }
        System.out.println("+-----+--------------------+---------------+");
    }


//    Question 9:
//    In ra tất cả các group "Java"
        //Giống bài 8 nhưng dùng equals
        //System.out.println("Java".equalsIgnoreCase("java")); // equals ko phân biệt hoa thường
        //System.out.println("1 Java 1.".toLowerCase().contains("java".toLowerCase()));// contain ko phân biệt hoa thường

//    Question 10:
//    Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
//    Nếu có xuất ra “OK” ngược lại “KO”.
//    Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.
public static void question10() {
    System.out.println("Nhập xâu kí tự thứ 1");
    String s1, s2;
    while (true) {
        s1 = scanner.nextLine();
        if (!s1.isBlank()) {
            break;
        }
        System.err.println("Vui lòng nhập lại s1");
    }
    System.out.println("Nhập xâu kí tự thứ 2");
    while (true) {
        s2 = scanner.nextLine();
        if (!s2.isBlank()) {
            break;
        }
        System.err.println("Vui lòng nhập lại s2");
    }
    if (s1.trim().length() != s2.trim().length()) {
        System.out.println("s1, s2 không phải l nghịch đảo của nhau");
    } else {
//            int length = s1.length();//độ dài của chuỗi
//            for (int i = 0; i <length; i++) {
//                if (s1.charAt(i) != s2.charAt(length-1-i)){
//                    System.out.println("s1,s2 ko phải nghịch đảo của nhau");
//                    return;
//                }
//            }
//            System.out.println("s1,s2 là nghịch đảo ");
//        }
        StringBuilder a = new StringBuilder(s1);
        if (s2.equals(a.reverse().toString())){
            System.out.println("s1,s2 là nghịch đảo ");
        }else {
            System.out.println("s1,s2 ko phải nghịch đảo của nhau");
        }
    }
}
//    Question 11: Count special Character
//    Tìm số lần xuất hiện ký tự "a" trong chuỗi

    public static void question11() {
        System.out.println("Nhập xâu kí tự thứ 1");
        String s1;
        while (true) {
            s1 = scanner.nextLine();
            if (!s1.isBlank()) {
                break;
            }
            System.err.println("Vui lòng nhập lại s1");
        }
        System.out.println("nhập ký tự mốn đếm");
        String x = scanner.nextLine();

        int count = 0; //đếm số lần xuất hiện
        for (int i = 0; i < s1.length(); i++) {
            if (x.equals(String.valueOf(s1.charAt(i)))){
                count ++;
            }
        }
        System.out.printf("số lần xuất hiện của %s là: %d", x, count);
    }
//    Question 12: Reverse String
//    Đảo ngược chuỗi sử dụng vòng lặp
    //for i chạy từ length-1 về 0 sau đó nối chuỗi

//    Question 13:
//    String not contains digit
//    Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược lại true.
//    Ví dụ:
//            "abc" => true
//            "1abc", "abc1", "123", "a1bc", null => false

    public static void question13() {
        System.out.println("Nhập xâu kí tự thứ 1");
        String s1;
        while (true) {
            s1 = scanner.nextLine();
            if (!s1.isBlank()) {
                break;
            }
            System.err.println("Vui lòng nhập lại s1");
        }

        for (int i = 0; i < s1.length(); i++) {
            if (Character.isDigit(s1.charAt(i))){
                System.out.println("False");
                return;
            }
        }
        System.out.printf("True");
    }



//    Question 14: Replace character
//    Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác cho trước.
//    Ví dụ:
//            "VTI Academy" chuyển ký tự 'e' sang '*' kết quả " VTI Acad*my"

    public static void question14() {
        System.out.println("Nhập xâu kí tự thứ 1");
        String s1;
        while (true) {
            s1 = scanner.nextLine();
            if (!s1.isBlank()) {
                break;
            }
            System.err.println("Vui lòng nhập lại s1");
        }
        System.out.println("chuỗi sau khi thay thế là: " + s1.replace("e", "*"));

    }



//    Question 15: Revert string by word
//    Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà không dùng thư viện.
//    Ví dụ: " I am developer " => "developer am I".
//    Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách.
//    Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt chuỗi theo dấu cách
        // split cắt chuỗi
        // dùng for ngược i=length -1 chạy đến i=0 rồi cộng chuỗi

//    Question 16:
//    Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần bằng nhau với n
//    ký tự. Nếu chuỗi không chia được thì xuất ra màn hình “KO”.
        public static void question16() {
            System.out.println("Nhập xâu kí tự thứ 1");
            String s1;
            while (true) {
                s1 = scanner.nextLine();
                if (!s1.isBlank()) {
                    break;
                }
                System.err.println("Vui lòng nhập lại s1");
            }
            System.out.println("nhập số > 0");
            int n = scanner.nextInt();
            System.out.println(s1.trim().length()%n == 0? "0": "KO");
        }



}
