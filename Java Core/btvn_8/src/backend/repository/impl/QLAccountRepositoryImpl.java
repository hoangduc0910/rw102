package backend.repository.impl;

import backend.repository.IQLAccountRepository;
import entity.Account;
import entity.Department;
import entity.Position;
import entity.PositionName;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLAccountRepositoryImpl implements IQLAccountRepository {



    @Override
    public List<Account> findAll() {
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
        return accounts;
    }

    @Override
    public List<Account> findByUserName(String name) {
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
        return accounts;
    }

    @Override
    public boolean deleteAccountByName(String userName) {
        Connection connection = JDBCUtils.getConnection();
        String sql = "delete from account where username = ?";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);

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
    public boolean updateFullNameByUsername(String userName, String fullName) {

        Connection connection = JDBCUtils.getConnection();
        String sql = "update account set full_name = ? where username = ?";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,fullName);
            preparedStatement.setString(2,userName);

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
    public List<Position> getAllPosition() {
        List<Position> positions = new ArrayList<>();
        try {
            String url = "jdbc:mysql://localhost:3306/btvn_8";
            String username = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM position";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                int id = resultSet.getInt("position_id");
                String positionNameString = resultSet.getString("position_name");
                PositionName positionName = PositionName.valueOf(positionNameString);
                positions.add(new Position(id, positionName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
        }
        return positions;
    }

    @Override
    public List<Department> getallDepartment() {
        List<Department> departments = new ArrayList<>();
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
                departments.add(new Department(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
        }
        return departments;
    }

    @Override
    public boolean themMoiAccount(Account account) {
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "INSERT INTO account (`username`, `full_name`, `email`, `department_id`, `position_id`) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, account.getUserName());
            statement.setString(2,account.getFullName());
            statement.setString(3, account.getEmail());
            statement.setInt(4,account.getDepartment().getId());
            statement.setInt(5,account.getPosition().getId());



            int c = statement.executeUpdate();
            return c>0;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
        }
        return false;
    }

    @Override
    public boolean exitsByUserName(String username) {
        try {
            Connection conn = JDBCUtils.getConnection();
            String sql = "SELECT * FROM account WHERE username like ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
        }
        return false;
    }

    @Override
    public boolean exitsByEmail(String email) {
        try {
            Connection conn = JDBCUtils.getConnection();
            String sql = "SELECT * FROM account WHERE email like ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
        }
        return false;
    }

    @Override
    public boolean deleteIfExits(String userName) {
        try {
            Connection conn = JDBCUtils.getConnection();
            String sql = "SELECT * FROM account WHERE username like ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeConnection();
        }
        return true;
    }
}
