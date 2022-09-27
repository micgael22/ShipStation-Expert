package com.testCases;

import com.aventstack.extentreports.Status;
import com.baseClasses.BaseC_01;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.SQLException;

public class TC_01_dataToExcel extends BaseC_01 {

    public TC_01_dataToExcel() throws SQLException {
    }

    @Test(priority = 1)
    public void empTest() throws SQLException, FileNotFoundException {
        try{
//            test = extent.createTest("Employees Test", "Insertion of data successfully")
//                    .log(Status.INFO, "Employees data successful");

            //statement/query
            rs = stmt.executeQuery("SELECT * FROM employees");
            extent.createTest("Employees Test","Data transfer")
                    .log(Status.PASS, "Insertion of data successfully");
            extent.createTest("name","description").log(Status.INFO,"Details");

        }catch (Exception e){
            extent.createTest("Employees Test","Data transfer")
                    .log(Status.FAIL, "Insertion of data failed");
            Assert.fail();
        }

        try {
            //create sheet
            sheet = workbook.createSheet("Employee Data");

            //create row
            row = sheet.createRow(0);

            //create cells
            row.createCell(0).setCellValue("Emp_ID");
            row.createCell(1).setCellValue("Last_name");
            row.createCell(2).setCellValue("First_name");
            row.createCell(3).setCellValue("Title");
            row.createCell(4).setCellValue("Sex");
            row.createCell(5).setCellValue("Date_of_birth");
            row.createCell(6).setCellValue("Hire_date");
            row.createCell(7).setCellValue("Address");
            row.createCell(8).setCellValue("City");
            row.createCell(9).setCellValue("Region");
            row.createCell(10).setCellValue("Postal_code");
            row.createCell(11).setCellValue("Country");
            row.createCell(12).setCellValue("Phone_number");
            row.createCell(13).setCellValue("Email");
            row.createCell(14).setCellValue("Reports_to");
            row.createCell(15).setCellValue("Salary_Rand");

            int r = 1;

            while (rs.next()) {
                int empID = rs.getInt("Emp_ID");
                String lastName = rs.getString("Last_name");
                String firstName = rs.getString("First_name");
                String title = rs.getString("Title");
                String sex = rs.getString("Sex");
                Date dateOfBirth = rs.getDate("Date_of_birth");
                Date hireDate = rs.getDate("Hire_date");
                String address = rs.getString("Address");
                String city = rs.getString("City");
                String region = rs.getString("Region");
                int postalCode = rs.getInt("Postal_code");
                String country = rs.getString("Country");
                String phoneNumber = rs.getString("Phone_number");
                String email = rs.getString("Email");
                int reportsTo = rs.getInt("Reports_to");
                Float salary = rs.getFloat("Salary_Rand");

                row = sheet.createRow(r++);

                row.createCell(0).setCellValue(empID);
                row.createCell(1).setCellValue(lastName);
                row.createCell(2).setCellValue(firstName);
                row.createCell(3).setCellValue(title);
                row.createCell(4).setCellValue(sex);
                row.createCell(5).setCellValue(dateOfBirth);
                row.createCell(6).setCellValue(hireDate);
                row.createCell(7).setCellValue(address);
                row.createCell(8).setCellValue(city);
                row.createCell(9).setCellValue(region);
                row.createCell(10).setCellValue(postalCode);
                row.createCell(11).setCellValue(country);
                row.createCell(12).setCellValue(phoneNumber);
                row.createCell(13).setCellValue(email);
                row.createCell(14).setCellValue(reportsTo);
                row.createCell(15).setCellValue(salary);

                fos = new FileOutputStream("src/main/resources/shipStationData/EmployeesData.xlsx");

            }
            extent.createTest("Employees Test","Data transfer")
                    .log(Status.PASS, ">>>TestCase 01 SUCCESSFULL<<<");
            System.out.println(">>>TestCase 01 SUCCESSFULL<<<");
        }catch (Exception ex){
            extent.createTest("Employees Test","Data transfer")
                    .log(Status.FAIL, ">>>TestCase 01 UNSUCCESSFULL<<<");

            Assert.fail();
        }




    }

