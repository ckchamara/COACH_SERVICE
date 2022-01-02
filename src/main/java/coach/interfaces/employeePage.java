package coach.interfaces;

//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!

import coach.dao.dbConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class employeePage extends JPanel implements ActionListener {

    //construct components
    JFrame frame = new JFrame("Employee Profile");
    JLabel empid = new JLabel("EMP ID:");
    JLabel lastname = new JLabel("LASTNAME:");
    JLabel firstName = new JLabel("FIRST NAME");
    JButton editDetails = new JButton("Edit Details");
    JButton addRoute = new JButton("Add Route");
    JButton deleteRoute = new JButton("Delete Route");
    JTable table = new JTable();
    JScrollPane tableWithScrolBox = new JScrollPane(table);

    JLabel email_label;
    JLabel firstname_label;
    JLabel lastname_label;

    String tableData[][] = new String[25][20];


    public employeePage() {
        createWindow();
        setJlabelParams();
        setLocationAndSize();
        populateData();
        createTable();
        addComponentsToFrame();
        setVisibleWindow();
        actionEvent();

    }

    public void setJlabelParams(){
        ResultSet resultSet = null;
        try {
            Connection conn = dbConnection.getInstance().getConnection();
            // TODO: 1/2/2022  
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * from busbook.employees where empId=2");
            resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {
                 email_label = new JLabel(String.valueOf(resultSet.getInt("empId")));
                 firstname_label = new JLabel(String.valueOf(resultSet.getString("firstName")));
                 lastname_label = new JLabel(String.valueOf(resultSet.getString("lastName")));
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void populateData() {
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            Connection conn = dbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * from busbook.routes");
            resultSet = preparedStatement.executeQuery();

            int i = 0;
            while (resultSet.next()) {
                String routeId = resultSet.getString("routeId");
                String origin = resultSet.getString("origin");
                String originCity = resultSet.getString("originCity");
                String destination = resultSet.getString("destination");
                String destinationCity = resultSet.getString("destinationCity");
                Date departure = resultSet.getDate("departure");
                Time time = resultSet.getTime("time");
                Double price = resultSet.getDouble("price");
                Integer seats = resultSet.getInt("seats");
                Integer remainSeats = resultSet.getInt("remainSeats");
                tableData[i][0] = String.valueOf(routeId);
                tableData[i][1] = String.valueOf(origin);
                tableData[i][3] = String.valueOf(originCity);
                tableData[i][4] = String.valueOf(destination);
                tableData[i][5] = String.valueOf(destinationCity);
                tableData[i][6] = String.valueOf(departure);
                tableData[i][7] = String.valueOf(time);
                tableData[i][8] = String.valueOf(price);
                tableData[i][9] = String.valueOf(seats);
                tableData[i][10] = String.valueOf(remainSeats);
                i++;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void createWindow() {
        frame.setPreferredSize(new Dimension(850, 520));
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    private void setVisibleWindow(){frame.setVisible(true);}

    public void createTable() {
        Object[] columns = {"Route Id", "Origin","originCity", "Destination","destinationCity", "Departure","time", "Price", "Seates", "RemainSeats"};
        final DefaultTableModel model = new DefaultTableModel(tableData, columns);
        table.setModel(model);
        table.setBackground(Color.CYAN.brighter());
        table.setForeground(Color.black);
        Font font = new Font("", 1, 18);
        table.setFont(font);
        table.setRowHeight(30);
    }

    public void setLocationAndSize() {
        empid.setBounds(325, 80, 100, 25);
        lastname.setBounds(320, 155, 100, 25);
        firstName.setBounds(320, 115, 100, 25);
        editDetails.setBounds(345, 235, 120, 25);
        addRoute.setBounds(530, 290, 150, 25);
        deleteRoute.setBounds(700, 290, 115, 25);
        tableWithScrolBox.setBounds(10, 330, 815, 140);
        email_label.setBounds(430, 80, 100, 25);
        firstname_label.setBounds(430, 115, 100, 25);
        lastname_label.setBounds(430, 155, 100, 25);

    }

    public void addComponentsToFrame() {
        frame.add(empid);
        frame.add(lastname);
        frame.add(firstName);
        frame.add(editDetails);
        frame.add(addRoute);
        frame.add(deleteRoute);
        frame.add(tableWithScrolBox);
        frame.add(email_label);
        frame.add(firstname_label);
        frame.add(lastname_label);

    }

    public void actionEvent() {
        editDetails.addActionListener(this);
        addRoute.addActionListener(this);
        deleteRoute.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == editDetails) {
            // TODO: 1/2/2022 fnish the edit button action
        } else if (e.getSource() == addRoute) {
            // TODO: 1/2/2022
        } else if (e.getSource() == deleteRoute) {
            // TODO: 1/2/2022
        }

    }

    public static void main(String[] args) {
        new employeePage();
    }

}
