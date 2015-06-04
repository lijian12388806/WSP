package com.liveneo.plat.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRDUtils {

	public FileRDUtils() {
	}

	/**
	 * 删除某个文件夹下的所有文件夹和文件
	 * 
	 * @param delpath
	 *            String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @return boolean
	 */
	public static boolean deletefile(String delpath)
			throws FileNotFoundException, IOException {
		try {

			File file = new File(delpath);
			if (!file.isDirectory()) {
				System.out.println("1");
				file.delete();
			} else if (file.isDirectory()) {
				System.out.println("2");
				String[] filelist = file.list();
				for (int i = 0; i < filelist.length; i++) {
					File delfile = new File(delpath + "\\" + filelist[i]);
					if (!delfile.isDirectory()) {
						System.out.println("path=" + delfile.getPath());
						System.out.println("absolutepath="
								+ delfile.getAbsolutePath());
						System.out.println("name=" + delfile.getName());
						delfile.delete();
						System.out.println("删除文件成功");
					} else if (delfile.isDirectory()) {
						deletefile(delpath + "\\" + filelist[i]);
					}
				}
				file.delete();

			}

		} catch (FileNotFoundException e) {
			System.out.println("deletefile() Exception:" + e.getMessage());
		}
		return true;
	}

	/**
	 * 读取某个文件夹下的所有文件夹和文件
	 * 
	 * @param delpath
	 *            String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @return boolean
	 */
	public static List<String> readfile(String filepath)
			throws FileNotFoundException, IOException {
		try {

			File file = new File(filepath);
			List<String> fileList = new ArrayList<String>();
			if (!file.isDirectory()) {
				fileList.add(file.getName());
			} else if (file.isDirectory()) {
				String[] filesInDirect = file.list();
//				fileList = ListUtil.ConvertArrayToStringList(filesInDirect, "String");
				for (int i = 0; i < filesInDirect.length; i++) {
					File readfile = new File(filepath + "\\" + filesInDirect[i]);
					if (!readfile.isDirectory()) {
						fileList.add(filesInDirect[i]);
					} else if (readfile.isDirectory()) {
						readfile(filepath + "\\" + filesInDirect[i]);
					}
				}

			}
			return fileList;
		} catch (Exception e) {
			System.out.println("readfile() Exception:" + e.getMessage());
			return new ArrayList<String>();
		}
	}
	public static String createFile(String fileName, String filecontent) throws IOException {
		// 生成文件
		File file = new File(fileName);
		FileOutputStream out = null;
		try{
			if (!file.exists()) {
				file.createNewFile();
			}
			out = new FileOutputStream(file, false);
			out.write(filecontent.getBytes("utf-8"));
		}catch(Exception e){
			System.out.println("createFile Exception"+e.getMessage());
		}finally{
			out.close();
		}
		return fileName;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			readfile("http://172.16.1.133/IPPhonePush/css");
			System.out.println("%%:"+7%7);
			// deletefile("D:/file");
		} catch (FileNotFoundException ex) {
		} catch (IOException ex) {
		}
		System.out.println("ok");
	}

}
