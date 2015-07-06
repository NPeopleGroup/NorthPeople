package com.hyd.northpj.service.interfaces;

import java.util.List;

import com.hyd.northpj.entity.Question;

public interface QuestionServiceInterface {
	/**
	 * ��ȡһ������
	 * 
	 * @param 
	 * @return һ��������б�
	 * @throws Exception
	 */
	public List<Question> getQuestionList() throws Exception;

	/**
	 * ���һ������
	 * 
	 * @param question
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int addQuestion(Question question) throws Exception;

	/**
	 * ��ȡһ������
	 * 
	 * @param id
	 * @return ���ػ�ȡ��������
	 * @throws Exception
	 */
	public Question getQuestion(String id) throws Exception;
	
	/**
	 * ������������
	 * 
	 * @param question
	 * @return �ɹ�����0��ʧ�ܷ��ط�0
	 * @throws Exception
	 */
	public int setQuestion(Question question) throws Exception;

	/**
	 * ɾ����������
	 * 
	 * @param id
	 * @return һ�������ȫ������
	 * @throws Exception
	 */
	public int deleteQuestion(String id) throws Exception;

}
