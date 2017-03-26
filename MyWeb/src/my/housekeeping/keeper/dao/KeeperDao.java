/**
 * 
 */
package my.housekeeping.keeper.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import my.housekeeping.keeper.domain.Keeper;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;

/**
 * @author Leon-Desktop
 *
 */
public class KeeperDao {
	private QueryRunner qr = new TxQueryRunner();
	
	public List<Keeper> findAll() throws SQLException{
		String sql = "select * from keeper";
		List<Keeper> keeperList = qr.query(sql, new BeanListHandler<Keeper>(Keeper.class));
		return keeperList;
	}
	
	public int findAllCount() throws SQLException{
		String sql = "select count(1) from keeper";
		Number number = (Number)qr.query(sql, new ScalarHandler());
		return number.intValue();
	}
}
