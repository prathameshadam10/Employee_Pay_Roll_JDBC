package org.example;

import java.sql.*;

public class EmployeePayRollServiceMain {
    static final String DB_URL = "jdbc:mysql://localhost:3306/payroll_service";
    static final String USER = "root";
    static final String PASS = "Adam1";

    public static void main(String[] args) {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = null;
            stmt.executeUpdate("CREATE TABLE employee_payroll(id int not null auto_increment primary key,name varchar(30) not null,salary double not null,start_date date not null)");
            System.out.println("Created table in given database...");
            boolean val = stmt.execute("Select * from employee_payroll");
            System.out.println(val);
            if(val){
                ResultSet rs = stmt.getResultSet();
                while (rs.next()){
//                  retrieve by column name
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println(", Name: " + rs.getString("name"));
                    System.out.println(", Salary: " + rs.getDouble("salary"));
                    System.out.println(", Date: " + rs.getDate("start_date"));
                    System.out.println();
                }
            }else {
                int count2 = stmt.getUpdateCount();
                System.out.println(count2);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

