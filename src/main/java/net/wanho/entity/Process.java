package net.wanho.entity;

import java.sql.Timestamp;
//推进
public class Process {
	private int process_id;
    private String type;
    private int business_id;
    private String status;
    private String opinions;
    private int operator;
    private Timestamp create_time;
	public Process() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Process(int process_id, String type, int business_id, String status, String opinions, int operator,
			Timestamp create_time) {
		super();
		this.process_id = process_id;
		this.type = type;
		this.business_id = business_id;
		this.status = status;
		this.opinions = opinions;
		this.operator = operator;
		this.create_time = create_time;
	}
	public int getProcess_id() {
		return process_id;
	}
	public void setProcess_id(int process_id) {
		this.process_id = process_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(int business_id) {
		this.business_id = business_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOpinions() {
		return opinions;
	}
	public void setOpinions(String opinions) {
		this.opinions = opinions;
	}
	public int getOperator() {
		return operator;
	}
	public void setOperator(int operator) {
		this.operator = operator;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "Process [process_id=" + process_id + ", type=" + type + ", business_id=" + business_id + ", status="
				+ status + ", opinions=" + opinions + ", operator=" + operator + ", create_time=" + create_time + "]";
	}
	
}
