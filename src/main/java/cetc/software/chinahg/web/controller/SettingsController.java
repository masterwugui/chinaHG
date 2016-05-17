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

import cetc.software.chinahg.util.StringUtil;
import cetc.software.chinahg.web.service.DmbService;
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

	public DmbService dmbService;

	public DmbService getDmbService() {
		return dmbService;
	}

	@Resource(name = "dmbService")
	public void setDmbService(DmbService dmbService) {
		this.dmbService = dmbService;
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

	@RequestMapping(value = "updateYH.json")
	public void updateYH(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "yhbh", required = true) String yhbh,
			@RequestParam(value = "yhxm", required = true) String yhxm,
			@RequestParam(value = "yhdm", required = true) String yhdm,
			@RequestParam(value = "yhzw", required = true) String yhzw,
			@RequestParam(value = "yh_jobNum", required = true) String yh_jobNum,
			@RequestParam(value = "yh_permission", required = true) String yh_permission,
			@RequestParam(value = "yhkl", required = true) String yhkl) {
		int permisssion = 2;
		yh_permission = StringUtil.getStrConvert(yh_permission);
		if (yh_permission.equals("高级用户")) {
			permisssion = 1;
		} else if (yh_permission.equals("普通用户")) {
			permisssion = 2;
		}
		xtglyhbService.updateUser(StringUtil.getStrConvert(yhbh),
				StringUtil.getStrConvert(yhdm), StringUtil.getStrConvert(yhxm),
				StringUtil.getStrConvert(yhkl), StringUtil.getStrConvert(yhzw),
				StringUtil.getStrConvert(yh_jobNum), permisssion);
	}
	
	@RequestMapping(value = "updateYhSelected.json")
	public void updateYhSelected(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "yhbh", required = true) int yhbh,
			@RequestParam(value = "isSelected", required = true) int isSelected) {
		xtglyhbService.updateUserSelected(yhbh,isSelected);
	}
	
	@RequestMapping(value = "deleteYH.json")
	public void deleteYH(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "yhbh", required = true) int yhbh) {
		xtglyhbService.deleteXtglyhb(yhbh);
	}
	
	@RequestMapping(value = "getMaxDMBH.json")
	public ModelAndView getMaxDMBH(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "LX", required = true) int lx) {
		ModelAndView mav = new ModelAndView();
		int DMBH = dmbService.getMaxDmbh(lx);

		mav.addObject("DMBH", DMBH);

		return mav;
	}

	@RequestMapping(value = "updateDMBH.json")
	public ModelAndView updateDMBH(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "dmbh", required = true) int dmbh,
			@RequestParam(value = "cdlb", required = true) String dmms,
			@RequestParam(value = "lx", required = true) int lx) {
		ModelAndView mav = new ModelAndView();
		dmbService.updateDmbh(lx, dmbh, StringUtil.getStrConvert(dmms));
		return mav;
	}

	@RequestMapping(value = "deleteDMBH.json")
	public void deleteDMBH(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "dmbh", required = true) int dmbh,
			@RequestParam(value = "lx", required = true) int lx) {
		dmbService.deleteDmbh(lx, dmbh);
		;
	}
}
