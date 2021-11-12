package View;

import java.awt.Color;
import javax.swing.*;

public class Registrasi {
    JFrame fRegis;
    JPanel pRegis;

    Registrasi() {
        fRegis = new JFrame("Log In");
        fRegis.setSize(700, 1000);
        fRegis.setLayout(null);
        fRegis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pRegis = new JPanel();
        pRegis.setSize(700, 1000);
        pRegis.setBackground(Color.red);
        pRegis.setLayout(null);
        pRegis.setVisible(true);

        fRegis.add(pRegis);
        fRegis.setVisible(true);
    }

    public static void main(String[] args) {
        new Registrasi();
    }
}
