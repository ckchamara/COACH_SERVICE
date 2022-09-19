package coach.interfaces;

import coach.dao.dbConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerRegistrationForm extends JFrame implements ActionListener {
    JFrame frame = new JFrame("Customer Registration Form");
    String[] gender={"Male","Female"};
    JLabel firstNameLabel =new JLabel("FIRST NAME");
    JLabel genderLabel=new JLabel("GENDER");
    JLabel lastNameLabel =new JLabel("LAST NAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JLabel DOBLabel =new JLabel("DOB (yyyy-mm-dd)");
    JLabel AddressLable =new JLabel("ADDRESS");
    JLabel emailLabel=new JLabel("EMAIL");
    JLabel MobileNoLabel=new JLabel("MOBILE NO");
    JCheckBox showPassword = new JCheckBox("Show Password");

    JTextField nameTextField=new JTextField();
    JComboBox genderComboBox=new JComboBox(gender);
    JTextField lastNameTextField =new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JTextField DOBField =new JTextField();
    JTextField AddressTextField =new JTextField();
    JTextField emailTextField=new JTextField();
    JTextField MobileTextField=new JTextField();

    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");


    CustomerRegistrationForm()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        setVisibleWindow();
        actionEvent();
    }
    private void setVisibleWindow(){frame.setVisible(true);}

    public void createWindow()
    {

        frame.setBounds(40,40,380,600);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
        firstNameLabel.setBounds(20,20,100,70);
        genderLabel.setBounds(20,70,80,70);
        lastNameLabel.setBounds(20,120,100,70);
        passwordLabel.setBounds(20,170,100,70);
        DOBLabel.setBounds(20,220,140,70);
        AddressLable.setBounds(20,270,100,70);
        emailLabel.setBounds(20,320,100,70);
        MobileNoLabel.setBounds(20,370,100,70);

        nameTextField.setBounds(180,43,165,23);
        genderComboBox.setBounds(180,93,165,23);
        lastNameTextField.setBounds(180,143,165,23);
        passwordField.setBounds(180,193,165,23);
        showPassword.setBounds(180, 219, 150, 15);
        DOBField.setBounds(180,243,165,23);
        AddressTextField.setBounds(180,293,165,23);
        emailTextField.setBounds(180,343,165,23);
        MobileTextField.setBounds(180,393,165,23);

        registerButton.setBounds(70,450,100,35);
        resetButton.setBounds(220,450,100,35);
    }
    public void addComponentsToFrame()
    {
        frame.add(firstNameLabel);
        frame.add(genderLabel);
        frame.add(lastNameLabel);
        frame.add(passwordLabel);
        frame.add(DOBLabel);
        frame.add(AddressLable);
        frame.add(emailLabel);
        frame.add(nameTextField);
        frame.add(genderComboBox);
        frame.add(lastNameTextField);
        frame.add(passwordField);
        frame.add(DOBField);
        frame.add(AddressTextField);
        frame.add(emailTextField);
        frame.add(MobileNoLabel);
        frame.add(MobileTextField);
        frame.add(showPassword);

        frame.add(registerButton);
        frame.add(resetButton);

    }
    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
//            app.frame.setVisible(true);
//            frame.setVisible(false);

            String firstName = lastNameTextField.getText();
            String gender = genderComboBox.getSelectedItem().toString();
            String lastName = lastNameTextField.getText();
            String Password = passwordField.getText();
            String DOB = DOBField.getText();
            String Address = AddressTextField.getText();
            String Email = emailTextField.getText();
            String MobileNo = MobileTextField.getText();

            try {
                Connection conn = dbConnection.getInstance().getConnection();

                String query = " insert into busbook.customers (`FirstName`, `Lastname`, `Email`, `LoginPassword`, `DOB`, `Gender`, `PhoneNumber`, `Address`)" +
                        " values (?, ?, ?, ?, ? ,?, ?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, firstName);
                preparedStmt.setString(2, lastName);
                preparedStmt.setString(3, Email);
                preparedStmt.setString(4, Password);
                preparedStmt.setString(5,DOB);
                preparedStmt.setString(6,gender);
                preparedStmt.setString(7,MobileNo);
                preparedStmt.setString(8, Address);

                // execute the preparedstatement
                preparedStmt.execute();
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }

        }

        if (e.getSource() == resetButton) {
            passwordField.setText("");
            nameTextField.setText("");
            lastNameTextField.setText("");
            DOBField.setText("");
            AddressTextField.setText("");
            emailTextField.setText("");
            MobileTextField.setText("");
        }

        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }

    }



    public static void main(String[] args) {
        new CustomerRegistrationForm();
    }
}
