package com.zqy.find.service.model;

import java.io.Serializable;

public class SearchFace  implements Serializable{
    private long faceID;
    private  float similarityGoal;
   
	public long getFaceID() {
		return faceID;
	}
	public void setFaceID(long faceID) {
		this.faceID = faceID;
	}
	public float getSimilarityGoal() {
		return similarityGoal;
	}
	public void setSimilarityGoal(float similarityGoal) {
		this.similarityGoal = similarityGoal;
	}
}
