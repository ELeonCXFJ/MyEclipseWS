/**
 * 
 */
package my.housekeeping.order.domain;

/**
 * @author Leon-Desktop
 *
 */
public class Service {
	private int sid;
	private String service;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	@Override
	public String toString() {
		return "Service [sid=" + sid + ", service=" + service + "]";
	}
	
}
