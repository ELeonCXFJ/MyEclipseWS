/**
 * 
 */
package my.housekeeping.keeper.service;

import java.sql.SQLException;
import java.util.List;

import my.housekeeping.keeper.dao.KeeperDao;
import my.housekeeping.keeper.domain.Keeper;

/**
 * @author Leon-Desktop
 *
 */
public class KeeperService {
	KeeperDao keeperDao = new KeeperDao();
	
	public List<Keeper> findAllKeeper(){
		try{
			return keeperDao.findAll();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
