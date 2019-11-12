package com.kimyunjae.util.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {
	public static String createUploadFolder(String path) {
		String ret = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		File file = new File(path,ret);
		if(!file.exists()) {
			file.mkdirs();
		}
//		System.out.println(file.getPath());
		return ret;
	}
	
	
	
	
}
