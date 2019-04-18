package net.wanho.dto;

public class Position_Menu_RelationsDto {
	private Integer relation_id;
	private Integer position_id;
	private String position_name;
	private Integer menu_id;
	private String menu_name;
	private String menu_url;
	private String parent_menu_id;
	private String pictures;
	private String status;
	public Position_Menu_RelationsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Position_Menu_RelationsDto(Integer relation_id, Integer position_id, String position_name, Integer menu_id,
			String menu_name, String menu_url, String parent_menu_id, String pictures, String status) {
		super();
		this.relation_id = relation_id;
		this.position_id = position_id;
		this.position_name = position_name;
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.menu_url = menu_url;
		this.parent_menu_id = parent_menu_id;
		this.pictures = pictures;
		this.status = status;
	}
	public Integer getRelation_id() {
		return relation_id;
	}
	public Integer getPosition_id() {
		return position_id;
	}
	public String getPosition_name() {
		return position_name;
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
	public String getParent_menu_id() {
		return parent_menu_id;
	}
	public String getPictures() {
		return pictures;
	}
	public String getStatus() {
		return status;
	}
	public void setRelation_id(Integer relation_id) {
		this.relation_id = relation_id;
	}
	public void setPosition_id(Integer position_id) {
		this.position_id = position_id;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
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
	public void setParent_menu_id(String parent_menu_id) {
		this.parent_menu_id = parent_menu_id;
	}
	public void setPictures(String pictures) {
		this.pictures = pictures;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Position_Menu_RelationsDto [relation_id=" + relation_id + ", position_id=" + position_id
				+ ", position_name=" + position_name + ", menu_id=" + menu_id + ", menu_name=" + menu_name
				+ ", menu_url=" + menu_url + ", parent_menu_id=" + parent_menu_id + ", pictures=" + pictures
				+ ", status=" + status + "]";
	}
	
	
	
}
