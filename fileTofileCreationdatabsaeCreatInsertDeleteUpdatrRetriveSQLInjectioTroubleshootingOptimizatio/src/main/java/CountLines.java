import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;


public class CountLines {

    public static int CountLinesNumbers(String FilePath)
    {
        try
        {
            FileReader reader= new FileReader("practice.txt");
            LineNumberReader lineNumberReader=new LineNumberReader(reader);
            int count=0;

            while(lineNumberReader.readLine()!=null)
            {
            count++;
            }
            return  count;
        }catch (IOException e)
        {
            return 0;
        }

    }

    public static void main(String[] args)
    {
        String FilePath="practice.txt";
        System.out.println("number of lines =" +CountLinesNumbers(FilePath));

    }
}

/*        1. Create a new Java application.
        2. Write a function that takes a file path as an argument and returns
         the number of lines in that file.
        3. Test the function with "practice.txt" and other text files you have available.
        */