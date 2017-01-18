package com.zqy.find.face.faceTool.lib64;

import java.io.File;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public interface FaceDetection extends Library {
	String classPath = FaceDetection.class.getClassLoader()
			.getResource("").getPath();
	String dllName = "FaceDetection";
	String dllpath = new File(classPath
			+ FaceDetection.class.getPackage().getName()
					.replaceAll("\\.", "/") + "/" + dllName).getAbsolutePath();
	FaceDetection INSTANCE = (FaceDetection) Native.loadLibrary(
			dllpath, FaceDetection.class);
}
