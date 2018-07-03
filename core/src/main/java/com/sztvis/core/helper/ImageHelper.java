package com.sztvis.core.helper;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

/**
 * @author longweiqian
 * @company tvis
 * @date 2018/1/23 下午6:14
 */
public class ImageHelper {
    /**
     * 将Base64字符串转换为图片
     * @param imgStr base64字符串
     * @param path 图片地址
     * @return
     */
    public static boolean generateImage(String imgStr, String file, String path, HttpServletRequest request) throws FileNotFoundException {
        String filepath=request.getSession().getServletContext().getRealPath(file);
        File upload=new File(filepath);
        if (!upload.exists())
            upload.mkdirs();
        if(imgStr == null)
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try{
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i){
                if(b[i]<0)
                    b[i] += 256;
            }
//            File pathout=new File(upload.getAbsolutePath(),path);
            OutputStream out = new FileOutputStream(filepath+path);
            out.write(b);
            out.flush();
            out.close();
            return true;
        }catch (Exception ex){
            return false;
        }

    }
    public static String ImageToBase64(String imgFile,HttpServletRequest request) {
        String filepath=request.getSession().getServletContext().getRealPath(imgFile);
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
    public static String saveImage(MultipartFile multipartFile,String path) throws IOException {
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream)multipartFile.getInputStream();
        String fileName = UUID.randomUUID().toString().replaceAll("-","")+".png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path+File.separator+fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1){
            bos.write(bs,0,len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }

}
