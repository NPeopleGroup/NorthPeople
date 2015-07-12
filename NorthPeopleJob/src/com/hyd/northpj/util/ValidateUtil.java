package com.hyd.northpj.util;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.hyd.northpj.entity.AdminUser;
import com.hyd.northpj.entity.Answer;
import com.hyd.northpj.entity.Material;
import com.hyd.northpj.entity.Question;
import com.hyd.northpj.entity.User;

public class ValidateUtil {

	private static Logger logger = Logger.getLogger(ValidateUtil.class);
	// ��sqlע�������ַ���
	private static String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"
			+ "(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";

	private static Pattern sqlPattern = Pattern.compile(reg,
			Pattern.CASE_INSENSITIVE);

	/**
	 * ��֤�û����������Ƿ�Ϊ�գ�����sql�����й��ˣ��Է�ֹע��
	 * 
	 * @param loginUser
	 * @return ������֤��� 1-->�û���Ϊ�գ�2--->�û���δͨ��sql��ȫ����֤��
	 *         3-->�û�����Ϊ�գ�4--->�û�����δͨ��sql��ȫ����֤�� 0 ͨ����֤
	 */
	public static int validAdminUser(AdminUser loginUser) {
		if (loginUser.getUsername() == null
				|| loginUser.getUsername().trim().equals("")) {
			return 1;
		} else if (!isPassSqlFilter(loginUser.getUsername())) {
			return 2;
		}
		if (loginUser.getUsername() == null
				|| loginUser.getPassword().trim().equals("")) {
			return 3;
		} else if (!isPassSqlFilter(loginUser.getPassword())) {
			return 4;
		}
		return 0;
	}

	/**
	 * ��֤�û����������Ƿ�Ϊ�գ�����sql�����й��ˣ��Է�ֹע��
	 * 
	 * @param loginUser
	 * @return ������֤��� 1-->�û���Ϊ�գ�2--->�û���δͨ��sql��ȫ����֤��
	 *         3-->�û�����Ϊ�գ�4--->�û�����δͨ��sql��ȫ����֤�� 0 ͨ����֤
	 */
	public static int validUser(User loginUser) {
		if (loginUser.getUsername() == null
				|| loginUser.getUsername().trim().equals("")) {
			return 1;
		} else if (!isPassSqlFilter(loginUser.getUsername())) {
			return 2;
		}
		if (loginUser.getUsername() == null
				|| loginUser.getPassword().trim().equals("")) {
			return 3;
		} else if (!isPassSqlFilter(loginUser.getPassword())) {
			return 4;
		}
		return 0;
	}

	/**
	 * ��֤answe�����Ϣ�Ƿ�Ϊ�գ�����sql�����й��ˣ��Է�ֹע��
	 * 
	 * @param answer
	 *            Ҫ��֤��answer
	 * @return 1-->�û���Ϊ�գ� 2--->�û���δͨ��sql��ȫ����֤��
	 *         3-->questionId�գ�4--->questionIdδͨ��sql��ȫ����֤�� 5-->answerΪ�գ�
	 *         6--->��answerδͨ��sql��ȫ����֤�� 0 ͨ����֤
	 */
	public static int validateAnswer(Answer answer) {
		if (answer.getUsername() == null
				|| answer.getUsername().trim().equals("")) {
			return 1;
		} else if (!isPassSqlFilter(answer.getUsername())) {
			return 2;
		}
		if (answer.getQuestionId() == null || answer.getQuestionId().equals("")) {
			return 3;
		} else if (!isPassSqlFilter(answer.getQuestionId())) {
			return 4;
		} else if (answer.getAnswer() == null || answer.getAnswer().equals("")) {
			return 5;
		} else if (!isPassSqlFilter(answer.getAnswer())) {
			return 6;
		}
		return 0;
	}

