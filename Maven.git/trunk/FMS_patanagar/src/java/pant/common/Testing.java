/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pant.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author kapil
 */
public class Testing {
    public static void writeCountryListToFile(String fileName) throws Exception{
        Workbook workbook = null;
         
         
         File file=new File(fileName);
        Sheet sheet = null;
         
int rowIndex = 1;
         if(!file.exists()){
             if(fileName.endsWith("xls")){
            workbook = new HSSFWorkbook();
        }else{
            throw new Exception("invalid file name, should be xls or xlsx");
        }
             sheet = workbook.createSheet("Countries");
             System.out.println(fileName + " written started");
             Row row = sheet.createRow(0);
            Cell cell0 = row.createCell(0);
            cell0.setCellValue("Country");
            Cell cell1 = row.createCell(1);
            cell1.setCellValue("Code");
         }
         else{
             FileInputStream fis = new FileInputStream(file);
             workbook = new HSSFWorkbook(fis);
             sheet = workbook.getSheetAt(0);
             rowIndex=sheet.getPhysicalNumberOfRows();
             System.out.println("rowIndex: "+rowIndex);
         }
        for(int i=0;i<10;i++){
            System.out.println("rowIndex" +rowIndex);
            Row row = sheet.createRow(rowIndex);
            Cell cell0 = row.createCell(0);
            cell0.setCellValue("GHH");
            Cell cell1 = row.createCell(1);
            cell1.setCellValue("d");
            rowIndex++;
        }
         
        //lets write the excel data to file now
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();
        System.out.println(fileName + " written successfully");
    }
    
    public static void main(String args[]) throws Exception{
       
        Testing.writeCountryListToFile("Countries.xls");
    }
}
