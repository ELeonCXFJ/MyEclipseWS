/**
 * 
 */
package my.housekeeping.user.service;

import java.sql.SQLException;

import my.housekeeping.user.dao.UserDao;

/**
 *用户模块业务逻辑层
 * @author Leon-Desktop
 *
 */
public class UserService {
	private UserDao userDao = new UserDao();
	//用户名校验
	public boolean ajaxValidatorUserName(String username){
		try {
			 return userDao.ajaxValidatorUserName(username);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//email校验
	public boolean ajaxValidatorEmail(String email){
		try {
			return userDao.ajaxValidatorEmail(email);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
