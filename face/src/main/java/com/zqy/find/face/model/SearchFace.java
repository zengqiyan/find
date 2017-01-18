package com.zqy.find.face.model;

public class SearchFace {
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
