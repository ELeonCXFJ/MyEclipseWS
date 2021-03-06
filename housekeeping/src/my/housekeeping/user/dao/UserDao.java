package my.housekeeping.user.dao;

import java.sql.SQLException;

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
		return (number.intValue() == 0);
	}
	
	public boolean ajaxValidatorEmail(String email) throws SQLException{
		String sql = "select count(1) from userinfo where email=?";
		Number number = (Number)qr.query(sql,new ScalarHandler(), email);
		return (number.intValue() == 0);
	}
}