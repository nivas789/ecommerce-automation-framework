package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private Workbook workbook;
    private Sheet sheet;

    public ExcelUtils(String filePath, String sheetName) {

        try {

            FileInputStream fileInputStream =
                    new FileInputStream(filePath);

            workbook = new XSSFWorkbook(fileInputStream);

            // Use the first worksheet
            sheet = workbook.getSheetAt(0);

            fileInputStream.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public int getRowCount() {

        return sheet.getPhysicalNumberOfRows();
    }

    public int getColumnCount() {

        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    public String getCellData(int rowNumber, int columnNumber) {

        Row row = sheet.getRow(rowNumber);

        if (row == null) {
            return "";
        }

        Cell cell = row.getCell(columnNumber);

        if (cell == null) {
            return "";
        }

        DataFormatter formatter = new DataFormatter();

        return formatter.formatCellValue(cell);
    }

    public void closeWorkbook() {

        try {

            if (workbook != null) {
                workbook.close();
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}