	/**
	 * ��֤�û��������Եİ�ȫ��
	 * 
	 * @param loginUser
	 * @return ������֤�����1-->δͨ����֤��0-->ͨ����֤
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static int validateAdminUserAllProperty(AdminUser loginUser)
			throws SecurityException, ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException {

		Field[] fds = Class.forName("com.hyd.northpj.entity.AdminUser")
				.getDeclaredFields();

		for (int i = 0; i < fds.length; i++) {
			fds[i].setAccessible(true);
			Object userProperty = fds[i].get(loginUser);
			if (userProperty != null) {
				if (!isPassSqlFilter(userProperty.toString())) {
					return 1;
				}
			}
		}
		return 0;
	}

	/**
	 * ��֤�û��������Եİ�ȫ��
	 * 
	 * @param loginUser
	 * @return ������֤�����1-->δͨ����֤��0-->ͨ����֤
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static int validateUserAllProperty(User loginUser)
			throws SecurityException, ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException {

		Field[] fds = Class.forName("com.hyd.northpj.entity.User")
				.getDeclaredFields();

		for (int i = 0; i < fds.length; i++) {
			fds[i].setAccessible(true);
			Object userProperty = fds[i].get(loginUser);
			if (userProperty != null) {
				if (!isPassSqlFilter(userProperty.toString())) {
					return 1;
				}
			}
		}
		return 0;
	}

	/**
	 * ��֤�û��������Եİ�ȫ��
	 * 
	 * @param loginUser
	 * @return ������֤�����1-->δͨ����֤��0-->ͨ����֤
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static int validateMaterialAllProperty(Material material)
			throws SecurityException, ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException {

		Field[] fds = Class.forName("com.hyd.northpj.entity.Material")
				.getDeclaredFields();

		for (int i = 0; i < fds.length; i++) {
			fds[i].setAccessible(true);
			Object userProperty = fds[i].get(material);
			if (userProperty != null) {
				if (!isPassSqlFilter(userProperty.toString())) {
					return 1;
				}
			}
		}
		return 0;
	}

	public static int validateQuestionAllProperty(Question question)
			throws SecurityException, ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException {

		Field[] fds = Class.forName("com.hyd.northpj.entity.Question")
				.getDeclaredFields();

		for (int i = 0; i < fds.length; i++) {
			Object userProperty = fds[i].get(question);
			if (userProperty != null
					&& !isPassSqlFilter(userProperty.toString())) {
				return 1;
			}
		}
		return 0;
	}

	/**
	 * ��֤���ڷǿգ�����Ч��ֹsqlע��
	 * 
	 * @param question
	 * @return ������֤��� 1-->idΪnull��2-->idΪ�գ�3-->idδͨ����ȫ����֤
	 */
	public static int validateQuestionId(Question question) {
		if (question.getId() == null) {
			return 1;
		} else if (question.getId().equals("")) {
			return 2;
		} else if (!isPassSqlFilter(question.getId())) {
			return 3;
		}
		return 0;
	}

	/**
	 * ��֤�Ƿ�ͨ����sqlע�밲ȫ����֤
	 * 
	 * @param sourceSql
	 *            ����֤��sql���
	 * @return ��֤��� true-->��֤ͨ����falseδͨ����֤
	 */
	public static boolean isPassSqlFilter(String sourceSql) {

		if (sourceSql != null) {
			if (sqlPattern.matcher(sourceSql.trim()).find()) {
				logger.error("δ��ͨ����������p=" + sourceSql);

				return false;
			}
		}
		return true;
	}

	/**
	 * ��֤���ڵ���Ч��
	 * 
	 * @param beginDate
	 *            ��ʼ����j
	 * @param endDate
	 *            ��������
	 * @return ������֤��� true-->ͨ����֤��false-->δͨ����֤
	 */
	public static boolean isPassDateFilter(Date beginDate, Date endDate) {
		return beginDate != null
				&& ValidateUtil.isPassSqlFilter(beginDate.toString())
				&& endDate != null
				&& ValidateUtil.isPassSqlFilter(endDate.toString());
	}

	public static void copyProperty(User oldUser, User newUser)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		// �µ�class
		Class newClass = newUser.getClass();
		// �ϵ�class
		Class oldClass = oldUser.getClass();
		// �������е�����
		Field[] newFields = newClass.getDeclaredFields();
		// �µ�����
		Field newField = null;
		// �ϵ�����
		Field oldField = null;
		for (Field f : newFields) {
			// ���е���������
			String fieldName = f.getName();
			// ͨ���������ƻ�ȡ����
			newField = newClass.getDeclaredField(fieldName);
			// ��ȡ���Ե�ֵʱ��Ҫ����Ϊ true ��ָʾ����Ķ�����ʹ��ʱӦ��ȡ�� Java ���Է��ʼ�顣
			// ֵΪ false ��ָʾ����Ķ���Ӧ��ʵʩ Java ���Է��ʼ�顣
			newField.setAccessible(true);
			// �������Ի�ȡ�����ϵ�ֵ
			Object newObject = newField.get(newUser);
			// ���˿յ����Ի���һЩĬ��ֵ
			if (isContinue(newObject)) {
				continue;
			}
			oldField = oldClass.getDeclaredField(fieldName);
			oldField.setAccessible(true);
			oldField.set(oldUser, newObject);
		}
	}

	/**
	 * �Ƿ���������ѭ��
	 * 
	 * @author 2014-11-6 ����11:37:22
	 * @param object
	 * @return true �� ��null����Ĭ��ֵ false �� ��Ĭ��ֵ
	 */
	public static boolean isContinue(Object object) {
		if (object == null || "".equals(object)) {
			return true;
		}
		String valueStr = object.toString();
		if ("0".equals(valueStr) || "0.0".equals(valueStr)) {
			return true;
		}
		return false;
	}
}
