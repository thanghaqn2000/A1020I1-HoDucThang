package model.repository.impl;

import model.bean.User;
import model.repository.BaseRepository;
import model.repository.UserRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserRepoImpl implements UserRepo {
    private static final String DELETE_USER_BY_ID_SQL = "delete from users where id = ?";
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public boolean insertUser(User user) throws SQLException {
        int row = 0;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                    ("insert into users(`name`, email, country) values(?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    @Override
    public User selectUser(int id) {
        System.out.println(id);
        User user = null;
        // Step 1: Establishing a Connection
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                    ("select * from users where id=?");
            preparedStatement.setInt(1, id);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            Statement statement = baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setCountry(resultSet.getString("country"));
                user.setEmail(resultSet.getString("email"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        int row = 0;
        PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                ("delete from users where id = ?");
        preparedStatement.setInt(1, id);
        row = preparedStatement.executeUpdate();
        return row > 0;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return false;
    }
}
