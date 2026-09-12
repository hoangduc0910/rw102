import java.time.LocalDate;

public class Account {
    int id;
    String username;
    String fullName;
    String email;

    //department_id và position_id
    //với khóa ngoại chuyển sang object
    Department department;
    Position position;

    LocalDate createdate;

    public void in(){
        System.out.println("id: " + id);
        System.out.println("Name: " + username);
    }
}
