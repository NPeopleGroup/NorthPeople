package com.hyd.northpj.action;

import com.hyd.northpj.service.impl.MaterialService;
import com.hyd.northpj.util.CommonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class MaterialDeleteAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MaterialService myMaterialService=new MaterialService();
	private int materialId;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		int returnResult=myMaterialService.deleteMaterial(materialId);
		if(returnResult==0)
		{
			CommonUtil.toBeJsonResult("success");
		}else
		{
			CommonUtil.toBeJsonResult("failed");
		}
		return null;
	}
	public int getMaterialId() {
		return materialId;
	}
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}


}
