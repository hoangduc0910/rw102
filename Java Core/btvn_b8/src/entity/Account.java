package entity;

import javax.swing.text.Position;

public class Account {
    private int id;
    private String username;
    private String fullName;
    private String email;
    private Department department;
    private  Position position;

    public Account() {
    }

    public Account(int id, Position position, Department department, String email, String username, String fullName) {
        this.id = id;
        this.position = position;
        this.department = department;
        this.email = email;
        this.username = username;
        this.fullName = fullName;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
