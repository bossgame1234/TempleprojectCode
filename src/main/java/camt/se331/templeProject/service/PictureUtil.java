package camt.se331.templeProject.service;

import camt.se331.templeProject.entity.Picture;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Calendar;

/**
 * Created by SONY on 4/5/2558.
 */
public class PictureUtil {
    static PictureUtil pictureUtil = null;
    public static PictureUtil getInstance(){
        if (pictureUtil == null){
            pictureUtil = new PictureUtil();
        }
        return pictureUtil;
    }

    //creating new picture object
    public static Picture getPicture(String resourcePath){
        Picture picture = new Picture();
        ClassLoader classLoader = pictureUtil.getInstance().getClass().getClassLoader();
        File file = new File(classLoader.getResource(resourcePath).getFile());
        try {
            picture.setPictureType(Files.probeContentType(file.toPath()));
            picture.setPictureName(file.getName());
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;){
                bos.write(buf,0,readNum);
            }
            picture.setPictureLocation(bos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picture;
    }
}
