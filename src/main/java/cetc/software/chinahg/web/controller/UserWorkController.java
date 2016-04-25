package cetc.software.chinahg.web.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import cetc.software.chinahg.web.service.UserService;
import cetc.software.ksxt.web.service.model.checkModel;
import cetc.software.ksxt.web.service.model.userCheckModel;

@Controller
public class UserWorkController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4235542482264334560L;
	UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	static String notStarted = "未开始", hasConfirmed = "已确认",
			hasFinished = "已完成";

	@RequestMapping(value = "toWork.do")
	public ModelAndView toWork(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("User/workToDo");
		HttpSession session = request.getSession();
		int yhbh = (int) session.getAttribute("userId");
		List<userCheckModel> modelNotStartedList = userService
				.getCheckListByYhAndStatus(yhbh, notStarted);
		List<userCheckModel> modelConfirmedList = userService
				.getCheckListByYhAndStatus(yhbh, hasConfirmed);
		List<userCheckModel> modelFinishedList = userService
				.getCheckListByYhAndStatus(yhbh, hasFinished);
		
		mav.addObject("modelNotStartedList", modelNotStartedList);
		mav.addObject("modelConfirmedList", modelConfirmedList);
		mav.addObject("modelFinishedList", modelFinishedList);
		
		int notStarted = modelNotStartedList.size();
		int	notFinished = modelConfirmedList.size();
		int hasFinished = modelFinishedList.size();
		
		int notFinished1 = notStarted + notFinished;
		
		session.setAttribute("notStarted", notStarted);
		session.setAttribute("notFinished", notFinished);
		session.setAttribute("notFinished1", notFinished1);
		session.setAttribute("hasFinishedNum", hasFinished);
		
		return mav;
	}

	@RequestMapping(value = "confirmCheck.json")
	public ModelAndView toWork(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "checkId", required = false) int checkId,
			@RequestParam(value = "status", required = false) int status) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		int yhbh = (int) session.getAttribute("userId");
		
		int notStarted = (int) session.getAttribute("notStarted");
		int notFinished = (int) session.getAttribute("notFinished");
		int notFinished1 = (int) session.getAttribute("notFinished1");
		int hasFinishedNum = (int) session.getAttribute("hasFinishedNum");
		
		String qrsj = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String statusStr = "";
		if (status == 0) {
			statusStr = hasConfirmed;
			notStarted--;
			notFinished++;
			session.setAttribute("notStarted", notStarted);
			session.setAttribute("notFinished", notFinished);
			
		} else if (status == 1) {
			statusStr = hasFinished;
			notFinished--;
			notFinished1--;
			hasFinishedNum++;
			session.setAttribute("notFinished", notFinished);
			session.setAttribute("notFinished1", notFinished1);
			session.setAttribute("hasFinishedNum", hasFinishedNum);
		}
		userCheckModel model = userService.updateCheckStatus(checkId, yhbh,
				statusStr, qrsj);

		mav.addObject("checkModel", model);

		return mav;
	}
	
	@RequestMapping(value = "getUserCheckInfo.json")
	public ModelAndView getUserCheckInfo(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "checkId", required = false) int checkId) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		int yhbh = (int) session.getAttribute("userId");
		userCheckModel model = userService.getUserCheckInfoByUserBhAndCheckBh(yhbh, checkId);

		mav.addObject("checkModel", model);

		return mav;
	}
}