    @Test (priority = 2)
    public void custTest() throws SQLException, FileNotFoundException {

        test = extent.createTest("Insert customer data", "Insertion of data successfully")
                .log(Status.INFO, "Customers data successful");

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM customers");

        extent.createTest("Customer Test","Data Transfer")
                .log(Status.PASS, "Insertion of data successfully");

        //create sheet
        sheet = workbook.createSheet("Customer Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Customer_ID");
        row.createCell(1).setCellValue("Company_Name");
        row.createCell(2).setCellValue("Contact_Name");
        row.createCell(3).setCellValue("Contact_Title");
        row.createCell(4).setCellValue("Address");
        row.createCell(5).setCellValue("City");
        row.createCell(6).setCellValue("Region");
        row.createCell(7).setCellValue("Postal_Code");
        row.createCell(8).setCellValue("Country");
        row.createCell(9).setCellValue("Phone_number");
        row.createCell(10).setCellValue("Email");

        int r = 1;

        while (rs.next()) {
            int custID = rs.getInt("Customer_ID");
            String compName = rs.getString("Company_Name");
            String contName = rs.getString("Contact_Name");
            String contTitle = rs.getString("Contact_Title");
            String address = rs.getString("Address");
            String city = rs.getString("City");
            String region = rs.getString("Region");
            int postalCode = rs.getInt("Postal_Code");
            String country = rs.getString("Country");
            String phoneNumber = rs.getString("Phone_number");
            String email = rs.getString("Email");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(custID);
            row.createCell(1).setCellValue(compName);
            row.createCell(2).setCellValue(contName);
            row.createCell(3).setCellValue(contTitle);
            row.createCell(4).setCellValue(address);
            row.createCell(5).setCellValue(city);
            row.createCell(6).setCellValue(region);
            row.createCell(7).setCellValue(postalCode);
            row.createCell(8).setCellValue(country);
            row.createCell(9).setCellValue(phoneNumber);
            row.createCell(10).setCellValue(email);

            fos = new FileOutputStream("src/main/resources/shipStationData/CustomersData.xlsx");
        }
        System.out.println(">>>TestCase 02 SUCCESSFUL<<<");
    }

    @Test (priority = 3)
    public void ordersTest() throws SQLException, FileNotFoundException {

        test = extent.createTest("Insert orders data", "Insertion of data successfully")
                .log(Status.INFO, "Customers data successful");;

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM orders");

        extent.createTest("Order Test","Data Transfer")
                .log(Status.PASS, "Insertion of data successfully");

        //create sheet
        sheet = workbook.createSheet("Orders Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Order_ID");
        row.createCell(1).setCellValue("Customer_ID");
        row.createCell(2).setCellValue("Emp_ID");
        row.createCell(3).setCellValue("Order_Date");
        row.createCell(4).setCellValue("Required_Date");
        row.createCell(5).setCellValue("Shipped_Date");
        row.createCell(6).setCellValue("Shipper_ID");
        row.createCell(7).setCellValue("Ship_Via");
        row.createCell(8).setCellValue("Freight");
        row.createCell(9).setCellValue("Ship_Name");
        row.createCell(10).setCellValue("Ship_Address");
        row.createCell(11).setCellValue("Ship_City");
        row.createCell(12).setCellValue("Ship_Region");
        row.createCell(13).setCellValue("Ship_PostalCode");
        row.createCell(14).setCellValue("Ship_Country");

        int r = 1;

        while (rs.next()) {
            int orderID = rs.getInt("Order_ID");
            int custID = rs.getInt("Customer_ID");
            int empID = rs.getInt("Emp_ID");
            Date orderDate = rs.getDate("Order_Date");
            Date reqDate = rs.getDate("Required_Date");
            Date shippedDate = rs.getDate("Shipped_Date");
            int shipperID = rs.getInt("Shipper_ID");
            int shipVia = rs.getInt("Ship_Via");
            double freight = rs.getDouble("Freight");
            String shipName = rs.getString("Ship_Name");
            String shipAdd = rs.getString("Ship_Address");
            String shipCity = rs.getString("Ship_City");
            String shipRegion = rs.getString("Ship_Region");
            String shipPostalCode = rs.getString("Ship_PostalCode");
            String shipCountry = rs.getString("Ship_Country");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(orderID);
            row.createCell(1).setCellValue(custID);
            row.createCell(2).setCellValue(empID);
            row.createCell(3).setCellValue(orderDate);
            row.createCell(4).setCellValue(reqDate);
            row.createCell(5).setCellValue(shippedDate);
            row.createCell(6).setCellValue(shipperID);
            row.createCell(7).setCellValue(shipVia);
            row.createCell(8).setCellValue(freight);
            row.createCell(9).setCellValue(shipName);
            row.createCell(10).setCellValue(shipAdd);
            row.createCell(11).setCellValue(shipCity);
            row.createCell(12).setCellValue(shipRegion);
            row.createCell(13).setCellValue(shipPostalCode);
            row.createCell(14).setCellValue(shipCountry);

            fos = new FileOutputStream("src/main/resources/shipStationData/OrdersData.xlsx");
        }
        System.out.println(">>>TestCase 03 SUCCESSFUL<<<");
    }

