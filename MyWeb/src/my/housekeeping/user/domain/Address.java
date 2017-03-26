/**
 * 
 */
package my.housekeeping.user.domain;

/**
 * @author Leon-Desktop
 *
 */
public class Address {
	private int aid;
	private String province;
	private String city;
	private String district;
	private String street;
	private String tel;
	private int uid;
	
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return aid + " " + province + " " + city + " " + district + " "
				+ street + " " + tel + " " + uid;
	}
}
