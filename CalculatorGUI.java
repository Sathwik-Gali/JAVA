import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CalculatorGUI extends JFrame implements ActionListener {
    // Create frame
    static JFrame frame;

    // Create a textfield
    static JTextField textField;

    // Store operator and operands
    String operator;
    double num1, num2, result;

    // Default constructor
    CalculatorGUI() {
        operator = "";
        num1 = num2 = result = 0.0;

        // Create a textfield
        textField = new JTextField(16);

        // Set the textfield to non-editable
        textField.setEditable(false);

        // Create number buttons and operations buttons
        JButton[] numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton equalsButton = new JButton("=");
        JButton clearButton = new JButton("C");

        // Create a panel to hold the buttons
        JPanel panel = new JPanel();

        // Set the layout to a grid layout
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtractButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);

        panel.add(clearButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(divideButton);

        // Add the panel to the frame
        add(panel, BorderLayout.CENTER);

        // Add the textfield to the frame
        add(textField, BorderLayout.NORTH);

        // Set frame properties
        setTitle("Calculator");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Handle button clicks
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
            textField.setText(textField.getText() + command);
        } else if (command.charAt(0) == 'C') {
            textField.setText("");
            num1 = num2 = result = 0.0;
            operator = "";
        } else if (command.charAt(0) == '=') {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0.0) {
                        textField.setText("Error");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
            operator = "";
        } else {
            if (!operator.isEmpty()) {
                return;
            }
            operator = command;
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
        }
    }
    // Driver code
    public static void main(String[] args) {
        // Create a new frame
        frame = new JFrame("Calculator");

        // Create an object of the class
      new CalculatorGUI();

        // Create a textfield
        textField = new JTextField(16);
    
        // Set the textfield to non-editable
        textField.setEditable(false);

        // Add the textfield to the frame
        frame.add(textField, BorderLayout.NORTH);

        // Set frame properties
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}