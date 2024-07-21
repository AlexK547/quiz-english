package com.redline.view;

import com.redline.database.DbFunctions;
import com.redline.question.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddNewWordWindow implements ActionListener {

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JLabel labelCategory = new JLabel("Category");
    JTextField textCategory = new JTextField();
    JLabel labelWordEng = new JLabel("English word");
    JTextField textWordEng = new JTextField(30);
    JLabel labelWordRus = new JLabel("Russian word");
    JTextField textWordRus = new JTextField(30);

    JLabel labelMessage = new JLabel("Enter new word");
    JButton buttonSave = new JButton("Save");
    JButton buttonClear = new JButton("Clear");
    JButton button = new JButton();

    CategoryWindow categoryWindow;
    DbFunctions DB;

    public AddNewWordWindow(CategoryWindow categoryWindow, DbFunctions db) {
        this.categoryWindow = categoryWindow;
        this.DB = db;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(565,1000);
        frame.getContentPane().setBackground(new Color(222, 222, 222));
        frame.setLayout(null);
        frame.setResizable(false);

        // header
        textField.setBounds(0,0,565,75);
        textField.setBackground(new Color(57, 72, 120));
        textField.setForeground(new Color(255, 255, 255, 255));
        textField.setFont(new Font("Arial",Font.BOLD,30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        textField.setText("Add word");
        textField.addActionListener(this);

        // category - english word - russian word
        labelCategory.setBounds(50, 80, 200, 40);
        textCategory.setBounds(50, 110, 450, 40);
        textCategory.setBackground(new Color(255, 255, 255));
        textCategory.setFont(new Font("Arial",Font.BOLD,24));
        textCategory.setBorder(BorderFactory.createBevelBorder(1));
        textCategory.setHorizontalAlignment(JTextField.LEFT);
        textCategory.setEditable(true);

        labelWordEng.setBounds(50, 180, 200, 40);
        textWordEng.setBounds(50, 210, 450, 40);
        textWordEng.setBackground(new Color(255, 255, 255));
        textWordEng.setFont(new Font("Arial",Font.BOLD,24));
        textWordEng.setBorder(BorderFactory.createBevelBorder(1));
        textWordEng.setHorizontalAlignment(JTextField.LEFT);
        textWordEng.setEditable(true);

        labelWordRus.setBounds(50, 280, 200, 40);
        textWordRus.setBounds(50, 310, 450, 40);
        textWordRus.setBackground(new Color(255, 255, 255));
        textWordRus.setFont(new Font("Arial", Font.BOLD,24));
        textWordRus.setBorder(BorderFactory.createBevelBorder(1));
        textWordRus.setHorizontalAlignment(JTextField.LEFT);
        textWordRus.setEditable(true);

        labelMessage.setBounds(50, 380, 450, 40);
        labelMessage.setFont(new Font("Arial", Font.BOLD,24));
        labelMessage.setHorizontalAlignment(JLabel.LEFT);

        // buttons save and clear
        buttonSave.setBounds(50,500,150,50);
        buttonSave.setFont(new Font("Arial",Font.BOLD,24));
        buttonSave.setFocusable(false);
        buttonSave.setBackground(new Color(223, 233, 242, 255));
        buttonSave.addActionListener(this);

        buttonClear.setBounds(250,500,150,50);
        buttonClear.setFont(new Font("Arial",Font.BOLD,24));
        buttonClear.setFocusable(false);
        buttonClear.setBackground(new Color(223, 233, 242, 255));
        buttonClear.addActionListener(this);

        button.setBounds(50,800,450,100);
        button.setFont(new Font("Arial",Font.BOLD,35));
        button.setFocusable(false);
        button.setBackground(new Color(223, 233, 242, 255));
        button.setText("Main window");
        button.addActionListener(this);



        frame.add(textField);
        frame.add(labelCategory);
        frame.add(textCategory);
        frame.add(labelWordEng);
        frame.add(textWordEng);
        frame.add(labelWordRus);
        frame.add(textWordRus);
        frame.add(labelMessage);
        frame.add(buttonSave);
        frame.add(buttonClear);
        frame.add(button);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button) {
            frame.setVisible(false);
            try {
                categoryWindow.reflash();
            } catch (SQLException ex) {
                System.out.println("Error");
            }
        }

        if(e.getSource() == buttonSave) {
            Question question;
            String wordEng = textWordEng.getText();
            String wordRus = textWordRus.getText();
            String category = textCategory.getText();

            if (category.isEmpty()) {
                labelMessage.setText("Enter category");
            } else if (wordEng.isEmpty()) {
                labelMessage.setText("Enter english word");
            } else if (wordRus.isEmpty()) {
                labelMessage.setText("Enter russian word");
            } else {
                question = new Question(category, wordEng, wordRus);
                String message = DB.saveWord(question);
                labelMessage.setText(message);
                textCategory.setText("");
                textWordEng.setText("");
                textWordRus.setText("");
            }

        }

        if(e.getSource() == buttonClear) {
            textCategory.setText("");
            textWordEng.setText("");
            textWordRus.setText("");
            labelMessage.setText("Enter new word");
        }
    }
}
