import java.lang.Exception;
public class InsufficientCapException extends Exception
{
    InsufficientCapException(String s)
    {
        super(s);
    }
}