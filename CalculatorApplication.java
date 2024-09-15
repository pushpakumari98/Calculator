import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicCalculatorGUI extends JFrame implements ActionListener {

    // Components for the calculator
    private JTextField display;
    private JButton[] numberButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton sqrtButton, squareButton, reciprocalButton, clearButton, deleteButton, equalButton;
    private JButton dotButton, percentButton, openParenthesisButton, closeParenthesisButton;
    private JPanel panel;

    private double num1 = 0, num2 = 0;
    private char operator;
    private boolean dotUsed = false; // Track if the dot has been used

    public BasicCalculatorGUI() {
        // Frame properties
        setTitle(" Calculator");
        setSize(400, 600);  // Increased height to accommodate additional buttons
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.decode("#000000"));  // Dark background

        // Text field for the display
        display = new JTextField();
        display.setBounds(30, 40, 340, 50);
        display.setEditable(false);
        display.setBackground(Color.WHITE);
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setHorizontalAlignment(SwingConstants.RIGHT);  // Align text to the right
        display.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        add(display);

        // Creating buttons for numbers and operations
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            numberButtons[i].setBackground(Color.decode("#4CAF50"));  // Modern green for numbers
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setFocusPainted(false);
            numberButtons[i].setBorder(BorderFactory.createLineBorder(Color.decode("#FF5722")));
            numberButtons[i].addActionListener(this);
        }

        // Operation buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");

        squareButton = new JButton("x²");
        sqrtButton = new JButton("√");
        reciprocalButton = new JButton("1/x");
        clearButton = new JButton("CLR");
        deleteButton = new JButton("DEL");
        equalButton = new JButton("=");

        dotButton = new JButton(".");
        percentButton = new JButton("%");
        openParenthesisButton = new JButton("(");
        closeParenthesisButton = new JButton(")");

        // Setting color and font for number buttons
        JButton[] numberButtonsArray = {addButton, subButton, mulButton, divButton, deleteButton};
        for (JButton button : numberButtonsArray) {
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setBackground(Color.decode("#FFC107"));  // Yellow background
            button.setForeground(Color.BLACK);  // Black text
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createLineBorder(Color.decode("#FFD54F")));
            button.addActionListener(this);
        }

        // Setting color and font for other operation buttons
        JButton[] otherOperatorButtons = {squareButton, sqrtButton, reciprocalButton, clearButton, equalButton, dotButton, percentButton, openParenthesisButton, closeParenthesisButton};
        for (JButton button : otherOperatorButtons) {
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setBackground(Color.decode("#FF5722"));  // Stylish orange for other operators
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createLineBorder(Color.decode("#E64A19")));
            button.addActionListener(this);
        }

        equalButton.setBackground(Color.decode("#FFC107"));  // Bright yellow for equal button
        equalButton.setForeground(Color.BLACK);

        // Panel for the buttons layout
        panel = new JPanel();
        panel.setBounds(30, 120, 340, 430);  // Increased height for additional buttons
        panel.setLayout(new GridLayout(7, 4, 10, 10));
        panel.setBackground(Color.decode("#000000"));  // Panel background

        // Adding buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(dotButton);
        panel.add(numberButtons[0]);
        panel.add(percentButton);
        panel.add(divButton);
        panel.add(openParenthesisButton);
        panel.add(closeParenthesisButton);
        panel.add(clearButton);
        panel.add(equalButton);
        panel.add(sqrtButton);
        panel.add(reciprocalButton);
        panel.add(squareButton);
        panel.add(deleteButton);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText() + i);
                dotUsed = false; // Reset dot usage when a number is pressed
            }
        }

        if (e.getSource() == dotButton) {
            if (!dotUsed) {
                display.setText(display.getText() + ".");
                dotUsed = true;
            }
        }

        if (e.getSource() == percentButton) {
            num1 = Double.parseDouble(display.getText()) / 100;
            display.setText(String.valueOf(num1));
        }

        if (e.getSource() == openParenthesisButton) {
            display.setText(display.getText() + "(");
        }

        if (e.getSource() == closeParenthesisButton) {
            display.setText(display.getText() + ")");
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
            dotUsed = false;
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
            dotUsed = false;
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
            dotUsed = false;
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
            dotUsed = false;
        }
        if (e.getSource() == squareButton) {
            num1 = Double.parseDouble(display.getText());
            display.setText(String.valueOf(num1 * num1));
        }
        if (e.getSource() == sqrtButton) {
            num1 = Double.parseDouble(display.getText());
            display.setText(String.valueOf(Math.sqrt(num1)));
        }
        if (e.getSource() == reciprocalButton) {
            num1 = Double.parseDouble(display.getText());
            display.setText(String.valueOf(1 / num1));
        }
        if (e.getSource() == clearButton) {
            display.setText("");
            dotUsed = false;
        }
        if (e.getSource() == deleteButton) {
            String currentText = display.getText();
            if (currentText.length() > 0) {
                display.setText(currentText.substring(0, currentText.length() - 1));
                if (currentText.endsWith(".")) {
                    dotUsed = false; // Reset dot usage if the last character is a dot
                }
            }
        }
        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(display.getText());

            switch (operator) {
                case '+':
                    display.setText(String.valueOf(num1 + num2));
                    break;
                case '-':
                    display.setText(String.valueOf(num1 - num2));
                    break;
                case '*':
                    display.setText(String.valueOf(num1 * num2));
                    break;
                case '/':
                    if (num2 != 0) {
                        display.setText(String.valueOf(num1 / num2));
                    } else {
                        display.setText("Error");
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new BasicCalculatorGUI();
    }
}
