import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow implements ActionListener {

    DataQuestions dataQuestions = new DataQuestions();

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

        textField.setBounds(0,0,565,50);
        textField.setBackground(new Color(57, 72, 120));
        textField.setForeground(new Color(255, 255, 255, 255));
        textField.setFont(new Font("Arial",Font.BOLD,30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
        textField.setText(dataQuestions.getListWords().get(1).getEngWord());

        buttonA.setBounds(50,100,200,200);
        buttonA.setFont(new Font("Arial",Font.BOLD,35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(300,100,200,200);
        buttonB.setFont(new Font("Arial",Font.BOLD,35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(50,350,200,200);
        buttonC.setFont(new Font("Arial",Font.BOLD,35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(300,350,200,200);
        buttonD.setFont(new Font("Arial",Font.BOLD,35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        buttonE.setBounds(50,600,200,200);
        buttonE.setFont(new Font("Arial",Font.BOLD,35));
        buttonE.setFocusable(false);
        buttonE.addActionListener(this);
        buttonE.setText("E");

        buttonF.setBounds(300,600,200,200);
        buttonF.setFont(new Font("Arial",Font.BOLD,35));
        buttonF.setFocusable(false);
        buttonF.addActionListener(this);
        buttonF.setText("F");

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonA) {
            System.out.println("A");
        }
        if(e.getSource()==buttonB) {
            System.out.println("B");
        }
        if(e.getSource()==buttonC) {
            System.out.println(buttonC.getText());
        }
        if(e.getSource()==buttonD) {
            System.out.println("D");
        }
        if(e.getSource()==buttonE) {
            System.out.println("E");
        }
        if(e.getSource()==buttonF) {
            System.out.println("F");
        }
    }

}
