package com.hyd.northpj.action;

import com.hyd.northpj.entity.Material;
import com.hyd.northpj.service.impl.MaterialService;
import com.hyd.northpj.util.PrintDataToAjax;
import com.opensymphony.xwork2.ActionSupport;

public class MaterialInfoViewAction extends ActionSupport {

	/**
	 *所述材料信息 
	 */
	private static final long serialVersionUID = 1L;

	private int sn;
	private Material myMaterial=new Material();
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(sn);
		MaterialService myMaterialService=new MaterialService();
		myMaterial=myMaterialService.getMaterialInfo(sn);
		return SUCCESS;
	}

	public int getSn() {
		return sn;
	}

	public void setSn(int sn) {
		this.sn = sn;
	}

	public Material getMyMaterial() {
		return myMaterial;
	}

	public void setMyMaterial(Material myMaterial) {
		this.myMaterial = myMaterial;
	}

}
