package com.strom.model.user;

public class User {
	
	//�û����
	private String id;
	//����
	private String name;
	//����
	private Integer age;
	//�Ա�
	private Integer sex;
	//��ַ
	private String addr;
	//��ҵѧУ
	private String school;
	//���ű��
	private Integer orgId;
	//��ְʱ��
	private String createTime;
	//����
	private String email;
	//�绰
	private String phone;
	//����
	private String password;
	//�û���
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
