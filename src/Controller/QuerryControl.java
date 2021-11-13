package Controller;

import Model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class QuerryControl {
    DatabaseHandler conn = new DatabaseHandler();

    public User getUser(String email, String password) {
        conn.connect();
        String query = "SELECT `id`,`name`,`email`,`password`,`idCategory` FROM `user` WHERE email : " + email
                + " AND password : " + password;
        try {
            Statement statement = conn.conn.createStatement();
            ResultSet result = statement.executeQuery(query);
            User user = new User(0, query, query, query, 0);
            while (result.next()) {
                user.setId(result.getInt("id"));
                user.setName(result.getString("name"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("Password"));
                user.setIdCategory(result.getInt("idCategory"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // public boolean insertUser(User user) {
    //     conn.connect();
    //     String query = "INSERT INTO `user`(`id`,`name`,`email`.`password`,`idCategory`)VALUES ('?','?','?','?','?')";
    //     try {
    //         PreparedStatement statement = conn.conn.prepareStatement(query);
    //         statement.setInt(1, user.getId());
    //         statement.setString(2, user.getName());
    //         statement.setString(3, user.getEmail());
    //         statement.setString(4, user.getPassword());
    //         statement.setInt(5, user.getId());
    //         return (true);
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return (false);
    //     }
    // }
}
