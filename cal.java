import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComplexCalculatorUI {
    private JFrame frame;
    private JPanel panel;
    private JTextField textField;
    private JButton[] buttons;
    private String[] buttonLabels = {
        "7", "8", "9", "+",
        "4", "5", "6", "-",
        "1", "2", "3", "*",
        "0", ".", "/", "=",
        "sqrt", "x^2", "x^n", "C",
        "sin", "cos", "tan", "!",
    };

    public ComplexCalculatorUI() {
        frame = new JFrame("Complex Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 4));
        
        textField = new JTextField();
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        
        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].addActionListener(new ButtonClickListener());
            panel.add(buttons[i]);
        }

        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            switch (command) {
                case "=":
                    calculateResult();
                    break;
                case "C":
                    clearTextField();
                    break;
                case "sqrt":
                    calculateSquareRoot();
                    break;
                case "x^2":
                    calculatePower(2);
                    break;
                case "sin":
                    calculateTrigonometricFunction("sin");
                    break;
                case "cos":
                    calculateTrigonometricFunction("cos");
                    break;
                case "tan":
                    calculateTrigonometricFunction("tan");
                    break;
                case "!":
                    calculateFactorial();
                    break;
                default:
                    appendToTextField(command);
            }
        }
    }

    private void appendToTextField(String text) {
        textField.setText(textField.getText() + text);
    }

    private void clearTextField() {
        textField.setText("");
    }

    private void calculateResult() {
        String expression = textField.getText();
        // You need to implement the evaluation logic here
        // This is just a placeholder
        String result = evaluateExpression(expression);
        textField.setText(result);
    }

    private void calculateSquareRoot() {
        double operand = Double.parseDouble(textField.getText());
        double result = Math.sqrt(operand);
        textField.setText(Double.toString(result));
    }

    private void calculatePower(int power) {
        double operand = Double.parseDouble(textField.getText());
        double result = Math.pow(operand, power);
        textField.setText(Double.toString(result));
    }

    private void calculateTrigonometricFunction(String functionName) {
        double operand = Double.parseDouble(textField.getText());
        double result = 0;
        switch (functionName) {
            case "sin":
                result = Math.sin(operand);
                break;
            case "cos":
                result = Math.cos(operand);
                break;
            case "tan":
                result = Math.tan(operand);
                break;
        }
        textField.setText(Double.toString(result));
    }

    private void calculateFactorial() {
        int operand = Integer.parseInt(textField.getText());
        int result = factorial(operand);
        textField.setText(Integer.toString(result));
    }

    private int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }

    private String evaluateExpression(String expression) {
        // You need to implement the evaluation logic here
        // This is just a placeholder
        return "42";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComplexCalculatorUI();
            }
        });
    }
}
