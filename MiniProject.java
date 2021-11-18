import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


class MathLogic {
    int number;

    public MathLogic(String number) {
        this.number = Integer.parseInt(number);
    }

    String Factorial() {
        int ans = 1;
        for (int i=1; i<=number; i++)
            ans *= i;
        return Integer.toString(ans);
    }

    String sumOfDigit() {
        int sum = 0;
        while (number > 0){
            sum = sum + number % 10;
            number = number / 10;
        }
        return Integer.toString(sum);
    }

    String reverseNumber() {
        int revNum = 0;
        while (number > 0) {
            int rem = number % 10;
            revNum = revNum * 10 +  rem;
            number = number /10;
        }
        return Integer.toString(revNum);
    }

    String isPrime() {
        for (int i=2; i<number; i++)
            if ((number % i) == 0)
                return "Not a prime number";
        return "Prime number";
    }
}


public class MiniProject extends Frame implements ActionListener {

    MiniProject() {

        setTitle("Math Logic-One");

        setLayout(new GridLayout(3, 1));

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        JTextField tf1 = new JTextField(" ", 1);

        Font bigFont = tf1.getFont().deriveFont(Font.PLAIN, 30f);
        Font small = tf1.getFont().deriveFont(Font.PLAIN, 25f);

        Label l1 = new Label("Enter the Number");
        JTextField text1 = new JTextField();

        Label l2 = new Label("The Result is ");
        JTextField text2 = new JTextField("");

        JCheckBox box1 = new JCheckBox("Factorial");
        JCheckBox box2 = new JCheckBox("Sum of digits");
        JCheckBox box3 = new JCheckBox("Reverse number");
        JCheckBox box4 = new JCheckBox("Is prime");

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
        box4.setFont(small);

        box1.setBorderPainted(true);
        box2.setBorderPainted(true);
        box3.setBorderPainted(true);
        box4.setBorderPainted(true);

        box1.setBackground(Color.cyan);
        box2.setBackground(Color.cyan);
        box3.setBackground(Color.cyan);
        box4.setBackground(Color.cyan);

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
        p2.add(box4);

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

        box1.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED){
                MathLogic mathObj = new MathLogic(text1.getText());
                l2.setText("Factorial: ");
                text2.setText(mathObj.Factorial());
                box2.setSelected(false);
                box3.setSelected(false);
                box4.setSelected(false);
            }
        });

        box2.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED){
                MathLogic mathObj = new MathLogic(text1.getText());
                l2.setText("Sum of digit: ");
                text2.setText(mathObj.sumOfDigit());
                box1.setSelected(false);
                box3.setSelected(false);
                box4.setSelected(false);
            }
        });

        box3.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED){
                MathLogic mathObj = new MathLogic(text1.getText());
                l2.setText("Reverse: ");
                text2.setText(mathObj.reverseNumber());
                box1.setSelected(false);
                box2.setSelected(false);
                box4.setSelected(false);
            }
        });

        box4.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED){
                MathLogic mathObj = new MathLogic(text1.getText());
                l2.setText("Is prime: ");
                text2.setText(mathObj.isPrime());
                box1.setSelected(false);
                box2.setSelected(false);
                box3.setSelected(false);
            }
        });

        setSize(800, 650);
        setVisible(true);
    }

    public static void main(String[] args) {
        MiniProject obj = new MiniProject();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
