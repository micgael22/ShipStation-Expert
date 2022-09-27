package com.baseClasses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class BaseC_01 {
    public Connection con;
    public Statement stmt;
    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow row;
    public ResultSet rs;
    public FileOutputStream fos;

    public ExtentSparkReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;
    public WebDriver driver;

    public File scrFile;
    public File Dest;

    public BaseC_01() throws SQLException {
        htmlReporter = new ExtentSparkReporter("xReports\\xSparkreport.html"); //("Spark.html");
        extent = new ExtentReports();
        workbook = new XSSFWorkbook();
        con = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/ship_station","root","thebigbangtheory05__");
        stmt = con.createStatement();
    }


    @BeforeSuite
    public void startReport() throws SQLException {
        System.out.println("Starting the BeforeSuite");

        extent.attachReporter(htmlReporter);
        htmlReporter.config().setTheme(Theme.DARK);

        System.out.println("Ending the BeforeSuite");
    }

    @BeforeTest
    public void setup() throws SQLException {
        System.out.println("Starting the BeforeTest");

        System.out.println("Ending the BeforeTest");
    }

    @AfterTest
    public void afterTest() throws IOException, SQLException {
        System.out.println("Starting the afterTest");


        System.out.println("Ending the afterTest");
    }

    

    @AfterSuite
    public void teardown() throws IOException, SQLException {
        System.out.println("Starting the afterSuite");
        //to write or update test information to reporter

        extent.flush();
        System.out.println("Ending extent flush");

        //fos = new FileOutputStream("src/main/resources/excelFiles/ShipStationData.xlsx");
        System.out.println("write to workbook");

        workbook.write(fos);
        System.out.println("closing workbook");

        workbook.close();
        System.out.println("closing fos");

        fos.close();
        System.out.println("closing con");
        con.close();

        System.out.println(">>>>>>>>Connected<<<<<<<<<");
        System.out.println("End of the afterSuite");
    }
}
