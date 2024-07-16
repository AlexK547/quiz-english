package com.redline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainWindow implements ActionListener {

    private List<Question> listQuestions = new DataQuestions().getListWords();
    private int numberWord = 0;
    private int countWords = listQuestions.size();

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JButton buttonE = new JButton();
    JButton buttonF = new JButton();

    JButton buttonPrev = new JButton("Prev");
    JButton buttonNext = new JButton("Next");

    public MainWindow() {
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
        textField.setText(listQuestions.get(numberWord).getEngWord());

        buttonA.setBounds(50,100,200,200);
        buttonA.setFont(new Font("Arial",Font.BOLD,35));
        buttonA.setFocusable(false);
        buttonA.setBackground(new Color(223, 233, 242, 255));
        buttonA.addActionListener(this);

        buttonB.setBounds(300,100,200,200);
        buttonB.setFont(new Font("Arial",Font.BOLD,35));
        buttonB.setFocusable(false);
        buttonB.setBackground(new Color(223, 233, 242, 255));
        buttonB.addActionListener(this);

        buttonC.setBounds(50,350,200,200);
        buttonC.setFont(new Font("Arial",Font.BOLD,35));
        buttonC.setFocusable(false);
        buttonC.setBackground(new Color(223, 233, 242, 255));
        buttonC.addActionListener(this);

        buttonD.setBounds(300,350,200,200);
        buttonD.setFont(new Font("Arial",Font.BOLD,35));
        buttonD.setFocusable(false);
        buttonD.setBackground(new Color(223, 233, 242, 255));
        buttonD.addActionListener(this);


        buttonE.setBounds(50,600,200,200);
        buttonE.setFont(new Font("Arial",Font.BOLD,35));
        buttonE.setFocusable(false);
        buttonE.setBackground(new Color(223, 233, 242, 255));
        buttonE.addActionListener(this);

        buttonF.setBounds(300,600,200,200);
        buttonF.setFont(new Font("Arial",Font.BOLD,35));
        buttonF.setFocusable(false);
        buttonF.setBackground(new Color(223, 233, 242, 255));
        buttonF.addActionListener(this);


        buttonPrev.setBounds(100,850,150,50);
        buttonPrev.setFont(new Font("Arial",Font.BOLD,35));
        buttonPrev.setFocusable(false);
        buttonPrev.addActionListener(this);

        buttonNext.setBounds(300,850,150,50);
        buttonNext.setFont(new Font("Arial",Font.BOLD,35));
        buttonNext.setFocusable(false);
        buttonNext.addActionListener(this);

        frame.add(textField);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(buttonE);
        frame.add(buttonF);
        frame.add((buttonPrev));
        frame.add((buttonNext));
        frame.setVisible(true);

        Collections.shuffle(listQuestions);
        showWord();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Question word = listQuestions.get(numberWord);

        if(e.getSource()==buttonA) {
            checkAnswer(word, buttonA);
        }
        if(e.getSource()==buttonB) {
            checkAnswer(word, buttonB);
        }
        if(e.getSource()==buttonC) {
            checkAnswer(word, buttonC);
        }
        if(e.getSource()==buttonD) {
            checkAnswer(word, buttonD);
        }
        if(e.getSource()==buttonE) {
            checkAnswer(word, buttonE);
        }
        if(e.getSource()==buttonF) {
            checkAnswer(word, buttonF);
        }
        if(e.getSource() == buttonNext) {
            numberWord++;
            if (numberWord > countWords - 1) {
                numberWord = 0;
            }
            showWord();

        }
        if(e.getSource() == buttonPrev) {
            numberWord--;
            if (numberWord < 0) {
                numberWord = countWords - 1;
            }
            showWord();

        }
    }

    private void checkAnswer(Question word, JButton button) {
        if (button.getText().equals(word.getRusWord())) {
            button.setBackground(Color.green);
        } else {
            button.setBackground(Color.red);
        }
    }

    private void showWord() {
        Question word = listQuestions.get(numberWord);
        textField.setText(word.getEngWord());
        List<String> listWords = new ArrayList<>();
        listWords.add(word.getRusWord());

        for (int i = 1; i < 6; i++) {
            int num = (int) Math.floor(Math.random() * countWords);
            while (listWords.contains(listQuestions.get(num).getRusWord())) {
                num = (int) Math.floor(Math.random() * countWords);
            }

            if (!listWords.contains(listQuestions.get(num).getRusWord())) {
                listWords.add(listQuestions.get(num).getRusWord());
            }

        }

        buttonA.setBackground(new Color(223, 233, 242, 255));
        buttonB.setBackground(new Color(223, 233, 242, 255));
        buttonC.setBackground(new Color(223, 233, 242, 255));
        buttonD.setBackground(new Color(223, 233, 242, 255));
        buttonE.setBackground(new Color(223, 233, 242, 255));
        buttonF.setBackground(new Color(223, 233, 242, 255));

        Collections.shuffle(listWords);
        buttonA.setText(listWords.get(0));
        buttonB.setText(listWords.get(1));
        buttonC.setText(listWords.get(2));
        buttonD.setText(listWords.get(3));
        buttonE.setText(listWords.get(4));
        buttonF.setText(listWords.get(5));
    }

}
