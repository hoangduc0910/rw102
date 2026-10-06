package backend;

import entity.Department;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLDepartment implements IQLDepartment {
    Scanner sc = new Scanner(System.in);
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
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
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
        String name = sc.nextLine();
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
           e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
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
    public void themMoiDepartment() {
        System.out.println("Thêm mới Department");
        System.out.println("Nhập department name: ");
        String name = sc.nextLine();

        String sql = "INSERT INTO department (department_name) VALUES (?)";

        try {
            Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);

            int c = preparedStatement.executeUpdate();

            if (c > 0){
                System.out.println("Thêm mới thành công");
            }else {
                System.out.println("Thêm mới thất bại");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
        }

    }

    @Override
    public void xoaDepartmentTheoTen() {
        System.out.println("=== Xóa department theo tên ===");
        System.out.println("Nhập tên department");
        String name =sc.nextLine();

        Connection connection = JDBCUtils.getConnection();
        String sql = "delete from department where department_name = ?";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, name);

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
    public void capNhatDepartmentTheoid() {
        System.out.println("Update tên department theo id");
        System.out.println("Nhập id");
        int department_id = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhập department_name cần đổi");
        String name =sc.nextLine();

        Connection connection = JDBCUtils.getConnection();
        String sql = "update department set department_name  = ? where department_id = ?";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,department_id);

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
