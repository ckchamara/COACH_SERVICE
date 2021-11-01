package coach.interfaces;

//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class addRouteEmp extends JPanel implements ActionListener {
    String[] EUCountries = {"Austria","Italy", "Belgium","Latvia", "Bulgaria",	"Lithuania", "Croatia",	"Luxembourg", "Cyprus",	"MaltaCzechia",	"Netherlands", "Denmark",	"Poland", "Estonia",	"Portugal", "Finland",	"Romania", "France",	"Slovakia", "Germany",	"Slovenia", "Greece",	"Spain", "Hungary",	"Sweden", "Ireland"	};
    String[] Monthjcomp24Items = {    "1",
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

    String[] seatsNos = {"42","48","54"};

    JFrame frame = new JFrame ("Add Route Employee");

    JComboBox jcomp1 = new JComboBox (EUCountries);
    JLabel jcomp2 = new JLabel ("Origin");
    JComboBox jcomp3 = new JComboBox (EUCountries);
    JLabel jcomp4 = new JLabel ("Departure");
    JTextField jcomp5 = new JTextField ("CityO");
    JLabel jcomp6 = new JLabel ("City");
    JTextField jcomp7 = new JTextField ("CityD");
    JLabel jcomp8 = new JLabel ("City");
    JTextField jcomp9 = new JTextField ("Price");
    JLabel jcomp10 = new JLabel ("Price");
    JLabel jcomp12 = new JLabel ("Seats");
    JComboBox Seatsjcomp11 = new JComboBox (seatsNos);
    JCheckBox jcomp14 = new JCheckBox ("Sun");
    JCheckBox jcomp15 = new JCheckBox ("Mon");
    JCheckBox jcomp17 = new JCheckBox ("Fri");
    JCheckBox jcomp18 = new JCheckBox ("Sat");
    JCheckBox jcomp19 = new JCheckBox ("Thr");
    JCheckBox jcomp20 = new JCheckBox ("Tue");
    JCheckBox jcomp21 = new JCheckBox ("Wed");
    JButton addRouteBtn = new JButton ("Add Route");
    JComboBox Yearjcomp23 = new JComboBox (Yearcomp26Items);
    JComboBox jcomp24 = new JComboBox (Monthjcomp24Items);
    JComboBox jcomp25 = new JComboBox (Datejcomp25Items);
    JComboBox jcomp26 = new JComboBox (Hourjcomp26Items);
    JComboBox Minjcomp27 = new JComboBox (Miuutes);
    JLabel jcomp28 = new JLabel ("Year");
    JLabel jcomp29 = new JLabel ("Date");
    JLabel jcomp30 = new JLabel ("Month");
    JLabel jcomp31 = new JLabel ("Hour");
    JLabel jcomp32 = new JLabel ("Min");


    public addRouteEmp() {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }

    public void createWindow(){
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize (new Dimension (760, 380));
        frame.setLayout (null);
        frame.pack();
        frame.setVisible (true);
    }


    public void setLocationAndSize(){
        jcomp1.setBounds (25, 35, 150, 25);
        jcomp2.setBounds (25, 10, 100, 25);
        jcomp3.setBounds (405, 35, 150, 25);
        jcomp4.setBounds (405, 10, 100, 25);
        jcomp5.setBounds (180, 35, 150, 25);
        jcomp6.setBounds (180, 10, 100, 25);
        jcomp7.setBounds (560, 35, 150, 25);
        jcomp8.setBounds (560, 10, 100, 25);
        jcomp9.setBounds (35, 125, 150, 25);
        jcomp10.setBounds (35, 100, 100, 25);
        Seatsjcomp11.setBounds (35, 180, 100, 25);
        jcomp12.setBounds (35, 155, 100, 25);
        jcomp14.setBounds (230, 120, 50, 25);
        jcomp15.setBounds (230, 145, 50, 25);
        jcomp17.setBounds (305, 145, 55, 25);
        jcomp18.setBounds (305, 170, 55, 25);
        jcomp19.setBounds (305, 120, 55, 25);
        jcomp20.setBounds (230, 170, 55, 25);
        jcomp21.setBounds (230, 195, 65, 25);
        addRouteBtn.setBounds (320, 305, 100, 25);
        Yearjcomp23.setBounds (435, 130, 80, 25);
        jcomp24.setBounds (520, 130, 100, 25);
        jcomp25.setBounds (625, 130, 100, 25);
        jcomp26.setBounds (475, 195, 100, 25);
        Minjcomp27.setBounds (580, 195, 80, 25);
        jcomp28.setBounds (435, 105, 40, 25);
        jcomp29.setBounds (625, 105, 40, 25);
        jcomp30.setBounds (520, 105, 45, 25);
        jcomp31.setBounds (475, 170, 35, 25);
        jcomp32.setBounds (580, 170, 30, 25);
    }

    public void addComponentsToFrame() {
        frame.add (jcomp1);
        frame.add (jcomp2);
        frame.add (jcomp3);
        frame.add (jcomp4);
        frame.add (jcomp5);
        frame.add (jcomp6);
        frame.add (jcomp7);
        frame.add (jcomp8);
        frame.add (jcomp9);
        frame.add (jcomp10);
        frame.add (Seatsjcomp11);
        frame.add (jcomp12);
        frame.add (jcomp14);
        frame.add (jcomp15);
        frame.add (jcomp17);
        frame.add (jcomp18);
        frame.add (jcomp19);
        frame.add (jcomp20);
        frame.add (jcomp21);
        frame.add (addRouteBtn);
        frame.add (Yearjcomp23);
        frame.add (jcomp24);
        frame.add (jcomp25);
        frame.add (jcomp26);
        frame.add (Minjcomp27);
        frame. add (jcomp28);
        frame.add (jcomp29);
        frame.add (jcomp30);
        frame.add (jcomp31);
        frame.add (jcomp32);

    }

    public void actionEvent() {
        addRouteBtn.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addRouteBtn) {

        }

    }

    public static void main (String[] args) {
        new addRouteEmp();
    }

}
