package com.hyd.northpj.entity;



/**
 * TMaterial entity. @author MyEclipse Persistence Tools
 */

public class Material {


    // Fields    

     private int sn;
     private String name;
     private String image;
     private String description;

    // Property accessors

    public Integer getSn() {
        return this.sn;
    }
    
    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }


	@Override
	public String toString() {
		return "Material [sn=" + sn + ", name=" + name + ", image=" + image
				+ ", description=" + description + "]";
	}
}