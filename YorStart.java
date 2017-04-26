
/**
 * Write a description of class YorStart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YorStart extends Route
{
    // instance variables - replace the example below with your own
    

    public static String[] smallStations = new String[5];
    /**
     * Constructor for objects of class YorStart
     */
    public YorStart(int x)
    {
        toIndex = x;
        toStation = new String[5];
        toStation[0] = "12.20/25.00/70";
        toStation[1] = "12.00/20.00/60";
        toStation[2] = "8.20/16.00/40";
        toStation[3] = "11.20/16.00/75";
        toStation[4] = "NA";
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
}
