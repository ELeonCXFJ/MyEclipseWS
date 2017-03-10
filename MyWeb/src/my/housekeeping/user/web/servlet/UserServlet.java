/**
 * 
 */
package my.housekeeping.user.web.servlet;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.housekeeping.user.domain.User;
import my.housekeeping.user.service.UserService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

/**
 *  
 * @author Leon-Desktop
 *
 */
public class UserServlet extends BaseServlet {
	private UserService userService = new UserService();
	
	/**
	 * ajax  username validation
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxValidatorUserName(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		//从 register.jsp 获取username
		String username = request.getParameter("username");
		String jsonResultString="";
		//通过service获取结果
		boolean b = userService.ajaxValidatorUserName(username);
		if(b)
	       jsonResultString = "{\"valid\":true}";
		else
	       jsonResultString = "{\"valid\":false}";
		
		
		System.out.println(b);
		//返回给客户端
		response.getWriter().print(jsonResultString);
		return null;
	}
	
	
	/**
	 * ajax email validation
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxValidatorEmail(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		String email = request.getParameter("email");
		String jsonResultString = "";
		boolean b = userService.ajaxValidatorEmail(email);
		if(b)
		       jsonResultString = "{\"valid\":true}";
			else
		       jsonResultString = "{\"valid\":false}";
		response.getWriter().print(jsonResultString);
		return null;
	}
	
	/**
	 * 
	 *注册功能
	 */
	public String register(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException {
		User formUser = CommonUtils.toBean(request.getParameterMap(), User.class);
		userService.registerService(formUser);
		
		return "index.jsp";
	}
	
	public String login(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		User formUser = CommonUtils.toBean(request.getParameterMap(), User.class);
		boolean b = userService.loginService(formUser);
		if(b)
			return "index.jsp";
		else
			return "jsps/user/login.jsp";
	}
}
