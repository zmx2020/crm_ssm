package net.wanho.entity;

import java.sql.Timestamp;
//订单
public class Orders {
	private int order_id;
    private String order_seq;
    private String title;
    private int customer_id;
    private float total_money;
    private String status;
    private int operator;
    private Timestamp order_time;
    private Timestamp create_time;
    private String order_type;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(int order_id, String order_seq, String title, int customer_id, float total_money, String status,
			int operator, Timestamp order_time, Timestamp create_time, String order_type) {
		super();
		this.order_id = order_id;
		this.order_seq = order_seq;
		this.title = title;
		this.customer_id = customer_id;
		this.total_money = total_money;
		this.status = status;
		this.operator = operator;
		this.order_time = order_time;
		this.create_time = create_time;
		this.order_type = order_type;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_seq() {
		return order_seq;
	}
	public void setOrder_seq(String order_seq) {
		this.order_seq = order_seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public float getTotal_money() {
		return total_money;
	}
	public void setTotal_money(float total_money) {
		this.total_money = total_money;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getOperator() {
		return operator;
	}
	public void setOperator(int operator) {
		this.operator = operator;
	}
	public Timestamp getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Timestamp order_time) {
		this.order_time = order_time;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public String getOrder_type() {
		return order_type;
	}
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", order_seq=" + order_seq + ", title=" + title + ", customer_id="
				+ customer_id + ", total_money=" + total_money + ", status=" + status + ", operator=" + operator
				+ ", order_time=" + order_time + ", create_time=" + create_time + ", order_type=" + order_type + "]";
	}
	
}
