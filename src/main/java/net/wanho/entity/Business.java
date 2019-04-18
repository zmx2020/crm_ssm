package net.wanho.entity;

import java.sql.Timestamp;
//商机
public class Business {
	private int business_id;//商机ID
	private int customer_id;//客户ID
	private int link_main_id;//联系人ID
	private String business_name;//商机名
	private int business_type_id;//商机类型ID
	private String status;//状态
	private int business_source_id;//商机来源ID
	private float persale_price;// 预计价格
	// 赢单率
	private float probability;//机率
	private Timestamp visit_time;//下次联系时间
	private String visit_content;//下次联系内容
	private Timestamp update_time;//更新时间，修改时间
	private int employee_id;//员工号
	public Business() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Business(int business_id, int customer_id, int link_main_id, String business_name, int business_type_id,
			String status, int business_source_id, float persale_price, float probability, Timestamp visit_time,
			String visit_content, Timestamp update_time, int employee_id) {
		super();
		this.business_id = business_id;
		this.customer_id = customer_id;
		this.link_main_id = link_main_id;
		this.business_name = business_name;
		this.business_type_id = business_type_id;
		this.status = status;
		this.business_source_id = business_source_id;
		this.persale_price = persale_price;
		this.probability = probability;
		this.visit_time = visit_time;
		this.visit_content = visit_content;
		this.update_time = update_time;
		this.employee_id = employee_id;
	}
	public int getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(int business_id) {
		this.business_id = business_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getLink_main_id() {
		return link_main_id;
	}
	public void setLink_main_id(int link_main_id) {
		this.link_main_id = link_main_id;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public int getBusiness_type_id() {
		return business_type_id;
	}
	public void setBusiness_type_id(int business_type_id) {
		this.business_type_id = business_type_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBusiness_source_id() {
		return business_source_id;
	}
	public void setBusiness_source_id(int business_source_id) {
		this.business_source_id = business_source_id;
	}
	public float getPersale_price() {
		return persale_price;
	}
	public void setPersale_price(float persale_price) {
		this.persale_price = persale_price;
	}
	public float getProbability() {
		return probability;
	}
	public void setProbability(float probability) {
		this.probability = probability;
	}
	public Timestamp getVisit_time() {
		return visit_time;
	}
	public void setVisit_time(Timestamp visit_time) {
		this.visit_time = visit_time;
	}
	public String getVisit_content() {
		return visit_content;
	}
	public void setVisit_content(String visit_content) {
		this.visit_content = visit_content;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	@Override
	public String toString() {
		return "Business [business_id=" + business_id + ", customer_id=" + customer_id + ", link_main_id="
				+ link_main_id + ", business_name=" + business_name + ", business_type_id=" + business_type_id
				+ ", status=" + status + ", business_source_id=" + business_source_id + ", persale_price="
				+ persale_price + ", probability=" + probability + ", visit_time=" + visit_time + ", visit_content="
				+ visit_content + ", update_time=" + update_time + ", employee_id=" + employee_id + "]";
	}
	
	
}
