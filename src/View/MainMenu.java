package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenu implements ActionListener {
    JFrame fMenuAwal;
    JPanel pMenuAwal;
    JButton btnLogin;
    JButton btnRegistrasi;
    JButton btnLihatDataPengguna;

    MainMenu() {
        fMenuAwal = new JFrame("Menu Awal");
        fMenuAwal.setSize(300, 600);
        fMenuAwal.setLayout(null);
        fMenuAwal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pMenuAwal = new JPanel();
        pMenuAwal.setSize(300, 600);
        pMenuAwal.setBackground(Color.yellow);
        pMenuAwal.setLayout(null);
        pMenuAwal.setVisible(true);

        btnLogin = new JButton("Log In");
        btnLogin.setBounds(5, 5, 200, 100);
        btnLogin.addActionListener(this);

        btnRegistrasi = new JButton("Registrasi");
        btnRegistrasi.setBounds(5, 150, 200, 100);
        btnRegistrasi.addActionListener(this);

        btnLihatDataPengguna = new JButton("Lihat Data");
        btnLihatDataPengguna.setBounds(5, 300, 200, 100);
        btnLihatDataPengguna.addActionListener(this);

        pMenuAwal.add(btnLihatDataPengguna);
        pMenuAwal.add(btnRegistrasi);
        pMenuAwal.add(btnLogin);
        fMenuAwal.add(pMenuAwal);
        fMenuAwal.setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenu();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch (command) {
        case "Log In":
            new LogIn();
            break;
        case "Registrasi":
            new Registrasi();
            break;
        case "Lihat Data":
            new LihatData();
            break;
        default:
            throw new AssertionError();
        }
    }
}
