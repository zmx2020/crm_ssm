package net.wanho.entity;

import java.sql.Timestamp;
//联系人
public class LinkMan {
	 private int link_main_id;
	 private String name;
	 private String sex;
	 private String position;
	 private String nickName;
	 private int phonenum;
	 private String email;
	 private int qq;
	 private Timestamp create_time;
	 private Timestamp update_time;
	 private String remarks;
	 private String qr_code;
	 private int customer_id;
	public LinkMan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LinkMan(int link_main_id, String name, String sex, String position, String nickName, int phonenum,
			String email, int qq, Timestamp create_time, Timestamp update_time, String remarks, String qr_code,
			int customer_id) {
		super();
		this.link_main_id = link_main_id;
		this.name = name;
		this.sex = sex;
		this.position = position;
		this.nickName = nickName;
		this.phonenum = phonenum;
		this.email = email;
		this.qq = qq;
		this.create_time = create_time;
		this.update_time = update_time;
		this.remarks = remarks;
		this.qr_code = qr_code;
		this.customer_id = customer_id;
	}
	public int getLink_main_id() {
		return link_main_id;
	}
	public void setLink_main_id(int link_main_id) {
		this.link_main_id = link_main_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(int phonenum) {
		this.phonenum = phonenum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getQq() {
		return qq;
	}
	public void setQq(int qq) {
		this.qq = qq;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getQr_code() {
		return qr_code;
	}
	public void setQr_code(String qr_code) {
		this.qr_code = qr_code;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	@Override
	public String toString() {
		return "LinkMan [link_main_id=" + link_main_id + ", name=" + name + ", sex=" + sex + ", position=" + position
				+ ", nickName=" + nickName + ", phonenum=" + phonenum + ", email=" + email + ", qq=" + qq
				+ ", create_time=" + create_time + ", update_time=" + update_time + ", remarks=" + remarks
				+ ", qr_code=" + qr_code + ", customer_id=" + customer_id + "]";
	}
	
}
