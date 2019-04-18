package net.wanho.entity;
import java.sql.Timestamp;

public class Menu {
	private Integer menu_id;
	private String menu_name;
	private String menu_url;
	private String pictures;
	private String status;
	private Timestamp create_time;
	private Timestamp update_time;
	private Integer parent_menu_id;
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(Integer menu_id, String menu_name, String menu_url, String pictures, String status,
			Timestamp create_time, Timestamp update_time, Integer parent_menu_id) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.menu_url = menu_url;
		this.pictures = pictures;
		this.status = status;
		this.create_time = create_time;
		this.update_time = update_time;
		this.parent_menu_id = parent_menu_id;
	}
	public Integer getMenu_id() {
		return menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public String getMenu_url() {
		return menu_url;
	}
	public String getPictures() {
		return pictures;
	}
	public String getStatus() {
		return status;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public Timestamp getUpdate_time() {
		return update_time;
	}
	public Integer getParent_menu_id() {
		return parent_menu_id;
	}
	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}
	public void setPictures(String pictures) {
		this.pictures = pictures;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}
	public void setParent_menu_id(Integer parent_menu_id) {
		this.parent_menu_id = parent_menu_id;
	}
	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", menu_name=" + menu_name + ", menu_url=" + menu_url + ", pictures="
				+ pictures + ", status=" + status + ", create_time=" + create_time + ", update_time=" + update_time
				+ ", parent_menu_id=" + parent_menu_id + "]";
	}
	
	
	
	
}
