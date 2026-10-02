package entity;

public class Account {
    private int id;
    private String userName;
    private String fullName;
    private String email;
    private Department department;
    private Position position;

    public Account() {
    }

    public Account(int id, Position position, Department department, String fullName, String email, String userName) {
        this.id = id;
        this.position = position;
        this.department = department;
        this.fullName = fullName;
        this.email = email;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
