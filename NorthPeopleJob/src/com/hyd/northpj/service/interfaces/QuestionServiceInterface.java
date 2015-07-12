package com.hyd.northpj.service.interfaces;

import java.util.List;

import com.hyd.northpj.entity.Question;

public interface QuestionServiceInterface {
	/**
	 * 获取一组问题
	 * 
	 * @param 
	 * @return 一组问题的列表
	 * @throws Exception
	 */
	public List<Question> getQuestionList() throws Exception;

	/**
	 * 添加一个问题
	 * 
	 * @param question
	 * @return 成功返回0，失败返回非0
	 * @throws Exception
	 */
	public int addQuestion(Question question) throws Exception;

	/**
	 * 获取一个问题
	 * 
	 * @param id
	 * @return 返回获取到的问题
	 * @throws Exception
	 */
	public Question getQuestion(String id) throws Exception;
	
	/**
	 * 设置问题内容
	 * 
	 * @param question
	 * @return 成功返回0，失败返回非0
	 * @throws Exception
	 */
	public int setQuestion(Question question) throws Exception;

	/**
	 * 删除问题内容
	 * 
	 * @param id
	 * @return 一个试题的全部内容
	 * @throws Exception
	 */
	public int deleteQuestion(String id) throws Exception;

	/**
	 * 转换问题类型为中文
	 * 
	 * @param questionType
	 * @return 中文问题类型
	 * @throws Exception
	 */
	String changeQuestionTypeToChinese(String questionType) throws Exception;

	/**
	 * 转换问题类型为英文
	 * 
	 * @param questionType
	 * @return 英文问题类型
	 * @throws Exception
	 */
	String changeQuestionTypeToEnglish(String questionType) throws Exception;

	/**
	 *  获取一个问题
	 * 
	 * @param id
	 * @param type
	 * @return 返回获取到的问题
	 * @throws Exception
	 */
	Question getQuestionByType(String id, String type) throws Exception;

	/**
	 * 获取下一个问题类型
	 * 
	 * @param questionType
	 * @return 返回获取到的问题类型
	 * @throws Exception
	 */
	String getNextQuestionType(String questionType) throws Exception;

	/**
	 * 获取一组问题
	 * 
	 * @param questionType
	 * @return 一组问题的列表
	 * @throws Exception
	 */
	List<Question> getQuestionList(String questionType) throws Exception;

}
