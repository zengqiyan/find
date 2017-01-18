package com.zqy.find.face.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;


public class Faceset implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1003245161508717740L;
	private Integer facesetid;//id
	private Integer face_count;
	private String faceset_id;
	private String faceset_name;
	public Integer getFacesetid() {
		return facesetid;
	}
	public void setFacesetid(Integer facesetid) {
		this.facesetid = facesetid;
	}
	public Integer getFace_count() {
		return face_count;
	}
	public void setFace_count(Integer face_count) {
		this.face_count = face_count;
	}
	public String getFaceset_id() {
		return faceset_id;
	}
	public void setFaceset_id(String faceset_id) {
		this.faceset_id = faceset_id;
	}
	public String getFaceset_name() {
		return faceset_name;
	}
	public void setFaceset_name(String faceset_name) {
		this.faceset_name = faceset_name;
	}
	public static void main(String[] args) {
		 NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		 currencyFormat.setCurrency(Currency.getInstance(Locale.JAPAN));
	     System.out.println("本地默认格式输出货币值：" + currencyFormat.format(123));  
	}
}
