package cetc.software.chinahg.web.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cetc.software.chinahg.data.dao.DmbDao;
import cetc.software.chinahg.data.dataobject.PubXtglYhb;
import cetc.software.chinahg.web.service.ManageWorkService;
import cetc.software.ksxt.web.service.model.checkModel;

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
}
