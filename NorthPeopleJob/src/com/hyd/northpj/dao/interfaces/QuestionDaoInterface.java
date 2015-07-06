package com.hyd.northpj.dao.interfaces;

import java.util.List;

import com.hyd.northpj.entity.Question;

public interface QuestionDaoInterface {

	/**
	 * ��ȡһ������
	 * 
	 * @param
	 * @return һ��������б�
	 * @throws Exception
	 */
	public List<Question> selectQuestionList() throws Exception;

	/**
	 * ���һ������
	 * 
	 * @param question
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int insertQuestion(Question question) throws Exception;

	/**
	 * ��ȡһ������
	 * 
	 * @param id
	 * @return ���ػ�ȡ��������
	 * @throws Exception
	 */
	public Question selectQuestion(String id) throws Exception;

	/**
	 * ������������
	 * 
	 * @param question
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int updateQuestion(Question question) throws Exception;

	/**
	 * ɾ����������
	 * 
	 * @param id
	 * @return һ�������ȫ������
	 * @throws Exception
	 */
	public int deleteQuestion(String id) throws Exception;

}
