package utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        String filePath =
                "src/test/resources/testdata/LoginData.xlsx";

        String sheetName = "LoginData";

        ExcelUtils excelUtils =
                new ExcelUtils(filePath, sheetName);

        int rowCount = excelUtils.getRowCount();

        // We need exactly 3 columns:
        // username, password, expectedResult
        int columnCount = 3;

        Object[][] data =
                new Object[rowCount - 1][columnCount];

        for (int i = 1; i < rowCount; i++) {

            for (int j = 0; j < columnCount; j++) {

                data[i - 1][j] =
                        excelUtils.getCellData(i, j);
            }
        }

        excelUtils.closeWorkbook();

        return data;
    }
}