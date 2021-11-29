package EMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;

public class Front_Page implements ActionListener{
    JFrame f;
    JLabel id, l;
    JButton btn;

    Front_Page(){
        f = new JFrame("Employee Management System");
        f.setSize(1000, 700);
        f.setLocation(300, 50);
        f.getContentPane().setBackground(Color.GREEN);
        f.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        l = new JLabel(new ImageIcon(i2));
        l.setBounds(0, 0, 1000, 700);
        f.add(l);

        id = new JLabel("EMPLOYEE MANAGEMENT SYSTEM", JLabel.CENTER);
        id.setBounds(10, 10, 980, 60);
        id.setFont(new Font("Elephant", Font.PLAIN, 40));
        id.setForeground(Color.RED);
        l.add(id);

        btn = new JButton("CLICK HERE TO CONTINUE");
        btn.setBackground(new Color(0, 128, 128));
        btn.setForeground(Color.red);
        btn.setFont(new Font("Lucida Calligraphy", Font.HANGING_BASELINE, 40));
        btn.setBounds(100, 500, 800, 70);
        btn.addActionListener(this);
        l.add(btn);


        f.setVisible(true);

        //For blinking of JLabel
        while(true){
            id.setVisible(false);
            try{
                Thread.sleep(500); //1000 = 1 second
            }catch (Exception e){e.printStackTrace();}
            id.setVisible(true);
            try {
                Thread.sleep(500);
            }catch (Exception e){e.printStackTrace();}
        }
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == btn){
            f.setVisible(false);
            new login();
        }
    }

    public static void main(String[] args){
        Front_Page f = new Front_Page();
    }
}
