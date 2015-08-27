package com.hyd.northpj.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.hyd.northpj.entity.User;
import com.hyd.northpj.service.impl.UserService;
import com.hyd.northpj.util.CommonUtil;
import com.hyd.northpj.util.Relations;

public class UserInfoViewAction extends ModelAction<User>{

	/**
	 * 查看普通用户的个人信息
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	
	private String fileNumber;

	private User myUser=new User();
	
	private UserService myUserService=new UserService();
	
	private List<Relations> myRelationList=new ArrayList<Relations>();
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		CommonUtil.construcUserInfo(myUser,myRelationList,myUserService,getUserName());
		SimpleDateFormat myFormat=new SimpleDateFormat("yyyyMMddHHmmss");
		Random randomNumber=new Random();
		fileNumber=myFormat.format(new Date())+randomNumber.nextInt(1000);
		return SUCCESS;
	}


	public User getMyUser() {
		return myUser;
	}

	public void setMyUser(User myUser) {
		this.myUser = myUser;
	}

	public List<Relations> getMyRelationList() {
		return myRelationList;
	}

	public void setMyRelationList(List<Relations> myRelationList) {
		this.myRelationList = myRelationList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getFileNumber() {
		return fileNumber;
	}


	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber;
	}

}
