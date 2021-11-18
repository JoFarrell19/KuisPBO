package View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Controller.QuerryControl;
import Model.*;

public class MenuProfile implements ActionListener {
    QuerryControl querryControl = new QuerryControl();
    User user;
    JFrame fMenuProfile;
    JPanel pMenuProfile;
    JLabel lEmail, lNama, lPassword, lCategory;
    JTextField tfEmail, tfNama, tfCategory;
    JPasswordField pfPassword;
    JButton btnSimpan, btnHapus, btnBack;
    QuerryControl queryController = new QuerryControl();
    JComboBox<String> cbCategory;
    ArrayList<CategoryUser> categories = queryController.selectCategoryUser();

    public MenuProfile(User user) {
        fMenuProfile = new JFrame();
        fMenuProfile.setSize(700, 1000);
        fMenuProfile.setLayout(null);
        fMenuProfile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pMenuProfile = new JPanel();
        pMenuProfile.setBackground(Color.yellow);
        pMenuProfile.setSize(700, 1000);
        pMenuProfile.setLayout(null);

        lEmail = new JLabel("Email : ");
        lEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        lEmail.setBounds(1, 12, 1000, 100);

        tfEmail = new JTextField();
        tfEmail.setBounds(55, 50, 200, 30);

        lNama = new JLabel("Nama : ");
        lNama.setFont(new Font("Tahoma", Font.BOLD, 14));
        lNama.setBounds(1, 70, 1000, 100);

        tfNama = new JTextField();
        tfNama.setBounds(55, 110, 200, 30);

        lPassword = new JLabel("Password : ");
        lPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lPassword.setBounds(1, 120, 1000, 100);

        pfPassword = new JPasswordField();
        pfPassword.setBounds(80, 160, 200, 30);

        lCategory = new JLabel("Category : ");
        lCategory.setFont(new Font("Tahoma", Font.BOLD, 14));
        lCategory.setBounds(1, 170, 1000, 100);

        String[] categoryList = new String[categories.size()];
        for (int i = 0; i < categories.size(); i++) {
            categoryList[i] = categories.get(i).getName();
        }
        cbCategory = new JComboBox<>(categoryList);
        cbCategory.setBounds(90, 200, 300, 50);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(1, 270, 100, 50);
        btnSimpan.addActionListener(this);

        btnHapus = new JButton("Hapus");
        btnHapus.setBounds(105, 270, 100, 50);
        btnHapus.addActionListener(this);

        btnBack = new JButton("Back");
        btnBack.setBounds(210, 270, 100, 50);
        btnBack.addActionListener(this);

        pMenuProfile.add(cbCategory);
        pMenuProfile.add(btnSimpan);
        pMenuProfile.add(btnHapus);
        pMenuProfile.add(btnBack);
        pMenuProfile.add(lCategory);
        pMenuProfile.add(lPassword);
        pMenuProfile.add(pfPassword);
        pMenuProfile.add(lNama);
        pMenuProfile.add(tfNama);
        pMenuProfile.add(tfEmail);
        pMenuProfile.add(lEmail);
        fMenuProfile.add(pMenuProfile);
        fMenuProfile.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch (command) {
        case "Simpan":
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
                User updatedUser = new User(name, email, password, idCategory);
                boolean success = queryController.updateUser(user.getIdUser(), updatedUser);

                if (success) {
                    JOptionPane.showMessageDialog(null, "Update success");
                } else {
                    JOptionPane.showMessageDialog(null, "Update failed");
                }
            }
            fMenuProfile.dispose();
            new MainMenu();

            break;
        case "Hapus":
            boolean success = queryController.deleteUser(user.getIdUser());
            if (success) {
                JOptionPane.showMessageDialog(null, "Deleted");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete");
            }
            new MainMenu();
            fMenuProfile.dispose();
            break;
        case "Back":
            new MainMenu();
            fMenuProfile.dispose();
            break;
        default:
            break;
        }

    }
}
