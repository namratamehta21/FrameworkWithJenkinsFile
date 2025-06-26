package UtilityFile;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelReader 
{
    private final String filePath;

    public ExcelReader(String filePath)
    {
        this.filePath = filePath;
    }

    public List<Map<String, String>> readExcelData(String sheetName, String scenarioName) throws FileNotFoundException, IOException 
    {
    	System.out.println("Inside excel sheet reading part...!!!!!");
       // Map<String, List<Map<String, String>>> scenarioDataMap = new LinkedHashMap<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis))
        {

        	Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) 
            {
                System.out.println("Sheet " + sheetName + " not found.");
                return null;
            }
            System.out.println("Sheet " + sheetName + " found.");
            
            int totalRows = sheet.getPhysicalNumberOfRows()+1;
            int scenarioRow = -1;

            System.out.println("Total rowssssssssssssssss:::::::::::::::::"+totalRows);
         // Find the row where the scenario name appears (in the first column, usually)
            for (int i = 0; i < totalRows; i++) 
            { // Start from 1 if row 0 is header
                Row row = sheet.getRow(i);
                
                if (row == null) 
                	continue; 
                
                 Cell cell = row.getCell(0); // Assuming scenario names are in first column
                 
                 if (cell != null) 
                 {
                	    System.out.println("Row " + i + " Cell Value: " + cell.toString());

                	    if (cell.getCellType() == CellType.STRING &&
                	        cell.getStringCellValue().trim().equalsIgnoreCase(scenarioName.trim())) 
                	    {
                	        scenarioRow = i;
                	        System.out.println("Scenario found at row number: " + scenarioRow);
                	        break;
                	    }
                	}
              }
            
         // Begin new logic from here (line 61)
            List<Map<String, String>> dataList = new ArrayList<>();

            if (scenarioRow != -1 && scenarioRow + 1 < totalRows) 
            {
                Row headerRow = sheet.getRow(scenarioRow + 1);
                if (headerRow == null) 
                    return null;

                List<String> headers = new ArrayList<>();
                for (Cell cell : headerRow) 
                {
                    headers.add(cell.toString().trim());
                }
                System.out.println("List of header is : "+headers);
                
                for (int i = scenarioRow + 2; i < totalRows; i++) 
                {
                    Row dataRow = sheet.getRow(i);
                    System.out.println("Values found in excel at :"+dataRow);
                    
                    if (dataRow == null) 
                    	break;

                    boolean isEmptyRow = true;
                    for (int k = 0; k < headers.size(); k++) 
                    {
                        Cell cell = dataRow.getCell(k);
                        if (cell != null && !cell.toString().trim().isEmpty()) 
                        {
                            isEmptyRow = false;
                            break;
                        }
                    }
                    
                    if (isEmptyRow) break;
                    
                    Map<String, String> dataMap = new LinkedHashMap<>();
                    for (int j = 0; j < headers.size(); j++) 
                    {
                        Cell cell = dataRow.getCell(j);
                        String value = (cell != null) ? cell.toString().trim() : "";
                        dataMap.put(headers.get(j), value);
                    }

                    dataList.add(dataMap);
                }
            }
            // Log final data
            System.out.println("Extracted Data:");
            for (Map<String, String> dataMap : dataList) 
            {
                System.out.println("Returning data: " + dataMap);
            }

            return dataList;
        }
    }
}