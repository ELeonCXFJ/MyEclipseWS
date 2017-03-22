package my.housekeeping.user.dao;

import java.sql.SQLException;

import my.housekeeping.user.domain.User;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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
	 * 按uid和password进行查询
	 */
	public boolean findByUidAndPassword(int uid,String password) throws SQLException{
		String sql = "select count(1) from userinfo where uid=? and password=?";
		Number number = (Number)qr.query(sql, new ScalarHandler(),uid,password);
		if(number.intValue() == 0)
			return false;
		else
			return true;
	}
	
	/**
	 * 修改密码
	 * @param uid
	 * @param password
	 * @throws SQLException 
	 */
	public void updatePassword(int uid,String password) throws SQLException{
		String sql = "update userinfo set password=? where uid=?";
		qr.update(sql,password,uid);
	}
	
	/**
	 * 校验用户名是否已经注册
	 * @throws SQLException 
	 * 
	 */
	public boolean ajaxValidatorUserName(String username) throws SQLException{
		String sql = "select count(1) from userinfo where username=?";
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
		String sql = "insert into userinfo(username,password,sex,role,state,email) values(?,?,?,?,?,?)";
		Object[] params = {user.getUsername(),user.getPassword(),user.getSex(),
				user.getRole(),user.getState(),user.getEmail()};
		qr.update(sql,params);
	}
	
	/**
	 * 登录功能实现
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	
	public User login(String username,String password) throws SQLException{
		String sql = "select * from userinfo where (username=? and password=?)";
		return qr.query(sql, new BeanHandler<User>(User.class),username,password);
	}
}