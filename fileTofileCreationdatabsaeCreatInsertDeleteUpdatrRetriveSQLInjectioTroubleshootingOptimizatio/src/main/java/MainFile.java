import java.io.File;
import java.io.IOException;

public class MainFile
{
    public static void main(String[] args)
    {

            try {
                File f1 = new File("practice.txt");
                if (f1.createNewFile()) {
                    System.out.println("File created :"+f1.getName());
                }else{
                    System.out.println("File is already existed");
                }

            }catch (IOException e)
            {
                System.out.println("An Error");

            }
    }

}