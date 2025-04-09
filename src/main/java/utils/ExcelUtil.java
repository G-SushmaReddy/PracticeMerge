package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {

    private static XSSFSheet sheet;

    public static Object[][] getLoginData(String filepath,String sheetName)
    {
        FileInputStream file = null;
        try{
            file = new FileInputStream(filepath);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();
            Object[][] data = new Object[rowCount][colCount];

            for(int i=1;i<=rowCount;i++)
            {
                Row row = sheet.getRow(i);
                for(int j=0;j<colCount;j++)
                {
                    Cell cell = row.getCell(j);
                    data[i-1][j] = cell.getStringCellValue();
                }
            }
            return data;

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(file!=null)
                {
                    file.close();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }
}
