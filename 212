import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame("Новогодний калькулятор");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(350, 450);

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());

        JTextField a = new JTextField();
        a.setHorizontalAlignment(JTextField.RIGHT);
        a.setFont(new Font("Arial", Font.PLAIN, 24));
        p.add(a, BorderLayout.NORTH);

        JPanel b = new JPanel();
        b.setLayout(new GridLayout(6, 4, 5, 5));

        String[] c = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "√", "x²", "M+", "M",
                "C"
        };

        final String[] firstNum = {""};
        final String[] operator = {""};
        final boolean[] isOperatorPressed = {false};
        final double[] memory = {0};

        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setBackground(Color.RED);
                Timer timer = new Timer(100, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btn.setBackground(null);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        };

        for (String t : c) {
            JButton k = new JButton(t);
            k.setFont(new Font("Arial", Font.PLAIN, 18));
            k.setBackground(new Color(255, 215, 0));
            k.setFocusPainted(false);
            k.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            k.addActionListener(buttonListener);

            b.add(k);

            k.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String text = k.getText();

                    if ("0123456789.".contains(text)) {
                        if (isOperatorPressed[0]) {
                            a.setText("");
                            isOperatorPressed[0] = false;
                        }
                        a.setText(a.getText() + text);
                    } else if ("/*-+".contains(text)) {
                        firstNum[0] = a.getText();
                        operator[0] = text;
                        isOperatorPressed[0] = true;
                    } else if ("=".equals(text)) {
                        String secondNum = a.getText();
                        double result = 0;

                        try {
                            double num1 = Double.parseDouble(firstNum[0]);
                            double num2 = Double.parseDouble(secondNum);

                            switch (operator[0]) {
                                case "+": result = num1 + num2; break;
                                case "-": result = num1 - num2; break;
                                case "*": result = num1 * num2; break;
                                case "/": result = num1 / num2; break;
                            }

                            a.setText(String.valueOf(result));
                        } catch (Exception ex) {
                            a.setText("Error");
                        }
                    } else if ("√".equals(text)) {
                        double num = Double.parseDouble(a.getText());
                        a.setText(String.valueOf(Math.sqrt(num)));
                    } else if ("x²".equals(text)) {
                        double num = Double.parseDouble(a.getText());
                        a.setText(String.valueOf(num * num));
                    } else if ("M+".equals(text)) {
                        memory[0] = Double.parseDouble(a.getText());
                    } else if ("M".equals(text)) {
                        a.setText(String.valueOf(memory[0]));
                    } else if ("C".equals(text)) {
                        a.setText("");
                        firstNum[0] = "";
                        operator[0] = "";
                        memory[0] = 0;
                    }
                }
            });
        }

        p.add(b, BorderLayout.CENTER);
        f.add(p);

        f.setVisible(true);
    }
}
