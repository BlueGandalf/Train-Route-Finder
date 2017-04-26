import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
/**
 * Write a description of class GUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GUI 
{
    // instance variables - replace the example below with your own
    JFrame frm1;
    JPanel pane1;
    
    JFrame frm2;
    JPanel pane2;
    
    JButton timeBut;
    JButton priceBut;
    JButton routeBut;
    JButton sortBut;
    JButton adminBut;
    JButton endBut;
    
    JLabel dateLabel;
    JComboBox monthCB;
    JComboBox dayCB;
    JComboBox yearCB;
    
    JLabel startingStationLabel;
    JComboBox startStationCB;
    JLabel endingStationLabel;
    JComboBox endStationCB;
    
    JLabel results;
    
    JFrame adminFrm;
    JPanel adminPane;

    JButton inputRouteButton;
    JButton saveRouteButton;
    JButton loadRouteButton;
    JLabel lbael;
    JTextArea text;
    
    TrainRouteFinder trf;
    /**
     * Constructor for objects of class GUI
     */
    public GUI(TrainRouteFinder trf)
    {
        
        this.trf = trf;
        
        frm1 = new JFrame("Train Route Finder");
        frm1.setBounds(50,50,100,250);
        
        pane1 = new JPanel();
        Color beige = new Color(250,235,215);
        pane1.setBackground(beige);
        
        frm2 = new JFrame("Train Route Finder");
        frm2.setBounds(250,50,475,300);
        
        pane2 = new JPanel();
        pane2.setBackground(beige);
        
        timeBut = new JButton("Time");
        timeBut.addActionListener(trf);
        timeBut.setLocation(30,30);
        timeBut.setVisible(true);
        pane1.add(timeBut);
        
        priceBut = new JButton("Price");
        priceBut.addActionListener(trf);
        priceBut.setLocation(30,70);
        priceBut.setVisible(true);
        pane1.add(priceBut);
        
        routeBut = new JButton("Route");
        routeBut.addActionListener(trf);
        routeBut.setLocation(30,120);
        routeBut.setVisible(true);
        pane1.add(routeBut);
        
        sortBut = new JButton("Sort");
        sortBut.addActionListener(trf);
        sortBut.setLocation(30,30);
        sortBut.setVisible(true);
        pane1.add(sortBut);
        
        adminBut = new JButton("Admin");
        adminBut.addActionListener(trf);
        adminBut.setLocation(200,150);
        adminBut.setVisible(true);
        pane1.add(adminBut);
        
        endBut = new JButton("Close");
        endBut.addActionListener(trf);
        timeBut.setLocation(30,30);
        endBut.setVisible(true);
        pane1.add(endBut);
        
        String[] stations = { "Leicester","Loughborough","Nottingham","Derby","York" };
        
        startingStationLabel = new JLabel("Departing Station: ");
        startStationCB = new JComboBox(stations);
        startStationCB.addActionListener(trf);
        startingStationLabel.setVisible(true);
        startStationCB.setVisible(true);
        pane2.add(startingStationLabel);
        pane2.add(startStationCB);
        
        endingStationLabel = new JLabel("Departing Station: ");
        endStationCB = new JComboBox(stations);
        endStationCB.addActionListener(trf);
        endingStationLabel.setVisible(true);
        endStationCB.setVisible(true);
        pane2.add(endingStationLabel);
        pane2.add(endStationCB);
        
        startDate();
        
        results = new JLabel("");
        results.setVisible(true);
        pane2.add(results);
        
        pane1.setVisible(true);
        frm1.add(pane1);
        frm1.setVisible(true);
        
        pane2.setVisible(true);
        frm2.add(pane2);
        frm2.setVisible(true);
    }

    
    public void startDate()
    {
        String[] monthOptions = { "Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec" };
        monthCB = new JComboBox(monthOptions);
        monthCB.addActionListener(trf);
        monthCB.setName("month");
        monthCB.setVisible(true);
        pane2.add(monthCB);
        
        dayCB = new JComboBox();
        dayCB.addActionListener(trf);
        monthCB.setName("day");
        dayCB.setEnabled(false);
        dayCB.setVisible(true);
        pane2.add(dayCB);
        
        String[] yearOptions = { "2017","2018","2019","2020","2021" };
        yearCB = new JComboBox(yearOptions);
        yearCB.addActionListener(trf);
        yearCB.setEnabled(false);
        yearCB.setVisible(true);
        pane2.add(yearCB);
    }
    
    public void dropdownChanged(String s){
        //((JComboBox)ae.getSource())
        System.out.println("woop");
        yearCB.setEnabled(true);
        switch(s){
            case "Jan":setDay(monthLength(31));
            break;
            case "Feb":setDay(monthLength(28));
            break;
            case "Mar":setDay(monthLength(31));
            break;
            case "Apr":setDay(monthLength(30));
            break;
            case "May":setDay(monthLength(31));
            break;
            case "Jun":setDay(monthLength(30));
            break;
            case "Jul":setDay(monthLength(31));
            break;
            case "Aug":setDay(monthLength(31));
            break;
            case "Sep":setDay(monthLength(30));
            break;
            case "Oct":setDay(monthLength(31));
            break;
            case "Nov":setDay(monthLength(30));
            break;
            case "Dec":setDay(monthLength(31));
            break;
            case "2020":if(monthCB.getSelectedItem() == "Feb")setDay(monthLength(29));
            break;
            default:System.out.println("dropdown switch defaulted");
        }
    }
    
    public void setDay(String[] dayOptions)
    {
        DefaultComboBoxModel model = new DefaultComboBoxModel( dayOptions );
        dayCB.setModel( model );
        dayCB.setEnabled(true);
    }
    
    public String[] monthLength(int y)
    {
        String[] days = new String[y];
        for(int x=0;x<y;x++){
            days[x] = Integer.toString(x+1);
        }
        return days;
    }
    
    public boolean validateInput()
    {
        if(startStationCB.getSelectedItem() != null && endStationCB.getSelectedItem() != null && monthCB.getSelectedItem() != null && dayCB.getSelectedItem() != null && yearCB.getSelectedItem() != null){
        return true;
    }
    return false;
    }
    
    public int getDepartingIndex(){
        return startStationCB.getSelectedIndex();
    }
    
    public int getDestinationIndex(){
        return endStationCB.getSelectedIndex();
        
    }
    
    public void startAdmin(){
        adminFrm = new JFrame("Admin");
        adminFrm.setBounds(450,450,400,200);
        
        adminPane = new JPanel();
        
        lbael = new JLabel("<html>These functions use the two stations from the starting windows. <br>Please check they are correct.</html>");
        lbael.setVisible(true);
        adminPane.add(lbael);
        
        inputRouteButton = new JButton("Input Route");
        inputRouteButton.addActionListener(trf);
        inputRouteButton.setVisible(true);
        adminPane.add(inputRouteButton);
        
        saveRouteButton = new JButton("Save Route");
        saveRouteButton.addActionListener(trf);
        saveRouteButton.setVisible(true);
        adminPane.add(saveRouteButton);
        
        loadRouteButton = new JButton("Load Route");
        loadRouteButton.addActionListener(trf);
        loadRouteButton.setVisible(true);
        adminPane.add(loadRouteButton);
        
        text = new JTextArea(5,30);
        text.setVisible(true);
        adminPane.add(text);
        
        adminPane.setVisible(true);
        adminFrm.add(adminPane);
        
        adminFrm.setVisible(true);
        
    }
   
    public String getAdminText(){
        return text.getText();
    }
    
    public void setAdminText(String t){
        text.setText(t);
    }
    
    public void setResults(String s){
        results.setText(s);
    }
    
    public int getDayCBLength(){
        return dayCB.getItemCount();
    }
    
    public int getSelectedDayCB(){
        return Integer.parseInt(dayCB.getSelectedItem().toString());
    }

    public void errorMessage(String s){
        JFrame fError = new JFrame("Error");
        fError.setBounds(300,300,200,75);
        JPanel pError = new JPanel();
        JLabel lError = new JLabel(s);
        
        lError.setVisible(true);
        pError.add(lError);
        pError.setVisible(true);
        fError.add(pError);
        fError.setVisible(true);
    }
}