    @Test (priority = 4)
    public void suppliersTest() throws SQLException, FileNotFoundException {

        test = extent.createTest("Insert suppliers data", "Insertion of data successfully")
                .log(Status.INFO, "Suppliers data successful");

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM suppliers");

        extent.createTest("Suppliers Test","Data Transfer")
                .log(Status.PASS, "Insertion of data successfully");

        //create sheet
        sheet = workbook.createSheet("Suppliers Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Suppliers_ID");
        row.createCell(1).setCellValue("Company_Name");
        row.createCell(2).setCellValue("Contact_Name");
        row.createCell(3).setCellValue("Contact_Title");
        row.createCell(4).setCellValue("Address");
        row.createCell(5).setCellValue("City");
        row.createCell(6).setCellValue("Region");
        row.createCell(7).setCellValue("Postal_Code");
        row.createCell(8).setCellValue("Country");
        row.createCell(9).setCellValue("Phone_Number");
        row.createCell(10).setCellValue("Email");

        int r = 1;

        while (rs.next()) {
            int supplID = rs.getInt("Supplier_ID");
            String compName = rs.getString("Company_Name");
            String contName = rs.getString("Contact_Name");
            String contTitle = rs.getString("Contact_Title");
            String address = rs.getString("Address");
            String city = rs.getString("City");
            String region = rs.getString("Region");
            String postCode = rs.getString("Postal_Code");
            String country = rs.getString("Country");
            String phoneNmr = rs.getString("Phone_Number");
            String email = rs.getString("Email");

            row = sheet.createRow(r++);

            //create rows and cells
            row.createCell(0).setCellValue(supplID);
            row.createCell(1).setCellValue(compName);
            row.createCell(2).setCellValue(contName);
            row.createCell(3).setCellValue(contTitle);
            row.createCell(4).setCellValue(address);
            row.createCell(5).setCellValue(city);
            row.createCell(6).setCellValue(region);
            row.createCell(7).setCellValue(postCode);
            row.createCell(8).setCellValue(country);
            row.createCell(9).setCellValue(phoneNmr);
            row.createCell(10).setCellValue(email);

            fos = new FileOutputStream("src/main/resources/shipStationData/SuppliersData.xlsx");
        }
        System.out.println(">>>TestCase 04 SUCCESSFUL<<<");
    }

