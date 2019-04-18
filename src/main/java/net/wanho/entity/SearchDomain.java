package net.wanho.entity;
//搜索域
public class SearchDomain {
	 private String text;
	 private String texTime;
	 private String type;
	public SearchDomain() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchDomain(String text, String texTime, String type) {
		super();
		this.text = text;
		this.texTime = texTime;
		this.type = type;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTexTime() {
		return texTime;
	}
	public void setTexTime(String texTime) {
		this.texTime = texTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "SearchDomain [text=" + text + ", texTime=" + texTime + ", type=" + type + "]";
	}
	 
}
