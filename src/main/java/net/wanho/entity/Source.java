package net.wanho.entity;
//客户来源
public class Source {
	private int source_id;
	private String source_name;
	public Source() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Source(int source_id, String source_name) {
		super();
		this.source_id = source_id;
		this.source_name = source_name;
	}
	public int getSource_id() {
		return source_id;
	}
	public void setSource_id(int source_id) {
		this.source_id = source_id;
	}
	public String getSource_name() {
		return source_name;
	}
	public void setSource_name(String source_name) {
		this.source_name = source_name;
	}
	@Override
	public String toString() {
		return "Source [source_id=" + source_id + ", source_name=" + source_name + "]";
	}
	
}
