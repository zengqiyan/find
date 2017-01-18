package com.zqy.find.face.faceTool.lib;

import java.io.File;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public interface opencv_highgui extends Library {
	String classPath = opencv_highgui.class.getClassLoader()
			.getResource("").getPath();
	String dllName = "opencv_highgui2413";
	String dllpath = new File(classPath
			+ opencv_highgui.class.getPackage().getName()
					.replaceAll("\\.", "/") + "/" + dllName).getAbsolutePath();
	opencv_highgui INSTANCE = (opencv_highgui) Native.loadLibrary(
			dllpath, opencv_highgui.class);
}
