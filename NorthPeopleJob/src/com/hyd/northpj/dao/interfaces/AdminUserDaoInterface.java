package com.hyd.northpj.dao.interfaces;

import java.util.List;

import com.hyd.northpj.entity.AdminUser;

public interface AdminUserDaoInterface {
	/**
	 * �����û�
	 * 
	 * @param adminUser
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int insertUser(AdminUser adminUser) throws Exception;

	/**
	 * ��ȡ�û�����
	 * 
	 * @param adminUser
	 * @return �û�����
	 * @throws Exception
	 */
	public String selectUserPassword(String username) throws Exception;

	/**
	 * �����û�����
	 * 
	 * @param adminUser
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int updateUserPassword(AdminUser adminUser) throws Exception;

	/**
	 * �����û���Ϣ
	 * 
	 * @param adminUser
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int updateUserInformation(AdminUser adminUser) throws Exception;

	/**
	 * ��ȡ��һ�û���Ϣ
	 * 
	 * @param adminUser
	 * @return �û���Ϣ
	 * @throws Exception
	 */
	public AdminUser selectUserInformation(String username) throws Exception;
	
	/**
	 * ��ȡ�����û���Ϣ
	 * @return
	 * @throws Exception
	 */
	public List<AdminUser> selectAllUsers() throws Exception;
	
	/**
	 * ɾ���û���Ϣ
	 * @param userName
	 * @return ɾ���ɹ�����0
	 * @throws Exception
	 */
	public int delteteAdminUser(String userName) throws Exception;
	
	/**
	 * ɾ����ͨ�û���Ϣ
	 * @param userName
	 * @return ɾ���ɹ�����0
	 * @throws Exception
	 */
	public int delteteUser(String userName) throws Exception;

}
