package backend;

import entity.Account;
import entity.Department;
import entity.Position;
import entity.PositionName;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QL implements IQL {
    @Override
    public void hienThiToanBoAccount() {
        List<Account> accounts = new ArrayList<>();

        try {
            String url = "jdbc:mysql://localhost:3306/btvn_8";
            String username = "root";
            String password = "root";

            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * \n" +
                    "FROM account acc\n" +
                    "join department dep on acc.department_id = dep.department_id\n" +
                    "join position pos on acc.position_id = pos.position_id";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);// resultSet giống nh 1 table kêt qua của câu sql tren

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("username");
                String fullName = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                int positionId = resultSet.getInt("position_id");
                String positionNameString = resultSet.getString("position_name");
                PositionName positionName = PositionName.valueOf(positionNameString);
                int departmentId = resultSet.getInt("department_id");
                String departmentName = resultSet.getString("department_name");
                Department department = new Department(departmentId, departmentName);
                Position position = new Position(positionId, positionName);

                accounts.add(new Account(id, position, department, fullName, email, userName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hiển thị toàn bộ account");
        System.out.println("+---+---------------+--------------------+-------------------------+-------------------------+------------------------------+");
        System.out.printf("|%3s|%15s|%20s|%25s|%25s|%30s|\n", "id", "username", "full_name", "email", "pos_id", "dep_id");
        System.out.println("+---+---------------+--------------------+-------------------------+-------------------------+------------------------------+");
        for (Account acc: accounts){
            System.out.printf("|%3s|%15s|%20s|%25s|%25s|%30s|\n", acc.getId(), acc.getUserName(), acc.getFullName(), acc.getEmail(), acc.getPosition(), acc.getDepartment());
        }
        System.out.println("+---+---------------+--------------------+-------------------------+-------------------------+------------------------------+");
    }

    @Override
    public void timKiemAccountTheoUsername() {
        System.out.println("==== TÌM ACCOUNT ==== ");
        System.out.println("==== NHẬP USERNAME ==== ");
        String name = new Scanner(System.in).nextLine();
        List<Account> accounts = new ArrayList<>();



        try {
            String url = "jdbc:mysql://localhost:3306/btvn_8";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "Select *\n" +
                    "FROM account acc\n" +
                    "join department dep on acc.department_id = dep.department_id\n" +
                    "join position pos on acc.position_id = pos.position_id\n" +
                    "WHERE username Like ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,"%" + name + "%");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("username");
                String fullName = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                int positionId = resultSet.getInt("position_id");
                String positionNameString = resultSet.getString("position_name");
                PositionName positionName = PositionName.valueOf(positionNameString);
                int departmentId = resultSet.getInt("department_id");
                String departmentName = resultSet.getString("department_name");
                Department department = new Department(departmentId, departmentName);
                Position position = new Position(positionId, positionName);

                accounts.add(new Account(id, position, department, fullName, email, userName));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hiển thị toàn bộ account");
        System.out.println("+---+---------------+--------------------+-------------------------+-------------------------+------------------------------+");
        System.out.printf("|%3s|%15s|%20s|%25s|%25s|%30s|\n", "id", "username", "full_name", "email", "pos_id", "dep_id");
        System.out.println("+---+---------------+--------------------+-------------------------+-------------------------+------------------------------+");
        for (Account acc: accounts){
            System.out.printf("|%3s|%15s|%20s|%25s|%25s|%30s|\n", acc.getId(), acc.getUserName(), acc.getFullName(), acc.getEmail(), acc.getPosition(), acc.getDepartment());
        }
        System.out.println("+---+---------------+--------------------+-------------------------+-------------------------+------------------------------+");
    }

    @Override
    public void hienThiDepartment() {
        List<Department> departments = new ArrayList<>();


        //Tạo kết nối đến database
        try {
            String url = "jdbc:mysql://localhost:3306/btvn_8";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM department";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
            int id = resultSet.getInt("department_id");
            String name = resultSet.getString("department_name");
            departments.add(new Department(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hiển Thị Department");
        System.out.println("+----------+------------------------------");
        System.out.printf("|%10s|%30s|\n", "id", "department_name");
        System.out.println("+----------+------------------------------");
        for (Department dep: departments){
            System.out.printf("|%10s|%30s|\n", dep.getId(), dep.getName());
        }
        System.out.println("+----------+------------------------------");
    }

    @Override
    public void timKiemDepartmentTheoTen() {
        System.out.println("==== TÌM DEPARTMENT ==== ");
        System.out.println("==== NHẬP DEPARTMENT NAME ==== ");
        String name = new Scanner(System.in).nextLine();
        List<Department> departments = new ArrayList<>();

        //Tạo kết nối đến database
        try {
            String url = "jdbc:mysql://localhost:3306/btvn_8";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * from department WHERE department_name like ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("department_id");
                String departmentName = resultSet.getString("department_name");
                departments.add(new Department(id, departmentName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hiển Thị Department");
        System.out.println("+----------+------------------------------");
        System.out.printf("|%10s|%30s|\n", "id", "department_name");
        System.out.println("+----------+------------------------------");
        for (Department dep: departments){
            System.out.printf("|%10s|%30s|\n", dep.getId(), dep.getName());
        }
        System.out.println("+----------+------------------------------");
    }
}
