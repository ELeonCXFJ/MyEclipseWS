/**
 * 
 */
package my.housekeeping.order.domain;

import my.housekeeping.user.domain.User;

/**
 * @author Leon-Desktop
 *
 */
public class Order {
	private int oid; //primary key
	private String ordertime; //order time
	private int status;//order's status
	private String street;
	private User owner;// the order's owner
	private String district;
	private String appointment; 
	private String tel;
	private String other;
	private String service;
	
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAppointment() {
		return appointment;
	}
	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", ordertime=" + ordertime + ", status="
				+ status + ", street=" + street + ", owner=" + owner
				+ ", district=" + district + ", appointment=" + appointment
				+ ", tel=" + tel + ", other=" + other + ", service=" + service
				+ "]";
	}
	
}
