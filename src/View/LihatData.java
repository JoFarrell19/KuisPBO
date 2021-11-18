package View;
import java.awt.Color;
import Controller.QuerryControl;
import Model.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.PlainDocument;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LihatData implements ActionListener{
    QuerryControl querryControl = new QuerryControl();
    JFrame fLihatData;
    JPanel pLihatData;
    JButton btnSearch, btnBack;
    JTable jtDataTable;
    DefaultTableModel model;
    QuerryControl queryController = new QuerryControl();
    JComboBox<String> cbCategory;
    ArrayList<CategoryUser> categories = queryController.selectCategoryUser();
    LihatData(){
        fLihatData = new JFrame("Lihat Data");
        fLihatData.setSize(700, 1000);
        fLihatData.setLayout(null);
        fLihatData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pLihatData = new JPanel();
        pLihatData.setSize(700,1000);
        pLihatData.setBackground(Color.yellow);
        pLihatData.setLayout(null);
        pLihatData.setVisible(true);

        String[] categoryList = new String[categories.size()];
        for (int i = 0; i < categories.size(); i++) {
            categoryList[i] = categories.get(i).getName();
        }
        cbCategory = new JComboBox<>(categoryList);
        cbCategory.setBounds(5, 30, 300, 50);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(1, 100, 100, 50);
        btnSearch.addActionListener(this);

        btnBack = new JButton("Back");
        btnBack.setBounds(120, 100, 100, 50);
        btnBack.addActionListener(this);

        jtDataTable = new JTable();
        jtDataTable.setBounds(0, 160, 700,700);


        pLihatData.add(jtDataTable);
        pLihatData.add(btnSearch);
        pLihatData.add(btnBack);
        pLihatData.add(cbCategory); 
        fLihatData.add(pLihatData);
        fLihatData.setVisible(true);
    }
    public static void main(String[] args) {
        new LihatData();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "Search":
                //Getter
                String category = cbCategory.getSelectedItem().toString();
                ArrayList<User> users = querryControl.selectUserCategory(category);
                
                //Setter
                String[] columnData = {"idUser", "name", "email", "password", "idCategory"};
                model = new DefaultTableModel(columnData, 0);

                for (int i = 0; i < users.size(); i++) {
                    String[] newModel = new String[5];
                    newModel[0] = String.valueOf(users.get(i).getIdUser());
                    newModel[1] = users.get(i).getName();
                    newModel[2] = users.get(i).getEmail();
                    newModel[3] = users.get(i).getPassword();
                    newModel[4] = String.valueOf(users.get(i).getIdCategory());
                    model.addRow(newModel);
                }

                jtDataTable.setModel(model);
                break;
            case "Back":
                new MainMenu();
                fLihatData.dispose();
                break;
            default: 
                break;
        }
    }
}
