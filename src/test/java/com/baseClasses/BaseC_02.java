package com.baseClasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.sql.*;

public class BaseC_02 {

    public int sponsor_ID;
    public String sponsor_Name;
    public int amount;
    public String sponsor_Level;
    public String sql;
    public Connection con;
    public Statement st;
    public ResultSet rs;
    public ExtentSparkReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;

    public BaseC_02() throws SQLException {
        htmlReporter = new ExtentSparkReporter("xReports\\DataToDatabase.html"); //("Spark.html");
        extent = new ExtentReports();

        sql = "INSERT INTO sponsors (sponsor_ID, sponsor_Name, amount, sponsor_Level ) " +
                "VALUES (" + sponsor_ID + ",'" + sponsor_Name + "'," + amount + ",'" + sponsor_Level + "')";

        con = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/ship_station","root","thebigbangtheory05__");
        st = con.createStatement();
    }

    @BeforeSuite
    public void startReport02() throws SQLException {
        System.out.println("Starting the BeforeSuite");

        extent.attachReporter(htmlReporter);
        htmlReporter.config().setTheme(Theme.DARK);

        System.out.println("Ending the BeforeSuite");
    }

    @BeforeTest
    public void setup02() throws SQLException {
        System.out.println("Starting the BeforeTest");

        System.out.println("Ending the BeforeTest");
    }

    @AfterTest
    public void afterTest02() throws IOException, SQLException {
        System.out.println("Starting the afterTest");

        System.out.println("Ending the afterTest");
    }


    @AfterSuite
    public void teardown02() throws IOException, SQLException {
        System.out.println("Starting the afterSuite");
        //to write or update test information to reporter

        extent.flush();
        System.out.println("Ending extent flush");

        con.close();

        System.out.println(">>>>>>>>Connected<<<<<<<<<");
        System.out.println("End of the afterSuite");
    }
}
