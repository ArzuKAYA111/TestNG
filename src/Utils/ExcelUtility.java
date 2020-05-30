package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtility {

	public static Workbook book;
	public static Sheet sheet;
	
public static void openExcel(String filePath){
	
	try {
		FileInputStream fileIS=new FileInputStream(filePath);
	} catch (IOException e) {
	
		e.printStackTrace();
	}	
}


public static void loadSheet(String sheetName) {
	sheet= book.getSheet(sheetName);
	
}

private static int rowCount() {
	return sheet.getPhysicalNumberOfRows();
}

private static int colsCount(int rowIndex) {
	return sheet.getRow(rowIndex).getLastCellNum();
}

private static String cellData (int rowIndex,int colIndex) {
	
	return sheet.getRow(rowIndex).getCell(colIndex).toString();
}


//return a 2d object array of data

public static Object[][] excelIntoArray(String filePath, String sheetName){
	
	openExcel(filePath);
	 loadSheet(sheetName);
	
	int rows =rowCount();
	int cols=colsCount(0);
	
	
	Object[] [] data =new Object [rows-1][cols];
	//iterating rows 
	for (int i=1; i <rows; i++) {
		
		//iterating cols 	
	for(int j=0; j<cols; j++)	{
		//storing values into 2D array
		data [i-1][j]=cellData(i,j);
		
	}
	
	}
	return data;
}


//HW Create a method that will return a List of Maps

//public static List<LinkedHashMap> ExcelIntoList(String filePath, String sheetName){
//	openExcel(filePath);
//	 loadSheet(sheetName);
//	
//	int rows =rowCount();
//	int cols=colsCount(0);
//	
//	List<LinkedHashMap> usedData=new LinkedHashMap<> ();
//	//iterating rows 
//		for (int i=1; i <rows; i++) {
//			
//			//iterating cols 	
//		for(int j=0; j<cols; j++)	{
//			usedData.add [i-1][j]=cellData(i,j);
//			
//		}
//		
//	
//	return usedData;
//}



//    from someONe YNs
//for (int i = 0; i < lastRowNum; i++) {
//    Map<Object, Object> datamap = new HashMap<>();
//    for (int j = 0; j < lastCellNum; j++) {
//      datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
//    }
//    obj[i][0] = datamap;
//  }
//  return  obj;










}
