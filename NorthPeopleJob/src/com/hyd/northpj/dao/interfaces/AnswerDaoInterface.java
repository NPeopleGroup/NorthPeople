package com.hyd.northpj.dao.interfaces;

import java.util.ArrayList;

import com.hyd.northpj.entity.Answer;
import com.hyd.northpj.model.EvaluationFile;
import com.hyd.northpj.model.EvaluationScore;

public interface AnswerDaoInterface {
	/**
	 * ����һ����
	 * 
	 * @param adminUser
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int insertAnswer(Answer answer) throws Exception;

	/**
	 * ��ȡ�û������۷�������
	 * 
	 * @param username
	 * @return ���۷������ϣ��������ͣ������͵ĳɼ�
	 * @throws Exception
	 */
	public ArrayList<EvaluationScore> selectEvaluationScore(String username)
			throws Exception;

	/**
	 * ��ȡ�û������۲��ϼ���
	 * 
	 * @param username
	 * @return ���۲��ϼ��ϣ����۲��ϣ��ò�����������
	 * @throws Exception
	 */
	public ArrayList<EvaluationFile> selectEvaluationFile(String username)
			throws Exception;

	/**
	 * �����û����ʹ���ID��ȡһ������
	 * 
	 * @param username
	 * @param questionId
	 * @return ���ػ�ȡ��������
	 * @throws Exception
	 */
	Answer selectAnswer(String username, String questionId) throws Exception;

	/**
	 * ɾ���û���ĳһ���ʹ���
	 * 
	 * @param username
	 * @param type
	 * @return ��ȷɾ���򷵻�0
	 * @throws Exception
	 */
	int deleteAnswerByPeopleAndType(String username, String type);

	/**
	 * ɾ���û���ĳһ������
	 * 
	 * @param username
	 * @param questionId
	 * @return ��ȷɾ���򷵻�0
	 * @throws Exception
	 */
	int deleteQuestionByPeopleAndQuestionId(String username, String questionId);

	/**
	 * ��ȡ�û�δ��ɴ������Ŀ����
	 * 
	 * @return �û�δ��ɴ������Ŀ���� ��ʽ���磺<����><����>
	 * @throws Exception
	 */
	String selectUnFinishedType();

}
