package Controller;
import Model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
public class QuerryControl {
    DatabaseHandler conn = new DatabaseHandler();

    // public User getUser(String email, String password){
    //     conn.connect();
    //     String query = "SELECT `id`,`name`,`email`,`password`,`idCategory` FROM `user` WHERE email : " + email + " AND password : "+ password ;
    //     try {
    //         Statement statement = conn.conn.createStatement();
    //         ResultSet result = statement.executeQuery(query);
    //         User user = new User();
    //         while (result.next()){
    //             user.setId(result.getInt("id"));
    //             user.setName(result.getString("name"));
    //             user.setEmail(result.getString("email"));
    //             user.getPassword(result.getString("password"));
    //             user.setIdCategory(result.getInt("idCategory"));
    //         }
    //         return user;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return null;
    //     }
    // }
}
