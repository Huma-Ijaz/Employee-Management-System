package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    //Scanner Input for Random Number
    Random ran = new Random();
    int number= ran.nextInt(999999);//number is given for maximum point range

    JTextField tname, tfname,taddress, tphone ,tcard,temail,tsalary, tdesignation;
    JLabel tempid;
    JDateChooser tdob;
    JComboBox Boxeducation;

    JButton add,back; //to Use Buttons Globally


    AddEmployee(){
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

        tname = new JTextField();
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

        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(new Color(177,252,197));
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

        String items[] = {"BBA","B.Tech","BCA","B.A","BSC","B.COM","MBA","MCA","M.A","MTECH","MSC","PHD"};//Formation of Array
        Boxeducation = new JComboBox(items);//Pass the Array
        Boxeducation.setBackground(new Color(177,252,197));
        Boxeducation.setBounds(600,300,150,30);
        add(Boxeducation);

        //For I'd Card
        JLabel card = new JLabel("I'd Card Number");
        card.setBounds(400,350,150,30);
        card.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(card);

        tcard = new JTextField();
        tcard.setBounds(600,350,150,30);
        tcard.setBackground(new Color(177,252,197));
        add(tcard);

        //For EmployeeI'd
        JLabel empid = new JLabel("Employee I'd");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);

        tempid = new JLabel("" + number);
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

        //button formation
        add =new JButton("Add");
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
        if(e.getSource() == add ){  //To store data into the database
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) Boxeducation.getSelectedItem(); //bcz education was stored in Array so we use this function
            String designation = tdesignation.getText();
            String card = tcard.getText();
            String empid = tempid.getText();

            try{
                conn c = new conn();
                String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+card+"','"+empid+"')";
                //query should be arranged accordingto to the table format in database
                c.statement.executeUpdate(query); //pass the query
                JOptionPane.showMessageDialog(null,"Details added successfully"); // to show admin that data is stored successfully in database
                setVisible(false);
                new Main_class();


            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
            new Main_class();
        }

    }

    public static void main(String []args){

        new AddEmployee();
    }
}
