
/**
 * Write a description of class DerStart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DerStart extends Route
{
    // instance variables - replace the example below with your own
    

    public static String[] smallStations = new String[5];
    /**
     * Constructor for objects of class DerStart
     */
    public DerStart(int x)
    {
        toIndex = x;
        toStation = new String[5];
        toStation[0] = "3.70/7.00/48";
        toStation[1] = "2.00/2.50/25";
        toStation[2] = "1.50/3.00/10";
        toStation[3] = "NA";
        toStation[4] = "7.20/16.00/85";
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
}
