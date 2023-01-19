package com.patikadev.EX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Example extends JFrame {
    private JPanel wrapper;
    private JPanel wTop;
    private JPanel wBottom;
    private JButton btn_login;
    private JTextField fld_username;
    private JLabel lbl_username;
    private JPasswordField fld_password;
    private JLabel lbl_password;

    public Example(){
        for (UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
            if ("Nimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        setContentPane(wrapper);
        setSize(500,250);
        setTitle("Uygulama Adı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2;
        setLocation(x,y);

        setVisible(true);

        btn_login.addActionListener(e -> {
            if (fld_username.getText().length()==0 || fld_password.getText().length()==0){
                JOptionPane.showMessageDialog(null,"Tüm alanları doldurun!", "Hata", JOptionPane.WARNING_MESSAGE);
            }

        });

    }
}