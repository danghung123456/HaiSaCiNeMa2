package com.DTO;

import java.sql.Date;

import com.Entity.Member;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MemberDTO {
	private Integer memberId;
	private String memberName;
	private String email;
	private String password;
	private String phone;
	private String address;
	private Date birthday;
	private Integer idCard;
	private Double totalMoney;

	@Override
	public String toString() {
		return "MemberDTO [memberId=" + memberId + ", memberName=" + memberName + ", email=" + email + ", password="
				+ password + ", phone=" + phone + ", address=" + address + ", birthday=" + birthday + ", idCard="
				+ idCard + ", totalMoney=" + totalMoney + "]";
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(memberName) || isNull(email) || isNull(password) || isNull(phone);
		return includeId ? res || isNull(memberId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public Member convertToMember() {
		ObjectMapper mapper = new ObjectMapper();
		Member member = mapper.convertValue(this, Member.class);
		return member;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getIdCard() {
		return idCard;
	}

	public void setIdCard(Integer idCard) {
		this.idCard = idCard;
	}

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
}
