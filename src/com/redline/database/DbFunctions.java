package com.redline.database;

import com.redline.question.Question;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class DbFunctions {
    public Connection connectToDB(String dbname, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname + "?serverTimezone=Europe/Moscow&useSSL=false", user, pass);
        } catch (Exception ex) {
            System.out.println("Error");
            System.out.println(ex);
        }
        return conn;
    }

    public Set<String> getCategories() throws SQLException {
        Set<String> categoriesList = new HashSet<>();

        try {
            Connection conn = connectToDB("quiz-english", "postgres", "root");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT category FROM words");
            while (resultSet.next()) {
                String category = resultSet.getString(1);
                categoriesList.add(category);
            }

            conn.close();
        } catch (Exception ex) {
            System.out.println("Error");
            System.out.println(ex);
        }


        return categoriesList;
    }

    public String saveWord(Question question) {
        String wordCategory = question.getCategory();
        String wordEng = question.getEngWord();
        String wordRus = question.getRusWord();

        try {
            Connection conn = connectToDB("quiz-english", "postgres", "root");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM words");
            while (resultSet.next()) {
                String category = resultSet.getString(1);
                String eng = resultSet.getString(2);
                String rus = resultSet.getString(3);

                if (eng.equals(wordEng) || rus.equals(wordRus)) {
                    return "The word is already in the database";
                }
            }

            String sql = "INSERT INTO words (category, word_eng, word_rus) VALUES ('"
                    + wordCategory
                    + "', '" + wordEng
                    + "', '" + wordRus + "')";
            int rows = statement.executeUpdate(sql);
            System.out.println(rows);

            conn.close();
        } catch (Exception ex) {
            System.out.println("Error");
            System.out.println(ex);
        }

        return "Word added to database";
    }
}
