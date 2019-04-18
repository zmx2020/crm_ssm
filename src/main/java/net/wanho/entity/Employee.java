package net.wanho.entity;

import java.sql.Timestamp;

//从业员工
public class Employee {
    private Integer employee_id;

    private String employee_name;

    private Integer department_id;

    private Integer position_id;

    private String phone;

    private String email;

    private String status;

    private Integer parent_Employee_id;

    private Timestamp create_time;

    private Timestamp update_time;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer employee_id, String employee_name, Integer department_id, Integer positon_id, String phone,
			String email, String status, Integer parent_Employee_id, Timestamp create_time, Timestamp update_time) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.department_id = department_id;
		this.position_id = position_id;
		this.phone = phone;
		this.email = email;
		this.status = status;
		this.parent_Employee_id = parent_Employee_id;
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

	public Integer getPosition_id() {
		return position_id;
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

	public Integer getParent_Employee_id() {
		return parent_Employee_id;
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

	public void setPosition_id(Integer position_id) {
		this.position_id = position_id;
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

	public void setParent_Employee_id(Integer parent_Employee_id) {
		this.parent_Employee_id = parent_Employee_id;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", department_id="
				+ department_id + ", positon_id=" + position_id + ", phone=" + phone + ", email=" + email + ", status="
				+ status + ", parent_Employee_id=" + parent_Employee_id + ", create_time=" + create_time
				+ ", update_time=" + update_time + "]";
	}
    
    
 
    
}