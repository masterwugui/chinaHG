package cetc.software.chinahg.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SecurityInterceptor implements HandlerInterceptor {

	private static final String LOGIN_URL = "/chinahg/index.do";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 不过滤的uri
		String[] notFilter = new String[] { "login", "index.jsp", "index.do", "toHome.do" };

		String[] notFilterEnd = new String[] { ".css", ".js", ".jsp", ".JPG",
				".PNG", ".JPEG", ".jpg", ".png", ".jpeg",".html"};

		// 请求的uri
		String uri = request.getRequestURI();

		// 是否过滤
		boolean doFilter = true;
		if (uri.equals("/chinahg/"))
			doFilter = false;
		for (String s : notFilter) {
			if (uri.indexOf(s) != -1) {
				// 如果uri中包含不过滤的uri，则不进行过滤
				doFilter = false;
				break;
			}
		}
		for (String s : notFilterEnd) {
			if (uri.endsWith(s)) {
				// 如果uri中包含不过滤的uri，则不进行过滤
				doFilter = false;
				break;
			}
		}
		if (doFilter) {
			HttpSession session = request.getSession(true);
			// 从session 里面获取用户名的信息
			Object obj = session.getAttribute("yhmc");
			// 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆
			if (obj == null || "".equals(obj.toString())) {
				System.out.println("没登陆");
				response.sendRedirect(LOGIN_URL);
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest req,
			HttpServletResponse res, Object arg2, Exception arg3)
			throws Exception {
	}

}