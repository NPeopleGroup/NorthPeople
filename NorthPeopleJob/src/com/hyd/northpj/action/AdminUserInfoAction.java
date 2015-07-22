package com.hyd.northpj.action;

import com.hyd.northpj.entity.AdminUser;
import com.hyd.northpj.service.impl.AdminUserService;

public class AdminUserInfoAction extends ModelAction<AdminUser>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AdminUser myEditUser;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		String userName=new String(request.getParameter("userName").getBytes("ISO8859-1"),"UTF-8");
		System.out.println(userName);
		AdminUserService myEditUserService=new AdminUserService();

		setMyEditUser(myEditUserService.getAdminUserInformation(request.getParameter("userName")));
		System.out.println(getMyEditUser().toString());
		return SUCCESS;
	}

	public AdminUser getMyEditUser() {
		return myEditUser;
	}
	public void setMyEditUser(AdminUser myEditUser) {
		this.myEditUser = myEditUser;
	}
}
