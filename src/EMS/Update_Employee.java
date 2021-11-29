package EMS;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;

public class Update_Employee implements ActionListener{
    JFrame f;
    JLabel img, l1, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
    JTextField name, fname, age, dob, education, post, address, city, state, phone, email, aadhaar;
    JButton update, cancel;
    String id;

    Update_Employee(String eid){
        this.id = eid;
        Font font1 = new Font("Bell MT", Font.BOLD, 25);
        Font font2 = new Font("Goudy Old Style", Font.PLAIN, 21);

        f = new JFrame("Update Employee Information");
        f.setSize(900, 650);
        f.setLocation(350, 50);
        f.setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 650, Image.SCALE_DEFAULT);
        img = new JLabel(new ImageIcon(i2));
        img.setBounds(0, 0, 900, 650);
        f.add(img);

        JLabel title = new JLabel("Update Employee Details", JLabel.CENTER);
        title.setBounds(10, 10, 880, 50);
        title.setForeground(Color.BLUE);
        title.setFont(new Font("Elephant", Font.BOLD, 40));
        img.add(title);

        l1 = new JLabel("Name");
        l1.setBounds(50, 100, 200, 30);
        l1.setForeground(Color.RED);
        l1.setFont(font1);
        img.add(l1);

        name = new JTextField();
        name.setBounds(200, 100, 200, 30);
        name.setFont(font2);
        img.add(name);

        l3 = new JLabel("Father's Name");
        l3.setBounds(500, 100, 200, 30);
        l3.setFont(font1);
        l3.setForeground(Color.RED);
        img.add(l3);

        fname = new JTextField();
        fname.setBounds(680, 100, 200, 30);
        fname.setFont(font2);
        img.add(fname);

        l4 = new JLabel("Age");
        l4.setBounds(50, 150, 200, 30);
        l4.setFont(font1);
        l4.setForeground(Color.RED);
        img.add(l4);

        age = new JTextField();
        age.setBounds(200, 150, 200, 30);
        age.setFont(font2);
        img.add(age);

        l5 = new JLabel("DOB");
        l5.setBounds(500, 150, 200, 30);
        l5.setFont(font1);
        l5.setForeground(Color.RED);
        img.add(l5);

        dob = new JTextField();
        dob.setBounds(680, 150, 200, 30);
        dob.setFont(font2);
        img.add(dob);

        l6 = new JLabel("Address");
        l6.setBounds(50, 200, 200, 30);
        l6.setFont(font1);
        l6.setForeground(Color.RED);
        img.add(l6);

        address = new JTextField();
        address.setBounds(200, 200, 200, 30);
        address.setFont(font2);
        img.add(address);

        l7 = new JLabel("City");
        l7.setBounds(500, 200, 200, 30);
        l7.setFont(font1);
        l7.setForeground(Color.RED);
        img.add(l7);

        city = new JTextField();
        city.setBounds(680, 200, 200, 30);
        city.setFont(font2);
        img.add(city);

        l8 = new JLabel("State");
        l8.setBounds(50, 250, 200, 30);
        l8.setFont(font1);
        l8.setForeground(Color.RED);
        img.add(l8);

        state = new JTextField();
        state.setBounds(200, 250, 200, 30);
        state.setFont(font2);
        img.add(state);

        l9 = new JLabel("Phone");
        l9.setBounds(500, 250, 200, 30);
        l9.setFont(font1);
        l9.setForeground(Color.RED);
        img.add(l9);

        phone = new JTextField();
        phone.setBounds(680, 250, 200, 30);
        phone.setFont(font2);
        img.add(phone);

        l10 = new JLabel("E-mail ID");
        l10.setBounds(50, 300, 200, 30);
        l10.setFont(font1);
        l10.setForeground(Color.RED);
        img.add(l10);

        email = new JTextField();
        email.setBounds(200, 300, 200, 30);
        email.setFont(font2);
        img.add(email);

        l11 = new JLabel("Education");
        l11.setBounds(500, 300, 200, 30);
        l11.setFont(font1);
        l11.setForeground(Color.RED);
        img.add(l11);

        education = new JTextField();
        education.setBounds(680, 300, 200, 30);
        education.setFont(font2);
        img.add(education);


        l12 = new JLabel("Post");
        l12.setBounds(50, 350, 200, 30);
        l12.setFont(font1);
        l12.setForeground(Color.RED);
        img.add(l12);

        post = new JTextField();
        post.setBounds(200, 350, 200, 30);
        post.setFont(font2);
        img.add(post);

        l13 = new JLabel("AADHAAR No.");
        l13.setBounds(50, 400, 200, 30);
        l13.setFont(new Font("Cambria", Font.BOLD, 20));
        l13.setForeground(Color.RED);
        img.add(l13);

        aadhaar = new JTextField();
        aadhaar.setBounds(200, 400, 200, 30);
        aadhaar.setFont(font2);
        img.add(aadhaar);

        update = new JButton("Update");
        update.setBackground(Color.GREEN);
        update.setForeground(Color.WHITE);
        update.setBounds(380, 480, 120, 35);
        update.addActionListener(this);
        update.setFont(new Font("Latin", Font.PLAIN, 25));
        img.add(update);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(380, 550, 120, 35);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Latin", Font.PLAIN, 25));
        img.add(cancel);

        showData(id);

        f.setVisible(true);
    }

    int i = 0;
    void showData(String ID){
        try{
            Conn c = new Conn();
            ResultSet rs = c.stmt.executeQuery("Select * from employee where id='"+ID+"'");
            if (rs.next()){
                i = 1;
                name.setText(rs.getString("name"));
                fname.setText(rs.getString("fname"));
                age.setText(rs.getString("age"));
                dob.setText(rs.getString("dob"));
                education.setText(rs.getString("education"));
                post.setText(rs.getString("post"));
                address.setText(rs.getString("address"));
                email.setText(rs.getString("email"));
                city.setText(rs.getString("city"));
                state.setText(rs.getString("state"));
                aadhaar.setText(rs.getString("aadhaar"));
                phone.setText(rs.getString("phone"));
            }
            if (i == 0){
                JOptionPane.showMessageDialog(null, "ID NOT FOUND!!!");
//                new Search_Employee();
                f.setVisible(false);
            }
        }catch (Exception e){e.printStackTrace();}
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == update){
            String name_ = name.getText();
            String fname_ = fname.getText();
            String dob_ = dob.getText();
            String age_ = age.getText();
            String address_ = address.getText();
            String city_ = city.getText();
            String state_ = state.getText();
            String education_ = education.getText();
            String email_ = email.getText();
            String post_ = post.getText();
            long phone_ = Long.parseLong(phone.getText());
            long aadhaar_ = Long.parseLong(aadhaar.getText());

            String q = "update employee set name='"+name_+"', fname='"+fname_+"', dob='"+dob_+"', age='"+age_+"', address='"+address_+"'" +
                    ",city='"+city_+"', state='"+state_+"', education='"+education_+"', email='"+email_+"', post='"+post_+"', phone="+phone_+"" +
                    ",aadhaar="+aadhaar_+" where id='"+id+"'";
//            System.out.println(q);
            try{
                Conn c = new Conn();
                c.stmt.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Employee data UPDATED Successfully");
            }catch (Exception e){e.printStackTrace();}

        }else if(ae.getSource() == cancel){
            f.setVisible(false);
            new details();
        }
    }

    public static void main(String[] args){
        new Update_Employee("412");
    }
}
