package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.*;
import Model.*;
import Controller.QuerryControl;
import Model.CategoryUser;

public class Registrasi implements ActionListener {
    JFrame fRegis;
    JPanel pRegis;
    JLabel lEmail, lNama, lPassword;
    JTextField tfEmail, tfNama;
    JPasswordField pfPassword;
    JButton btnRegis, btnBack;
    JComboBox<String> cbCategory;
    QuerryControl queryController = new QuerryControl();
    ArrayList<CategoryUser> categories = queryController.selectCategoryUser();

    Registrasi() {
        fRegis = new JFrame("Registration");
        fRegis.setSize(700, 1000);
        fRegis.setLayout(null);
        fRegis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pRegis = new JPanel();
        pRegis.setSize(700, 1000);
        pRegis.setBackground(Color.CYAN);
        pRegis.setLayout(null);
        pRegis.setVisible(true);

        lEmail = new JLabel("Masukan Email :");
        lEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        lEmail.setBounds(1, 10, 1000, 100);

        tfEmail = new JTextField();
        tfEmail.setBounds(120, 55, 200, 30);

        lNama = new JLabel("Masukan Nama :");
        lNama.setFont(new Font("Tahoma", Font.BOLD, 14));
        lNama.setBounds(1, 80, 1000, 100);

        tfNama = new JTextField();
        tfNama.setBounds(120, 120, 200, 30);

        lPassword = new JLabel("Masukan Password :");
        lPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lPassword.setBounds(1, 140, 1000, 100);

        pfPassword = new JPasswordField();
        pfPassword.setBounds(150, 180, 200, 30);

        String[] categoryList = new String[categories.size()];
        for (int i = 0; i < categories.size(); i++) {
            categoryList[i] = categories.get(i).getName();
        }
        cbCategory = new JComboBox<>(categoryList);
        cbCategory.setBounds(1, 220, 300, 50);

        btnRegis = new JButton("Registrasi");
        btnRegis.setBounds(1, 280, 100, 50);
        btnRegis.addActionListener(this);

        btnBack = new JButton("Back");
        btnBack.setBounds(1, 350, 100, 50);
        btnBack.addActionListener(this);

        pRegis.add(btnBack);
        pRegis.add(btnRegis);
        pRegis.add(cbCategory);
        pRegis.add(lPassword);
        pRegis.add(pfPassword);
        pRegis.add(lNama);
        pRegis.add(tfNama);
        pRegis.add(tfEmail);
        pRegis.add(lEmail);
        fRegis.add(pRegis);

        fRegis.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch (command) {
        case "Registrasi":
            String email = tfEmail.getText();
            String name = tfNama.getText();
            String password = String.valueOf(pfPassword.getPassword());
            String category = cbCategory.getSelectedItem().toString();

            if (email.equals("") || name.equals("") || password.equals("")) {
                JOptionPane.showMessageDialog(null, "Tolong isi dengan benar, masih ada yang kosong");
            } else if (password.length() < 8) {
                JOptionPane.showMessageDialog(null, "password terlalu pendek, harus lebih dari 8 huruf");
            } else {
                int idCategory = 0;
                for (int i = 0; i < categories.size(); i++) {
                    if (categories.get(i).getName().equals(category)) {
                        idCategory = categories.get(i).getIdCategory();
                    }
                }

                User user = new User(name, email, password, idCategory);
                boolean success = queryController.insertUser(user);

                if (success) {
                    JOptionPane.showMessageDialog(null, "Register Success");
                    fRegis.dispose();
                    new MainMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to register");
                }
            }
            break;
        case "Back":
            new MainMenu();
            fRegis.dispose();
            break;
        default:
            break;
        }
    }
}
