package com.zqy.find.face.faceTool.lib64;

import java.io.File;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

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
