package com.hyd.northpj.action;

import com.hyd.northpj.service.impl.QuestionService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminQuestionDeleteAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3265213567707315809L;
	private String id;
	private String questionType;
	@Override
	public String execute() throws Exception {

		QuestionService myQuestionService = new QuestionService();
		myQuestionService.deleteQuestion(id);
		return SUCCESS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

}