    @Test (priority = 5)
    public void orderDTest() throws SQLException, FileNotFoundException {

        test = extent.createTest("Insert orderDetails data", "Insertion of data successfully")
                .log(Status.INFO, "Order Details data successful");

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM order_details");

        extent.createTest("Order Details Test","Data Transfer")
                .log(Status.PASS, "Insertion of data successfully");

        //create sheet
        sheet = workbook.createSheet("Order Details Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Order_ID");
        row.createCell(1).setCellValue("Product_ID");
        row.createCell(2).setCellValue("Unit_Price");
        row.createCell(3).setCellValue("Quantity");
        row.createCell(4).setCellValue("Discount");

        int r = 1;

        while (rs.next()) {
            int supplierID = rs.getInt("Order_ID");
            int productID = rs.getInt("Product_ID");
            int unitPrice = rs.getInt("Unit_Price");
            int quantity = rs.getInt("Quantity");
            String discount = rs.getString("Discount");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(supplierID);
            row.createCell(1).setCellValue(productID);
            row.createCell(2).setCellValue(unitPrice);
            row.createCell(3).setCellValue(quantity);
            row.createCell(4).setCellValue(discount);

            fos = new FileOutputStream("src/main/resources/shipStationData/OrderDetailsData.xlsx");
        }
        System.out.println(">>>TestCase 05 SUCCESSFUL<<<");
    }

    @Test (priority = 6)
    public void categoriesTest() throws SQLException, FileNotFoundException {

        test = extent.createTest("Insert categories data", "Insertion of data successfully")
                .log(Status.INFO, "Categories data successful");

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM categories");

        extent.createTest("Categories Test","Data Transfer")
                .log(Status.PASS, "Insertion of data successfully");

        //create sheet
        sheet = workbook.createSheet("Categories Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Category_ID");
        row.createCell(1).setCellValue("Category_Name");

        int r = 1;

        while (rs.next()) {
            int cateID = rs.getInt("Category_ID");
            String cateName = rs.getString("Category_Name");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(cateID);
            row.createCell(1).setCellValue(cateName);

            fos = new FileOutputStream("src/main/resources/shipStationData/CategoriesData.xlsx");
        }
        System.out.println(">>>TestCase 06 SUCCESSFUL<<<");
    }

    @Test (priority = 7)
    public void custDemoTest() throws SQLException, FileNotFoundException {

        test = extent.createTest("Insert customerDemo data", "Insertion of data successfully")
                .log(Status.INFO, "Categories data successful");

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM customer_demo");

        extent.createTest("Customer Demo Test", "Data Transfer")
                .log(Status.PASS, "Insertion of data successfully");

        //create sheet
        sheet = workbook.createSheet("Customer Demo Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Customer_ID");
        row.createCell(1).setCellValue("Customer_Type_ID");

        int r = 1;

        while (rs.next()) {
            int custID = rs.getInt("Customer_ID");
            int custTypeID = rs.getInt("Customer_Type_ID");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(custID);
            row.createCell(1).setCellValue(custTypeID);

            fos = new FileOutputStream("src/main/resources/shipStationData/CustomerDemoData.xlsx");
        }
        System.out.println(">>>TestCase 07 SUCCESSFUL<<<");
    }
    @Test (priority = 8)
    public void custDemoGrTest() throws SQLException, FileNotFoundException {

        test = extent.createTest("Insert customerDemographics data", "Insertion of data successfully")
                .log(Status.INFO, "Categories data successful");

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM customer_demographics");

        extent.createTest("Customer Demographics Test", "Data Transfer")
                .log(Status.PASS, "Insertion of data successfully");

        //create sheet
        sheet = workbook.createSheet("Customer Demographics Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Customer_Type_ID");
        row.createCell(1).setCellValue("Customer_Desc");

        int r = 1;

        while (rs.next()) {
            int custTypeID = rs.getInt("Customer_Type_ID");
            String custDesc = rs.getString("Customer_Desc");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(custTypeID);
            row.createCell(1).setCellValue(custDesc);

            fos = new FileOutputStream("src/main/resources/shipStationData/customerDemographicsData.xlsx");
        }
        System.out.println(">>>TestCase 08 SUCCESSFUL<<<");
    }

