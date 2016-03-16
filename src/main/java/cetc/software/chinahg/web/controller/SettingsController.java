package cetc.software.chinahg.web.controller;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cetc.software.chinahg.web.service.XtglyhbService;

@Controller
public class SettingsController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6663124548339616407L;
	
	private XtglyhbService xtglyhbService;
	public XtglyhbService getXtglyhbService() {
		return xtglyhbService;
	}

	@Resource(name = "xtglyhbService")
	public void setXtglyhbService(XtglyhbService xtglyhbService) {
		this.xtglyhbService = xtglyhbService;
	}
	
	@RequestMapping(value = "addYh.json")
	public ModelAndView addYh(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "yhdm", required = true) String yhdm,
			@RequestParam(value = "yhkl", required = true) String yhkl) {
		ModelAndView mav = new ModelAndView();
		xtglyhbService.insertNewHgUser(yhdm, yhkl);
		return mav;
	}

}
