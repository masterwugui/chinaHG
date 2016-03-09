package cetc.software.chinahg.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;

/**
 * POI操作Excel
 * 
 * @since: 1.0
 * @version:1.0
 * @createTime:2011年07月21日 10：47：20
 * @updateTime:2011年07月21日 10：47：20
 * 
 */
public class PoiExcelSheetCopy {

	/**
	 * 根据源Sheet样式copy新Sheet
	 * 
	 * @param fromsheetname
	 * @param newsheetname
	 * @param targetFile
	 */
	public void copySheet(String fromsheetname, String newsheetname,
			String targetFile) {
		HSSFWorkbook wb = null;
		try {
			FileInputStream fis = new FileInputStream(targetFile);
			wb = new HSSFWorkbook(fis);
			HSSFSheet fromsheet = wb.getSheet(fromsheetname);
			if (fromsheet != null && wb.getSheet(newsheetname) == null) {
				HSSFSheet newsheet = wb.createSheet(newsheetname);
				// 设置打印参数
				newsheet.setMargin(HSSFSheet.TopMargin,
						fromsheet.getMargin(HSSFSheet.TopMargin));// 页边距（上）
				newsheet.setMargin(HSSFSheet.BottomMargin,
						fromsheet.getMargin(HSSFSheet.BottomMargin));// 页边距（下）
				newsheet.setMargin(HSSFSheet.LeftMargin,
						fromsheet.getMargin(HSSFSheet.LeftMargin));// 页边距（左）
				newsheet.setMargin(HSSFSheet.RightMargin,
						fromsheet.getMargin(HSSFSheet.RightMargin));// 页边距（右

				HSSFPrintSetup ps = newsheet.getPrintSetup();
				ps.setLandscape(false); // 打印方向，true：横向，false：纵向(默认)
				ps.setVResolution((short) 600);
				ps.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE); // 纸张类型

				File file = new File(targetFile);
				if (file.exists() && (file.renameTo(file))) {
					copyRows(wb, fromsheet, newsheet,
							fromsheet.getFirstRowNum(),
							fromsheet.getLastRowNum());
					FileOutputStream fileOut = new FileOutputStream(targetFile);
					wb.write(fileOut);
					fileOut.flush();
					fileOut.close();
				} else {
					System.out.println("文件不存在或者正在使用,请确认...");
				}
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 拷贝Excel行
	 * 
	 * @param wb
	 * @param fromsheet
	 * @param newsheet
	 * @param firstrow
	 * @param lastrow
	 */
	public void copyRows(HSSFWorkbook wb, HSSFSheet fromsheet,
			HSSFSheet newsheet, int firstrow, int lastrow) {
		if ((firstrow == -1) || (lastrow == -1) || lastrow < firstrow) {
			return;
		}
		// 拷贝合并的单元格
		Region region = null;
		for (int i = 0; i < fromsheet.getNumMergedRegions(); i++) {
			region = fromsheet.getMergedRegionAt(i);
			if ((region.getRowFrom() >= firstrow)
					&& (region.getRowTo() <= lastrow)) {
				newsheet.addMergedRegion(region);
			}
		}

		HSSFRow fromRow = null;
		HSSFRow newRow = null;
		HSSFCell newCell = null;
		HSSFCell fromCell = null;
		// 设置列宽
		for (int i = firstrow; i <= lastrow; i++) {
			fromRow = fromsheet.getRow(i);
			if (fromRow != null) {
				for (int j = fromRow.getLastCellNum(); j >= fromRow
						.getFirstCellNum(); j--) {
					int colnum = fromsheet.getColumnWidth((short) j);
					if (colnum > 100) {
						newsheet.setColumnWidth((short) j, (short) colnum);
					}
					if (colnum == 0) {
						newsheet.setColumnHidden((short) j, true);
					} else {
						newsheet.setColumnHidden((short) j, false);
					}
				}
				break;
			}
		}
		// 拷贝行并填充数据
		for (int i = 0; i <= lastrow; i++) {
			fromRow = fromsheet.getRow(i);
			if (fromRow == null) {
				continue;
			}
			newRow = newsheet.createRow(i - firstrow);
			newRow.setHeight(fromRow.getHeight());
			for (int j = fromRow.getFirstCellNum(); j < fromRow
					.getPhysicalNumberOfCells(); j++) {
				fromCell = fromRow.getCell((short) j);
				if (fromCell == null) {
					continue;
				}
				newCell = newRow.createCell((short) j);
				newCell.setCellStyle(fromCell.getCellStyle());
				int cType = fromCell.getCellType();
				newCell.setCellType(cType);
				switch (cType) {
				case HSSFCell.CELL_TYPE_STRING:
					newCell.setCellValue(fromCell.getRichStringCellValue());
					break;
				case HSSFCell.CELL_TYPE_NUMERIC:
					newCell.setCellValue(fromCell.getNumericCellValue());
					break;
				case HSSFCell.CELL_TYPE_FORMULA:
					newCell.setCellFormula(fromCell.getCellFormula());
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN:
					newCell.setCellValue(fromCell.getBooleanCellValue());
					break;
				case HSSFCell.CELL_TYPE_ERROR:
					newCell.setCellValue(fromCell.getErrorCellValue());
					break;
				default:
					newCell.setCellValue(fromCell.getRichStringCellValue());
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		PoiExcelSheetCopy ew = new PoiExcelSheetCopy();
		ew.copySheet("template", "test2", "f:/templet.xls");
	}
}
