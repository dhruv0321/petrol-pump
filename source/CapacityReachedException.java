import java.lang.Exception;
public class CapacityReachedException extends Exception
{
    CapacityReachedException(String s)
    {
        super(s);
    }
}