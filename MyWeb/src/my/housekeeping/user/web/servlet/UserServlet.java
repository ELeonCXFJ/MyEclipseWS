/**
 * 
 */
package my.housekeeping.user.web.servlet;



import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.housekeeping.user.domain.User;
import my.housekeeping.user.service.UserService;
import my.housekeeping.user.service.exception.UserException;
import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

/**
 *  
 * @author Leon-Desktop
 *
 */
public class UserServlet extends BaseServlet {
	private UserService userService = new UserService();
	
	public String exit(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		request.getSession().invalidate();
		request.removeAttribute("msg");
		request.removeAttribute("code");
		request.removeAttribute("user");
		return "r:/index.jsp";
	}
	
	public String updatePassword(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		User formUser = CommonUtils.toBean(request.getParameterMap(), User.class);
		User user = (User)request.getSession().getAttribute("sessionUser");
		//若没有的登录，则返回登录界面
		if(user == null){
			System.out.println("还没登陆bug");
			request.setAttribute("msg","<script>alert('您还没有登录');</script>");
			request.setAttribute("code", "NOT_LOGIN");
			request.getSession().invalidate();
			return "f:/jsps/user/login.jsp";
		}
		try{
			request.setAttribute("msg","<script>alert('您还没有登录');</script>");
			userService.updatePassword(user.getUid(), formUser.getNewpassword(),
					formUser.getPassword());
			request.setAttribute("code", "SUCCESS");
			System.out.println("success");
			return "f:/jsps/user/pwd.jsp";
		}catch (UserException e){
			//request.setAttribute("msg", e.getMessage());
			//request.setAttribute("user", formUser);
			request.setAttribute("code", "ERROR");
			System.out.println("ERROR");
			return "f:/jsps/user/pwd.jsp";
		}
	}
	
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
		//System.out.println("1");
		User user = userService.loginService(formUser);
		//System.out.println("2");
		if(user == null){
			request.setAttribute("code", "NO_SUCH_USER");
			request.setAttribute("user", formUser);
			return "f:/jsps/user/login.jsp";
		}else{
			if(user.getState() == 0){
				request.setAttribute("msg","<script>alert('您还没有登录');</script>");

				request.setAttribute("code", "USER_DISABLED");
				request.setAttribute("Buser", formUser.getUsername());
				request.setAttribute("user", formUser);
				return "f:/jsps/user/login.jsp";
			}else{
				request.getSession().setAttribute("sessionUser", user);
				String username = user.getUsername();
				Cookie cookie = new Cookie("username",username);
				cookie.setMaxAge(1000 * 60 * 60 * 24 * 10);
				response.addCookie(cookie);
				//System.out.println("login success");
				return "r:/index.jsp";
			}
		}
	}
}
