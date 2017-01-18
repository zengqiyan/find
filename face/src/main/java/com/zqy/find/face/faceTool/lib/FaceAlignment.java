package com.zqy.find.face.faceTool.lib;

import java.io.File;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface FaceAlignment extends Library {
	String classPath = FaceAlignment.class.getClassLoader()
			.getResource("").getPath();
	String dllName = "FaceAlignment";
	String dllpath = new File(classPath
			+ FaceAlignment.class.getPackage().getName()
					.replaceAll("\\.", "/") + "/" + dllName).getAbsolutePath();
	FaceAlignment INSTANCE = (FaceAlignment) Native.loadLibrary(
			dllpath, FaceAlignment.class);
	
}
