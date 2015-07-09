package com.hyd.northpj.action;

import java.util.ArrayList;
import java.util.List;

import com.hyd.northpj.entity.Question;
import com.hyd.northpj.service.impl.QuestionService;
import com.hyd.northpj.util.CommonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class AdminQuestionListAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5742246754557711658L;
	private String questionType;

	@Override
	public String execute() throws Exception {

		QuestionService questionService = new QuestionService();
		List<Question> questionList = new ArrayList<Question>();
		if (questionType != null) {
			switch (questionType) {
			case "age":
				setQuestionType("����");
				break;
			case "education":
				setQuestionType("����");
				break;
			case "skills_title":
				setQuestionType("����(ְ��)");
				break;
			case "skills_qualifications":
				setQuestionType("����(ְҵ�ʸ�)");
				break;
			case "housing":
				setQuestionType("ס��");
				break;
			case "security":
				setQuestionType("�籣");
				break;
			case "settled_area":
				setQuestionType("�仧����");
				break;
			case "career":
				setQuestionType("ְҵ");
				break;
			case "investment_tax":
				setQuestionType("Ͷ����˰");
				break;
			case "awards_honor":
				setQuestionType("��������");
				break;
			case "marital_status":
				setQuestionType("����״��");
				break;
			case "working_years":
				setQuestionType("��������");
				break;
			case "law_integrity":
				setQuestionType("�ط�����");
				break;

			default:
				setQuestionType("����");
				break;
			}
			questionList = questionService.getQuestionList(questionType);
		} else {
			questionList = questionService.getQuestionList();
		}

		CommonUtil.toBeJson(questionList, questionList.size());

		return null;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	/**
	 * 
	 */

}
