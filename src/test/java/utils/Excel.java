package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static void excel(String c_name1,String c_hours1, String c_rating1,String c_name2,String c_hours2, String c_rating2,List<String> list1,List<String> list2,List<String> list3,List<String> list4,String errmsg) throws IOException {
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\Excelsheet\\Identifycourse.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet1 = workbook.createSheet("Course Details");
		XSSFRow row10 = sheet1.createRow(0);
		row10.createCell(0).setCellValue("Course Details");
		
		XSSFRow row11 = sheet1.createRow(1);
		row11.createCell(0).setCellValue("Course Name ");
		row11.createCell(1).setCellValue(c_name1);
		
		XSSFRow row12 = sheet1.createRow(2);
		row12.createCell(0).setCellValue("Learning Hours ");
		row12.createCell(1).setCellValue(c_hours1);
		
		XSSFRow row13 = sheet1.createRow(3);
		row13.createCell(0).setCellValue("Rating ");
		row13.createCell(1).setCellValue(c_rating1);
		
		XSSFRow row14 = sheet1.createRow(5);
		row14.createCell(0).setCellValue("Course Name ");
		row14.createCell(1).setCellValue(c_name2);
		
		XSSFRow row15 = sheet1.createRow(6);
		row15.createCell(0).setCellValue("Learning Hours ");
		row15.createCell(1).setCellValue(c_hours2);
		
		XSSFRow row16 = sheet1.createRow(7);
		row16.createCell(0).setCellValue("Rating ");
		row16.createCell(1).setCellValue(c_rating2);
		
		XSSFSheet sheet2 = workbook.createSheet("Language Learning");
		XSSFRow row20 = sheet2.createRow(0);
		row20.createCell(0).setCellValue("LANGUAGE LEARNING");
		
		XSSFRow row21 = sheet2.createRow(1);
		row21.createCell(0).setCellValue("LEVEL ");
		row21.createCell(1).setCellValue("BEGINNER");
		row21.createCell(2).setCellValue("INTERMEDIATE");
		row21.createCell(3).setCellValue("ADVANCED");
		row21.createCell(4).setCellValue("MIXED");
		
		int max = list1.size();
		int m = max+2;
			
				for(int i=2;i<m;i++) {
				XSSFRow row22 =sheet2.createRow(i);
				row22.createCell(1).setCellValue(list1.get(i-2));
				
				if(i+2<list2.size()) {
				row22.createCell(2).setCellValue(list2.get(i-2));
				}
				
				if(i+2<list3.size()) {
					row22.createCell(3).setCellValue(list3.get(i-2));
				}
				
				if(i+2<list4.size()) {
					row22.createCell(4).setCellValue(list4.get(i-2));
				}
				}
	    
		XSSFSheet sheet3 = workbook.createSheet("For Campus");
		XSSFRow row31 = sheet3.createRow(0);
		row31.createCell(0).setCellValue("FOR CAMPUS FORM");
		
		XSSFRow row32 = sheet3.createRow(1);
		row32.createCell(0).setCellValue("Error in Mail ");
		row32.createCell(1).setCellValue(errmsg);
		
		workbook.write(file);
		workbook.close();
		file.close();
	}
}
