package employee.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame  implements ActionListener {

    JTable table;  //to get table of the choosen employee data
    Choice choiceEMP; // used for dropdown to show all employees I'ds
    JButton searchbtn, print, back,update;

    ViewEmployee(){

        getContentPane().setBackground(new Color(255,131,122));//content pane is used to customize user interface
        JLabel search = new JLabel("Search by Employee I'D");
        search.setBounds(20,10,150,20);
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(180,20,150,20);
        add(choiceEMP);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee"); // ExecuteQuery is used to get data back from our database
            while(resultSet.next()){
                choiceEMP.add(resultSet.getString("empid"));

            }

        }catch (Exception e){
            e.printStackTrace();//used to let us know about exception if there is any exception
        }

        table = new JTable();
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("Select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        //Button Formation
        searchbtn = new JButton("Search");
        searchbtn.setBounds(20,70,80,20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

       update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);



        setSize(900,600);
        setLocation(300,100);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchbtn){
            String query = "select * from employee where empid = '"+choiceEMP.getSelectedItem()+"'";
            try{
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query); //to get data from database
                table.setModel(DbUtils.resultSetToTableModel(resultSet)); // to store taken data
            }catch (Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource()== print) {
            try{
                table.print();

            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(choiceEMP.getSelectedItem()); // To give selected items to update class

        }else {
            setVisible(false);
            new Main_class();

        }

    }

    public static void main(String[]args){
        new ViewEmployee();
    }
}
