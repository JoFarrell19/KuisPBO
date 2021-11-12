package View;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class Registrasi {
    JFrame fRegis;
    JPanel pRegis;
    JLabel lEmail, lNama, lPassword;
    JTextField tfEmail, tfNama;
    JPasswordField pfPassword;
    
    Registrasi() {
        fRegis = new JFrame("Log In");
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


        pRegis.add(lPassword);
        pRegis.add(pfPassword);
        pRegis.add(lNama);
        pRegis.add(tfNama);
        pRegis.add(tfEmail);
        pRegis.add(lEmail);
        fRegis.add(pRegis);
        fRegis.setVisible(true);
    }

    public static void main(String[] args) {
        new Registrasi();
    }
}
