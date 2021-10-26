package com.inetbanking.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
//Excel-->Workbook-->Sheet-->Row-->Cells
public class XLUtils {
    public  static FileInputStream fi;//FileInputSttream is used to open file in input mode
    public static FileOutputStream fo;//
    public static XSSFWorkbook wb;//
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;

public static int getrowcount(String xlfile/*filename*/ , String xlsheet /*Sheet name*/) throws IOException {
    fi = new FileInputStream(xlfile);
    wb = new XSSFWorkbook(fi);
ws = wb.getSheet(xlsheet);
int rowcount = ws.getLastRowNum();//putting value of last row number in variable
wb.close();
fi.close();
return rowcount;
}
public static int getcellcount(String xlfile, String xlsheet , int rownum) throws IOException {
    fi = new FileInputStream(xlfile);
    wb = new XSSFWorkbook(fi);
    ws = wb.getSheet(xlsheet);
    row = ws.getRow(rownum);
    int cellcount = row.getLastCellNum();
    wb.close();
    fi.close();
    return  cellcount;


}
public static String getcelldata(String xlfile, String xlsheet , int rownum , int column) throws IOException {
    fi = new FileInputStream(xlfile);
    wb = new XSSFWorkbook(fi);
    ws = wb.getSheet(xlsheet);
    row = ws.getRow(rownum);
cell = row.getCell(column);
String data;
try {
    DataFormatter formatter = new DataFormatter();
    String celldata = formatter.formatCellValue(cell);//Returns the formatted value of a cell as a String regarless of cell type.
    return celldata;
}
catch (Exception e) {
    data = "";
}
wb.close();
fi.close();
return data;
}
public static void setCellData(String xlfile , String xlsheet, int rownum , int column ,String data) throws IOException {//will write data in excel
    fi = new FileInputStream(xlfile);
    wb = new XSSFWorkbook(fi);
    ws=wb.getSheet(xlsheet);
    row = ws.getRow(rownum);
    cell = row.createCell(column);
    cell.setCellValue(data);
    fo = new FileOutputStream(xlfile);
    wb.write(fo);
    wb.close();
fi.close();
fo.close();
}


}
