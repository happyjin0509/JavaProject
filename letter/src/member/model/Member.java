package member.model;

import java.util.Date;

public class Member {

	private String member_id;
	private String name;
	private String password;
	private String email;
	private Date birthday;

	public Member() {}
	public Member(String member_id, String name, String password, String email, Date birthday) {
		super();
		this.member_id = member_id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.birthday = birthday;
	}
		
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	/* 입출력 객체(DTO)를 다룰 때 즉시 사용하기 쉽도록 꼭 필요한 메소드를 작성 */
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}
	//현재 객체의 비번을 매개변수로 받은 비번으로 덮어씀
	public void changePassword(String newPwd) {
		this.password = newPwd;
	}

}
