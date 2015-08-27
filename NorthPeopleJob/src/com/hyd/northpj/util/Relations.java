package com.hyd.northpj.util;

public class Relations {
	private String relation;
	private String relationName;
	private String relationIDCard;
	private String relationDegree;
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getRelationName() {
		return relationName;
	}
	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}
	public String getRelationIDCard() {
		return relationIDCard;
	}
	public void setRelationIDCard(String relationIDCard) {
		this.relationIDCard = relationIDCard;
	}
	public String getRelationDegree() {
		return relationDegree;
	}
	public void setRelationDegree(String relationDegree) {
		this.relationDegree = relationDegree;
	}
	public Relations(String relation, String relationName,
			String relationIDCard, String relationDegree) {
		super();
		this.relation = relation;
		this.relationName = relationName;
		this.relationIDCard = relationIDCard;
		this.relationDegree = relationDegree;
	}
	
	
}