    @Test (priority = 9)
    public void empTerritoryTest() throws SQLException, FileNotFoundException {

        test = extent.createTest("Insert employeesTerritoryData", "Insertion of data successfully")
                .log(Status.INFO, "Employee Territory data successful");

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM employees_territory");

        extent.createTest("Employee Territory Test", "Data Transfer")
                .log(Status.PASS, "Insertion of data successfully");

        //create sheet
        sheet = workbook.createSheet("Employees Territory Data");

        //create rows
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Emp_ID");
        row.createCell(1).setCellValue("Territory_ID");

        int r = 1;

        while (rs.next()) {
            int empID = rs.getInt("Emp_ID");
            String terrID = rs.getString("Territory_ID");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(empID);
            row.createCell(1).setCellValue(terrID);

            fos = new FileOutputStream("src/main/resources/shipStationData/EmployeesTerritoryData.xlsx");
        }
        System.out.println(">>>TestCase 09 SUCCESSFUL<<<");
    }

    @Test (priority = 10)
    public void regionTest() throws SQLException, FileNotFoundException {

        test = extent.createTest("Insert region data", "Insertion of data successfully")
                .log(Status.INFO, "Region data successful");

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM region");

        extent.createTest("Customer Demographics Test", "Data Transfer")
                .log(Status.PASS, "Insertion of data successfully");

        //create sheet
        sheet = workbook.createSheet("Region Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Region_ID");
        row.createCell(1).setCellValue("Region Description");

        int r = 1;

        while (rs.next()) {
            int regionID = rs.getInt("Region_ID");
            String regionDesc = rs.getString("Region_Description");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(regionID);
            row.createCell(1).setCellValue(regionDesc);

            fos = new FileOutputStream("src/main/resources/shipStationData/RegionData.xlsx");
        }
        System.out.println(">>>TestCase 10 SUCCESSFUL<<<");
    }

    @Test (priority = 11)
    public void shippersTest() throws SQLException, FileNotFoundException {

        test = extent.createTest("Insert shippers data", "Insertion of data successfully")
                .log(Status.INFO, "Shippers data successful");

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM shippers");

        extent.createTest("Shippers Test", "Data Transfer")
                .log(Status.PASS, "Insertion of data successfully");

        //create sheet
        sheet = workbook.createSheet("Shippers Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Shipper_ID");
        row.createCell(1).setCellValue("Company_Name");
        row.createCell(2).setCellValue("Phone_Number");

        int r = 1;

        while (rs.next()) {
            int shipperID = rs.getInt("Shipper_ID");
            String compName = rs.getString("Company_Name");
            String phoneNum = rs.getString("Phone_Number");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(shipperID);
            row.createCell(1).setCellValue(compName);
            row.createCell(2).setCellValue(phoneNum);

            fos = new FileOutputStream("src/main/resources/shipStationData/ShippersData.xlsx");
        }
        System.out.println(">>>TestCase 11 SUCCESSFUL<<<");
    }
    @Test (priority = 12)
    public void terTest() throws SQLException, FileNotFoundException {

        test = extent.createTest("Insert territories data", "Insertion of data successfully")
                .log(Status.INFO, "Territories data successful");

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM territories");

        extent.createTest("Territories Test", "Data Transfer")
                .log(Status.PASS, "Insertion of data successfully");

        //create sheet
        sheet = workbook.createSheet("Territories Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Territory_ID");
        row.createCell(1).setCellValue("Last_Name");
        row.createCell(2).setCellValue("Region_ID");

        int r = 1;

        while (rs.next()) {

            String terID = rs.getString("Territory_ID");
            String lastName = rs.getString("Last_Name");
            int regionID = rs.getInt("Region_ID");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue("Territory_ID");
            row.createCell(1).setCellValue("Last_Name");
            row.createCell(2).setCellValue("Region_ID");

            fos = new FileOutputStream("src/main/resources/shipStationData/TerritoriesData.xlsx");
        }
        System.out.println(">>>TestCase 12 SUCCESSFUL<<<");
    }

