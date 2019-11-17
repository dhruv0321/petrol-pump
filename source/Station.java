import java.lang.*;
import java.io.*;
interface station1
{
    int totalcap=1000;
    static boolean dispensible=true;
}
public abstract class Station implements station1
{
    private static boolean dispensible = true;
    private static int totalcap=1000;
    public static int ret_totalcap()
    {
        return totalcap;
    }
    public static void update_cap(int n)
    {
        totalcap -= n;
        if (ret_totalcap()==0)
        {
            dispensible=false;
        }
    }
    public static boolean ret_stat()
    {
        return dispensible;
    }
}