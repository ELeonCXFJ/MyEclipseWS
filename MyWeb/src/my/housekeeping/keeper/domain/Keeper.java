/**
 * 
 */
package my.housekeeping.keeper.domain;

/**
 * @author Leon-Desktop
 *
 */
public class Keeper {
	private int kid;
	private String name;
	private String age;
	private String hometown; //故乡
	private String education;//学历
	private int sex;
	private String exp;
	private String image;
	private String tel;
	
	
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Keeper [kid=" + kid + ", name=" + name + ", age=" + age
				+ ", hometown=" + hometown + ", education=" + education
				+ ", sex=" + sex + ", exp=" + exp + ", image=" + image
				+ ", tel=" + tel + "]";
	}
	
}
