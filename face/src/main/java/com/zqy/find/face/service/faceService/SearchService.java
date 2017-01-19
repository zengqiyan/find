package com.zqy.find.face.service.faceService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zqy.find.face.faceTool.lib64.FaceTool;
import com.zqy.find.face.model.Face;
import com.zqy.find.face.model.SearchFace;
import com.zqy.find.face.repository.FaceRepository;



@Service
public class SearchService {

	@Autowired
	private FaceRepository faceRepository;
	
	public List<SearchFace> searchFace(int faceCount, String faceImgFile) {
		FaceTool faceTool = FaceTool.INSTANCE;
		faceTool.init("E:/face/model/seeta_fd_frontal_v1.0.bin",
				   "E:/face/model/seeta_fa_v1.1.bin",
				   "E:/face/model/seeta_fr_v1.0.bin");
		List<Face> faceList= faceRepository.findAll();//mongoTemplate.findAll(Face.class);
		
		if(faceList==null || faceList.size()<=0){
			return null;
		}
		int size = faceList.size();
		String[] id = new String[size];
		String[] featureStr = new String[size];
		for(int i=0;i<faceList.size();i++){
			id[i] = String.valueOf(faceList.get(i).getId());
			featureStr[i] = faceList.get(i).getFaceFeat();
		}
		faceTool.load(faceList.size(), 2048, id, featureStr);
		String[] reaultId = new String[faceCount];
		float[] similarityGoal = new float[faceCount];
		faceTool.find(faceCount, faceImgFile, reaultId, similarityGoal);
		List<SearchFace> resultFaces = new ArrayList<SearchFace>();
		for(int i=0;i<faceCount;i++){
			if(reaultId[i]!=null){
				SearchFace searchFace = new SearchFace();
				searchFace.setSimilarityGoal(similarityGoal[i]);
				searchFace.setFaceID(Long.parseLong(reaultId[i]));
				resultFaces.add(searchFace);
			}
		}
		return resultFaces;
	}}
