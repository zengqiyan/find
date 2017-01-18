package com.zqy.find.face.faceTool.lib;

import java.io.File;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;

public interface Identification extends Library {
	String classPath = Identification.class.getClassLoader()
			.getResource("").getPath();
	String dllName = "Identification";
	String dllpath = new File(classPath
			+ Identification.class.getPackage().getName()
					.replaceAll("\\.", "/") + "/" + dllName).getAbsolutePath();
	Identification INSTANCE = (Identification) Native.loadLibrary(
			dllpath, Identification.class);
}
