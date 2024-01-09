import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class WriteInFile {
    public static void main(String[] args) {


        try {
            FileWriter writer=new FileWriter("practice.txt");
            BufferedWriter bufferedWriter=new BufferedWriter(writer);
            bufferedWriter.write("java is fun!");
            bufferedWriter.newLine();
            bufferedWriter.write("I'm learning file management.");
            bufferedWriter.newLine();
            bufferedWriter.write("Soon I can save data locally.");
            bufferedWriter.newLine();
            bufferedWriter.write("i am fine.");


bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error");
        }

    }
}
