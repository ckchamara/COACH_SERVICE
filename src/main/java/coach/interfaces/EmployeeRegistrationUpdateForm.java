package coach.interfaces;

import coach.dao.dbConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRegistrationUpdateForm extends JFrame implements ActionListener {

    int employeeId;
    JFrame frame = new JFrame("Employee Update Form");
    JLabel firstNameLabel = new JLabel("FIRST NAME");
    JLabel passwordlabel = new JLabel("LAST NAME");
    JLabel lastNameLabel = new JLabel("PASSWORD");

    JCheckBox showPassword = new JCheckBox("Show Password");

    JTextField firstnameTextField = new JTextField();
    JPasswordField passwordTextField = new JPasswordField();
    JTextField lastNameTextField = new JTextField();
    JButton UpdateButton = new JButton("UPDATE");
    JButton resetButton = new JButton("ERASE");


    EmployeeRegistrationUpdateForm(int empId) {
        employeeId = empId;
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        setVisibleWindow();
        populateData();
        actionEvent();

    }

    private void populateData() {

        String firstName = firstnameTextField.getText();
        String password = passwordTextField.getText();
        String lastName = lastNameTextField.getText();

        ResultSet resultSet = null;
        try {
            Connection conn = dbConnection.getInstance().getConnection();
            // TODO: 1/2/2022
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * from busbook.employees where empId="+employeeId);
            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {
//                email_label = new JLabel(String.valueOf(resultSet.getInt("empId")));

                firstnameTextField.setText(String.valueOf(resultSet.getString("firstName")));
                lastNameTextField.setText(String.valueOf(resultSet.getString("lastName")));
                passwordTextField.setText(String.valueOf(resultSet.getString("password")));
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void setVisibleWindow() {
        frame.setVisible(true);
    }

    public void createWindow() {

        frame.setBounds(40, 40, 380, 380);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setLocationAndSize() {
        firstNameLabel.setBounds(20, 20, 100, 70);
        passwordlabel.setBounds(20, 70, 80, 70);
        lastNameLabel.setBounds(20, 120, 100, 70);

        firstnameTextField.setBounds(180, 43, 165, 23);
        passwordTextField.setBounds(180, 143, 165, 23);
        showPassword.setBounds(180, 163, 150, 20);
        lastNameTextField.setBounds(180, 93, 165, 23);

        UpdateButton.setBounds(70, 190, 100, 35);
        resetButton.setBounds(220, 190, 100, 35);
    }

    public void addComponentsToFrame() {
        frame.add(firstNameLabel);
        frame.add(passwordlabel);
        frame.add(lastNameLabel);
        frame.add(firstnameTextField);
        frame.add(passwordTextField);
        frame.add(lastNameTextField);
        frame.add(showPassword);
        frame.add(UpdateButton);
        frame.add(resetButton);

    }

    public void actionEvent() {
        UpdateButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == UpdateButton) {
//            app.frame.setVisible(true);
//            frame.setVisible(false);

            String firstName = firstnameTextField.getText();
            String lastName = lastNameTextField.getText();
            String password = passwordTextField.getText();

            try {
                Connection conn = dbConnection.getInstance().getConnection();

                String query = " UPDATE busbook.employees SET firstName = ?, lastName = ? ,password = ? WHERE empId = ?";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, firstName);
                preparedStmt.setString(2, lastName);
                preparedStmt.setString(3, password);
                preparedStmt.setString(4, String.valueOf(employeeId));

                preparedStmt.execute();
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }

        }

        if (e.getSource() == resetButton) {
            passwordTextField.setText("");
            firstnameTextField.setText("");
            lastNameTextField.setText("");
        }

        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordTextField.setEchoChar((char) 0);
            } else {
                passwordTextField.setEchoChar('*');
            }
        }
    }


    public static void main(String[] args) {
        new EmployeeRegistrationUpdateForm(2);
    }
}
