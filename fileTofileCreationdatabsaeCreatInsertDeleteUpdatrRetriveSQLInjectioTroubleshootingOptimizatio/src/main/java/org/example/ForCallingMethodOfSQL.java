package org.example;

public class ForCallingMethodOfSQL {

    public static void main(String[] args) {

        //SQLOperations.CreatDatabae();
        //SQLOperations.InsertData();
        //SQLOperations.PrintData();
       // SQLOperations.DeleteDta();
        //SQLOperations.searchWithUserInput();
        //SQLOperations.CheckIntegrity();
        SQLOperations.CreateBackupFile();
        //SQLOperations.BackupRestore();
    }
}
    /*
    public static void CreatDatabae()
    {
try
{
    Connection connection = DriverManager.getConnection("jdbc:sqlite:school.db");
    Statement statement=connection.createStatement();
    String sql="CREATE TABLE IF NOT EXIST students("
            +"id INTEGER PRIMARY KEY,"
            +"name TEXT NOT NULL,"
            +"age INTEGER NOT NULL,"
            +"grade INTEGER NOT NUL)";
    statement.execute(sql);
    statement.close();
    connection.close();

}catch (ArithmeticException e) {
    System.out.println(e.getMessage());
}
catch (Exception e)
{
    System.out.println("Error");
}
    }

    }

     */

