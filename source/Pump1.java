import java.io.*;
import java.lang.*;
interface pump
{
    int ret_cap();
    void dispense(int n);
}
abstract class Pumps extends Station implements pump
{
    boolean isvalid=true;
    int capacity = 500;
    public int ret_cap()
    {
        return capacity;
    }
    public void dispense(int n)
    {
        capacity -= n;
        update_cap(n);
        if (this.ret_cap()==0)
        {
            isvalid=false;
        }
    }
    public boolean get_valid()
    {
        return isvalid;
    }
    public void check_capacity(int n) throws InsufficientCapException
    {
        if(this.ret_cap()<n||Station.ret_totalcap()<n)
        {
            throw new InsufficientCapException("Insufficient Capacity");
        }
    }
}
class Pump1 extends Pumps implements Runnable
{
    
    public void run()
    {
        try 
        {
            input();
        } catch (Exception e){}
    }
    public void input() throws IOException
    {
        try 
        {
            int n;
            filelog.out.write("Remaning Capacity of pump :" +Integer.toString(ret_cap()));
            filelog.out.write("Enter Quantity to dispense :");
            n=Integer.parseInt(filelog.out.reader());
            check_capacity(n);
            dispense(n);
            filelog.out.write("Remaning Capacity of pump :" +Integer.toString(ret_cap()));
        }
        catch (InsufficientCapException e)
        {
            filelog.out.write(e);
            filelog.out.write("Remaining pump capacity " + Integer.toString(this.ret_cap()));
            filelog.out.write("Remaining station capacity "+ Integer.toString(Station.ret_totalcap()));
        }
        catch (Exception e) {filelog.out.write(e);}
        
    }
}
