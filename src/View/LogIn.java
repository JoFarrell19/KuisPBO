package View;

import javax.swing.*;

public class LogIn {
    JFrame fLogIn;
    JPanel pLogIn;

    LogIn() {
        fLogIn = new JFrame("Log In");
        fLogIn.setSize(700, 1000);
        fLogIn.setLayout(null);
        fLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fLogIn.setVisible(true);
    }

    public static void main(String[] args) {
        new LogIn();
    }
}
