package com.sztvis.core.helper;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.FilenameFilter;

/**
 * @author longweiqian
 * @company tvis
 * @date 2017/12/27 下午6:49
 */
public class FileFilterByExtension extends FileFilter implements java.io.FileFilter,FilenameFilter {



    //扩展名字符串、过滤器描述、是否显示文件夹

    private String sExtensions;

    private String sDescription;

    private Boolean directoryInclude;



    //构造函数

    public FileFilterByExtension(){

        sExtensions   = "";

        sDescription = "";

        directoryInclude = true;

    }



    public FileFilterByExtension(String sDescription){

        sExtensions   = "";

        this.sDescription = sDescription;

        directoryInclude = true;

    }



    public FileFilterByExtension(String sDescription,String sExtensions){

        this.sExtensions = sExtensions;

        this.sDescription = sDescription;

        directoryInclude = true;

    }



    /*

     *设置文件夹是否可见

     * true为可见、false为不可见

     */

    public void setDirectoryInclude(boolean flag) {

        directoryInclude = flag;

    }



    public boolean isDirectoryInclude() {

        return directoryInclude;

    }


    /*

     * 重写接口javax.swing.filechooser.FileFilter的两个方法

     * @getDescription(),accept

     */



    public String getDescription(){

        return sDescription;

    }



    public boolean  accept(File file){

        if(file.isDirectory()){

            return directoryInclude;

        }



        if(sExtensions == "" || sExtensions == null){

            return false;

        }



        if(sExtensions.equals(".*") || sExtensions.equals("*")){

            return true;

        }



        String sFile_extension = null;

        String sFileName = file.getName();

        int i = sFileName.lastIndexOf(".");

        if(i>0 && i< sFileName.length()-1){
            sFile_extension = sFileName.substring(i+1);
        }
        String aExtension[] = sExtensions.split(",");
        Boolean bReturnValue = false;

        for(int j = 0;j < aExtension.length;j++){

            bReturnValue = bReturnValue||aExtension[j].equalsIgnoreCase(sFile_extension);

        }
        return bReturnValue;
    }

    public  boolean accept(File file,String s){

        return accept(new File(file, s));

    }

}
