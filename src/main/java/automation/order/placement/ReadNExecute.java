package automation.order.placement;/*package automation.order.placement;

import com.sun.media.sound.InvalidFormatException;
import com.sun.rowset.internal.Row;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
//This is a controller class which reads test cases from excel sheet and execute them one by one.
//At the end it appends test result into the output file.

public class ReadNExecuteCases {

    public static void main(String[] args) throws Exception {

        try {

            readDataFromSpreadsheet();

        }
        catch (Exception e){

            e.printStackTrace();
        }

    }


    public static <XSSFSheet> void readDataFromSpreadsheet () {


        try {

            //Creating package object by reading excel file
            OPCPackage pkg = OPCPackage.openOrCreate(new File("C:\\MyFolder\\myProgramming\\TestData\\TakeAwayData.xlsx"));

            //Creating worbook object from package
            XSSFWorkbook workbook = new XSSFWorkbook(pkg);
            //Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);


            //Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.rowIterator();

            //Traversing through each row. Which in our case is individual test case.
            while(rowIterator.hasNext()) {
                //Using rowIterator to create each individual read object
                Row row = rowIterator.next();
                int rowIndex = row.getRowNum(); //getting row index (starting from 0)
                System.out.println("Current Row is: " + rowIndex );

                if( 0 != rowIndex) { //Ignoring first row as it is header

                    String  Type = null;
                    String Option = null;
                    String Address = null;
                    String PostCode = null;
                    String City = null;
                    String Name = null;
                    String PhoneNum = null;
                    String email = null;
                    int columnIndex = 0;


                    //For each row, iterate through each columns i.e going through each variable in test case
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while(cellIterator.hasNext()) {

                        Cell cell = cellIterator.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING); //we are marking cell as string even if it is a number

                        columnIndex = cell.getColumnIndex();

                        if(columnIndex == 0){
                            //    driver.findElement(By.name("UserName")).sendKeys(cell.getStringCellValue());
                            Type = cell.getStringCellValue();
                        }
                        else if (columnIndex == 1) {

                            Option = cell.getStringCellValue();
                        }

                        else if (columnIndex == 2) {

                            Address = cell.getStringCellValue();
                        }
                        else if (columnIndex == 3) {

                            PostCode = cell.getStringCellValue();
                        }
                        else if (columnIndex == 4) {

                            City = cell.getStringCellValue();
                        }

                        else if (columnIndex == 5) {

                            Name = cell.getStringCellValue();
                        }

                        else if (columnIndex == 6) {

                            PhoneNum = cell.getStringCellValue();
                        }

                        else if (columnIndex == 7) {

                            email  = cell.getStringCellValue();
                        }

                        //  driver.findElement(By.name("Password")).sendKeys(cell.getStringCellValue());
                    }
                    System.out.println("Executing scripts with data: ");

                    //call selenium Takeaway method execute case which takes all the test variables
                    // and calls executeCase and returns order reference number
                    String[] resultArray= TakeAway.executeCase(Type,Option,Address,PostCode,City,Name,PhoneNum,email);

                    row.createCell(columnIndex + 1).setCellValue(resultArray[0]);
                    row.createCell(columnIndex + 2).setCellValue(resultArray[1]);
                    row.createCell(columnIndex + 3).setCellValue(resultArray[2]);



                }

            }
            writeDataFromExcel(sheet, workbook);


        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error reading spreadsheet");
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            // TODO Auto-generated catch block

            System.out.println("Spread sheet has invalid format: ");

            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static <XSSFSheet> void  writeDataFromExcel(XSSFSheet sh, XSSFWorkbook wb)
    {
        try
        {

            // XSSFRow row=sh.getRow(rowcount);
            FileOutputStream webdata=new FileOutputStream("C:\\MyFolder\\myProgramming\\TestData\\TakeAwayData_output.xlsx");
            // row.createCell(columncount).setCellValue(value);
            wb.write(webdata);
            webdata.close();


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}

 */