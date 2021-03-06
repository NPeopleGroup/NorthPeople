package com.hyd.northpj.action;

import java.util.ArrayList;
import java.util.List;

import com.hyd.northpj.entity.Material;
import com.hyd.northpj.entity.Question;
import com.hyd.northpj.service.impl.MaterialService;
import com.hyd.northpj.service.impl.QuestionService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminQuestionAddPageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4846975153597108907L;
	private List<Question> gotoList;
	private List<Material> materialList;
	private String questionType;

	@Override
	public String execute() throws Exception {

		List<Question> gotoList = new ArrayList<Question>();
		QuestionService myQuestionService = new QuestionService();
		gotoList = myQuestionService.getQuestionList(myQuestionService
				.changeQuestionTypeToChinese(questionType));
		Question finish = new Question();
		finish.setId("end");
		gotoList.add(finish);
		setGotoList(gotoList);

		List<Material> materialList = new ArrayList<Material>();
		MaterialService materialService = new MaterialService();
		materialList = materialService.getMaterialList();
//		for (Material tmpMaterial: materialList){
//			if(!tmpMaterial.getDescription().equals(null)){
//				tmpMaterial.setName(tmpMaterial.getName()+"("+tmpMaterial.getDescription()+")");
//			}
//		}
		setMaterialList(materialList);

		return SUCCESS;
	}

	public List<Question> getGotoList() {
		return gotoList;
	}

	public void setGotoList(List<Question> gotoList) {
		this.gotoList = gotoList;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public List<Material> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(List<Material> materialList) {
		this.materialList = materialList;
	}

}
