package com.hyd.northpj.service.interfaces;

import java.util.List;

import com.hyd.northpj.entity.AdminUser;
import com.hyd.northpj.entity.User;

public interface AdminUserServiceInterface {
	/**
	 * ע��һ������Ա�û�
	 * 
	 * @param adminUser
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int register(AdminUser adminUser) throws Exception;

	/**
	 * ����Ա�û���¼
	 * 
	 * @param adminUser
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int login(AdminUser adminUser) throws Exception;

	/**
	 * ����Ա�û���������
	 * 
	 * @param adminUser
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int changePassword(AdminUser adminUser, String newPassword) throws Exception;
	
	/**
	 * �û��ǼǸ�����Ϣ
	 * 
	 * @param adminUser
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int setAdminUserInformation(AdminUser adminUser) throws Exception;

	/**
	 * ��ȡ�û��ĸ�����Ϣ
	 * 
	 * @param username
	 * @return һ������Ա�û�
	 * @throws Exception
	 */
	public AdminUser getAdminUserInformation(String username) throws Exception;

	/**
	 * ��ȡ����������Ա����Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<User> getNormalUserList() throws Exception;

	/**
	 * ��ȡ����ҵ��Ա��Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<AdminUser> getAdminUserList() throws Exception;

	/**
	 * �����û���ɾ��ҵ��Ա
	 * @param userName
	 * @return �ɹ�����0�����򷵻�1
	 * @throws Exception
	 */
	public int deleteAdminUser(String userName) throws Exception;

	
	/**
	 * ɾ����ͨ�û�
	 * @param userName
	 * @return �ɹ�����0�����򷵻�1
	 * @throws Exception
	 */
	public int deleteUser(String userName) throws Exception;
	
}
