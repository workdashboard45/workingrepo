package event.atharva;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator1 extends JFrame implements ActionListener {
    JTextField display;
    double num1, num2, result;
    char operator;

    JButton[] numberButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton;
    JButton equalButton, clearButton, decimalButton;

    public Calculator1() {
        setTitle("Standard Calculator");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 25));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        // Number buttons
        for (int i = 0; i <= 9; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            numberButtons[i].addActionListener(this);
        }

        // Operator buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equalButton = new JButton("=");
        clearButton = new JButton("C");
        decimalButton = new JButton(".");

        JButton[] operationButtons = {
            addButton, subButton, mulButton, divButton,
            equalButton, clearButton, decimalButton
        };

        for (JButton button : operationButtons) {
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(this);
        }

        // Add buttons to panel
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(mulButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);

        panel.add(numberButtons[0]);
        panel.add(decimalButton);
        panel.add(equalButton);
        panel.add(addButton);

        add(panel, BorderLayout.CENTER);

        // Clear button
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(clearButton, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // Number buttons
        if (command.charAt(0) >= '0' &&
            command.charAt(0) <= '9') {
            display.setText(display.getText() + command);
        }

        // Decimal point
        else if (command.equals(".")) {
            if (!display.getText().contains(".")) {
                display.setText(display.getText() + ".");
            }
        }

        // Clear
        else if (command.equals("C")) {
            display.setText("");
            num1 = num2 = result = 0;
            operator = '\0';
        }

        // Operators
        else if (command.equals("+") ||
                 command.equals("-") ||
                 command.equals("*") ||
                 command.equals("/")) {

            if (!display.getText().isEmpty()) {
 
                num1 = Double.parseDouble(display.getText());
                operator = command.charAt(0);
                display.setText("");
            }
        }

        // Equals
        else if (command.equals("=")) {
            if (!display.getText().isEmpty()) {
                num2 = Double.parseDouble(display.getText());

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;

                    case '-':
                        result = num1 - num2;
                        break;

                    case '*':
                        result = num1 * num2;
                        break;

                    case '/':
                        if (num2 != 0)
                            result = num1 / num2;
                        else {
                            display.setText("Error");
                            return;
                        }
                        break;
                }

                display.setText(String.valueOf(result));
            }
        }
    }

    public static void main(String[] args) {
        new Calculator1();
    }
}
