package commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public void WriteDataAtCell(String filename, String sheetname, int irow, int icol, String input_data) {

		// load file can xu ly
		File fi = new File(filename);
		FileInputStream fis;
		try {
			fis = new FileInputStream(fi);
			// tao 1 cai workbook tu file input stream
			// .xlx va .xlsx
			Workbook wb = new XSSFWorkbook(fis);

			Sheet sh = wb.getSheet(sheetname); // by name
			// Sheet sh = wb.getSheetAt(1); //get sheet by index

			Row rw = sh.getRow(irow);
			if (rw == null) {
				rw = sh.createRow(irow);
			}

			Cell cell = rw.getCell(icol);
			if (cell == null) {
				cell = rw.createCell(icol, CellType.STRING);
			}
			cell.setCellValue(input_data);

			// thao tac ctr S
			FileOutputStream fo = new FileOutputStream(fi);
			wb.write(fo);

			wb.close();
			fo.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void WriteDataAtRow(String filename, String sheetname, int irow_start, int icol, String input_data) {
		// input_data = "data1;data2;data3"
		// load file can xu ly
		File fi = new File(filename);
		FileInputStream fis;
		try {
			fis = new FileInputStream(fi);
			// tao 1 cai workbook tu file input stream
			// .xlx va .xlsx
			Workbook wb = new XSSFWorkbook(fis);

			Sheet sh = wb.getSheet(sheetname); // by name
			// Sheet sh = wb.getSheetAt(1); //get sheet by index

			String[] rs = input_data.split(";");
			for (String str : rs) {
				Row rw = sh.getRow(irow_start);
				if (rw == null) {
					rw = sh.createRow(irow_start);
				}

				Cell cell = rw.getCell(icol);
				if (cell == null) {
					cell = rw.createCell(icol, CellType.STRING);
				}
				cell.setCellValue(str);
				irow_start = irow_start + 1;
			}

			// thao tac ctr S
			FileOutputStream fo = new FileOutputStream(fi);
			wb.write(fo);

			wb.close();
			fo.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String ReadDataAtCell(String filename, String sheetname, int irow, int icol) {
		// input_data = "data1;data2;data3"
		// load file can xu ly
		File fi = new File(filename);
		FileInputStream fis;
		String output_data="";
		try {
			fis = new FileInputStream(fi);
			// tao 1 cai workbook tu file input stream
			// .xlx va .xlsx
			Workbook wb = new XSSFWorkbook(fis);

			Sheet sh = wb.getSheet(sheetname); // by name
			// Sheet sh = wb.getSheetAt(1); //get sheet by index

			Row rw = sh.getRow(irow);
			if(rw!=null) {
				Cell cell = rw.getCell(icol);
				if(cell!=null) {
					output_data = cell.getRichStringCellValue().toString();
				}
			}
			
			wb.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output_data;
	}
}
