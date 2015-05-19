package camt.se331.templeProject.controller;

import camt.se331.templeProject.entity.Gallery;
import camt.se331.templeProject.entity.History;
import camt.se331.templeProject.entity.News;
import camt.se331.templeProject.entity.Picture;
import camt.se331.templeProject.service.GalleryService;
import camt.se331.templeProject.service.HistoryService;
import camt.se331.templeProject.service.NewsService;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by SONY on 4/5/2558.
 */
@Controller
@RequestMapping(value = "/picture")
public class PictureController {
    @Autowired
    HistoryService historyService;
    @Autowired
    GalleryService galleryService;
    @Autowired
    NewsService newsService;

    @RequestMapping(value = "/addHistoryPicture",method = RequestMethod.POST)
    @ResponseBody
    public History addHistoryPicture(HttpServletRequest request,
                            HttpServletResponse response,@RequestParam("historyid")Long historyId){
        MultipartHttpServletRequest mRequest;
        History history = historyService.getHistory();
        try{
            mRequest = (MultipartHttpServletRequest)request;
            Iterator<String> itr= mRequest.getFileNames();
            while(itr.hasNext()){
                MultipartFile multipartFile = mRequest.getFile(itr.next());
                Picture picture = new Picture();
                picture.setPictureName(multipartFile.getName());
                picture.setPictureType(multipartFile.getContentType());

                byte[] pictureFile = multipartFile.getBytes();
                InputStream in = new ByteArrayInputStream(pictureFile);
                    BufferedImage bufferedImage = ImageIO.read(in);
                    bufferedImage = Scalr.resize(bufferedImage, Scalr.Method.QUALITY, Scalr.Mode.AUTOMATIC ,1024, 768);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ImageIO.write(bufferedImage, "jpg", bos);
                    picture.setPictureLocation(bos.toByteArray());
                historyService.addPicture(history, picture);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return history;
    }

    @RequestMapping(value = "/addGalleryPicture",method = RequestMethod.POST)
    @ResponseBody
    public Gallery addGalleryPicture(HttpServletRequest request,
                              HttpServletResponse response,@RequestParam("galleryid")Long galleryId){
        MultipartHttpServletRequest mRequest;
       Gallery gallery = galleryService.getGallery(galleryId);
        try{
            mRequest = (MultipartHttpServletRequest)request;
            Iterator<String> itr= mRequest.getFileNames();
            while(itr.hasNext()){
                MultipartFile multipartFile = mRequest.getFile(itr.next());
                Picture picture = new Picture();
                picture.setPictureName(multipartFile.getName());
                picture.setPictureType(multipartFile.getContentType());
                byte[] pictureFile = multipartFile.getBytes();
                InputStream in = new ByteArrayInputStream(pictureFile);
                BufferedImage bufferedImage = ImageIO.read(in);
                bufferedImage = Scalr.resize(bufferedImage, Scalr.Method.QUALITY, Scalr.Mode.AUTOMATIC ,1024, 768);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "jpg", bos);
                picture.setPictureLocation(bos.toByteArray());
                galleryService.addPicture(gallery,picture);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        return gallery;
    }

    @RequestMapping(value = "/addNewsPicture",method = RequestMethod.POST)
    @ResponseBody
    public News addNewsPicture(HttpServletRequest request,
                                     HttpServletResponse response,@RequestParam("newsid")Long newsId){
        MultipartHttpServletRequest mRequest;
        News news = newsService.getNewsById(newsId);
        try{
            mRequest = (MultipartHttpServletRequest)request;
            Iterator<String> itr= mRequest.getFileNames();
            while(itr.hasNext()){
                MultipartFile multipartFile = mRequest.getFile(itr.next());
                Picture picture = new Picture();
                picture.setPictureName(multipartFile.getName());
                picture.setPictureType(multipartFile.getContentType());
                byte[] pictureFile = multipartFile.getBytes();
                InputStream in = new ByteArrayInputStream(pictureFile);
                BufferedImage bufferedImage = ImageIO.read(in);
                bufferedImage = Scalr.resize(bufferedImage, Scalr.Method.QUALITY, Scalr.Mode.AUTOMATIC,1024, 768);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "jpg", bos);
                picture.setPictureLocation(bos.toByteArray());
                newsService.addPictureNews(news, picture);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }

}
