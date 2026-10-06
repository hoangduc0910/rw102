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
                    "left join department dep on acc.department_id = dep.department_id\n" +
                    "left join position pos on acc.position_id = pos.position_id";
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
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
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
        String name = sc.nextLine();
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
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
        }
        System.out.println("Hiển account cần tìm");
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
        System.out.println("=== THÊM MỚI ACCOUNT ===");
        System.out.println("Nhập username");
        String username = sc.nextLine();
        System.out.println("Nhập fullname");
        String fullName = sc.nextLine();
        System.out.println("Nhập email");
        String email = sc.nextLine();
        int depId ;
        int posId;

        List<Position> positions = this.getAllPosition();

        while (true){
            System.out.println("Nhập position id");
            System.out.println("+-----+--------------------+");
            System.out.printf("|%5s|%20s|\n","ID","Name");
            System.out.println("+-----+--------------------+");
            for (Position pos: positions){
                System.out.printf("|%5s|%20s|\n", pos.getId(), pos.getName());
            }
            System.out.println("+-----+--------------------+");
            posId = sc.nextInt();
            sc.nextLine();
            boolean check = false;
            for (Position pos: positions){
                if (pos.getId() == posId){
                    check = true;
                    break;
                }
            }
            if (check ){
                break;
            }else {
                System.out.println("ID chức vụ chưa đúng, nhập lại!!");
            }
        }

        List<Department> departments = this.getallDepartment();
        while (true){
            System.out.println("Nhập department id");
            System.out.println("+-----+--------------------+");
            System.out.printf("|%5s|%20s|\n","ID","Name");
            System.out.println("+-----+--------------------+");
            for (Department dep : departments){
                System.out.printf("|%5s|%20s|\n", dep.getId(), dep.getName());
            }
            System.out.println("+-----+--------------------+");
            depId = sc.nextInt();
            sc.nextLine();
            boolean check = false;
            for (Department dep: departments){
                if (dep.getId() == depId){
                    check = true;
                    break;
                }
            }
            if (check ){
                break;
            }else {
                System.out.println("ID chưa đúng, nhập lại!!");
            }
        }
        System.out.printf("DepID: %d",  "PosID: %d", depId, posId);
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "INSERT INTO account (`username`, `full_name`, `email`, `department_id`, `position_id`) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,fullName);
            statement.setString(3,email);
            statement.setInt(4,depId);
            statement.setInt(5,posId);

            int c = statement.executeUpdate();
            if (c>0){
                System.out.println("Thêm mới thành công");
            }else {
                System.out.println("Thêm mới thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
        }

    }
        private List<Department> getallDepartment(){
            List<Department> departments = new ArrayList<>();
            try {
                Connection connection = JDBCUtils.getConnection();
                String sql = "select * from department";

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()){
                    departments.add(new Department(resultSet.getInt("department_id"), resultSet.getString("department_name")));
                }

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                JDBCUtils.closeConnection();
            }
            return departments;
        }
        private List<Position> getAllPosition(){
            List<Position> positions = new ArrayList<>();
            try {
                Connection connection = JDBCUtils.getConnection();
                String sql = "select * from position";

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()){
                   int id = resultSet.getInt("position_id");
                   String name = resultSet.getString("position_name");
                    PositionName pName = PositionName.valueOf(name);// chuyển enum thành string
                    Position position = new Position(id, pName);
                    positions.add(position);

    //    positions.add(new Position(resultSet.getInt("position_id"), PositionName.valueOf(resultSet.getString("position_name"))));

                }

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                JDBCUtils.closeConnection();
            }
            return positions ;
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
