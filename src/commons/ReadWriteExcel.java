package commons;

public class ReadWriteExcel {


//	public void writeDataAtCell(String filePath, String fileName, String sheetName, int iRow, int iColumn,
//			String data) {
//		Workbook wb = null;
//
//		try {
//			File file = new File(filePath + "//" + fileName);
//			FileInputStream inputStream;
//			inputStream = new FileInputStream(file);
//			String fileExtensionName = fileName.substring(fileName.indexOf("."));
//			if (fileExtensionName.equalsIgnoreCase(".xlsx")) {
//				wb = new XSSFWorkbook(inputStream);
//			} else if (fileExtensionName.equalsIgnoreCase(".xls")) {
//				wb = new HSSFWorkbook(inputStream);
//			}
//
//			Sheet sheet = wb.getSheet(sheetName);
//			Row row = sheet.getRow(iRow);
//			if (row == null) {
//				row = sheet.createRow(iRow);
//			}
//			Cell cell = row.createCell(iColumn, CellType.STRING);
//			cell.setCellValue(data);
//
//			inputStream.close();
//
//			FileOutputStream outputStream = new FileOutputStream(file);
//			wb.write(outputStream);
//			wb.close();
//			outputStream.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public String ReadDataAtCell(String filePath, String fileName, String sheetName, int iRow, int iColumn) {
//		Workbook wb = null;
//		String data = "";
//		try {
//			File file = new File(filePath + "//" + fileName);
//			FileInputStream inputStream;
//			inputStream = new FileInputStream(file);
//			String fileExtensionName = fileName.substring(fileName.indexOf("."));
//			if (fileExtensionName.equalsIgnoreCase(".xlsx")) {
//				wb = new XSSFWorkbook(inputStream);
//			} else if (fileExtensionName.equalsIgnoreCase(".xls")) {
//				wb = new HSSFWorkbook(inputStream);
//			}
//
//			Sheet sheet = wb.getSheet(sheetName);
//			Row row = sheet.getRow(iRow);
//			Cell cell = row.getCell(iColumn);
//
//			if (cell != null) {
//				data = cell.getStringCellValue().toString();
//			}
//
//			inputStream.close();
//			wb.close();
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return data;
//	}

	
}
