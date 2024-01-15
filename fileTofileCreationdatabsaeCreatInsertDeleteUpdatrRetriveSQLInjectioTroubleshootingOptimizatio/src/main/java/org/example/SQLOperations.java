package org.example;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.util.Scanner;


public class SQLOperations
{
    public static void CreatDatabae()
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:school.db");
            Statement statement=connection.createStatement();
            String sql="CREATE TABLE IF NOT EXISTS students("
                    +"id INTEGER PRIMARY KEY,"
                    +"name TEXT NOT NULL,"
                    +"age INTEGER NOT NULL,"
                    +"grade INTEGER NOT NULL)";
            statement.execute(sql);
            statement.close();
            connection.close();
        }catch (ArithmeticException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }
    }
    public static void InsertData()
    {
        try
        {
            Connection connection=DriverManager.getConnection("jdbc:sqlite:school.db");
            String sql="INSERT INTO students(name,age, grade)VALUES(?,?, ?) ";
            PreparedStatement pstmt= connection.prepareStatement(sql);
            pstmt.setString(1,"Toni");
            pstmt.setInt(2,25);
            pstmt.setInt(3,20);
            pstmt.executeUpdate();
            pstmt.setString(1,"pinky");
            pstmt.setInt(2,34);
            pstmt.setInt(3,30);
            pstmt.executeUpdate();
            pstmt.setString(1,"kiwi");
            pstmt.setInt(2,24);
            pstmt.setInt(3,34);
            pstmt.executeUpdate();
            pstmt.close();
            connection.close();
        }catch (Exception e)
        {
            System.out.println("Error");
        }
    }
    public static void PrintData()
    {
        try
        {
            Connection connection=DriverManager.getConnection("jdbc:sqlite:school.db");
            Statement statement=connection.createStatement();
            String sql="SELECT name,age FROM students";
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next())
            {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("age is :"+age+" name is :"+name);
            }
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }
    public static void DeleteDta()
    {
     try {
         Connection connection=DriverManager.getConnection("jdbc:sqlite:school.db");
         String sql="DELETE FROM students WHERE name='kiwi'";
         PreparedStatement pstmt=connection.prepareStatement(sql);
         pstmt.executeUpdate();
connection.close();
pstmt.close();
     }catch (Exception e)
     {
         System.out.println("Error");
     }
    }
    public static void searchWithUserInput()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter students name :");
        String name= scanner.nextLine();
        try
        {
            Connection connection=DriverManager.getConnection("jdbc:sqlite:school.db");
            String sql="SELECT * FROM students WHERE name=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                 name=resultSet.getString("name");
                int age=resultSet.getInt("age");
                System.out.println("Name is :"+name+" age is :"+age);
            }
        }catch (Exception e)
        {
            System.out.println("Error");
        }
    }
    public static void CheckIntegrity()
    {
        try {
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:school.db");
                java.sql.Statement statement = connection.createStatement();
                String sql = "PRAGMA integrity_check";

                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    System.out.println("Integrity Check Result: " + resultSet.getString(1));
                }

                statement.close();
                connection.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void CreateBackupFile()//create a backupFile of database
    {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:school.db");
            String sql = "BACKUP DATABASE school.db TO DISK = 'jdbc:sqlite:school.db'";//BACKUP DATABASE databasename TO DISK = 'filepath';
            PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
            preparedStatement.setString(1, "jdbc:sqlite:school_backup.db");
                preparedStatement.execute();
            connection.close();
            System.out.println("back up is successful");
        }catch (Exception e){
            System.out.println("Error");
        }
    }
    public static void BackupRestore()
    {
        try {
            Connection connection=DriverManager.getConnection("jdbc:sqlite:school.db");
            connection.close();
            File originalFile=new File("jdbc:sqlite:school.db");
            File backupFile=new File("jdbc:sqlite:school_backup.db");
            Files.copy(backupFile.toPath(),originalFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            connection.close();
        }catch (Exception e)
        {
            System.out.println("Error");
        }
    }
}



//Troubleshooting with logging.

/*CheckIntegrity()
    {
        try {
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:school.db");
                java.sql.Statement statement = connection.createStatement();
                String sql = "PRAGMA integrity_check";

                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    System.out.println("Integrity Check Result: " + resultSet.getString());
                }

                statement.close();
                connection.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

 */

    /*
    public static void main(String[] args) {
        try
        {
         Connection connection=DriverManager.getConnection("jdbc:sqlite:school.db");
         String sql="INSERT INTO students(name,age)VALUES(?,?,?) ";
         PreparedStatement pstmt= connection.prepareStatement(sql);
pstmt.setString(1,"Toni");
            pstmt.setInt(2,25);
            pstmt.setString(1,"pinky");
            pstmt.setInt(2,34);
            pstmt.setString(1,"kiwi");
            pstmt.setInt(2,24);

            pstmt.executeUpdate();
pstmt.close();
connection.close();
        }catch (Exception e)
        {
            System.out.println("Error");
            System.out.println(e.getCause());
        }
    }
}
 DatabaseOperations {

    // ... (previous code)

    public static void backupDatabase(String backupFilePath) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:school.db");
            String backupCommand = "BACKUP TO ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(backupCommand)) {
                preparedStatement.setString(1, backupFilePath);
                preparedStatement.execute();
            }
            connection.close();
            System.out.println("Backup successful.");
        } catch (SQLException e) {
            System.out.println("Backup error: " + e.getMessage());
        }
    }

    public static void restoreDatabase(String backupFilePath) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:school.db");
            connection.close(); // Close the current connection before restoring

            // Copy the backup file to the original database file
            File originalFile = new File("school.db");
            File backupFile = new File(backupFilePath);

            Files.copy(backupFile.toPath(), originalFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Restore successful.");
        } catch (Exception e) {
            System.out.println("Restore error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example usage
        backupDatabase("school_backup.db");
        // Perform operations that modify the database
        // ...
        // Now, restore the database to its original state
        restoreDatabase("school_backup.db");
    }
}
DatabaseOperations {

    private static final Logger logger = Logger.getLogger(DatabaseOperations.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("database_operations.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error setting up logging: " + e.getMessage(), e);
        }
    }

    public static void InsertData() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:school.db");
            String sql = "INSERT INTO students(name, age, grade) VALUES(?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "Toni");
            pstmt.setInt(2, 25);
            pstmt.setInt(3, 20);
            pstmt.executeUpdate();
            pstmt.close();
            connection.close();
            logger.info("Data inserted successfully.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error inserting data: " + e.getMessage(), e);
        }
    }

    // ... (other methods)

    public static void main(String[] args) {
        try {
            InsertData();
            // Simulate inserting duplicate records
            InsertData(); // This will cause a SQLException
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Main method error: " + e.getMessage(), e);
        }
    }
}
 */
