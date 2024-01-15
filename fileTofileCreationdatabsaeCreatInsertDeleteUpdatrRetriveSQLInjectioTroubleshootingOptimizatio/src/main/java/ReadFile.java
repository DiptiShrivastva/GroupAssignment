import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {
    public static void main(String[] args) {
        try {
         FileReader reader=new FileReader("practice.txt");
         BufferedReader bufferedReader = new BufferedReader(reader);
         String line;
         while((line=bufferedReader.readLine())!=null){
             System.out.println(line);
         }
        bufferedReader.close();
        }catch (Exception e)
        {
            System.out.println("Error");
        }
    }
}