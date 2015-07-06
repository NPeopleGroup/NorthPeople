package com.hyd.northpj.action;

import java.util.List;

import com.hyd.northpj.entity.User;
import com.hyd.northpj.service.impl.AdminUserService;
import com.hyd.northpj.util.CommonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {
		AdminUserService myAdminUserService=new AdminUserService();
		List<User> myUserList=myAdminUserService.getNormalUserList();
		for (User user : myUserList) {
			System.out.println(user.toString());
		}
		CommonUtil.toBeJson(myUserList, myUserList.size());
		return null;
	}

}
