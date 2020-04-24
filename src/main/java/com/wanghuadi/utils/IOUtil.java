package com.wanghuadi.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class IOUtil {
	
	
	/**
	 * 获取文件扩展名
	 * @return
	 */
	public static String getName(){
		File file = new File("pom.xml");
		String name = file.getName();
		return name.substring(name.indexOf("."));
	}
	
	/*
	 * 删除文件，如果是目录，则下面的文件和所有子目录中的文件都要删除
	 * 递归删除
	*/
	public static void deleteFile(File file){
		if(file.exists()){
			if(file.isDirectory()){
				File[] listFiles = file.listFiles();
				for (File file2 : listFiles) {
					if(file2.isDirectory()){
						deleteFile(file2);
					}else{
						file2.delete();
					}
				}
				file.delete();
			}
		}
	}
	
	/**
	 * 解析文件
	 * @param filePath  文件路径
	 * @param splitstring	切割 符号
	 * @return
	 */
	public static List<Object[]> readFile(String filePath,String splitstring) {
		try {
			File file  = new File(filePath);
			//按行读取
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = "";
			
			List<Object[]> list = new ArrayList<Object[]>();
			while((str = br.readLine())!= null){
				String[] split = str.split(splitstring);
				list.add(split);
			}
			br.close();
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
