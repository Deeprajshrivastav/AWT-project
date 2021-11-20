import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MiniProject extends Frame implements ActionListener {

    MiniProject() {

        setTitle("Temperature Convertor");

        setLayout(new GridLayout(3, 1));

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        JTextField tf1 = new JTextField(" ", 1);

        Font bigFont = tf1.getFont().deriveFont(Font.PLAIN, 30f);
        Font small = tf1.getFont().deriveFont(Font.PLAIN, 22f);

        Label l1 = new Label("Enter the Temperature");
        JTextField text1 = new JTextField();

        Label l2 = new Label("The Result is ");
        JTextField text2 = new JTextField("");

        JButton box1 = new JButton("Convert to Celsius");
        JButton box2 = new JButton("Convert to Fahrenheit");
        JButton box3 = new JButton("Convert to Kelvin");


        FlowLayout layout = new FlowLayout();
        FlowLayout layout1 = new FlowLayout();

        layout.setVgap(30);
        layout1.setHgap(35);
        p1.setLayout(layout);
        p2.setLayout(layout1);

        text1.setPreferredSize(new Dimension(270, 50));
        text2.setPreferredSize(new Dimension(270, 50));

        text1.setFont(bigFont);
        text2.setFont(bigFont);

        l1.setFont(small);
        l2.setFont(small);

        box1.setFont(small);
        box2.setFont(small);
        box3.setFont(small);

        box1.setBorderPainted(true);
        box2.setBorderPainted(true);
        box3.setBorderPainted(true);

        box1.setBackground(Color.CYAN);
        box2.setBackground(Color.CYAN);
        box3.setBackground(Color.CYAN);

        box1.setForeground(Color.BLUE);
        box2.setForeground(Color.RED);
        box3.setForeground(Color.BLUE);

        text1.setBackground(Color.lightGray);
        text2.setBackground(Color.lightGray);

        text1.setForeground(Color.BLUE);
        text2.setForeground(Color.BLUE);

        l1.setForeground(Color.red);
        l2.setForeground(Color.red);

        text2.setEditable(false);

        p2.add(box1);
        p2.add(box2);
        p2.add(box3);

        p1.add(l1);
        p1.add(text1);

        p3.add(l2);
        p3.add(text2);

        add(p1, "North");
        add(p2, "Center");
        add(p3, "South");

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        box1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l2.setText("Celsius: ");
                text2.setText(text1.getText() + "C");
            }
        });

        box2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = text1.getText();
                int fahrenheit  = Integer.parseInt(temp);
                fahrenheit = (int) (fahrenheit * 1.8 + 32);
                l2.setText("Fahrenheit: ");
                text2.setText(fahrenheit + "F");
            }
        });

        box3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp = text1.getText();
                int kelvin = Integer.parseInt(temp);
                kelvin = kelvin + 273;
                l2.setText("Kelvin: ");
                text2.setText(kelvin + "K");
            }
        });

        setSize(830, 650);
        setVisible(true);
    }

    public static void main(String[] args) {
        MiniProject obj = new MiniProject();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
