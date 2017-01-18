package com.zqy.find.face.faceTool.lib64;

import java.io.File;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface FaceTool extends Library {
	FaceAlignment faceAlignment =FaceAlignment.INSTANCE;
	FaceDetection faceDetection =FaceDetection.INSTANCE;
	Identification identification = Identification.INSTANCE;
	opencv_core _opencv_core =opencv_core.INSTANCE; 
	opencv_highgui _opencv_highgui =opencv_highgui.INSTANCE; 
    opencv_imgproc _opencv_imgproc = opencv_imgproc.INSTANCE;
	String classPath = FaceTool.class.getClassLoader()
			.getResource("").getPath();
	String dllName = "faceTool";
	String dllpath = new File(classPath
			+ FaceTool.class.getPackage().getName()
					.replaceAll("\\.", "/") + "/" + dllName).getAbsolutePath();
	FaceTool INSTANCE = (FaceTool) Native.loadLibrary(
			dllpath, FaceTool.class);
	void init(String detectorBinPath, String faceAlignmentBinPath, String faceIdentificationBinPath);
    void load(int size, int feat_dims, String[] id, String[] featureStr);
	String getFeatureStr(String filePath);
	boolean getFeatureStrs(int size, String[] imgPaths, String[] flag, String[] featStrs);
    void find(int topK,String filename,String[] id, float[] similarityGoal);
}
