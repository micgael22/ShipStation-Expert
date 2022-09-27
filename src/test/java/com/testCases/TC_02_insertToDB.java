package com.testCases;

import com.aventstack.extentreports.Status;
import com.baseClasses.BaseC_02;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.sql.SQLException;


public class TC_02_insertToDB extends BaseC_02 {

    public TC_02_insertToDB() throws SQLException {

    }

    @Test (priority = 1)
    public void sponsor01() throws SQLException {

        sponsor_ID = 20;
        sponsor_Name = "RollersX";
        amount = 50000;
        sponsor_Level = "LEVEL 3";

        test = extent.createTest("Sponsor 01 data RollersX", "Insertion of data successfully")
                .log(Status.INFO, "Data into DataBase");

//        sql = "INSERT INTO sponsors (sponsor_ID, sponsor_Name, amount, sponsor_Level ) " +
//                "VALUES (" + sponsor_ID + ",'" + sponsor_Name + "'," + amount + ",'" + sponsor_Level + "')";

        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/ship_station","root","thebigbangtheory05__");

            st = con.createStatement();
            int m =st.executeUpdate(sql);
            if (m == 1)
                System.out.println("Insert data successfully : " + sql);
            else
                System.out.println("Insertion data failed");
        }
        catch (Exception e) {
            System.err.println(e);
        }

        System.out.println(">>>Sponsor 01<<< "
                + sponsor_ID + " >>> " + sponsor_Name + " >>> " + amount + " >>> " + sponsor_Level );
    }

    @Test (priority = 2)
    public void sponsor02() {
        sponsor_ID = 21;
        sponsor_Name = "Extremes";
        amount = 10000;
        sponsor_Level = "LEVEL 1";

        test = extent.createTest("Sponsor 02 data Extremes", "Insertion of data successfully")
                .log(Status.INFO, "Data into DataBase");

//        sql = "INSERT INTO sponsors (sponsor_ID, sponsor_Name, amount, sponsor_Level ) " +
//                "VALUES (" + sponsor_ID + ",'" + sponsor_Name + "'," + amount + ",'" + sponsor_Level + "')";

        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/ship_station","root","thebigbangtheory05__");

            st = con.createStatement();
            int m =st.executeUpdate(sql);
            if (m == 1)
                System.out.println("Insert data successfully : " + sql);
            else
                System.out.println("Insertion data failed");
        }
        catch (Exception e) {
            System.err.println(e);
        }

        System.out.println(">>>Sponsor 02<<< "
                + sponsor_ID + " >>> " + sponsor_Name + " >>> " + amount + " >>> " + sponsor_Level );
    }

    @Test (priority = 3)
    public void sponsor03() {
        sponsor_ID = 22;
        sponsor_Name = "Big Bang";
        amount = 26000;
        sponsor_Level = "LEVEL 2";

        test = extent.createTest("Sponsor 03 data Big Bang", "Insertion of data successfully")
                .log(Status.INFO, "Data into DataBase");

//        sql = "INSERT INTO sponsors (sponsor_ID, sponsor_Name, amount, sponsor_Level ) " +
//                "VALUES (" + sponsor_ID + ",'" + sponsor_Name + "'," + amount + ",'" + sponsor_Level + "')";

        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/ship_station","root","thebigbangtheory05__");

            st = con.createStatement();
            int m =st.executeUpdate(sql);
            if (m == 1)
                System.out.println("Insert data successfully : " + sql);
            else
                System.out.println("Insertion data failed");
        }
        catch (Exception e) {
            System.err.println(e);
        }

        System.out.println(">>>Sponsor 03<<< "
                + sponsor_ID + " >>> " + sponsor_Name + " >>> " + amount + " >>> " + sponsor_Level );
    }

    @Test (priority = 4)
    public void sponsor04() {
        sponsor_ID = 23;
        sponsor_Name = "Palace";
        amount = 540000;
        sponsor_Level = "LEVEL 3";

        test = extent.createTest("Sponsor 04 data Palace", "Insertion of data successfully")
                .log(Status.INFO, "Data into DataBase");

//        sql = "INSERT INTO sponsors (sponsor_ID, sponsor_Name, amount, sponsor_Level ) " +
//                "VALUES (" + sponsor_ID + ",'" + sponsor_Name + "'," + amount + ",'" + sponsor_Level + "')";

        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/ship_station","root","thebigbangtheory05__");

            st = con.createStatement();
            int m =st.executeUpdate(sql);
            if (m == 1)
                System.out.println("Insert data successfully : " + sql);
            else
                System.out.println("Insertion data failed");
        }
        catch (Exception e) {
            System.err.println(e);
        }

        System.out.println(">>>Sponsor 04<<< "
                + sponsor_ID + " >>> " + sponsor_Name + " >>> " + amount + " >>> " + sponsor_Level );
    }

    @Test (priority = 5)
    public void sponsor05() {
        sponsor_ID = 24;
        sponsor_Name = "85South";
        amount = 110000;
        sponsor_Level = "LEVEL 1";

        test = extent.createTest("Sponsor 05 data 85South", "Insertion of data successfully")
                .log(Status.INFO, "Data into DataBase");

        sql = "INSERT INTO sponsors (sponsor_ID, sponsor_Name, amount, sponsor_Level ) " +
                "VALUES (" + sponsor_ID + ",'" + sponsor_Name + "'," + amount + ",'" + sponsor_Level + "')";

        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/ship_station","root","thebigbangtheory05__");

            st = con.createStatement();
            int m =st.executeUpdate(sql);
            if (m == 1)
                System.out.println("Insert data successfully : " + sql);
            else
                System.out.println("Insertion data failed");
        }
        catch (Exception e) {
            System.err.println(e);
        }

//        System.out.println(">>>Sponsor 05<<< "
//                + sponsor_ID + " >>> " + sponsor_Name + " >>> " + amount + " >>> " + sponsor_Level );

    }
}
