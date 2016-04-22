package cetc.software.chinahg.web.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cetc.software.chinahg.data.dao.DmbDao;
import cetc.software.chinahg.data.dataobject.ExamDmb;
import cetc.software.chinahg.data.dataobject.PubXtglYhb;
import cetc.software.chinahg.web.service.ManageWorkService;
import cetc.software.chinahg.web.service.XtglyhbService;
import cetc.software.ksxt.web.service.model.checkModel;
import cetc.software.ksxt.web.service.model.zghgUserModel;

@Controller
public class LoginController implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 5934993450538015681L;
	/**
	 *  
	 */
	private static int CDLX1 = 1, CDLX2 = 2, CDLX3 = 3, JCNR = 4, JCYQ = 5,
			YWLB = 6;

	private DmbDao dmbDao;

	public DmbDao getDmbDao() {
		return dmbDao;
	}

	@Resource(name = "dmbDao")
	public void setDmbDao(DmbDao dmbDao) {
		this.dmbDao = dmbDao;
	}

	private XtglyhbService xtglyhbService;

	public XtglyhbService getXtglyhbService() {
		return xtglyhbService;
	}

	@Resource(name = "xtglyhbService")
	public void setXtglyhbService(XtglyhbService xtglyhbService) {
		this.xtglyhbService = xtglyhbService;
	}
	
	private ManageWorkService manageWorkService;

	public ManageWorkService getManageWorkService() {
		return manageWorkService;
	}

	@Resource(name = "manageWorkService")
	public void setManageWorkService(ManageWorkService manageWorkService) {
		this.manageWorkService = manageWorkService;
	}
	
	@RequestMapping(value = "index.do")
	public ModelAndView showLogin(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		System.out.println("转到登录页面");
		ModelAndView mav = new ModelAndView("page-login");
		return mav;
	}

	@RequestMapping(value = "toManageHome.do")
	public ModelAndView toHome(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		ModelAndView mav = new ModelAndView("Manager/managerHome");
		List<ExamDmb> cdList1 = dmbDao.dmbList(CDLX1);
		List<ExamDmb> ywist = dmbDao.dmbList(YWLB);
		List<ExamDmb> jcyqList = dmbDao.dmbList(JCYQ);
		mav.addObject("cdList", cdList1);
		mav.addObject("ywList", ywist);
		mav.addObject("jcyqList", jcyqList);
		
		List<checkModel> modelList = manageWorkService.getCheckList();
		mav.addObject("modelList", modelList);
		
		return mav;
	}

	@RequestMapping(value = "toSettings.do")
	public ModelAndView toSettings(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		ModelAndView mav = new ModelAndView("Manager/settings");
		List<zghgUserModel> userList = xtglyhbService.getUserList();
		mav.addObject("userList", userList);
		return mav;
	}

	@RequestMapping(value = "/login.json")
	public synchronized ModelAndView loginJson(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "yhdm", required = false) String yhdm,
			@RequestParam(value = "yhkl", required = false) String yhkl)
			throws IOException {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		PubXtglYhb pubXtglYhb = xtglyhbService.getXtglyhbByYhdmYhkl(yhdm, yhkl);
		if (pubXtglYhb != null) {
			session.setAttribute("yhmc", pubXtglYhb.getYhmc());
			session.setAttribute("userId", pubXtglYhb.getYhbh());
		} else {
			System.out.println("fail to log in !");
		}
		String permission = pubXtglYhb.getPermission();
		mav.addObject("permission", permission);
		return mav;
	}
}
