//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//  Step 1 import required package
//Step 1. import java.sql.*;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static  void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        try {

            //step 2 load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //step 3 create connection

            String url = "jdbc:mysql://127.0.0.1:3306/computer";
            String userName = "root";
            String password ="gobinda@0337";
            Connection con = DriverManager.getConnection(url,userName,password);
//step 4 create statement
            //Statement stm = con.createStatement();
            //step5 execute queries
            //String query = "INSERT INTO CSS VALUES(103,'Himanshu'),(104,'Gagan'),(105,'Sahil')";
            //Here i am using preparedStatement()
           PreparedStatement pstmt= con.prepareStatement("INSERT INTO CSS VALUES(?,?)");
            System.out.println("How many student do you want to Add= ");
            int num=sc.nextInt();
            for(int i=1; i<=num;i++)
            {
                System.out.println(" Enter the data of " +i+ " student ");
                System.out.print("Enter your RollNo =");
                int RollNo=sc.nextInt();
                pstmt.setInt(1,RollNo);
                System.out.print("Enter your Name =");
                String Name=sc.next();
                pstmt.setString(2,Name);
                pstmt.executeUpdate();

            }
            //stm.executeUpdate(query);
            // step 6. close connection
            con.close();
            System.out.println("Data Inserted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

