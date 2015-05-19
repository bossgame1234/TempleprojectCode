package camt.se331.templeProject.service;

import camt.se331.templeProject.entity.Picture;
import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
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

        File file = new
                File(classLoader.getResource(resourcePath).getFile());


        try{
            picture.setPictureName(file.getName());
            picture.setPictureType(Files.probeContentType(file.toPath()));
            FileInputStream fis = new FileInputStream(file);
            BufferedImage bufferedImage= ImageIO.read(fis);
            bufferedImage= Scalr.resize(bufferedImage, Scalr.Method.QUALITY, Scalr.Mode.AUTOMATIC, 1024, 768);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage,"jpg",bos);
            picture.setPictureLocation(bos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return picture;
    }
}
