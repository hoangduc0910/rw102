public class Exercise5 {
    //    Question 5:
//    So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau không
//    (bằng nhau khi tên của 2 phòng ban đó bằng nhau)
    public static void question5(Department dep1, Department dep2) {
        if (dep1.departmentName.equals(dep2.departmentName)) {
            System.out.println("2 phòng ban bằng nhau");
        } else {
            System.out.println("2 phòng ban không bằng nhau");
        }
    }

    //    Question 6: sắp xếp theo chữ cái đâ tiên
//    Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh
//    sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
//    VD:
//    Accounting
//    Boss of director
//            Marketing
//    Sale
//    Waiting room
    public static void question6(String[] names) {
        for (int i = 0; i < names.length - 1; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].compareTo(names[j]) > 0) {
                    //đổi chỗ vtri i cho j
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
        for (String s : names) {
            System.out.println(s);
        }
    }


//    Question 7: sắp xếp theo chữ đầu tiên của từ cuối cùng
//    Khởi tạo 1 array học sinh gồm 5 Phòng ban, sau đó in ra dan sách phòng ban được sắp xếp theo tên
//    VD:
//    Accounting
//    Boss of director
//            Marketing
//    waiting room
//    Sale
public static void question7(String[] names) {
    for (int i = 0; i < names.length - 1; i++) {
        for (int j = i + 1; j < names.length; j++) {
            // lấy ra từ cuoi cung trong ten
            String[] arrs1 = names[i].split(" ");
            String[] arrs2 = names[j].split(" ");
            String last1 = arrs1[arrs1.length - 1];
            String last2 = arrs2[arrs2.length - 1];
            if (last1.compareToIgnoreCase(last2) > 0) {
                //đổi chỗ vtri i cho j
                String temp = names[i];
                names[i] = names[j];
                names[j] = temp;
            }
        }
    }
    for (String s : names) {
        System.out.println(s);
    }
}
}
