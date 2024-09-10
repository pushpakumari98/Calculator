import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApplication implements ActionListener {

    double num1 = 0, num2 = 0, result = 0;
    int calculation;
    JFrame frame = new JFrame("Calculator");
    JLabel label = new JLabel();
    JTextField textField = new JTextField();
    JRadioButton onRadioButton = new JRadioButton("on");
    JRadioButton offRadioButton = new JRadioButton("off");
    JButton buttonZero = new JButton("0");
    JButton buttonOne = new JButton("1");
    JButton buttonTwo = new JButton("2");
    JButton buttonThree = new JButton("3");
    JButton buttonFour = new JButton("4");
    JButton buttonFive = new JButton("5");
    JButton buttonSix = new JButton("6");
    JButton buttonSeven = new JButton("7");
    JButton buttonEight = new JButton("8");
    JButton buttonNine = new JButton("9");
    JButton buttonDot = new JButton(".");
    JButton buttonClear = new JButton("Clr");
    JButton buttonDelete = new JButton("Del");
    JButton buttonEqual = new JButton("=");
    JButton buttonMul = new JButton("x");
    JButton buttonDiv = new JButton("/");
    JButton buttonPlus = new JButton("+");
    JButton buttonMinus = new JButton("-");
    JButton buttonSquare = new JButton("x\u00B2");
    JButton buttonReciprocal = new JButton("1/x");
    JButton buttonSqrt = new JButton("\u221A");

    // Theme related components
    JRadioButton darkTheme = new JRadioButton("Dark");
    JRadioButton lightTheme = new JRadioButton("Light");
    ButtonGroup themeGroup = new ButtonGroup();

    Color darkBackground = Color.black;
    Color darkForeground = Color.white;
    Color lightBackground = Color.white;
    Color lightForeground = Color.black;

    CalculatorApplication() {
        prepareGui();
        addComponents();
        addActionEvent();
        setTheme(darkTheme.isSelected()); // Start with dark theme
    }

    public void prepareGui() {
        frame.setSize(305, 550); // Adjusted height for theme settings
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(darkBackground);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addComponents() {
        label.setBounds(250, 0, 50, 50);
        label.setForeground(darkForeground);
        frame.add(label);

        textField.setBounds(10, 40, 270, 40);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setForeground(darkForeground); // Set text color
        frame.add(textField);

        onRadioButton.setBounds(10, 95, 60, 40);
        onRadioButton.setSelected(true);
        onRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
        onRadioButton.setBackground(darkBackground);
        onRadioButton.setForeground(darkForeground);
        onRadioButton.setFocusable(false);
        frame.add(onRadioButton);

        offRadioButton.setBounds(10, 120, 60, 40);
        offRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
        offRadioButton.setBackground(darkBackground);
        offRadioButton.setForeground(darkForeground);
        offRadioButton.setFocusable(false);
        frame.add(offRadioButton);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(onRadioButton);
        buttonGroup.add(offRadioButton);

        // Theme settings
        darkTheme.setBounds(10, 170, 80, 40);
        darkTheme.setFont(new Font("Arial", Font.BOLD, 14));
        darkTheme.setBackground(darkBackground);
        darkTheme.setForeground(darkForeground);
        darkTheme.setFocusable(false);
        frame.add(darkTheme);

        lightTheme.setBounds(10, 200, 80, 40);
        lightTheme.setFont(new Font("Arial", Font.BOLD, 14));
        lightTheme.setBackground(darkBackground);
        lightTheme.setForeground(darkForeground);
        lightTheme.setFocusable(false);
        frame.add(lightTheme);

        themeGroup.add(darkTheme);
        themeGroup.add(lightTheme);

        // Buttons - Rest of the code remains similar
        buttonSeven.setBounds(10, 250, 60, 40);
        buttonSeven.setFont(new Font("Arial", Font.BOLD, 20));
        buttonSeven.setFocusable(false);
        frame.add(buttonSeven);

        buttonEight.setBounds(80, 250, 60, 40);
        buttonEight.setFont(new Font("Arial", Font.BOLD, 20));
        buttonEight.setFocusable(false);
        frame.add(buttonEight);

        buttonNine.setBounds(150, 250, 60, 40);
        buttonNine.setFont(new Font("Arial", Font.BOLD, 20));
        buttonNine.setFocusable(false);
        frame.add(buttonNine);

        buttonFour.setBounds(10, 310, 60, 40);
        buttonFour.setFont(new Font("Arial", Font.BOLD, 20));
        buttonFour.setFocusable(false);
        frame.add(buttonFour);

        buttonFive.setBounds(80, 310, 60, 40);
        buttonFive.setFont(new Font("Arial", Font.BOLD, 20));
        buttonFive.setFocusable(false);
        frame.add(buttonFive);

        buttonSix.setBounds(150, 310, 60, 40);
        buttonSix.setFont(new Font("Arial", Font.BOLD, 20));
        buttonSix.setFocusable(false);
        frame.add(buttonSix);

        buttonOne.setBounds(10, 370, 60, 40);
        buttonOne.setFont(new Font("Arial", Font.BOLD, 20));
        buttonOne.setFocusable(false);
        frame.add(buttonOne);

        buttonTwo.setBounds(80, 370, 60, 40);
        buttonTwo.setFont(new Font("Arial", Font.BOLD, 20));
        buttonTwo.setFocusable(false);
        frame.add(buttonTwo);

        buttonThree.setBounds(150, 370, 60, 40);
        buttonThree.setFont(new Font("Arial", Font.BOLD, 20));
        buttonThree.setFocusable(false);
        frame.add(buttonThree);

        buttonDot.setBounds(150, 430, 60, 40);
        buttonDot.setFont(new Font("Arial", Font.BOLD, 20));
        buttonDot.setFocusable(false);
        frame.add(buttonDot);

        buttonZero.setBounds(10, 430, 130, 40);
        buttonZero.setFont(new Font("Arial", Font.BOLD, 20));
        buttonZero.setFocusable(false);
        frame.add(buttonZero);

        buttonEqual.setBounds(220, 370, 60, 100);
        buttonEqual.setFont(new Font("Arial", Font.BOLD, 20));
        buttonEqual.setBackground(new Color(239, 188, 2));
        buttonEqual.setFocusable(false);
        frame.add(buttonEqual);

        buttonDiv.setBounds(220, 110, 60, 40);
        buttonDiv.setFont(new Font("Arial", Font.BOLD, 20));
        buttonDiv.setBackground(new Color(239, 188, 2));
        buttonDiv.setFocusable(false);
        frame.add(buttonDiv);

        buttonSqrt.setBounds(10, 170, 60, 40);
        buttonSqrt.setFont(new Font("Arial", Font.BOLD, 18));
        buttonSqrt.setFocusable(false);
        frame.add(buttonSqrt);

        buttonMul.setBounds(220, 250, 60, 40);
        buttonMul.setFont(new Font("Arial", Font.BOLD, 20));
        buttonMul.setBackground(new Color(239, 188, 2));
        buttonMul.setFocusable(false);
        frame.add(buttonMul);

        buttonMinus.setBounds(220, 170, 60, 40);
        buttonMinus.setFont(new Font("Arial", Font.BOLD, 20));
        buttonMinus.setBackground(new Color(239, 188, 2));
        buttonMinus.setFocusable(false);
        frame.add(buttonMinus);

        buttonPlus.setBounds(220, 310, 60, 50);
        buttonPlus.setFont(new Font("Arial", Font.BOLD, 20));
        buttonPlus.setBackground(new Color(239, 188, 2));
        buttonPlus.setFocusable(false);
        frame.add(buttonPlus);

        buttonSquare.setBounds(80, 170, 60, 40);
        buttonSquare.setFont(new Font("Arial", Font.BOLD, 20));
        buttonSquare.setFocusable(false);
        frame.add(buttonSquare);

        buttonReciprocal.setBounds(150, 170, 60, 40);
        buttonReciprocal.setFont(new Font("Arial", Font.BOLD, 15));
        buttonReciprocal.setFocusable(false);
        frame.add(buttonReciprocal);

        buttonDelete.setBounds(150, 110, 60, 40);
        buttonDelete.setFont(new Font("Arial", Font.BOLD, 12));
        buttonDelete.setBackground(Color.red);
        buttonDelete.setForeground(Color.white);
        buttonDelete.setFocusable(false);
        frame.add(buttonDelete);

        buttonClear.setBounds(80, 110, 60, 40);
        buttonClear.setFont(new Font("Arial", Font.BOLD, 12));
        buttonClear.setBackground(Color.red);
        buttonClear.setForeground(Color.white);
        buttonClear.setFocusable(false);
        frame.add(buttonClear);
    }

    public void addActionEvent() {
        onRadioButton.addActionListener(this);
        offRadioButton.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonDiv.addActionListener(this);
        buttonSqrt.addActionListener(this);
        buttonSquare.addActionListener(this);
        buttonReciprocal.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonSeven.addActionListener(this);
        buttonEight.addActionListener(this);
        buttonNine.addActionListener(this);
        buttonMul.addActionListener(this);
        buttonFour.addActionListener(this);
        buttonFive.addActionListener(this);
        buttonSix.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonOne.addActionListener(this);
        buttonTwo.addActionListener(this);
        buttonThree.addActionListener(this);
        buttonEqual.addActionListener(this);
        buttonZero.addActionListener(this);
        buttonDot.addActionListener(this);

        // Theme settings action listeners
        darkTheme.addActionListener(this);
        lightTheme.addActionListener(this);
    }

    public static void main(String[] args) {
        new CalculatorApplication();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == onRadioButton) {
            enable();
        } else if (source == offRadioButton) {
            disable();
        } else if (source == buttonClear) {
            label.setText("");
            textField.setText("");
        } else if (source == buttonDelete) {
            int length = textField.getText().length();
            int number = length - 1;
            if (length > 0) {
                StringBuilder back = new StringBuilder(textField.getText());
                back.deleteCharAt(number);
                textField.setText(back.toString());
            }
            if (textField.getText().endsWith("")) ;
            label.setText("");
        } else if (source == buttonZero) {
            if (textField.getText().equals("0")) {
                return;
            } else {
                textField.setText(textField.getText() + "0");
            }
        } else if (source == buttonOne) {
            textField.setText(textField.getText() + "1");
        } else if (source == buttonTwo) {
            textField.setText(textField.getText() + "2");
        } else if (source == buttonThree) {
            textField.setText(textField.getText() + "3");
        } else if (source == buttonFour) {
            textField.setText(textField.getText() + "4");
        } else if (source == buttonFive) {
            textField.setText(textField.getText() + "5");
        } else if (source == buttonSix) {
            textField.setText(textField.getText() + "6");
        } else if (source == buttonSeven) {
            textField.setText(textField.getText() + "7");
        } else if (source == buttonEight) {
            textField.setText(textField.getText() + "8");
        } else if (source == buttonNine) {
            textField.setText(textField.getText() + "9");
        } else if (source == buttonDot) {
            if (textField.getText().contains(".")) {
                return;
            } else {
                textField.setText(textField.getText() + ".");
            }
        } else if (source == buttonPlus) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            calculation = 1;
            textField.setText("");
            label.setText(str + "+");
        } else if (source == buttonMinus) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            calculation = 2;
            textField.setText("");
            label.setText(str + "-");
        } else if (source == buttonMul) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            calculation = 3;
            textField.setText("");
            label.setText(str + "*");
        } else if (source == buttonDiv) {
            String str = textField.getText();
            num1 = Double.parseDouble(textField.getText());
            calculation = 4;
            textField.setText("");
            label.setText(str + "/");
        } else if (source == buttonSquare) {
            num1 = Double.parseDouble(textField.getText());
            double square = Math.pow(num1, 2);
            String string = Double.toString(square);
            if (string.endsWith("0")) {
                textField.setText(string.replace(".0", ""));
            } else {
                textField.setText((string));
            }
        } else if (source == buttonSqrt) {
            num1 = Double.parseDouble(textField.getText());
            double sqrt = Math.sqrt(num1);
            textField.setText(Double.toString(sqrt));
        } else if (source == buttonReciprocal) {
            num1 = Double.parseDouble(textField.getText());
            double reciprocal = 1 / num1;
            String string = Double.toString(reciprocal);
            if (string.endsWith(".0")) {
                textField.setText(string.replace(".0", ""));
            } else {
                textField.setText(string);
            }
        } else if (source == buttonEqual) {
            num2 = Double.parseDouble(textField.getText());
            switch (calculation) {
                case 1:
                    result = num1 + num2;
                    break;
                case 2:
                    result = num1 - num2;
                    break;
                case 3:
                    result = num1 * num2;
                    break;
                case 4:
                    result = num1 / num2;
                    break;

            }
            if (Double.toString(result).endsWith(".0")) {
                textField.setText(Double.toString(result).replace(".0", ""));
            } else {
                textField.setText(Double.toString(result));
            }
            label.setText("");
            num1 = result;
        } else if (source == darkTheme) {
            setTheme(true); // Apply dark theme
        } else if (source == lightTheme) {
            setTheme(false); // Apply light theme
        }
    }

    public void enable() {
        onRadioButton.setEnabled(false);
        offRadioButton.setEnabled(false);
        textField.setEnabled(true);
        label.setEnabled(true);
        buttonDelete.setEnabled(true);
        buttonDiv.setEnabled(true);
        buttonSqrt.setEnabled(true);
        buttonSquare.setEnabled(true);
        buttonReciprocal.setEnabled(true);
        buttonMinus.setEnabled(true);
        buttonSeven.setEnabled(true);
        buttonEight.setEnabled(true);
        buttonNine.setEnabled(true);
        buttonMul.setEnabled(true);
        buttonFour.setEnabled(true);
        buttonFive.setEnabled(true);
        buttonSix.setEnabled(true);
        buttonPlus.setEnabled(true);
        buttonOne.setEnabled(true);
        buttonTwo.setEnabled(true);
        buttonThree.setEnabled(true);
        buttonEqual.setEnabled(true);
        buttonZero.setEnabled(true);
        buttonDot.setEnabled(true);
    }

    public void disable() {
        onRadioButton.setEnabled(true);
        offRadioButton.setEnabled(false);
        textField.setEnabled(false);
        label.setEnabled(false);
        label.setText("");
        textField.setText("");
        buttonDelete.setEnabled(false);
        buttonDiv.setEnabled(false);
        buttonSqrt.setEnabled(false);
        buttonSquare.setEnabled(false);
        buttonReciprocal.setEnabled(false);
        buttonMinus.setEnabled(false);
        buttonSeven.setEnabled(false);
        buttonEight.setEnabled(false);
        buttonNine.setEnabled(false);
        buttonMul.setEnabled(false);
        buttonFour.setEnabled(false);
        buttonFive.setEnabled(false);
        buttonSix.setEnabled(false);
        buttonPlus.setEnabled(false);
        buttonOne.setEnabled(false);
        buttonTwo.setEnabled(false);
        buttonThree.setEnabled(false);
        buttonEqual.setEnabled(false);
        buttonZero.setEnabled(false);
        buttonDot.setEnabled(false);
    }

    // Function to apply the theme
    public void setTheme(boolean isDark) {
        if (isDark) {
            frame.getContentPane().setBackground(darkBackground);
            label.setForeground(darkForeground);
            textField.setForeground(darkForeground);
            onRadioButton.setBackground(darkBackground);
            onRadioButton.setForeground(darkForeground);
            offRadioButton.setBackground(darkBackground);
            offRadioButton.setForeground(darkForeground);
            darkTheme.setBackground(darkBackground);
            darkTheme.setForeground(darkForeground);
            lightTheme.setBackground(darkBackground);
            lightTheme.setForeground(darkForeground);

            // Update button colors
            buttonClear.setBackground(Color.blue); // Dark red
            buttonClear.setForeground(Color.white);
            buttonDelete.setBackground(Color.blue);
            buttonDelete.setForeground(Color.white);
        } else {
            frame.getContentPane().setBackground(lightBackground);
            label.setForeground(lightForeground);
            textField.setForeground(lightForeground);
            onRadioButton.setBackground(lightBackground);
            onRadioButton.setForeground(lightForeground);
            offRadioButton.setBackground(lightBackground);
            offRadioButton.setForeground(lightForeground);
            darkTheme.setBackground(lightBackground);
            darkTheme.setForeground(lightForeground);
            lightTheme.setBackground(lightBackground);
            lightTheme.setForeground(lightForeground);

            // Update button colors
            buttonClear.setBackground(Color.CYAN); // Light gray
            buttonClear.setForeground(Color.black);
            buttonDelete.setBackground(Color.CYAN);
            buttonDelete.setForeground(Color.black);
        }
        frame.repaint(); // Refresh the frame to apply the changes
    }
}