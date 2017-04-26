import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

/**
 * Write a description of class TrainRouteFinder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrainRouteFinder implements ActionListener
{
    // instance variables - replace the example below with your own
    Route route;
    FileHandler fh;
    GUI g;
    
    public TrainRouteFinder()
    {
        g = new GUI(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        System.out.println();
        switch (ae.getActionCommand()){
            case "Time": time();
            break;
            case "Price": price();
            break;
            case "Route": route();
            break;
            case "Sort": routeSort();
            break;
            case "Admin": g.startAdmin();
            break;
            case "Close": System.exit(0);
            break;
            case "comboBoxChanged": g.dropdownChanged((String)((JComboBox)ae.getSource()).getSelectedItem());
            break;
            case "Input Route": adminInput();
            break;
            case "Save Route": adminSave();
            break;
            case "Load Route": adminLoad();
            break;
            default: System.out.println("switch defaulted: " + ae.getActionCommand());
        }
    }
    
    public void time()
    {
        if(g.validateInput())
        {
        g.setResults("It's time");
        setRoute();
        g.setResults(route.getTime());
        }else{
            g.errorMessage("Please fill in date fully.");
        }
    }
    
    public void price()
    {
        if(g.validateInput())
        {
        g.setResults("It's time");
        setRoute();
        g.setResults(route.getPrice(g.getDayCBLength(),g.getSelectedDayCB()));
        }else{
            g.errorMessage("Please fill in date fully.");
        }
    }
    
    public void route()
    {
        
        String str = "<html>";
        setRoute();
        String[] temp = route.smallStations[g.getDestinationIndex()].split(",");
        
        for(int x = 0;x<temp.length;x++){
            str += temp[x] + " \n";
    }
    g.setResults(str + "</html>");
}    
    
    public void routeSort()
    {//sequential sort using String.compareTo()
        setRoute();
        String[] temp = route.smallStations[g.getDestinationIndex()].split(",");
        for(int i = 0;i<temp.length;i++){
            for(int j = 0;j<temp.length;j++){
                if(j+1 <= temp.length-1){
                    if(temp[j].compareTo(temp[j+1])>0){
						 String a = temp[j];
						 temp[j] = temp[j+1];
						 temp[j+1] = a;
                    }else{
                        System.out.println("No swap necessary for " + j + " and " + (j+1));
                    }
                }
            }
        }
        
        String str = "";
        for(int x = 0;x<temp.length;x++){
            str += temp[x] + " \n";
    }
    g.setResults(str);
        
    }
    
    public void setRoute(){
        switch(g.getDepartingIndex()){
            case 0: route = new LeiStart(g.getDestinationIndex());
            break;
            case 1: route = new LouStart(g.getDestinationIndex());
            break;
            case 2: route = new NotStart(g.getDestinationIndex());
            break;
            case 3: route = new DerStart(g.getDestinationIndex());
            break;
            case 4: route = new YorStart(g.getDestinationIndex());
            break;
        }
    }
    
    public void adminInput(){
        switch(g.getDepartingIndex()){
            case 0: LeiStart.smallStations[g.getDestinationIndex()] = g.getAdminText();
            break;
            case 1: LouStart.smallStations[g.getDestinationIndex()] = g.getAdminText();
            break;
            case 2: NotStart.smallStations[g.getDestinationIndex()] = g.getAdminText();
            break;
            case 3: DerStart.smallStations[g.getDestinationIndex()] = g.getAdminText();;
            break;
            case 4: YorStart.smallStations[g.getDestinationIndex()] = g.getAdminText();
            break;
        }
    }
    
    public void adminSave(){
        fh = new FileHandler();
        fh.saveRoutes(encodeRoutes());
    }
    
    public String encodeRoutes(){
        String str = "";
            for(int y = 0;y < 5;y++){
                if(LeiStart.smallStations[y] != null){
                    str += ("0/"+y + "/" + LeiStart.smallStations[y] + "#");
                }
            }
            for(int y = 0;y < 5;y++){
                if(LouStart.smallStations[y] != null){
                    str += ("1/"+y + "/" + LouStart.smallStations[y] + "#");
                }
            }
            for(int y = 0;y < 5;y++){
                if(NotStart.smallStations[y] != null){
                    str += ("2/"+y + "/" + NotStart.smallStations[y] + "#");
                }
            }
            for(int y = 0;y < 5;y++){
                if(DerStart.smallStations[y] != null){
                    str += ("3/"+y + "/" + DerStart.smallStations[y] + "#");
                }
            }
            for(int y = 0;y < 5;y++){
                if(YorStart.smallStations[y] != null){
                    str += ("4/"+y + "/" + YorStart.smallStations[y] + "#");
                }
            }
        return str;
    }
    
    public void adminLoad(){
        
    }
}
