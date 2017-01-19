package com.zqy.find.face.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.zqy.dao.mogo.GeneratedValue;


@Document
public class Face implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3660372976788337778L;

	@GeneratedValue
	@Id
	private Long id ;//id
	private Long szzid;
	private String faceFeat;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSzzid() {
		return szzid;
	}
	public void setSzzid(Long szzid) {
		this.szzid = szzid;
	}
	public String getFaceFeat() {
		return faceFeat;
	}
	public void setFaceFeat(String faceFeat) {
		this.faceFeat = faceFeat;
	}
}
