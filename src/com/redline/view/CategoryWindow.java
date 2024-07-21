package com.redline.view;


import com.redline.database.DbFunctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

public class CategoryWindow implements ActionListener {

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JButton button = new JButton();

    List<JButton> buttons = new ArrayList<>();

    AddNewWordWindow addNewWordWindow;
    DbFunctions DB = new DbFunctions();

    public CategoryWindow() throws SQLException {
        addNewWordWindow = new AddNewWordWindow(this, this.DB);
        addNewWordWindow.frame.setVisible(false);

        reflash();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==textField) {
            System.out.println("categories");
        }

        if(e.getSource()==button) {
            System.out.println("button");
            frame.setVisible(false);
            addNewWordWindow.frame.setVisible(true);
        }

    }


    public void addButtons(Set<String> categoriesList) {
        Object[] categories = categoriesList.toArray();
        int step = 80;

        for (int i = 0; i < categories.length; i++) {
            String category = (String) categories[i];
            JButton btn = new JButton();

            btn.setBounds(50,100 + i*step,450,50);
            btn.setFont(new Font("Arial",Font.BOLD,24));
            btn.setFocusable(false);
            btn.setBackground(new Color(223, 233, 242, 255));
            btn.setText((String) category);
            btn.addActionListener(this);

            buttons.add(btn);
            frame.add(btn);
            System.out.println(category);
        }

    }

    public void reflash() throws SQLException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(565,1000);
        frame.getContentPane().setBackground(new Color(222, 222, 222));
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(0,0,565,75);
        textField.setBackground(new Color(57, 72, 120));
        textField.setForeground(new Color(255, 255, 255, 255));
        textField.setFont(new Font("Arial",Font.BOLD,30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        textField.setText("Categories");
        textField.addActionListener(this);

        addButtons(DB.getCategories());
        System.out.println(DB.getCategories().size());

        button.setBounds(50,800,450,100);
        button.setFont(new Font("Arial",Font.BOLD,35));
        button.setFocusable(false);
        button.setBackground(new Color(223, 233, 242, 255));
        button.setText("Add new word");
        button.addActionListener(this);

        frame.add(textField);
        frame.add(button);

        frame.setVisible(true);
    }
}
