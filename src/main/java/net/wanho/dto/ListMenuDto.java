package net.wanho.dto;
import java.util.List;

public class ListMenuDto {
	private Integer menu_id;
	private String menu_name;
	private String menu_url;
	private String pictures;
	private String status;
	private List<Position_Menu_RelationsDto> childern;
	public ListMenuDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListMenuDto(Integer menu_id, String menu_name, String menu_url, String pictures, String status,
			List<Position_Menu_RelationsDto> childern) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.menu_url = menu_url;
		this.pictures = pictures;
		this.status = status;
		this.childern = childern;
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
	public List<Position_Menu_RelationsDto> getChildern() {
		return childern;
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
	public void setChildern(List<Position_Menu_RelationsDto> childern) {
		this.childern = childern;
	}
	@Override
	public String toString() {
		return "ListMenuDto [menu_id=" + menu_id + ", menu_name=" + menu_name + ", menu_url=" + menu_url + ", pictures="
				+ pictures + ", status=" + status + ", childern=" + childern + "]";
	}

	
	
}
