package org.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XLUtils {

    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wBook;
    public static XSSFSheet wSheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static int getRowCount(String xlFile, String xlSheet) throws IOException {

        fi = new FileInputStream(xlFile);
        wBook = new XSSFWorkbook(fi);
        wSheet = wBook.getSheet(xlSheet);
        int rowCount = wSheet.getLastRowNum();
        wBook.close();
        fi.close();
        return rowCount;
    }

    public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException {

        fi = new FileInputStream(xlFile);
        wBook = new XSSFWorkbook(fi);
        wSheet = wBook.getSheet(xlSheet);
        row = wSheet.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        wBook.close();
        fi.close();
        return cellCount;
    }

    public static String getCellData(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {

        fi = new FileInputStream(xlFile);
        wBook = new XSSFWorkbook(fi);
        wSheet = wBook.getSheet(xlSheet);
        row = wSheet.getRow(rowNum);
        cell= row.getCell(colNum);

        String data;
        try{
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        }
        catch (Exception e) {
            data = "";
        }

        wBook.close();
        fi.close();
        return data;
    }

    public static String setCellData(String xlFile, String xlSheet, int rowNum, int colNum, String data) throws IOException {

        fi = new FileInputStream(xlFile);
        wBook = new XSSFWorkbook(fi);
        wSheet = wBook.getSheet(xlSheet);
        row = wSheet.getRow(rowNum);
        cell= row.createCell(colNum);
        cell.setCellValue(data);

        fo =new FileOutputStream(xlFile);
        wBook.write(fo);
        wBook.close();
        fi.close();
        fo.close();
        return xlFile;
    }

}
