package my.housekeeping.user.domain;
/**
 * 用户模块的实体类
 */
/*
 * 用户的属性来自于userinfo表以及该模块的所有表单。
 */
public class User {
	private int uid; 			//主键
	private String username;	//用户名
	private String password;	//密码
	private int role;			//用户类型
	private int state;			//用户状态
	private String email;		//邮箱
	private int sex;			//性别
	
	
	//register form
	private String confirmpassword;
	
	//change password
	private String newpassword;
	
	//getter and setter
	public int getUid() {
		return uid;
	}	
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password="
				+ password + ", role=" + role + ", state=" + state + ", email="
				+ email + ", sex=" + sex + ", confirmpassword="
				+ confirmpassword + ", newpassword=" + newpassword + "]";
	}
	
}
