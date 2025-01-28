package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateEmployee extends JFrame implements ActionListener {
    JTextField teducation, tfname,taddress, tphone ,tcard, temail,tsalary, tdesignation;

    JLabel tempid;

    JButton add,back;

    String number;

    UpdateEmployee(String number){

        this.number = number;
        //To get Background colour
        getContentPane().setBackground(new Color(163,255,188));

        //For making heading
        JLabel heading= new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        //For name Button
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);
        //For Father Name
        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);

        //For Date of Birth
        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(200,200,150,30);
        tdob.setFont(new Font("Tahoma",Font.BOLD,20));
        add(tdob);

        //For Salary
        JLabel salary = new JLabel(" Salary ");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);


        //For Address
        JLabel address = new JLabel(" Address ");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        //For Phone Number
        JLabel phone = new JLabel(" Phone ");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        //For E-mail
        JLabel email = new JLabel(" E-mail ");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200,300,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);

        //For Education
        JLabel education = new JLabel("  Highest Education ");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);

        teducation = new JTextField();
        teducation.setBounds(600,300,150,30);
        teducation.setBackground(new Color(177,252,197));
        add(teducation);


        //For I'd Card
        JLabel card = new JLabel("I'd Card Number");
        card.setBounds(400,350,150,30);
        card.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(card);

        JLabel tcard = new JLabel();
        tcard.setBounds(600,350,150,30);
        tcard.setBackground(new Color(177,252,197));
        add(tcard);

        //For EmployeeI'd
        JLabel empid = new JLabel("Employee I'd");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);

        tempid = new JLabel();
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);

        //For Designation
        JLabel  designation = new JLabel(" Designation");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200,350,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);

        try{
            conn c = new conn();
            String query= "select * from employee where empid= '"+number+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                taddress.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));
                tcard.setText(resultSet.getString("card"));
                tempid.setText(resultSet.getString("empid"));
                tdesignation.setText(resultSet.getString("designation"));






            }

        }catch (Exception e){
            e.printStackTrace();
        }

        //button formation
        add =new JButton("UPDATE");
        add.setBounds(250,550,150,40);
        add.setBackground(Color.BLACK); //for background clr
        add.setForeground(Color.WHITE); // for written text visibility
        add.addActionListener(this);
        add(add);

        back  =new JButton("Back");
        back.setBounds(450,550,150,40);
        back.setBackground(Color.BLACK); //for background clr
        back.setForeground(Color.WHITE); // for written text visibility
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLocation(300,50);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            try{
                conn c = new conn();
                String query= "update employee set fname='"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"', email='"+email+"', education='"+education+"',designation='"+designation+"'where empid = '"+number+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Detail updated successfully");
                setVisible(false);
                new Main_class();

            }catch (Exception E){
                E.printStackTrace();
            }

        }else{
            setVisible(false);
            new ViewEmployee();
        }

    }

    public static void main(String []args){
        new UpdateEmployee("");

    }
}
