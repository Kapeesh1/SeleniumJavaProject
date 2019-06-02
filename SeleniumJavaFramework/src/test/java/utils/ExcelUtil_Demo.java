package utils;

public class ExcelUtil_Demo {

	public static void main(String[] args) {
		
		String projectPath= System.getProperty("user.dir");
		ExcelUtils excel = new ExcelUtils(projectPath+"/excel/data.xlsx", "UserData");
		excel.getRowCount();
		excel.getCellDataString(0, 0);
		excel.getCellDataNumber(1, 1);
	}
}
