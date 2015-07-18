package com.hyd.northpj.action;

import com.hyd.northpj.entity.Question;
import com.hyd.northpj.service.impl.AnswerService;
import com.hyd.northpj.service.impl.QuestionService;
import com.opensymphony.xwork2.ActionSupport;

public class AnswerQuestionPageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5561112297024954096L;
	private String from;
	private String id;
	private String type;
	private String unFinishedType;
	private Question question;

	@Override
	public String execute() throws Exception {

		QuestionService myQuestionService = new QuestionService();
		AnswerService myAnswerService = new AnswerService();
		setUnFinishedType(myAnswerService.getUnFinishedType());
		question = myQuestionService.getQuestion(id);
		if (question != null) {
			setQuestion(question);
			return SUCCESS;
		} else {
			return "input";
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getUnFinishedType() {
		return unFinishedType;
	}

	public void setUnFinishedType(String unFinishedType) {
		this.unFinishedType = unFinishedType;
	}
}
