package coach.interfaces;

//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!


import coach.dao.dbConnection;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class addRouteEmp extends JPanel implements ActionListener {
    String[] EUCountries = {"Austria", "Italy", "Belgium", "Latvia", "Bulgaria", "Lithuania", "Croatia", "Luxembourg", "Cyprus", "Malta", "Czechia", "Netherlands", "Denmark", "Poland", "Estonia", "Portugal", "Finland", "Romania", "France", "Slovakia", "Germany", "Slovenia", "Greece", "Spain", "Hungary", "Sweden", "Ireland"};
    String[] Monthjcomp24Items = {"1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",};
    String[] Datejcomp25Items = {"1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "21",
            "22",
            "23",
            "24",
            "25",
            "26",
            "27",
            "28",
            "29",
            "30"
    };

    String[] Miuutes = {"1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "21",
            "22",
            "23",
            "24",
            "25",
            "26",
            "27",
            "28",
            "29",
            "30",
            "31",
            "32",
            "33",
            "34",
            "35",
            "36",
            "37",
            "38",
            "39",
            "40",
            "41",
            "42",
            "43",
            "44",
            "45",
            "46",
            "47",
            "48",
            "49",
            "50",
            "51",
            "52",
            "53",
            "54",
            "55",
            "56",
            "57",
            "58",
            "59"
    };
    String[] Hourjcomp26Items = {"1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12"
    };

    String[] Yearcomp26Items = {"2021",
            "2022",
            "2023",
            "2024",
            "2025",
            "2026",
            "2027",
            "2028",
            "2029",
            "2030"
    };

    String[] seatsNos = {"42", "48", "54"};

    JFrame frame = new JFrame("Add Route Employee");

    JComboBox OriginComboBox = new JComboBox(EUCountries);
    JLabel jcomp2 = new JLabel("Origin");
    JComboBox DepartureComboBox = new JComboBox(EUCountries);
    JLabel jcomp4 = new JLabel("Departure");
    JTextField OriginTextField = new JTextField("CityO");
    JLabel jcomp6 = new JLabel("City");
    JTextField CityTextField = new JTextField("CityD");
    JLabel Cityjcomp8 = new JLabel("City");
    JTextField PriceTextField = new JTextField();
    JLabel jcomp10 = new JLabel("Price");
    JLabel jcomp12 = new JLabel("Seats");

    JComboBox SeatsComboBox = new JComboBox(seatsNos);

    JButton addRouteBtn = new JButton("Add Route");

    JComboBox YearComboBox = new JComboBox(Yearcomp26Items);
    JComboBox MonthComboBox = new JComboBox(Monthjcomp24Items);
    JComboBox DateComboBox = new JComboBox(Datejcomp25Items);
    JComboBox HourComboBox = new JComboBox(Hourjcomp26Items);
    JComboBox MinComboBox = new JComboBox(Miuutes);

    JLabel jcomp28 = new JLabel("Year");
    JLabel jcomp29 = new JLabel("Date");
    JLabel jcomp30 = new JLabel("Month");
    JLabel jcomp31 = new JLabel("Hour");
    JLabel jcomp32 = new JLabel("Min");


    public addRouteEmp() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        setVisibleWindow();
        actionEvent();
    }
    private void setVisibleWindow(){frame.setVisible(true);}


    public void createWindow() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(760, 380));
        frame.setLayout(null);
        frame.pack();
    }


    public void setLocationAndSize() {
        OriginComboBox.setBounds(25, 35, 150, 25);
        jcomp2.setBounds(25, 10, 100, 25);
        DepartureComboBox.setBounds(405, 35, 150, 25);
        jcomp4.setBounds(405, 10, 100, 25);
        OriginTextField.setBounds(180, 35, 150, 25);
        jcomp6.setBounds(180, 10, 100, 25);
        CityTextField.setBounds(560, 35, 150, 25);
        Cityjcomp8.setBounds(560, 10, 100, 25);
        PriceTextField.setBounds(35, 125, 150, 25);
        jcomp10.setBounds(35, 100, 100, 25);
        SeatsComboBox.setBounds(35, 180, 100, 25);
        jcomp12.setBounds(35, 155, 100, 25);
        addRouteBtn.setBounds(320, 305, 100, 25);
        YearComboBox.setBounds(435, 130, 80, 25);
        MonthComboBox.setBounds(520, 130, 100, 25);
        DateComboBox.setBounds(625, 130, 100, 25);
        HourComboBox.setBounds(475, 195, 100, 25);
        MinComboBox.setBounds(580, 195, 80, 25);
        jcomp28.setBounds(435, 105, 40, 25);
        jcomp29.setBounds(625, 105, 40, 25);
        jcomp30.setBounds(520, 105, 45, 25);
        jcomp31.setBounds(475, 170, 35, 25);
        jcomp32.setBounds(580, 170, 30, 25);
    }

    public void addComponentsToFrame() {
        frame.add(OriginComboBox);
        frame.add(jcomp2);
        frame.add(DepartureComboBox);
        frame.add(jcomp4);
        frame.add(OriginTextField);
        frame.add(jcomp6);
        frame.add(CityTextField);
        frame.add(Cityjcomp8);
        frame.add(PriceTextField);
        frame.add(jcomp10);
        frame.add(SeatsComboBox);
        frame.add(jcomp12);

        frame.add(addRouteBtn);
        frame.add(YearComboBox);
        frame.add(MonthComboBox);
        frame.add(DateComboBox);
        frame.add(HourComboBox);
        frame.add(MinComboBox);
        frame.add(jcomp28);
        frame.add(jcomp29);
        frame.add(jcomp30);
        frame.add(jcomp31);
        frame.add(jcomp32);

    }

    public void actionEvent() {
        addRouteBtn.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addRouteBtn) {
            //INSERT INTO `busbook`.`routes` (`routeId`, `origin`, `destination`, `departure`, `price`, `seats`, `dates`, `remainSeats`) VALUES ('ff', 'ss', 'ff', '2021-10-12 12:23:00', '32', '43', '43', '43');

            String OriginCountry = String.valueOf(OriginComboBox.getSelectedItem());
            String DepartureCountry = String.valueOf(DepartureComboBox.getSelectedItem());
            String OriginCity = OriginTextField.getText();
            String departureCity = CityTextField.getText();
            double price = Double.parseDouble(PriceTextField.getText());
            int seats = Integer.parseInt(SeatsComboBox.getSelectedItem().toString());
//            String startDate =

            int year = Integer.parseInt(YearComboBox.getSelectedItem().toString());
            int month = Integer.parseInt(MonthComboBox.getSelectedItem().toString());
            int date = Integer.parseInt(DateComboBox.getSelectedItem().toString());
            int hour = Integer.parseInt(HourComboBox.getSelectedItem().toString());
            int min = Integer.parseInt(MinComboBox.getSelectedItem().toString());

            String formattedDateTime2 = "" + year + "-" + month + "-" + date;
            String formatTime = hour + ":" + min + ":" + "00";

            Time time1 = Time.valueOf(formatTime);

            String str="2015-03-31";
            Date date1=Date.valueOf(formattedDateTime2);//converting string into sql date

            //set route id
            char[] originCountryInitials = OriginCountry.toLowerCase().toCharArray();
            char[] originCityInitials = OriginCity.toLowerCase().toCharArray();
            char[] destiCountryInitials = DepartureCountry.toLowerCase().toCharArray();
            char[] destiCityInitials = departureCity.toLowerCase().toCharArray();
            String routeID = String.valueOf(originCountryInitials[0] + originCityInitials[1] + "_" + destiCountryInitials[0] + destiCityInitials[1]);

            try {
                Connection conn = dbConnection.getInstance().getConnection();

                String query = " insert into busbook.routes (`routeId`, `origin`, `originCity`, `destination`, `destinationCity`, `departure`, `time`, `price`, `seats`, `remainSeats`)"
                        + " values (?, ?, ?, ?, ? ,?, ?, ?, ?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, routeID);
                preparedStmt.setString(2, OriginCountry);
                preparedStmt.setString(3, OriginCity);
                preparedStmt.setString(4, DepartureCountry);
                preparedStmt.setString(5, departureCity);
                preparedStmt.setDate(6, date1);
                preparedStmt.setTime(7, time1);
                preparedStmt.setDouble(8, price);
                preparedStmt.setInt(9, seats);
                preparedStmt.setInt(10, 45);

                // execute the preparedstatement
                preparedStmt.execute();
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        new addRouteEmp();
    }

}
