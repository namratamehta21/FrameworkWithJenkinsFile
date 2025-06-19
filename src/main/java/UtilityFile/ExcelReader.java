package UtilityFile;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

    private Sheet sheet;

    public ExcelReader(String filePath, String sheetName) {
        System.out.println("File path is : " + filePath);
        System.out.println("Sheet name is : " + sheetName);
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Workbook workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet '" + sheetName + "' not found in Excel file.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load Excel sheet: " + e.getMessage());
        }
    }

    public Map<String, String> getDataByScenario(String scenarioTitle) {
        Map<String, String> data = new HashMap<>();

        if (sheet == null) {
            throw new IllegalStateException("Sheet not initialized properly.");
        }

        int lastRow = sheet.getLastRowNum();
        boolean scenarioFound = false;
        Map<Integer, String> headerIndex = new HashMap<>();

        for (int i = 0; i <= lastRow; i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;

            Cell firstCell = row.getCell(0);
            if (firstCell != null && firstCell.getCellType() == CellType.STRING &&
                firstCell.getStringCellValue().trim().equalsIgnoreCase(scenarioTitle.trim())) {

                scenarioFound = true;
                Row headerRow = sheet.getRow(i + 1);
                if (headerRow == null) {
                    throw new IllegalStateException("Header row missing after scenario title: " + scenarioTitle);
                }

                for (Cell cell : headerRow) {
                    headerIndex.put(cell.getColumnIndex(), cell.getStringCellValue().trim());
                }

                Row dataRow = sheet.getRow(i + 2);
                if (dataRow == null) {
                    throw new RuntimeException("No data found under scenario: " + scenarioTitle);
                }

                System.out.println("Reading data for scenario: " + scenarioTitle);
                for (Map.Entry<Integer, String> entry : headerIndex.entrySet()) {
                    Cell dataCell = dataRow.getCell(entry.getKey());
                    String value = "";

                    if (dataCell != null) {
                        switch (dataCell.getCellType()) {
                            case STRING:
                                value = dataCell.getStringCellValue();
                                break;
                            case NUMERIC:
                                value = (dataCell.getNumericCellValue() == (int) dataCell.getNumericCellValue())
                                        ? String.valueOf((int) dataCell.getNumericCellValue())
                                        : String.valueOf(dataCell.getNumericCellValue());
                                break;
                            case BOOLEAN:
                                value = String.valueOf(dataCell.getBooleanCellValue());
                                break;
                            default:
                                value = "";
                        }
                    }

                    value = value.trim();
                    data.put(entry.getValue(), value);
                    System.out.println(entry.getValue() + " = " + value);
                }

                break;
            }
        }

        if (!scenarioFound) {
            throw new RuntimeException("Scenario title not found in Excel: " + scenarioTitle);
        }

        return data;
    }
}
