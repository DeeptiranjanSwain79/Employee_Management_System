package EMS;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;

public class Print_Data implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25, l26, img;
    String id, name, fname, age, dob, address, city, state, phone, email, education, post, aadhaar;
    JButton print, cancel;

    Print_Data(String eid){
        Font font1 = new Font("Bell MT", Font.PLAIN, 25);
        Font font2 = new Font("Goudy Old Style", Font.PLAIN, 21);

        f = new JFrame("Print Employee Data");
        f.setSize(595, 642);
        f.setLocation(350, 50);
        f.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/print.jpg"));
        img = new JLabel(i1);
        img.setBounds(0, 0, 595, 642);
        f.add(img);

        try{
            Conn c = new Conn();
            ResultSet rs = c.stmt.executeQuery("select * from employee where id='"+eid+"'");
            while (rs.next()){
                name = rs.getString("name");
                fname = rs.getString("fname");
                age = rs.getString("age");
                dob = rs.getString("dob");
                education = rs.getString("education");
                post = rs.getString("post");
                id = rs.getString("id");
                address = rs.getString("address");
                city = rs.getString("city");
                state = rs.getString("state");
                phone = rs.getString("phone");
                email = rs.getString("email");
                aadhaar = rs.getString("aadhaar");
            }
        }catch (Exception e){e.printStackTrace();}

        l1 = new JLabel("Name");
        l1.setBounds(30, 20, 150, 30);
        l1.setFont(font1);
        img.add(l1);

        l2 = new JLabel(name);
        l2.setBounds(200, 20, 350, 30);
        l2.setFont(font2);
        img.add(l2);

        l3 = new JLabel("Father's Name");
        l3.setBounds(30, 60, 150, 30);
        l3.setFont(font1);
        img.add(l3);

        l4 = new JLabel(fname);
        l4.setBounds(200, 60, 350, 30);
        l4.setFont(font2);
        img.add(l4);

        l3 = new JLabel("Date of Birth");
        l3.setBounds(30, 100, 150, 30);
        l3.setFont(font1);
        img.add(l3);

        l4 = new JLabel(dob);
        l4.setBounds(200, 100, 350, 30);
        l4.setFont(font2);
        img.add(l4);

        l5 = new JLabel("Age");
        l5.setBounds(30, 140, 150, 30);
        l5.setFont(font1);
        img.add(l5);

        l6 = new JLabel(age);
        l6.setBounds(200, 140, 350, 30);
        l6.setFont(font2);
        img.add(l6);

        l7 = new JLabel("Education");
        l7.setBounds(30, 180, 150, 30);
        l7.setFont(font1);
        img.add(l7);

        l8 = new JLabel(education);
        l8.setBounds(200, 180, 350, 30);
        l8.setFont(font2);
        img.add(l8);

        l9 = new JLabel("Post");
        l9.setBounds(30, 220, 150, 30);
        l9.setFont(font1);
        img.add(l9);

        l10 = new JLabel(post);
        l10.setBounds(200, 220, 350, 30);
        l10.setFont(font2);
        img.add(l10);

        l11 = new JLabel("Employee ID");
        l11.setBounds(30, 260, 150, 30);
        l11.setFont(font1);
        img.add(l11);

        l12 = new JLabel(id);
        l12.setBounds(200, 260, 350, 30);
        l12.setFont(font2);
        img.add(l12);

        l13 = new JLabel("Address");
        l13.setBounds(30, 300, 150, 30);
        l13.setFont(font1);
        img.add(l13);

        l14 = new JLabel(address);
        l14.setBounds(200, 300, 350, 30);
        l14.setFont(font2);
        img.add(l14);

        l15 = new JLabel("City");
        l15.setBounds(30, 340, 150, 30);
        l15.setFont(font1);
        img.add(l15);

        l16 = new JLabel(city);
        l16.setBounds(200, 340, 350, 30);
        l16.setFont(font2);
        img.add(l16);

        l17 = new JLabel("State");
        l17.setBounds(30, 380, 150, 30);
        l17.setFont(font1);
        img.add(l17);

        l18 = new JLabel(state);
        l18.setBounds(200, 380, 350, 30);
        l18.setFont(font2);
        img.add(l18);

        l19 = new JLabel("Phone");
        l19.setBounds(30, 420, 150, 30);
        l19.setFont(font1);
        img.add(l19);

        l20 = new JLabel(phone);
        l20.setBounds(200, 420, 350, 30);
        l20.setFont(font2);
        img.add(l20);

        l21 = new JLabel("E-mail ID");
        l21.setBounds(30, 460, 150, 30);
        l21.setFont(font1);
        img.add(l21);

        l22 = new JLabel(email);
        l22.setBounds(200, 460, 350, 30);
        l22.setFont(font2);
        img.add(l22);

        l23 = new JLabel("AADHAAR");
        l23.setBounds(30, 500, 150, 30);
        l23.setFont(font1);
        img.add(l23);

        l24 = new JLabel(aadhaar);
        l24.setBounds(200, 500, 350, 30);
        l24.setFont(font2);
        img.add(l24);

        l25 = new JLabel("Employee ID");
        l25.setBounds(30, 530, 150, 30);
        l25.setFont(font1);
        img.add(l25);

        l26 = new JLabel(id);
        l26.setBounds(200, 530, 350, 30);
        l26.setFont(font2);
        img.add(l26);

        print = new JButton("Print");
        print.addActionListener(this);
        print.setBackground(Color.GREEN);
        print.setForeground(Color.BLACK);
        print.setFont(new Font("Lucida Calligraphy", Font.BOLD, 17));
        print.setBounds(100, 570, 100, 20);
        img.add(print);

        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.BLACK);
        cancel.setFont(new Font("Lucida Calligraphy", Font.BOLD, 17));
        cancel.setBounds(320, 570, 100, 20);
        img.add(cancel);

        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == print){
            JOptionPane.showMessageDialog(null, "Employee Data Printed Successfully");
            f.setVisible(false);
            new details();
        }else if (ae.getSource() == cancel){
            f.setVisible(false);
            new View_Employee();
        }

    }

    public static void main(String[] args) {
        new Print_Data("");
    }
}
