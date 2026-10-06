package backend.repository.impl;

import backend.repository.IQLDepartmentRepository;
import entity.Department;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLDepartmentRepositoryImpl implements IQLDepartmentRepository {



    @Override
    public List<Department> findAll() {
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
        return departments;
    }

    @Override
    public List<Department> findByDepartmentName(String name) {
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
        return departments;
    }

    @Override
    public boolean deleteDepartmentByName(String name) {
        Connection connection = JDBCUtils.getConnection();
        String sql = "delete from department where department_name = ?";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, name);

            int c = preparedStatement.executeUpdate();

            return c>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
        }
        return false;
    }

    @Override
    public boolean updateDepById(int departmentId, String name) {
        Connection connection = JDBCUtils.getConnection();
        String sql = "update department set department_name  = ? where department_id = ?";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,departmentId);

            int c = preparedStatement.executeUpdate();
            return c>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
        }


        return false;
    }
}
