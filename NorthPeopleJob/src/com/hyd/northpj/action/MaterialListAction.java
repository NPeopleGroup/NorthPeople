package com.hyd.northpj.action;

import java.util.ArrayList;
import java.util.List;

import com.hyd.northpj.entity.Material;
import com.hyd.northpj.service.impl.MaterialService;
import com.hyd.northpj.util.CommonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class MaterialListAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Material> myMaterialList=new ArrayList<Material>();
	private MaterialService myMaterialService=new MaterialService();
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		myMaterialList=myMaterialService.getMaterialList();
		CommonUtil.toBeJson(myMaterialList, myMaterialList.size());
		return null;
	}
	public List<Material> getMyMaterialList() {
		return myMaterialList;
	}
	public void setMyMaterialList(List<Material> myMaterialList) {
		this.myMaterialList = myMaterialList;
	}

}
