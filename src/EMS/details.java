package EMS;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class details implements ActionListener{
    JFrame f;
    JLabel img, l;
    JButton add, view, remove, update;
    details(){
        f = new JFrame("Details");
        f.setLayout(null);
        f.setBackground(Color.WHITE);
        f.setSize(700, 500);
        f.setLocation(300, 150);

        img = new JLabel();
        img.setBounds(0, 0, 700, 500);
        img.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/details.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
        img.setIcon(i1);
        f.add(img);

        l = new JLabel("Employee Details", JLabel.CENTER);
        l.setBounds(10, 20, 680, 40);
        l.setFont(new Font("Elephant", Font.BOLD, 35));
        l.setForeground(Color.black);
        img.add(l);

        add = new JButton("Add");
        add.setBounds(350, 80, 100, 40);
        add.setFont(new Font("STENCIL", Font.PLAIN, 15));
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLUE);
        add.addActionListener(this);
        img.add(add);

        view = new JButton("View");
        view.setBounds(500, 80, 100, 40);
        view.setFont(new Font("STENCIL", Font.PLAIN, 15));
        view.setForeground(Color.BLACK);
        view.setBackground(Color.GREEN);
        view.addActionListener(this);
        img.add(view);

        update = new JButton("Update");
        update.setBounds(350, 150, 100, 40);
        update.setFont(new Font("STENCIL", Font.PLAIN, 15));
        update.setForeground(Color.BLACK);
        update.setBackground(Color.YELLOW);
        update.addActionListener(this);
        img.add(update);

        remove = new JButton("Remove");
        remove.setBounds(500, 150, 100, 40);
        remove.setFont(new Font("STENCIL", Font.PLAIN, 15));
        remove.setForeground(Color.WHITE);
        remove.setBackground(Color.RED);
        remove.addActionListener(this);
        img.add(remove);

        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            new Add_Employee();
            f.setVisible(false);
        }else if(ae.getSource() == view){
            new View_Employee();
            f.setVisible(false);
        }else if (ae.getSource() == update){
            new Search_Employee();
            f.setVisible(false);
        }else if(ae.getSource() == remove){
            new Remove_Employee();
            f.setVisible(false);
        }
    }
    public static void main(String[] args){
        details d = new details();
    }
}
