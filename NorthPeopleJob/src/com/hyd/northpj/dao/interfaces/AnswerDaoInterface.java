package com.hyd.northpj.dao.interfaces;

import java.util.ArrayList;

import com.hyd.northpj.entity.Answer;
import com.hyd.northpj.model.EvaluationFile;
import com.hyd.northpj.model.EvaluationScore;

public interface AnswerDaoInterface {
	/**
	 * 增加一个答案
	 * 
	 * @param adminUser
	 * @return 成功返回0，失败返回非0
	 * @throws Exception
	 */
	public int insertAnswer(Answer answer) throws Exception;

	/**
	 * 获取用户的评价分数集合
	 * 
	 * @param username
	 * @return 评价分数集合，评价类型，该类型的成绩
	 * @throws Exception
	 */
	public ArrayList<EvaluationScore> selectEvaluationScore(String username)
			throws Exception;

	/**
	 * 获取用户的评价材料集合
	 * 
	 * @param username
	 * @return 评价材料集合，评价材料，该材料所属部门
	 * @throws Exception
	 */
	public ArrayList<EvaluationFile> selectEvaluationFile(String username)
			throws Exception;

	/**
	 * 根据用户名和答题ID获取一个问题
	 * 
	 * @param username
	 * @param questionId
	 * @return 返回获取到的问题
	 * @throws Exception
	 */
	Answer selectAnswer(String username, String questionId) throws Exception;

	/**
	 * 删除用户的某一类型答题
	 * 
	 * @param username
	 * @param type
	 * @return 正确删除则返回0
	 * @throws Exception
	 */
	int deleteAnswerByPeopleAndType(String username, String type);

	/**
	 * 删除用户的某一个答题
	 * 
	 * @param username
	 * @param questionId
	 * @return 正确删除则返回0
	 * @throws Exception
	 */
	int deleteQuestionByPeopleAndQuestionId(String username, String questionId);

	/**
	 * 获取用户未完成答题的题目类型
	 * 
	 * @return 用户未完成答题的题目类型 格式例如：<年龄><教育>
	 * @throws Exception
	 */
	String selectUnFinishedType();

}
