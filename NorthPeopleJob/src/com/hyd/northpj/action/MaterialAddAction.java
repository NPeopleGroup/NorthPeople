package com.hyd.northpj.action;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.hyd.northpj.entity.Material;
import com.hyd.northpj.service.impl.MaterialService;
import com.opensymphony.xwork2.ActionSupport;

public class MaterialAddAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private String department;
	private String imageContentType;
	private String imageFileName;
	private File image;
	private String result;
	private String url;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String newFileName=null;
		try {

			if (image != null) {
				String realpath = ServletActionContext.getServletContext()
						.getRealPath("/img");
				newFileName=new Date().getTime()+imageFileName.substring(imageFileName.lastIndexOf("."));
				File savefile = new File(new File(realpath), newFileName);
				if (!savefile.getParentFile().exists())
					savefile.getParentFile().mkdirs();
				FileUtils.copyFile(image, savefile);

			}

			MaterialService materialService = new MaterialService();

			Material myMaterial=new Material();
			myMaterial.setName(name);
			myMaterial.setDescription(description);
			myMaterial.setDepartment(department);
			myMaterial.setImage(newFileName);
			if (0 == materialService.addMaterial(myMaterial)) {

				result="增加材料成功,2s以后将会跳转到材料列表页面！";
				url="admin/materialList";

			}
		} catch (Exception e) {
			result="增加材料失败,2s以后将会跳转到新增材料页面！";
			url="admin/materialAdd";
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
