
/**
 * Write a description of class LouStart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LouStart extends Route
{
    
    public static String[] smallStations = new String[5];
    
    public LouStart(int x)
    {
        toIndex = x;
        toStation = new String[5];
        toStation[0] = "2.50/4.00/10";
        toStation[1] = "NA";
        toStation[2] = "1.50/2.50/15";
        toStation[3] = "1.25/2.50/23";
        toStation[4] = "11.50/20.00/60";
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
}
