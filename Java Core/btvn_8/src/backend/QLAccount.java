package backend;

import entity.Account;
import entity.Department;
import entity.Position;
import entity.PositionName;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLAccount implements IQLAccount {
    Scanner sc = new Scanner(System.in);

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
                    "left join department dep on acc.department_id = dep.department_id\n" +
                    "left join position pos on acc.position_id = pos.position_id\n" +
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
    public void themMoiAccount() {
        System.out.println("=== Thêm mới account ===");
        System.out.println("Nhập username");
        String userName = new Scanner(System.in).nextLine();
        System.out.println("Nhập fullname");
        String fullName = sc.nextLine();
        System.out.println("Nhập email");
        String email = sc.nextLine();
        System.out.println("Nhập position_id");
        int positionId = sc.nextInt();
        sc.nextLine();
//        System.out.println("Chọn position_name:    1.DEV    2.TEST    3.PM    Khác.SCRUM_MASTER");
//        PositionName positionName = null;
//        String choice = sc.nextLine();
//        switch (choice){
//            case "1":
//                positionName = PositionName.DEV;
//                break;
//            case "2":
//                positionName = PositionName.TEST;
//                break;
//            case "3":
//                positionName = PositionName.PM;
//                break;
//            default:
//                positionName = PositionName.SCRUM_MASTER;
//        }
//        Position position = new Position(positionId, positionName);
        System.out.println("Nhập department_id");
        int departmentId = sc.nextInt();
        sc.nextLine();
//        System.out.println("Nhập department_name");
//        String departmentName = sc.nextLine();
//        Department department = new Department(departmentId, departmentName);

        String sql =String.format("insert into account(username,full_name, email, position_id, department_id) values (?,?,?,?,?) ");

        try {
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, fullName);
            preparedStatement.setString(3, email);
            preparedStatement.setInt(4, positionId);
            preparedStatement.setInt(5, departmentId);


            int c = preparedStatement.executeUpdate();

            if (c>0){
                System.out.println("Thêm thành công");
            }else {
                System.out.println("Thêm thất bại");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
        }
    }

    @Override
    public void xoaAccountTheousUsername() {
        System.out.println("=== Xóa account theo username ===");
        System.out.println("Nhập username");
        String userName =sc.nextLine();

        Connection connection = JDBCUtils.getConnection();
        String sql = "delete from account where username = ?";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);

            int c = preparedStatement.executeUpdate();

            if (c>0){
                System.out.println("Xóa thành công");
            }else {
                System.out.println("Xóa thất bại");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
        }
    }

    @Override
    public void capNhatfullnameTheousUsername() {
        System.out.println("Update fullname theo username");
        System.out.println("Nhập username");
        String userName =sc.nextLine();
        System.out.println("Nhập fullname cần đổi");
        String fullName =sc.nextLine();

        Connection connection = JDBCUtils.getConnection();
        String sql = "update account set full_name = ? where username = ?";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,fullName);
            preparedStatement.setString(2,userName);

            int c = preparedStatement.executeUpdate();
            if (c>0){
                System.out.println("Cập nhật thành công");
            }else {
                System.out.println("Cập nhật thất bại");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
        }


    }
}
