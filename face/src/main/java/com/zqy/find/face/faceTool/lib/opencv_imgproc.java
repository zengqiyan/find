package com.zqy.find.face.faceTool.lib;

import java.io.File;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public interface opencv_imgproc extends Library {
	String classPath = opencv_imgproc.class.getClassLoader()
			.getResource("").getPath();
	String dllName = "opencv_imgproc2413";
	String dllpath = new File(classPath
			+ opencv_imgproc.class.getPackage().getName()
					.replaceAll("\\.", "/") + "/" + dllName).getAbsolutePath();
	opencv_imgproc INSTANCE = (opencv_imgproc) Native.loadLibrary(
			dllpath, opencv_imgproc.class);
}
