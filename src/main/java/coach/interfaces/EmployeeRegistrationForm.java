package coach.interfaces;

import coach.dao.dbConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeRegistrationForm extends JFrame implements ActionListener {
    JFrame frame = new JFrame("Employee Registration Form");
    JCheckBox showPassword = new JCheckBox("Show Password");
    JLabel firstNameLabel =new JLabel("FIRST NAME");
    JLabel passwordlabel =new JLabel("LAST NAME");
    JLabel lastNameLabel =new JLabel("PASSWORD");

    JTextField firstnameTextField =new JTextField();
    JPasswordField passwordField =new JPasswordField();
    JTextField lastNameTextField =new JTextField();

    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");


    EmployeeRegistrationForm()
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

        frame.setBounds(40,40,380,380);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void setLocationAndSize()
    {
        firstNameLabel.setBounds(20,20,100,70);
        passwordlabel.setBounds(20,70,80,70);
        lastNameLabel.setBounds(20,120,100,70);

        firstnameTextField.setBounds(180,43,165,23);
        passwordField.setBounds(180,143,165,23);
        showPassword.setBounds(180, 163, 150, 30);
        lastNameTextField.setBounds(180,93,165,23);

        registerButton.setBounds(70,200,100,35);
        resetButton.setBounds(220,200,100,35);
    }
    public void addComponentsToFrame()
    {
        frame.add(firstNameLabel);
        frame.add(passwordlabel);
        frame.add(lastNameLabel);
        frame.add(firstnameTextField);
        frame.add(passwordField);
        frame.add(lastNameTextField);
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

            String firstName = firstnameTextField.getText();
            String password = passwordField.getText();
            String lastName = lastNameTextField.getText();

            try {
                Connection conn = dbConnection.getInstance().getConnection();

                String query = " insert into busbook.employees (`firstName`, `lastName`, `password`)" +
                        " values (?, ?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, firstName);
                preparedStmt.setString(2, lastName);
                preparedStmt.setString(3, password);

                // execute the preparedstatement
                preparedStmt.execute();
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }

        }

        if (e.getSource() == resetButton) {
            passwordField.setText("");
            firstnameTextField.setText("");
            lastNameTextField.setText("");
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
        new EmployeeRegistrationForm();
    }
}
