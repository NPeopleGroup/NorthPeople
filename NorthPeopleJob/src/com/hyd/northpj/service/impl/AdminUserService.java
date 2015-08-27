package com.hyd.northpj.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.hyd.northpj.dao.impl.AdminUserDao;
import com.hyd.northpj.dao.impl.UserDao;
import com.hyd.northpj.entity.AdminUser;
import com.hyd.northpj.entity.User;
import com.hyd.northpj.service.interfaces.AdminUserServiceInterface;
import com.hyd.northpj.util.ValidateUtil;

public class AdminUserService implements AdminUserServiceInterface {
	private Logger myLogger = Logger.getLogger(this.getClass());
	private AdminUserDao myAdminUserDao = new AdminUserDao();

	@Override
	public int register(AdminUser adminUser) throws Exception {

		// ���û���Ч�Խ�����
		int validateResult = ValidateUtil.validAdminUser(adminUser);
		// ����ֵ��Ϊ0����ʾ�������س����־
		if (validateResult != 0) {
			return validateResult;
		}
		return (myAdminUserDao.insertUser(adminUser)) == 0 ? 0 : 5;
	}

	@Override
	public int login(AdminUser adminUser) throws Exception {
		// TODO Auto-generated method stub

		// ���û���Ч�Խ�����
		int validateResult = ValidateUtil.validAdminUser(adminUser);
		// ����ֵ��Ϊ0����ʾ�������س����־
		if (validateResult != 0) {
			return validateResult;
		}

		String realPassword = null;
		try {
			realPassword = myAdminUserDao.selectUserPassword(adminUser
					.getUsername());
		} catch (Exception e) {
			myLogger.error("��ȡ�û������������:" + e.toString());
			return 5;
		}
		if (adminUser.getPassword() == null
				|| adminUser.getPassword().trim().equals("")) {
			myLogger.error("�û���������Ϊ�գ�");
			return 6;
		} else if (!adminUser.getPassword().equals(realPassword)) {
			myLogger.error("�û����벻ƥ�䣡");
			return 7;
		}
		return 0;
	}

	@Override
	public int changePassword(AdminUser adminUser, String newPassword)
			throws Exception {
		// TODO Auto-generated method stub

		// �ж��û���Ч��
		int isUserExist = login(adminUser);
		// ����ֵ��Ϊ0����ʾ�������س����־
		if (isUserExist != 0) {
			myLogger.error("�޷�ͨ���û���Ч����֤,��˶��û����Լ����룡");
			return isUserExist;
		}
		if (adminUser.getPassword().equals(newPassword)) {
			myLogger.error("�����û�������һ��!");
			return 7;
		}

		try {
			adminUser.setPassword(newPassword);
			myAdminUserDao.updateUserPassword(adminUser);
		} catch (Exception e) {
			myLogger.error("�����û������������:" + e.toString());
			return 8;
		}
		return 0;
	}

	public int setAdminUserInformation(AdminUser adminUser) throws Exception {


		if (ValidateUtil.validateAdminUserAllProperty(adminUser) == 0) {
			myAdminUserDao.updateUserInformation(adminUser);
		} else {
			myLogger.error("�����û���Ϣ���ִ���");
			return 3;
		}
		return 0;
	}

	@Override
	public AdminUser getAdminUserInformation(String username) throws Exception {
		if (username != null && ValidateUtil.isPassSqlFilter(username)) {
			return myAdminUserDao.selectUserInformation(username);
		}
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getNormalUserList() throws Exception {
		// TODO Auto-generated method stub
		UserDao myUserDao=new UserDao();
		List<User> myUserList=myUserDao.selectAllUser();
		return myUserList;
	}

	@Override
	public List<AdminUser> getAdminUserList() throws Exception {
		// TODO Auto-generated method stub
		AdminUserDao myAdminUserDao=new AdminUserDao();
		List<AdminUser> myAdminUserList=myAdminUserDao.selectAllUsers();
		return myAdminUserList;
	}

	@Override
	public int deleteAdminUser(String userName) throws Exception {
		// TODO Auto-generated method stub
		myAdminUserDao.delteteAdminUser(userName);
		return 0;
	}

	@Override
	public int deleteUser(String userName) throws Exception {
		// TODO Auto-generated method stub
		myAdminUserDao.delteteUser(userName);
		return 0;
	}

	@Override
	public List<User> getNormalUserListByProgressStatus(String type) throws Exception {
		// TODO Auto-generated method stub
		UserDao myUserDao=new UserDao();
		return myUserDao.selectUserByProgress(type);
	}

}
