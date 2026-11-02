package event.atharva;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
public class Calculator extends JFrame {

    JTextField display;
    int n1, n2;
    String op;
    Calculator() {
        setSize(300, 400);
        setTitle("Calculator");
        setLayout(null);

        display = new JTextField();
   display.setFont(new Font("Arial", Font.BOLD, 25));
        display.setBounds(30, 30, 230, 50);
        add(display);

        JButton b1 = new JButton("1");
        b1.setBounds(30, 100, 50, 50);
        add(b1);
        JButton b2 = new JButton("2");
        b2.setBounds(90, 100, 50, 50);
        add(b2);

        JButton b3 = new JButton("3");
        b3.setBounds(150, 100, 50, 50);
        add(b3);

        JButton add = new JButton("+");
        add.setBounds(210, 100, 50, 50);
        add(add);

        JButton b4 = new JButton("4");
        b4.setBounds(30, 160, 50, 50);
        add(b4);

        JButton b5 = new JButton("5");
        b5.setBounds(90, 160, 50, 50);
        add(b5);

        JButton b6 = new JButton("6");
        b6.setBounds(150, 160, 50, 50);
        add(b6);

        JButton sub = new JButton("-");
        sub.setBounds(210, 160, 50, 50);
        add(sub);

        JButton b7 = new JButton("7");
        b7.setBounds(30, 220, 50, 50);
        add(b7);

        JButton b8 = new JButton("8");
        b8.setBounds(90, 220, 50, 50);
        add(b8);

        JButton b9 = new JButton("9");
        b9.setBounds(150, 220, 50, 50);
        add(b9);

        JButton mul = new JButton("*");
        mul.setBounds(210, 220, 50, 50);
        add(mul);
        JButton b0 = new JButton("0");
        b0.setBounds(30, 280, 50, 50);
        add(b0);

        JButton clear = new JButton("C");
        clear.setBounds(90, 280, 50, 50);
        add(clear);

        JButton equal = new JButton("=");
        equal.setBounds(150, 280, 50, 50);
        add(equal);

        JButton div = new JButton("/");
        div.setBounds(210, 280, 50, 50);
        add(div);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "1");
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "2");
            }
        });

        
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "3");
            }
        }); 
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "4");
            }
        }); 
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "5");
            }
        }); 
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "6");
            }
        }); 
        b7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "7");
            }
        }); 
        b8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "8");
            }
        }); 
        b9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "9");
            }
        });
        b0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "0");
            }
        });


        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                n1 = Integer.parseInt(display.getText());
                op = "+";
                display.setText("");
            }
        });
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 n1 = Integer.parseInt(display.getText());
                op = "-";
                display.setText("");
            }
        });
        mul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 n1 = Integer.parseInt(display.getText());
                op = "*";
                display.setText("");
            }
        });
        // DIV button
        div.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 n1 = Integer.parseInt(display.getText());
                op = "/";
                display.setText("");
            }
        });
        equal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                n2  = Integer.parseInt(display.getText());

                if (op.equals("+"))
                    display.setText(String.valueOf(n1 + n2));

                if (op.equals("-"))
                    display.setText(String.valueOf(n1 - n2));

                if (op.equals("*"))
                    display.setText(String.valueOf(n1 * n2));

                if (op.equals("/"))
                    display.setText(String.valueOf(n1 / n2));
            }
        });
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.setText("");
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
