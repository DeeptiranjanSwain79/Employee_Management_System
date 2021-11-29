package EMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class login implements ActionListener{
    JFrame f;
    JLabel l1, l2;
    JTextField tf;
    JPasswordField pf;
    JButton login, cancel;

    login(){
        f = new JFrame("Login");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        f.setSize(600, 300);
        f.setLocation(200, 200);


        l1 = new JLabel("Username");
        l1.setBounds(40, 20, 100, 25);
        f.add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40, 70, 100, 25);
        f.add(l2);

        tf = new JTextField();
        tf.setBounds(150, 20, 150, 25);
        f.add(tf);

        pf = new JPasswordField();
        pf.setBounds(150, 70, 150, 25);
        f.add(pf);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(230, 230, Image.SCALE_DEFAULT);
        JLabel img = new JLabel(new ImageIcon(i2));
        img.setBounds(330, 25, 230, 230);
        f.add(img);

        login = new JButton("Login");
        login.setBackground(Color.BLUE);
        login.setForeground(Color.WHITE);
        login.setBounds(100, 140, 120, 30);
        login.addActionListener(this);
        f.add(login);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(100, 190, 120, 30);
        cancel.addActionListener(this);
        f.add(cancel);


        f.setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String username = tf.getText();
            String password = pf.getText();
            try{
                Conn c = new Conn();
                ResultSet rs = c.stmt.executeQuery("select * from login where username='"+username+"'and password='"+password+"'");
                if (rs.next()){
                    new details();
                    f.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Credentials");
                    f.setVisible(false);
                }
            }catch (Exception e){e.printStackTrace();}
        }else if (ae.getSource() == cancel){
            f.setVisible(false);
            JOptionPane.showMessageDialog(null, "Thank You!\nVisit Again");
        }

    }

    public static void main(String[] args) {
        login l = new login();
    }
}
