package com.zqy.find.face.faceTool.lib;

import java.io.File;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public interface opencv_core extends Library {
	String classPath = opencv_core.class.getClassLoader()
			.getResource("").getPath();
	String dllName = "opencv_core2413";
	String dllpath = new File(classPath
			+ opencv_core.class.getPackage().getName()
					.replaceAll("\\.", "/") + "/" + dllName).getAbsolutePath();
	opencv_core INSTANCE = (opencv_core) Native.loadLibrary(
			dllpath, opencv_core.class);

}
