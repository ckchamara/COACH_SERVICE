package coach.interfaces;


import coach.dao.dbConnection;
import coach.interfaces.customer.customerPage;
import coach.interfaces.employee.employeePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginFrame extends JFrame implements ActionListener {

    JFrame frame = new JFrame("Login");
//    Container frame = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JButton RegisterButton = new JButton("REGISTRATION");
    JCheckBox showPassword = new JCheckBox("Show Password");
    JCheckBox empOrUserCheck = new JCheckBox("Are You a Employee?");

    public void createWindow()
    {
        frame.setTitle("Login Form");
        frame.setBounds(40,40,380,600);
        // frame.getContentPane().setBackground(Color.lightGray);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
    }


    LoginFrame() {
        createWindow();
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        setVisibleWindow();
        addActionEvent();

    }
    private void setVisibleWindow(){frame.setVisible(true);}

    public void setLayoutManager() {
        frame.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
        RegisterButton.setBounds(100, 350, 150, 30);
        empOrUserCheck.setBounds(150, 180, 150, 30);

    }

    public void addComponentsToContainer() {
        frame.add(userLabel);
        frame.add(passwordLabel);
        frame.add(userTextField);
        frame.add(passwordField);
        frame.add(showPassword);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(RegisterButton);
        frame.add(empOrUserCheck);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        RegisterButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) {
            String userText = userTextField.getText();
            String pwdText = passwordField.getText();

            if (empOrUserCheck.isSelected()){
                ResultSet resultSet = null;
                try {
                    String query = "SELECT * FROM busbook.employees WHERE firstName =? AND password =?";
                    Connection conn = dbConnection.getInstance().getConnection();
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setString(1,userTextField.getText());
                    preparedStatement.setString(2,passwordField.getText());
                    resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        String empiID = resultSet.getString("empId");
                        new employeePage(empiID);
                    }
                } catch (Exception ye) {
                    ye.printStackTrace();
                }

            }else if(!empOrUserCheck.isSelected()) {
                ResultSet resultSet = null;
                try {
                    String query = "SELECT * FROM busbook.customers WHERE FirstName =? AND LoginPassword =?";
                    Connection conn = dbConnection.getInstance().getConnection();
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setString(1,userTextField.getText());
                    preparedStatement.setString(2,passwordField.getText());
                    resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        String customerID = resultSet.getString("CustomerId");
                        new customerPage(customerID);
                    }
                } catch (Exception ye) {
                    ye.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }

        if (e.getSource() == RegisterButton) {
            if (empOrUserCheck.isSelected()){
                new EmployeeRegistrationForm();
            }else {
                new CustomerRegistrationForm();
            }

        }

        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }

    }

    public static void main(String[] args) {
        new LoginFrame();
    }

}




