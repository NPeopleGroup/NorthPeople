package com.hyd.northpj.action;

import java.util.ArrayList;
import java.util.List;

import com.hyd.northpj.entity.User;
import com.hyd.northpj.service.impl.AdminUserService;
import com.hyd.northpj.util.CommonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String type;
	@Override
	public String execute() throws Exception {
		AdminUserService myAdminUserService=new AdminUserService();
		List<User> myUserList=new ArrayList<User>();
		if(type==null)
		{
			System.out.println("no type");
			myUserList=myAdminUserService.getNormalUserList();
		}else{
			System.out.println("yes type");
			myUserList=myAdminUserService.getNormalUserListByProgressStatus(type);
		}
		for (User user : myUserList) {
			System.out.println(user.toString());
		}
		CommonUtil.toBeJson(myUserList, myUserList.size());
		return null;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
