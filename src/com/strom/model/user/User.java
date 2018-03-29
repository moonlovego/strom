package com.strom.model.user;

public class User {
	
	//用户编号
	private String id;
	//姓名
	private String name;
	//年龄
	private Integer age;
	//性别
	private Integer sex;
	//地址
	private String addr;
	//毕业学校
	private String school;
	//部门编号
	private Integer orgId;
	//入职时间
	private String createTime;
	//邮箱
	private String email;
	//电话
	private String phone;
	//密码
	private String password;
	//用户名
	private String username;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "User [addr=" + addr + ", age=" + age + ", createTime="
				+ createTime + ", email=" + email + ", id=" + id + ", name="
				+ name + ", orgId=" + orgId + ", password=" + password
				+ ", phone=" + phone + ", school=" + school + ", sex=" + sex
				+ ", username=" + username + "]";
	}
}
