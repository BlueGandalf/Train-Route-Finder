
/**
 * Write a description of class Route here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Route
{
    //to store the route details. Index 0 is Leicester, 1 is Loughborough, 2 is Nottingham, 3 is Derby and 4 is York.
    //to store any small, intermediary stations along the route, as inputted or loaded from the Admin menu.
    String[] toStation;
    public static String[] smallStations = new String[5];
    int toIndex;

    /**
     * Constructor for objects of class Route
     */
    public Route()
    {
       // toIndex = x;
       //start();
    }
    
    public void start(){}

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getPrice(int length, int index)
    {
        String str = "";
        if(toStation[toIndex] != "NA"){
          String[] s = splitArray();
            if(index == length){
                str = ("Single: " + (Double.parseDouble(s[0])*0.9) + " Return: " + (Double.parseDouble(s[1])*0.9));
            }else if(index < length){
                str = ("Single Ticket: " + s[0] + " Return: " + s[1]);
            }
    }else{
        str = ("<html><br>It is free to get to your departing station from your departing station. <br> Please select proper stations.</html>"); 
    }
    return str;
}
    
    public String getTime(){
        String[] s = splitArray();
        if(toStation[toIndex] != "NA"){
        if(Integer.parseInt(s[2]) > 60){
        return ("The journey takes " + (Math.floor(Integer.parseInt(s[2])/60)) + " hours and " + (Integer.parseInt(s[2])%60) + " minutes.");
    }else{
        return ("The journey takes " + (Integer.parseInt(s[2])%60) + " minutes.");
    }
}else{
    return ("<html><br>It won't take any time to get to your departing station. <br> Please select proper stations.</html>");
}
    }
    
    
    public String[] splitArray(){
        String[] splitted;
        if(toStation[toIndex] != "NA"){
       splitted = toStation[toIndex].split("/");
        return splitted;
    }
    return new String[2];
}
}
