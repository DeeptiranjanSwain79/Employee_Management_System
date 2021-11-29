package EMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Remove_Employee implements ActionListener {
    JFrame f;
    JTextField t;
    JLabel l1, l2, l3, l4, img, name, phone, email;
    JButton search, back, remove, cancel;

    Remove_Employee(){
        Font font1 = new Font("Bell MT", Font.BOLD, 25);
        Font font2 = new Font("Lucida Calligraphy", Font.BOLD, 15);
        Font font3 = new Font("Cambria", Font.PLAIN, 25);

        f = new JFrame("Remove Employee");
        f.setLayout(null);
        f.setSize(500, 500);
        f.setLocation(400, 100);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/remove.jpg"));
        img = new JLabel(i1);
        img.setBounds(0, 0, 500, 500);
        img.setLayout(null);
        f.add(img);

        l1 = new JLabel("Employee ID");
        l1.setBounds(30, 25, 250, 30);
        l1.setForeground(Color.WHITE);
        l1.setFont(font1);
        img.add(l1);

        t = new JTextField();
        t.setBounds(200, 25, 250, 30);
        t.setFont(font3);
        img.add(t);

        search = new JButton("Search");
        search.setBounds(200, 100, 100, 30);
        search.addActionListener(this);
        search.setBackground(Color.BLUE);
        search.setForeground(Color.WHITE);
        search.setFont(font2);
        img.add(search);

        back = new JButton("Back");
        back.setBounds(360, 100, 100, 30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(font2);
        img.add(back);

        l2 = new JLabel("Name");
        l2.setBounds(50, 150, 250, 30);
        l2.setForeground(Color.WHITE);
        l2.setFont(font1);
        l2.setVisible(false);
        img.add(l2);

        name = new JLabel();
        name.setBounds(200, 150, 250, 30);
        name.setForeground(Color.WHITE);
        name.setFont(font3);
        name.setVisible(false);
        img.add(name);

        l3 = new JLabel("Mobile No.");
        l3.setBounds(50, 200, 250, 30);
        l3.setForeground(Color.WHITE);
        l3.setFont(font1);
        l3.setVisible(false);
        img.add(l3);

        phone = new JLabel();
        phone.setBounds(200, 200, 250, 30);
        phone.setForeground(Color.WHITE);
        phone.setFont(font3);
        phone.setVisible(false);
        img.add(phone);

        l4 = new JLabel("E-mail ID");
        l4.setBounds(50, 250, 250, 30);
        l4.setForeground(Color.WHITE);
        l4.setFont(font1);
        l4.setVisible(false);
        img.add(l4);

        email = new JLabel();
        email.setBounds(200, 250, 300, 30);
        email.setForeground(Color.WHITE);
        email.setFont(font3);
        email.setVisible(false);
        img.add(email);

        remove = new JButton("Remove");
        remove.setBounds(70, 300, 150, 30);
        remove.addActionListener(this);
        remove.setBackground(Color.red);
        remove.setForeground(Color.WHITE);
        remove.setFont(font2);
        remove.setVisible(false);
        img.add(remove);

        cancel = new JButton("Cancel");
        cancel.setBounds(280, 300, 150, 30);
        cancel.addActionListener(this);
        cancel.setBackground(Color.CYAN);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(font2);
        cancel.setVisible(false);
        img.add(cancel);

        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == search){
            try{
                Conn con = new Conn();
                ResultSet rs = con.stmt.executeQuery("Select * from employee where id='"+t.getText()+"'");
                 int i=0;
                 if (rs.next()){
                     String name_ = rs.getString("name");
                     String mob_ = rs.getString("phone");
                     String email_ = rs.getString("email");

                     l2.setVisible(true);
                     l3.setVisible(true);
                     l4.setVisible(true);
                     name.setVisible(true);
                     phone.setVisible(true);
                     email.setVisible(true);
                     remove.setVisible(true);
                     cancel.setVisible(true);
                     i = 1;
                     name.setText(name_);
                     phone.setText(mob_);
                     email.setText(email_);

                 }
                 if (i == 0){
                     JOptionPane.showMessageDialog(null, "Employee ID NOT found.");
                 }

            }catch (Exception e){e.printStackTrace();}
        }else if (ae.getSource() == remove){
            try {
                Conn con = new Conn();
                con.stmt.executeUpdate("delete from employee where id='"+t.getText()+"'");
                JOptionPane.showMessageDialog(null, "Employee data DELETED Successfully");
                l2.setVisible(true);
                l3.setVisible(true);
                l4.setVisible(true);
                name.setVisible(true);
                phone.setVisible(true);
                email.setVisible(true);
                remove.setVisible(true);
                cancel.setVisible(true);

            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Exception occurred while deleting data\n"+e);
            }
        }else if (ae.getSource() == back){
            f.setVisible(false);
            new details();
        }else if (ae.getSource() == cancel){
            f.setVisible(false);
            new details();
        }
    }

    public static void main(String[] args) {
        new Remove_Employee();
    }
}
