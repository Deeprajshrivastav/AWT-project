import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


class StringOperator {
    String word;

    public StringOperator(String word) {
        this.word = word;
    }

    String length() {
        String ans = Integer.toString(word.length());
        return ans;
    }

    String lowerCase() {
        return word.toLowerCase();
    }

    String upperCase() {
        return word.toUpperCase();
    }

    String HashCode() {
        String ans = Integer.toString(word.hashCode());
        return ans;
    }
}


public class MiniProject extends Frame implements ActionListener {

    MiniProject() {

        setTitle("String Operator");

        setLayout(new GridLayout(3, 1));

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        JTextField tf1 = new JTextField(" ", 1);

        Font bigFont = tf1.getFont().deriveFont(Font.PLAIN, 30f);
        Font small = tf1.getFont().deriveFont(Font.PLAIN, 25f);

        Label l1 = new Label("Enter the string");
        JTextField text1 = new JTextField("");

        Label l2 = new Label("The Result is ");
        JTextField text2 = new JTextField("");

        JCheckBox box1 = new JCheckBox("Length");
        JCheckBox box2 = new JCheckBox("Upper Case");
        JCheckBox box3 = new JCheckBox("Lower Case");
        JCheckBox box4 = new JCheckBox("Hash Code");

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
                StringOperator ass = new StringOperator(text1.getText());
                l2.setText("Length: ");
                text2.setText(ass.length());
                box2.setSelected(false);
                box3.setSelected(false);
                box4.setSelected(false);
            }
        });

        box2.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED){
                StringOperator ass = new StringOperator(text1.getText());
                l2.setText("Upper Case: ");
                text2.setText(ass.upperCase());
                box1.setSelected(false);
                box3.setSelected(false);
                box4.setSelected(false);
            }
        });

        box3.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED){
                StringOperator ass = new StringOperator(text1.getText());
                l2.setText("Lower Case: ");
                text2.setText(ass.lowerCase());
                box1.setSelected(false);
                box2.setSelected(false);
                box4.setSelected(false);
            }
        });

        box4.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED){
                StringOperator ass = new StringOperator(text1.getText());
                l2.setText("Hash Code: ");
                text2.setText(ass.HashCode());
                box1.setSelected(false);
                box2.setSelected(false);
                box3.setSelected(false);
            }
        });

        setSize(760, 650);
        setVisible(true);

    }

    public static void main(String[] args) {
        MiniProject obj = new MiniProject();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
