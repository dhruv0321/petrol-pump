import java.io.*;
import java.lang.*;
class Main
{
    public static void main(String[] args) throws IOException
    {
        int i;
        Pump1[] p1= new Pump1[3];
        for(i=0;i<3;i++) p1[i]=new Pump1();
        while(Station.ret_stat())
        {
            for(i=0;i<3;i++)
            {
                try
                {
                    if(Station.ret_stat()!=true)
                        throw new CapacityReachedException("Station Capacity Reached");
                }
                catch (Exception e) {filelog.out.write(e);break;}
                try
                {
                    if(p1[i].get_valid()!=true)
                        throw new CapacityReachedException("Pump "+ Integer.toString(i+1) + " Capacity Reached");
                }
                catch (Exception e)
                {
                    filelog.out.write(e);
                    continue;
                }
                Thread obj = new Thread(p1[i]);
                try
                {
                    filelog.out.write("Remaining station capacity "+ Integer.toString(Station.ret_totalcap()));
                    filelog.out.write("Pump number :" +Integer.toString(i+1));
                    obj.start();
                    try
                    {
                        obj.join();
                    }
                    catch(Exception e)
                    {
                        filelog.out.write(e);
                    }
                }
                finally
                {
                    filelog.out.write("Thank you for Visiting");
                }
            }
        }
    }
}