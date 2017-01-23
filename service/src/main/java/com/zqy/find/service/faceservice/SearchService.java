package com.zqy.find.service.faceservice;

import java.util.List;

import com.zqy.find.service.model.SearchFace;

public interface SearchService {
	public List<SearchFace> searchFace(int faceCount, String faceImgFile);
}
