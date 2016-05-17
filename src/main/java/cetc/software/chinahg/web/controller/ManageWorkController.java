package cetc.software.chinahg.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cetc.software.chinahg.data.dao.DmbDao;
import cetc.software.chinahg.data.dataobject.ExamDmb;
import cetc.software.chinahg.util.FileOperateUtil;
import cetc.software.chinahg.web.service.ManageWorkService;
import cetc.software.chinahg.web.service.XtglyhbService;
import cetc.software.ksxt.web.service.model.checkModel;
import cetc.software.ksxt.web.service.model.userCheckModel;
import cetc.software.ksxt.web.service.model.zghgUserModel;

@Controller
public class ManageWorkController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DmbDao dmbDao;

	public DmbDao getDmbDao() {
		return dmbDao;
	}

	@Resource(name = "dmbDao")
	public void setDmbDao(DmbDao dmbDao) {
		this.dmbDao = dmbDao;
	}

	private ManageWorkService manageWorkService;

	public ManageWorkService getManageWorkService() {
		return manageWorkService;
	}

	private XtglyhbService xtglyhbService;

	public XtglyhbService getXtglyhbService() {
		return xtglyhbService;
	}

	@Resource(name = "xtglyhbService")
	public void setXtglyhbService(XtglyhbService xtglyhbService) {
		this.xtglyhbService = xtglyhbService;
	}

	@Resource(name = "manageWorkService")
	public void setManageWorkService(ManageWorkService manageWorkService) {
		this.manageWorkService = manageWorkService;
	}

	private static int CDLX1 = 1, CDLX2 = 2, CDLX3 = 3, JCNR = 4, JCYQ = 5,
			YWLB = 6;

	@RequestMapping(value = "/cqUser.json")
	public ModelAndView cqUser(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "cd", required = false) int cd,
			@RequestParam(value = "ywlb", required = false) int ywlb,
			@RequestParam(value = "jcyq", required = false) int jcyq) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		String scrYhmc = (String) session.getAttribute("yhmc");
		int scrYhbh = (int) session.getAttribute("userId");
		String nowTimeStr = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new Date());
		checkModel model = manageWorkService.cqUser(cd, ywlb, jcyq, scrYhmc,
				scrYhbh, nowTimeStr);
		model.setCdChn(dmbDao.getDmms(CDLX1, model.getCd()));
		model.setJcyqChn(dmbDao.getDmms(JCYQ, model.getJcyq()));
		model.setYwlbChn(dmbDao.getDmms(YWLB, model.getYwlb()));
		mav.addObject("checkModel", model);
		return mav;
	}

	@RequestMapping(value = "searchChecks.json")
	public ModelAndView searchChecks(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "yhbh", required = true) int yhbh,
			@RequestParam(value = "cd", required = true) int cd,
			@RequestParam(value = "ywlb", required = true) int ywlb,
			@RequestParam(value = "jcyq", required = true) int jcyq,
			@RequestParam(value = "startScsj", required = true) String startScsj,
			@RequestParam(value = "endScsj", required = true) String endScsj,
			@RequestParam(value = "startWcsj", required = true) String startWcsj,
			@RequestParam(value = "endWcsj", required = true) String endWcsj) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		List<userCheckModel> modelList = manageWorkService.searchChecks(yhbh,
				cd, ywlb, jcyq, startScsj, endScsj, startWcsj, endWcsj);
		session.setAttribute("searchResult", modelList);
		mav.addObject("modelList",modelList);
		return mav;
	}
	
	@RequestMapping(value = "removeCheck.json")
	public void removeCheck(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "checkId", required = true) int checkId) {
		manageWorkService.deleteCheck(checkId);
	}
	
	@RequestMapping(value = "printSearchResult.do", method = RequestMethod.GET)
	public void printSearchResult(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<userCheckModel> modelList = (List<userCheckModel>) session.getAttribute("searchResult");
		String resourcePath = null;
		try {
			resourcePath = ManageWorkController.class.getResource("/").toURI()
					.getPath();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		File inputfile = new File(resourcePath + "searchTemplate.xls");
		File outputfile = new File(System.currentTimeMillis() + ".xls");
		try {
			FileOutputStream os = new FileOutputStream(outputfile);

			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
					inputfile)); // 读取excel模板
			HSSFSheet sheet = workbook.getSheetAt(0); // 读取第二个工作簿
			HSSFRow row;
			HSSFCell cell = null;
			int rownum = 2; // 添加的起始行
			HSSFCellStyle style = getStyle(workbook);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
			int index = 1;
			for (userCheckModel model : modelList) {
				row = sheet.getRow(rownum);
				if (row == null) {
					sheet.createRow(rownum);
					row = sheet.getRow(rownum);
					// System.out.println();
					// continue;
				}
				myCreateCell(1, index + "", row, cell, style);// 序号
				myCreateCell(2, model.getScsj(), row, cell,
						style);// 生成时间
				myCreateCell(3, model.getZxr_name(), row, cell,
						style);// 用户名称
				myCreateCell(4, model.getCdChn(), row, cell,
						style);// 场地类别
				myCreateCell(5, model.getYwlbChn(), row, cell,
						style);// 业务类别
				myCreateCell(6, model.getJcyqChn(), row, cell,
						style);// 检查要求
				myCreateCell(7, model.getZxr_qrsj(), row, cell,
						style);// 确认时间
				myCreateCell(8, model.getZxr_wcsj(), row, cell,
						style);// 完成时间
				myCreateCell(9, model.getScr_name(), row, cell,
						style);// 派单领导
				index++;
				rownum++;
			}
			workbook.write(os);
			os.flush();
			os.close();
			String xls_name = "业务表" + ".xls";
			FileOperateUtil.download(request, response,
					outputfile.getAbsolutePath(), "", xls_name);
			File tmpFile = new File(outputfile.getAbsolutePath());
			if (tmpFile.exists()) {
				System.out
						.println("临时文件：" + tmpFile.getAbsolutePath() + "删除成功");

				tmpFile.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	private static void myCreateCell(int cellnum, String value, HSSFRow row,
			HSSFCell cell, HSSFCellStyle style) {
		if (row == null)
			return;
		cell = row.createCell((short) cellnum);
		cell.setCellValue(new HSSFRichTextString(value));
		cell.setCellStyle(style);
	}
	
	public static HSSFCellStyle getStyle(HSSFWorkbook workbook) {
		// 设置字体;
		HSSFFont font = workbook.createFont();
		// 设置字体大小;
		font.setFontHeightInPoints((short) 12);
		// 设置字体名字;
		font.setFontName("宋体");
		// font.setItalic(true);
		// font.setStrikeout(true);
		// 设置样式;
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置底边框;
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// 设置底边框颜色;
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		// 设置左边框;
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// 设置左边框颜色;
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		// 设置右边框;
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// 设置右边框颜色;
		style.setRightBorderColor(HSSFColor.BLACK.index);
		// 设置顶边框;
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		// 设置顶边框颜色;
		style.setTopBorderColor(HSSFColor.BLACK.index);
		// 在样式用应用设置的字体;
		style.setFont(font);
		// 设置自动换行;
		style.setWrapText(false);
		// 设置水平对齐的样式为居中对齐;
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 设置垂直对齐的样式为居中对齐;
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		return style;
	}
	
	@RequestMapping(value = "toCheckSearch.do")
	public ModelAndView toCheckSearch(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		ModelAndView mav = new ModelAndView("Manager/searchCheck");

		List<ExamDmb> cdList1 = dmbDao.dmbList(CDLX1);
		List<ExamDmb> ywist = dmbDao.dmbList(YWLB);
		List<ExamDmb> jcyqList = dmbDao.dmbList(JCYQ);
		mav.addObject("cdList", cdList1);
		mav.addObject("ywList", ywist);
		mav.addObject("jcyqList", jcyqList);

		List<zghgUserModel> userList = xtglyhbService.getUserList(2);
		mav.addObject("userList", userList);
		return mav;
	}
}
