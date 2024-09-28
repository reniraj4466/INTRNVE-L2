/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    private JTextField display;
    private JButton[] numberButtons = new JButton[10];
    private JButton addButton, subButton, mulButton, divButton, eqButton, clrButton;
    private String operator;
    private double num1, num2;

    public Calculator() {
        setTitle("Basic Calculator");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 40));
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            numberButtons[i].addActionListener(this);
            panel.add(numberButtons[i]);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clrButton = new JButton("C");

        addButton.setFont(new Font("Arial", Font.PLAIN, 40));
        subButton.setFont(new Font("Arial", Font.PLAIN, 40));
        mulButton.setFont(new Font("Arial", Font.PLAIN, 40));
        divButton.setFont(new Font("Arial", Font.PLAIN, 40));
        eqButton.setFont(new Font("Arial", Font.PLAIN, 40));
        clrButton.setFont(new Font("Arial", Font.PLAIN, 40));

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        eqButton.addActionListener(this);
        clrButton.addActionListener(this);

        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(eqButton);
        panel.add(clrButton);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = "+";
            display.setText("");
        } else if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = "-";
            display.setText("");
        } else if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = "*";
            display.setText("");
        } else if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = "/";
            display.setText("");
        } else if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case "+":
                    display.setText(String.valueOf(num1 + num2));
                    break;
                case "-":
                    display.setText(String.valueOf(num1 - num2));
                    break;
                case "*":
                    display.setText(String.valueOf(num1 * num2));
                    break;
                case "/":
                    display.setText(String.valueOf(num1 / num2));
                    break;
            }
        } else if (e.getSource() == clrButton) {
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
