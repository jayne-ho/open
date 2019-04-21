package cn.jayneo.open.entity;

import org.springframework.stereotype.Component;

/**
 * 用户
 */
@Component
public class UserEntity implements java.io.Serializable{
	private Integer uid;
	private String firstName;//名
	private String lastName;//姓
	private String password;
	private String salt;//盐
	private Integer gender;//性别
	private String avatar;
	private String phone;
	private String email;
	private Integer isDelete;

	@Override
	public String toString() {
		return "User{" +
				"uid=" + uid +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", password='" + password + '\'' +
				", salt='" + salt + '\'' +
				", gender=" + gender +
				", avatar='" + avatar + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", isDelete=" + isDelete +
				'}';
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
}
