package com.example.gamificationaccesa.repository;


import com.example.gamificationaccesa.domain.*;

import java.sql.*;
import java.util.*;

public class UserDatabaseRepository implements Repository<User> {
    private static UserDatabaseRepository instance = null;
    private UserDatabaseRepository() {
    }
    public static UserDatabaseRepository getInstance() {
        if(instance == null) {
            instance = new UserDatabaseRepository();
        }
        return instance;
    }
    private final String url = "jdbc:postgresql://localhost:5432/gamification";
    private final String username = "postgres";
    private final String password = "15dovlecel";


    @Override
    public User getOne(Long aLong) {
        String sql = "SELECT * from users WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setLong(1, aLong);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Long id = resultSet.getLong("id");
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastname");
            String mail = resultSet.getString("mail");
            int age = resultSet.getInt("age");
            String password = resultSet.getString("password");
            int tokens = resultSet.getInt("tokens");
            String badges = resultSet.getString("badges");

            return new User(id, firstName,lastName,mail,age,password,tokens,badges);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterable<User> getAll() {
        Set<User> users = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from users");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String mail = resultSet.getString("mail");
                int age = resultSet.getInt("age");
                String password = resultSet.getString("password");
                int tokens = resultSet.getInt("tokens");
                String badges = resultSet.getString("badges");

                User user1 = new User(id,firstName,lastName,mail,age,password, tokens, badges);
                users.add(user1);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void verifyEntity(User entity) {
        if (entity == null)
            throw new IllegalArgumentException("entity must be not null");
        HashSet<User> all = (HashSet<User>) getAll();
        if (all.contains(entity)) {
            throw new IllegalArgumentException("the id must be unique");
        }
    }

    @Override
    public int size() {
        String sql = "SELECT COUNT(*) FROM users";

        int size = 0;
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            size = resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return size;
    }

    @Override
    public User delete(Long aLong) {
        String sql = "delete from users where id = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, aLong);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void update(User entity) {
        String sql = "update users set firstname =?, lastname =?, mail=?, age=?, password =?, tokens =?, badges=? where id =?";
        verifyEntity(entity);
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, entity.getFirstname());
            ps.setString(2, entity.getLastname());
            ps.setString(3, entity.getMail());
            ps.setInt(4, entity.getAge());
            ps.setString(5, entity.getPassword());
            ps.setInt(6, entity.getTokens());
            ps.setString(7, entity.getBadges());

            ps.setLong(8, entity.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> getAllList() {
        ArrayList<User> users = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from users");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String mail = resultSet.getString("mail");
                int age = resultSet.getInt("age");
                String password = resultSet.getString("password");
                int tokens = resultSet.getInt("tokens");
                String badges = resultSet.getString("badges");

                User user1 = new User(id,firstName,lastName,mail,age,password, tokens, badges);
                users.add(user1);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void save(User entity) {
        String sql = "insert into users(id,firstName,lastName,mail,age,password,tokens,badges)values(?,?,?,?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getFirstname());
            ps.setString(3, entity.getLastname());
            ps.setString(4, entity.getMail());
            ps.setInt(5, entity.getAge());
            ps.setString(6, entity.getPassword());
            ps.setInt(7, entity.getTokens());
            ps.setString(8, entity.getBadges());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

