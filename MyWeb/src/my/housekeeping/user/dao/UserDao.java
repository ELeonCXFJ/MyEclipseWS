package my.housekeeping.user.dao;

import java.sql.SQLException;

import my.housekeeping.user.domain.User;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;



/**
 * 用户模块持久层
 * @author Leon-Desktop
 *
 */
public class UserDao {
	private QueryRunner qr = new TxQueryRunner();
	/**
	 * 校验用户名是否已经注册
	 * @throws SQLException 
	 * 
	 */
	public boolean ajaxValidatorUserName(String username) throws SQLException{
		String sql = "select count(1) from userinfo where usr=?";
		Number number = (Number)qr.query(sql,new ScalarHandler(), username);
		System.out.println(number);
		if(number.intValue() == 0)
			return true;//用户不存在
		else
			return false; //用户已存在
	}
	
	public boolean ajaxValidatorEmail(String email) throws SQLException{
		String sql = "select count(1) from userinfo where email=?";
		Number number = (Number)qr.query(sql,new ScalarHandler(), email);
		if(number.intValue() == 0)
			return true;//email不存在
		else
			return false; //email已存在
	}
	
	public void register(User user)throws SQLException{
		String sql = "insert into userinfo(usr,pwd,sex,role,state,email) values(?,?,?,?,?,?)";
		Object[] params = {user.getUsername(),user.getPassword(),user.getSex(),
				user.getRole(),user.getState(),user.getEmail()};
		qr.update(sql,params);
	}
	
	public boolean login(User user) throws SQLException{
		String sql = "select count(1) from userinfo where (usr=? and pwd=?)";
		Object[] params = {user.getUsername(),user.getPassword()};
		Number number = (Number)qr.query(sql, new ScalarHandler(),params);
		if(number.intValue() == 0)
		{
			System.out.println(number.intValue());
			return false;//用户不存在，显示错误
		}
		else
		{
			System.out.println(number.intValue());
			return true;//用户存在，允许登录
		}
	}
}