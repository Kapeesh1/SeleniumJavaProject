package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath,String sheetName){
		try{
			workbook= new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		//getRowCount();
		//	getCellDataString(0,0);
		//getCellDataNumber(1,1);
	}
	public static int getRowCount(){
		int rowCount=0;
		try{
			rowCount=sheet.getPhysicalNumberOfRows();
			System.out.println("Count of rows: "+rowCount);
		}catch(Exception exp){
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();	
		}	
		return rowCount;
	}
	public static String getCellDataString(int rowNum, int colNum){
		String cellData=null;
		try{
			 cellData=sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println("user Cell data:" +cellData);
		}catch(Exception exp){
			exp.getMessage();
			exp.getCause();
			exp.printStackTrace();

		}
		return cellData;

	}

	public static void getCellDataNumber(int rowNum, int cellNum){
		try{
			double cellData=sheet.getRow(rowNum).getCell(cellNum).getNumericCellValue();
			System.out.println("user Cell data:" +cellData);
		}catch(Exception exp){
			exp.getMessage();
			exp.getCause();
			exp.printStackTrace();

		}

	}

	public static int getColCount(){
		int colCount=0;
		try{
			colCount=sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Count of col: "+colCount);
		}catch(Exception exp){
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();	
		}	
		return colCount;
	}

}







