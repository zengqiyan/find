package com.zqy.find.face.service.faceService;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zqy.find.face.faceTool.lib64.FaceTool;
import com.zqy.find.face.model.Face;
import com.zqy.find.face.repository.FaceRepository;



@Service
@Transactional
public class TrainService {
	@Autowired
	private FaceRepository faceRepository;
	
	public void trainAndSave(int szzid[], String[] imgPaths) throws Exception {
		FaceTool v = FaceTool.INSTANCE;
		v.init("E:/face/model/seeta_fd_frontal_v1.0.bin",
			   "E:/face/model/seeta_fa_v1.1.bin",
			   "E:/face/model/seeta_fr_v1.0.bin");
		int size = imgPaths.length;
		String[] featStrs = new String[size];
		String[] flag = new String[size];
		for(int i=0;i<size;i++){
			flag[i] = String.valueOf(szzid[i]);
		}
		v.getFeatureStrs(size, imgPaths, flag, featStrs);
		for(int i=0;i<size;i++){
			if(featStrs[i]!=null && !featStrs[i].equals("")){
				Face face = new Face();
				String[] feats = featStrs[i].split(":");
				face.setSzzid(Long.valueOf(feats[0]));
				face.setFaceFeat(feats[1]);
				faceRepository.save(face);
			}
		}
	}
	
}
