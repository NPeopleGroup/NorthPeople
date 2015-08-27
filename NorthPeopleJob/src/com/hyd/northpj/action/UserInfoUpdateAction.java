package com.hyd.northpj.action;

import com.hyd.northpj.entity.User;
import com.hyd.northpj.service.impl.UserService;

public class UserInfoUpdateAction extends ModelAction<User>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User myEditUser=new User();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UserService myUserService=new UserService();
	//	myEditUser.setUsername(session.getAttribute("NorthPeopleJob_username").toString());
		myUserService.setInformation(myEditUser);
		return SUCCESS;
	}
	
	public User getModel() {
		return myEditUser;
	}
	public User getMyEditUser() {
		return myEditUser;
	}
	public void setMyEditUser(User myEditUser) {
		this.myEditUser = myEditUser;
	}
	



	
}
