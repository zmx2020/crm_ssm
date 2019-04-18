package net.wanho.dto;

import java.sql.Timestamp;

//从业员工
public class EmployeeDto {
    private Integer employee_id;

    private String employee_name;

    private Integer department_id;
    
    private String department_name;   

    private Integer position_id;
    
    private String position_Name;

    private String phone;

    private String email;

    private String status;

    private Integer parent_employee_id;
    
    private String parent_employee_name;

    private Timestamp create_time;

    private Timestamp update_time;

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDto(Integer employee_id, String employee_name, Integer department_id, String department_name,
			Integer position_id, String position_Name, String phone, String email, String status,
			Integer parent_employee_id, String parent_employee_name, Timestamp create_time, Timestamp update_time) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.department_id = department_id;
		this.department_name = department_name;
		this.position_id = position_id;
		this.position_Name = position_Name;
		this.phone = phone;
		this.email = email;
		this.status = status;
		this.parent_employee_id = parent_employee_id;
		this.parent_employee_name = parent_employee_name;
		this.create_time = create_time;
		this.update_time = update_time;
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public Integer getDepartment_id() {
		return department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public Integer getPosition_id() {
		return position_id;
	}

	public String getPosition_Name() {
		return position_Name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getStatus() {
		return status;
	}

	public Integer getParent_employee_id() {
		return parent_employee_id;
	}

	public String getParent_employee_name() {
		return parent_employee_name;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public Timestamp getUpdate_time() {
		return update_time;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public void setPosition_id(Integer position_id) {
		this.position_id = position_id;
	}

	public void setPosition_Name(String position_Name) {
		this.position_Name = position_Name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setParent_employee_id(Integer parent_employee_id) {
		this.parent_employee_id = parent_employee_id;
	}

	public void setParent_employee_name(String parent_employee_name) {
		this.parent_employee_name = parent_employee_name;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return "EmployeeDto [employee_id=" + employee_id + ", employee_name=" + employee_name + ", department_id="
				+ department_id + ", department_name=" + department_name + ", position_id=" + position_id
				+ ", position_Name=" + position_Name + ", phone=" + phone + ", email=" + email + ", status=" + status
				+ ", parent_employee_id=" + parent_employee_id + ", parent_employee_name=" + parent_employee_name
				+ ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}

    
}