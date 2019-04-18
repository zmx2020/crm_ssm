
package net.wanho.consts;

public interface ConstMsg
{
	public final static String USER_NOT_EXIST = "该用户名不存在！";
	public final static String USER_DISABLED = "该用户不可登录！";
	public final static String PASSWORD_WRONG = "用户名名或密码不正确！";
	public final static String DATA_ACCESS_ERROR = "系统正忙！请稍候。。。";
	public final static String LOGIN_SUCCEED = "欢迎登录";
	public final static String MODIFY_FAIL = "修改失败！";
	public final static String MODIFY_SUCCEED = "修改成功！";
	
	public final static String MENU_URL_EXIST = "菜单路径已存在！";
	public final static String MENU_NAME_EXIST = "菜单名称已存在！";
	public final static String MENU_NAME_URL_EXIST = "菜单名称、菜单路径已存在！";
	
	public final static String EMPLOYEE_STATUS_UPDATE_FAIL = "员工状态更新失败！";
	public final static String POSITION_NAME_EXIST = "职位名称已存在！";
	
	
	public final static String MENU_POSITION_RELATION_FAIL = "此菜单已被职位关联无法删除，请先取消该菜单关联";
	public final static String POSITION_MENU_RELATION_FAIL = "此职位已关联菜单无法删除，请先取消该菜单关联";
	public final static String POSITION_EMPLOYEE_RELATION_FAIL = "此职位已被员工关联无法删除，请先取消该职位关联";
	
}
