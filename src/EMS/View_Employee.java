package EMS;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.*;

public class View_Employee implements ActionListener {
    JFrame f;
    JTextField t;
    JLabel l1, l2;
    JButton search, cancel;

    View_Employee(){
        f = new JFrame("View Employee");
        f.getContentPane().setBackground(Color.GREEN);
        f.setSize(500, 270);
        f.setLocation(400, 200);
        f.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/view.jpg"));
        l1 = new JLabel(i1);
        l1.setBounds(0, 0, 500, 270);
        f.setLayout(null);
        f.add(l1);

        l2 = new JLabel("Employee ID");
        l2.setBounds(40, 60, 250, 30);
        l2.setFont(new Font("Cambria", Font.PLAIN, 20));
        l2.setForeground(Color.WHITE);
        l1.add(l2);

        t = new JTextField();
        t.setBounds(250, 60, 150, 30);
        l1.add(t);

        search = new JButton("Search");
        search.setBounds(200, 120, 100, 35);
        search.setBackground(Color.GREEN);
        search.setForeground(Color.BLACK);
        search.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
        search.addActionListener(this);
        l1.add(search);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 190, 100, 35);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.BLACK);
        cancel.setFont(new Font("Lucida Calligraphy", Font.BOLD, 15));
        cancel.addActionListener(this);
        l1.add(cancel);

        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == search){
            f.setVisible(false);
            try {
                Print_Data p = new Print_Data(t.getText());
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Invalid \nEmployee ID");
            }
        }else if(ae.getSource() == cancel){
            f.setVisible(false);
            details d = new details();
        }
    }

    public static void main(String[] main){
        View_Employee v = new View_Employee();
    }
}
