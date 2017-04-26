
/**
 * Write a description of class NotStart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NotStart extends Route
{
    // instance variables - replace the example below with your own
    
    public static String[] smallStations = new String[5];

    /**
     * Constructor for objects of class NotStart
     */
    public NotStart(int x)
    {
        toIndex = x;
        toStation = new String[5];
        toStation[0] = "3.50/6.20/30";
        toStation[1] = "1.50/2.50/15";
        toStation[2] = "NA";
        toStation[3] = "2.50/3.00/12";
        toStation[4] = "11.50/16.00/40";
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
}
