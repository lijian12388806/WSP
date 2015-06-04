package com.liveneo.plat.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.Zip64Mode;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

public class ZipFileUtil {
	
	 /**
     * 把文件压缩成zip格式
     * @param files         需要压缩的文件
     * @param zipFilePath 压缩后的zip文件路径   ,如"D:/test/aa.zip";
     */
    public static void compressFiles2Zip(File[] files,String zipFilePath) {
        if(files != null && files.length >0) {
            if(isEndsWithZip(zipFilePath)) {
                ZipArchiveOutputStream zaos = null;
                try {
                    File zipFile = new File(zipFilePath);
                    zaos = new ZipArchiveOutputStream(zipFile);
                    //Use Zip64 extensions for all entries where they are required
                    zaos.setUseZip64(Zip64Mode.AsNeeded);
                     
                    //将每个文件用ZipArchiveEntry封装
                    //再用ZipArchiveOutputStream写到压缩文件中
                    for(File file : files) {
                        if(file != null) {
                            ZipArchiveEntry zipArchiveEntry  = new ZipArchiveEntry(file,file.getName());
                            zaos.putArchiveEntry(zipArchiveEntry);
                            InputStream is = null;
                            try {
                                is = new BufferedInputStream(new FileInputStream(file));
                                byte[] buffer = new byte[1024 * 5];  
                                int len = -1;
                                while((len = is.read(buffer)) != -1) {
                                    //把缓冲区的字节写入到ZipArchiveEntry
                                    zaos.write(buffer, 0, len);
                                }
                                //Writes all necessary data for this entry.
                                zaos.closeArchiveEntry();  
                            }catch(Exception e) {
                                throw new RuntimeException(e);
                            }finally {
                                if(is != null) 
                                    is.close();
                            }
                             
                        }
                    }
                    zaos.finish();
                }catch(Exception e){
                    throw new RuntimeException(e);
                }finally {
                        try {
                            if(zaos != null) {
                                zaos.close();
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                }
                 
            }
             
        }
         
    }
    /**
     * 把zip文件解压到指定的文件夹
     * @param zipFilePath   zip文件路径, 如 "D:/test/aa.zip"
     * @param saveFileDir   解压后的文件存放路径, 如"D:/test/"
     */
    public static void decompressZip(String zipFilePath,String saveFileDir) {
        if(isEndsWithZip(zipFilePath)) {
            File file = new File(zipFilePath);
            if(file.exists()) {
                InputStream is = null;
                //can read Zip archives
                ZipArchiveInputStream zais = null;
                try {
                    is = new FileInputStream(file);
                    zais = new ZipArchiveInputStream(is);
                    ArchiveEntry  archiveEntry = null;
                    //把zip包中的每个文件读取出来
                    //然后把文件写到指定的文件夹
                    while((archiveEntry = zais.getNextEntry()) != null) {
                        //获取文件名
                        String entryFileName = archiveEntry.getName();
                        //构造解压出来的文件存放路径
                        String entryFilePath = saveFileDir + entryFileName;
                        byte[] content = new byte[(int) archiveEntry.getSize()];
                        zais.read(content);
                        OutputStream os = null;
                        try {
                            //把解压出来的文件写到指定路径
                            File entryFile = new File(entryFilePath);
                            os = new BufferedOutputStream(new FileOutputStream(entryFile));
                            os.write(content);
                        }catch(IOException e) {
                            throw new IOException();
                        }finally {
                            if(os != null) {
                                os.flush();
                                os.close();
                            }
                        }
                         
                    }
                }catch(Exception e) {
                    throw new RuntimeException(e);
                }finally {
                        try {
                            if(zais != null) {
                                zais.close();
                            }
                            if(is != null) {
                                is.close();
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                }
            }
        }
    }
     
    /**
     * 判断文件名是否以.zip为后缀
     * @param fileName        需要判断的文件名
     * @return 是zip文件返回true,否则返回false
     */
    public static boolean isEndsWithZip(String fileName) {
        boolean flag = false;
        if(fileName != null && !"".equals(fileName.trim())) {
            if(fileName.endsWith(".ZIP")||fileName.endsWith(".zip")){
                flag = true;
            }
        }
        return flag;
    }
    
    
    //压缩文件为ZIP
    public static void compressZip(File source,String zipFilePath){
    	if(source.exists()) {
          File[] files = source.listFiles();
          ZipFileUtil.compressFiles2Zip(files, zipFilePath);
      }
    	
    }
    
    
   //多文件压缩
//    public static void test1() throws IOException {
//        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("D:\\testZip.zip"));
        //实例化一个名称为ab.txt的ZipEntry对象
//        ZipEntry entry = new ZipEntry("ab.txt");
        //设置注释
//        zos.setComment("zip测试for单个文件");
        //把生成的ZipEntry对象加入到压缩文件中，而之后往压缩文件中写入的内容都会放在这个ZipEntry对象里面
//        zos.putNextEntry(entry);
//        InputStream is = new FileInputStream("D:\\ab.txt");
        int len = 0;
//        while ((len = is.read()) != -1)
//            zos.write(len);
//        is.close();
//        zos.close();
//    }
     
    public static void test2() throws IOException {
        File inFile = new File("D:\\test\\bbb");
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("D:\\test.zip"));
        zos.setComment("多文件处理");
        zipFile(inFile, zos, "");
        zos.close();
    }
     
    public static void zipFile(File inFile, ZipOutputStream zos, String dir) throws IOException {
        if (inFile.isDirectory()) {
            File[] files = inFile.listFiles();
            for (File file:files)
                zipFile(file, zos, dir + "\\" + inFile.getName());
        } else {
            String entryName = null;
            if (!"".equals(dir))
                entryName = dir + "\\" + inFile.getName();
            else
                entryName = inFile.getName();
            ZipEntry entry = new ZipEntry(entryName);
            zos.putNextEntry(entry);
            InputStream is = new FileInputStream(inFile);
            int len = 0;
            while ((len = is.read()) != -1)
                zos.write(len);
            is.close();
        }

    }
    
/**
 * zipFileName   路径+压缩后的zip文件名
 * inputFileName 要压缩的文件
 * 
 * **/
    public static  void zip(String zipFileName, String inputFileName) throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        zip(out, new File(inputFileName), "");
        out.close();
    }

    private static  void zip(ZipOutputStream out, File f, String base) throws Exception {
        if (f.isDirectory()) {
           File[] fl = f.listFiles();
           out.putNextEntry(new ZipEntry(base + "/"));
           base = base.length() == 0 ? "" : base + "/";
           for (int i = 0; i < fl.length; i++) {
           zip(out, fl[i], base + fl[i].getName());
         }
        }else {
           out.putNextEntry(new ZipEntry(base));
           FileInputStream in = new FileInputStream(f);
           int b;
           while ( (b = in.read()) != -1) {
            out.write(b);
         }
         in.close();
       }
    }
    
    /**
     * zipfile  要解压的zip文件路径+名字
     * destDir  解压到的文件路径
     * 
     * **/
    
    public static void extZipFileList(String zipfile, String destDir){
		destDir = destDir.endsWith("\\") ? destDir : destDir + "\\";
		byte b[] = new byte[512];
		int length;     
		ZipFile zipFile;
		try {
			zipFile = new ZipFile(new File(zipfile));
			Enumeration enumeration = zipFile.entries();
			ZipEntry zipEntry = null;
			while (enumeration.hasMoreElements()) {
				zipEntry = (ZipEntry) enumeration.nextElement();
				File loadFile = new File(destDir + zipEntry.getName());
				if (zipEntry.isDirectory()) {
					loadFile.mkdirs();
				} else {
					if (!loadFile.getParentFile().exists())
						loadFile.getParentFile().mkdirs();
					OutputStream outputStream = new FileOutputStream(loadFile);
					InputStream inputStream = zipFile.getInputStream(zipEntry);
					while ((length = inputStream.read(b)) > 0){
						outputStream.write(b,0,length);
					}	
				}
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
	}
    public static void main(String args[]) throws Exception  {
    	//存放待压缩文件的目录
//        File srcFile = new File("D:/test");
//        压缩后的zip文件路径
//        String zipFilePath = "D:/test/test.zip";
//        if(srcFile.exists()) {
//            File[] files = srcFile.listFiles();
//            ZipFileUtil.compressFiles2Zip(files, zipFilePath);
//        }
//        ZipFileUtil.compressZip(srcFile, zipFilePath);
        //压缩包所在路径
//        String zipFilePath = "d:/bbb.zip";
        //解压后的文件存放目录
//        String saveFileDir = "d:/test/";
        //调用解压方法
//        ZipFileUtil.decompressZip(zipFilePath, saveFileDir);
//    	ZipFileUtil.zip("D:/test.zip","D:/test");
//    	File target=new File(CreateXml.backupsource+"conf.zip");
//    	FileUtil.deleteDirectory("D:/test/conf.zip");
    	ZipFileUtil.extZipFileList("D:/aaa.zip","D:/test/");
    }
    	
}
