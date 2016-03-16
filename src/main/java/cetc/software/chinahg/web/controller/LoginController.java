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

import cetc.software.chinahg.data.dataobject.PubXtglYhb;
import cetc.software.chinahg.web.service.XtglyhbService;
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
	private XtglyhbService xtglyhbService;
	public XtglyhbService getXtglyhbService() {
		return xtglyhbService;
	}

	@Resource(name = "xtglyhbService")
	public void setXtglyhbService(XtglyhbService xtglyhbService) {
		this.xtglyhbService = xtglyhbService;
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
		return mav;
	}

	@RequestMapping(value = "toWork.do")
	public ModelAndView toWork(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		ModelAndView mav = new ModelAndView("User/workToDo");
		return mav;
	}
	
	@RequestMapping(value = "toSettings.do")
	public ModelAndView toSettings(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		ModelAndView mav = new ModelAndView("Manager/settings");
		List<zghgUserModel> userList = xtglyhbService.getUserList();
		mav.addObject("userList",userList);
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
		mav.addObject("permission",permission);
		return mav;
	}
}
