/**
 * 
 */
package my.housekeeping.user.service;

import java.sql.SQLException;

import my.housekeeping.user.dao.UserDao;
import my.housekeeping.user.domain.User;

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
	
	public void registerService(User user){
		//完善数据
		user.setRole(1);
		user.setSex(1);
		user.setState(1);
		/*
		 * 插入数据库
		 */
		try{
			userDao.register(user);
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
}
