package com.redline;

import com.redline.database.DbFunctions;
import com.redline.view.CategoryWindow;

import java.sql.SQLException;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {



        DbFunctions db = new DbFunctions();
//        db.connectToDB("quiz-english", "postgres", "root");
        Set<String> categoriesList = db.getCategories();


        CategoryWindow categoryWindow = new CategoryWindow(categoriesList);

    }
}