package com.example.gamificationaccesa.repository;

import com.example.gamificationaccesa.domain.*;

import java.sql.*;
import java.util.*;

public class QuestDatabaseRepository implements Repository<Quest> {

    private static QuestDatabaseRepository instance = null;

    private QuestDatabaseRepository() {
    }
    public static QuestDatabaseRepository getInstance() {
        if(instance == null) {
            instance = new QuestDatabaseRepository();
        }
        return instance;
    }
    private final String url = "jdbc:postgresql://localhost:5432/gamification";
    private final String username = "postgres";
    private final String password = "15dovlecel";
    @Override
    public Quest getOne(Long aLong) {
        String sql = "SELECT * from quests WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setLong(1, aLong);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            Long userid = resultSet.getLong("user");
            String sentence  = resultSet.getString("sentence");
            String answer = resultSet.getString("answer");

            return new Quest(id,name,userid,sentence,answer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterable<Quest> getAll() {
        Set<Quest> quests = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from quests");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Long userid = resultSet.getLong("userid");
                String sentence  = resultSet.getString("sentence");
                String answer = resultSet.getString("answer");

                Quest q = new Quest(id,name,userid,sentence,answer);
                quests.add(q);
            }
            return quests;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quests;
    }

    @Override
    public void verifyEntity(Quest entity) {
        if (entity == null)
            throw new IllegalArgumentException("entity must be not null");
        HashSet<Quest> all = (HashSet<Quest>) getAll();
        if (all.contains(entity)) {
            throw new IllegalArgumentException("the id must be unique");
        }
    }

    @Override
    public void save(Quest entity) {
        String sql = "insert into quests(id,name,userid,sentence,answer)values(?,?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setLong(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setLong(3, entity.getUserid());
            ps.setString(4, entity.getSentence());
            ps.setString(5, entity.getAnswer());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int size() {
        String sql = "SELECT COUNT(*) FROM quests";

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
    public Quest delete(Long aLong) {
        String sql = "delete from quests where id = ?";

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
    public void update(Quest entity) {
        String sql = "update quests set name = ?, userid = ?, sentence=?, answer=?where id = ?";
        verifyEntity(entity);
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, entity.getId().toString());
            ps.setString(2, entity.getName());
            ps.setLong(3, entity.getUserid());
            ps.setString(4, entity.getSentence());
            ps.setString(5, entity.getAnswer());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Quest> getAllList() {
        ArrayList<Quest> quests = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from quests");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Long userid = resultSet.getLong("userid");
                String sentence  = resultSet.getString("sentence");
                String answer = resultSet.getString("answer");

                Quest q = new Quest(id,name,userid,sentence,answer);
                quests.add(q);
            }
            return quests;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quests;
    }
}
