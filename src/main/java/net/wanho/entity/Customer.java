package net.wanho.entity;

import java.sql.Timestamp;
//客戶
public class Customer {
	private int customer_id;
    private String customer_name;
    private String post_code;//邮编
    private int field_id;//领域
    private int source_id;
    private Timestamp create_time;
    private Timestamp update_time;
    private String employee_numbers;
    private int prinpical;
    private String address;
    private String tag;
    private String remarks;
    private String busubess_volume;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customer_id, String customer_name, String post_code, int field_id, int source_id,
			Timestamp create_time, Timestamp update_time, String employee_numbers, int prinpical, String address,
			String tag, String remarks, String busubess_volume) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.post_code = post_code;
		this.field_id = field_id;
		this.source_id = source_id;
		this.create_time = create_time;
		this.update_time = update_time;
		this.employee_numbers = employee_numbers;
		this.prinpical = prinpical;
		this.address = address;
		this.tag = tag;
		this.remarks = remarks;
		this.busubess_volume = busubess_volume;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getPost_code() {
		return post_code;
	}
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}
	public int getField_id() {
		return field_id;
	}
	public void setField_id(int field_id) {
		this.field_id = field_id;
	}
	public int getSource_id() {
		return source_id;
	}
	public void setSource_id(int source_id) {
		this.source_id = source_id;
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
	public String getEmployee_numbers() {
		return employee_numbers;
	}
	public void setEmployee_numbers(String employee_numbers) {
		this.employee_numbers = employee_numbers;
	}
	public int getPrinpical() {
		return prinpical;
	}
	public void setPrinpical(int prinpical) {
		this.prinpical = prinpical;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getBusubess_volume() {
		return busubess_volume;
	}
	public void setBusubess_volume(String busubess_volume) {
		this.busubess_volume = busubess_volume;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", post_code=" + post_code
				+ ", field_id=" + field_id + ", source_id=" + source_id + ", create_time=" + create_time
				+ ", update_time=" + update_time + ", employee_numbers=" + employee_numbers + ", prinpical=" + prinpical
				+ ", address=" + address + ", tag=" + tag + ", remarks=" + remarks + ", busubess_volume="
				+ busubess_volume + "]";
	}
	
}
