package com.baseClasses;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileOutputStream;
import java.io.IOException;

public class BaseC_03 {

    XSSFWorkbook wb;
    Sheet sheet;
    String filepath;
    FileOutputStream fos;

    @BeforeTest
    public void setup03() {
        wb = new XSSFWorkbook();
        sheet = wb.createSheet("Login Details");

    }

    @AfterTest
    public void afterTest() throws IOException {
        filepath = "src/main/resources/empPrivateData/PrivateData.xlsx";
        fos = new FileOutputStream(filepath);
        wb.write(fos);
        fos.close();

        System.out.println(">>>>>>>>file written successfully!!<<<<<<<<<<");
    }

}
