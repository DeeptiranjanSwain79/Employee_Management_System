package EMS;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Add_Employee implements ActionListener  {
    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, img;
    JTextField name, fname, age, dob, address, city, state, phone, email, post, aadhaar, id;
    JButton submit, cancel;
    Choice c;

    Add_Employee(){
        f = new JFrame("Employee Registration Form");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        f.setSize(900, 700);
        f.setLocation(150, 50);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/add_employee.jpg"));
        img = new JLabel();
        img.setBounds(0, 0, 900, 700);
        img.setIcon(i1);
        img.setLayout(null);
        f.add(img);

        l1 = new JLabel("New Employee Details", JLabel.CENTER);
        l1.setBounds(10, 10, 880, 40);
        l1.setFont(new Font("Elephant", Font.PLAIN, 35));
        img.add(l1);

        l2 = new JLabel("Name");
        l2.setBounds(50, 100, 200, 30);
        l2.setFont(new Font("Cambria", Font.BOLD, 20));
        img.add(l2);

        name = new JTextField();
        name.setBounds(200, 100, 200, 30);
        img.add(name);

        l3 = new JLabel("Father's Name");
        l3.setBounds(500, 100, 200, 30);
        l3.setFont(new Font("Cambria", Font.BOLD, 20));
        img.add(l3);

        fname = new JTextField();
        fname.setBounds(680, 100, 200, 30);
        img.add(fname);

        l4 = new JLabel("Age");
        l4.setBounds(50, 150, 200, 30);
        l4.setFont(new Font("Cambria", Font.BOLD, 20));
        img.add(l4);

        age = new JTextField();
        age.setBounds(200, 150, 200, 30);
        img.add(age);

        l5 = new JLabel("DOB(dd/mm/yyyy)");
        l5.setBounds(500, 150, 200, 30);
        l5.setFont(new Font("Cambria", Font.BOLD, 20));
        img.add(l5);

        dob = new JTextField();
        dob.setBounds(680, 150, 200, 30);
        img.add(dob);

        l6 = new JLabel("Address");
        l6.setBounds(50, 200, 200, 30);
        l6.setFont(new Font("Cambria", Font.BOLD, 20));
        img.add(l6);

        address = new JTextField();
        address.setBounds(200, 200, 200, 30);
        img.add(address);

        l7 = new JLabel("City");
        l7.setBounds(500, 200, 200, 30);
        l7.setFont(new Font("Cambria", Font.BOLD, 20));
        l7.setForeground(Color.RED);
        img.add(l7);

        city = new JTextField();
        city.setBounds(680, 200, 200, 30);
        img.add(city);

        l8 = new JLabel("State");
        l8.setBounds(50, 250, 200, 30);
        l8.setFont(new Font("Cambria", Font.BOLD, 20));
        img.add(l8);

        state = new JTextField();
        state.setBounds(200, 250, 200, 30);
        img.add(state);

        l9 = new JLabel("Phone");
        l9.setBounds(500, 250, 200, 30);
        l9.setFont(new Font("Cambria", Font.BOLD, 20));
        img.add(l9);

        phone = new JTextField();
        phone.setBounds(680, 250, 200, 30);
        img.add(phone);

        l10 = new JLabel("E-mail ID");
        l10.setBounds(50, 300, 200, 30);
        l10.setFont(new Font("Cambria", Font.BOLD, 20));
        img.add(l10);

        email = new JTextField();
        email.setBounds(200, 300, 200, 30);
        img.add(email);

        l11 = new JLabel("Education");
        l11.setBounds(500, 300, 200, 30);
        l11.setFont(new Font("Cambria", Font.BOLD, 20));
        img.add(l11);

        c = new Choice();
        c.setBounds(700, 300, 200, 30);
        c.setFont(new Font("Cambria", Font.BOLD, 17));
        c.add("Matriculation");
        c.add("Intermediate");
        c.add("Graduate");
        c.add("Post-Graduate");
        c.add("Doctorate");
        img.add(c);


        l12 = new JLabel("Post");
        l12.setBounds(50, 350, 200, 30);
        l12.setFont(new Font("Cambria", Font.BOLD, 20));
        img.add(l12);

        post = new JTextField();
        post.setBounds(200, 350, 200, 30);
        img.add(post);

        l13 = new JLabel("AADHAAR No.");
        l13.setBounds(50, 400, 200, 30);
        l13.setFont(new Font("Cambria", Font.BOLD, 20));
        img.add(l13);

        aadhaar = new JTextField();
        aadhaar.setBounds(200, 400, 200, 30);
        img.add(aadhaar);

        l14 = new JLabel("Employee ID");
        l14.setBounds(50, 450, 200, 30);
        l14.setFont(new Font("Cambria", Font.BOLD, 20));
        img.add(l14);

        id = new JTextField();
        id.setBounds(200, 450, 200, 30);
        img.add(id);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        submit.setBounds(380, 530, 120, 35);
        submit.addActionListener(this);
        submit.setFont(new Font("Latin", Font.PLAIN, 25));
        img.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(380, 600, 120, 35);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Latin", Font.PLAIN, 25));
        img.add(cancel);

        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String name_ = name.getText();
            String fname_ = fname.getText();
            String dob_ = dob.getText();
            String age_ = age.getText();
            String address_ = address.getText();
            String city_ = city.getText();
            String state_ = state.getText();
            String education_ = c.getSelectedItem();
            String email_ = email.getText();
            String post_ = post.getText();
            String id_ = id.getText();
            long phone_ = Long.parseLong(phone.getText());
            long aadhaar_ = Long.parseLong(aadhaar.getText());

            String q = "insert into employee (name, fname, dob, age, address, city, state, education, email, post, id, phone, aadhaar) values " +
                    "('"+name_+"', '"+fname_+"', '"+dob_+"', '"+age_+"', '"+address_+"', '"+city_+"', '"+state_+"', '"+education_+"'," +
                    "'"+email_+"', '"+post_+"', '"+id_+"', "+phone_+", "+aadhaar_+")";

            try{
                Conn con = new Conn();
                con.stmt.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "New Employee Details inserted Successfully");
                f.setVisible(false);
                new details();
            }catch (Exception e){e.printStackTrace();}

        }else if (ae.getSource() == cancel){
            f.setVisible(false);
            new details();
        }
    }
    public static void main(String[] args){
        Add_Employee ae = new Add_Employee();
    }
}
