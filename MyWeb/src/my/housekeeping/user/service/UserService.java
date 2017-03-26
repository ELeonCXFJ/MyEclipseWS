/**
 * 
 */
package my.housekeeping.user.service;

import java.sql.SQLException;

import my.housekeeping.user.dao.UserDao;
import my.housekeeping.user.domain.Address;
import my.housekeeping.user.domain.User;
import my.housekeeping.user.service.exception.UserException;

/**
 *用户模块业务逻辑层
 * @author Leon-Desktop
 *
 */

public class UserService {
	private UserDao userDao = new UserDao();

	
	/**
	 * 添加
	 * @param uid
	 * @param address
	 */
	public void addAddressService(int uid,Address address) throws UserException{
		address.setCity("上海市");
		address.setProvince("上海市");
		address.setUid(uid);
		try{
			userDao.addAddress(address);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	
	
	/**
	 * 修改密码
	 * @author Leon-Desktop
	 * @throws UserException
	 */
	public void updatePassword(int uid,String newPass,String oldPass) throws UserException {
		try{
			boolean bool = userDao.findByUidAndPassword(uid, oldPass);
			if(bool == false)
			{
				throw new UserException("原密码错误！");
			}
			
			userDao.updatePassword(uid, newPass);
		} catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	
	
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
	
	/**
	 * 登录服务
	 * @param user
	 * @return
	 */
	public User loginService(User user){
		try{
			return userDao.login(user.getUsername(),user.getPassword());
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}
}
