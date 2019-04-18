package net.wanho.entity;

import java.sql.Timestamp;
//职位
public class Position {
	private int position_id;
    private String position_name;
    private String position_level;
    private Timestamp create_time;
    private Timestamp update_time;
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Position(int position_id, String position_name, String position_level, Timestamp create_time,
			Timestamp update_time) {
		super();
		this.position_id = position_id;
		this.position_name = position_name;
		this.position_level = position_level;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public int getPosition_id() {
		return position_id;
	}
	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	public String getPosition_level() {
		return position_level;
	}
	public void setPosition_level(String position_level) {
		this.position_level = position_level;
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
	@Override
	public String toString() {
		return "Position [position_id=" + position_id + ", position_name=" + position_name + ", position_level="
				+ position_level + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
	
}