    @Test (priority = 13)
    public void prodTest() throws SQLException, FileNotFoundException {

        test = extent.createTest("Insert products data", "Insertion of data successfully")
                .log(Status.INFO, "Products data successful");

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM products");

        extent.createTest("Products Test", "Data Transfer")
                .log(Status.PASS, "Insertion of data successfully");

        //create sheet
        sheet = workbook.createSheet("Products Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("Product_ID");
        row.createCell(1).setCellValue("Product_Name");
        row.createCell(2).setCellValue("Supplier_ID");
        row.createCell(3).setCellValue("Category_ID");
        row.createCell(4).setCellValue("Quantity_Per_Unit");
        row.createCell(5).setCellValue("Unit_Price");
        row.createCell(6).setCellValue("Units_in_Stock");
        row.createCell(7).setCellValue("Units_in_Order");
        row.createCell(8).setCellValue("Reorder_Level");
        row.createCell(9).setCellValue("Discount");
        row.createCell(10).setCellValue("Discontinued");

        int r = 1;

        while (rs.next()) {
            int productID = rs.getInt("Product_ID");
            String productName = rs.getString("Product_Name");
            int supplierID = rs.getInt("Supplier_ID");
            int cateID = rs.getInt("Category_ID");
            String quanPerUnt = rs.getString("Quantity_Per_Unit");
            int unitPrice = rs.getInt("Unit_Price");
            int unitInStock = rs.getInt("Units_in_Stock");
            int unitInOrder = rs.getInt("Units_in_Order");
            int reorderLevel = rs.getInt("Reorder_Level");
            String discount = rs.getString("Discount");
            String discontinued = rs.getString("Discontinued");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(productID);
            row.createCell(1).setCellValue(productName);
            row.createCell(2).setCellValue(supplierID);
            row.createCell(3).setCellValue(cateID);
            row.createCell(4).setCellValue(quanPerUnt);
            row.createCell(5).setCellValue(unitPrice);
            row.createCell(6).setCellValue(unitInStock);
            row.createCell(7).setCellValue(unitInOrder);
            row.createCell(8).setCellValue(reorderLevel);
            row.createCell(9).setCellValue(discount);
            row.createCell(10).setCellValue(discontinued);

            fos = new FileOutputStream("src/main/resources/shipStationData/ProductsData.xlsx");
        }
        System.out.println(">>>TestCase 13 SUCCESSFUL<<<");
    }
    @Test (priority = 14)
    public void sponsorTest() throws SQLException, FileNotFoundException {

        test = extent.createTest("Insert sponsor data", "Insertion of data successfully")
                .log(Status.INFO, "Sponsor data successful");

        //statement/query
        rs = stmt.executeQuery("SELECT * FROM sponsors");

        extent.createTest("Sponsor Test", "Data Transfer")
                .log(Status.PASS, "Insertion of data successfully");

        //create sheet
        sheet = workbook.createSheet("Sponsors Data");

        //create row
        row = sheet.createRow(0);

        //create cells
        row.createCell(0).setCellValue("sponsor_ID");
        row.createCell(1).setCellValue("sponsor_Name");
        row.createCell(2).setCellValue("amount");
        row.createCell(3).setCellValue("sponsor_Level");

        int r = 1;

        while (rs.next()) {
            int sponsor_ID = rs.getInt("sponsor_ID");
            String sponsor_Name = rs.getString("sponsor_Name");
            int amount = rs.getInt("amount");
            String sponsor_Level = rs.getString("sponsor_Level");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(sponsor_ID);
            row.createCell(1).setCellValue(sponsor_Name);
            row.createCell(2).setCellValue(amount);
            row.createCell(3).setCellValue(sponsor_Level);

            fos = new FileOutputStream("src/main/resources/shipStationData/SponsorsData.xlsx");
        }
        System.out.println(">>>TestCase 14 SUCCESSFUL<<<");
    }
}
