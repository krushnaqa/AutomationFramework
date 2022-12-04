package basicUtility;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelFileUtility {
	

	public class GenericForExcel {
	public GenericForExcel GFE=new GenericForExcel();

		public void getSheetNumberName(String projectPath) {
			String sheetName="";
			try {
				FileInputStream fis=new FileInputStream(projectPath);
				Workbook wb=WorkbookFactory.create(fis);
				int s2=wb.getNumberOfSheets();
				for(int i=0;i<=s2;i++) {
					sheetName=wb.getSheetName(i);
					System.out.print("Sheet Names are "+sheetName+" ");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void getRowAndCellNumber(String projectPath) {
			String sheetName="";
			try {
				FileInputStream fis=new FileInputStream(projectPath);
				Workbook wb=WorkbookFactory.create(fis);
				Sheet s=wb.getSheet(sheetName);
				int getLastRowNum=s.getLastRowNum();
				System.out.println("Number of rows are : "+getLastRowNum);
				int getLastCellNum =s.getRow(0).getLastCellNum();
				System.out.println("Number of cells are : "+getLastCellNum);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void getallValuesOfSheet(String projectPath,String sheetName) {
			try {
				FileInputStream fis=new FileInputStream(projectPath);
				Workbook wb=WorkbookFactory.create(fis);
				Sheet s=wb.getSheet(sheetName);
				int noOfRows=s.getLastRowNum();
				Row r=s.getRow(0);
				HashMap <String,String> HM=new HashMap<String,String>();
				String columnName="",columnValue="";
				int noOfCells=r.getLastCellNum();
				for(int i=1;i<=noOfRows;i++){
					for(int j=0;j<noOfCells;j++) {
						columnName=r.getCell(j).getStringCellValue();
						DataFormatter formatter = new DataFormatter();
						Cell cell = s.getRow(i).getCell(j);
						columnValue = formatter.formatCellValue(cell);
						HM.put(columnName, columnValue);	
					}
					System.out.println(HM);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void getValueOfRow(String projectPath,String sheetName,int rowNo) {
			try {
				FileInputStream fis=new FileInputStream(projectPath);
				Workbook wb=WorkbookFactory.create(fis);
				Sheet s=wb.getSheet(sheetName);
				int noOfRows=s.getLastRowNum();
				Row r=s.getRow(0);
				HashMap <String,String> HM=new HashMap<String,String>();
				String columnName="",columnValue="";
				int noOfCells=r.getLastCellNum();
				for(int i=1;i<=noOfRows;i++){
					for(int j=0;j<noOfCells;j++) {
						columnName=r.getCell(j).getStringCellValue();
						DataFormatter formatter = new DataFormatter();
						Cell cell = s.getRow(rowNo).getCell(j);
						columnValue = formatter.formatCellValue(cell);
						HM.put(columnName, columnValue);	
					}

				}
				System.out.println(HM);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void getValueOfRowCell(String projectPath,String sheetName,int rowNo,String key) {
			try {
				FileInputStream fis=new FileInputStream(projectPath);
				Workbook wb=WorkbookFactory.create(fis);
				Sheet s=wb.getSheet(sheetName);
				int noOfRows=s.getLastRowNum();
				Row r=s.getRow(0);
				HashMap <String,String> HM=new HashMap<String,String>();
				String columnName="",columnValue="";
				int noOfCells=r.getLastCellNum();
				for(int i=1;i<=noOfRows;i++){
					for(int j=0;j<noOfCells;j++) {
						columnName=r.getCell(j).getStringCellValue();
						DataFormatter formatter = new DataFormatter();
						Cell cell = s.getRow(rowNo).getCell(j);
						columnValue = formatter.formatCellValue(cell);
						HM.put(columnName, columnValue);	
					}

				}
				System.out.println(HM.get(key));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public class WriteDataInExcel {
			FileInputStream fis=null;
			FileOutputStream fos=null;
			public void writeData(String projectPath,String sheetName,int rowNo,int colNo,String data){
				try {
					fis=new FileInputStream(projectPath);
					Workbook wb=WorkbookFactory.create(fis);
					Sheet s=wb.getSheet(sheetName);
					int noOfRows=s.getLastRowNum();
					if(rowNo<=noOfRows) {
					s.getRow(rowNo).createCell(colNo).setCellValue(data);
					}else {
					s.createRow(rowNo).createCell(colNo).setCellValue(data);
					}
					fos=new FileOutputStream(projectPath);
					wb.write(fos);

				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
