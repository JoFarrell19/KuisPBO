package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;
import java.awt.Color;
import java.awt.Image;
import java.awt.Font;
import Controller.QuerryControl;
import Model.User;

public class LogIn implements ActionListener {
    JFrame fLogIn;
    JPanel pLogIn;
    JLabel img, lEmail, lPassword;

    JTextField tfEmail;
    JPasswordField pfPassword;
    JButton btnLogIn, btnBack;

    LogIn() {
        fLogIn = new JFrame("Log In");
        fLogIn.setSize(700, 1000);
        fLogIn.setLayout(null);
        fLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pLogIn = new JPanel();
        pLogIn.setSize(700, 1000);
        pLogIn.setBackground(Color.white);
        pLogIn.setLayout(null);
        pLogIn.setVisible(true);

        ImageIcon logo = new ImageIcon("src\\Source\\53d.jpg");
        Image scaleImage = logo.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        img = new JLabel();
        img.setIcon(new ImageIcon(scaleImage));
        img.setBounds(1, 1, 100, 100);

        lEmail = new JLabel("Masukan Email : ");
        lEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        lEmail.setBounds(1, 150, 1000, 100);

        tfEmail = new JTextField();
        tfEmail.setBounds(120, 190, 200, 30);

        lPassword = new JLabel("Masukan Password : ");
        lPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lPassword.setBounds(1, 190, 1000, 100);

        pfPassword = new JPasswordField();
        pfPassword.setBounds(150, 230, 200, 30);

        btnLogIn = new JButton("Log In");
        btnLogIn.setBounds(1, 280, 100, 50);
        btnLogIn.addActionListener(this);

        btnBack = new JButton("Back");
        btnBack.setBounds(1, 340, 100, 50);
        btnBack.addActionListener(this);

        pLogIn.add(btnLogIn);
        pLogIn.add(btnBack);
        pLogIn.add(lPassword);
        pLogIn.add(pfPassword);
        pLogIn.add(lEmail);
        pLogIn.add(tfEmail);
        pLogIn.add(img);
        fLogIn.add(pLogIn);
        fLogIn.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch (command) {
        case "Log In":
            String email = tfEmail.getText();
            String password = String.valueOf(pfPassword.getPassword());
            
            if (email.equals("") && password.equals("")) {
                JOptionPane.showMessageDialog(null, "Nama dan Email Kosong", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                QuerryControl qControl = new QuerryControl();
                User user = qControl.selectUser(email, password);
                if (user != null) {
                    new MenuProfile(user);
                    fLogIn.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "User tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            break;
        case "Back":
            new MainMenu();
            fLogIn.dispose();
            break;
        default:
            throw new AssertionError();
        }
    }
}
