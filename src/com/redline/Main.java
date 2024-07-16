package com.redline;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        MainWindow window = new MainWindow();

        DbFunctions db = new DbFunctions();
        db.connectToDB("quiz-english", "postgres", "root");


    }
}