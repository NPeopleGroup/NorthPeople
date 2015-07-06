package com.hyd.northpj.action;

import com.hyd.northpj.entity.AdminUser;
import com.hyd.northpj.service.impl.AdminUserService;

public class AdminUserUpdateAction extends ModelAction<AdminUser>{

	private static final long serialVersionUID = 1L;

	private AdminUser myEditUser=new AdminUser();;	

	@Override
	public String execute() throws Exception
	{
		AdminUserService myEditUserService=new AdminUserService();
		myEditUserService.setAdminUserInformation(myEditUser);
		return SUCCESS;
	}

	public AdminUser getModel() {
		return getMyEditUser();
	}

	public AdminUser getMyEditUser() {
		return myEditUser;
	}

	public void setMyEditUser(AdminUser myEditUser) {
		this.myEditUser = myEditUser;
	}
}
