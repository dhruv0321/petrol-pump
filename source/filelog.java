import java.io.*;
public class filelog
{   static class Logging
    {
        public void write(String s) throws IOException
        {
            File file = new File("log.txt");
            FileWriter fw = new FileWriter(file, true);
            fw.write("*"+s+"\n");
            System.out.println(s);
            fw.close();
        }
        public void write(Object x) throws IOException {
            String s = String.valueOf(x);
            File file = new File("log.txt");
            FileWriter fw = new FileWriter(file, true);
            fw.write("#"+s+"\n");
            System.out.println(s);
            fw.close();
        }

        public String reader() throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            File file = new File("log.txt");
            FileWriter fw = new FileWriter(file, true);
            fw.write("->"+s+"\n");
            fw.close();
            return s;
        }
    }
    static Logging out = new Logging();
}