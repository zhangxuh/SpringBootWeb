package com.cn.util;

/**
 * Created by Administrator on 2016/11/11.
 */
public class FileUtil {
    /**
     * 判断文件是否为图片文件
     * @param fileName
     * @return
     */
    public static boolean isImageFile(String fileName) {
        String [] img_type = new String[]{".jpg", ".jpeg", ".png", ".gif", ".bmp"};
        if(fileName==null) {return false;}
        fileName = fileName.toLowerCase();
        for(String type : img_type) {
            if(fileName.endsWith(type)) {return true;}
        }
        return false;
    }
    /**
     * 获取文件后缀名
     * @param fileName
     * @return
     */
    public static String getFileType(String fileName) {
        if(fileName!=null && fileName.indexOf(".")>=0) {
            return fileName.substring(fileName.lastIndexOf("."), fileName.length());
        }
        return "";
    }
}
